package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();

        ImageView pizza = (ImageView) findViewById(R.id.pizza_image);
        if(bundle!=null){
            int resId = bundle.getInt("resId");
            pizza.setImageResource(resId);
        }

    }
}
