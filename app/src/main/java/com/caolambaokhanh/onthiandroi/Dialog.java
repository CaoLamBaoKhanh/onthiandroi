package com.caolambaokhanh.onthiandroi;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.caolambaokhanh.DTO.SachDTO;
import com.caolambaokhanh.Database.CreateDatabase;

import java.util.ArrayList;
import java.util.List;

public class Dialog extends AppCompatActivity {
    CreateDatabase database;
    Button btnLuu,btnThoat, btnXoa, btnSua;
    EditText edMaSach, edTenSach, edGiaSach;
    List<Integer> maSach;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog);
        database = new CreateDatabase(this);

        linkView();
        addEvent();
    }

    private void linkView() {
        btnLuu = findViewById(R.id.btnLuu);
        btnThoat = findViewById(R.id.btnThoat);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        edMaSach = findViewById(R.id.edMaSach);
        edTenSach = findViewById(R.id.edTenSach);
        edGiaSach = findViewById(R.id.edGiaSach);
    }

    private void addEvent() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=edMaSach.getText().toString();
                String name = edTenSach.getText().toString();
                String price= edGiaSach.getText().toString();
                if(!name.equals("")&&!price.equals("")&&!id.equals("")&&kiemtra()!=0){
                    database.execQuery("INSERT INTO "+ database.TBL_NAME + " VALUES("+Integer.parseInt(id)+ ", '" + name + "', "+ Double.parseDouble(price) + ")");
                    finish();
                }
                else {
                    Toast.makeText(Dialog.this, "That bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    int kiemtra(){
        maSach= new ArrayList<>();
        Cursor cursor= database.getData("SELECT * FROM "+ database.TBL_NAME);
        maSach.clear();
        int ma=Integer.parseInt(edMaSach.getText().toString());
        while (cursor.moveToNext()){
            maSach.add( cursor.getInt(0));
        }
        cursor.close();
        for(int i=0; i<maSach.size();i++){
            if(ma==maSach.get(i)){
                return 0;
            }
        }
        return 1;
    }
}
