package com.example.laba6;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int Number;
    int ind = 0;
    Handler handler = new Handler();

    public void ChooseInt(){
        Number = (int) ((Math.random() * (100 - 1))) + 1;
    }

    public void pbAnim(ProgressBar pb, EditText tv, int i){

            ObjectAnimator progressAnimator = ObjectAnimator.ofInt(pb, "progress", ind, Integer.parseInt(tv.getText().toString()));
            progressAnimator.setDuration(500);
            progressAnimator.setInterpolator(new LinearInterpolator());
            progressAnimator.start();
            if (Integer.parseInt(tv.getText().toString()) == Number){
                pb.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            }
            else {
                if ( Integer.parseInt(tv.getText().toString()) < Number+11 && Integer.parseInt(tv.getText().toString())> Number){
                    pb.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
                }
                else{
                    if ( Integer.parseInt(tv.getText().toString()) > Number-11 && Integer.parseInt(tv.getText().toString())< Number){
                        pb.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
                    }
                    else{
                        pb.setProgressTintList(ColorStateList.valueOf(Color.RED));
                    }

                }
            }


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView tv_main = findViewById(R.id.tv_main);
        EditText et_main = findViewById(R.id.et_main);
        Button btn_main = findViewById(R.id.btn_main);
        Button btn_new_int = findViewById(R.id.btn_new_int);
        ProgressBar pb_main = findViewById(R.id.pb_main);


        ChooseInt();

        pb_main.setMax(100);
        pb_main.setProgress(0);
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
                        pbAnim(pb_main,et_main,ind);
                        ind = Integer.parseInt(et_main.getText().toString());


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