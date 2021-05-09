package com.example.kalorie.ui.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kalorie.R;

public class FoodInfoFragment extends Fragment {


    public FoodInfoFragment() {
        // Required empty public constructor
    }

    public static FoodInfoFragment newInstance() {
        FoodInfoFragment fragment = new FoodInfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // get food id
        int foodId = getArguments().getInt("food_id");
        return inflater.inflate(R.layout.fragment_food_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController navController = Navigation.findNavController(view);

        super.onViewCreated(view, savedInstanceState);

        Button btn_add_food_back = view.findViewById(R.id.fragment_food_info_btn_back);
        btn_add_food_back.setOnClickListener(v -> navController.navigate(R.id.action_foodInfoFragment_to_homeFragment));

    }
}