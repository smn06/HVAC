package com.example.hvac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class accessories extends AppCompatActivity {
    private Button more;
    private TextView ex;
    private TextView back;
    private Button blight,bfan,bheat,bfri,bac;

    int light=0,fan=0,heater=0,fri=0,ac=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_accessories);

        more=(Button)findViewById(R.id.more);
        back=(TextView)findViewById(R.id.back);
        ex=(TextView)findViewById(R.id.log);

        blight=(Button)findViewById(R.id.light);
        bfan=(Button)findViewById(R.id.fan);
        bheat=(Button)findViewById(R.id.heater);
        bfri=(Button)findViewById(R.id.fridge);
        bac=(Button)findViewById(R.id.ac);

        blight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(accessories.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(light==0) {

                    builder.setMessage(R.string.light_mes);
                    light = 1;
                }
                else{
                    builder.setMessage("Light is off");
                    light=0;
                }

                final AlertDialog light_mes = builder.create();
                light_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        light_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);

            }
        });

        bfan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(accessories.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(fan==0) {

                    builder.setMessage(R.string.fan_mes);
                    fan = 1;
                }
                else{
                    builder.setMessage("Fan is off");
                    fan=0;
                }

                final AlertDialog fan_mes = builder.create();
                fan_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        fan_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);


            }
        });

        bheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(accessories.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(heater==0) {

                    builder.setMessage(R.string.heater_mes);
                    heater = 1;
                }
                else{
                    builder.setMessage("Heater is off");
                    heater=0;
                }

                final AlertDialog heater_mes = builder.create();
                heater_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        heater_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);




            }
        });

        bfri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(accessories.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(fri==0) {

                    builder.setMessage(R.string.fridge_mes);
                    fri = 1;
                }
                else{
                    builder.setMessage("Fridge is off");
                    fri=0;
                }

                final AlertDialog fridge_mes = builder.create();
                fridge_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        fridge_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);






            }
        });

        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(accessories.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(ac==0) {

                    builder.setMessage(R.string.ac_mes);
                    ac = 1;
                }
                else{
                    builder.setMessage("AC is off");
                    ac=0;
                }

                final AlertDialog ac_mes = builder.create();
                ac_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        ac_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);




            }
        });


        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),admin_user.class));
                finish();

            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openroom();
            }
        });


        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openaccessories_more();
            }
        });


    }

    private void openadmin_user() {
        Intent intent=new Intent(this,admin_user.class);
        startActivity(intent);
    }

    private void openroom() {
        Intent intent=new Intent(this,room.class);
        startActivity(intent);
    }

    private void openaccessories_more() {
        Intent intent=new Intent(this,accessories_more.class);
        startActivity(intent);
    }
}