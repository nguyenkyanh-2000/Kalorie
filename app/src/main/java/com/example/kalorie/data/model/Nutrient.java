package com.example.kalorie.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nutrient")
public class Nutrient {

    @PrimaryKey
    private int nutrientId;

    private float amountCalorie;
    private float amountProtein;
    private float amountFat;
    private float amountCarb;

    public Nutrient(){}

    public int getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(int nutrientId) {
        this.nutrientId = nutrientId;
    }

    public float getAmountCalorie() {
        return amountCalorie;
    }

    public void setAmountCalorie(float amountCalorie) {
        this.amountCalorie = amountCalorie;
    }

    public float getAmountProtein() {
        return amountProtein;
    }

    public void setAmountProtein(float amountProtein) {
        this.amountProtein = amountProtein;
    }

    public float getAmountFat() {
        return amountFat;
    }

    public void setAmountFat(float amountFat) {
        this.amountFat = amountFat;
    }

    public float getAmountCarb() {
        return amountCarb;
    }

    public void setAmountCarb(float amountCarb) {
        this.amountCarb = amountCarb;
    }
}
