package BUS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DAO.TaiKhoanDAO;
import DAO.TaiKhoanDAO;
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
            TaiKhoanDAO data=new TaiKhoanDAO();
            if(DSND==null) DSND=new ArrayList<TaiKhoanNguoiDungDTO>();
            DSND=data.docDSND();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanNguoiDungBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void themND(TaiKhoanNguoiDungDTO user){
        try {
            TaiKhoanDAO data=new TaiKhoanDAO();
//            data.addND(user);
            DSND.add(user);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanNguoiDungBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<TaiKhoanNguoiDungDTO> timKiem(String keyword){
        ArrayList<TaiKhoanNguoiDungDTO> userList=new ArrayList<>();
        userList=null;
        for(TaiKhoanNguoiDungDTO user: DSND)
//            if(user.getMaND().contains(keyword) || user.getTenNv().contains(keyword)) 
//             if(Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE).matcher(user.getTenNv()).find()
//                     || user.getMaND().contains(keyword))
            userList.add(user);
        return userList;
    }
//    public ArrayList<TaiKhoanNguoiDung> timTheoTenND(String ten){
//        ArrayList<TaiKhoanNguoiDung> userList=new ArrayList<>();
//        for(TaiKhoanNguoiDungDTO user: DSND){
//            if(user.getTenNv().contains(ten))
//                userList.add(user);
//        }
//        return userList;
//    }
    public void suaND(TaiKhoanNguoiDungDTO user){
        try {
            TaiKhoanDAO data=new TaiKhoanDAO();
//            data.updateND(user);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanNguoiDungBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
   
    
}
