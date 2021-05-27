package com.example.kalorie.data.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class MealWithFoods {
    @Embedded public Meal meal;
    @Relation(parentColumn = "mealDate"
            , entityColumn = "foodDate",
            entity = Food.class
    ) List<Food> foodList;
}
