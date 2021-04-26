package BUS;

import DAO.*;
import java.util.ArrayList;
import DTO.*;

public class GetDataBUS {
    QueryDAO data = new QueryDAO();
    public static ArrayList<HoaDonDTO> dshd;
    public static ArrayList<ChuongTrinhKhuyenMaiDTO> dsctkm;
    public static ArrayList<SanPhamDTO> dssp;
    public static ArrayList<ChiTietCTKMDTO> dskmct;
    public static ArrayList<ChiTietHDDTO> dscthd;
    public static ArrayList<ChiTietSPDTO> dsctsp;
    public GetDataBUS(){
    }
    
//Hoa Don 
    public void LoadHD(){
        if(dshd == null){
           dshd = new ArrayList<>();
        }  
        dshd = data.LoadHD();
    }
    public boolean InsertHD(HoaDonDTO hd){       
        if(data.InsertHD(hd)){
            dshd.add(hd); 
            return true;
        } 
        return false;
    }
    public boolean DeleteHD(String hd){
        return data.DeleteHD(hd);          
    }
    public boolean UpdateHD(HoaDonDTO hd, String a){
        return data.UpdateHD(hd, a);
    }
    
//Chuong Trinh Khuyen Mai
    public void LoadKM(){
        if(dsctkm == null){
           dsctkm= new ArrayList<>();
        }  
        dsctkm = data.LoadKM();
    }
    public boolean InsertKM(ChuongTrinhKhuyenMaiDTO ctkm){       
        if(data.InsertKM(ctkm)){
            dsctkm.add(ctkm); 
            return true;
        } 
        return false;
    }
    public boolean DeleteKM(String km){
        return data.DeleteKM(km);          
    }
    public boolean UpdateKM(ChuongTrinhKhuyenMaiDTO ctkm, String a){
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
    public boolean UpdateCTKM(ChiTietCTKMDTO ctkm, String maKM, String maMon){
        return data.UpdateCTKM(ctkm, maKM, maMon);
    }
    public boolean InsertCTKM(ChiTietCTKMDTO ctkm){
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
    public boolean UpdateCTHD(ChiTietHDDTO cthd, String maHD, String maMon){
        return data.UpdateCTHD(cthd, maHD, maMon);
    }
    public boolean InsertCTHD(ChiTietHDDTO cthd){
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
    public boolean InsertSP(SanPhamDTO sp){       
        if(data.InsertSP(sp)){
            dssp.add(sp); 
            return true;
        } 
        return false;
    }
    public boolean DeleteSP(String sp){
        return data.DeleteSP(sp);          
    }
    public boolean UpdateSP(SanPhamDTO sp, String a){
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
    public boolean UpdateCTSP(ChiTietSPDTO ctsp, String maMon, String maNL){
        return data.UpdateCTSP(ctsp, maMon, maNL);
    }
    public boolean InsertCTSP(ChiTietSPDTO ctsp){
        if(data.InsertCTSP(ctsp)){
            dsctsp.add(ctsp);
            return true;
        }
        return false;
    }
}
