package com.myproject.shop;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    @Value("${name}")
    private String name;

    public NameService (){
    }

    @PostConstruct
    private void sayMyName(){
        System.out.println(name);
    }
}
