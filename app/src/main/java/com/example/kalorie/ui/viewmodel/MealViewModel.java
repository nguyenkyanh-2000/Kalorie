package com.example.kalorie.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.kalorie.data.model.Meal;
import com.example.kalorie.data.repository.KalorieRepository;

public class MealViewModel extends AndroidViewModel {

    private final KalorieRepository kalorieRepository;

    public MealViewModel(@NonNull Application application) {
        super(application);
        kalorieRepository = new KalorieRepository(application);
    }

    public void insertMeal(Meal meal){kalorieRepository.insert(meal);}
    public Meal getMealByDate(String date){return kalorieRepository.getMealByDate(date);}
}
