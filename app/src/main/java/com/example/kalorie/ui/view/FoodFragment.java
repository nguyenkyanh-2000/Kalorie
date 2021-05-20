package com.example.kalorie.ui.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalorie.data.model.Food;
import com.example.kalorie.databinding.FragmentItemListFoodBinding;
import com.example.kalorie.ui.adapter.FoodRecyclerViewAdapter;
import com.example.kalorie.ui.adapter.FoodRecyclerViewInterface;
import com.example.kalorie.ui.viewmodel.FoodViewModel;

import java.util.List;

public class FoodFragment extends Fragment implements FoodRecyclerViewInterface {

    FragmentItemListFoodBinding binding;
    FoodViewModel foodViewModel;
    public static List<Food> currentFoodList;

    public FoodFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentItemListFoodBinding.inflate(inflater, container, false);
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        FoodRecyclerViewAdapter adapter = new FoodRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);

        foodViewModel.getAllFood().observe(getActivity(), foodList -> {
            adapter.setFoodList(foodList);
            currentFoodList = foodList;
        });
    }

    @Override
    public void onItemClick(int position) {
        Food currentFood = currentFoodList.get(position);
        NavController navController = Navigation.findNavController(getView());

        // Navigate to the information page about the clicked food
        HomeFragmentDirections.ActionHomeFragmentToFoodInfoFragment action = HomeFragmentDirections
                .actionHomeFragmentToFoodInfoFragment(currentFood);
        navController.navigate(action);


    }


    /* Demo food generation

    public static List<Food> foods = new ArrayList<Food>();
    private static int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Food item) {
        foods.add(item);
    }

    private static Food createDummyItem(int index){
        Food dummyFood = new Food();
        dummyFood.setFoodName("Food " + String.valueOf(index));
        dummyFood.setFoodDescription("Item number " + String.valueOf(index));
        dummyFood.setFoodCalorie(String.valueOf(index * 100));
        dummyFood.setFoodAmount(2);
        return dummyFood;
    }

    */
}