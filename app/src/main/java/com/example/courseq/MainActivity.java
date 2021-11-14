package com.example.courseq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText e1,e2,e3;
private Button btn1,btn2;

userdatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new userdatabase(this);
        e1=(EditText)findViewById(R.id.ev1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        btn2=(Button)findViewById(R.id.b2);
        btn1=(Button)findViewById(R.id.btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if(e1.equals("")||e2.equals(""))
                    Toast.makeText(getApplicationContext(),"fields are empty",Toast.LENGTH_SHORT).show();
                else if(s2.equals(s3)){
                    boolean chkm = db.check(s1);
                    if (chkm == true) {
                        boolean insert = db.insert(s1, s2);

                    if(insert=true)
                        Toast.makeText(getApplicationContext(),"registered successfully",Toast.LENGTH_SHORT).show();
                }
                    else
                        Toast.makeText(getApplicationContext(),"already exist",Toast.LENGTH_SHORT).show();
            }
                else
                    Toast.makeText(getApplicationContext(),"password did not match",Toast.LENGTH_SHORT).show();
        }


    });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,login.class);
                startActivity(in);
            }
        });
    }
}
