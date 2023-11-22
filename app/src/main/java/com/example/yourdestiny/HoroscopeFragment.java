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

public class HoroscopeFragment extends Fragment {

    public HoroscopeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_horoscope, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //reference the buttons from layout
        Button calculatorBtnH = view.findViewById(R.id.calculatorBtnH);
        Button homeBtnH = view.findViewById(R.id.homeBtnH);

        // Set OnClickListener using lambda expression
        calculatorBtnH.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_horoscopeFragment_to_calculatorFragment);
        });
        // Set OnClickListener using lambda expression
        homeBtnH.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_horoscopeFragment_to_mainFragment);

        });
    }
}