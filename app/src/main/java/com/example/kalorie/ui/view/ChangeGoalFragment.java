package com.example.kalorie.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.kalorie.R;
import com.example.kalorie.databinding.FragmentChangeGoalBinding;

import org.jetbrains.annotations.NotNull;

public class ChangeGoalFragment extends Fragment {

    FragmentChangeGoalBinding binding;

    public ChangeGoalFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChangeGoalBinding.inflate(inflater, container, false);
        return binding.getRoot();
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