package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LineRootActivity extends AppCompatActivity {
    private Root RootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Intent intent = getIntent();
        String a2 = intent.getStringExtra("a2");
        String b2 = intent.getStringExtra("b2");
        String c2 = intent.getStringExtra("c2");

        setContentView(R.layout.activity_line_root);
        Root RootView = findViewById(R.id.rootView);
        RootView.setA2(a2);
        RootView.setB2(b2);
        RootView.setC2(c2);

        View exitRoot = findViewById(R.id.textExitRoot);
        exitRoot.setOnClickListener(this::clickExitRoot);
    }

    public void clickExitRoot(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}