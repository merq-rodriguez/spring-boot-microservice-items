package com.example.items.controllers;

import java.util.List;

import com.example.items.models.Item;
import com.example.items.models.Product;
import com.example.items.services.interfaces.IItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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

  @HystrixCommand(fallbackMethod = "methodAlternative")
  @GetMapping("/{id}/quantity/{quantity}")
  public Item findItemById(
    @PathVariable Long id,
    @PathVariable Integer quantity
  ) {
    return itemService.findById(id, quantity);
  }

  /**
   * 
   * @param id
   * @param quantity
   * @return
   * En caso de que suceda un error proveemos de un metodo alternativo para controllar el error manifestado
   * existen diferentes formas de abordar estos casos como consultar a la memoria cache y retornar esos datos
   * o incluso poner la peticion en la cola, la cual sera respondida cuando llegue su momento.
   */
  public Item methodAlternative( Long id, Integer quantity){
    Item item = new Item();
    Product pro = new Product();
    pro.setId(id);
    pro.setName("Arduino Nano");
    pro.setPrice(50000L);
    item.setProduct(pro);
    item.setQuantity(quantity);
    return item;
  }

}
