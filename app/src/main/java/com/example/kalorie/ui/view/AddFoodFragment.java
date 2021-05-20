package com.example.kalorie.ui.view;

import android.os.Bundle;
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

    FragmentAddFoodBinding binding;
    FoodViewModel foodViewModel;
    Food currentFood;

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


        binding.fragmentAddFoodBtnBack.setOnClickListener(v -> {
            navController.navigate(R.id.action_addFoodFragment_to_homeFragment);
            Toast.makeText(getContext(), "No food added.", Toast.LENGTH_LONG).show();
        });

        binding.fragmentAddFoodBtnSave.setOnClickListener(v -> {
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

    public void savedFood(){
        String foodName = binding.fragmentAddFoodEditTextFoodName.getText().toString();
        String foodDescription = binding.fragmentAddFoodTextInputDescription.getText().toString();
        String foodCalorie = binding.fragmentAddFoodEditTextCalorie.getText().toString();
        int foodAmount = Integer.parseInt(binding.fragmentAddFoodEditTextAmount.getText().toString());

        return;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String units = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}