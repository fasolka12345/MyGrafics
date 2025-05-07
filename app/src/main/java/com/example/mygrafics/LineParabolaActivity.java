package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;

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

        parabolaView = new Parabola(this, null);
        parabolaView.setA1(a1);
        parabolaView.setB1(b1);
        parabolaView.setC1(c1);
        setContentView(parabolaView);
    }
}