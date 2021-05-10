package BUS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DAO.TaiKhoanNguoiDungDAO;
import DAO.TaiKhoanNguoiDungDAO;
import DTO.TaiKhoanNguoiDungDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dell
 */
public class TaiKhoanNguoiDungBUS {
    public static ArrayList<TaiKhoanNguoiDungDTO> DSND;

    public TaiKhoanNguoiDungBUS() {
    }
    public void docDSND(){
        try {
            TaiKhoanNguoiDungDAO data=new TaiKhoanNguoiDungDAO();
            if(DSND==null) DSND=new ArrayList<TaiKhoanNguoiDungDTO>();
            DSND=data.docDSND();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanNguoiDungBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void themND(TaiKhoanNguoiDungDTO user){
        try {
            TaiKhoanNguoiDungDAO data=new TaiKhoanNguoiDungDAO();
//            data.addND(user);
            DSND.add(user);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanNguoiDungBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
//    public void suaND(TaiKhoanNguoiDungDTO user){
//        try {
//            TaiKhoanNguoiDungDAO data=new TaiKhoanNguoiDungDAO();
////            data.updateND(user);
//        } catch (SQLException ex) {
//            Logger.getLogger(TaiKhoanNguoiDungBUS.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public boolean xoaND(int index, String username){
        try {
            TaiKhoanNguoiDungDAO data=new TaiKhoanNguoiDungDAO();
            if(data.delete(username)) {
                DSND.remove(index);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanNguoiDungBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }     
}

   
   
    

