package com.fawry.ecommerce.model;

public class Milk implements Product, Expirable, Shippable {
String name;
     double price;
    int quantity;
     boolean expired;
    double weight;

     public Milk(String name, double price, int quantity, boolean expired, double weight) {
        this.name = name;
         this.price = price;
         this.quantity = quantity;
        this.expired = expired;
        this.weight = weight;
    }

     public String getName() {
         return name; 
        }
    public double getPrice() {
         return price;
         }
         public double getWeight() {
    return weight;
}
    public int getQuantity() { return quantity; }
    public boolean isExpired() { return false; }
    
    public boolean isShippable() { return false; }
      
    public void reduceStock(int q) {
    this.quantity -= q;}

   

}
