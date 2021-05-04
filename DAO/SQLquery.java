package DAO;

import DTO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

public class SQLquery {
    private String tableHD = "hoadon";
    private String tableKM = "khuyenmai";
    private String tableCTHD = "chitiethoadon";
    private String tableSP = "sanpham";
    private String tableCTSP = "chitietsanpham";
    static Connection con = null;
    private MyConnect mycon = new MyConnect();
    public SQLquery(){
        if(con == null){
            try{
                con = mycon.connect();
            }catch(Exception ex){
                System.err.println(ex);
            }
        }
    }
    
// Hoa Don    
    public boolean InsertHD(HoaDon hd){
        String query = "Insert into " + tableHD + " (MaHD, MaNV, MaTV, MaKM, NgayLHD, TongTien, TienKhuyenMai, ThanhToan) values(?, ?, ?, ?, ?, ?, ?, ?)";
        try{    
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, hd.getMaHD());
            st.setString(2, hd.getMaNV());
            st.setString(3, hd.getMaTV());
            st.setString(4, hd.getMaKM());
            st.setString(5, hd.getNgayLHD());
            st.setDouble(6, hd.getTongTien());
            st.setDouble(7, hd.getTongKM());
            st.setDouble(8, hd.getTongTT());
            return st.executeUpdate()>0;
        }catch(SQLException ex){  
            System.err.println(ex);
        } 
        return false;
    }
    public boolean DeleteHD(String a){
        String query = "delete from " + tableHD + " where MaHD = ? ";
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, a);
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }
    public boolean UpdateHD(HoaDon hd, String a){
        String query = "update " + tableHD + " set MaNV = ?, MaTV = ?, MaKM = ?, NgayLHD = ?, TongTien = ?, TienKhuyenMai = ?, ThanhToan = ? where hoadon.MaHD = ? ";
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, hd.getMaNV());
            st.setString(2, hd.getMaTV());
            st.setString(3, hd.getMaKM());
            st.setString(4, hd.getNgayLHD());
            st.setDouble(5, hd.getTongTien());
            st.setDouble(6, hd.getTongKM());
            st.setDouble(7, hd.getTongTT());
            st.setString(8, hd.getMaHD());
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }
    public ArrayList LoadHD(){
        ArrayList<HoaDon> dshd = new ArrayList<>();
        try{
            String sql = "Select * from " + tableHD;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaTV(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayLHD(rs.getString(5));
                hd.setTongTien(Double.parseDouble(rs.getString(6)));
                hd.setTongKM(Double.parseDouble(rs.getString(7)));
                hd.setTongTT(Double.parseDouble(rs.getString(8)));
                dshd.add(hd);
            }
        }catch(SQLException e){
            System.err.println("Error");
        }  
        return dshd;
    }
      
    
//Chuong Trinh Khuyen Mai
    public boolean InsertKM(ChuongTrinhKhuyenMai ctkm){
        String query = "Insert into " + tableKM + " (MaKM, TenCT, GG, NgayBD, NgayKT) values(?, ?, ?, ?, ?)";
        try{    
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, ctkm.getMaKM());
            st.setString(2, ctkm.getTenCT());
            st.setDouble(3, ctkm.getGG());
            st.setString(4, ctkm.getNgayBD());
            st.setString(5, ctkm.getNgayKT());
            return st.executeUpdate()>0;
        }catch(SQLException ex){  
            System.err.println(ex);
        } 
        return false;
    }
    public boolean DeleteKM(String a){
        String query = "delete from " + tableKM + " where MaKM = ? ";
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, a);
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }
    public boolean UpdateKM(ChuongTrinhKhuyenMai ctkm, String a){
        String query = "update " + tableKM + " set TenCT = ?, GG = ?, NgayBD = ?, NgayKT = ? where MaKM = ?";
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, ctkm.getTenCT());
            st.setDouble(2, ctkm.getGG());
            st.setString(3, ctkm.getNgayBD());
            st.setString(4, ctkm.getNgayKT());
            st.setString(5, ctkm.getMaKM());
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }  
    public ArrayList LoadKM(){
        ArrayList<ChuongTrinhKhuyenMai> dsctkm = new ArrayList<>();
        try{
            String sql = "Select * from " + tableKM;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai();
                ctkm.setMaKM(rs.getString(1));
                ctkm.setTenCT(rs.getString(2));
                ctkm.setGG(rs.getDouble(3));
                ctkm.setNgayBD(rs.getString(4));
                ctkm.setNgayKT(rs.getString(5));
                dsctkm.add(ctkm);
            }
        }catch(SQLException e){
            System.err.println("Error");
        }  
        return dsctkm;
    }
    
// Chi Tiet Hoa Don
    public ArrayList LoadCTHD(){
        ArrayList<ChiTietHD> dscthd = new ArrayList<>();
        try{
            String sql = "Select * from " + tableCTHD;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ChiTietHD cthd = new ChiTietHD();
                cthd.setMaHD(rs.getString(1));
                cthd.setMaMon(rs.getString(2));
                cthd.setSoLuong(rs.getDouble(3));
                cthd.setDonGia(rs.getDouble(4));
                cthd.setThanhTien(rs.getDouble(5));
                dscthd.add(cthd);
            }
            return dscthd;
        }catch(SQLException e){
            System.err.println("Error");
        }  
        return null;
    }
    public boolean InsertCTHD(ChiTietHD cthd){
        String query = "Insert into " + tableCTHD + " (MaHD, MaMon, SoLuong, DonGia, ThanhTien) values(?, ?, ?, ?, ?)";
        try{    
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, cthd.getMaHD());
            st.setString(2, cthd.getMaMon());
            st.setDouble(3, cthd.getSoLuong());
            st.setDouble(4, cthd.getDonGia());
            st.setDouble(5, cthd.getThanhTien());
            return st.executeUpdate()>0;
        }catch(SQLException ex){  
            System.err.println(ex);
        } 
        return false;
    }
    public boolean DeleteCTHD(String a, String b){
        String query = "delete from " + tableCTHD + " where (MaHD = ? and MaMon = ? )";
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, a);
            st.setString(2, b);
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }
    public boolean UpdateCTHD(ChiTietHD cthd, String a, String b){
        String query = "update " + tableCTHD + " set SoLuong = ?, DonGia = ?, ThanhTien = ? where (MaHD = ? and MaMon = ? )";
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setDouble(1, cthd.getSoLuong());
            st.setDouble(2, cthd.getDonGia());
            st.setDouble(3, cthd.getThanhTien());
            st.setString(4, cthd.getMaHD());
            st.setString(5, cthd.getMaMon());
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }
    
// San Pham
    public boolean InsertSP(SanPham sp){
        String query = "Insert into " + tableSP + " (MaMon, MaLoai, TenMon, DonGia, SoLuongDT, DonViTinh) values(?, ?, ?, ?, ?, ?)";
        try{    
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, sp.getMaMon());
            st.setString(2, sp.getMaLoaiSP());
            st.setString(3, sp.getTenMon());
            st.setDouble(4, sp.getDonGia());
            st.setDouble(5, sp.getSoLuongDT());
            st.setString(6, sp.getDonViTinh());
            return st.executeUpdate()>0;
        }catch(SQLException ex){  
            System.err.println(ex);
        } 
        return false;
    }
    public boolean DeleteSP(String a){
        String query = "delete from " + tableSP + " where MaMon = ? ";
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, a);
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }
    public boolean UpdateSP(SanPham sp, String a){
        String query = "update " + tableSP + " set MaLoai = ?, TenMon = ?, DonGia = ?, SoLuongDT = ?, DonViTinh = ? where MaMon = ? ";
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, sp.getMaLoaiSP());
            st.setString(2, sp.getTenMon());
            st.setDouble(3, sp.getDonGia());
            st.setDouble(4, sp.getSoLuongDT());
            st.setString(5, sp.getDonViTinh());
            st.setString(6, sp.getMaMon());
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }
    public ArrayList LoadSP(){
        ArrayList<SanPham> dssp = new ArrayList<>();
        try{
            String sql = "Select * from " + tableSP;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setMaMon(rs.getString(1));
                sp.setMaLoaiSP(rs.getString(2));
                sp.setTenMon(rs.getString(3));
                sp.setDonGia(rs.getDouble(4));
                sp.setSoLuongDT(rs.getDouble(5));
                sp.setDonViTinh(rs.getString(6));
                dssp.add(sp);
            }
        }catch(SQLException e){
            System.err.println("Error");
        }  
        return dssp;
    }


// Chi Tiet San Pham    
    public ArrayList LoadCTSP(){
        ArrayList<ChiTietSP> dsctsp = new ArrayList<>();
        try{
            String sql = "Select * from " + tableCTSP;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ChiTietSP ctsp = new ChiTietSP();
                ctsp.setMaMon(rs.getString(1));
                ctsp.setMaNL(rs.getString(2));
                ctsp.setKhoiLuong(rs.getDouble(3));
                ctsp.setDonViTinh(rs.getString(4));
                dsctsp.add(ctsp);
            }
        }catch(SQLException e){
            System.err.println("Error");
        }  
        return dsctsp;
    }
    public boolean InsertCTSP(ChiTietSP ctsp){
        String query = "Insert into " + tableCTSP + " (MaMon, MaNL, KhoiLuong, DonViTinh) values(?, ?, ?, ?)";
        try{    
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, ctsp.getMaMon());
            st.setString(2, ctsp.getMaNL());
            st.setDouble(3, ctsp.getKhoiLuong());
            st.setString(4, ctsp.getDonViTinh());
            return st.executeUpdate()>0;
        }catch(SQLException ex){  
            System.err.println(ex);
        } 
        return false;
    }
    public boolean DeleteCTSP(String a, String b){
        String query = "delete from " + tableCTSP + " where (MaMon = ? && MaNL = ? )";
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, a);
            st.setString(2, b);
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }
    public boolean UpdateCTSP(ChiTietSP ctsp, String a, String b){
        String query = "update " + tableCTSP + " set KhoiLuongLuong = ?, DonViTinh = ? where (MaMon = ? and MaNL = ? )";
        try{
            PreparedStatement st = con.prepareStatement(query);
            st.setDouble(1, ctsp.getKhoiLuong());
            st.setString(2, ctsp.getDonViTinh());
            st.setString(4, ctsp.getMaMon());
            st.setString(5, ctsp.getMaNL());
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }
}
