package com.example.myworkpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ImageView imageView = findViewById(R.id.show_data);
        String url_data  = "https://site-assets.mediaoxide.com/workpointtv/2020/08/19051135/AUG19.jpg";
        Picasso.get().load(url_data).into(imageView);
    }
}