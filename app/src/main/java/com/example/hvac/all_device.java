package com.example.hvac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class all_device extends AppCompatActivity {

    private TextView bac;

    private TextView de1,de2,de3,de4,de5,de6,de7,de8,de9,de10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_device);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bac=(TextView)findViewById(R.id.back);

        de1=(TextView)findViewById(R.id.dev1);
        de2=(TextView)findViewById(R.id.dev2);
        de3=(TextView)findViewById(R.id.dev3);
        de4=(TextView)findViewById(R.id.dev4);
        de5=(TextView)findViewById(R.id.dev5);
        de6=(TextView)findViewById(R.id.dev6);
        de7=(TextView)findViewById(R.id.dev7);
        de8=(TextView)findViewById(R.id.dev8);
        de9=(TextView)findViewById(R.id.dev9);
        de10=(TextView)findViewById(R.id.dev10);


        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference De1=database.getReference("Active Now : Device 1");
        De1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                de1.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        DatabaseReference De2=database.getReference("Active Now : Device 2");
        De2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                de2.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference De3=database.getReference("Active Now : Device 3");
        De3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                de3.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference De4=database.getReference("Active Now : Device 4");
        De4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                de4.setText(""+s);

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
                de5.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference De6=database.getReference("Not Active : Device 1");
        De6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                de6.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference De7=database.getReference("Not Active : Device 2");
        De7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                de7.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference De8=database.getReference("Not Active : Device 3");
        De8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                de8.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference De9=database.getReference("Not Active : Device 4");
        De9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                de9.setText(""+s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference De10=database.getReference("Not Active : Device 5");
        De10.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s= (String) snapshot.getValue();
                de10.setText(""+s);

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