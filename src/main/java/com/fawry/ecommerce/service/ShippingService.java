package com.fawry.ecommerce.service;
// package com.fawry.ecommerce;

import com.fawry.ecommerce.model.Shippable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("* Shipment notice *");
        Map<String, Double> grouped = new LinkedHashMap<>();
        Map<String, Integer> counts = new LinkedHashMap<>();

        double totalWeight = 0;

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();

            grouped.put(name, grouped.getOrDefault(name, 0.0) + weight);
            counts.put(name, counts.getOrDefault(name, 0) + 1);

            totalWeight += weight;
        }

        for (String name : grouped.keySet()) {
            System.out.println(counts.get(name) + "x " + name + "        " + grouped.get(name).intValue() + "g");
        }

        System.out.println("Total weight " + (Math.round(totalWeight) / 1000.0) + "kg\n");
    }
}