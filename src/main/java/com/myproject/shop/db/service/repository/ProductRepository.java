package com.myproject.shop.db.service.repository;

import com.myproject.shop.db.service.mapper.ProductRowMapper;
import com.myproject.shop.domain.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProductRowMapper productRowMapper = new ProductRowMapper();

    public ProductRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product get(int id){
        final String sql = "select * from product where product.id = " + id;
            try {
                return jdbcTemplate.queryForObject(sql, productRowMapper);
            } catch (EmptyResultDataAccessException e) {
                return null;
            }
    }
}
