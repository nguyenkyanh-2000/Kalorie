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
import com.example.kalorie.databinding.FragmentNutrientCompositionBinding;

import org.jetbrains.annotations.NotNull;

public class NutrientCompositionFragment extends Fragment {

    FragmentNutrientCompositionBinding binding;

    public NutrientCompositionFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentNutrientCompositionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        view.setOnClickListener(v -> navController
                .navigate(R.id.action_homeFragment_to_diarySettingsFragment));

        // demo Progress Bars
        binding.progressBarCarbs.setProgress(30);
        binding.progressBarFats.setProgress(60);
        binding.progressBarProteins.setProgress(90);
        binding.textViewProgressCarbs.setText("30%");
        binding.textViewProgressFats.setText("60%");
        binding.textViewProgressProteins.setText("90%");
    }
}