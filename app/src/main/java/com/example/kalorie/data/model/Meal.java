package com.example.kalorie.data.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meal")
public class Meal {

    @PrimaryKey
    private Integer mealId;
    private String mealDate;

    private float goalCarb;
    private float goalFat;
    private float goalProtein;
    private float goalCalorie;

    private float usedCarb;
    private float usedFat;
    private float usedProtein;
    private float usedCalorie;


    public Meal(){};

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getMealDate() {
        return mealDate;
    }

    public void setMealDate(String mealDate) {
        this.mealDate = mealDate;
    }

    public float getGoalCarb() {
        return goalCarb;
    }

    public void setGoalCarb(float goalCarb) {
        this.goalCarb = goalCarb;
    }

    public float getGoalFat() {
        return goalFat;
    }

    public void setGoalFat(float goalFat) {
        this.goalFat = goalFat;
    }

    public float getGoalProtein() {
        return goalProtein;
    }

    public void setGoalProtein(float goalProtein) {
        this.goalProtein = goalProtein;
    }

    public float getGoalCalorie() {
        return goalCalorie;
    }

    public void setGoalCalorie(float goalCalorie) {
        this.goalCalorie = goalCalorie;
    }

    public float getUsedCarb() {
        return usedCarb;
    }

    public void setUsedCarb(float usedCarb) {
        this.usedCarb = usedCarb;
    }

    public float getUsedFat() {
        return usedFat;
    }

    public void setUsedFat(float usedFat) {
        this.usedFat = usedFat;
    }

    public float getUsedProtein() {
        return usedProtein;
    }

    public void setUsedProtein(float usedProtein) {
        this.usedProtein = usedProtein;
    }

    public float getUsedCalorie() {
        return usedCalorie;
    }

    public void setUsedCalorie(float usedCalorie) {
        this.usedCalorie = usedCalorie;
    }
}
