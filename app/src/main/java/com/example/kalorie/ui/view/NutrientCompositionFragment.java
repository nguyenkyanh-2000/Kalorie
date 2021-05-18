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
import com.example.kalorie.databinding.FragmentAddFoodBinding;
import com.example.kalorie.databinding.FragmentHomeBinding;
import com.example.kalorie.databinding.FragmentNutrientCompositionBinding;

public class NutrientCompositionFragment extends Fragment {

    FragmentNutrientCompositionBinding binding;

    public NutrientCompositionFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentNutrientCompositionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
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