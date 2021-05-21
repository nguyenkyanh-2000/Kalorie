package com.example.kalorie.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Food{

    @PrimaryKey(autoGenerate = true)
    private int foodId;

    @ColumnInfo
    private String foodName;

    @ColumnInfo
    private String foodDescription;

    @ColumnInfo
    private int foodAmount;

    @ColumnInfo
    private int foodCalorie;

    @ColumnInfo
    private int foodFat;

    @ColumnInfo
    private int foodProtein;

    @ColumnInfo
    private int foodCarb;

    @ColumnInfo
    private int mealId;

    public Food(){
    }


    // Getters & Setters

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getFoodFat() {
        return foodFat;
    }

    public void setFoodFat(int foodFat) {
        this.foodFat = foodFat;
    }

    public int getFoodProtein() {
        return foodProtein;
    }

    public void setFoodProtein(int foodProtein) {
        this.foodProtein = foodProtein;
    }

    public int getFoodCarb() {
        return foodCarb;
    }

    public void setFoodCarb(int foodCarb) {
        this.foodCarb = foodCarb;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodCalorie() {
        return foodCalorie;
    }

    public void setFoodCalorie(int foodCalorie) {
        this.foodCalorie = foodCalorie;
    }
}