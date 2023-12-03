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
import android.widget.TextView;
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

    private final List<HoroscopeData> horoscopeDataList = new ArrayList<>();
    private View view;
    private RecyclerView recyclerView;  // Added RecyclerView field
    private ImageView imageView;  // Added ImageView field

    public HoroscopeFragment() {
        // Required empty public constructor
    }

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        prepareHoroscopeData();


        // reference the buttons from layout
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
    @Override
    public void onPause() {
        super.onPause();
        deleteAllItems();
    }

    private void deleteAllItems() {
        // Clear the horoscopeDataList
        horoscopeDataList.clear();

        // Notify the adapter that the data set has changed
        if (recyclerView.getAdapter() != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    private void prepareHoroscopeData() {
        HoroscopeAdapter horoscopeAdapter = new HoroscopeAdapter(requireContext(), horoscopeDataList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(horoscopeAdapter);



        HoroscopeData horoscopeData1 = new HoroscopeData("ARIES", "aries69", imageView);
        horoscopeDataList.add(horoscopeData1);

        HoroscopeData horoscopeData2 = new HoroscopeData("TAURUS", "taurus69", imageView);
        horoscopeDataList.add(horoscopeData2);

        HoroscopeData horoscopeData3 = new HoroscopeData("GEMINI", "gemini69", imageView);
        horoscopeDataList.add(horoscopeData3);

        HoroscopeData horoscopeData4 = new HoroscopeData("CANCER", "cancer69", imageView);
        horoscopeDataList.add(horoscopeData4);

        HoroscopeData horoscopeData5 = new HoroscopeData("LEO", "leo69", imageView);
        horoscopeDataList.add(horoscopeData5);

        HoroscopeData horoscopeData6 = new HoroscopeData("VIRGO", "virgo69", imageView);
        horoscopeDataList.add(horoscopeData6);

        HoroscopeData horoscopeData7 = new HoroscopeData("LIBRA", "libra69", imageView);
        horoscopeDataList.add(horoscopeData7);

        HoroscopeData horoscopeData8 = new HoroscopeData("SCORPIO", "scorpio69", imageView);
        horoscopeDataList.add(horoscopeData8);

        HoroscopeData horoscopeData9 = new HoroscopeData("SAGITTARIUS", "sagittarius69", imageView);
        horoscopeDataList.add(horoscopeData9);

        HoroscopeData horoscopeData10 = new HoroscopeData("CAPRICORN", "capricorn69", imageView);
        horoscopeDataList.add(horoscopeData10);

        HoroscopeData horoscopeData11 = new HoroscopeData("AQUARIUS", "aquarius69", imageView);
        horoscopeDataList.add(horoscopeData11);

        HoroscopeData horoscopeData12 = new HoroscopeData("PISCES", "pisces69", imageView);
        horoscopeDataList.add(horoscopeData12);

    }



}
