package com.example.hvac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class person_counter extends AppCompatActivity {
    private TextView bac;
    private TextView p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_counter);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bac=(TextView)findViewById(R.id.back);

        p1=(TextView)findViewById(R.id.pe1);
        p2=(TextView)findViewById(R.id.pe2);
        p3=(TextView)findViewById(R.id.pe3);
        p4=(TextView)findViewById(R.id.pe4);
        p5=(TextView)findViewById(R.id.pe5);
        p6=(TextView)findViewById(R.id.pe6);
        p7=(TextView)findViewById(R.id.pe7);
        p8=(TextView)findViewById(R.id.pe8);
        p9=(TextView)findViewById(R.id.pe9);
        p10=(TextView)findViewById(R.id.pe10);




        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference P1=database.getReference("Person Out: Day 1");
        P1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                p1.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference P2=database.getReference("Person Out: Day 2");
        P2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                p2.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference P3=database.getReference("Person Out: Day 3");
        P3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                p3.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference P4=database.getReference("Person Out: Day 4");
        P4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                p4.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference P5=database.getReference("Person Out: Day 5");
        P5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                p5.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        DatabaseReference P6=database.getReference("Person In: Day 1");
        P6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                p6.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference P7=database.getReference("Person In: Day 2");
        P7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                p7.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference P8=database.getReference("Person In: Day 3");
        P8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                p8.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference P9=database.getReference("Person In: Day 4");
        P9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                p9.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        DatabaseReference P10=database.getReference("Person In: Day 5");
        P10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                p10.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

































        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensecurity();
            }
        });
    }

    private void opensecurity() {

        Intent intent=new Intent(this,security.class);
        startActivity(intent);
    }
}