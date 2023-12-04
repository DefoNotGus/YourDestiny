package com.example.yourdestiny;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainFragment extends Fragment {

    private TextView welcomeMsg;
    private ImageView logo;
    private Handler longPressHandler;
    private boolean isLongPress = false;
    private static final int LONG_PRESS_DURATION = 3000; // 5 seconds

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        welcomeMsg = view.findViewById(R.id.welcomeMsg);
        logo = view.findViewById(R.id.logo);

        // Initialize YourAppDatabase
        HoroscopeDatabase horoscopeDatabase = new HoroscopeDatabase(requireContext());
        horoscopeDatabase.open();

        // Get the last record and set it to the TextView
        String lastRecord = horoscopeDatabase.getLastRecord();
        if (lastRecord != null) {
            welcomeMsg.setText(lastRecord);
        }

        // Close the database when done
        horoscopeDatabase.close();

        // Set up long-press detection on the logo ImageView
        longPressHandler = new Handler();
        logo.setOnLongClickListener(v -> {
            isLongPress = true;
            longPressHandler.postDelayed(longPressRunnable, LONG_PRESS_DURATION);
            return true;
        });

        logo.setOnClickListener(v -> {
            // Handle regular click event
            if (isLongPress) {
                // If it was a long press, isLongPress will be true
                isLongPress = false; // Reset the flag
                longPressHandler.removeCallbacks(longPressRunnable); // Remove the callback
                // Initialize the database and delete all records
                horoscopeDatabase.open();
                horoscopeDatabase.deleteAllRecords();
                horoscopeDatabase.close();

                //Display Instructions
                welcomeMsg.setText(R.string.tutorial);
            } else {
                // Handle regular click event
                // Add your regular click logic here
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //reference the buttons from layout
        Button calculatorBtn = view.findViewById(R.id.calculatorBtn);
        Button horoscopeBtn = view.findViewById(R.id.horoscopeBtn);

        // Set OnClickListener using lambda expression for navigation
        horoscopeBtn.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_horoscopeFragment);
        });
        // Set OnClickListener using lambda expression for navigation
        calculatorBtn.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_calculatorFragment);

        });
    }
    private final Runnable longPressRunnable = () -> {
        isLongPress = false; // Reset the flag
    };
}
