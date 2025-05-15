package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about); //

        View start = findViewById(R.id.textView13);
        start.setOnClickListener(this::clickStart);

        View back = findViewById(R.id.textView10);
        back.setOnClickListener(this::clickBackAbout);//
    }
    public void clickStart(View view) {
        Intent intent = new Intent(getApplicationContext(), GraficsActivity.class);
        startActivity(intent);
    }

    public void clickBackAbout(View view) {
        finishAndRemoveTask();
    }
}
