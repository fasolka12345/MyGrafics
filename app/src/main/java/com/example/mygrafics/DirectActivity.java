package com.example.mygrafics;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DirectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_direct);

        View create = findViewById(R.id.textCreateDirect);
        create.setOnClickListener(this::clickCreateDirect);

        View createYourself = findViewById(R.id.textCreateYourselfDirect);
        createYourself.setOnClickListener(this::clickCreateYourselfDirect);

        View back = findViewById(R.id.textBack);
        back.setOnClickListener(this::clickBackDirect);
    }
    public void clickCreateDirect(View view) {
        EditText editTextk = findViewById(R.id.editTextk);
        EditText editTextb = findViewById(R.id.editTextb);
        Intent intent = new Intent(getApplicationContext(), LineActivity.class);
        intent.putExtra("k", editTextk.getText().toString());
        intent.putExtra("b", editTextb.getText().toString());
        startActivity(intent);
    }

    public void clickCreateYourselfDirect(View view) {
        EditText editTextk = findViewById(R.id.editTextk);
        EditText editTextb = findViewById(R.id.editTextb);
        Intent intent = new Intent(getApplicationContext(), LineYourselfActivity.class);
        intent.putExtra("k", editTextk.getText().toString());
        intent.putExtra("b", editTextb.getText().toString());
        startActivity(intent);
    }

    public void clickBackDirect(View view) {
        finishAndRemoveTask();
    }
}