package com.example.courseq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class act2 extends AppCompatActivity {
 private Button ad1,ad2,ad3,ad4,r1,r2,r3,r4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        ad1=(Button)findViewById(R.id.ad1);
        ad2=(Button)findViewById(R.id.ad2);

        ad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n=new Intent(act2.this,ad1.class);
                startActivity(n);

            }
        });
ad2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent r=new Intent(act2.this,r1.class);
        startActivity(r);
    }
});
    }
}
