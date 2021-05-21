package com.example.kalorie.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kalorie.data.model.Food;
import com.example.kalorie.data.repository.KalorieRepository;

import java.util.List;


public class FoodViewModel extends AndroidViewModel {

    private KalorieRepository kalorieRepository;
    private LiveData<List<Food>> allFood;


    public FoodViewModel(@NonNull Application application) {
        super(application);
        kalorieRepository = new KalorieRepository(application);
        allFood = kalorieRepository.getAllFood();
    }

    public void insert(Food food){
        kalorieRepository.insert(food);
    }

    public void update(Food food){
        kalorieRepository.update(food);
    }

    public void delete(Food food){
        kalorieRepository.delete(food);
    }

    public void deleteAllFood(){
        kalorieRepository.deleteAllFood();
    }

    public LiveData<List<Food>> getAllFood() {
        return allFood;
    }

    public LiveData<Food> getFoodById(int id) {
        return kalorieRepository.getFoodById(id);
    }

}
