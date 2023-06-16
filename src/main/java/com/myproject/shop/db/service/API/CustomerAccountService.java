package com.myproject.shop.db.service.API;

import com.myproject.shop.domain.CustomerAccount;
import org.springframework.lang.Nullable;

public interface CustomerAccountService {

    void addCustomerAccount(CustomerAccount customerAccount);

    @Nullable
    Double getMoney(int customerId);

    void setMoney(int customerId, double money);
}
