package com.fawry.ecommerce.model;

public class TV implements Product, Shippable {
    private String name;
    private double price;
    private int quantity;
    private double weight;

    public TV(String name, double price, int quantity, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isExpired() { return false; }
    public boolean isShippable() { return true; }
    public double getWeight() { return weight; }
       public void reduceStock(int q) {
    this.quantity -= q;}
}