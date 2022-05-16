package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.radiobutton.MaterialRadioButton;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String operation;
    private String firstNumber;
    private String lastNumber;

    private static final String NameSharedPreference = "LOGIN";
    private static final String appTheme = "APP_THEME";
    private static final int lightTheme = 0;
    private static final int nightTheme = 1;

    private final String num1 = "num1";
    private final String savedDisplay = "display";
    private final String num2 = "num2";
    private final String op = "operation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.my_theme_light));
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.edit_text);
        display.setShowSoftInputOnFocus(false);

        ScrollView scrollView = findViewById(R.id.scroll_view);
        MaterialRadioButton light = findViewById(R.id.radio_button_light);
        MaterialRadioButton night = findViewById(R.id.radio_button_night);

        initThemeChooser();

        if (light.isChecked()) {
            scrollView.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.sun));
        }
        if (night.isChecked()){
            scrollView.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.girl));
        }
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radio_button_light), lightTheme);
        initRadioButton(findViewById(R.id.radio_button_night), nightTheme);
        RadioGroup rg = findViewById(R.id.radio_group);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(lightTheme))).setChecked(true);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(v -> {
            setAppTheme(codeStyle);
            recreate();
        });
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(appTheme, codeStyle);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(appTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case lightTheme:
                return R.style.my_theme_light;
            case nightTheme:
                return R.style.my_theme_night;
        }
        return -1;
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
        firstNumber = bundle.getString(num1);
        lastNumber = bundle.getString(num2);
        operation = bundle.getString(op);
        display.setText(firstNumber);
        display.setText(lastNumber);
        display.setText(operation);
        display.setText(bundle.getString(savedDisplay));
    }

    public boolean checkNumber(String num, String pat) {
        Pattern pattern = Pattern.compile(pat);
        Matcher matcher = pattern.matcher(num);
        return !matcher.matches();
    }

    @SuppressLint("NonConstantResourceId")
    public void writeDigits(View view) {
        String patternForDigit = ".+\\.\\d*";
        String patternForOperation = "\\" + operation;
        String digit = display.getText().toString();
        switch (view.getId()) {
            case R.id.button_dot:
                if (checkNumber(digit, patternForDigit) && !digit.isEmpty() && checkNumber(digit, patternForOperation)) {
                    digit = digit + ".";
                }
                break;
            case R.id.button_0:
                if (digit.isEmpty() || digit.equals(operation)) {
                    digit = digit + "0.";
                } else {
                    digit = digit + "0";
                }
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
        if (operation == null || operation.equals("0")) {
            firstNumber = display.getText().toString();
            if (!firstNumber.isEmpty()) {
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
        }
    }

    public void equalsButton(View view) {
        Calculator calculator = new Calculator();
        if (firstNumber != null) {
            lastNumber = display.getText().toString();
            String secondNumber = lastNumber.replaceAll("[^\\d.]", "");
            if (!secondNumber.isEmpty()) {
                double first = Double.parseDouble(firstNumber);
                double second = Double.parseDouble(secondNumber);
                if (Objects.equals(operation, "/") && second == 0) {
                    display.setText("");
                    display.setHint("Ошибка / на 0");
                } else {
                    double result = calculator.calculate(operation, first, second);
                    display.setText(String.valueOf(result));
                    operation = null;
                    firstNumber = null;
                    lastNumber = null;
                }
            }
        }
    }

    public void clear(View view) {
        display.setText(null);
        firstNumber = null;
        lastNumber = null;
        operation = null;
        display.setHint("Введите число");
    }
}