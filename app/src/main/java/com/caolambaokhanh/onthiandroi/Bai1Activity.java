package com.caolambaokhanh.onthiandroi;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai1Activity extends AppCompatActivity {
    LinearLayout layoutContener;
    Button btnDrawView;
    EditText edShow;

    LinearLayout.LayoutParams layoutParams =new LinearLayout.LayoutParams(500, ViewGroup.LayoutParams.MATCH_PARENT);
    Handler handler =new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bai1);

        linkView();
        addEvent();
    }

    private void linkView() {
        layoutContener = findViewById(R.id.layoutContener);
        btnDrawView = findViewById(R.id.btnDrawView);
        edShow = findViewById(R.id.edShow);
    }

    private void addEvent() {
        btnDrawView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runBackgroundThread();
            }
        });
    }

    private void runBackgroundThread() {
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                //tạo ra view
            }
        });
        thread.start();
    }
    //chạy uithread
    Runnable UIThread =new Runnable() {
        @Override
        public void run() {
            ImageButton button =new ImageButton(Bai1Activity.this);
            button.setLayoutParams(layoutParams);
            //thuc hien code

            layoutContener.addView(button);
        }
    };
}
