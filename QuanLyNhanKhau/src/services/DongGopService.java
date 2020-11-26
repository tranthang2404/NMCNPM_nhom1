/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.EventModel;
import models.PaymentModel;

/**
 *
 * @author Thang
 */
public class DongGopService {
    public boolean addEvent(EventModel event){
        return true;
    }
    
    public boolean addPayment(PaymentModel payment){
        return true;
    }
    public List<EventModel> getAllEvents(){
        try{
            Connection conn = MysqlConnection.getMysqlConnection();
            if(conn == null) return null;
            Statement stat = conn.createStatement();

//            String sql = " insert into app_user(id,name,passwd) values(2,'admin2','adminpw2');   " +
//                    " insert into app_user(id,name,passwd) values(3,'admin3','adminpw3')" ;
            String sql = "select * from su_kien";
            ResultSet rs = stat.executeQuery(sql);

            System.out.println(sql);
            List<EventModel> lstEvent = new ArrayList<>();

            while (rs.next()) {
                EventModel e = new EventModel();
                e.setId(rs.getInt("id")) ;
                e.setTensukien(rs.getString("tensukien").trim() );
                e.setBatbuoc(rs.getInt("batbuoc"));
                e.setDongTheoHokhau(rs.getInt("dongTheoHokhau"));
                e.setDongTheoNhanKhau(rs.getInt("dongTheoNhanKhau"));
                e.setThoigian(rs.getTimestamp("thoigian"));
                lstEvent.add(e);

            }
            // close connection
            conn.close();
            return lstEvent;
        }catch(Exception e) {
            return null;
        }

    };
    
    public List<PaymentModel> getAllPayments(int idSukien){
        try{
            Connection conn = MysqlConnection.getMysqlConnection();
            if(conn == null) return null;
            String sql = "select * from dong_gop where idSukien = " + idSukien;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            List<PaymentModel> lst = new ArrayList<>();
            while (rs.next()) {
                PaymentModel p = new PaymentModel();
                p.setId(rs.getInt("id"));
                p.setIdSukien(rs.getInt("idSukien"));
                p.setGhichu(rs.getString("ghichu"));
                p.setThoigian(rs.getTimestamp("thoigian"));
                p.setIdHoKhau(rs.getString("idHoKhau"));
                p.setSoTienDaDong(rs.getInt("sotien"));
                String idHoKhau = rs.getString("idHoKhau");
                String sqltmp = "Select * from nhan_khau where ID = (SELECT idChuHo from ho_khau where maHoKhau = '" + idHoKhau+"')";
                Statement stat2 = conn.createStatement();
                ResultSet rs2 = stat2.executeQuery(sqltmp);
                while(rs2.next()){
                    p.setTenChuHo(rs2.getString("hoTen"));
                    break;
                }
                 lst.add(p);
            }

            return lst;
        }catch(Exception e) {
            
            return null;
        }
    };
}
