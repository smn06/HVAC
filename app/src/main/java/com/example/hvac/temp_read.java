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


public class temp_read extends AppCompatActivity {
    private TextView back;
    private Button button;
    private Button turbo;
    private Button reboot;
    private TextView ho;
    int state = 0;
    int state_temp=0;
    private TextView ed1,ed2,ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_temp_read);
        back=(TextView)findViewById(R.id.back);
        button=(Button)findViewById(R.id.temp);
        turbo=(Button)findViewById(R.id.turbo_cool);
        reboot=(Button)findViewById(R.id.reboot);
        ho=(TextView)findViewById(R.id.log);

        ed1=(TextView)findViewById(R.id.edit1);
        ed2=(TextView)findViewById(R.id.edit2);
        ed3=(TextView)findViewById(R.id.edit3);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference my=database.getReference("Temp Write");
        my.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                ed1.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference mb=database.getReference("Building Temp Write");
        mb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                ed2.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference mo=database.getReference("Outside Temp Write");
        mo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                ed3.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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


        turbo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myref=database.getReference("Turbo Cooling");





                AlertDialog.Builder builder = new AlertDialog.Builder(temp_read.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(state==0) {

                    myref.setValue("Turbo Cooling is on");
                    builder.setMessage(R.string.turbo_message);
                    state = 1;
                }
                else{
                    myref.setValue("Turbo Cooling is off");
                    builder.setMessage("Turbo Cooling is turning off in 2s");
                    state=0;
                }

                final AlertDialog turbo_message = builder.create();
                turbo_message.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        turbo_message.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);


            }
        });


        reboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myref=database.getReference("Reboot");
                myref.setValue("Rebooting Whole System");





                AlertDialog.Builder builder = new AlertDialog.Builder(temp_read.this);
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmain_admin();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myref=database.getReference("Temperature Change");

                myref.setValue("Turbo Cooling is on");




                AlertDialog.Builder builder = new AlertDialog.Builder(temp_read.this);
                builder.setTitle(">>>>>>>!!!!WARNING!!!!<<<<<<<<");
                if(state_temp==0) {
                    myref.setValue("Temperature will change to low in 2s");
                    builder.setMessage(R.string.message);
                    state_temp = 1;
                }
                else{
                    myref.setValue("Temperature will change to normal in 2s");
                    builder.setMessage("Temperature will change to normal in 2s");
                    state_temp=0;
                }

                final AlertDialog message = builder.create();
                message.show();


                final Timer t;
                t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        message.dismiss(); // when the task active then close the dialog
                        t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                    }
                }, 2000);

                }


        });




}

    private void openadmin_user() {




        Intent intent=new Intent(this,admin_user.class);



        startActivity(intent);
    }

    private void opendial_temp() {
        //Intent intent=new Intent(this,dial_temp.class);

    }

    private void openmain_admin() {
        Intent intent=new Intent(this,main_admin.class);
        startActivity(intent);
    }
}