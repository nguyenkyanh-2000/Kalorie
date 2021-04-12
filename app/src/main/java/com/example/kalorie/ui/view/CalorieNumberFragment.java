package com.example.kalorie.ui.view;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.kalorie.ui.viewmodel.CalorieNumberViewModel;
import com.example.kalorie.R;

public class CalorieNumberFragment extends Fragment {

    private CalorieNumberViewModel mViewModel;

    public static CalorieNumberFragment newInstance() {
        return new CalorieNumberFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calorie_number_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CalorieNumberViewModel.class);
        // TODO: Use the ViewModel
    }

}