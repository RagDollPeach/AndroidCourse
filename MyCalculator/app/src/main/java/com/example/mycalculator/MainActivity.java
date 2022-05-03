package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText onDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onDisplay = findViewById(R.id.editText);
        onDisplay.setShowSoftInputOnFocus(false);

    }

    private void writeDigits(String inputDigit) {
        String str = onDisplay.getText().toString();
        int pos = onDisplay.getSelectionStart();
        String leftStr = str.substring(0, pos);
        String rightStr = str.substring(pos);
        onDisplay.setText(String.format("%s%s%s", leftStr, inputDigit, rightStr));
        onDisplay.setSelection(pos + 1);
    }

    public void zeroButton(View view) {
        writeDigits("0");
    }

    public void oneButton(View view) {
        writeDigits("1");
    }

    public void twoButton(View view) {
        writeDigits("2");
    }

    public void threeButton(View view) {
        writeDigits("3");
    }

    public void fourButton(View view) {
        writeDigits("4");
    }

    public void fiveButton(View view) {
        writeDigits("5");
    }

    public void sixButton(View view) {
        writeDigits("6");
    }

    public void sevenButton(View view) {
        writeDigits("7");
    }

    public void eightButton(View view) {
        writeDigits("8");
    }

    public void nineButton(View view) {
        writeDigits("9");
    }

    public void dotButton(View view) {
        writeDigits(".");
    }

    public void divineButton(View view) {
        writeDigits("/");
    }

    public void multiplyButton(View view) {
        writeDigits("*");
    }

    public void minusButton(View view) {
        writeDigits("-");
    }

    public void plusButton(View view) {
        writeDigits("+");
    }

    public void equalsButton(View view) {
        String str = onDisplay.getText().toString();
        String[] saint = str.split("[\\d]");
        String[] digits = str.split("[\\D]");
        double firstDigit = Double.parseDouble(digits[0]);
        double secondDigit = Double.parseDouble(digits[1]);
        for (String s : saint) {
            if (s.equals("/")) {
                double result = firstDigit / secondDigit;
                onDisplay.setText(String.valueOf(result));
            }
            if (s.equals("*")) {
                double result = firstDigit * secondDigit;
                onDisplay.setText(String.valueOf(result));
            }
            if (s.equals("-")) {
                double result = firstDigit - secondDigit;
                onDisplay.setText(String.valueOf(result));
            }
            if (s.equals("+")) {
                double result = firstDigit + secondDigit;
                onDisplay.setText(String.valueOf(result));
            }
        }
    }

    public void clear(View view) {
        onDisplay.setText("");
    }
}