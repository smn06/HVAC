package com.example.hvac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class accessories_more extends AppCompatActivity {
    private TextView back;
    private Button btv,boven,bprint,bal,bblen;

    int tv=0,oven=0,printer=0,alexa=0,blen=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_accessories_more);
        back=(TextView)findViewById(R.id.back);

        btv=(Button)findViewById(R.id.tv);
        boven=(Button)findViewById(R.id.oven);
        bprint=(Button)findViewById(R.id.printer);
        bal=(Button)findViewById(R.id.alexa);
        bblen=(Button)findViewById(R.id.blender);


        btv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(accessories_more.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(tv==0) {

                    builder.setMessage(R.string.tv_mes);
                    tv = 1;
                }
                else{
                    builder.setMessage("TV is off");
                    tv=0;
                }

                final AlertDialog tv_mes = builder.create();
                tv_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        tv_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);



            }
        });


        boven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(accessories_more.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(oven==0) {

                    builder.setMessage(R.string.oven_mes);
                    oven = 1;
                }
                else{
                    builder.setMessage("Oven is off");
                    oven=0;
                }

                final AlertDialog oven_mes = builder.create();
                oven_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        oven_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);



            }
        });


        bprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                AlertDialog.Builder builder = new AlertDialog.Builder(accessories_more.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(printer==0) {

                    builder.setMessage(R.string.print_mes);
                    printer = 1;
                }
                else{
                    builder.setMessage("Printer is off");
                    printer=0;
                }

                final AlertDialog print_mes = builder.create();
                print_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        print_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);



            }
        });


        bal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(accessories_more.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(alexa==0) {

                    builder.setMessage(R.string.alex_mes);
                    alexa = 1;
                }
                else{
                    builder.setMessage("Alexa is off");
                    alexa=0;
                }

                final AlertDialog alex_mes = builder.create();
                alex_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        alex_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);





            }
        });

        bblen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(accessories_more.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(blen==0) {

                    builder.setMessage(R.string.blen_mes);
                    blen = 1;
                }
                else{
                    builder.setMessage("Blender is off");
                    blen=0;
                }

                final AlertDialog blen_mes = builder.create();
                blen_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        blen_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);




            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openaccessories();
            }
        });
    }

    private void openaccessories() {
        Intent intent=new Intent(this,accessories.class);
        startActivity(intent);


    }
}