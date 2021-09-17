package com.example.hvac;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
    private TextView back;

    EditText mEmail,mPassword;
    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main2);
        button= (Button) findViewById(R.id.Login);

        mEmail=findViewById(R.id.user);
        mPassword=findViewById(R.id.pass);

        fAuth=FirebaseAuth.getInstance();



        back=(TextView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openadmin_user();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("password Required");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity2.this,"Login success",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),room.class));


                        }
                        else{
                            Toast.makeText(MainActivity2.this,"error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();


                        }
                    }
                });

            }
        });
    }

    private void openadmin_user() {
        Intent intent= new Intent(this,admin_user.class);
        startActivity(intent);
    }

    private void openroom() {
        Intent intent= new Intent(this,room.class);
        startActivity(intent);
    }
}