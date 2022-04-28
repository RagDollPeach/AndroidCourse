package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String operation;
    private String firstNumber;
    private String lastNumber;

    private final String num1 = "num1";
    private final String savedDisplay = "display";
    private final String num2 = "num2";
    private final String op = "operation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.editText);
        display.setShowSoftInputOnFocus(false);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(num1, firstNumber);
        bundle.putString(savedDisplay, display.getText().toString());
        bundle.putString(num2, lastNumber);
        bundle.putString(op, operation);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        firstNumber = bundle.getString(num1, "0");
        lastNumber = bundle.getString(num2, "0");
        operation = bundle.getString(op, "0");
        display.setText(firstNumber);
        display.setText(lastNumber);
        display.setText(operation);
        display.setText(bundle.getString(savedDisplay, "0"));
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
        lastNumber = display.getText().toString();
        double first = Double.parseDouble(firstNumber);
        double second = Double.parseDouble(lastNumber.substring(1));
        double result = calculator.calculate(operation, first, second);
        display.setText(String.valueOf(result));
    }

    public void clear(View view) {
        display.setText("");
    }
}