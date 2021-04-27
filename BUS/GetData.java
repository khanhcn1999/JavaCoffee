package BUS;

import DAO.*;
import java.util.ArrayList;
import DTO.*;

public class GetData {
    Query data = new Query();
    public static ArrayList<HoaDon> dshd;
    public static ArrayList<ChuongTrinhKhuyenMai> dsctkm;
    public static ArrayList<SanPham> dssp;
    public static ArrayList<ChiTietCTKM> dskmct;
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
        return data.DeleteHD(hd);          
    }
    public boolean UpdateHD(HoaDon hd, String a){
        return data.UpdateHD(hd, a);
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
        return data.DeleteKM(km);          
    }
    public boolean UpdateKM(ChuongTrinhKhuyenMai ctkm, String a){
        return data.UpdateKM(ctkm, a);
    }
    
//Chi Tiet Khuyen Mai   
    public void LoadCTKM(){
        if(dskmct == null){
           dskmct = new ArrayList<>();
        }  
        dskmct = data.LoadCTKM();
    }
    public boolean DeleteCTKM(String maKM,String maMon){
        return data.DeleteCTKM(maKM, maMon);
    }
    public boolean UpdateCTKM(ChiTietCTKM ctkm, String maKM, String maMon){
        return data.UpdateCTKM(ctkm, maKM, maMon);
    }
    public boolean InsertCTKM(ChiTietCTKM ctkm){
        if(data.InsertCTKM(ctkm)){
            dskmct.add(ctkm);
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
        return data.DeleteCTKM(maKM, maMon);
    }
    public boolean UpdateCTHD(ChiTietHD cthd, String maHD, String maMon){
        return data.UpdateCTHD(cthd, maHD, maMon);
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
        return data.DeleteSP(sp);          
    }
    public boolean UpdateSP(SanPham sp, String a){
        return data.UpdateSP(sp, a);
    }
    

//Chi Tiet San Pham    
    public void LoadCTSP(){
        if(dsctsp == null){
           dsctsp = new ArrayList<>();
        }  
        dsctsp = data.LoadCTSP();
    }
    public boolean DeleteCTSP(String maMon,String maNL){
        return data.DeleteCTSP(maMon, maNL);
    }
    public boolean UpdateCTSP(ChiTietSP ctsp, String maMon, String maNL){
        return data.UpdateCTSP(ctsp, maMon, maNL);
    }
    public boolean InsertCTSP(ChiTietSP ctsp){
        if(data.InsertCTSP(ctsp)){
            dsctsp.add(ctsp);
            return true;
        }
        return false;
    }
}
