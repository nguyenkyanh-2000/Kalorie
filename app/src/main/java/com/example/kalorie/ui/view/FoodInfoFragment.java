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


    public FoodInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFoodInfoBinding binding = FragmentFoodInfoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController navController = Navigation.findNavController(view);

        super.onViewCreated(view, savedInstanceState);

        Button btn_add_food_back = view.findViewById(R.id.fragment_food_info_btn_back);
        btn_add_food_back.setOnClickListener(v -> navController.navigate(R.id.action_foodInfoFragment_to_homeFragment));

    }
}