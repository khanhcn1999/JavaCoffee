package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ConnectDB.MySQLConnect;
import DTO.NhanVien;
public class NhanVienDAO {

    Connection connect=null;
    Statement statement=null;
    ResultSet result=null;
    MySQLConnect conn=new MySQLConnect("coffee");
    
    public NhanVienDAO() throws SQLException{
        if(connect==null){
            try {
                connect=conn.getConnect();
                statement=conn.getStatement();
            } catch (Exception ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ArrayList docDSNV(){
        ArrayList<NhanVien> dsnv=new ArrayList<NhanVien>();
        try {
            String sql="select * from nhanvien";
            result=conn.executeQuery(sql);
            while(result.next()){
                NhanVien nv=new NhanVien();
                nv.setMaNV(result.getString(1));
                nv.setHoNV(result.getString(2));
                nv.setTenNv(result.getString(3));
                nv.setEmailNV(result.getString(4));
                nv.setSdtNV(result.getString(5));
                nv.setGtinhNV(result.getString(6));
                nv.setChucVu(result.getString(7));
                nv.setLamViec(result.getBoolean(8));
                dsnv.add(nv);
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsnv;
    }
    public void addNV(NhanVien nv){
        PreparedStatement statement=null;
        try {
            String sql="insert into nhanvien values(?, ?, ?, ?, ?, ?, ?, ?)";
            statement=connect.prepareCall(sql);
            statement.setString(1,nv.getMaNV());
            statement.setString(2,nv.getHoNV());
            statement.setString(3,nv.getTenNv());
            statement.setString(4,nv.getEmailNV());
            statement.setString(5,nv.getSdtNV());
            statement.setString(6,nv.getGtinhNV());
            statement.setString(7,nv.getChucVu());
            statement.setBoolean(8, true);
            statement.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin sinh viên.");
        }
    }
    public void updateNV(NhanVien nv){
        try {
            String sql="update nhanvien set HoNV='"+nv.getHoNV()+
                    "', TenNV='"+nv.getTenNv()+
                    "', Email='"+nv.getEmailNV()+
                    "', SDT='"+nv.getSdtNV()+
                    "', GioiTinh='"+nv.getGtinhNV()+
                    "', ChucVu='"+nv.getChucVu()+"' where MaNV='"+nv.getMaNV()+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.Close();
            } catch (Exception ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void updateThoiViec(String Manv){
        try {
            String sql="update nhanvien set LamViec='0' where MaNV='"+Manv+"'";
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
