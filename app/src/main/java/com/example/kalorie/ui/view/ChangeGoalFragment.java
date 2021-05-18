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
import com.example.kalorie.databinding.FragmentAddFoodBinding;
import com.example.kalorie.databinding.FragmentChangeGoalBinding;

public class ChangeGoalFragment extends Fragment {

    FragmentChangeGoalBinding binding;

    public ChangeGoalFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChangeGoalBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final NavController navController = Navigation.findNavController(view);
        super.onViewCreated(view, savedInstanceState);

        binding.fragmentChangeGoalBtnBack.setOnClickListener(v -> navController
               .navigate(R.id.action_changeGoalFragment_to_diarySettingsFragment));
        binding.fragmentChangeGoalBtnSave.setOnClickListener(v -> navController
               .navigate(R.id.action_changeGoalFragment_to_diarySettingsFragment));
    }
}