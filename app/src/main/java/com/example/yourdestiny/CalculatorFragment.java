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
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class CalculatorFragment extends Fragment {

    private TextView dateResultTextView;
    private Button dateButton;
    public CalculatorFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);


        dateResultTextView = view.findViewById(R.id.dateResult);
        dateButton = view.findViewById(R.id.dateBtn);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateZodiacSign();
            }
        });
        return view;
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
    private void calculateZodiacSign() {
        // Get the date in DD/MM format
        EditText dateEditText = getView().findViewById(R.id.dateText);
        String userEnteredDate = dateEditText.getText().toString();

        // Extract day and month from the date
        String[] parts = userEnteredDate.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);

        // Calculate the zodiac sign
        String zodiacSign = getZodiacSign(day, month);

        // Display the result in the TextView
        dateResultTextView.setText("Your Zodiac Sign is " + zodiacSign);
    }

        private String getZodiacSign(int day, int month) {
            if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
                return "Aries";
            } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
                return "Taurus";
            } else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
                return "Gemini";
            } else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) {
                return "Cancer";
            } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
                return "Leo";
            } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
                return "Virgo";
            } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
                return "Libra";
            } else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
                return "Scorpio";
            } else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
                return "Sagittarius";
            } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
                return "Capricorn";
            } else if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
                return "Aquarius";
            } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
                return "Pisces";
            } else {
                return "Unknown";
            }
        }
    }

