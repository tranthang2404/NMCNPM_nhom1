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
public class PaymentModel {
    private int id;
    private int idSukien;
    private String idHoKhau;
    private String tenChuHo;
    private int soTienDaDong;
    private Date thoigian;
    private String ghichu;

    public int getIdSukien() {
        return idSukien;
    }

    public void setIdSukien(int idSukien) {
        this.idSukien = idSukien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(String idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public int getSoTienDaDong() {
        return soTienDaDong;
    }

    public void setSoTienDaDong(int soTienDaDong) {
        this.soTienDaDong = soTienDaDong;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
}
