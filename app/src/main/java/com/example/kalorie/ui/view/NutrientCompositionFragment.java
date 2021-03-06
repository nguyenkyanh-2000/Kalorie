package com.example.kalorie.ui.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.kalorie.R;
import com.example.kalorie.databinding.FragmentNutrientCompositionBinding;
import com.example.kalorie.ui.viewmodel.FoodViewModel;
import com.example.kalorie.ui.viewmodel.MealViewModel;

import org.jetbrains.annotations.NotNull;

public class NutrientCompositionFragment extends Fragment {

    FragmentNutrientCompositionBinding binding;
    MealViewModel mealViewModel;

    public NutrientCompositionFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentNutrientCompositionBinding.inflate(inflater, container, false);
        mealViewModel = new ViewModelProvider(getActivity()).get(MealViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        Log.v("Date changed", "Nothing");
        MutableLiveData<String> liveData = navController.getCurrentBackStackEntry()
                .getSavedStateHandle()
                .getLiveData("date");
        liveData.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getActivity(),s, Toast.LENGTH_LONG).show();
                Log.v("Date changed", s);
            }
        });

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