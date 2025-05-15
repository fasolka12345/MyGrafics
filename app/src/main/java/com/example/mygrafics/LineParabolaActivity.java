package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LineParabolaActivity extends AppCompatActivity {
    private Parabola parabolaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Intent intent = getIntent();
        String a1 = intent.getStringExtra("a1");
        String b1 = intent.getStringExtra("b1");
        String c1 = intent.getStringExtra("c1");

        setContentView(R.layout.activity_line_parabola);
        Parabola parabolaView = findViewById(R.id.parabolaView);
        parabolaView.setA1(a1);
        parabolaView.setB1(b1);
        parabolaView.setC1(c1);

        View exitParabola = findViewById(R.id.textExitParabola);
        exitParabola.setOnClickListener(this::clickExitParabola);
    }

    public void clickExitParabola(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}