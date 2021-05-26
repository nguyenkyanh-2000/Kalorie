package com.example.kalorie.data.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMeal(Meal meal);

    //TODO: use Date instead of String
    @Query("SELECT * FROM meal WHERE mealDate =:date LIMIT 1")
    Meal getMealByDate(String date);
}

