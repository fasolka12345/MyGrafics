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

        View direct = findViewById(R.id.textDirect);
        direct.setOnClickListener(this::clickDirect);

        View parabola = findViewById(R.id.textParabola);
        parabola.setOnClickListener(this::clickParabola);

        View root = findViewById(R.id.textRoot);
        root.setOnClickListener(this::clickRoot);
    }

    public void clickDirect(View view) {
        Intent intent = new Intent(getApplicationContext(), DirectActivity.class);
        startActivity(intent);
    }

    public void clickParabola(View view) {
        Intent intent = new Intent(getApplicationContext(), ParabolaActivity.class);
        startActivity(intent);
    }

    public void clickRoot(View view) {
        Intent intent = new Intent(getApplicationContext(), RootActivity.class);
        startActivity(intent);
    }
}