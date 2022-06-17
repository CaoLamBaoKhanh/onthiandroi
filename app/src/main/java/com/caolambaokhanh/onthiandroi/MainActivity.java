package com.caolambaokhanh.onthiandroi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnActivity1;
    Button btnActivity2;
    Button btnlgn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkView();
        addEvent();
    }

    private void linkView() {
        btnActivity1 = findViewById(R.id.btnActivity1);
        btnActivity2 = findViewById(R.id.btnActivity2);
        btnlgn = findViewById(R.id.btnlgn);
    }

    private void addEvent() {
        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iActivity1 = new Intent(MainActivity.this, Bai1Activity.class);
                startActivity(iActivity1);
            }
        });
        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iActivity2 = new Intent(MainActivity.this, Bai2Activity.class);
                startActivity(iActivity2);
            }
        });
        btnlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ilgn= new Intent(MainActivity.this, lgnActivity.class);
                startActivity(ilgn);
            }
        });
    }
}