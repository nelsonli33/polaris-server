package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.util.EnumUtil;
import com.bcorp.polaris.storefront.api.model.GetInvoiceSettingResponse;
import com.bcorp.polaris.storefront.api.model.SaveInvoiceSettingRequest;
import com.bcorp.polaris.storefront.api.model.SaveInvoiceSettingResponse;
import com.bcorp.polaris.storefront.constant.InvoiceType;
import com.bcorp.polaris.storefront.dto.CompanyInvoiceDto;
import com.bcorp.polaris.storefront.dto.DonationInvoiceDto;
import com.bcorp.polaris.storefront.dto.InvoiceSettingDto;
import com.bcorp.polaris.storefront.dto.PersonalInvoiceDto;
import com.bcorp.polaris.storefront.facade.CustomerFacade;
import com.bcorp.polaris.storefront.util.ReqMsgValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerAccountController extends AbstractController
{
    private CustomerFacade customerFacade;

    @Autowired
    public CustomerAccountController(CustomerFacade customerFacade)
    {
        this.customerFacade = customerFacade;
    }

    @GetMapping(path = "/api/v1/customer/account/invoice-setting")
    public ResponseEntity<GetInvoiceSettingResponse> getUserInvoiceSetting()
    {
        final InvoiceSettingDto invoiceSettingDto = customerFacade.getCustomerInvoiceSetting();

        final GetInvoiceSettingResponse response = GetInvoiceSettingResponse.builder()
                .personal(getStorefrontRestMapper().convert(invoiceSettingDto.getPersonal()))
                .company(getStorefrontRestMapper().convert(invoiceSettingDto.getCompany()))
                .donation(getStorefrontRestMapper().convert(invoiceSettingDto.getDonation()))
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping(path = "/api/v1/customer/account/invoice-setting")
    public ResponseEntity<SaveInvoiceSettingResponse> postInvoiceSetting(
            @RequestParam(value = "type") Integer type,
            @RequestBody SaveInvoiceSettingRequest body
    )
    {
        SaveInvoiceSettingResponse response = null;
        final InvoiceType invoiceType = EnumUtil.getByCode(type, InvoiceType.class);
        if (invoiceType == null)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.ENUM_CODE_NOT_FOUND, "InvoiceType: " + type + " for invoice setting");
        }

        switch (invoiceType)
        {
            case PERSON:
                ReqMsgValidator.CustomerAccount.validatePersonalInvoiceSetting(body);
                PersonalInvoiceDto personalInvoiceDto = new PersonalInvoiceDto();
                personalInvoiceDto.setEmail(body.getEmail());
                response = SaveInvoiceSettingResponse.builder()
                        .personal(getStorefrontRestMapper().convert(customerFacade.savePersonalInvoiceSetting(personalInvoiceDto)))
                        .build();
                break;
            case COMPANY:
                ReqMsgValidator.CustomerAccount.validateCompanyInvoiceSetting(body);
                CompanyInvoiceDto companyInvoiceDto = new CompanyInvoiceDto();
                companyInvoiceDto.setEmail(body.getEmail());
                companyInvoiceDto.setInvoiceTitle(body.getInvoiceTitle());
                companyInvoiceDto.setBusinessNumber(body.getBusinessNumber());

                response = SaveInvoiceSettingResponse.builder()
                        .company(getStorefrontRestMapper().convert(customerFacade.saveCompanyInvoiceSetting(companyInvoiceDto)))
                        .build();
                break;
            case DONATION:
                ReqMsgValidator.CustomerAccount.validateDonationInvoiceSetting(body);
                DonationInvoiceDto donationInvoiceDto = new DonationInvoiceDto();
                donationInvoiceDto.setCharityLovecode(body.getLoveCode());

                response = SaveInvoiceSettingResponse.builder()
                        .donation(getStorefrontRestMapper().convert(customerFacade.saveDonationInvoiceSetting(donationInvoiceDto)))
                        .build();
                break;
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
