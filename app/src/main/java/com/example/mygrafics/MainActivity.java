package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.textView2);
        view.setOnClickListener(this::pushStart);
    }

    public void pushStart(View view) {
        Intent intent = new Intent(getApplicationContext(), GraficsActivity.class);
        startActivity(intent);
    }
}