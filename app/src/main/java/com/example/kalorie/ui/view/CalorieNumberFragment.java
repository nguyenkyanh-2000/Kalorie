package com.example.kalorie.ui.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.kalorie.R;
import com.example.kalorie.databinding.FragmentCalorieNumberBinding;
import com.example.kalorie.ui.viewmodel.MealViewModel;

import static android.content.ContentValues.TAG;

public class CalorieNumberFragment extends Fragment {

    FragmentCalorieNumberBinding binding;
    MealViewModel mealViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCalorieNumberBinding.inflate(inflater, container, false);
        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        view.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_diarySettingsFragment));
    }
}