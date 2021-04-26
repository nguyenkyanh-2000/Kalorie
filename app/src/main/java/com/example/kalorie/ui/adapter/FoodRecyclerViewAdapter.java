package com.example.kalorie.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kalorie.R;
import com.example.kalorie.data.model.Food;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Food}
 */
public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder> {

    private List<Food> mValues;
    private FoodRecyclerViewInterface foodRecyclerViewInterface;

    public FoodRecyclerViewAdapter(List<Food> mValues, FoodRecyclerViewInterface foodRecyclerViewInterface) {
        this.mValues = mValues;
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
        holder.mNameView.setText(mValues.get(position).getFoodName());
        holder.mCalorieView.setText(mValues.get(position).getFoodCalorie());
        holder.mDetailsView.setText(mValues.get(position).getFoodDetails());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View mView;
        public TextView mNameView;
        public TextView mCalorieView;
        public TextView mDetailsView;

        public ViewHolder(View view){
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.item_food_name);
            mCalorieView = (TextView) view.findViewById(R.id.item_food_calorie);
            mDetailsView = (TextView) view.findViewById(R.id.item_food_details);
            itemView.setOnClickListener(v -> foodRecyclerViewInterface.onItemClick(getAdapterPosition()));
            itemView.setOnLongClickListener(v -> {
                foodRecyclerViewInterface.onLongItemClick(getAdapterPosition());
                return true;
            });
        }

    }

}