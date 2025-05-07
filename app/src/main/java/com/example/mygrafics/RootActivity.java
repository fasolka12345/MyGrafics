package com.example.mygrafics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RootActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_root);

        View createRoot = findViewById(R.id.textCreateRoot);
        createRoot.setOnClickListener(this::clickCreateRoot);

        View createYourselfRoot = findViewById(R.id.textCreateYourselfRoot);
        createYourselfRoot.setOnClickListener(this::clickCreateYourselfRoot);
    }
    public void clickCreateRoot(View view) {
        EditText editTexta2 = findViewById(R.id.editTexta2);
        EditText editTextb2 = findViewById(R.id.editTextb2);
        EditText editTextc2 = findViewById(R.id.editTextc2);
        Intent intent = new Intent(getApplicationContext(), LineRootActivity.class);
        intent.putExtra("a2", editTexta2.getText().toString());
        intent.putExtra("b2", editTextb2.getText().toString());
        intent.putExtra("c2", editTextc2.getText().toString());
        startActivity(intent);
    }

    public void clickCreateYourselfRoot(View view) {
        EditText editTexta2 = findViewById(R.id.editTexta2);
        EditText editTextb2 = findViewById(R.id.editTextb2);
        EditText editTextc2 = findViewById(R.id.editTextc2);
        Intent intent = new Intent(getApplicationContext(), LineRootYourselfActivity.class);
        intent.putExtra("a2", editTexta2.getText().toString());
        intent.putExtra("b2", editTextb2.getText().toString());
        intent.putExtra("c2", editTextc2.getText().toString());
        startActivity(intent);
    }
}