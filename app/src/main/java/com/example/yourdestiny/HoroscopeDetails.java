package com.example.yourdestiny;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class HoroscopeDetails extends Fragment {

    TextView textView;
    private View view;
    private Button detailBackbtn;

    private RequestQueue requestQueue;

    public HoroscopeDetails() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horoscope_details, container, false);
        textView = view.findViewById(R.id.horoscopeText);
        detailBackbtn = view.findViewById(R.id.detailBackbtn);

        detailBackbtn.setOnClickListener(v -> {
            // Get the text from horoscopeText
            String horoscopeDetails = textView.getText().toString();

            // Insert the text into the database
            HoroscopeDatabase appDatabase = new HoroscopeDatabase(requireContext());
            appDatabase.open();
            appDatabase.insertData(horoscopeDetails);
            appDatabase.close();

            // Destroy the current fragment
            requireActivity().getSupportFragmentManager().popBackStack();
        });
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize Volley request queue
        requestQueue = Volley.newRequestQueue(requireContext());
        String zodiacName = requireArguments().getString("zodiacName");
        populateHoroscope(zodiacName);

    }

    public void populateHoroscope(String zodiacName) {
        String apiUrl = "https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=" + zodiacName.toLowerCase() + "&day=TODAY";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, apiUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Parse the JSON response
                            String data = response.getJSONObject("data").getString("horoscope_data");

                            // Display the URL in TextView
                            textView.setText(data);
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