package com.myproject.shop.controller;

import com.myproject.shop.db.service.API.ShoppingService;
import com.myproject.shop.db.service.API.request.BuyProductRequest;
import com.myproject.shop.db.service.API.response.BuyProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shop")
public class ShoppingController {

    private final ShoppingService shoppingService;

    public ShoppingController(ShoppingService shoppingService) {
        this.shoppingService = shoppingService;
    }

    @PostMapping("/buy")
    public ResponseEntity buy(@RequestBody BuyProductRequest request){
        BuyProductResponse buyProductResponse = shoppingService.buyProduct(request);
        if (buyProductResponse.isSuccess()){
            return ResponseEntity.ok().build();
        }else {
            return new ResponseEntity<>(buyProductResponse.getErrorMessage(), HttpStatus.PRECONDITION_FAILED);
        }

    }
}
