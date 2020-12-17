package com.example.items.controllers;

import java.util.List;

import com.example.items.models.Item;
import com.example.items.services.interfaces.IItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
  
  @Autowired()
  @Qualifier("serviceFeign")
  private IItemService itemService;

  @GetMapping()
  public List<Item> getItems(){
    return itemService.getItems();
  }

  @GetMapping("/{id}/quantity/{quantity}")
  public Item findItemById(
    @PathVariable Long id,
    @PathVariable Integer quantity
  ){
    return itemService.findById(id, quantity);
  }
}
