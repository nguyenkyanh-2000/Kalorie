package com.example.kalorie.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kalorie.data.model.Meal;
import com.example.kalorie.data.repository.KalorieRepository;

public class MealViewModel extends AndroidViewModel {

    private final KalorieRepository kalorieRepository;
    public MutableLiveData<String> currentDate = new MutableLiveData<>();

    public MealViewModel(@NonNull Application application) {
        super(application);
        kalorieRepository = new KalorieRepository(application);
    }

    public void insertMeal(Meal meal){
        kalorieRepository.insert(meal);
    }

    public LiveData<String> getCurrentDate(){
        return currentDate;
    }

    public Meal getMealByDate(String date){
        Meal currentMeal = kalorieRepository.getMealByDate(date);
        currentDate.setValue(date);

        if (currentMeal == null){
            currentMeal = new Meal();
            currentMeal.setMealDate(date);
            currentMeal.setGoalCalorie(0);
            currentMeal.setGoalCarb(0);
            currentMeal.setGoalProtein(0);
            currentMeal.setGoalFat(0);
            currentMeal.setUsedCalorie(0);
            currentMeal.setUsedCarb(0);
            currentMeal.setUsedProtein(0);
            currentMeal.setUsedFat(0);
            insertMeal(currentMeal);
        }
        return currentMeal;
    }
}
