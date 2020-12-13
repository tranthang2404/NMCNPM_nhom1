/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.EventModel;
import models.PaymentModel;

/**
 *
 * @author Administrator
 */
public class DongGopService {
    
    
    public boolean addEvent(EventModel event){
         try{
            Connection conn = MysqlConnection.getMysqlConnection();
            if(conn == null) return false;
            String sql = "insert into su_kien(tensukien, batbuoc, dongTheoHokhau, dongTheoNhanKhau  ) values( ?, ?, ?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, event.getTensukien());
            stat.setInt(2, event.getBatbuoc());
            stat.setInt(3, event.getDongTheoHokhau());
            stat.setInt(4, event.getDongTheoNhanKhau());
            stat.executeUpdate();

            return true;
        }catch(Exception e) {

            return false;
        }
    }
     public boolean delEvent(int eventID){
        try{
            Connection conn = MysqlConnection.getMysqlConnection();
            if(conn == null) return false;
            String sql = "DELETE FROM su_kien WHERE id=" + eventID ;
            Statement stat = conn.createStatement();
            stat.execute(sql);

            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean addPayment(PaymentModel payment){
        try{
            Connection conn = MysqlConnection.getMysqlConnection();
            if(conn == null) return false;
            String sql = "insert into dong_gop(idHoKhau, idSukien, sotien, ghichu ) values( ?, ?, ?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, payment.getIdHoKhau());
            stat.setInt(2, payment.getIdSukien());
            stat.setInt(3, payment.getSoTienDaDong());
            stat.setString(4, payment.getGhichu());
            stat.executeUpdate();

            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean updateEvent(int eventID, String tenEvent, int batBuoc, int dongHokhau, int dongNhankhau){
        try{
            Connection conn = MysqlConnection.getMysqlConnection();
            if(conn == null) return false;
            String sql = "UPDATE su_kien SET tensukien=?,batbuoc=?,dongTheoHokhau=?,dongTheoNhanKhau=? WHERE id=?";
             PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tenEvent);
            stat.setInt(2, batBuoc);
            stat.setInt(3, dongHokhau);
            stat.setInt(4, dongNhankhau);
            stat.setInt(5, eventID);
            stat.executeUpdate();

            return true;

        }catch(Exception e){
            return false;
        }
    } 
    
     public boolean delPayment(int paymentID){
        try{
            Connection conn = MysqlConnection.getMysqlConnection();
            if(conn == null) return false;
            String sql = "DELETE FROM dong_gop WHERE id=" + paymentID ;
            Statement stat = conn.createStatement();
            stat.execute(sql);

            return true;
        }catch(Exception e){
            return false;
        }
    }
     
    public boolean updatePayment(int paymentID, int sotien, String ghichu){
        try{
            Connection conn = MysqlConnection.getMysqlConnection();
            if(conn == null) return false;
            String sql = "UPDATE dong_gop SET sotien=?,ghichu=? WHERE id=?";
             PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, sotien);
            stat.setString(2, ghichu);
            stat.setInt(3, paymentID);
            stat.executeUpdate();

            return true;

        }catch(Exception e){
            return false;
        }
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
    
      public int totalPayment(int idSukien){
        try{
            Connection conn = MysqlConnection.getMysqlConnection();
            if(conn == null) return 0;
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
            int sum = 0;
            for(int i = 0; i<lst.size();i++){
                sum += lst.get(i).getSoTienDaDong();
            }

            return sum;
        }catch(Exception e) {
            
            return 0;
        }
    };
}
