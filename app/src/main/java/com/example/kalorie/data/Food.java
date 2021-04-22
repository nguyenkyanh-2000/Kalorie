package com.example.kalorie.data;

public class Food {
    public final String foodName;
    public final String foodCalorie;
    public final String foodDetails;

    public Food(String foodName, String foodCalorie, String foodDetails) {
        this.foodName = foodName;
        this.foodCalorie = foodCalorie;
        this.foodDetails = foodDetails;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodCalorie() {
        return foodCalorie;
    }

    public String getFoodDetails() {
        return foodDetails;
    }
}
