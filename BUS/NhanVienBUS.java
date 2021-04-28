package BUS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.NhanVienDAO;
import DTO.NhanVien;

public class NhanVienBUS {
    public static ArrayList<NhanVien> DSNV;

    public NhanVienBUS() {
    }
    public ArrayList<NhanVien> docDSNV(){
        try {
            NhanVienDAO data=new NhanVienDAO();
            if(DSNV==null) DSNV=new ArrayList<NhanVien>();
            DSNV=data.docDSNV();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
		return DSNV;
    }
    void addNV(NhanVien nv){
        try {
            NhanVienDAO data=new NhanVienDAO();
            data.addNV(nv);
            DSNV.add(nv);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    NhanVien timkiem(String manv){
        for(NhanVien nv: DSNV)
            if(nv.getMaNV()==manv) return nv;
        return null;
    }
    void sua(NhanVien nv){
        try {
            NhanVienDAO data=new NhanVienDAO();
            data.updateNV(nv);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void thoiViec(String manv){
        try {
            NhanVienDAO data=new NhanVienDAO();
            data.updateThoiViec(manv);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}