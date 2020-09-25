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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class rpm extends AppCompatActivity {
    private TextView ex;
    private TextView back;
    private Button turbo,aut,manual,low;
    int tu=0,au=0,man=0,lo=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_rpm);
        ex=(TextView)findViewById(R.id.log);
        back=(TextView)findViewById(R.id.back);

        turbo=(Button)findViewById(R.id.turbo);
        aut=(Button)findViewById(R.id.auto);
        manual=(Button)findViewById(R.id.manual);
        low=(Button)findViewById(R.id.low);


        turbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference rpm=database.getReference("Turbo RPM");




                AlertDialog.Builder builder = new AlertDialog.Builder(rpm.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(tu==0) {

                    rpm.setValue("Turbo RPM is on");
                    builder.setMessage(R.string.turbo_m);
                    tu = 1;
                }
                else{
                    rpm.setValue("Turbo RPM is off");

                    builder.setMessage("Turbo RPM is turning off in 2s");
                    tu=0;
                }

                final AlertDialog turbo_m = builder.create();
                turbo_m.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        turbo_m.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);




            }
        });

        aut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference rpm=database.getReference("Auto RPM");



                AlertDialog.Builder builder = new AlertDialog.Builder(rpm.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(au==0) {
                    rpm.setValue("Auto RPM is on");
                    builder.setMessage(R.string.auto_m);
                    au = 1;
                }
                else{
                    rpm.setValue("Auto RPM is off");
                    builder.setMessage("Auto RPM is turning off in 2s");
                    au=0;
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

        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference rpm=database.getReference("Manual RPM");


                AlertDialog.Builder builder = new AlertDialog.Builder(rpm.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(man==0) {
                    rpm.setValue("Manual RPM is on");
                    builder.setMessage(R.string.manual_m);
                    man = 1;
                }
                else{
                    rpm.setValue("Manual RPM is off");
                    builder.setMessage("Turbo RPM is turning off in 2s");
                    man=0;
                }

                final AlertDialog manual_m = builder.create();
                manual_m.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        manual_m.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);



            }
        });

        low.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference rpm=database.getReference("Low RPM");



                AlertDialog.Builder builder = new AlertDialog.Builder(rpm.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(lo==0) {
                    rpm.setValue("Low RPM is on");
                    builder.setMessage(R.string.lo_m);
                    lo = 1;
                }
                else{

                    rpm.setValue("Low RPM is off");
                    builder.setMessage("Low RPM is turning off in 2s");
                    lo=0;
                }

                final AlertDialog lo_m = builder.create();
                lo_m.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        lo_m.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);




            }
        });






        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmain_admin();
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

    private void openmain_admin() {
        Intent intent=new Intent(this,main_admin.class);
        startActivity(intent);
    }

    private void openadmin_user() {
        Intent intent=new Intent(this,admin_user.class);
        startActivity(intent);
    }
}