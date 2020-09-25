package com.example.hvac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class security extends AppCompatActivity {
    private TextView ex;
    private TextView back;
    private Button s;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_security);
        ex=(TextView) findViewById(R.id.log);
        back=(TextView)findViewById(R.id.back);
        s=(Button)findViewById(R.id.settings);


        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opengate_open_close();
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

    private void opengate_open_close() {

        Intent intent=new Intent(this,gate_open_close.class);
        startActivity(intent);


    }

    private void openmain_admin() {
        Intent intent=new Intent(this,main_admin.class);
        startActivity(intent);
    }

    private void openadmin_user() {
        Intent intent= new Intent(this,admin_user.class);
        startActivity(intent);
    }

}