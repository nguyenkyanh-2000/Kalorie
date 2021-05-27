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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.kalorie.R;
import com.example.kalorie.databinding.FragmentHomeBinding;

import org.jetbrains.annotations.NotNull;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class HomeFragment extends Fragment{

    FragmentHomeBinding binding;

    public HomeFragment() {}

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController navController = findNavController(this);
        super.onViewCreated(view, savedInstanceState);

        binding.fragmentHomeBtnAddFood.setOnClickListener(v -> navController
                .navigate(R.id.action_homeFragment_to_addFoodFragment));

    }

}