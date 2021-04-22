package com.example.kalorie.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodList {

    public static List<Food> ITEMS = new ArrayList<Food>();

    private static Map<String, Food> ITEM_MAP = new HashMap<String, Food>();

    private static int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Food item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.foodName, item);
    }

    private static Food createDummyItem(int position) {
        return new Food(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

}