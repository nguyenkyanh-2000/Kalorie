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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kalorie.R;

public class DiarySettingsFragment extends Fragment {

    public DiarySettingsFragment() {

    }

    public static DiarySettingsFragment newInstance(String param1, String param2) {
        DiarySettingsFragment fragment = new DiarySettingsFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController navController = Navigation.findNavController(view);
        super.onViewCreated(view, savedInstanceState);

        Button btn_add_food_back = view.findViewById(R.id.fragment_diary_settings_btn_back);
        btn_add_food_back.setOnClickListener(v -> navController.navigate(R.id.action_diarySettingsFragment_to_homeFragment));

        Button btn_add_food_change_date = view.findViewById(R.id.fragment_diary_settings_btn_change_date);

        Button btn_add_food_change_goals = view.findViewById(R.id.fragment_diary_settings_btn_change_goals);
        btn_add_food_change_goals.setOnClickListener(v -> navController.navigate(R.id.action_diarySettingsFragment_to_changeGoalFragment));

        ProgressBar progressBar_calories = view.findViewById(R.id.progress_bar_calories);
        TextView textView_calories = view.findViewById(R.id.text_view_progress_calories);

        progressBar_calories.setProgress(50);
        textView_calories.setText("50%");




    }
}