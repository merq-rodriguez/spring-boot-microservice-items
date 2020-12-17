package com.example.items.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.items.models.Item;
import com.example.items.models.Product;
import com.example.items.services.interfaces.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("serviceRestTemplate")
public class ItemService implements IItemService{
  
  final String uri = "http://localhost:4000/products";

  @Autowired
  @Qualifier("ClientRest")
  private RestTemplate clientRest;

  @Override
  public List<Item> getItems() {
    Map<String, String> uriVariables = new HashMap<>();
    List<Product> products = Arrays.asList(clientRest.getForObject(uri, Product[].class, uriVariables));
    return products.stream()
      .map( pro -> new Item(pro, 1))
      .collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id, Integer quantity) {
    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("id", id.toString());
    Product product = clientRest.getForObject(uri+"/{id}", Product.class, uriVariables);
    System.out.println(product);
    return new Item(product, quantity);
  }
}
