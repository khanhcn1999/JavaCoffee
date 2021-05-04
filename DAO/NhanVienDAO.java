/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class NhanVienDAO {

    Connection connect=null;
    Statement statement=null;
    ResultSet result=null;
    MySQLConnect conn=new MySQLConnect("coffee");
    
    public NhanVienDAO() throws SQLException{
        if(connect==null){
            try {
                connect=conn.getConnect();
                statement=conn.getStatement();
            } catch (Exception ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ArrayList docDSNV(){
        ArrayList<NhanVienDTO> dsnv=new ArrayList<NhanVienDTO>();
        try {
            String sql="select * from nhanvien";
            result=conn.executeQuery(sql);
            while(result.next()){
                NhanVienDTO nv=new NhanVienDTO();
                nv.setMaNV(result.getString(1));
                nv.setHoNV(result.getString(2));
                nv.setTenNv(result.getString(3));
                nv.setEmailNV(result.getString(4));
                nv.setSdtNV(result.getString(5));
                nv.setGtinhNV(result.getString(6));
                nv.setChucVu(result.getString(7));
                nv.setTTLamViec(result.getBoolean(8));
                dsnv.add(nv);
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return dsnv;
    }
    public void add(NhanVienDTO nv){
        PreparedStatement stm=null;
        try {
            String sql="insert into nhanvien values(?, ?, ?, ?, ?, ?, ?, ?)";
            stm = connect.prepareCall(sql);
            stm.setString(1,nv.getMaNV());
            stm.setString(2,nv.getHoNV());
            stm.setString(3,nv.getTenNv());
            stm.setString(4,nv.getEmailNV());
            stm.setString(5,nv.getSdtNV());
            stm.setString(6,nv.getGtinhNV());
            stm.setString(7,nv.getChucVu());
            stm.setBoolean(8, true);
            stm.execute();
            
        } catch (SQLException ex) {
        }
    }
    public void update(NhanVienDTO nv){
        try {
            String sql="update nhanvien set HoNV='"+nv.getHoNV()+
                    "', TenNV='"+nv.getTenNv()+
                    "', Email='"+nv.getEmailNV()+
                    "', SDT='"+nv.getSdtNV()+
                    "', GioiTinh='"+nv.getGtinhNV()+
                    "', ChucVu='"+nv.getChucVu()+"' where MaNV='"+nv.getMaNV()+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
    public void TTLamviec(String Manv, String b){
        try {
            String sql="update nhanvien set TTLamViec='0' where MaNV='"+Manv+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

