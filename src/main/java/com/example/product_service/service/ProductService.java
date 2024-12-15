package com.example.product_service.service;

import com.example.product_service.Exception.ProductNotFoundException;
import com.example.product_service.entity.Product;
import com.example.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductByid(Long id){
        return productRepository.
                findById(id).
                orElseThrow(() -> new ProductNotFoundException(id));
    }

    public void deleteProductByid(Long id){
         productRepository.deleteById(id);
    }
}
