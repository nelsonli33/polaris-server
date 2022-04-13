package com.bcorp.polaris.storefront.bo;

import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.storefront.constant.PaymentType;
import com.bcorp.polaris.storefront.dto.InvoiceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutBo
{
    private CartRecord cart;
    private List<CartLineItemRecord> cartLineItems;
    private PaymentType paymentType;
    private InvoiceDto invoiceDto;
}
