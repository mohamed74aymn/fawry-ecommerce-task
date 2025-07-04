package com.fawry.ecommerce;
// import com.fawry.ecommerce.model.*;
// import com.fawry.ecommerce.service.*;

import com.fawry.ecommerce.model.Cheese;
import com.fawry.ecommerce.model.Biscuit;
import com.fawry.ecommerce.model.ScratchCard;
import com.fawry.ecommerce.model.TV;
import com.fawry.ecommerce.model.Milk;
import com.fawry.ecommerce.model.Product;
import com.fawry.ecommerce.model.Customer;

import com.fawry.ecommerce.service.Cart;
import com.fawry.ecommerce.service.CheckoutService;


public class App {
    public static void main(String[] args) {
        Product cheese = new Cheese("Cheese", 50, 5, false, 250);
        Product Milk = new Milk("Milk", 120, 20, false, 1000);
        Product biscuit = new Biscuit("Biscuit", 80, 2, true, 500);
        Product scratchCard = new ScratchCard("ScratchCard", 50, 10);
        Product tv = new TV("TV", 1000, 3, 8000);

       
        Customer customer1 = new Customer("mohamed Ayman", 5000);
        Cart cart1 = new Cart();
        cart1.add(cheese, 2);
        cart1.add(biscuit, 1);
        cart1.add(Milk, 1);
         cart1.add(scratchCard, 2);
        cart1.add(tv, 3);
        // System.out.println("=== Checkout for Ali ===");
        System.out.println("=== Checkout for " + customer1.getName() + " ===");
        CheckoutService.checkout(customer1, cart1);

        
        // Customer customer2 = new Customer("Sara", 3000);
        // Cart cart2 = new Cart();
        // cart2.add(cheese, 3);
        // cart2.add(scratchCard, 2);
        // cart2.add(tv, 1);
        // System.out.println("\n=== Checkout for Ali ===");
        // CheckoutService.checkout(customer2, cart2);
    }
}
