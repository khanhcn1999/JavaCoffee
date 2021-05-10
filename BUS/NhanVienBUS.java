/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Dell
 */
public class NhanVienBUS {
    public static ArrayList<NhanVienDTO> DSNV;

    public NhanVienBUS() {
    }
    public void docDSNV(){
        try {
            NhanVienDAO data=new NhanVienDAO();
            if(DSNV==null) DSNV=new ArrayList<NhanVienDTO>();
            DSNV=data.docDSNV();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean themNV(NhanVienDTO nv){
        try {
            NhanVienDAO data=new NhanVienDAO();
            if(data.add(nv)){
                DSNV.add(nv);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public ArrayList<NhanVienDTO> timKiem(String keyword){
        ArrayList<NhanVienDTO> nvList=new ArrayList<>();
        for(NhanVienDTO nv: DSNV)
//            if(nv.getMaNV().contains(keyword) || nv.getTenNv().contains(keyword)) 
             if(Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE).matcher(nv.getTenNv()).find()
                     || nv.getMaNV().contains(keyword)) nvList.add(nv);
        return nvList;
    }
    public boolean suaNV(int index, NhanVienDTO nv){
        try {
            NhanVienDAO data=new NhanVienDAO();
            if(data.update(nv)){
                DSNV.set(index, nv);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean setTTLamviec(String manv){
        try {
            NhanVienDAO data=new NhanVienDAO();
            if(data.TTLamviec(manv)) return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
}