package jp.techacademy.mito.yuuya.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL;
import static android.text.InputType.TYPE_NUMBER_FLAG_SIGNED;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText aEditText;
    EditText bEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        aEditText =(EditText) findViewById(R.id.editText1) ;
        aEditText.setInputType(InputType.TYPE_CLASS_NUMBER|TYPE_NUMBER_FLAG_DECIMAL|TYPE_NUMBER_FLAG_SIGNED);
        bEditText =(EditText) findViewById(R.id.editText2) ;
        bEditText.setInputType(InputType.TYPE_CLASS_NUMBER|TYPE_NUMBER_FLAG_DECIMAL|TYPE_NUMBER_FLAG_SIGNED);


        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText("+");
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("-");
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText("×");
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setText("÷");
        button4.setOnClickListener(this);

    }

    @Override
        public void onClick(View v){
        String a = null;
        if (v.getId() == R.id.button1) {
            a = "+";
        } else if (v.getId() == R.id.button2) {
            a = "-";
        }else if (v.getId() == R.id.button3) {
            a = "×";
        }else if (v.getId() == R.id.button4) {
            a = "÷";
        }

        Intent intent = new Intent(this, SecondActivity.class);
        try {
            double num1 = Double.parseDouble(aEditText.getText().toString());
            double num2 = Double.parseDouble(bEditText.getText().toString());
            intent.putExtra("VALUE1", num1);
            intent.putExtra("VALUE2", num2);
            intent.putExtra("VALUE3", a);
            startActivity(intent);
        }
        //数値以外を入力された時のアラートダイアログ
        catch(java.lang.NumberFormatException ex){
            //AlertDialog.Builderクラスを使用してAlertDialogを準備する。
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("警告");
                alertDialogBuilder.setMessage("フォームに数値を入力してください。");

                //肯定ボタンの文字列、押した時のリスナーを設定する
                alertDialogBuilder.setPositiveButton("閉じる",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog,int witch){
                                Log.d("UI_PARTS","閉じるボタン");
                            }
                        });
                //AlertDialogを作成して表示する
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
        }

    }
}
