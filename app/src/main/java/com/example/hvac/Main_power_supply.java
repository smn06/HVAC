package com.example.hvac;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class Main_power_supply extends AppCompatActivity {
    private TextView back;
    private TextView ho;
    private Button sc,on,off;
    int supply=0;
    private TextView logg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main3);
        back = (TextView)findViewById(R.id.back);
        ho=(TextView)findViewById(R.id.home);

        logg=(TextView)findViewById(R.id.log);

        logg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),admin_user.class));
                finish();
            }
        });


        sc=(Button)findViewById(R.id.scheduled_supp);
        on=(Button)findViewById(R.id.ON);
        off=(Button) findViewById(R.id.OFF);







        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference power=database.getReference("Main Power");
                power.setValue("Main Power Supply is off");


                AlertDialog.Builder temp1= new AlertDialog.Builder(Main_power_supply.this);
                temp1.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                temp1.setMessage("Power Supply is Off");
                temp1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                });
                temp1.show();


            }
        });



        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference power=database.getReference("Main Power");
                power.setValue("Main Power Supply is on");

                AlertDialog.Builder temp= new AlertDialog.Builder(Main_power_supply.this);
                temp.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                temp.setMessage("power Supply is On");
                temp.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                });
                temp.show();


            }
        });


        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference power=database.getReference("Schedule Power");
                power.setValue("Main Power Supply is off");


                AlertDialog.Builder builder = new AlertDialog.Builder(Main_power_supply.this);
                builder.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                if(supply==0) {
                    power.setValue("Schedule Supply Activated");
                    builder.setMessage(R.string.sc_mes);
                    supply = 1;
                }
                else{
                    power.setValue("Schedule Supply Activated");
                    builder.setMessage("Schedule Supply Deactivated");
                    supply=0;
                }

                final AlertDialog sc_mes = builder.create();
                sc_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        sc_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);



            }
        });










        ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmain_admin();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensupply();
            }
        });

    }

    private void openmain_admin() {
        Intent intent=new Intent(this,main_admin.class);
        startActivity(intent);
    }

    private void opensupply() {
        Intent intent= new Intent(this,supply.class);
        startActivity(intent);


    }
}