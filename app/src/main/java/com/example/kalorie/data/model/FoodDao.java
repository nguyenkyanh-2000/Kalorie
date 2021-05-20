package com.example.kalorie.data.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FoodDao {

    @Insert
    void insertFood(Food food);

    @Delete
    void deleteFood(Food food);

    @Update
    void updateFood(Food food);

    @Query("DELETE FROM food")
    void deleteAllFood();

    @Query("SELECT * FROM food ORDER BY foodId")
    LiveData<List<Food>> getAllFood();

    @Query("SELECT * FROM food WHERE foodId =:Id")
    LiveData<Food> getFoodById(int Id);

}
