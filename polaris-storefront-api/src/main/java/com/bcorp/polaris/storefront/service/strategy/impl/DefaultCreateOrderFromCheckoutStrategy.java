package com.bcorp.polaris.storefront.service.strategy.impl;

import com.bcorp.polaris.core.model.tables.records.*;
import com.bcorp.polaris.core.service.KeyGenerator;
import com.bcorp.polaris.storefront.bo.CheckoutBo;
import com.bcorp.polaris.storefront.constant.*;
import com.bcorp.polaris.storefront.dto.InvoiceDto;
import com.bcorp.polaris.storefront.service.strategy.CreateOrderFromCheckoutStrategy;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.bcorp.polaris.core.model.tables.Order.ORDER;
import static com.bcorp.polaris.core.model.tables.OrderInvoice.ORDER_INVOICE;
import static com.bcorp.polaris.core.model.tables.OrderLineItem.ORDER_LINE_ITEM;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;

@Component(value = "createOrderFromCheckoutStrategy")
public class DefaultCreateOrderFromCheckoutStrategy implements CreateOrderFromCheckoutStrategy
{
    private DSLContext dslContext;
    private KeyGenerator keyGenerator;

    @Autowired
    public DefaultCreateOrderFromCheckoutStrategy(
            DSLContext dslContext,
            @Qualifier(value = "uuidKeyGenerator") KeyGenerator keyGenerator
    )
    {
        this.dslContext = dslContext;
        this.keyGenerator = keyGenerator;
    }

    @Override
    @Transactional
    public OrderRecord createOrderFromCheckout(CheckoutBo checkoutBo)
    {
        final CartRecord cart = checkoutBo.getCart();
        final List<CartLineItemRecord> cartLineItems = checkoutBo.getCartLineItems();
        final PaymentType paymentType = checkoutBo.getPaymentType();

        validateParameterNotNullStandardMessage("cart", cart);
        validateParameterNotNullStandardMessage("cartLineItems", cartLineItems);
        validateParameterNotNullStandardMessage("paymentType", paymentType);

        final OrderRecord order = dslContext.newRecord(ORDER);
        String orderCode = generateOrderCode();


        order.setUserId(cart.getUserId());
        order.setCode(orderCode);
        order.setOrderStatus(OrderStatus.UNPAID.getCode());
        order.setSubtotal(cart.getSubtotal());
        order.setTotalDiscounts(cart.getTotalDiscounts());
        order.setTotalPrice(cart.getTotalPrice());
        order.setPaymentMode(paymentType.getCode());
        order.setPaymentStatus(PaymentStatus.UNPAID.getCode());
        order.store();

        createOrderLineItemsFromCartLineItems(order, cartLineItems);
        createOrderInvoiceFromInvoice(order, checkoutBo.getInvoiceDto());

        return order;
    }

    protected void createOrderLineItemsFromCartLineItems(OrderRecord order, List<CartLineItemRecord> cartLineItems)
    {
        List<OrderLineItemRecord> result = new ArrayList<>();

        for (final CartLineItemRecord cartLineItem : cartLineItems)
        {
            OrderLineItemRecord orderLineItem = dslContext.newRecord(ORDER_LINE_ITEM);
            orderLineItem.setOrderId(order.getId());
            orderLineItem.setBookId(cartLineItem.getBookId());
            orderLineItem.setName(cartLineItem.getName());
            orderLineItem.setPrice(cartLineItem.getPrice());
            orderLineItem.setSubtotal(cartLineItem.getSubtotal());
            orderLineItem.setTotalDiscounts(cartLineItem.getTotalDiscounts());
            orderLineItem.setTotalPrice(cartLineItem.getTotalPrice());
            orderLineItem.setItemStatus(OrderItemStatus.PENDING.getCode());
            result.add(orderLineItem);
        }

        dslContext.batchStore(result).execute();
    }

    protected void createOrderInvoiceFromInvoice(OrderRecord order, InvoiceDto invoiceDto)
    {
        if (invoiceDto == null)
        {
            return;
        }

        final OrderInvoiceRecord orderInvoice = dslContext.newRecord(ORDER_INVOICE);
        orderInvoice.setInvoiceType(invoiceDto.getInvoiceType().getCode().byteValue());
        orderInvoice.setInvoiceTitle(invoiceDto.getInvoiceTitle());
        orderInvoice.setBusinessNumber(invoiceDto.getBusinessNumber());
        orderInvoice.setContactEmail(invoiceDto.getEmail());
        orderInvoice.setLoveCode(invoiceDto.getLoveCode());
        orderInvoice.setOrderCode(order.getCode());
        orderInvoice.setInvoiceStatus(InvoiceStatus.PENDING.getCode().byteValue());
        orderInvoice.store();

        order.setInvoiceId(orderInvoice.getId());
        order.update();
    }

    protected String generateOrderCode()
    {
        final Object generatedValue = keyGenerator.generate();
        if (generatedValue instanceof String)
        {
            return (String) generatedValue;
        }
        else
        {
            return String.valueOf(generatedValue);
        }
    }
}
