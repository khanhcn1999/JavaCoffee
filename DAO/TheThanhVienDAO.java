/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TheThanhVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class TheThanhVienDAO {
    Connection connect=null;
    Statement statement=null;
    ResultSet result=null;
    MySQLConnect conn=new MySQLConnect("coffee");

    public TheThanhVienDAO() {
        if(connect==null){
            try {
                connect=conn.getConnect();
                statement=connect.createStatement();
            } catch (Exception ex) {
                Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<TheThanhVienDTO> docDSTTV() {
        ArrayList<TheThanhVienDTO> dsttv=new ArrayList<TheThanhVienDTO>();
        try {
            String sql="select * from thethanhvien";
            result=statement.executeQuery(sql);
            while(result.next()){
                TheThanhVienDTO tv=new TheThanhVienDTO();
                tv.setMaTTV(result.getString(1));
                tv.setTenTV(result.getString(2));
                tv.setSDT(result.getString(3));
                tv.setDiemTichLuy(result.getDouble(4));
                dsttv.add(tv);
            }
        } catch (Exception ex) {
            Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsttv;
    }
    public boolean themTTV(TheThanhVienDTO ttv){
        try {
            PreparedStatement stm=null;
            String sql="insert into thethanhvien values(?, ?, ?, ?)";
            stm=connect.prepareCall(sql);
            stm.setString(1,ttv.getMaTTV());
            stm.setString(2,ttv.getTenTV());
            stm.setString(3,ttv.getSDT());
            stm.setDouble(4,ttv.getDiemTichLuy());
            return stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean suaTTV(TheThanhVienDTO ttv){
        try {
            String sql="update thethanhvien set HoTen='"+ttv.getTenTV()
                    +"', SDT='"+ttv.getSDT()
                    +"' where MaTV='"+ttv.getMaTTV()+"'";            
            return statement.executeUpdate(sql)>0;
        } catch (SQLException ex) {
            Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void suaDiem(TheThanhVienDTO ttv){
        try {
            String sql;
            sql = "update thethanhvien set Diem='"+ttv.getDiemTichLuy()+"' where MaTV='"+ttv.getMaTTV()+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean xoaTTV(String matv){
        try {
            String sql="delete from thethanhvien where MaTV='"+matv+"'";
            return statement.executeUpdate(sql)>0;
        } catch (SQLException ex) {
            Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }        

    
}
