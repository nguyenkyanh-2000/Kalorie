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

        foodViewModel.getAllFood().observe(getActivity(), foodList -> {
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