package com.example.kalorie.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food")
public class Food implements Parcelable {

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

    // Parcelable

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


    protected Food(Parcel in) {
        foodId = in.readInt();
        nutrientId = in.readInt();
        foodName = in.readString();
        foodDescription = in.readString();
        foodAmount = in.readInt();
        foodCalorie = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(foodId);
        dest.writeInt(nutrientId);
        dest.writeString(foodName);
        dest.writeString(foodDescription);
        dest.writeInt(foodAmount);
        dest.writeString(foodCalorie);
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