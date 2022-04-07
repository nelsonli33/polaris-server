package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.core.dto.CartDto;
import com.bcorp.polaris.storefront.api.model.AddToCartRequest;
import com.bcorp.polaris.storefront.api.model.AddToCartResponse;
import com.bcorp.polaris.storefront.facade.CartFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CartController extends AbstractController
{
    private CartFacade cartFacade;

    @Autowired
    public CartController(CartFacade cartFacade)
    {
        this.cartFacade = cartFacade;
    }

    @PostMapping(value = "/api/v1/cart/add")
    public ResponseEntity<AddToCartResponse> addToCart(@Valid @RequestBody final AddToCartRequest body)
    {
        final CartDto cartDto = cartFacade.addToCart(body.getBookId());

        AddToCartResponse response = AddToCartResponse.builder()
                .cart(getStorefrontRestMapper().convert(cartDto))
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
