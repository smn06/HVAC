package com.example.hvac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sos extends AppCompatActivity {
    private TextView back;
    private TextView calling;
    private EditText enumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sos);
        back=(TextView)findViewById(R.id.back);

        calling=(TextView)findViewById(R.id.call);

        enumber=(EditText) findViewById(R.id.num);

        calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone=enumber.getText().toString();

                if(phone.isEmpty()){
                    Toast.makeText(getApplicationContext(),"PLease Enter Number",Toast.LENGTH_SHORT).show();


                }
                else{
                    String s="tel:"+phone;
                    Intent intent=new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);

                }


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensupply();
            }
        });


    }

    private void opensupply() {

        Intent intent=new Intent(this,supply.class);
        startActivity(intent);

    }
}