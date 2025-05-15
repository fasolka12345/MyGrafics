package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        setContentView(R.layout.activity_line_compare);
        DirectYourself directYourselfView = findViewById(R.id.directYourselfView);
        directYourselfView.setK(k);
        directYourselfView.setB(b);

        View compareDirect = findViewById(R.id.textCompareDirect);
        compareDirect.setOnClickListener(this::clickCompareDirect);

        View exitDirect = findViewById(R.id.textExitDirectYourself);
        exitDirect.setOnClickListener(this::clickExitDirectYourself);

        View back = findViewById(R.id.textBack);
        back.setOnClickListener(this::clickBack);
    }

    public void clickCompareDirect(View view) {
        DirectYourself directYourselfView = findViewById(R.id.directYourselfView);
        directYourselfView.showFunction();
        directYourselfView.invalidate();
    }

    public void clickExitDirectYourself(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public void clickBack(View view) {
        finishAndRemoveTask();
    }
}
