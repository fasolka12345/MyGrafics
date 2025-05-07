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

        setContentView(R.layout.activity_line_parabola);
        ParabolaYourself parabolaYourselfView = findViewById(R.id.parabolaYourselfView);
        parabolaYourselfView.setA1(a1);
        parabolaYourselfView.setB1(b1);
        parabolaYourselfView.setC1(c1);

        View compareDirect = findViewById(R.id.textCompareParabola);
        compareDirect.setOnClickListener(this::clickCompareParabola);
    }

    public void clickCompareParabola(View view) {
        Intent intent = new Intent(LineParabolaYourselfActivity.this, LineParabolaActivity.class);
        String a1 = getIntent().getStringExtra("a1");
        String b1 = getIntent().getStringExtra("b1");
        String c1 = getIntent().getStringExtra("c1");
        intent.putExtra("a1", a1);
        intent.putExtra("b1", b1);
        intent.putExtra("c1", c1);
        startActivity(intent);
    }
}