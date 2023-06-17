package com.myproject.shop.db.service.impl;

import com.myproject.shop.db.service.API.BoughtProductService;
import com.myproject.shop.db.service.repository.BoughtProductRepository;
import com.myproject.shop.domain.BoughtProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoughtProductServiceImpl implements BoughtProductService {

    private final BoughtProductRepository boughtProductRepository;

    public BoughtProductServiceImpl(BoughtProductRepository boughtProductRepository) {
        this.boughtProductRepository = boughtProductRepository;
    }

    @Override
    public void add(BoughtProduct boughtProduct) {
        boughtProductRepository.add(boughtProduct);
    }

    @Override
    public List<BoughtProduct> getAllByCustomerId(int customerId) {
        return boughtProductRepository.getAllByCustomerId(customerId);
    }
}
