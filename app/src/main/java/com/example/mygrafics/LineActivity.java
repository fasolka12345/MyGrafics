package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
        setContentView(R.layout.activity_line);
        Direct directView = findViewById(R.id.directView);
        directView.setK(k);
        directView.setB(b);

        View exitDirect = findViewById(R.id.textExitDirect);
        exitDirect.setOnClickListener(this::clickExitDirect);
    }

    public void clickExitDirect(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}