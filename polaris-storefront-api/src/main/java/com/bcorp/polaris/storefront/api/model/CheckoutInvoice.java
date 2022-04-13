package com.bcorp.polaris.storefront.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckoutInvoice
{
    private Integer invoiceType;
    private String email;
    private String invoiceTitle;
    private String businessNumber;
    private String loveCode;

    @JsonCreator
    public CheckoutInvoice(
            @JsonProperty("invoice_type") Integer invoiceType,
            @JsonProperty("email") String email,
            @JsonProperty("invoice_title") String invoiceTitle,
            @JsonProperty("business_number") String businessNumber,
            @JsonProperty("love_code") String loveCode
    )
    {
        this.invoiceType = invoiceType;
        this.email = email;
        this.invoiceTitle = invoiceTitle;
        this.businessNumber = businessNumber;
        this.loveCode = loveCode;
    }
}
