package com.caolambaokhanh.DTO;

public class SachDTO {
    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int maSach) {
        MaSach = maSach;
    }

    public String getTanSach() {
        return TanSach;
    }

    public void setTanSach(String tanSach) {
        TanSach = tanSach;
    }

    public String getGiaSach() {
        return GiaSach;
    }

    public void setGiaSach(String giaSach) {
        GiaSach = giaSach;
    }

    public SachDTO(int maSach, String tensach, String giaSach){
        MaSach = maSach;
        TanSach= tensach;
        GiaSach = giaSach;

    }
    int MaSach;
    String TanSach, GiaSach;

}
