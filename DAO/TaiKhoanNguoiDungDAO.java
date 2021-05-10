/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.TaiKhoanNguoiDungDTO;
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
public class TaiKhoanNguoiDungDAO {
    Connection connect=null;
    Statement statement=null;
    ResultSet result=null;
    MySQLConnect conn=new MySQLConnect("coffee");
    
    public TaiKhoanNguoiDungDAO() throws SQLException{
        if(connect==null){
            try {
                connect=conn.getConnect();
                statement=conn.getStatement();
            } catch (Exception ex) {
                Logger.getLogger(TaiKhoanNguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ArrayList docDSND(){
        ArrayList<TaiKhoanNguoiDungDTO> dsnd=new ArrayList<TaiKhoanNguoiDungDTO>();
        try {
            String sql="select * from taikhoannd";
            result=conn.executeQuery(sql);
            while(result.next()){
                TaiKhoanNguoiDungDTO nd=new TaiKhoanNguoiDungDTO();
                nd.setUsername(result.getString(1));
                nd.setPassword(result.getString(2));
                dsnd.add(nd);
            }
        } catch (Exception ex) {
            Logger.getLogger(TaiKhoanNguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return dsnd;
    }
    public void add(TaiKhoanNguoiDungDTO nd){
        PreparedStatement stm=null;
        try {
            String sql="insert into taikhoannd values(?, ?)";
            stm = connect.prepareCall(sql);
            stm.setString(1,nd.getUsername());
            stm.setString(2,nd.getPassword());
            stm.executeUpdate(sql);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Lá»—i ghi thÃ´ng tin tÃ i khoáº£n ngÆ°á»�i dÃ¹ng.");
        }
    }
//    public void update(TaiKhoanNguoiDungDTO nd){
//        try {
//            String sql="update taikhoanND set username='"+nd.getUsername()+
//                    "', TenND='"+nd.getPassword()+"'";
//            statement.executeUpdate(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(TaiKhoanNguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    } 
    public boolean delete(String username){
    
        try {
            String sql="delete from taikhoanND where username='"+username+"'";
            return statement.executeUpdate(sql)>0;
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanNguoiDungDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
