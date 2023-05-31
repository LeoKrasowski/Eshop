package com.myproject.shop.db.service.impl;

import com.myproject.shop.db.service.API.MerchantService;
import com.myproject.shop.db.service.repository.MerchantRepository;
import com.myproject.shop.domain.Merchant;

import java.util.List;

public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository merchantRepository;

    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public List<Merchant> getMerchants() {
        return merchantRepository.getAll();
    }

    @Override
    public Merchant get(int id) {
        return merchantRepository.get(id);
    }

    @Override
    public Integer add(Merchant merchant) {
        return merchantRepository.add(merchant);
    }
}
