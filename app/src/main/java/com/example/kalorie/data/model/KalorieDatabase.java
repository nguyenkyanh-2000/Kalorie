package com.example.kalorie.data.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Food.class, Meal.class}, version = 1)
public abstract class KalorieDatabase extends RoomDatabase{

    public abstract FoodDao foodDao();
    public abstract MealDao mealDao();

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
            new PopulateDBAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void>{
        FoodDao foodDao;
        MealDao mealDao;

        public PopulateDBAsyncTask(KalorieDatabase db) {
            this.foodDao = db.foodDao();
            this.mealDao = db.mealDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Food sampleFood = new Food();
            sampleFood.setFoodName("Food Sample");
            sampleFood.setFoodDescription("This is a test Food");
            sampleFood.setFoodCalorie(1200);
            sampleFood.setFoodProtein(30);
            sampleFood.setFoodCarb(40);
            sampleFood.setFoodFat(50);
            sampleFood.setFoodAmount(1);
            sampleFood.setFoodUnit("G");
            foodDao.insertFood(sampleFood);

            Meal sampleMeal = new Meal();
            sampleMeal.setMealDate("25/05/2021");
            sampleMeal.setGoalCalorie(2000);
            sampleMeal.setGoalCarb(100);
            sampleMeal.setGoalProtein(100);
            sampleMeal.setGoalFat(100);
            mealDao.insertMeal(sampleMeal);

            return null;
        }
    }

}
