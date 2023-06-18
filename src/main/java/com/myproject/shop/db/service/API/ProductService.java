package com.myproject.shop.db.service.API;

import com.myproject.shop.db.service.API.request.UpdateProductRequest;
import com.myproject.shop.domain.Product;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ProductService {
    List <Product> getProducts ();

    @Nullable
    Product get(int id);

    @Nullable
    Integer add(Product product); // return generated id

    void delete(int id);

    void update(int id, UpdateProductRequest request);

    void updateAvailableInternal(int id, int newAvailable);

}
