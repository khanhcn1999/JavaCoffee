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
}
