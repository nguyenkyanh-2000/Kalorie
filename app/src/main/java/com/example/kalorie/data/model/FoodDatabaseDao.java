package com.example.kalorie.data.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FoodDatabaseDao {

    @Insert
    public void insert(Food food);

    @Delete
    public void deleteFood(Food food);


}