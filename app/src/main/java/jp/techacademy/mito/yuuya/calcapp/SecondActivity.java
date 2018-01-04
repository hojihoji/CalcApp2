package jp.techacademy.mito.yuuya.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    //TEST
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("VALUE1", 0);
        double value2 = intent.getDoubleExtra("VALUE2", 0);
        String value3 = intent.getStringExtra("VALUE3");

        TextView textView = (TextView) findViewById(R.id.textView);
            if (value3.equals("+")) {
                textView.setText(String.valueOf(value1 + value2));
            } else if (value3.equals("-")) {
                textView.setText(String.valueOf(value1 - value2));
            } else if (value3.equals("×")) {
                textView.setText(String.valueOf(value1 * value2));
            } else if (value3.equals("÷") && value2 != 0) {
                textView.setText(String.valueOf(value1 / value2));
            } else {
                textView.setText("計算できません");
            }
    }
}