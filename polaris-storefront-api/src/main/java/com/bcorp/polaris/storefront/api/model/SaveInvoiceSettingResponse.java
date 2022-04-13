package com.bcorp.polaris.storefront.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaveInvoiceSettingResponse
{
    private PersonalInvoice personal;
    private CompanyInvoice company;
    private DonationInvoice donation;

    @JsonCreator
    public SaveInvoiceSettingResponse(
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
