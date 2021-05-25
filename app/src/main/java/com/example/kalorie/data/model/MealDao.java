package com.example.kalorie.data.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MealDao {

    @Insert
    void insertMeal(Meal meal);

    @Query("SELECT * FROM meal WHERE mealDate =:date LIMIT 1")
    Meal getMealByDate(String date);
}

