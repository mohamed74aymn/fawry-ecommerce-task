package com.fawry.ecommerce.model;

public class ScratchCard implements Product {
    private String name;
    private double price;
    private int quantity;

    public ScratchCard(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
         return name; 
        }
    public double getPrice() {
         return price;
         }
    public int getQuantity() { return quantity; }
    public boolean isExpired() { return false; }
    
    public boolean isShippable() { return false; }
      
    public void reduceStock(int q) {
    this.quantity -= q;}
}