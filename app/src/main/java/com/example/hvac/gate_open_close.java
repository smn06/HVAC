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

import java.util.Timer;
import java.util.TimerTask;

public class gate_open_close extends AppCompatActivity {
    private TextView ex;
    private TextView back,logg;
   private Button open,close,reso,night,reboo;
    int resol=0,n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_gate_open_close);
        ex=(TextView) findViewById(R.id.exit);
        back=(TextView)findViewById(R.id.back);

        open=(Button)findViewById(R.id.gate_open);
        close=(Button)findViewById(R.id.gate_close);
        reso=(Button)findViewById(R.id.res);
        night=(Button)findViewById(R.id.Night);
        reboo=(Button)findViewById(R.id.reboot);

        logg=(TextView)findViewById(R.id.log);


        logg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),admin_user.class));
                finish();
            }
        });



        reboo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(gate_open_close.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                builder.setMessage(R.string.reboot_message);


                final AlertDialog reboot_message = builder.create();
                reboot_message.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        reboot_message.dismiss();
                        openadmin_user();// when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);




            }
        });




        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(gate_open_close.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(n==0) {

                    builder.setMessage(R.string.n_mes);
                    n = 1;
                }
                else{
                    builder.setMessage("Nightmode Deactivated");
                    n=0;
                }

                final AlertDialog n_mes = builder.create();
                n_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        n_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);


            }
        });


        reso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(gate_open_close.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(resol==0) {

                    builder.setMessage(R.string.res_mes);
                    resol = 1;
                }
                else{
                    builder.setMessage("Resolution is set to Normal");
                    resol=0;
                }

                final AlertDialog res_mes = builder.create();
                res_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        res_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);



            }
        });




        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder temp2= new AlertDialog.Builder(gate_open_close.this);
                temp2.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                temp2.setMessage("Gate is Off");
                temp2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                temp2.show();



            }
        });


        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder temp1= new AlertDialog.Builder(gate_open_close.this);
                temp1.setTitle(">>>>>>>!!!!Information!!!!<<<<<<<");
                temp1.setMessage("Gate is Open");
                temp1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                temp1.show();

            }
        });


        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmain_admin();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensecurity();
            }
        });

    }

    private void openmain_admin() {
        Intent intent=new Intent(this,main_admin.class);
        startActivity(intent);
    }

    private void openadmin_user() {
        Intent intent=new Intent(this,admin_user.class);
        startActivity(intent);

    }

    private void opensecurity() {
        Intent intent=new Intent(this,security.class);
        startActivity(intent);
    }
}