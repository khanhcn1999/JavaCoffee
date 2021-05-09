package BUS;

import DAO.*;
import java.util.ArrayList;
import javax.management.Query;
import DTO.*;
/**
 *
 * @author Lao Gia Hao
 */
public class NguyenLieuBUS {
   
    public static ArrayList<NguyenLieuDTO> dsnl;
    
    public NguyenLieuBUS(){}
    
    public ArrayList<NguyenLieuDTO> LoadNL(){
    	 NguyenLieuDAO data = new NguyenLieuDAO();
        if(dsnl == null){
           dsnl = new ArrayList<>();
        }  
        
        return dsnl = data.LoadNl();
    }
    public boolean themNL(NguyenLieuDTO nl) {
    	 NguyenLieuDAO data = new NguyenLieuDAO();
    if(data.add(nl)) {
    	return true;
    }
    	 return false;
      	
    }
    public boolean DelNL(String nl){
    	 NguyenLieuDAO data = new NguyenLieuDAO();
        if(data.del(nl)){ 
            return true;
        } 
        return false;         
    }
    public boolean UpdateNL(NguyenLieuDTO nl, String a){
    	 NguyenLieuDAO data = new NguyenLieuDAO();
        if(data.update(nl, a)){ 
            return true;
        } 
        return false; 
    }
}
