package com.example.kalorie.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.kalorie.data.model.Food;
import com.example.kalorie.data.model.FoodDao;
import com.example.kalorie.data.model.KalorieDatabase;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class KalorieRepository {
    private FoodDao foodDao;
    private LiveData<List<Food>> allFood;

    public KalorieRepository(Application application){
        KalorieDatabase kalorieDatabase = KalorieDatabase.getINSTANCE(application);
        foodDao = kalorieDatabase.foodDao();
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
            return new GetFoodAsyncTask(foodDao).execute(id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class GetFoodAsyncTask extends AsyncTask<Integer, Void, Food>{
        private FoodDao foodDao;

        private GetFoodAsyncTask(FoodDao foodDao){
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
