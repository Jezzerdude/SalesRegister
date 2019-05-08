package com.example.salesregisterkata.engine;

import com.example.salesregisterkata.Model.Item;
import com.example.salesregisterkata.Model.Order;

import java.util.List;

public interface PriceCalculator {
    Order getOrderDetails(List<Item> items);
}
