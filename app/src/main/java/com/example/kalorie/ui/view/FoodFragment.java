package com.example.kalorie.ui.view;

import android.content.Context;
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
import android.widget.Button;
import android.widget.Toast;

import com.example.kalorie.data.model.Food;
import com.example.kalorie.ui.adapter.FoodRecyclerViewAdapter;
import com.example.kalorie.R;
import com.example.kalorie.ui.adapter.FoodRecyclerViewInterface;
import com.example.kalorie.ui.viewmodel.FoodViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 */
public class FoodFragment extends Fragment implements FoodRecyclerViewInterface {

    FoodViewModel foodViewModel;
    public static List<Food> foodList;

    public FoodFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item_list_food, container, false);

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        FoodRecyclerViewAdapter adapter = new FoodRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);

        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
        foodViewModel.getAllFood().observe(getActivity(), new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foods) {
                adapter.setFoodList(foods);
                foodList = foods;
            }
        });

        return view;
    }


    @Override
    public void onItemClick(int position) {
        Food currentFood = foodList.get(position);
        NavController nav = Navigation.findNavController(getView());
        HomeFragmentDirections.ActionHomeFragmentToFoodInfoFragment action = HomeFragmentDirections
                .actionHomeFragmentToFoodInfoFragment(currentFood);
        nav.navigate(action);
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