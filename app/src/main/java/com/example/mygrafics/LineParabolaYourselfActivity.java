package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LineParabolaYourselfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Intent intent = getIntent();
        String a1 = intent.getStringExtra("a1");
        String b1 = intent.getStringExtra("b1");
        String c1 = intent.getStringExtra("c1");

        setContentView(R.layout.activity_line_parabola_compare);
        ParabolaYourself parabolaYourselfView = findViewById(R.id.parabolaYourselfView);
        parabolaYourselfView.setA1(a1);
        parabolaYourselfView.setB1(b1);
        parabolaYourselfView.setC1(c1);

        View compareParabola = findViewById(R.id.textCompareParabola);
        compareParabola.setOnClickListener(this::clickCompareParabola);

        View exitParabola = findViewById(R.id.textExitParabolaYourself);
        exitParabola.setOnClickListener(this::clickExitParabolaYourself);
    }

    public void clickCompareParabola(View view) {
        ParabolaYourself parabolaYourselfView = findViewById(R.id.parabolaYourselfView);
        parabolaYourselfView.showFunction();
        parabolaYourselfView.invalidate();
    }

    public void clickExitParabolaYourself(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
