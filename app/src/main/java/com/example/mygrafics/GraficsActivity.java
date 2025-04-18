package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class GraficsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grafics);

        View view = findViewById(R.id.textDirect);
        view.setOnClickListener(this::clickDirect);
    }

    public void clickDirect(View view) {
        Intent intent = new Intent(getApplicationContext(), DirectActivity.class);
        startActivity(intent);
    }
}