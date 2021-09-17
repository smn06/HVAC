package com.example.hvac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

public class psi_read extends AppCompatActivity {
    private TextView back;
    private TextView ho;
    private Button aut,man,reb;
    int a=0,m=0;
    private TextView ed1,ed2,ed3,ed4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_psi_read);
        back=(TextView) findViewById(R.id.back);
        ho=(TextView) findViewById(R.id.log);

        aut=(Button)findViewById(R.id.auto);
        man=(Button)findViewById(R.id.manual);
        reb=(Button)findViewById(R.id.reboot);

        ed1=(TextView)findViewById(R.id.edit1);
        ed2=(TextView)findViewById(R.id.edit2);
        ed3=(TextView)findViewById(R.id.edit3);
        ed4=(TextView)findViewById(R.id.edit4);




        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference p1=database.getReference("PSI 1");
        p1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                ed1.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        DatabaseReference p2=database.getReference("PSI 2");
        p2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                ed2.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference p3=database.getReference("PSI 3");
        p3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                ed3.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        DatabaseReference p4=database.getReference("PSI 4");
        p4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                ed4.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });









        reb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference psi=database.getReference("Reboot PSI");
                psi.setValue("Rebooting Whole System");


                AlertDialog.Builder builder = new AlertDialog.Builder(psi_read.this);
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


        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference psi=database.getReference("PSI Read");





                AlertDialog.Builder builder = new AlertDialog.Builder(psi_read.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(m==0) {
                    psi.setValue("Manual Supply Activated");
                    builder.setMessage(R.string.man_mes);
                    m = 1;
                }
                else{
                    psi.setValue("Manual Supply Deactivated");

                    builder.setMessage("Manual Supply Deactivated");
                    m=0;
                }

                final AlertDialog man_mes = builder.create();
                man_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        man_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);



            }
        });



        aut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference psi=database.getReference("PSI Auto Read");



                AlertDialog.Builder builder = new AlertDialog.Builder(psi_read.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(a==0) {
                    psi.setValue("Auto Supply Activated");
                    builder.setMessage(R.string.auto_mes);
                    a = 1;
                }
                else{
                    psi.setValue("Auto Supply Deactivated");
                    builder.setMessage("Auto Supply Deactivated");
                    a=0;
                }

                final AlertDialog auto_mes = builder.create();
                auto_mes.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        auto_mes.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);




            }
        });



        ho.setOnClickListener(new View.OnClickListener() {
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
                openmain_admin();
            }
        });
    }



    private void openadmin_user() {
        Intent intent=new Intent(this,admin_user.class);
        startActivity(intent);
    }

    private void openmain_admin() {
        Intent intent=new Intent(this,main_admin.class);
        startActivity(intent);
    }

}