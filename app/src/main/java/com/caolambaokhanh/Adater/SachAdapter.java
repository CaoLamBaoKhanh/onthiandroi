package com.caolambaokhanh.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.caolambaokhanh.DTO.SachDTO;
import com.caolambaokhanh.onthiandroi.R;

import java.util.List;

public class SachAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<SachDTO> sachDTOList;
    ViewHolderSach viewHolderSach;
    public SachAdapter(Context context, int layout, List<SachDTO> sachDTOList){
        this.context = context;
        this.layout = layout;
        this.sachDTOList = sachDTOList;
    }

    @Override
    public int getCount() {
        return sachDTOList.size();
    }

    @Override
    public Object getItem(int position) {
        return sachDTOList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        if(view == null){
            viewHolderSach = new ViewHolderSach();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            viewHolderSach.txtMaSach = view.findViewById(R.id.txtMaSach);
            viewHolderSach.txtTenSach = view.findViewById(R.id.txtTenSach);
            viewHolderSach.txtGiaSach = view.findViewById(R.id.txtGiaSach);

            view.setTag(viewHolderSach);

        }
        else {
            viewHolderSach = (ViewHolderSach) view.getTag();
        }
        SachDTO sachDTO = sachDTOList.get(position);
        viewHolderSach.txtMaSach.setText(String.valueOf(sachDTO.getMaSach()));
        viewHolderSach.txtTenSach.setText(sachDTO.getTanSach());
        viewHolderSach.txtGiaSach.setText(sachDTO.getGiaSach());

        return view;
    }

    public class ViewHolderSach{
        TextView txtMaSach, txtTenSach, txtGiaSach;
    }
}
