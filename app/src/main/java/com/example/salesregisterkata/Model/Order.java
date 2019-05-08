package com.example.salesregisterkata.Model;

import java.util.List;

public class Order {
    private List<Item> items;
    private double totalBeforeTax;
    private double totalAfterTax;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalBeforeTax() {
        return totalBeforeTax;
    }

    public void setTotalBeforeTax(double totalBeforeTax) {
        this.totalBeforeTax = totalBeforeTax;
    }

    public double getTotalAfterTax() {
        return totalAfterTax;
    }

    public void setTotalAfterTax(double totalAfterTax) {
        this.totalAfterTax = totalAfterTax;
    }
}
