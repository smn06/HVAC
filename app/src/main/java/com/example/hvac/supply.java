package com.example.hvac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class supply extends AppCompatActivity {
    private TextView ex;
    private TextView back;
    private Button water;
    private Button power;
    private Button fire;
    private Button ambu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_supply);
        ex=(TextView)findViewById(R.id.log);
        back=(TextView)findViewById(R.id.back);

        power=(Button) findViewById(R.id.main_power);

        water=(Button) findViewById(R.id.water);

        fire=(Button) findViewById(R.id.fire);

        ambu= (Button) findViewById(R.id.ambulance);

        ambu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openaddr();
            }
        });

        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensos();
            }
        });

        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openfloortofloor();
            }
        });

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain_power_supply();
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

    private void openaddr() {
        Intent intent=new Intent(this,addr.class);
        startActivity(intent);
    }

    private void opensos() {
        Intent intent=new Intent(this,sos.class);
        startActivity(intent);
    }

    private void openfloortofloor() {
        Intent intent= new Intent(this,floortofloor.class);
        startActivity(intent);
    }

    private void openMain_power_supply() {

        Intent intent=new Intent(this,Main_power_supply.class);
        startActivity(intent);
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

