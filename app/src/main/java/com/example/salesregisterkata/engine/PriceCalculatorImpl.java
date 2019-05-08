package com.example.salesregisterkata.engine;

import com.example.salesregisterkata.Model.Item;
import com.example.salesregisterkata.Model.Order;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class PriceCalculatorImpl implements PriceCalculator {
    @Override
    public Order getOrderDetails(List<Item> items) {
        double totalBeforeTax = 0;
        double discount = 0;
        double totalAfterTax = 0;
        double tax = 0;
        for (Item item : items) {
            double itemTotal = item.getQuantity() * item.getUnitPrice();
            totalBeforeTax += itemTotal;
            discount += itemTotal * item.getDiscount();
            tax = totalBeforeTax * (item.getState().getTaxRate()/100);
            totalAfterTax += (totalBeforeTax - discount) + tax;
        }
        return new Order(items,
                BigDecimal.valueOf(totalBeforeTax).round(new MathContext(3, RoundingMode.CEILING)),
                BigDecimal.valueOf(discount).round(new MathContext(3, RoundingMode.CEILING)),
                BigDecimal.valueOf(tax).round(new MathContext(3, RoundingMode.CEILING)),
                BigDecimal.valueOf(totalAfterTax));
    }
}
