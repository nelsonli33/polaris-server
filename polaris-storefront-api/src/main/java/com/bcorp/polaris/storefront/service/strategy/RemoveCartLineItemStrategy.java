package com.bcorp.polaris.storefront.service.strategy;

import com.bcorp.polaris.storefront.dto.CommerceCartParameter;

public interface RemoveCartLineItemStrategy
{
    void removeLineItem(CommerceCartParameter commerceCartParameter);

    void removeAllLineItems(CommerceCartParameter commerceCartParameter);
}
