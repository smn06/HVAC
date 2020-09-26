package com.example.hvac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class admin_user extends AppCompatActivity {
    private Button button;
    private Button button1;
    private TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_admin_user);


        button= (Button) findViewById(R.id.Admin);
        button1=(Button) findViewById(R.id.user);
        back=(TextView) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openadmin_login();
            }
        });

}

    private void openMainActivity() {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    private void openMainActivity2() {
        Intent intent= new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    private void openadmin_login() {
        Intent intent= new Intent(this,admin_login.class);
        startActivity(intent);
    }

}