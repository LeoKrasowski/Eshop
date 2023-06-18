package com.myproject.shop.db.service.impl;

import com.myproject.shop.db.service.API.*;
import com.myproject.shop.db.service.API.request.BuyProductRequest;
import com.myproject.shop.db.service.API.response.BuyProductResponse;
import com.myproject.shop.domain.BoughtProduct;
import com.myproject.shop.domain.Customer;
import com.myproject.shop.domain.Product;
import org.springframework.stereotype.Service;


@Service
public class ShoppingServiceImpl implements ShoppingService {

    private final ProductService productService;
    private final CustomerService customerService;
    private final CustomerAccountService customerAccountService;

    private final BoughtProductService boughtProductService;

    public ShoppingServiceImpl(ProductService productService, CustomerService customerService, CustomerAccountService customerAccountService, BoughtProductService boughtProductService) {
        this.productService = productService;
        this.customerService = customerService;
        this.customerAccountService = customerAccountService;
        this.boughtProductService = boughtProductService;
    }

    @Override
    public BuyProductResponse buyProduct(BuyProductRequest request) {
            int productId = request.getProductId();
            int customerId = request.getCustomerId();


        Product product = productService.get(productId);
        if (product == null) {
            return new BuyProductResponse(false, "Product with id: " + productId +
                    " doesn't exist");
        }

        Customer customer = customerService.get(customerId);
        if (customer == null) {
            return new BuyProductResponse(false, "Customer with id: " + customerId +
                    "doesn't exist");
        }

        if (product.getAvailable() < request.getQuantity()){
            return new BuyProductResponse(false, "Doesn't have enough available products");
        }

        Double customerMoney = customerAccountService.getMoney(customerId);
        if (customerMoney == null) {
            return new BuyProductResponse(false, "Customer with id: " + customerId +
                    "doesn't have account");
        } else {
            double totalPriceOfRequest = product.getPrice() * request.getQuantity();
            if (customerMoney >= totalPriceOfRequest) {
                customerAccountService.setMoney(customerId, customerMoney - totalPriceOfRequest);
                productService.updateAvailableInternal(productId, product.getAvailable() - request.getQuantity());
                boughtProductService.add(new BoughtProduct(productId, customerId, request.getQuantity()));
                return new BuyProductResponse(true);
            }else{
                return new BuyProductResponse(false, "Customer id: " + customerId + " Money not enough");
            }
        }

    }
}
