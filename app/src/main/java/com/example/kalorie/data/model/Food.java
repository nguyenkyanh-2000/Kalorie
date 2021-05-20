package com.example.kalorie.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food")
public class Food{

    @PrimaryKey(autoGenerate = true)
    private int foodId;

    private int nutrientId;

    @ColumnInfo
    private String foodName;

    @ColumnInfo
    private String foodDescription;

    @ColumnInfo
    private int foodAmount;

    // Temporary
    private String foodCalorie;

    public Food(){

    }

    public Food(int foodId, String foodName, String foodDescription, String foodCalorie){
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodCalorie = foodCalorie;
    }

    public Food(String foodName, String foodDescription, String foodCalorie){
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodCalorie = foodCalorie;
    }


    // Getters & Setters

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(int nutrientId) {
        this.nutrientId = nutrientId;
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

    public String getFoodCalorie() {
        return foodCalorie;
    }

    public void setFoodCalorie(String foodCalorie) {
        this.foodCalorie = foodCalorie;
    }
}