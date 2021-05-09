package BUS;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;

public class NhaCungCapBUS {
	public static ArrayList<NhaCungCapDTO> dsncc;
	public NhaCungCapBUS(){
		
	}
		public ArrayList<NhaCungCapDTO> docDSNCC(){
			try {
		NhaCungCapDAO ncd = new NhaCungCapDAO()	;
		if(dsncc==null) dsncc = new ArrayList<NhaCungCapDTO>();
		dsncc= ncd.docDSNhaCungCap();
			}catch (SQLException ex) {
	            Logger.getLogger(NhanVienBUS.class.getName()).log(Level.SEVERE, null, ex);
	        }
		return dsncc;
		}
		public boolean themNCC(NhaCungCapDTO ncc) {
			try {
				NhaCungCapDAO ncd= new NhaCungCapDAO();
				if(ncd.insert(ncc)) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
			
		}
		public boolean xoaNCC(String MaNhaCungCap) {
			try {
				NhaCungCapDAO ncd = new NhaCungCapDAO();
				if(ncd.delete(MaNhaCungCap)) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
		}
		public boolean suaNCC(String MaNhaCungCap,NhaCungCapDTO ncc) {
			try {
				NhaCungCapDAO ncd = new NhaCungCapDAO();
				if(ncd.update(MaNhaCungCap, ncc)) {
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
			
		}
		/*public boolean kiemtrasdt(String a) {
			String input = a;
				
			if(input.matches(regex)) {
				return true;
			}
			return false;
		}*/
}
