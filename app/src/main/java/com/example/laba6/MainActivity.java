package com.example.laba6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int Number;

    public void ChooseInt(){
        Number = (int) ((Math.random() * (100 - 1))) + 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView tv_main = findViewById(R.id.tv_main);
        EditText et_main = findViewById(R.id.et_main);
        Button btn_main = findViewById(R.id.btn_main);
        Button btn_new_int = findViewById(R.id.btn_new_int);


        ChooseInt();


        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_main.getText().toString().equals("")){
                    tv_main.setText("Ведите что нибудь!");
                }
                else{
                    if (Integer.parseInt(et_main.getText().toString()) < 0 || Integer.parseInt(et_main.getText().toString()) > 100){
                        tv_main.setText("Число вне диапазона!");
                    }
                    else {
                        if (Integer.parseInt(et_main.getText().toString())< Number ){
                            tv_main.setText(getResources().getString(R.string.behind));
                        }
                        if (Integer.parseInt(et_main.getText().toString())> Number ){
                            tv_main.setText(getResources().getString(R.string.ahead));
                        }

                        if (Integer.parseInt(et_main.getText().toString()) == Number ){
                            tv_main.setText(getResources().getString(R.string.hit));
                        }
                    }

                }


            }
        });

        btn_new_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseInt();
                tv_main.setText("Число изменилось");
            }
        });

    }
}