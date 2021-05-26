package com.example.kalorie.ui.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.kalorie.R;
import com.example.kalorie.data.model.Meal;
import com.example.kalorie.databinding.FragmentDiarySettingsBinding;
import com.example.kalorie.ui.viewmodel.FoodViewModel;
import com.example.kalorie.ui.viewmodel.MealViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DiarySettingsFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    FragmentDiarySettingsBinding binding;
    MealViewModel mealViewModel;
    Meal currentMeal = new Meal();

    public DiarySettingsFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDiarySettingsBinding.inflate(inflater, container, false);
        mealViewModel =  new ViewModelProvider(getActivity()).get(MealViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController navController = Navigation.findNavController(view);
        super.onViewCreated(view, savedInstanceState);

        binding.fragmentDiarySettingsBtnBack.setOnClickListener(v -> navController
                .navigate(R.id.action_diarySettingsFragment_to_homeFragment));

        binding.fragmentDiarySettingsBtnChangeGoals.setOnClickListener(v -> navController
                .navigate(R.id.action_diarySettingsFragment_to_changeGoalFragment));

        binding.fragmentDiarySettingsBtnChangeDate.setOnClickListener(v -> showDatePickerDialog());
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this,
            Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month = month + 1;
        String date = dayOfMonth + "/" + month + "/" + year;

        binding.fragmentDiarySettingsTextViewCurrentDate.setText(date);
        currentMeal = mealViewModel.getMealByDate(date);

        try {
            binding.fragmentDiarySettingsTextViewCarbGoal.setText(String.valueOf(currentMeal.getGoalCarb()));
            binding.fragmentDiarySettingsTextViewProteinGoal.setText(String.valueOf(currentMeal.getGoalProtein()));
            binding.fragmentDiarySettingsTextViewFatGoal.setText(String.valueOf(currentMeal.getGoalFat()));
            binding.progressBarCalories.setProgress(currentMeal.getProgressCalorie());
            binding.textViewProgressCalories.setText(currentMeal.getProgressCalorie() + "%");
        }
        catch (Exception e){
            binding.fragmentDiarySettingsTextViewCarbGoal.setText(R.string.default_meal_specs);
            binding.fragmentDiarySettingsTextViewProteinGoal.setText(R.string.default_meal_specs);
            binding.fragmentDiarySettingsTextViewFatGoal.setText(R.string.default_meal_specs);
            binding.progressBarCalories.setProgress(0);
            binding.textViewProgressCalories.setText("0%");
        }
    }
}