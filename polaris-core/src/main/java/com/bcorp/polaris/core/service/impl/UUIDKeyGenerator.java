package com.bcorp.polaris.core.service.impl;

import com.bcorp.polaris.core.service.KeyGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service(value = "uuidKeyGenerator")
public class UUIDKeyGenerator implements KeyGenerator
{
    @Override
    public Object generate()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
