package com.fawry.ecommerce.model;

public interface Product {
    double getPrice();
    String getName();
    boolean isExpired();
    boolean isShippable();
    int getQuantity();
}