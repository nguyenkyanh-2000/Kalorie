package com.example.kalorie.ui.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kalorie.R;
import com.example.kalorie.data.model.Food;
import com.example.kalorie.databinding.FragmentFoodInfoBinding;

import static android.content.ContentValues.TAG;

public class FoodInfoFragment extends Fragment {

    FragmentFoodInfoBinding binding;
    Food currentFood;

    public FoodInfoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFoodInfoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        if (getArguments() != null){
            FoodInfoFragmentArgs args = FoodInfoFragmentArgs.fromBundle(getArguments());
            currentFood = args.getFood();
        }

        binding.fragmentFoodInfoBtnBack.setOnClickListener(v -> navController
                .navigate(R.id.action_foodInfoFragment_to_homeFragment));

        binding.fragmentFoodInfoTextViewCalorie.setText(currentFood.getFoodCalorie());
        binding.fragmentFoodInfoTextViewName.setText(currentFood.getFoodName());
        binding.fragmentFoodInfoTextViewDescription.setText(currentFood.getFoodDescription());
    }
}