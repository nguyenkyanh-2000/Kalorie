package com.example.kalorie.data.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MealDao {

    @Insert
    void insertMeal(Meal meal);

    @Delete
    void deleteMeal(Meal meal);

    @Update
    void updateMeal(Meal meal);

    @Transaction
    @Query("SELECT * FROM Food where mealId =:Id")
    public List<MealWithFoods> getMealWithFoods(int Id);
}

