package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DirectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_direct);

        View view = findViewById(R.id.textCreate);
        view.setOnClickListener(this::clickCreate);
    }
    public void clickCreate(View view) {
        Intent intent = new Intent(getApplicationContext(), LineActivity.class);
        startActivity(intent);
    }
}