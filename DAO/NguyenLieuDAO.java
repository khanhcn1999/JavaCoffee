package DAO;

import DTO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ConnectDB.MySQLConnect;

public class NguyenLieuDAO {
	Connection connect=null;
    Statement st = null;
    ResultSet rs=null;
    MySQLConnect conn=new MySQLConnect("coffee");
    
    public NguyenLieuDAO() {
        if(connect==null){
            try {
                connect=conn.getConnect();
                st =conn.getStatement();
            } catch (Exception ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // doc danh sach
    public ArrayList LoadNl(){
        ArrayList<NguyenLieuDTO> dsnl = new ArrayList<>();
        try{
            String sql = "Select * from nl" ;
            PreparedStatement st = connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                NguyenLieuDTO sp = new NguyenLieuDTO();
                sp.setMaNguyenLieu(rs.getString(1));
                sp.setTenNl(rs.getString(2));
                sp.setSoLuong(rs.getDouble(3));
              //  sp.setDonGia(rs.getDouble(4));
                dsnl.add(sp);
            }
        }catch(SQLException e){
            System.err.println("Error");
        }  
        return dsnl;
    }
    public boolean add(NguyenLieuDTO nl){
        String sqlCommand = "insert into nl values (?,?,?,?)";
        PreparedStatement pts = null;
        try {
        	pts = connect.prepareStatement(sqlCommand);
			pts.setString(1,nl.getMaNguyenLieu());
			pts.setString(2,nl.getTenNl());
			pts.setDouble(3, nl.getSoLuong());
			pts.setDouble(4, nl.getDonGia());
			return pts.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
        
    }
    // sua
    public boolean update(NguyenLieuDTO nl, String MaNL){
        String query = "update nl set soluong = ?,dongia = ? WHERE maNL = ?";
        try{
            PreparedStatement st = connect.prepareStatement(query);
            st.setDouble(1, nl.getSoLuong());
            st.setDouble(2, nl.getDonGia());
            st.setString(3, nl.getMaNguyenLieu());
            return st.executeUpdate()>0;
        }catch(SQLException ex){
            System.err.println(ex);
        }
       return false; 
    }
    // xoa
    public boolean del(String a){
        String query = "delete from nl where maMonan = ? ";
        try{
            PreparedStatement st = connect.prepareStatement(query);
            st.setString(1, a);
            return st.executeUpdate()>0; 
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return false;
    }
}

