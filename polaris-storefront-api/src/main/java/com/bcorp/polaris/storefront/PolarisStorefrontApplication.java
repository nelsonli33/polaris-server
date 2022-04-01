package com.bcorp.polaris.storefront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bcorp.polaris.core", "com.bcorp.polaris.security", "com.bcorp.polaris.author"})
public class PolarisStorefrontApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(PolarisStorefrontApplication.class, args);
    }

}
