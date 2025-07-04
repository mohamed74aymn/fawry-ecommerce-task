package com.fawry.ecommerce.service;
// package com.fawry.ecommerce;

import com.fawry.ecommerce.model.*;

import java.util.*;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double subtotal = 0;
        double shipping = 0;
        List<Shippable> shippin = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product.isExpired()) {
                System.out.println(product.getName() + " is expired.");
                return;
            }

            subtotal += product.getPrice() * quantity;

            if (product.isShippable() && product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    shippin.add((Shippable) product);
                    shipping += 10;
                }
            }
        }

        double total = subtotal + shipping;

        if (!customer.pay(total)) {
            System.out.println("Insufficient balance.");
            return;
        }

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int q = entry.getValue();

            if (product instanceof Cheese) {
                ((Cheese) product).reduceStock(q);
            }
             else if (product instanceof Biscuit) {
                ((Biscuit) product).reduceStock(q);
            }
             else if (product instanceof TV) {
                ((TV) product).reduceStock(q);
            }
             else if (product instanceof ScratchCard) {
                ((ScratchCard) product).reduceStock(q);
            }
        }

        if (!shippin.isEmpty()) {
            ShippingService.ship(shippin);
        }

        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey().getName() + "        " + (entry.getKey().getPrice() * entry.getValue()));
        }

        System.out.println("---------------------");
        System.out.println("Subtotal           " +  subtotal);
        System.out.println("Shipping           " +  shipping);
        System.out.println("Amount             " +  total);
        System.out.println("Remaining balance: " +  customer.getBalance());
    }
}
