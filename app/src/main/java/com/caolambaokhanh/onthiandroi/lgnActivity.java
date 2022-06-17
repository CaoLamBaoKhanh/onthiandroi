package com.caolambaokhanh.onthiandroi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class lgnActivity extends AppCompatActivity {
    EditText editText;
    String sa,sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lgn);
        linkView();
        GridLayout layout = (GridLayout) this.findViewById(R.id.gridlayout);

        for (int i = 1; i<=4; i++){
            final Random random = new Random();
            int d9roll = random.nextInt((100))+1;
            EditText textView = new EditText(this);
            Button button = new Button(this);
            button.setText(""+d9roll);
            button.setId(i);
            textView.setText(""+d9roll);
            textView.setTextSize(25);
            textView.setId(i);
            if(d9roll %2!=0 ){
                textView.setWidth(300);
                layout.addView(textView);
            }
            else {
                textView.setWidth(300);
                layout.addView(button);
            }
            //click
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText textView1 = (EditText) v;
                    sa = textView1.getText().toString();
                    editText.setText(sa);
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button1 = (Button) v;
                    sb = button1.getText().toString();
                    editText.setText(sb);
                }
            });
        }
    }

    private void linkView() {
        editText = findViewById(R.id.Editnumber);
    }
}

