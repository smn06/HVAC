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

public class mode extends AppCompatActivity {
    private TextView ex;
    private TextView back;
    private Button tur,man,aut,low;
    int t=0,m=0,a=0,l=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        ex=(TextView)findViewById(R.id.log);
        back=(TextView)findViewById(R.id.back);


        tur=(Button)findViewById(R.id.turbo_mode);
        man=(Button)findViewById(R.id.manual_mode);
        aut=(Button)findViewById(R.id.auto_mode);
        low=(Button)findViewById(R.id.low_mode);


        tur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(mode.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(t==0) {

                    builder.setMessage(R.string.tur_m);
                    t = 1;
                }
                else{
                    builder.setMessage("Turbo mode Deactivated");
                    t=0;
                }

                final AlertDialog tur_m = builder.create();
                tur_m.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        tur_m.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);




            }
        });

        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(mode.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(m==0) {

                    builder.setMessage(R.string.man_m);
                    m = 1;
                }
                else{
                    builder.setMessage("Manual mode Deactivated");
                    m=0;
                }

                final AlertDialog tur_m = builder.create();
                tur_m.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        tur_m.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);




            }
        });

        aut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(mode.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(a==0) {

                    builder.setMessage(R.string.auto_m);
                    a = 1;
                }
                else{
                    builder.setMessage("Auto mode Deactivated");
                    a=0;
                }

                final AlertDialog auto_m = builder.create();
                auto_m.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        auto_m.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);





            }
        });

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(mode.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(l==0) {

                    builder.setMessage(R.string.low_m);
                    l = 1;
                }
                else{
                    builder.setMessage("Low mode Deactivated");
                    l=0;
                }

                final AlertDialog low_m = builder.create();
                low_m.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        low_m.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);






            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openroom();
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
    }

    private void openroom() {
        Intent intent=new Intent(this,room.class);
        startActivity(intent);
    }

    private void openadmin_user() {
        Intent intent=new Intent(this,admin_user.class);
        startActivity(intent);
    }
}