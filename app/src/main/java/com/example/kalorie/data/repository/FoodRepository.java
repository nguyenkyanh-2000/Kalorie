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

    }

    public void update(Food food){

    }

    public void delete(Food food){

    }

    public void deleteAllFood(){

    }

    public LiveData<List<Food>> getAllFood(){
        return allFood;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Food, Void, Void>{
        private FoodDao foodDao;

        private InsertNoteAsyncTask(FoodDao foodDao){
            this.foodDao = foodDao;
        }

        @Override
        protected Void doInBackground(Food... foods) {
            foodDao.insertFood(foods[0]);
            return null;
        }
    }
}
