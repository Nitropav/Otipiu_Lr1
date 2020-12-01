package com.example.troshkocalc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    String pi = "3.14159265";
    String exp = "2.71828182";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }

            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void zeroBTN(View view){
        updateText("0");

    }
    public void oneBTN(View view){
        updateText("1");

    }

    public void twoBTN(View view){
        updateText("2");

    }

    public void threeBTN(View view){
        updateText("3");

    }

    public void fourBTN(View view){
        updateText("4");

    }

    public void fiveBTN(View view){
        updateText("5");

    }

    public void sixBTN(View view){
        updateText("6");

    }

    public void sevenBTN(View view){
        updateText("7");

    }
    public void eightBTN(View view){
        updateText("8");

    }
    public void nineBTN(View view){
        updateText("9");

    }
    public void clearBTN(View view){
        display.setText("");

    }

    public void exponentBTN(View view){
        updateText("^");

    }

    public void parenthesesBTN(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++){
            if (display.getText().toString().substring(i, i+1).equals("(")){
                openPar += 1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")){
                closedPar += 1;
            }
        }

        if (openPar == closedPar || display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText("(");
            display.setSelection(cursorPos + 1);
        }
        else if (closedPar < openPar && !display.getText().toString().substring(textLen-1, textLen).equals("(")){
            updateText(")");
        }
        display.setSelection(cursorPos + 1);
    }

    public void divideBTN(View view){
        updateText("÷");

    }
    public void multiplyBTN(View view){
        updateText("×");

    }
    public void addBTN(View view){
        updateText("+");

    }

    public void subtractBTN(View view){
        updateText("-");

    }
    public void pointBTN(View view){
        updateText(".");

    }
    public void equalsBTN(View view){

        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());

    }
    public void backspaceBTN(View view){

        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }


    public void sinusBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {

            double val = Double.parseDouble(display.getText().toString());
            double r = Math.sin(Math.toRadians(val));
            display.setText(String.valueOf(r));
            display.setSelection(String.valueOf(r).length());
        }

    }

    public void cosineBTN(View view) {

        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){

            double val = Double.parseDouble(display.getText().toString());
            double r = Math.cos(Math.toRadians(val));
            display.setText(String.valueOf(r));
            display.setSelection(String.valueOf(r).length());}

    }
    public void tangentBTN(View view) {

        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            double val = Double.parseDouble(display.getText().toString());
            double r = Math.tan(Math.toRadians(val));
            display.setText(String.valueOf(r));
            display.setSelection(String.valueOf(r).length());}

    }

    public void factorialBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            int val = Integer.parseInt(display.getText().toString());
            int fact = factorial(val);
            display.setText(String.valueOf(fact));
            display.setSelection(String.valueOf(fact).length()); }

    }
    int factorial(int n){
        return (n==1 || n==0) ? 1 : n*factorial(n-1);
    }

    public void sqrtBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            String val = display.getText().toString();
            double r = Math.sqrt(Double.parseDouble(val));
            display.setText(String.valueOf(r));
            display.setSelection(String.valueOf(r).length());}

    }

    public void piBTN(View view) {

        int cursorPos = display.getSelectionStart();
        updateText("3.14159265");
        display.setSelection(cursorPos + 10);

    }

    public void expBTN(View view) {
        int cursorPos = display.getSelectionStart();
        updateText("2.71828182");
        display.setSelection(cursorPos + 10);
    }

    public void logBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            double val = Double.parseDouble(display.getText().toString());
            double r = Math.log10(val);
            display.setText(String.valueOf(r));
            display.setSelection(String.valueOf(r).length());}


    }

    public void lnBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            double val = Double.parseDouble(display.getText().toString());
            double r = Math.log(val);
            display.setText(String.valueOf(r));
            display.setSelection(String.valueOf(r).length());}


    }

    public void reversBTN(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            double val = Double.parseDouble(display.getText().toString());
            double r = Math.pow(val, -1);
            display.setText(String.valueOf(r));
            display.setSelection(String.valueOf(r).length());}

    }
}

