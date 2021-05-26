package com.example.kalorie.data.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Meal {

    @PrimaryKey
    private Integer Id;

    @ColumnInfo
    private String mealDate;

    @ColumnInfo
    private float goalCarb;

    @ColumnInfo
    private float goalFat;

    @ColumnInfo
    private float goalProtein;

    @ColumnInfo
    private float goalCalorie;

    @ColumnInfo
    private float usedCarb;

    @ColumnInfo
    private float usedFat;

    @ColumnInfo
    private float usedProtein;

    @ColumnInfo
    private float usedCalorie;


    public Meal(){}

    public Integer getProgressCalorie()
    {
        float progress = 100 * usedCalorie / goalCalorie;
        return (int) progress;
    }


    public Integer getProgressProtein()
    {
        float progress = 100 * usedProtein / goalProtein;
        return (int) progress;
    }


    public Integer getProgressCarb()
    {
        float progress = 100 * usedCarb / goalCarb;
        return (int) progress;
    }


    public Integer getProgressFat()
    {
        float progress = 100 * usedFat / goalFat;
        return (int) progress;
    }

    // Setters & Getters


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
