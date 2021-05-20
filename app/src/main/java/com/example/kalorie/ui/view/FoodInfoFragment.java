package com.example.kalorie.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.kalorie.R;
import com.example.kalorie.data.model.Food;
import com.example.kalorie.databinding.FragmentFoodInfoBinding;
import com.example.kalorie.ui.viewmodel.FoodViewModel;

import org.jetbrains.annotations.NotNull;

public class FoodInfoFragment extends Fragment {

    private int currentFoodId;
    private static Food currentFood = new Food();
    private FragmentFoodInfoBinding binding;
    private FoodViewModel foodViewModel;

    public FoodInfoFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFoodInfoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        foodViewModel = new ViewModelProvider(getActivity()).get(FoodViewModel.class);

        // Get the ID of the clicked food from the bundle sent by the food fragment
        if (getArguments() != null){
            FoodInfoFragmentArgs args = FoodInfoFragmentArgs.fromBundle(getArguments());
            currentFoodId = args.getCurrentFoodId();
        }

        // Get the food using Food View Model
        foodViewModel.getFoodById(currentFoodId).observe(getViewLifecycleOwner(), food ->{
            currentFood = food;
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        binding.fragmentFoodInfoTextViewCalorie.setText(currentFood.getFoodCalorie());
        binding.fragmentFoodInfoTextViewName.setText(currentFood.getFoodName());
        binding.fragmentFoodInfoTextViewDescription.setText(currentFood.getFoodDescription());

        binding.fragmentFoodInfoBtnBack.setOnClickListener(v -> {
            navController.navigate(R.id.action_foodInfoFragment_to_homeFragment);
        });

        binding.fragmentFoodInfoBtnRemove.setOnClickListener(v -> {
            navController.navigate(R.id.action_foodInfoFragment_to_homeFragment);
            foodViewModel.delete(currentFood);
            Toast.makeText(getActivity(), "Food removed", Toast.LENGTH_LONG).show();
        });

    }
}