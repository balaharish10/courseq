package com.example.courseq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ad1 extends AppCompatActivity {
    private EditText ed1, ed2, ed3;
    private Button btn;
    database1 db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad1);
        db=new database1(this);
        ed1 = (EditText) findViewById(R.id.e2);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        btn = (Button) findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String s1=ed1.getText().toString();
                String s2=ed2.getText().toString();
                String s3=ed3.getText().toString();
                boolean d=db.insert(s1,s2,s3);
                if(d=true)
                {
                    Toast.makeText(getApplicationContext(),"comment saved",Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }
}
