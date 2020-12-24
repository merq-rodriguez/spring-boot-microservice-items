package com.example.items.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.items.models.Item;
import com.springboot.app.common.models.Product;

import com.example.items.services.interfaces.IItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ItemController {
  
private static Logger log = LoggerFactory.getLogger(ItemController.class);

  @Autowired
  private Environment environment;
  
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


  @GetMapping("/config")
  public ResponseEntity<?>  getConfig(){
    String env = (String) this.environment.getProperty("environment");
    String port = (String) this.environment.getProperty("server.port");
    Map<String, String> config = new HashMap<>();
    config.put("Environment", env);
    config.put("Port", port);
    return new ResponseEntity<Map<String, String>>(config, HttpStatus.OK);
  }
}
