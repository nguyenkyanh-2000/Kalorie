package com.example.kalorie.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Food {

    public String foodId;

    public String foodName;

    public String foodCalorie;

    public String foodDetails;


    public Food(String foodId, String foodName, String foodCalorie, String foodDetails) {
        this.foodId = foodId;
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

    public String getFoodId() {
        return foodId;
    }
}
