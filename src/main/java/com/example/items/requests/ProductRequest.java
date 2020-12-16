package com.example.items.requests;

import java.util.List;
import java.util.stream.Collectors;

import com.example.items.models.Item;
import com.example.items.requests.interfaces.IProductRequest;
import com.example.items.services.interfaces.IItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("ProductRequest")
public class ProductRequest implements IItemService {

  @Autowired
  private IProductRequest clientRest;

  @Override
  public List<Item> getItems() {
    return clientRest.getProducts().stream()
      .map( pro -> new Item(pro, 1))
      .collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id, Integer quantity) {
    return new Item(clientRest.findProductById(id),quantity);
  }
}
