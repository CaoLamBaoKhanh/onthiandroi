package com.caolambaokhanh.Adater;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.caolambaokhanh.DTO.SachDTO;

import java.util.List;

public class SachAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<SachDTO> sachDTOList;


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}