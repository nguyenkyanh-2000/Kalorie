package com.example.kalorie.ui.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kalorie.R;
import com.example.kalorie.data.model.Food;
import com.example.kalorie.databinding.FragmentAddFoodBinding;
import com.example.kalorie.ui.viewmodel.FoodViewModel;

public class AddFoodFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    FragmentAddFoodBinding binding;
    FoodViewModel foodViewModel;

    public AddFoodFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddFoodBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController navController = Navigation.findNavController(view);
        foodViewModel = new ViewModelProvider(getActivity()).get(FoodViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        binding.fragmentAddFoodBtnBack.setOnClickListener(v -> {
            navController.navigate(R.id.action_addFoodFragment_to_homeFragment);
            Toast.makeText(getContext(), "No food added.", Toast.LENGTH_LONG).show();
        });

        binding.fragmentAddFoodBtnSave.setOnClickListener(v -> {
            Food currentFood = savedFood();
            foodViewModel.insert(currentFood);
            navController.navigate(R.id.action_addFoodFragment_to_homeFragment);
            Toast.makeText(getContext(), "Food added", Toast.LENGTH_LONG).show();
        });


        // TODO: Deal with the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner2.setAdapter(adapter);
        binding.spinner2.setOnItemSelectedListener(this);
    }

    public Food savedFood(){
        String foodName = binding.fragmentAddFoodEditTextFoodName.getText().toString();
        String foodDescription = binding.fragmentAddFoodTextInputDescription.getText().toString();
        String foodCalorie = binding.fragmentAddFoodEditTextCalorie.getText().toString();
        int foodAmount = Integer.parseInt(binding.fragmentAddFoodEditTextAmount.getText().toString());
        Food food = new Food();
        food.setFoodName(foodName);
        food.setFoodDescription(foodDescription);
        food.setFoodAmount(foodAmount);
        food.setFoodCalorie(foodCalorie);
        return food;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String units = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}