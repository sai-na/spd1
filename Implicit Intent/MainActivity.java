package com.example.implicitintent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    Button dail,gallery,geo,web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dail=findViewById(R.id.dail);
        gallery=findViewById(R.id.gallery);
        geo=findViewById(R.id.geo);
        web=findViewById(R.id.web);
        dail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1=new
                        Intent(Intent.ACTION_DIAL,Uri.parse("tel:+918593014459"));
                startActivity(in1);
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1=new
                        Intent(Intent.ACTION_VIEW,Uri.parse("content://media/external/images/media/"));
                        startActivity(in1);
            }
        });
        geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1=new
                        Intent(Intent.ACTION_VIEW,Uri.parse("geo:10.175456,76.459512"))
                        ;
                startActivity(in1);
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1=new
                        Intent(Intent.ACTION_VIEW,Uri.parse("https://ssmpoly.ac.in"));
                startActivity(in1);
            }
        });
    }
}