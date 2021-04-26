package com.example.kalorie.data.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Food.class}, version = 1)
public abstract class FoodDatabase extends RoomDatabase {

    public abstract FoodDao foodDao();

    private static FoodDatabase INSTANCE;

    public static FoodDatabase getInstance(Context context){

        if(INSTANCE == null ) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FoodDatabase.class, "FoodDB")
                    .allowMainThreadQueries()
                    .build();

        }

        return INSTANCE;
    }
}