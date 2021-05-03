package BUS;

import DAO.*;
import java.util.ArrayList;
import DTO.*;

public class GetData {
    Query data = new Query();
    public static ArrayList<HoaDon> dshd;
    public static ArrayList<ChuongTrinhKhuyenMai> dsctkm;
    public static ArrayList<SanPham> dssp;
    public static ArrayList<ChiTietHD> dscthd;
    public static ArrayList<ChiTietSP> dsctsp;
    public GetData(){
    }
    
//Hoa Don 
    public void LoadHD(){
        if(dshd == null){
           dshd = new ArrayList<>();
        }  
        dshd = data.LoadHD();
    }
    public boolean InsertHD(HoaDon hd){       
        if(data.InsertHD(hd)){
            dshd.add(hd); 
            return true;
        } 
        return false;
    }
    public boolean DeleteHD(String hd){
        if(data.DeleteHD(hd)){ 
            return true;
        } 
        return false;         
    }
    public boolean UpdateHD(HoaDon hd, String a){
        if(data.UpdateHD(hd, a)){ 
            return true;
        } 
        return false; 
    }
    
//Chuong Trinh Khuyen Mai
    public void LoadKM(){
        if(dsctkm == null){
           dsctkm= new ArrayList<>();
        }  
        dsctkm = data.LoadKM();
    }
    public boolean InsertKM(ChuongTrinhKhuyenMai ctkm){       
        if(data.InsertKM(ctkm)){
            dsctkm.add(ctkm); 
            return true;
        } 
        return false;
    }
    public boolean DeleteKM(String km){
        if(data.DeleteKM(km)){ 
            return true;
        } 
        return false;           
    }
    public boolean UpdateKM(ChuongTrinhKhuyenMai ctkm, String a){
        if(data.UpdateKM(ctkm, a)){ 
            return true;
        } 
        return false; 
    }
            
//Chi Tiet Hoa Don
    public void LoadCTHD(){
        if(dscthd == null){
            dscthd = new ArrayList<>();
        }
        dscthd = data.LoadCTHD();
    }
    public boolean DeleteCTHD(String maKM,String maMon){
        if(data.DeleteCTHD(maKM, maMon)){ 
            return true;
        } 
        return false; 
    }
    public boolean UpdateCTHD(ChiTietHD cthd, String maHD, String maMon){
        if(data.UpdateCTHD(cthd, maHD, maMon)){ 
            return true;
        } 
        return false; 
    }
    public boolean InsertCTHD(ChiTietHD cthd){
        if(data.InsertCTHD(cthd)){
            dscthd.add(cthd);
            return true;
        }
        return false;
    }
    
//San Pham
    public void LoadSP(){
        if(dssp == null){
           dssp = new ArrayList<>();
        }  
        dssp = data.LoadSP();
    }
    public boolean InsertSP(SanPham sp){       
        if(data.InsertSP(sp)){
            dssp.add(sp); 
            return true;
        } 
        return false;
    }
    public boolean DeleteSP(String sp){
        if(data.DeleteSP(sp)){ 
            return true;
        } 
        return false;          
    }
    public boolean UpdateSP(SanPham sp, String a){
        if(data.UpdateSP(sp, a)){ 
            return true;
        } 
        return false; 
    }
    

//Chi Tiet San Pham    
    public void LoadCTSP(){
        if(dsctsp == null){
           dsctsp = new ArrayList<>();
        }  
        dsctsp = data.LoadCTSP();
    }
    public boolean DeleteCTSP(String maMon,String maNL){
        if(data.DeleteCTSP(maMon, maNL)){ 
            return true;
        } 
        return false; 
    }
    public boolean UpdateCTSP(ChiTietSP ctsp, String maMon, String maNL){
        if(data.UpdateCTSP(ctsp, maMon, maNL)){ 
            return true;
        } 
        return false; 
    }
    public boolean InsertCTSP(ChiTietSP ctsp){
        if(data.InsertCTSP(ctsp)){
            dsctsp.add(ctsp);
            return true;
        }
        return false;
    }
}
