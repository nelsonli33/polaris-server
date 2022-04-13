package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalInvoice
{
    private Integer invoiceType;
    private String email;

    @JsonCreator
    public PersonalInvoice(
            @JsonProperty("invoice_type") Integer invoiceType,
            @JsonProperty("contact_email") String email
    )
    {
        this.invoiceType = invoiceType;
        this.email = email;
    }
}
