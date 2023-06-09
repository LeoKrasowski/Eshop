package com.myproject.shop.db.service.API;

import com.myproject.shop.domain.Merchant;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MerchantService {

    List<Merchant> getMerchants();
    @Nullable
    Merchant get(int id);

    @Nullable
    Integer add(Merchant merchant); //returns generated id

}
