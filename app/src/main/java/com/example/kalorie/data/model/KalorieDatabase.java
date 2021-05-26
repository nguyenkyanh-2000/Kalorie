package com.example.kalorie.data.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Food.class, Meal.class}, version = 2)
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
            sampleMeal.setMealDate("25/5/2021");
            sampleMeal.setGoalCalorie(2000);
            sampleMeal.setGoalCarb(100);
            sampleMeal.setGoalProtein(100);
            sampleMeal.setGoalFat(100);
            sampleMeal.setUsedCalorie(1800);
            sampleMeal.setUsedCarb(60);
            sampleMeal.setUsedProtein(30);
            sampleMeal.setUsedFat(15);
            mealDao.insertMeal(sampleMeal);

            Meal sampleMeal1 = new Meal();
            sampleMeal1.setMealDate("26/5/2021");
            sampleMeal1.setGoalCalorie(2000);
            sampleMeal1.setGoalCarb(80);
            sampleMeal1.setGoalProtein(80);
            sampleMeal1.setGoalFat(80);
            sampleMeal1.setUsedCalorie(1800);
            sampleMeal1.setUsedCarb(60);
            sampleMeal1.setUsedProtein(30);
            sampleMeal1.setUsedFat(15);
            mealDao.insertMeal(sampleMeal1);

            return null;
        }
    }

}
