package com.example.items.services.interfaces;

import java.util.List;

import com.example.items.models.Item;

public interface IItemService {
  public List<Item> getItems();
  public Item findById(Long id, Integer quantity);
  
}
