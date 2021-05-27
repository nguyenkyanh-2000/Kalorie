package com.example.kalorie.ui.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.kalorie.R;
import com.example.kalorie.data.model.Meal;
import com.example.kalorie.databinding.FragmentChangeGoalBinding;
import com.example.kalorie.ui.viewmodel.MealViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class ChangeGoalFragment extends Fragment implements DatePickerDialog.OnDateSetListener{

    FragmentChangeGoalBinding binding;
    MealViewModel mealViewModel;
    Meal currentMeal = new Meal();
    String currentDate;

    public ChangeGoalFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChangeGoalBinding.inflate(inflater, container, false);
        currentDate ="";
        mealViewModel = new ViewModelProvider(getActivity()).get(MealViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final NavController navController = Navigation.findNavController(view);
        super.onViewCreated(view, savedInstanceState);

        // Add a text watcher to all input fields.
        binding.fragmentChangeGoalBtnSave.setEnabled(false);
        binding.EditTextNewCalorieGoal.addTextChangedListener(textWatcher);
        binding.EditTextNewCarbGoal.addTextChangedListener(textWatcher);
        binding.EditTextNewProteinGoal.addTextChangedListener(textWatcher);
        binding.EditTextNewFatGoal.addTextChangedListener(textWatcher);

        // Bindings for BACK, SAVE and CHOOSE DATE buttons

        binding.fragmentChangeGoalBtnBack.setOnClickListener(v -> {
            navController.navigate(R.id.action_changeGoalFragment_to_diarySettingsFragment);
            Toast.makeText(getContext(), "No new goals.", Toast.LENGTH_SHORT).show();
        });

        binding.fragmentChangeGoalBtnSave.setOnClickListener(v -> {
            navController.navigate(R.id.action_changeGoalFragment_to_diarySettingsFragment);
            mealViewModel.insertMeal(currentMeal);
            Toast.makeText(getContext(), "New goal added.", Toast.LENGTH_SHORT).show();
        });

        binding.fragmentChangeGoalBtnChooseDate.setOnClickListener(v -> showDatePickerDialog());
    }

    // Text watcher
    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            // Get inputs from the EditText fields.
            String mealCalorieInput = binding.EditTextNewCalorieGoal
                    .getText().toString().trim();
            String mealCarbInput = binding.EditTextNewCarbGoal
                    .getText().toString().trim();
            String mealProteinInput = binding.EditTextNewProteinGoal
                    .getText().toString().trim();
            String mealFatInput = binding.EditTextNewFatGoal
                    .getText().toString().trim();

            // If any input field is empty, the SAVE button is hidden.
            if (currentDate != "" && !mealCalorieInput.isEmpty() && !mealCarbInput.isEmpty()
                && !mealProteinInput.isEmpty() && !mealFatInput.isEmpty()){

                binding.fragmentChangeGoalBtnSave.setEnabled(true);
                currentMeal.setMealDate(currentDate);
                currentMeal.setGoalCalorie(Integer.parseInt(mealCalorieInput));
                currentMeal.setGoalCarb(Integer.parseInt(mealCarbInput));
                currentMeal.setGoalProtein(Integer.parseInt(mealProteinInput));
                currentMeal.setGoalFat(Integer.parseInt(mealFatInput));
            }
        }
        @Override
        public void afterTextChanged(Editable s) {}
    };

    // Date Picker Dialog
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
        //  Months in Android: 0 - 11, not 1 - 12.
        month = month + 1;
        currentDate = dayOfMonth + "/" + month + "/" + year;
        binding.fragmentChangeGoalBtnChooseDate.setText(currentDate);
    }
}