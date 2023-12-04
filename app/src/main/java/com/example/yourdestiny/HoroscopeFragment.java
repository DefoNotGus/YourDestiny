package com.example.yourdestiny;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HoroscopeFragment extends Fragment {

    // List to store HoroscopeData objects
    private final List<HoroscopeData> horoscopeDataList = new ArrayList<>();

    // View object to hold the fragment's layout
    private View view;

    // RecyclerView for displaying horoscope items
    private RecyclerView recyclerView;

    // ImageView for displaying images
    private ImageView imageView;

    // Default constructor
    public HoroscopeFragment() {
        // Required empty public constructor
    }

    // Called to create and return the view hierarchy associated with the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_horoscope, container, false);

        // Initialize views
        recyclerView = view.findViewById(R.id.recycler_view);  // Initialize RecyclerView
        imageView = view.findViewById(R.id.imageView);  // Initialize ImageView

        return view;
    }

    // Called after the view has been created
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        prepareHoroscopeData();

        // Reference the buttons from the layout
        Button calculatorBtnH = view.findViewById(R.id.calculatorBtnH);
        Button homeBtnH = view.findViewById(R.id.homeBtnH);

        // Set OnClickListener using lambda expression for calculator button
        calculatorBtnH.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_horoscopeFragment_to_calculatorFragment);
        });

        // Set OnClickListener using lambda expression for home button
        homeBtnH.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_horoscopeFragment_to_mainFragment);
        });
    }

    // Called when the fragment is paused
    @Override
    public void onPause() {
        super.onPause();
        deleteAllItems();
    }

    // Method to delete all items from the horoscopeDataList
    private void deleteAllItems() {
        // Clear the horoscopeDataList
        horoscopeDataList.clear();

        // Notify the adapter that the data set has changed
        if (recyclerView.getAdapter() != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    // Method to prepare sample HoroscopeData and populate RecyclerView
    private void prepareHoroscopeData() {
        // Create a HoroscopeAdapter and set it on the RecyclerView
        HoroscopeAdapter horoscopeAdapter = new HoroscopeAdapter(requireContext(), horoscopeDataList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(horoscopeAdapter);

        // Add sample HoroscopeData to the list
        for (int i = 1; i <= 12; i++) {
            String zodiacName = getZodiacName(i);
            String imageName = getZodiacImageName(i);

            // Create a new HoroscopeData object and add it to the list
            HoroscopeData horoscopeData = new HoroscopeData(zodiacName, imageName, imageView);
            horoscopeDataList.add(horoscopeData);
        }
    }

    // Helper method to get zodiac name based on its index
    private String getZodiacName(int index) {
        switch (index) {
            case 1:
                return "ARIES";
            case 2:
                return "TAURUS";
            case 3:
                return "GEMINI";
            case 4:
                return "CANCER";
            case 5:
                return "LEO";
            case 6:
                return "VIRGO";
            case 7:
                return "LIBRA";
            case 8:
                return "SCORPIO";
            case 9:
                return "SAGITTARIUS";
            case 10:
                return "CAPRICORN";
            case 11:
                return "AQUARIUS";
            case 12:
                return "PISCES";
            default:
                return "";
        }
    }

    // Helper method to get zodiac image name based on its index
    private String getZodiacImageName(int index) {
        return getZodiacName(index).toLowerCase() + "69";
    }
}
