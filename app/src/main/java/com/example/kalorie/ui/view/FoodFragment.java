package com.example.kalorie.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kalorie.data.model.Food;
import com.example.kalorie.databinding.FragmentItemListFoodBinding;
import com.example.kalorie.ui.adapter.FoodRecyclerViewAdapter;
import com.example.kalorie.ui.adapter.FoodRecyclerViewInterface;
import com.example.kalorie.ui.viewmodel.FoodViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FoodFragment extends Fragment implements FoodRecyclerViewInterface {

    FragmentItemListFoodBinding binding;
    FoodViewModel foodViewModel;
    public static List<Food> currentFoodList;

    public FoodFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentItemListFoodBinding.inflate(inflater, container, false);
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        FoodRecyclerViewAdapter adapter = new FoodRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);

        foodViewModel.getAllFood().observe(getViewLifecycleOwner(), foodList -> {
            adapter.setFoodList(foodList);
            currentFoodList = foodList;
        });
    }

    @Override
    public void onItemClick(int position) {
        Food currentFood = currentFoodList.get(position);
        int currentFoodId = currentFood.getFoodId();

        NavController navController = Navigation.findNavController(getView());

        // Navigate to the information page about the clicked food
        HomeFragmentDirections.ActionHomeFragmentToFoodInfoFragment action = HomeFragmentDirections
                .actionHomeFragmentToFoodInfoFragment(currentFoodId);
        navController.navigate(action);
    }

}