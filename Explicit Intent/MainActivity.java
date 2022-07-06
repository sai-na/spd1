package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uname,pass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=findViewById(R.id.uname);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=uname.getText().toString();
                String passw=pass.getText().toString();

                if (passw.equals("123") && user.equals("yaseen"))
                {
                    Intent in1=new Intent(MainActivity.this,page2.class);
                    in1.putExtra("user",user);
                    in1.putExtra("pass",passw);
                    startActivity(in1);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wrong Input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}