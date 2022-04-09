package com.bcorp.polaris.storefront.dto.error;

import java.util.List;

public class CartError
{
    private List<CartLineItemError> problematicItems;

    public List<CartLineItemError> getProblematicItems()
    {
        return problematicItems;
    }

    public void setProblematicItems(List<CartLineItemError> problematicItems)
    {
        this.problematicItems = problematicItems;
    }
}
