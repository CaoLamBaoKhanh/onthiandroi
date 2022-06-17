package com.caolambaokhanh.onthiandroi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Bai1Activity extends AppCompatActivity {
    Button btnDraw;
    EditText edtNumofvalue;
    LinearLayout layoutContainer;
    Random random= new Random();
    public final int MSG_UPDATE_UI=1;
    public final int MSG_UPDATE_UI_DONE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bai1);
        linkView();
        addEvent();
    }

    private void addEvent() {
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runBackgroundThread();
            }
        });
    }

    private void linkView() {
        edtNumofvalue=findViewById(R.id.edShow);
        btnDraw=findViewById(R.id.btnDrawView);
        layoutContainer=findViewById(R.id.layoutContener);
    }
    Handler handler= new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg){
            switch (msg.what){
                case MSG_UPDATE_UI:
                    int percent= (int)msg.arg1;
                    int numb=(int)msg.obj;
                    LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    if(msg.arg1%2==0){
                        Button button= new Button(Bai1Activity.this);
                        button.setText(""+numb);
                        button.setLayoutParams(params);
                        layoutContainer.addView(button);
                    }
                    else{
                        EditText editText= new EditText(Bai1Activity.this);
                        editText.setLayoutParams(params);
                        layoutContainer.addView(editText);
                    }

                    break;
                case MSG_UPDATE_UI_DONE:
                    Toast.makeText(Bai1Activity.this, "DONE", Toast.LENGTH_SHORT).show();
                    break;
                default: break;
            }
        }
    };
    private void runBackgroundThread() {
        int numb=Integer.parseInt(edtNumofvalue.getText().toString());
        layoutContainer.removeAllViews();
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i= 1; i<=numb; i++){
                    Message msg= new Message();
                    msg.what=MSG_UPDATE_UI;
                    msg.arg1=i;
                    msg.obj= random.nextInt(100);
                    handler.sendMessage(msg);
                    SystemClock.sleep(100);
                }
                handler.sendEmptyMessage(MSG_UPDATE_UI_DONE);
            }
        });
        thread.start();
    }
}
