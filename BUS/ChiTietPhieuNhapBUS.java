package BUS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.ChiTietPhieuNhapDAO;
import DTO.ChiTietPhieuNhapDTO;


public class ChiTietPhieuNhapBUS {
	public ChiTietPhieuNhapBUS() {
	}
	public static ArrayList<ChiTietPhieuNhapDTO> dsctpn;
	public boolean them(ChiTietPhieuNhapDTO ctpn) {
		ChiTietPhieuNhapDAO ctd;
		try {
			ctd = new ChiTietPhieuNhapDAO();
			if(ctd.insert(ctpn))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;	
	}
	public ArrayList<ChiTietPhieuNhapDTO> docCTPN() throws SQLException{
		try {
		ChiTietPhieuNhapDAO ctd = new ChiTietPhieuNhapDAO();
		if(dsctpn==null) dsctpn = new ArrayList<ChiTietPhieuNhapDTO>();
		dsctpn = ctd.docCTPN();
		}catch (SQLException ex) {
            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
		return dsctpn;
	}
	public boolean xoa(String MaPhieuNhap,String MaNguyenLieu) {
		ChiTietPhieuNhapDAO ctd;
		try {
			ctd = new ChiTietPhieuNhapDAO();
			if(ctd.delete(MaPhieuNhap,MaNguyenLieu))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean sua(String MaPhieuNhap,String MaNguyenLieu,ChiTietPhieuNhapDTO ctpn) {
		ChiTietPhieuNhapDAO ctd;
		try {
			ctd = new ChiTietPhieuNhapDAO();
			if(ctd.update(MaPhieuNhap,MaNguyenLieu, ctpn))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
