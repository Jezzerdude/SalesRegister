package com.example.salesregisterkata.Model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private List<Item> items;
    private BigDecimal totalBeforeTax;
    private BigDecimal tax;

    private BigDecimal totalAfterTax;
    private BigDecimal discount;

    public Order(List<Item> items, BigDecimal totalBeforeTax, BigDecimal discount,
                 BigDecimal tax, BigDecimal totalAfterTax) {
        this.items = items;
        this.totalBeforeTax = totalBeforeTax;
        this.discount = discount;
        this.tax = tax;
        this.totalAfterTax = totalAfterTax;
    }

    public List<Item> getItems() {
        return items;
    }

    public BigDecimal getTotalBeforeTax() {
        return totalBeforeTax;
    }

    public BigDecimal getTotalAfterTax() {
        return totalAfterTax;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getTax() {
        return tax;
    }
}
