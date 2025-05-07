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

        setContentView(R.layout.activity_line_root);
        RootYourself rootYourselfView = findViewById(R.id.rootYourselfView);
        rootYourselfView.setA2(a2);
        rootYourselfView.setB2(b2);
        rootYourselfView.setC2(c2);

        View compareDirect = findViewById(R.id.textCompareRoot);
        compareDirect.setOnClickListener(this::clickCompareRoot);
    }

    public void clickCompareRoot(View view) {
        Intent intent = new Intent(LineRootYourselfActivity.this, LineRootActivity.class);
        String a2 = getIntent().getStringExtra("a2");
        String b2 = getIntent().getStringExtra("b2");
        String c2 = getIntent().getStringExtra("c2");
        intent.putExtra("a2", a2);
        intent.putExtra("b2", b2);
        intent.putExtra("c2", c2);
        startActivity(intent);
    }
}