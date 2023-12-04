package com.example.yourdestiny;

import android.widget.ImageView;

public class HoroscopeData {
    String  zodiacName;
    String zodiacImage;
    ImageView imageView;

    // Construct to define data on Horoscope RecyclerView
    public HoroscopeData(String zodiacName, String zodiacImage, ImageView imageView) {
        this.zodiacName = zodiacName;
        this.zodiacImage = zodiacImage;
        this.imageView = imageView;
    }
}
