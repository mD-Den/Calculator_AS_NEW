package com.md_den.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private double result = 0;
    private String text;
    private ArrayList<Double> exampleElements = new ArrayList<>();
    private boolean isNextClear = false;
    MathActivity mathActivity = MathActivity.NONE;
    DecimalFormat decimalFormat = new DecimalFormat("#.#########");
    DecimalFormat decimalFormat1 = new DecimalFormat("#.");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickNull(View view) {
        TextView mainText = (TextView) findViewById(R.id.main_text);
        text = mainText.getText().toString();
        if (!text.equals("0")) {
            mainText.setText(String.format("%s0", text));
        }
        if (isNextClear) {
            mainText.setText("0");
        }
    }

    public void one(View view) {
        TextView mainText = (TextView) findViewById(R.id.main_text);
        text = mainText.getText().toString();
        if (text.equals("0") || isNextClear) {
            mainText.setText("1");
            isNextClear = false;
        } else {
            mainText.setText(String.format("%s1", text));
        }
    }

    public void two(View view) {
        TextView mainText = (TextView) findViewById(R.id.main_text);
        text = mainText.getText().toString();
        if (text.equals("0") || isNextClear) {
            mainText.setText("2");
            isNextClear = false;
        } else {
            mainText.setText(String.format("%s2", text));
        }
    }

    public void three(View view) {
        TextView mainText = (TextView) findViewById(R.id.main_text);
        text = mainText.getText().toString();
        if (text.equals("0") || isNextClear) {
            mainText.setText("3");
            isNextClear = false;
        } else {
            mainText.setText(String.format("%s3", text));
        }
    }

    public void four(View view) {
        TextView mainText = (TextView) findViewById(R.id.main_text);
        text = mainText.getText().toString();
        if (text.equals("0") || isNextClear) {
            mainText.setText("4");
            isNextClear = false;
        } else {
            mainText.setText(String.format("%s4", text));
        }
    }

    public void five(View view) {
        TextView mainText = (TextView) findViewById(R.id.main_text);
        text = mainText.getText().toString();
        if (text.equals("0") || isNextClear) {
            mainText.setText("5");
            isNextClear = false;
        } else {
            mainText.setText(String.format("%s5", text));
        }
    }

    public void six(View view) {
        TextView mainText = (TextView) findViewById(R.id.main_text);
        text = mainText.getText().toString();
        if (text.equals("0") || isNextClear) {
            mainText.setText("6");
            isNextClear = false;
        } else {
            mainText.setText(String.format("%s6", text));
        }
    }

    public void seven(View view) {
        TextView mainText = (TextView) findViewById(R.id.main_text);
        text = mainText.getText().toString();
        if (text.equals("0") || isNextClear) {
            mainText.setText("7");
            isNextClear = false;
        } else {
            mainText.setText(String.format("%s7", text));
        }

    }

    public void eight(View view) {
        TextView mainText = (TextView) findViewById(R.id.main_text);
        text = mainText.getText().toString();
        if (text.equals("0") || isNextClear) {
            mainText.setText("8");
            isNextClear = false;
        } else {
            mainText.setText(String.format("%s8", text));
        }
    }

    public void nine(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        text = textView.getText().toString();
        if (text.equals("0") || isNextClear) {
            textView.setText("9");
            isNextClear = false;
        } else {
            textView.setText(String.format("%s9", text));
        }
    }

    public void clickPlus(View view) {
        mathActivity = MathActivity.PLUS;
        TextView textView = (TextView) findViewById(R.id.main_text);
        exampleElements.add(Double.parseDouble(textView.getText().toString()));
        textView.setText("0");
        isNextClear = true;
    }

    public void clickMinus(View view) {
        mathActivity = MathActivity.MINUS;
        TextView textView = (TextView) findViewById(R.id.main_text);
        exampleElements.add(Double.parseDouble(textView.getText().toString()));
        textView.setText("0");
        isNextClear = true;
    }

    public void clickDivision(View view) {
        mathActivity = MathActivity.DIVISION;
        TextView textView = (TextView) findViewById(R.id.main_text);
        exampleElements.add(Double.parseDouble(textView.getText().toString()));
        textView.setText("0");
        isNextClear = true;
    }

    public void clickMultiplication(View view) {
        mathActivity = MathActivity.MULTIPLICATION;
        TextView textView = (TextView) findViewById(R.id.main_text);
        exampleElements.add(Double.parseDouble(textView.getText().toString()));
        textView.setText("0");
        isNextClear = true;
    }

    public void click1x(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        textView.setText(String.format("%s", 1 / Double.parseDouble(textView.getText().toString())));
        isNextClear = true;
    }

    public void clickx2(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        textView.setText(String.format("%s", (Double.parseDouble(textView.getText().toString()) * Double.parseDouble(textView.getText().toString()))));
        isNextClear = true;
    }

    public void clickSqr(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        double sqrt = Math.sqrt(Double.parseDouble(textView.getText().toString()));
        textView.setText(decimalFormat.format(sqrt));
        isNextClear = true;
    }

    public void clickInterest(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        exampleElements.add(Double.parseDouble(textView.getText().toString()));
        switch (mathActivity) {
            case PLUS:
                result = exampleElements.get(exampleElements.size() - 2) + (exampleElements.get(exampleElements.size() - 2) / 100) * exampleElements.get(exampleElements.size() - 1);
                break;
            case MINUS:
                result = exampleElements.get(exampleElements.size() - 2) - (exampleElements.get(exampleElements.size() - 2) / 100) * exampleElements.get(exampleElements.size() - 1);
                break;
            case DIVISION: {
                result = (exampleElements.get(exampleElements.size() - 2)) / ((exampleElements.get(exampleElements.size() - 1)) / 100);
                if (Double.isInfinite(result)) {
                    result = 0.0;
                }
            }
            break;
            case MULTIPLICATION:
                result = (exampleElements.get(exampleElements.size() - 2)) * (exampleElements.get(exampleElements.size() - 1) / 100);
                break;
            case NONE:
                result = exampleElements.get(exampleElements.size() - 1) / 100;
                break;
        }
        textView.setText(decimalFormat.format(result));
    }

    public void clickCE(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        textView.setText("0");
        isNextClear = true;
    }

    public void clickC(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        textView.setText("0");
        isNextClear = true;
    }

    public void clickDel(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        String s = textView.getText().toString();
        s = s.substring(0, s.length() - 1);
        if (s.length() == 0) {
            textView.setText("0");
        } else {
            textView.setText(s);
        }
        isNextClear = true;
    }

    public void plusMinus(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        if (!textView.getText().equals("0")) {
            result = Double.parseDouble(textView.getText().toString()) * (-1);
            textView.setText(decimalFormat.format(result));
        }
    }

    public void comma(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        Double d = Double.parseDouble(textView.getText().toString());
        if (!isNextClear) {
            textView.setText(decimalFormat1.format(d));
        } else {
            textView.setText("0.");
            isNextClear = false;
        }
    }

    public void total(View view) {
        TextView textView = (TextView) findViewById(R.id.main_text);
        switch (mathActivity) {
            case PLUS:
                textView = (TextView) findViewById(R.id.main_text);
                exampleElements.add(Double.parseDouble(textView.getText().toString()));
                result = exampleElements.get(exampleElements.size() - 2) + exampleElements.get(exampleElements.size() - 1);
                break;
            case MINUS:
                textView = (TextView) findViewById(R.id.main_text);
                exampleElements.add(Double.parseDouble(textView.getText().toString()));
                result = exampleElements.get(exampleElements.size() - 2) - exampleElements.get(exampleElements.size() - 1);
                break;
            case DIVISION:
                textView = (TextView) findViewById(R.id.main_text);
                exampleElements.add(Double.parseDouble(textView.getText().toString()));

                result = exampleElements.get(exampleElements.size() - 2) / exampleElements.get(exampleElements.size() - 1);
                if (Double.isInfinite(result)) {
                    result = 0.0;
                    mathActivity = MathActivity.NONE;
                }
                break;
            case MULTIPLICATION:
                textView = (TextView) findViewById(R.id.main_text);
                exampleElements.add(Double.parseDouble(textView.getText().toString()));
                result = exampleElements.get(exampleElements.size() - 2) * exampleElements.get(exampleElements.size() - 1);
                break;
        }
        textView.setText(decimalFormat.format(result));
        isNextClear = true;
    }
}