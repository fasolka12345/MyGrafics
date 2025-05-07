package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ParabolaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_parabola);

        View createParabola = findViewById(R.id.textCreateParabola);
        createParabola.setOnClickListener(this::clickCreateParabola);

        View createYourselfParabola = findViewById(R.id.textCreateYourselfParabola);
        createYourselfParabola.setOnClickListener(this::clickCreateYourselfParabola);
    }
    public void clickCreateParabola(View view) {
        EditText editTexta1 = findViewById(R.id.editTexta1);
        EditText editTextb1 = findViewById(R.id.editTextb1);
        EditText editTextc1 = findViewById(R.id.editTextc1);
        Intent intent = new Intent(getApplicationContext(), LineParabolaActivity.class);
        intent.putExtra("a1", editTexta1.getText().toString());
        intent.putExtra("b1", editTextb1.getText().toString());
        intent.putExtra("c1", editTextc1.getText().toString());
        startActivity(intent);
    }

    public void clickCreateYourselfParabola(View view) {
        EditText editTexta1 = findViewById(R.id.editTexta1);
        EditText editTextb1 = findViewById(R.id.editTextb1);
        EditText editTextc1 = findViewById(R.id.editTextc1);
        Intent intent = new Intent(getApplicationContext(), LineParabolaYourselfActivity.class);
        intent.putExtra("a1", editTexta1.getText().toString());
        intent.putExtra("b1", editTextb1.getText().toString());
        intent.putExtra("c1", editTextc1.getText().toString());
        startActivity(intent);
    }
}