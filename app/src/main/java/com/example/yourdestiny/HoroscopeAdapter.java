package com.example.yourdestiny;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HoroscopeAdapter extends RecyclerView.Adapter<HoroscopeAdapter.HoroscopeViewHolder> {

    // List to store HoroscopeData objects
    List<HoroscopeData> horoscopeDataList;

    // Context to be used throughout the adapter
    private Context context;

    // Constructor to initialize the adapter with context and data list
    public HoroscopeAdapter(Context context, List<HoroscopeData> horoscopeDataList) {
        this.context = context;
        this.horoscopeDataList = horoscopeDataList;
    }

    // Called when RecyclerView needs a new ViewHolder
    @NonNull
    @Override
    public HoroscopeAdapter.HoroscopeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each list item
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horoscope_list_row, parent, false);
        return new HoroscopeViewHolder(itemView);
    }

    // Called to display the data at a specific position
    @Override
    public void onBindViewHolder(@NonNull HoroscopeAdapter.HoroscopeViewHolder holder, int position) {
        // Get the HoroscopeData object at the given position
        HoroscopeData horoscopeData = horoscopeDataList.get(position);

        // Set the zodiac name and image in the ViewHolder
        holder.zodiacName.setText(horoscopeData.zodiacName);
        int resId = context.getResources().getIdentifier(horoscopeData.zodiacImage, "drawable", "com.example.yourdestiny");
        holder.imageView.setBackgroundResource(resId);
    }

    // Returns the total number of items in the data set
    @Override
    public int getItemCount() {
        return horoscopeDataList.size();
    }

    // ViewHolder class to hold the views for each list item
    class HoroscopeViewHolder extends RecyclerView.ViewHolder {
        LinearLayout parent;
        TextView zodiacName;
        ImageView imageView;

        // Constructor for the ViewHolder
        public HoroscopeViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize views from the layout
            parent = itemView.findViewById(R.id.parent);
            zodiacName = itemView.findViewById(R.id.zodiacName);
            imageView = itemView.findViewById(R.id.imageView);

            // Set OnClickListener for the item view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Create a new instance of the HoroscopeDetails fragment
                    HoroscopeDetails horoscopeDetailsFragment = new HoroscopeDetails();

                    // Pass data to the fragment using arguments
                    Bundle bundle = new Bundle();
                    bundle.putString("zodiacName", zodiacName.getText().toString());
                    horoscopeDetailsFragment.setArguments(bundle);

                    // Get the fragment manager
                    FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();

                    // Start a fragment transaction
                    FragmentTransaction transaction = fragmentManager.beginTransaction();

                    // Replace the current fragment with the HoroscopeDetails fragment
                    transaction.replace(R.id.fragmentContainerView, horoscopeDetailsFragment);

                    // Add the transaction to the back stack (optional, but useful for navigating back)
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();
                }
            });
        }
    }
}
