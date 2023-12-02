package com.example.yourdestiny;

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
    private TextView horoscopeTextView;
    private RequestQueue requestQueue;
    private View view;

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
        this.view = view;
        prepareHoroscopeData();



        // Initialize views
        horoscopeTextView = view.findViewById(R.id.horoscopeTextView);

        // Initialize Volley request queue
        requestQueue = Volley.newRequestQueue(requireContext());

        // Make API call
        fetchHoroscopeData();

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
    private void prepareHoroscopeData() {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        ImageView imageView = view.findViewById(R.id.imageView);

        HoroscopeAdapter horoscopeAdapter = new HoroscopeAdapter(requireContext(), horoscopeDataList);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(horoscopeAdapter);


        HoroscopeData horoscopeData = new HoroscopeData("ARIES", "aries69", imageView);
        horoscopeDataList.add(horoscopeData);
    }
    public void fetchHoroscopeData() {
        String apiUrl = "https://dog.ceo/api/breeds/image/random";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Parse the JSON response
                            String imageUrl = response.getString("message");

                            // Display the URL in TextView
                            horoscopeTextView.setText(imageUrl);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

        // Add the request to the RequestQueue
        requestQueue.add(request);
    }


}
