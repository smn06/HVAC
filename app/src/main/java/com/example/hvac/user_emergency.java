package com.example.hvac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class user_emergency extends AppCompatActivity {
    private TextView back;
    private TextView ho;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_emergency);
        back=(TextView)findViewById(R.id.back);
        ho=(TextView)findViewById(R.id.log);

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
                openroom();
            }
        });
    }

    private void openadmin_user() {

        Intent intent=new Intent(this,admin_user.class);
        startActivity(intent);

    }

    private void openroom() {

        Intent intent=new Intent(this,room.class);
        startActivity(intent);
    }
}