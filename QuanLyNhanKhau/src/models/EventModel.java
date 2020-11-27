/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class EventModel {
    private int id;
    private String tensukien;
        private int batbuoc;
    private int dongTheoHokhau;
    private int dongTheoNhanKhau;
    private Date thoigian;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensukien() {
        return tensukien;
    }

    public void setTensukien(String tensukien) {
        this.tensukien = tensukien;
    }

    public int getBatbuoc() {
        return batbuoc;
    }

    public void setBatbuoc(int batbuoc) {
        this.batbuoc = batbuoc;
    }

    public int getDongTheoHokhau() {
        return dongTheoHokhau;
    }

    public void setDongTheoHokhau(int dongTheoHokhau) {
        this.dongTheoHokhau = dongTheoHokhau;
    }

    public int getDongTheoNhanKhau() {
        return dongTheoNhanKhau;
    }

    public void setDongTheoNhanKhau(int dongTheoNhanKhau) {
        this.dongTheoNhanKhau = dongTheoNhanKhau;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }
    
}
