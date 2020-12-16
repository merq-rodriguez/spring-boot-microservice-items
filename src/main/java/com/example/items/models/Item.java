package com.example.items.models;

public class Item {
  private Product product;
  private Integer quantity;

  public Item(){}

  public Item(Product pro, Integer quantity){
    this.product = pro;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }
  
  public Integer getQuantity() {
    return quantity;
  }

  public Long getTotalValue(){
      return this.product.getPrice() * this.getQuantity();
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}
