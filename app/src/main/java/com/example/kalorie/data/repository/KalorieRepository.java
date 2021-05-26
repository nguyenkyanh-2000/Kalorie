package com.example.kalorie.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.kalorie.data.model.Food;
import com.example.kalorie.data.model.FoodDao;
import com.example.kalorie.data.model.KalorieDatabase;
import com.example.kalorie.data.model.Meal;
import com.example.kalorie.data.model.MealDao;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class KalorieRepository {
    private FoodDao foodDao;
    private MealDao mealDao;
    private LiveData<List<Food>> allFood;

    public KalorieRepository(Application application){
        KalorieDatabase kalorieDatabase = KalorieDatabase.getINSTANCE(application);
        foodDao = kalorieDatabase.foodDao();
        mealDao = kalorieDatabase.mealDao();
        allFood = foodDao.getAllFood();
    }

    public void insert(Food food){
        new InsertFoodAsyncTask(foodDao).execute(food);
    }
    public void delete(Food food){
        new DeleteFoodAsyncTask(foodDao).execute(food);
    }
    public LiveData<List<Food>> getAllFood(){
        return allFood;
    }
    public Food getFoodById(int id) {
        try {
            return new GetFoodByIdAsyncTask(foodDao).execute(id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Meal meal){ new InsertMealAsyncTask(mealDao).execute(meal);}
    public Meal getMealByDate(String date){
        try {
            return new GetMealByDateAsyncTask(mealDao).execute(date).get();
        } catch (ExecutionException | InterruptedException e) {}
        return null;
    }

    // Async tasks
    private static class InsertMealAsyncTask extends AsyncTask<Meal, Void, Void>{
        private MealDao mealDao;

        private InsertMealAsyncTask(MealDao mealDao){
            this.mealDao = mealDao;
        }

        @Override
        protected Void doInBackground(Meal... meals) {
            mealDao.insertMeal(meals[0]);
            return null;
        }
    }

    private static class GetMealByDateAsyncTask extends AsyncTask<String, Void, Meal>{
        private MealDao mealDao;

        private GetMealByDateAsyncTask(MealDao mealDao){
            this.mealDao = mealDao;
        }

        @Override
        protected Meal doInBackground(String... strings) {
            return mealDao.getMealByDate(strings[0]);
        }

        @Override
        protected void onPostExecute(Meal meal) {
            super.onPostExecute(meal);
        }
    }

    private static class GetFoodByIdAsyncTask extends AsyncTask<Integer, Void, Food>{
        private FoodDao foodDao;

        private GetFoodByIdAsyncTask(FoodDao foodDao){
            this.foodDao = foodDao;
        }

        @Override
        protected Food doInBackground(Integer... integers) {
            return foodDao.getFoodById(integers[0]);
        }

        @Override
        protected void onPostExecute(Food food) {
            super.onPostExecute(food);
        }
    }

    private static class InsertFoodAsyncTask extends AsyncTask<Food, Void, Void>{
        private FoodDao foodDao;

        private InsertFoodAsyncTask(FoodDao foodDao){
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(Food... foods) {
            foodDao.insertFood(foods[0]);
            return null;
        }
    }

    private static class DeleteFoodAsyncTask extends AsyncTask<Food, Void, Void>{
        private FoodDao foodDao;

        private DeleteFoodAsyncTask(FoodDao foodDao){
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(Food... foods) {
            foodDao.deleteFood(foods[0]);
            return null;
        }
    }



}
