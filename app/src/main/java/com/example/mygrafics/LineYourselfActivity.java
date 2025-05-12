package com.example.mygrafics;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LineYourselfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Intent intent = getIntent();
        String k = intent.getStringExtra("k");
        String b = intent.getStringExtra("b");

        setContentView(R.layout.activity_line);
        DirectYourself directYourselfView = findViewById(R.id.directYourselfView);
        directYourselfView.setK(k);
        directYourselfView.setB(b);

        View compareDirect = findViewById(R.id.textCompareDirect);
        compareDirect.setOnClickListener(this::clickCompareDirect);
    }

    public void clickCompareDirect(View view) {
        DirectYourself directYourselfView = findViewById(R.id.directYourselfView);
        directYourselfView.showFunction();
        directYourselfView.invalidate();
    }
}
