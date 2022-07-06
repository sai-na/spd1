package com.example.explicitintent;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class page2 extends AppCompatActivity {
  TextView val;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_page2);

    String v = getIntent().getStringExtra("user");

    val = findViewById(R.id.wel);
    val.setText("Hello," + v);
  }
}
