package com.example.courseq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
private EditText ed,ed1;
private Button btn;
userdatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       db=new userdatabase(this);
        ed=(EditText)findViewById(R.id.ed);
        ed1=(EditText)findViewById(R.id.e2);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=ed.getText().toString();
                String s2=ed1.getText().toString();
                boolean result=db.logincheck(s1,s2);
                if(result==true)
                {
                    Intent in=new Intent(login.this,act2.class);
                    startActivity(in);
            }
                else
                    Toast.makeText(getApplicationContext(),"TRY AGAIN",Toast.LENGTH_SHORT).show();
        }
    });
    }
}
