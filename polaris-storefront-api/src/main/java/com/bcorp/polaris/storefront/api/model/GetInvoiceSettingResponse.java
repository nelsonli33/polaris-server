package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetInvoiceSettingResponse
{
    private PersonalInvoice personal;
    private CompanyInvoice company;
    private DonationInvoice donation;

    @JsonCreator
    public GetInvoiceSettingResponse(
            @JsonProperty("personal") PersonalInvoice personal,
            @JsonProperty("company") CompanyInvoice company,
            @JsonProperty("donation") DonationInvoice donation
    )
    {
        this.personal = personal;
        this.company = company;
        this.donation = donation;
    }
}
