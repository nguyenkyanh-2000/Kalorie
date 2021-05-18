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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kalorie.R;

public class NutrientCompositionFragment extends Fragment {

    public NutrientCompositionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nutrient_composition, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        final NavController navController = Navigation.findNavController(view);
        view.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_diarySettingsFragment));

        ProgressBar progressBar_proteins = view.findViewById(R.id.progress_bar_proteins);
        ProgressBar progressBar_fats = view.findViewById(R.id.progress_bar_fats);
        ProgressBar progressBar_carbs = view.findViewById(R.id.progress_bar_carbs);
        TextView textView_proteins = view.findViewById(R.id.text_view_progress_proteins);
        TextView textView_fats = view.findViewById(R.id.text_view_progress_fats);
        TextView textView_carbs = view.findViewById(R.id.text_view_progress_carbs);

        // demo Progress Bars
        progressBar_carbs.setProgress(30);
        progressBar_fats.setProgress(60);
        progressBar_proteins.setProgress(90);
        textView_carbs.setText("30%");
        textView_fats.setText("60%");
        textView_proteins.setText("90%");

    }
}