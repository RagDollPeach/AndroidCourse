package com.example.hllogeegbrains;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SideActivity extends AppCompatActivity implements View.OnClickListener {

    private Button switchButton;
    private Button calendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);

        switchButton = findViewById(R.id.button2);
        switchButton.setOnClickListener(this);

        calendarButton = findViewById(R.id.calendarButton);
        calendarButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button2) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.calendarButton) {
            Intent intent = new Intent(this, CalendarActivity.class);
            startActivity(intent);
        }
    }
}