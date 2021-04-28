package BUS;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.PhieuNhapHangDAO;
import DTO.PhieuNhapHangDTO;
public class PhieuNhapHangBUS {
	public PhieuNhapHangBUS() {
	}
	public static ArrayList<PhieuNhapHangDTO> dspn;
	
	public void doc() throws SQLException{
		PhieuNhapHangDAO pnd = new PhieuNhapHangDAO();
		if(dspn==null) dspn = new ArrayList<PhieuNhapHangDTO>();
		dspn = pnd.docPNH();
	}
	 public boolean them(PhieuNhapHangDTO pnh) {
		 PhieuNhapHangDAO pnd;
		try {
			pnd = new PhieuNhapHangDAO();
			 if(pnd.insert(pnh))
				 return true;
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		 return false;
	 }
	 
	 public boolean xoa(String MaPhieuNhap) {
		 PhieuNhapHangDAO pnd;
		try {
			pnd = new PhieuNhapHangDAO();
			 if(pnd.delete(MaPhieuNhap))
				 return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		 return false;
	 }
	 public boolean sua(String MaPhieuNhap,PhieuNhapHangDTO pnh) {
		 try {
			PhieuNhapHangDAO pnd = new PhieuNhapHangDAO();
			if(pnd.update(MaPhieuNhap, pnh))
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	 }
}
