package com.example.hvac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class room extends AppCompatActivity {
    private Button room;
    private Button swich;
    private TextView back;
    private Button ex;
    private Button add;
    private Button all;
    private TextView lo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_room);
        room=(Button)findViewById(R.id.room_temp);
        swich=(Button)findViewById(R.id.switches);
        ex=(Button)findViewById(R.id.emer);
        back=(TextView)findViewById(R.id.back);

        add=(Button)findViewById(R.id.add_device);
        all=(Button)findViewById(R.id.connected);

        lo=(TextView)findViewById(R.id.log);


        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),admin_user.class));
                finish();
            }
        });


        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openall_device();
            }
        });




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openadd_device();
            }
        });


//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openwifi();
//            }
//        });





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openadmin_user();
            }
        });
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openuser_emergency();
            }
        });

        swich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openaccessories();
            }
        });



        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmode();

            }
        });

    }

    private void openall_device() {
        Intent intent=new Intent(this,all_device.class);
        startActivity(intent);
    }

    private void openadd_device() {

        Intent intent=new Intent(this,add_device.class);
        startActivity(intent);


    }

//    private void openwifi() {
//        Intent intent=new Intent(this,wifi.class);
//        startActivity(intent);
//    }

    private void openuser_emergency() {
        Intent intent=new Intent(this,user_emergency.class);
        startActivity(intent);
    }

    private void openadmin_user() {
        Intent intent=new Intent(this,admin_user.class);
        startActivity(intent);
    }

    private void openaccessories() {
        Intent intent=new Intent(this,accessories.class);
        startActivity(intent);
    }

    private void openmode() {
        Intent intent=new Intent(this,mode.class);
        startActivity(intent);
    }
}