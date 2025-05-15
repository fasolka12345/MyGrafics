package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LineRootActivity extends AppCompatActivity {
    private Root rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Intent intent = getIntent();
        String a2 = intent.getStringExtra("a2");
        String b2 = intent.getStringExtra("b2");
        String c2 = intent.getStringExtra("c2");

        rootView = new Root(this, null);
        rootView.setA2(a2);
        rootView.setB2(b2);
        rootView.setC2(c2);
        setContentView(rootView);
    }
}