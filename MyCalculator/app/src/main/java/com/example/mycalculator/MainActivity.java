package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String operation;
    private String firstNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.editText);
        display.setShowSoftInputOnFocus(false);
    }

    @SuppressLint("NonConstantResourceId")
    public void writeDigits(View view) {
        String digit = display.getText().toString();
        switch (view.getId()) {
            case R.id.button_dot:
                digit = digit + ".";
                break;
            case R.id.button_0:
                digit = digit + "0";
                break;
            case R.id.button_1:
                digit = digit + "1";
                break;
            case R.id.button_2:
                digit = digit + "2";
                break;
            case R.id.button_3:
                digit = digit + "3";
                break;
            case R.id.button_4:
                digit = digit + "4";
                break;
            case R.id.button_5:
                digit = digit + "5";
                break;
            case R.id.button_6:
                digit = digit + "6";
                break;
            case R.id.button_7:
                digit = digit + "7";
                break;
            case R.id.button_8:
                digit = digit + "8";
                break;
            case R.id.button_9:
                digit = digit + "9";
                break;
        }
        display.setText(digit);
    }

    @SuppressLint("NonConstantResourceId")
    public void operations(View view) {
        firstNumber = display.getText().toString();
        switch (view.getId()) {
            case R.id.button_divine:
                operation = "/";
                break;
            case R.id.button_multiply:
                operation = "*";
                break;
            case R.id.button_minus:
                operation = "-";
                break;
            case R.id.button_plus:
                operation = "+";
                break;
        }
        display.setText(operation);
    }

    public void equalsButton(View view) {
        Calculator calculator = new Calculator();
        String lastNumber = display.getText().toString();
        double first = Double.parseDouble(firstNumber);
        double second = Double.parseDouble(lastNumber.substring(1));
        double result = calculator.calculate(operation, first, second);
        display.setText(String.valueOf(result));
    }

    public void clear(View view) {
        display.setText("");
    }
}