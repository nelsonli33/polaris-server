package com.bcorp.polaris.storefront.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveInvoiceSettingRequest
{
    private String email;
    private String invoiceTitle; // 發票抬頭
    private String businessNumber; // 統一編號
    private String loveCode;

    @JsonCreator
    public SaveInvoiceSettingRequest(
            @JsonProperty("email") String email,
            @JsonProperty("invoice_title") String invoiceTitle,
            @JsonProperty("business_number") String businessNumber,
            @JsonProperty("love_code") String loveCode
    )
    {
        this.email = email;
        this.invoiceTitle = invoiceTitle;
        this.businessNumber = businessNumber;
        this.loveCode = loveCode;
    }
}
