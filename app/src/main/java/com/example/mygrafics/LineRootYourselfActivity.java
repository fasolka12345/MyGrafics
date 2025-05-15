package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LineRootYourselfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Intent intent = getIntent();
        String a2 = intent.getStringExtra("a2");
        String b2 = intent.getStringExtra("b2");
        String c2 = intent.getStringExtra("c2");

        setContentView(R.layout.activity_line_root_compare);
        RootYourself rootYourselfView = findViewById(R.id.rootYourselfView);
        rootYourselfView.setA2(a2);
        rootYourselfView.setB2(b2);
        rootYourselfView.setC2(c2);

        View compareRoot = findViewById(R.id.textCompareRoot);
        compareRoot.setOnClickListener(this::clickCompareRoot);

        View exitRoot = findViewById(R.id.textExitRoot);
        exitRoot.setOnClickListener(this::clickExitRootYourself);
    }

    public void clickCompareRoot(View view) {
        RootYourself RootYourselfView = findViewById(R.id.rootYourselfView);
        RootYourselfView.showFunction();
        RootYourselfView.invalidate();
    }

    public void clickExitRootYourself(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
