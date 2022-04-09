package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.payload.ServerResponse;
import com.bcorp.polaris.storefront.api.model.GetCheckoutResponse;
import com.bcorp.polaris.storefront.facade.CartFacade;
import com.bcorp.polaris.storefront.facade.CheckoutFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CheckoutController extends AbstractController
{
    private CheckoutFacade checkoutFacade;
    private CartFacade cartFacade;

    @Autowired
    public CheckoutController(CheckoutFacade checkoutFacade, CartFacade cartFacade)
    {
        this.checkoutFacade = checkoutFacade;
        this.cartFacade = cartFacade;
    }


    @GetMapping(value = "/api/v1/checkout")
    public ResponseEntity<GetCheckoutResponse> doCheckout()
    {
        if (!checkoutFacade.hasValidCart())
        {
            log.info("Missing, empty cart");
            final GetCheckoutResponse resp = GetCheckoutResponse
                    .builder()
                    .error(ServerResponse.builder()
                            .code(InternalErrorCode.EMPTY_CART_ERROR.getCode())
                            .message("訂單中無商品資訊，請回到購物車頁面，重新再試。")
                            .build())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        }


//        cartFacade.validateCart();
//
//        final CheckoutDTO checkoutData = checkoutFacade.getCheckout();
//
//        final Checkout checkout = checkoutRestMapper.toCheckout(checkoutData);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
