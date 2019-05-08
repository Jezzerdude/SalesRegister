package com.example.salesregisterkata.ui.home;

import com.example.salesregisterkata.Model.Item;
import com.example.salesregisterkata.Model.Order;
import com.example.salesregisterkata.Model.State;
import com.example.salesregisterkata.engine.PriceCalculator;

import java.util.Collections;

public class HomePresenter implements HomeContract.Presenter {

    private final PriceCalculator priceCalculator;
    private final HomeContract.View view;

    public HomePresenter(PriceCalculator priceCalculator, HomeContract.View view) {
        this.priceCalculator = priceCalculator;
        this.view = view;
    }

    @Override
    public void calculateTotal(String label, String quantity, String individualPrice, String stateCode) {
        Item item = new Item(label,
                Double.valueOf(quantity),
                Double.valueOf(individualPrice),
                State.getStateFromCode(stateCode),
                getDiscount(quantity));
        Order order = priceCalculator.getOrderDetails(Collections.singletonList(item));
        view.showResult(getFormattedResult(order));
    }

    private String getFormattedResult(Order order) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Item item : order.getItems()) {
            stringBuilder.append("Label: ").append(item.getLabel()).append("\n");
            stringBuilder.append("Quantity: ").append(item.getQuantity()).append("\n");
            stringBuilder.append("Unit Price: ").append(item.getUnitPrice()).append("\n");
        }

        stringBuilder.append("Total Without Taxes: ")
                .append(order.getTotalBeforeTax().floatValue()).append("\n");
        stringBuilder.append("Discount: ")
                .append(order.getDiscount().floatValue()).append("\n");
        stringBuilder.append("Tax: ").append(order.getTax().floatValue()).append("\n");
        stringBuilder.append("Total Price: ").append(order.getTotalAfterTax().floatValue());

        return stringBuilder.toString();
    }

    private float getDiscount(String quantity) {
        int totalItems = Integer.valueOf(quantity);
        if (totalItems > 1000 && totalItems < 5000) {
            return 0.03f;
        } else if (totalItems > 5000 &&  totalItems < 7000) {
            return 0.05f;
        } else if (totalItems > 7000 && totalItems < 10000) {
            return 0.07f;
        } else if (totalItems > 10000 && totalItems < 50000) {
            return 0.10f;
        } else if (totalItems > 50000) {
            return 0.15f;
        } else {
            return 0.0f;
        }
    }
}
