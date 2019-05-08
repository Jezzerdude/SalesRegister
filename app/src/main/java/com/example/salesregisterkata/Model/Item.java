package com.example.salesregisterkata.Model;

import java.util.Objects;

public class Item {
    private String label;
    private double quantity;
    private double unitPrice;
    private State state;
    private float discount;

    public Item(String label, double quantity, double unitPrice, State state, float discount) {
        this.label = label;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.state = state;
        this.discount = discount;
    }

    public String getLabel() {
        return label;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }


    public State getState() {
        return state;
    }

    public float getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.quantity, quantity) == 0 &&
                Double.compare(item.unitPrice, unitPrice) == 0 &&
                Float.compare(item.discount, discount) == 0 &&
                Objects.equals(label, item.label) &&
                state == item.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, quantity, unitPrice, state, discount);
    }
}
