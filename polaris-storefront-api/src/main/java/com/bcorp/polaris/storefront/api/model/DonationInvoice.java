package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DonationInvoice
{
    private Integer invoiceType;
    private String loveCode;

    @JsonCreator
    public DonationInvoice(
            @JsonProperty("invoice_type") Integer invoiceType,
            @JsonProperty("love_code") String loveCode
    )
    {
        this.invoiceType = invoiceType;
        this.loveCode = loveCode;
    }
}
