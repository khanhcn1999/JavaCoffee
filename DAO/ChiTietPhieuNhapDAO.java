package DAO;
import DTO.ChiTietPhieuNhapDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ConnectDB.MySQLConnect;


public class ChiTietPhieuNhapDAO {
	 	Connection connect=null;
	    Statement st = null;
	    ResultSet rs=null;
	    MySQLConnect conn=new MySQLConnect("coffee");
	    
	    public ChiTietPhieuNhapDAO() throws SQLException{
	        if(connect==null){
	            try {
	                connect=conn.getConnect();
	                st =conn.getStatement();
	            } catch (Exception ex) {
	                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	
	public ArrayList<ChiTietPhieuNhapDTO>docCTPN() throws SQLException{
		ArrayList<ChiTietPhieuNhapDTO> dsctpn = new ArrayList<>();
		 PreparedStatement pts = null;
		String sqlCommand = "select * from chitietphieunhap";
		try {
			pts = connect.prepareStatement(sqlCommand);
			rs = pts.executeQuery();
		}catch(SQLException e){
		}
		while(rs.next()) {
			ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
			ctpn.setMaPhieuNhap(rs.getString(1));
			ctpn.setMaNguyenLieu(rs.getString(2));
			ctpn.setTenNgyenLieu(rs.getString(3));
			ctpn.setSoLuong(rs.getDouble(4));
			ctpn.setDonGia(rs.getDouble(5));
			ctpn.setThanhTien(rs.getDouble(6));
			dsctpn.add(ctpn);
		}
		return dsctpn;
	}
	public boolean delete(String MaPhieuNhap,String MaNguyenLieu) {
		String sqlCommand = "delete from chitietphieunhap where MaPhieuNhap = ? and MaNguyenLieu = ?";
		 PreparedStatement pts = null;
		try {
			pts = connect.prepareStatement(sqlCommand);
			pts.setString(1,MaPhieuNhap);
			pts.setString(2,MaNguyenLieu);
			return pts.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;	
	}
	public boolean update(String MaPhieuNhap,String MaNguyenLieu,ChiTietPhieuNhapDTO ctpn) {
		String sqlCommand ="Update chitietphieunhap set tenNguyenLieu = ?, SoLuong = ?,DonGia = ?,ThanhTien = ? Where MaPhieuNhap = ? and MaNguyenLieu = ? ";
		 PreparedStatement pts = null;
		try {
			pts = connect.prepareStatement(sqlCommand);
			pts.setString(1,ctpn.getTenNgyenLieu());
			pts.setDouble(2,ctpn.getSoLuong());
			pts.setDouble(3, ctpn.getDonGia());
			pts.setDouble(4,ctpn.getThanhTien());
			pts.setString(5,ctpn.getMaPhieuNhap());
			pts.setString(6,ctpn.getMaNguyenLieu());
			return pts.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;	
	}
	public boolean insert(ChiTietPhieuNhapDTO ctpn) {
		String sqlCommand = "insert into chitietphieunhap values (?,?,?,?,?,?)";
		 PreparedStatement pts = null;
		try {
			pts = connect.prepareStatement(sqlCommand);
			pts.setString(1,ctpn.getMaPhieuNhap());
			pts.setString(2,ctpn.getMaNguyenLieu());
			pts.setString(3,ctpn.getTenNgyenLieu());
			pts.setDouble(4,ctpn.getSoLuong());
			pts.setDouble(5,ctpn.getDonGia());
			pts.setDouble(6,ctpn.getThanhTien());
			return pts.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;		
	}
}
