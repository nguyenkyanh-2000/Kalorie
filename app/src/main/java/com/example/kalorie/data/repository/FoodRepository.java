package com.example.kalorie.data.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.kalorie.data.model.Food;
import com.example.kalorie.data.model.FoodDao;
import com.example.kalorie.data.model.KalorieDatabase;

import java.util.List;

public class FoodRepository {
    private FoodDao foodDao;
    private LiveData<List<Food>> allFood;

    public FoodRepository(Application application){
        KalorieDatabase kalorieDatabase = KalorieDatabase.getINSTANCE(application);
        foodDao = kalorieDatabase.foodDao();
        allFood = foodDao.getAllFood();
    }

    public void insert(Food food){
        new InsertFoodAsyncTask(foodDao).execute(food);
    }

    public void update(Food food){
        new UpdateFoodAsyncTask(foodDao).execute(food);
    }

    public void delete(Food food){
        new DeleteFoodAsyncTask(foodDao).execute(food);
    }

    public void deleteAllFood(){
        new DeleteAllFoodAsyncTask(foodDao).execute();
    }

    public LiveData<List<Food>> getAllFood(){
        return allFood;
    }

    public LiveData<Food> getFoodById(int id) {
        return foodDao.getFoodById(id);
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

    private static class UpdateFoodAsyncTask extends AsyncTask<Food, Void, Void>{
        private FoodDao foodDao;

        private UpdateFoodAsyncTask(FoodDao foodDao){
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(Food... foods) {
            foodDao.updateFood(foods[0]);
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

    private static class DeleteAllFoodAsyncTask extends AsyncTask<Void, Void, Void>{
        private FoodDao foodDao;

        private DeleteAllFoodAsyncTask(FoodDao foodDao){
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            foodDao.deleteAllFood();
            return null;
        }
    }


}
