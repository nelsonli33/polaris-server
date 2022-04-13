package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.core.dto.OrderDto;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.payload.ServerResponse;
import com.bcorp.polaris.core.util.EnumUtil;
import com.bcorp.polaris.storefront.api.model.*;
import com.bcorp.polaris.storefront.constant.InvoiceType;
import com.bcorp.polaris.storefront.constant.PaymentType;
import com.bcorp.polaris.storefront.dto.CheckoutDto;
import com.bcorp.polaris.storefront.dto.InvoiceDto;
import com.bcorp.polaris.storefront.dto.PaymentDto;
import com.bcorp.polaris.storefront.dto.PlaceOrderDto;
import com.bcorp.polaris.storefront.facade.CartFacade;
import com.bcorp.polaris.storefront.facade.CheckoutFacade;
import com.bcorp.polaris.storefront.facade.PaymentFacade;
import com.bcorp.polaris.storefront.util.ReqMsgValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class CheckoutController extends AbstractController
{
    private CheckoutFacade checkoutFacade;
    private CartFacade cartFacade;
    private PaymentFacade paymentFacade;

    @Autowired
    public CheckoutController(CheckoutFacade checkoutFacade, CartFacade cartFacade, PaymentFacade paymentFacade)
    {
        this.checkoutFacade = checkoutFacade;
        this.cartFacade = cartFacade;
        this.paymentFacade = paymentFacade;
    }


    @GetMapping(value = "/api/v1/checkout")
    public ResponseEntity<GetCheckoutResponse> doCheckout()
    {
        final ServerResponse serverResponse = beforeCheckout();
        if (serverResponse != null)
        {
            final GetCheckoutResponse resp = GetCheckoutResponse
                    .builder()
                    .error(serverResponse)
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        }


        final CheckoutDto checkoutDto = checkoutFacade.getCheckout();

        final Checkout checkout = getStorefrontRestMapper().convert(checkoutDto);

        GetCheckoutResponse resp = GetCheckoutResponse
                .builder()
                .checkout(checkout)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @PostMapping(value = "/api/v1/checkout/place-order")
    public ResponseEntity<PlaceOrderResponse> placeOrder(@Valid @RequestBody PlaceOrderRequest body)
    {
        // 1. validate checkout data
        validatePlaceOrderRequest(body);
        final ServerResponse serverResponse = beforeCheckout();
        if (serverResponse != null)
        {
            // TODO: return serverResponse
        }

        // 2. prepare placeOrderDto
        final PaymentType paymentType = EnumUtil.getByCode(body.getPaymentMethodCode(), PaymentType.class);
        PlaceOrderDto placeOrderDto = new PlaceOrderDto();
        placeOrderDto.setPaymentType(paymentType);
        if (body.getCheckoutInvoice() != null)
        {
            placeOrderDto.setInvoiceDto(createInvoiceDto(body.getCheckoutInvoice()));
        }

        // 3. place order
        final OrderDto orderDto = checkoutFacade.placeOrder(placeOrderDto);

        // 4. order pay
        final PaymentDto paymentDto = paymentFacade.startEcpayPayment(orderDto.getCode());

        PlaceOrderResponse response = PlaceOrderResponse.builder()
                .orderCode(orderDto.getCode())
                .checkoutForm(paymentDto.getCheckoutForm())
                .build();
        
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    protected void validatePlaceOrderRequest(PlaceOrderRequest body)
    {
        if (body.getCheckoutInvoice() != null)
        {
            final CheckoutInvoice checkoutInvoice = body.getCheckoutInvoice();
            ReqMsgValidator.Checkout.validateCheckoutInvoice(checkoutInvoice);
        }
    }

    protected ServerResponse beforeCheckout()
    {
        if (!checkoutFacade.hasValidCart())
        {
            log.info("Missing, empty cart");
            return ServerResponse.builder()
                    .code(InternalErrorCode.EMPTY_CART_ERROR.getCode())
                    .message("訂單中無商品資訊，請回到購物車頁面，重新再試。")
                    .build();
        }

        if (!cartFacade.validateCartIsValid())
        {
            log.info("Cart line items has changed");
            return ServerResponse.builder()
                    .code(InternalErrorCode.CART_ITEMS_CHANGED.getCode())
                    .message("訂單中部分商品資訊已更改，請回到購物車頁面，重新再試。")
                    .build();
        }
        return null;
    }

    protected InvoiceDto createInvoiceDto(CheckoutInvoice checkoutInvoice)
    {
        final InvoiceType invoiceType = EnumUtil.getByCode(checkoutInvoice.getInvoiceType(), InvoiceType.class);

        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceType(invoiceType);
        invoiceDto.setEmail(checkoutInvoice.getEmail());
        invoiceDto.setInvoiceTitle(checkoutInvoice.getInvoiceTitle());
        invoiceDto.setBusinessNumber(checkoutInvoice.getBusinessNumber());
        invoiceDto.setLoveCode(checkoutInvoice.getLoveCode());
        return invoiceDto;

    }
}
