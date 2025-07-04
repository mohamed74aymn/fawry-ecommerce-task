package com.fawry.ecommerce.service;
import com.fawry.ecommerce.model.Product;

import java.util.LinkedHashMap;

import java.util.Map;
public class Cart {

 public Map<Product, Integer> getItems() {
        return items;
    }

  

    private Map <Product, Integer> items = new LinkedHashMap<>();

    public void add(Product product, int quantity) {
    if (quantity <= 0) {
        System.out.println("❌ there no quantity for  " + product.getName());
        return;
    }

    if (product.isExpired()) {
        System.out.println("❌ Cannot add expired product  " + product.getName());
        return;
    }

    if (quantity > product.getQuantity()) {
        System.out.println("❌ Not enough stock for: " + product.getName());
        return;
    }

    int existing = items.getOrDefault(product, 0);
    items.put(product, existing + quantity);
}
  public boolean isEmpty() {
        return items.isEmpty();
    }

}