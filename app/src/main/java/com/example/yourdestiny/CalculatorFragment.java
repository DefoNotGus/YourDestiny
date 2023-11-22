package com.example.yourdestiny;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CalculatorFragment extends Fragment {


    public CalculatorFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //reference the buttons from layout
        Button horoscopeBtn = view.findViewById(R.id.horoscopeBtnC);
        Button homeBtn = view.findViewById(R.id.homeBtnC);

        // Set OnClickListener using lambda expression
        horoscopeBtn.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_calculatorFragment_to_horoscopeFragment);
        });
        // Set OnClickListener using lambda expression
        homeBtn.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_calculatorFragment_to_mainFragment);
        });
    }
}
