package com.example.salesregisterkata;

import com.example.salesregisterkata.Model.Item;
import com.example.salesregisterkata.Model.State;

import java.util.Collections;
import java.util.List;

class TestUtils {

    static Item getDummyItem(boolean withDiscount) {
        return new Item("Apples", 2000, 1, State.AL, withDiscount ? 0.03f : 0f);
    }

    static List<Item> getListOfDummyItems(boolean withDiscount) {
        return Collections.singletonList(getDummyItem(withDiscount));
    }

}
