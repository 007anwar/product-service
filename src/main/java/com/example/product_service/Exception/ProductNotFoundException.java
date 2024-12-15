package com.example.product_service.Exception;


public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id) {
        super("product not found with id: "+id);
    }
}
