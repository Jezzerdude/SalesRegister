package com.example.salesregisterkata.Model;

import java.util.List;

public class Order {
    private List<Item> items;
    private double totalBeforeTax;
    private double totalAfterTax;
    private double discount;

    public Order(List<Item> items, double totalBeforeTax, double discount, double totalAfterTax) {
        this.items = items;
        this.totalBeforeTax = totalBeforeTax;
        this.totalAfterTax = totalAfterTax;
        this.discount = discount;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalBeforeTax() {
        return totalBeforeTax;
    }


    public double getTotalAfterTax() {
        return totalAfterTax;
    }

    public double getDiscount() {
        return discount;
    }
}
