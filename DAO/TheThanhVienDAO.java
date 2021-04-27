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
import ConnectDB.MySQLConnect;

/**
 *
 * @author Dell
 */
public class TheThanhVienDAO {
    Connection connect=null;
    Statement statement=null;
    ResultSet result=null;
    MySQLConnect conn=new MySQLConnect("caphedb");

    public TheThanhVienDAO() {
        if(connect==null){
            try {
                connect=conn.getConnect();
                statement=conn.getStatement();
            } catch (Exception ex) {
                Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<TheThanhVienDTO> docDSTTV() {
        ArrayList<TheThanhVienDTO> dsttv=new ArrayList<TheThanhVienDTO>();
        try {
            String sql="select * from thethanhvien";
            result=conn.executeQuery(sql);
            while(result.next()){
                
            }
        } catch (Exception ex) {
            Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsttv;
    }
    public void themTTV(TheThanhVienDTO ttv){
        try {
            PreparedStatement stm=null;
            String sql="insert into thethanhvien values(?, ?, ?, ?)";
            stm=connect.prepareCall(sql);
            stm.setString(1,ttv.getMaTTV());
            stm.setString(2,ttv.getTenTV());
            stm.setString(3,ttv.getSDT());
            stm.setDouble(4,ttv.getDiemTichLuy());
            stm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void suaTTV(TheThanhVienDTO ttv){
        try {
            String sql="update thethanhvien set MaTV='"+ttv.getMaTTV()
                    +"', HoTen='"+ttv.getTenTV()
                    +"', SDT='"+ttv.getSDT()
                    +", Diem='"+ttv.getDiemTichLuy()+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void xoaTTV(String matv){
        try {
            String sql="delete from thethanhvien where MaTV='"+matv+"'";
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TheThanhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }        

    
}
