package com.example.courseq;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class r1 extends AppCompatActivity {
EditText ed;
Button b1,b2;
TextView tv1;
database1 db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r1);
        db=new database1(this);
        b1=findViewById(R.id.b1);
        tv1=findViewById(R.id.tv1);
        ed=findViewById(R.id.ed);
        b2=findViewById(R.id.b2);
        display();
        display2();

    }
    public void display() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor result = db.view();
                if (result.getCount()==0) {
                   show("error","no comments");
                   return;

                }
StringBuilder buffer=new StringBuilder();
                while(result.moveToNext())
                {
                    buffer.append("subject:"+result.getString(0)+"\n");
                    buffer.append("rating:"+result.getString(1)+"\n");
                    buffer.append("remark:"+result.getString(2)+"\n" +"\n\n");
                }
                tv1.setText(buffer.toString());
            }
        });
    }
    public void display2()
    {
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=ed.getText().toString();
                Cursor result = db.view2(s);
                if (result.getCount()==0) {
                    show("error","no comments");
                    return;

                }
                StringBuilder buffer=new StringBuilder();
                while(result.moveToNext())
                {
                    buffer.append("subject:"+result.getString(0)+"\n");
                    buffer.append("rating:"+result.getString(1)+"\n");
                    buffer.append("remark:"+result.getString(2)+"\n" +"\n\n");
                }
                tv1.setText(buffer.toString());
            }
        });
    }
public void show(String title,String message)
{
    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setCancelable(true);
    builder.setTitle(title);
    builder.setMessage(message);
    builder.show();
}
}
