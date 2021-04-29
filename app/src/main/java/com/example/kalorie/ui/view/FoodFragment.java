package com.example.kalorie.ui.view;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kalorie.data.model.Food;
import com.example.kalorie.ui.adapter.FoodRecyclerViewAdapter;
import com.example.kalorie.R;
import com.example.kalorie.ui.adapter.FoodRecyclerViewInterface;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 */
public class FoodFragment extends Fragment implements FoodRecyclerViewInterface {

    public FoodFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list_food, container, false);
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new FoodRecyclerViewAdapter(foods,this));
        return view;
    }

    @Override
    public void onItemClick(int position) {
        // test toast
        Toast.makeText(getContext(), "short click", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLongItemClick(int position) {
        // test toast
        // long click works
        Toast.makeText(getContext(), "long click", Toast.LENGTH_LONG).show();
    }

    // Demo food generation

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

    private static Food createDummyItem(int position) {
        String pos = String.valueOf(position);
        return new Food(pos, "Food No." + pos
                ,  String.valueOf(position * 100), makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item ").append(position).append(".");
        return builder.toString();
    }

}