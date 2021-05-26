package com.example.kalorie.ui.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.kalorie.R;
import com.example.kalorie.data.model.Food;
import com.example.kalorie.databinding.FragmentAddFoodBinding;
import com.example.kalorie.ui.viewmodel.FoodViewModel;

import org.jetbrains.annotations.NotNull;

public class AddFoodFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    FragmentAddFoodBinding binding = null;
    Food currentFood = new Food();
    FoodViewModel foodViewModel;

    public AddFoodFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddFoodBinding.inflate(inflater, container, false);
        foodViewModel = new ViewModelProvider(getActivity()).get(FoodViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController navController = Navigation.findNavController(view);
        super.onViewCreated(view, savedInstanceState);

        // Add a watcher to all input text fields.
        binding.fragmentAddFoodBtnSave.setEnabled(false);
        binding.fragmentAddFoodEditTextFoodName.addTextChangedListener(textWatcher);
        binding.fragmentAddFoodEditTextAmount.addTextChangedListener(textWatcher);
        binding.fragmentAddFoodEditTextCalorie.addTextChangedListener(textWatcher);
        binding.fragmentAddFoodTextInputDescription.addTextChangedListener(textWatcher);

        // Bindings for the SAVE and BACK button
        binding.fragmentAddFoodBtnBack.setOnClickListener(v -> {
            navController.navigate(R.id.action_addFoodFragment_to_homeFragment);
            Toast.makeText(getContext(), "No food added.", Toast.LENGTH_SHORT).show();
        });

        binding.fragmentAddFoodBtnSave.setOnClickListener(v -> {
            foodViewModel.insert(currentFood);
            navController.navigate(R.id.action_addFoodFragment_to_homeFragment);
            Toast.makeText(getContext(), "Food added", Toast.LENGTH_SHORT).show();
        });

        // Bindings for the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner2.setAdapter(adapter);
        binding.spinner2.setOnItemSelectedListener(this);
    }

    // Text watcher
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            // Getting input from input fields.
            String foodNameInput = binding.fragmentAddFoodEditTextFoodName
                        .getText().toString().trim();
            String foodCalorieInput = binding.fragmentAddFoodEditTextCalorie
                    .getText().toString().trim();
            String foodDescriptionInput = binding.fragmentAddFoodTextInputDescription
                    .getText().toString().trim();
            String foodAmountInput = binding.fragmentAddFoodEditTextAmount
                    .getText().toString().trim();
            String foodCarbInput = binding.fragmentAddFoodEditTextCarb
                    .getText().toString().trim();
            String foodProteinInput = binding.fragmentAddFoodEditTextProtein
                    .getText().toString().trim();
            String foodFatInput = binding.fragmentAddFoodEditTextFat
                    .getText().toString().trim();

            // If any of the inputs is empty, the SAVE button is hidden.
            if ((!foodAmountInput.isEmpty() && !foodCalorieInput.isEmpty()
                    && !foodNameInput.isEmpty() && !foodDescriptionInput.isEmpty()
                    && !foodCarbInput.isEmpty()) && !foodProteinInput.isEmpty()
                    && !foodFatInput.isEmpty()){

                binding.fragmentAddFoodBtnSave.setEnabled(true);
                currentFood.setFoodName(foodNameInput);
                currentFood.setFoodDescription(foodDescriptionInput);
                currentFood.setFoodCalorie(Integer.parseInt(foodCalorieInput));
                currentFood.setFoodAmount(Integer.parseInt(foodAmountInput));
                currentFood.setFoodCarb(Integer.parseInt(foodCarbInput));
                currentFood.setFoodProtein(Integer.parseInt(foodProteinInput));
                currentFood.setFoodFat(Integer.parseInt(foodFatInput));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    // Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String units = parent.getItemAtPosition(position).toString();
        currentFood.setFoodUnit(units);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        String defaultUnits = parent.getItemAtPosition(0).toString();
        currentFood.setFoodUnit(defaultUnits);
    }

}