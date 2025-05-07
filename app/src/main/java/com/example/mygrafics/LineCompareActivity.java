package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LineCompareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Intent intent = getIntent();
        String k = intent.getStringExtra("k");
        String b = intent.getStringExtra("b");

        setContentView(R.layout.activity_line_compare);
        Direct directView = findViewById(R.id.directView);
        directView.setK(k);
        directView.setB(b);
    }
}
