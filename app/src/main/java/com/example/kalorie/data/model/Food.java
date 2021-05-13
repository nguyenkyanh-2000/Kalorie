package com.example.kalorie.data.model;

import java.util.ArrayList;

public class Food {

    private String foodId;
    private String foodName;
    private String foodCalorie;
    private String foodDescription;
    private Integer foodAmount;
    private String[] foodUnits = new String[]{"g","mg","kg"};

    public Food(String foodId, String foodName, String foodCalorie, String foodDescription) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodCalorie = foodCalorie;
        this.foodDescription = foodDescription;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodCalorie() {
        return foodCalorie;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public String getFoodId() {
        return foodId;
    }
}
