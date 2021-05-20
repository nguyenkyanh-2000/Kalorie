package com.example.kalorie.data.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Food.class}, version = 1)
public abstract class KalorieDatabase extends RoomDatabase{

    public abstract FoodDao foodDao();

    private static KalorieDatabase INSTANCE;

    public static synchronized KalorieDatabase getINSTANCE(Context context){
        if (INSTANCE == null){
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), KalorieDatabase.class, "kalorieDB")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallBack)
                            .build();
        }
            return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private FoodDao foodDao;

        private PopulateDbAsyncTask (KalorieDatabase db){
            foodDao = db.foodDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            Food tmpFood = new Food();
            tmpFood.setFoodName("Example Food");
            tmpFood.setFoodDescription("Heavily coded food");
            tmpFood.setFoodCalorie(666);
            tmpFood.setFoodCarb(6);
            tmpFood.setFoodFat(6);
            tmpFood.setFoodProtein(6);
            foodDao.insertFood(tmpFood);
            return null;
        }
    }

}
