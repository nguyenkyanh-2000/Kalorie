package com.example.kalorie.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Food {

    public static final List<FoodItem> ITEMS = new ArrayList<FoodItem>();

    public static final Map<String, FoodItem> ITEM_MAP = new HashMap<String, FoodItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(FoodItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.foodName, item);
    }

    private static FoodItem createDummyItem(int position) {
        return new FoodItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class FoodItem {
        public final String foodName;
        public final String foodCalorie;
        public final String foodDetails;

        public FoodItem(String foodName, String foodCalorie, String foodDetails) {
            this.foodName = foodName;
            this.foodCalorie = foodCalorie;
            this.foodDetails = foodDetails;
        }

        @Override
        public String toString() {
            return foodCalorie;
        }
    }
}