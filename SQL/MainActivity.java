package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText rollno,name,mark;
    Button mod,sea,del,add,view;
    TextView viewtext;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollno=findViewById(R.id.rollno);
        name=findViewById(R.id.name);
        mark=findViewById(R.id.mark);

        mod=findViewById(R.id.mod);
        sea=findViewById(R.id.sea);
        del=findViewById(R.id.del);
        add=findViewById(R.id.add);
        view=findViewById(R.id.view);

        viewtext=findViewById(R.id.viewtext);

        db=openOrCreateDatabase("dbstudent", Context.MODE_PRIVATE,null);
        db.execSQL("create table if not exists std(roll VARCHAR,name VARCHAR,mark VARCHAR)");
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stname,stroll,stmark;
                stname=name.getText().toString();
                stroll=rollno.getText().toString();
                stmark=mark.getText().toString();
                if (name.getText().toString().isEmpty()||rollno.getText().toString().isEmpty()||mark.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter all fedild", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    db.execSQL("update std set name='"+stname+"',mark='"+stmark+"' where roll='"+stroll+"'");
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }
                name.setText("");
                rollno.setText("");
                mark.setText("");
            }

        });

        sea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewtext.setText("");
                String stname,stroll,stmark;
                stname=name.getText().toString();
                stroll=rollno.getText().toString();
                stmark=mark.getText().toString();
                if (rollno.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter Roll no", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Cursor cu=db.rawQuery("select * from std where roll='"+stroll+"'",null);
                    String st="";
                    if (cu.moveToFirst()) {
                        st = st + "Roll No:" + cu.getString(0) + "  Name:" + cu.getString(1) + "  Marks:" + cu.getString(2) + "\n";
                        viewtext.setText(st);
                    }
                }
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stname,stroll,stmark;
                stname=name.getText().toString();
                stroll=rollno.getText().toString();
                stmark=mark.getText().toString();
                if (rollno.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter Roll no", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    db.execSQL("delete from std where roll='"+stroll+"'");
                    Toast.makeText(MainActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                }
                name.setText("");
                rollno.setText("");
                mark.setText("");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String stname,stroll,stmark;
                stname=name.getText().toString();
                stroll=rollno.getText().toString();
                stmark=mark.getText().toString();
                if (name.getText().toString().isEmpty()||rollno.getText().toString().isEmpty()||mark.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Fill all feild", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ContentValues cv=new ContentValues();
                    cv.put("roll",stroll);
                    cv.put("name",stname);
                    cv.put("mark",stmark);
                    db.insert("std",null,cv);
                    Toast.makeText(MainActivity.this, "Add", Toast.LENGTH_SHORT).show();
                }
                name.setText("");
                rollno.setText("");
                mark.setText("");
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewtext.setText("");
                Cursor cu=db.rawQuery("select * from std",null);
                String st="";
                if (cu.moveToFirst()) {
                    while (!cu.isAfterLast()) {
                        st = st + "Roll No:" + cu.getString(0) + "  Name:" + cu.getString(1) + "  Marks:" + cu.getString(2) + "\n";
                        cu.moveToNext();
                    }
                    viewtext.setText(st);
                }
            }
        });
    }
}