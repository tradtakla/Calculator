package com.appsandgamesinc.mycalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaCodec;
import android.os.Build;
import android.provider.ContactsContract;
import android.renderscript.Double2;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Editable;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity

{

    Button btnClear, btnMultiply, btnBack, btnSeven, btnEight, btnNine, btnDivid, btnSubstract, btnFour, btnFive, btnSix, btnAdd, btnOne, btnTwo, btnThree, btnParenthesis, btnZero, btnDecimal, btnAbsolut, btnEquals;
    TextView txtSolution, txtInput;
    String display = "";
    LinearLayout mLinearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnClear = (Button) findViewById(R.id.btnClear);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnDivid = (Button) findViewById(R.id.btnDivid);
        btnSubstract = (Button) findViewById(R.id.btnSubstract);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnParenthesis = (Button) findViewById(R.id.btnParenthesis);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnDecimal = (Button) findViewById(R.id.btnDecimal);
        btnAbsolut = (Button) findViewById(R.id.btnAbsolut);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        txtSolution = (TextView) findViewById(R.id.txtSolution);
        txtInput = (TextView) findViewById(R.id.txtInput);
        mLinearLayout = (LinearLayout) findViewById(R.id.cll);
        txtInput.setText("0");

        btnZero.setOnClickListener(clickListener);
        btnOne.setOnClickListener(clickListener);
        btnTwo.setOnClickListener(clickListener);
        btnThree.setOnClickListener(clickListener);
        btnFour.setOnClickListener(clickListener);
        btnFive.setOnClickListener(clickListener);
        btnSix.setOnClickListener(clickListener);
        btnSeven.setOnClickListener(clickListener);
        btnEight.setOnClickListener(clickListener);
        btnNine.setOnClickListener(clickListener);
        btnAdd.setOnClickListener(clickListener);
        btnSubstract.setOnClickListener(clickListener);
        btnMultiply.setOnClickListener(clickListener);
        btnDivid.setOnClickListener(clickListener);
        btnClear.setOnClickListener(clickListener);
        btnBack.setOnClickListener(clickListener);
        btnEquals.setOnClickListener(clickListener);

        btnZero.setOnTouchListener(touchListener);
        btnOne.setOnTouchListener(touchListener);
        btnTwo.setOnTouchListener(touchListener);
        btnThree.setOnTouchListener(touchListener);
        btnFour.setOnTouchListener(touchListener);
        btnFive.setOnTouchListener(touchListener);
        btnSix.setOnTouchListener(touchListener);
        btnSeven.setOnTouchListener(touchListener);
        btnEight.setOnTouchListener(touchListener);
        btnNine.setOnTouchListener(touchListener);
        btnAdd.setOnTouchListener(touchListener);
        btnSubstract.setOnTouchListener(touchListener);
        btnMultiply.setOnTouchListener(touchListener);
        btnDivid.setOnTouchListener(touchListener);
        btnClear.setOnTouchListener(touchListener);
        btnBack.setOnTouchListener(touchListener);
        btnEquals.setOnTouchListener(touchListener);


    }

    private View.OnTouchListener touchListener = new View.OnTouchListener()
    {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent)
        {
            switch (motionEvent.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    ((Button) view).setTextColor(Color.BLUE);
                    break;
                case MotionEvent.ACTION_UP:
                    ((Button)view).setTextColor(Color.BLACK);
                    break;
            }
            return false;
        }
    };

    private View.OnClickListener clickListener = new View.OnClickListener()
    {


        @Override
        public void onClick(View view)
        {

            switch (view.getId())
            {
                case R.id.btnZero:
                    numberClicked("0");
                    break;

                case R.id.btnOne:
                    numberClicked("1");
                    break;

                case R.id.btnTwo:
                    numberClicked("2");
                    break;

                case R.id.btnThree:
                    numberClicked("3");
                    break;

                case R.id.btnFour:
                    numberClicked("4");
                    break;

                case R.id.btnFive:
                    numberClicked("5");
                    break;

                case R.id.btnSix:
                    numberClicked("6");
                    break;

                case R.id.btnSeven:
                    numberClicked("7");
                    break;

                case R.id.btnEight:
                    numberClicked("8");
                    break;

                case R.id.btnNine:
                    numberClicked("9");
                    break;

                case R.id.btnAdd:
                    symbolClicked("+");
                    break;

                case R.id.btnSubstract:
                    symbolClicked("-");
                    break;

                case R.id.btnMultiply:
                    symbolClicked("*");
                    break;

                case R.id.btnDivid:
                    symbolClicked("/");
                    break;

                case R.id.btnClear:
                    clear();
                    break;

                case R.id.btnBack:
                    backspace();
                    break;

                case R.id.btnEquals:
                    equalsClicked();
                    break;


            }
        }
    };

    private void numberClicked(String number)
    {

        if (txtInput.getText().toString().equals("0") && !number.equals("0"))
        {
            txtInput.setText(number);
        }
        else
            txtInput.setText(txtInput.getText().toString() + number);
    }

    private void symbolClicked(String symbol)
    {

        String display = txtInput.getText().toString();
        String lastChar = display.substring(display.length() - 1);


        if (lastChar.equals("+") || lastChar.equals("-") || lastChar.equals("*") || lastChar.equals("/"))
        {
            txtInput.setText(display.substring(0, display.length() - 1) + symbol);
        }
        else if (!display.contains("+") && !display.contains("-") && !display.contains("*") && !display.contains("/"))
        {
            txtInput.setText(txtInput.getText().toString() + symbol);
        }
        else
        {
            txtInput.setText(txtInput.getText().toString());
        }
    }

    private void equalsClicked()
    {
        Double result;
        String input = "";
        input = input.concat(txtInput.getText().toString());
        String symbol = "";


        if (input.contains("+") || input.contains("-") || input.contains("*") || input.contains("/"))
        {
            if (input.contains("+"))
            {

                symbol = symbol.concat("+");
            }
            else if (input.contains("-"))
            {
                symbol = symbol.concat("-");
            }
            else if (input.contains("*"))
            {
                symbol = symbol.concat("*");
            }
            else
            {
                symbol = symbol.concat("/");
            }


            String[] string = input.split("\\" + symbol);

            switch (symbol)
            {
                case "+":
                    result = Double.parseDouble(string[0]) + Double.parseDouble(string[1]);
                    txtSolution.setText( "=" + result);
                    break;

                case "-":
                    result = Double.parseDouble(string[0]) - Double.parseDouble(string[1]);
                    txtSolution.setText("=" + result);

                    break;

                case "*":

                    result = Double.parseDouble(string[0]) * Double.parseDouble(string[1]);
                    txtSolution.setText("=" + result);

                    break;

                case "/":
                    if (Double.parseDouble(string[1]) == 0)
                    {
                        isZero();
                    }
                    else
                    {
                        result = Double.parseDouble(string[0]) / Double.parseDouble(string[1]);
                        txtSolution.setText("=" + result);
                    }
                    break;

                default:
                    break;

            }
        }
    }

    private void clear()
    {
        txtInput.setText("0");
        txtSolution.setText("");
    }

    private void backspace()
    {
        String string = txtInput.getText().toString();
        if (string.length() >= 2)
        {
            display = string.substring(0, string.length() - 1);
            txtInput.setText(display);
        }
        else
            txtInput.setText("0");
    }

    private void isZero()
    {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.popup, null);

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();

    }

}