package com.example.kalorie.data.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface FoodDao {

    @Insert
    void insertFood(Food food);

    @Delete
    void deleteFood(Food food);

    @Query("SELECT * FROM food ORDER BY foodId")
    LiveData<List<Food>> getAllFood();

    @Query("SELECT * FROM food WHERE foodId =:Id LIMIT 1")
    Food getFoodById(int Id);

    @Transaction
    @Query("SELECT * FROM food")
    List<Food> getFoodsInMeal();

}
