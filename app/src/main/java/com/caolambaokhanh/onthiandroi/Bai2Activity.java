package com.caolambaokhanh.onthiandroi;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.caolambaokhanh.Adater.SachAdapter;
import com.caolambaokhanh.DTO.SachDTO;
import com.caolambaokhanh.Database.CreateDatabase;

import java.util.ArrayList;
import java.util.List;

public class Bai2Activity extends AppCompatActivity {
    ListView lvSach;
    CreateDatabase database;
    SachAdapter sachAdapter;
    List<SachDTO> sachDTOList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bai2);
        prepareDB();

        linkView();
        loadData();
        addEvent();
    }

    private void prepareDB() {
        database= new CreateDatabase(this);
        database.crateSomeDefaultProduct();
    }

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }

    private void loadData() {
        sachDTOList= new ArrayList<>();
        Cursor cursor= database.getData("SELECT * FROM "+ database.TBL_NAME);
        sachDTOList.clear();
        while (cursor.moveToNext()){
            sachDTOList.add(new SachDTO( cursor.getInt(0),cursor.getString(1), cursor.getString(2)));
        }
        cursor.close();
        sachAdapter =  new SachAdapter(Bai2Activity.this,R.layout.custom_layout_bai2,sachDTOList);
        lvSach.setAdapter(sachAdapter);
    }
    private void linkView() {
        lvSach = findViewById(R.id.lvSach);
    }

    private void addEvent() {
        lvSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent dialog= new Intent(Bai2Activity.this, Dialog.class);
                startActivity(dialog);
                return false;
            }
        });
    }
    //xoa
/*  db.execQuery("DELETE FROM " +Mydatabase.TBL_NAME+ " WHERE ProductId="+productId );
    loadData();*/
    //update
/*String name = edtName.getText().toString();
    double price= Double.parseDouble(edtPrice.getText().toString());
    db.execQuery("UPDATE "+ Mydatabase.TBL_NAME + " SET " + Mydatabase.COL_NAME+ " = '"+ name + "', "+ Mydatabase.COL_PRICE+ " = "+ price+ " WHERE " +Mydatabase.COL_ID+ " = "+p.getProductId());*/

}
