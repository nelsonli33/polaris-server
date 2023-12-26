package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.storefront.controller.mapper.StorefrontRestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;


public abstract class AbstractController
{
    private StorefrontRestMapper storefrontRestMapper;

    public StorefrontRestMapper getStorefrontRestMapper()
    {
        return storefrontRestMapper;
    }

    @Autowired
    public void setStorefrontRestMapper(StorefrontRestMapper storefrontRestMapper)
    {
        this.storefrontRestMapper = storefrontRestMapper;
    }
}
