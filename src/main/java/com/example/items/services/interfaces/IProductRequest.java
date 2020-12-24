package com.example.items.services.interfaces;

import java.util.List;
import com.springboot.app.common.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="product-service"/* , url = "localhost:4000/products" */)
public interface IProductRequest{
  @GetMapping()
  public List<Product> getProducts();
  
  @GetMapping("/{id}")
  public Product findProductById(@PathVariable Long id);
  
  @PostMapping()
  public Product createProduct(@RequestBody Product product);
  
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable Long id, @RequestBody Product product);
  
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Long id);
}
