package DAO;
import DTO.NhaCungCapDTO;
import ConnectDB.MySQLConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhaCungCapDAO {
	Connection connect=null;
    Statement st = null;
    ResultSet rs=null;
    MySQLConnect conn=new MySQLConnect("coffee");
    
    public NhaCungCapDAO() throws SQLException{
        if(connect==null){
            try {
                connect=conn.getConnect();
                st =conn.getStatement();
            } catch (Exception ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	
	public ArrayList<NhaCungCapDTO> docDSNhaCungCap() throws SQLException{
		ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
		PreparedStatement pts = null;
		String sqlCommand = "select * from nhacungcap";
		try {
			pts = connect.prepareStatement(sqlCommand);
			rs = pts.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			while(rs.next()) {
				NhaCungCapDTO ncc = new NhaCungCapDTO();
				ncc.setMaNhaCungCap(rs.getString(1));
				ncc.setTenNhaCungCap(rs.getString(2));
				ncc.setSoDienThoai(rs.getString(3));
				ncc.setDiaChi(rs.getString(4));
				dsncc.add(ncc);
			}
		return dsncc;
	}

	public boolean insert(NhaCungCapDTO ncc) {
		PreparedStatement pts = null;
		String sqlCommand = "insert into nhacungcap values (?,?,?,?)";
		try {
			pts = connect.prepareStatement(sqlCommand);
			pts.setString(1,ncc.getMaNhaCungCap());
			pts.setString(2,ncc.getTenNhaCungCap());
			pts.setString(3,ncc.getSoDienThoai());
			pts.setString(4,ncc.getDiaChi());
			return pts.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean delete(String MaNhaCungCap) {
		String sqlCommand = " delete from  nhacungcap where MaNhaCungCap=?";
		PreparedStatement pts = null;
		try {
			pts = connect.prepareStatement(sqlCommand);
			pts.setString(1, MaNhaCungCap);
			return pts.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean update(String MaNhaCungCap,NhaCungCapDTO ncc) {
		String sqlCommand = "update nhacungcap set TenNhaCungCap=?, SoDienThoai=?, DiaChi=? where MaNhaCungCap=?";
		PreparedStatement pts = null;
		try {
			pts= connect.prepareStatement(sqlCommand);
			pts.setString(1, ncc.getTenNhaCungCap());
			pts.setString(2, ncc.getSoDienThoai());
			pts.setString(3, ncc.getDiaChi());
			pts.setString(4, ncc.getMaNhaCungCap());
			return pts.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
