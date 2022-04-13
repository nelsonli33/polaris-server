package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyInvoice
{
    private Integer invoiceType;
    private String email;
    private String invoiceTitle;
    private String businessNumber;

    @JsonCreator
    public CompanyInvoice(
            @JsonProperty("invoice_type") Integer invoiceType,
            @JsonProperty("contact_email") String email,
            @JsonProperty("invoice_title") String invoiceTitle,
            @JsonProperty("business_number") String businessNumber
    )
    {
        this.invoiceType = invoiceType;
        this.email = email;
        this.invoiceTitle = invoiceTitle;
        this.businessNumber = businessNumber;
    }
}
