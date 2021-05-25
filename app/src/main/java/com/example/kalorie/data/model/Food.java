package com.example.kalorie.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Food{

    @PrimaryKey(autoGenerate = true)
    @SerializedName("food_id")
    private int foodId;

    @ColumnInfo
    @SerializedName("name")
    private String foodName;

    @ColumnInfo
    @SerializedName("description")
    private String foodDescription;

    @ColumnInfo
    @SerializedName("amount")
    private int foodAmount;

    @ColumnInfo
    @SerializedName("calories_amount")
    private int foodCalorie;

    @ColumnInfo
    @SerializedName("fats_amount")
    private int foodFat;

    @ColumnInfo
    @SerializedName("proteins_amount")
    private int foodProtein;

    @ColumnInfo
    @SerializedName("carbs_amount")
    private int foodCarb;

    @ColumnInfo
    private int mealId;

    @ColumnInfo
    private String foodUnit;

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

    public String getFoodUnit() {
        return foodUnit;
    }

    public void setFoodUnit(String foodUnit) {
        this.foodUnit = foodUnit;
    }
}