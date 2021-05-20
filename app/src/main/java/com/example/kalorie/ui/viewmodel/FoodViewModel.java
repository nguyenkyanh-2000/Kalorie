package com.example.kalorie.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kalorie.data.model.Food;
import com.example.kalorie.data.repository.FoodRepository;

import java.util.List;


public class FoodViewModel extends AndroidViewModel {

    private FoodRepository foodRepository;
    private LiveData<List<Food>> allFood;


    public FoodViewModel(@NonNull Application application) {
        super(application);
        foodRepository = new FoodRepository(application);
        allFood = foodRepository.getAllFood();
    }

    public void insert(Food food){
        foodRepository.insert(food);
    }

    public void update(Food food){
        foodRepository.update(food);
    }

    public void delete(Food food){
        foodRepository.delete(food);
    }

    public void deleteAllFood(){
        foodRepository.deleteAllFood();
    }

    public LiveData<List<Food>> getAllFood() {
        return allFood;
    }

    public LiveData<Food> getFoodById(int id) {
        return foodRepository.getFoodById(id);
    }

}
