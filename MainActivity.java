package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.appsearch.SearchResult;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;

import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTv, solutionTv;
    MaterialButton clear, brackets, percent, divide, multiply, subtraction, summation, equals;
    MaterialButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
    MaterialButton negative, point, button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

      assignId(clear, R.id.button_c);
        assignId(brackets, R.id.button_bracket);
        assignId(percent, R.id.button_percent);
        assignId(divide, R.id.button_divide);
        assignId(multiply, R.id.button_multiply);
        assignId(subtraction, R.id.button_substraction);
        assignId(summation, R.id.button_summation);
        assignId(equals, R.id.button_equals);
        assignId(button1, R.id.button_1);
        assignId(button2, R.id.button_2);
        assignId(button3, R.id.button_3);
        assignId(button4, R.id.button_4);
        assignId(button5, R.id.button_5);
        assignId(button6, R.id.button_6);
        assignId(button7, R.id.button_7);
        assignId(button8, R.id.button_8);
        assignId(button9, R.id.button_9);
        assignId(negative, R.id.button_negative);
        assignId(point, R.id.button_decimal);
        assignId(button0, R.id.button_0);


    }
    void assignId(MaterialButton btn, int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();


        if (buttonText.equals("AC"))
        {
            solutionTv.setText("");
            resultTv.setText("");
            return;
        }
        if (buttonText.equals("="))
        {
            solutionTv.setText(resultTv.getText());
            return;
        }
        if (buttonText.equals("C"))
        {
            if (dataToCalculate.equals(""))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("0"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("("))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals(")"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("/"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("*"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("-"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("+"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("."))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("1"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("2"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("3"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("4"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("5"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("6"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("7"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("8"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            if (dataToCalculate.equals("9"))
            {
                solutionTv.setText("");
                resultTv.setText("");
                return;
            }
            else
            {
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
            }

        }
        else
        {
            dataToCalculate = dataToCalculate + buttonText;
        }

        solutionTv.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if (!finalResult.equals("Err"))
        {
            resultTv.setText(finalResult);
        }

    }
    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if (finalResult.endsWith(".0"))
            {
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }
}