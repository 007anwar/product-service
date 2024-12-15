package com.example.product_service.api;


import com.example.product_service.entity.Product;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getProductById(@PathVariable Long id)
    {
        System.out.println("getting product with id "+id);
        return new ResponseEntity<>(productService.getProductByid(id),HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteProductById(@PathVariable Long id)
    {
        productService.deleteProductByid(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
