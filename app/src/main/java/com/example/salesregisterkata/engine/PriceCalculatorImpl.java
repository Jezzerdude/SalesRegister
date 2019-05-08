package com.example.salesregisterkata.engine;

import com.example.salesregisterkata.Model.Item;
import com.example.salesregisterkata.Model.Order;

import java.util.List;

public class PriceCalculatorImpl implements PriceCalculator {
    @Override
    public Order getOrderDetails(List<Item> items) {
        double totalBeforeTax = 0;
        double discount = 0;
        double totalAfterTax = 0;
        for (Item item : items) {
            double itemTotal = item.getQuantity() * item.getUnitPrice();
            totalBeforeTax += itemTotal;
            discount += itemTotal * item.getDiscount();
            totalAfterTax += (totalBeforeTax - discount) +
                    (totalBeforeTax * item.getState().getTaxRate());
        }
        return new Order(items, totalBeforeTax, discount, totalAfterTax);
    }
}
