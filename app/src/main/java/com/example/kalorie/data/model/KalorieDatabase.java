package com.example.kalorie.data.model;

import android.app.Application;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Food.class, Meal.class, Nutrient.class}, version = 1, exportSchema = false)
public abstract class KalorieDatabase extends RoomDatabase{

    public abstract FoodDao foodDao();
    private static volatile KalorieDatabase INSTANCE;

    public static KalorieDatabase getINSTANCE(Context context){
        if (INSTANCE == null){
            synchronized (KalorieDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), KalorieDatabase.class, "kalorieDB")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
