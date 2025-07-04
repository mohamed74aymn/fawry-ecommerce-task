package com.fawry.ecommerce.model;

public class Biscuit implements Product, Expirable, Shippable {
    int quantity;
     String name;
     double price;
     boolean expired;
     double weight;

    public Biscuit(String name, double price, int quantity, boolean expired, double weight) {
        this.name = name;
        this.price = price;
         this.quantity = quantity;
        this.expired = expired;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
 
    public boolean isExpired() { return expired; }
      public boolean isShippable() { return true; }
      public double getWeight() { return weight; }
      public void reduceStock(int q) {
    this.quantity -= q;
}
    
}
