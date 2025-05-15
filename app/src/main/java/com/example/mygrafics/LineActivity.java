package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LineActivity extends AppCompatActivity {
    private Direct directView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Intent intent = getIntent();
        String k = intent.getStringExtra("k");
        String b = intent.getStringExtra("b");

        directView = new Direct(this, null);
        directView.setK(k);
        directView.setB(b);
        setContentView(directView);

    }
}