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

public class ChangeGoalFragment extends Fragment {


    public ChangeGoalFragment() {
        // Required empty public constructor
    }


    public static ChangeGoalFragment newInstance(String param1, String param2) {
        ChangeGoalFragment fragment = new ChangeGoalFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_change_goal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController navController = Navigation.findNavController(view);
        super.onViewCreated(view, savedInstanceState);

        Button btn_change_goal_back = view.findViewById(R.id.fragment_change_goal_btn_back);
        btn_change_goal_back.setOnClickListener(v -> navController.navigate(R.id.action_changeGoalFragment_to_diarySettingsFragment));

        Button btn_change_goal_save = view.findViewById(R.id.fragment_change_goal_btn_save);
        btn_change_goal_save.setOnClickListener(v -> navController.navigate(R.id.action_changeGoalFragment_to_diarySettingsFragment));
    }
}