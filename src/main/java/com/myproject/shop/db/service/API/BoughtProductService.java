package com.myproject.shop.db.service.API;

import com.myproject.shop.domain.BoughtProduct;

import java.util.List;

public interface BoughtProductService {
    void add(BoughtProduct boughtProduct);

    List<BoughtProduct> getAllByCustomerId(int customerId);
}
