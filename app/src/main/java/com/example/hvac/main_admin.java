package com.example.hvac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class main_admin extends AppCompatActivity {
    private Button buttonh;
    private Button buttonw;
    private Button buttonf;
    private Button buttons;
    private Button buttone;
    private TextView back;
    private TextView logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main_admin);
        buttonh=(Button) findViewById(R.id.havc);
        buttonw=(Button)findViewById(R.id.water_supply);
        buttonf=(Button)findViewById(R.id.fire_exhaust);
        buttons=(Button)findViewById(R.id.security);
        buttone=(Button)findViewById(R.id.emergency);
        back=(TextView)findViewById(R.id.back);


        logout=(TextView)findViewById(R.id.log);

        logout.setOnClickListener(new View.OnClickListener() {
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
                openadmin_user();
            }
        });

        buttone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensupply();
            }
        });

        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensecurity();
            }
        });


        buttonf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openrpm();
            }
        });
        buttonw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openpsi_read();

            }
        });
        buttonh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opentemp_read();
            }
        });
    }

    private void openadmin_user() {
        Intent intent= new Intent(this,admin_user.class);
        startActivity(intent);

    }

    private void opensupply() {
        Intent intent = new Intent(this,supply.class);
        startActivity(intent);
    }

    private void opensecurity() {
        Intent intent =new Intent(this,security.class);
        startActivity(intent);
    }

    private void openrpm() {
        Intent intent=new Intent(this,rpm.class);
        startActivity(intent);
    }

    private void openpsi_read() {
        Intent intent=new Intent(this,psi_read.class);
        startActivity(intent);
    }

    private void opentemp_read() {
        Intent intent=new Intent(this,temp_read.class);
        startActivity(intent);
    }
}