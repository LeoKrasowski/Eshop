package com.myproject.shop.db.service.API;

import com.myproject.shop.db.service.API.request.BuyProductRequest;
import com.myproject.shop.db.service.API.response.BuyProductResponse;

public interface ShoppingService {
    BuyProductResponse buyProduct(BuyProductRequest request);
}
