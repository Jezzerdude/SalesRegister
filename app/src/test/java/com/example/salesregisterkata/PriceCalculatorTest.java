package com.example.salesregisterkata;

import android.companion.AssociationRequest;

import com.example.salesregisterkata.Model.Item;
import com.example.salesregisterkata.Model.Order;
import com.example.salesregisterkata.engine.PriceCalculator;
import com.example.salesregisterkata.engine.PriceCalculatorImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PriceCalculatorTest {
    private PriceCalculator priceCalculator;

    @Before
    public void setup() {
        priceCalculator = new PriceCalculatorImpl();
    }

    @Test
    public void testGetOrderDetails_WithDiscount() {
        //Given
        List<Item> items = TestUtils.getListOfDummyItems(true);

        //When
        Order order = priceCalculator.getOrderDetails(items);

        //Then
        for (int i = 0; i < order.getItems().size(); i++) {
            Assert.assertEquals(items.get(i), order.getItems().get(i));
        }

        Assert.assertEquals(60.0, order.getDiscount().floatValue(), 0.0);
        Assert.assertEquals(2000.0, order.getTotalBeforeTax().floatValue(), 0.0);
        Assert.assertEquals(80.0, order.getTax().floatValue(), 0.0);
        Assert.assertEquals(2020, order.getTotalAfterTax().floatValue(), 0.0);
    }

    @Test
    public void testGetOrderDetails_WithoutDiscount() {
        //Given
        List<Item> items = TestUtils.getListOfDummyItems(false);

        //When
        Order order = priceCalculator.getOrderDetails(items);

        //Then
        for (int i = 0; i < order.getItems().size(); i++) {
            Assert.assertEquals(items.get(i), order.getItems().get(i));
        }

        Assert.assertEquals(0.0, order.getDiscount().floatValue(), 0.0);
        Assert.assertEquals(2000.0, order.getTotalBeforeTax().floatValue(), 0.0);
        Assert.assertEquals(80.0, order.getTax().floatValue(), 0.0);
        Assert.assertEquals(2080, order.getTotalAfterTax().floatValue(), 0.0);
    }
}
