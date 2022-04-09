package com.bcorp.polaris.storefront.dto.cart;

import com.bcorp.polaris.storefront.bo.BookBo;
import com.bcorp.polaris.storefront.bo.CartBo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommerceCartParameter
{
    private CartBo cartBo;
    private BookBo bookBo;
}
