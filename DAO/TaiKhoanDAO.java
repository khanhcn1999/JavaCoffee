/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectDB.MySQLConnect;
import DTO.TaiKhoanNguoiDungDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class TaiKhoanDAO {
    Connection connect=null;
    Statement statement=null;
    ResultSet result=null;
    MySQLConnect conn=new MySQLConnect("caphedb");
    
    public TaiKhoanDAO() throws SQLException{
        if(connect==null){
            try {
                connect=conn.getConnect();
                statement=conn.getStatement();
            } catch (Exception ex) {
                Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ArrayList docDSND(){
        ArrayList<TaiKhoanNguoiDungDTO> dsnd=new ArrayList<TaiKhoanNguoiDungDTO>();
        try {
            String sql="select * from taikhoanND";
            result=conn.executeQuery(sql);
            while(result.next()){
                TaiKhoanNguoiDungDTO nd=new TaiKhoanNguoiDungDTO();
                nd.setUsername(result.getString(1));
                nd.setPassword(result.getString(2));
                dsnd.add(nd);
            }
        } catch (Exception ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return dsnd;
    }
    public void add(TaiKhoanNguoiDungDTO nd){
        PreparedStatement stm=null;
        try {
            String sql="insert into taikhoannguoidung values(?, ?)";
            stm = connect.prepareCall(sql);
            stm.setString(1,nd.getUsername());
            stm.setString(2,nd.getPassword());
            
            stm.execute();
            
        } catch (SQLException ex) {
        }
    }
    public void update(TaiKhoanNguoiDungDTO nd){
        try {
            String sql="update taikhoanND set username='"+nd.getUsername()+
                    "', TenND='"+nd.getPassword()+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.Close();
            } catch (Exception ex) {
                Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
}
