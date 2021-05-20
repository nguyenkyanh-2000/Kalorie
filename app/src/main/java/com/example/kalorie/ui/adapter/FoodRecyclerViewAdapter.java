package com.example.kalorie.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kalorie.R;
import com.example.kalorie.data.model.Food;
import com.example.kalorie.databinding.FragmentItemFoodBinding;

import java.util.ArrayList;
import java.util.List;


public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder> {

    private final FoodRecyclerViewInterface foodRecyclerViewInterface;
    private static List<Food> foodList = new ArrayList<>();

    public FoodRecyclerViewAdapter( FoodRecyclerViewInterface foodRecyclerViewInterface) {
        this.foodRecyclerViewInterface = foodRecyclerViewInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Food currentFood = foodList.get(position);
        holder.mNameView.setText(currentFood.getFoodName());
        holder.mCalorieView.setText(String.valueOf(currentFood.getFoodCalorie()));
        holder.mDetailsView.setText(currentFood.getFoodDescription());
    }

    public void setFoodList(List<Food> foodList){
        this.foodList = foodList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View mView;
        public TextView mNameView;
        public TextView mCalorieView;
        public TextView mDetailsView;

        public ViewHolder(View view){
            super(view);
            mView = view;
            mNameView = view.findViewById(R.id.item_food_name);
            mCalorieView = view.findViewById(R.id.item_food_calorie);
            mDetailsView = view.findViewById(R.id.item_food_description);
            itemView.setOnClickListener(v -> foodRecyclerViewInterface.onItemClick(getBindingAdapterPosition()));
        }

    }

}