package com.example.hvac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class add_device extends AppCompatActivity {

    private TextView bac;
    private TextView d1,d2,d3,d4,d5,d6,d7,d8,d9,d10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bac=(TextView)findViewById(R.id.back);


        d1=(TextView)findViewById(R.id.de1);
        d2=(TextView)findViewById(R.id.de2);

        d3=(TextView)findViewById(R.id.de3);
        d4=(TextView)findViewById(R.id.de4);



        d5=(TextView)findViewById(R.id.de5);

        d6=(TextView)findViewById(R.id.de6);
        d7=(TextView)findViewById(R.id.de7);
        d8=(TextView)findViewById(R.id.de8);
        d9=(TextView)findViewById(R.id.de9);
        d10=(TextView)findViewById(R.id.de10);



        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference D1=database.getReference("Active Now : Device 1");
        D1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                d1.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference D2=database.getReference("Active Now : Device 2");
        D2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                d2.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference D3=database.getReference("Active Now : Device 3");
        D3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                d3.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference D4=database.getReference("Active Now : Device 4");
        D4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                d4.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference D5=database.getReference("Active Now : Device 5");
        D5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                d5.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        DatabaseReference D6=database.getReference("Used Before: Device 1");
        D6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                d6.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference D7=database.getReference("Used Before: Device 2");
        D7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                d7.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference D8=database.getReference("Used Before: Device 3");
        D8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                d8.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference D9=database.getReference("Used Before: Device 4");
        D9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                d9.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference D10=database.getReference("Used Before: Device 5");
        D10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                d10.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });











        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openroom();
            }
        });



    }

    private void openroom() {
        Intent intent=new Intent(this,room.class);
        startActivity(intent);


    }
}