package com.example.hvac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(windowManager, ActionBar.LayoutParams,FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.get_started);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FirebaseDatabase database=FirebaseDatabase.getInstance();
//                DatabaseReference myref=database.getReference("Temp");
//
//                myref.setValue("Heleelo");

                openadmin_user();

            }

        });

    }

    private void openadmin_user() {
        Intent intent = new Intent(this, admin_user.class);
        startActivity(intent);


    }



}

