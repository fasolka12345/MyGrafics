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

        View start = findViewById(R.id.textStart);
        start.setOnClickListener(this::pushStart);

        View about = findViewById(R.id.textAbout);
        about.setOnClickListener(this::pushAbout);

        View exit = findViewById(R.id.textExit);
        exit.setOnClickListener(this::pushExit);

    }

    public void pushStart(View view) {
        Intent intent = new Intent(getApplicationContext(), GraficsActivity.class);
        startActivity(intent);
    }

    public void pushAbout(View view) {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    public void pushExit(View view) {
        finishAndRemoveTask();
    }
}