package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.core.dto.CartDto;
import com.bcorp.polaris.storefront.api.model.*;
import com.bcorp.polaris.storefront.facade.CartFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/api/v1/cart")
    public ResponseEntity<GetCartResponse> getCartDetails()
    {
        final CartDto cartDto = cartFacade.getCartForCurrentUser();

        GetCartResponse response = GetCartResponse.builder()
                .cart(getStorefrontRestMapper().convert(cartDto))
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
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

    @PutMapping(value = "/api/v1/cart/remove")
    public ResponseEntity<RemoveLineItemResponse> removeCartLineItem(@Valid @RequestBody final RemoveLineItemRequest body)
    {
        final CartDto cartDto = cartFacade.removeLineItem(body.getBookId());

        RemoveLineItemResponse response = RemoveLineItemResponse.builder()
                .cart(getStorefrontRestMapper().convert(cartDto))
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PutMapping(value = "/api/v1/cart/clear")
    public ResponseEntity<ClearCartResponse> clearCart()
    {
        final CartDto cartDto = cartFacade.clearCart();

        ClearCartResponse response = ClearCartResponse.builder()
                .cart(getStorefrontRestMapper().convert(cartDto))
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
