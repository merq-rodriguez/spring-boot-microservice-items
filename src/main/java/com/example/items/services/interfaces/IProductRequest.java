package com.example.items.services.interfaces;

import java.util.List;
import com.example.items.models.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service"/* , url = "localhost:4000/products" */)
public interface IProductRequest{
  @GetMapping("/products")
  public List<Product> getProducts();
  
  @GetMapping("/products/{id}")
  public Product findProductById(@PathVariable Long id);
}
