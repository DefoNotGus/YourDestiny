package com.example.yourdestiny;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class HoroscopeDetails extends Fragment {

    TextView textView;

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
        return inflater.inflate(R.layout.fragment_horoscope_details, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.horoscopeTextView);
        String zodiacName = requireArguments().getString("zodiacName");
        populateHoroscope(zodiacName);
    }
    private void populateHoroscope(String zodiacName) { // Pass the zodiacName as a parameter
        RequestQueue mRequestQueue = Volley.newRequestQueue(requireContext()); // Use requireContext() instead of 'this'
        String url = "https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=" + zodiacName + "&day=TODAY";
        StringRequest mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject data = new JSONObject(response.toLowerCase());
                    textView.setText(data.getString("horoscope_data")); // Use getString instead of get
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error response
            }
        });

        mRequestQueue.add(mStringRequest); // Add the request to the request queue
    }

}