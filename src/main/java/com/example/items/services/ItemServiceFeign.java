package com.example.items.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.items.models.Item;
import com.example.items.services.interfaces.*;
import com.springboot.app.common.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary()
@Service("serviceFeign")
public class ItemServiceFeign implements IItemService {

  @Autowired
  private IProductRequest clientFeign;

  @Override
  public List<Item> getItems() {
    return clientFeign.getProducts().stream()
      .map( pro -> new Item(pro, 1))
      .collect(Collectors.toList());
  }

  @Override
  public Item findById(Long id, Integer quantity) {
    return new Item(clientFeign.findProductById(id),quantity);
  }
}
