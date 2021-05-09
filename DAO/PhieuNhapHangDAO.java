package DAO;


import  DTO.PhieuNhapHangDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ConnectDB.MySQLConnect;

public class PhieuNhapHangDAO {
	ArrayList<PhieuNhapHangDTO> dspn = new ArrayList<>();
	Connection connect=null;
	 PreparedStatement pts = null;
	    Statement st = null;
	    ResultSet rs=null;
	    MySQLConnect conn=new MySQLConnect("coffee");
	    
	    public PhieuNhapHangDAO() throws SQLException{
	        if(connect==null){
	            try {
	                connect=conn.getConnect();
	                st =conn.getStatement();
	            } catch (Exception ex) {
	                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	public ArrayList<PhieuNhapHangDTO>docPNH() throws SQLException{
		 
		String sqlCommand = "select * from phieunhaphang";		
		try {
		pts = connect.prepareStatement(sqlCommand);
		rs = pts.executeQuery();
		}catch(SQLException e){
		}
		while(rs.next()) {
			PhieuNhapHangDTO pnh = new PhieuNhapHangDTO();
			pnh.setMaPhieuNhap(rs.getString(1));
			pnh.setMaNhanVien(rs.getString(2));
			pnh.setMaNhaCungCap(rs.getString(3));
			pnh.setNgayNhap(rs.getString(4));
			pnh.setTongCong(rs.getDouble(5));
			dspn.add(pnh);
		}
		return dspn;
	}
	public boolean delete(String MaPhieuNhap) {
		PreparedStatement pts = null;
		String sqlCommand = "delete from phieunhaphang where MaPhieuNhap = ?";
		try {
			pts = connect.prepareStatement(sqlCommand);
			pts.setString(1,MaPhieuNhap);
			return pts.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;	
	}
	public boolean insert(PhieuNhapHangDTO pnh) {
		String sqlCommand = "insert into phieunhaphang values (?,?,?,?,?)";
		 PreparedStatement pts = null;
		try {
			pts = connect.prepareStatement(sqlCommand);
			pts.setString(1,pnh.getMaPhieuNhap());
			pts.setString(2,pnh.getMaNhanVien());
			pts.setString(3,pnh.getMaNhaCungCap());
			pts.setString(4,pnh.getNgayNhap());
			pts.setDouble(5,pnh.getTongCong());
			return pts.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;			
	}
	public boolean update(String MaPhieuNhap,PhieuNhapHangDTO pnh) {
		String sqlCommand = "Update phieunhaphang set MaNhanVien = ?, MaNhaCungCap = ?, NgayNhap = ?, TongCong = ? where MaNhanVien = ?";
		PreparedStatement pts = null;
		try {
			pts = connect.prepareStatement(sqlCommand);
			pts.setString(1,pnh.getMaNhanVien());
			pts.setString(2,pnh.getMaNhaCungCap());
			pts.setString(3,pnh.getNgayNhap());
			pts.setDouble(4,pnh.getTongCong());
			pts.setString(5,pnh.getMaPhieuNhap());
			return pts.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;		
	}
	PhieuNhapHangDTO timkiem(String MaPhieuNhap) {
		for(PhieuNhapHangDTO pnh : dspn) {
			if(pnh.getMaPhieuNhap().compareTo(MaPhieuNhap)==0);
			{
				return pnh;
			}
		}
		return null;
	}
	
	
}
