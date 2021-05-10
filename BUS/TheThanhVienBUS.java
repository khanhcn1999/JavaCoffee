/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TheThanhVienDAO;
import DTO.TheThanhVienDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Dell
 */
public class TheThanhVienBUS {
    public static ArrayList<TheThanhVienDTO> DSTTV;

    public TheThanhVienBUS() {
    }
    public void docDSTTV(){
        TheThanhVienDAO data=new TheThanhVienDAO();
        if(DSTTV==null) DSTTV=new ArrayList<TheThanhVienDTO>();
        DSTTV=data.docDSTTV();
    }
    public boolean themTTV(TheThanhVienDTO ttv){
        TheThanhVienDAO data=new TheThanhVienDAO();
        if(data.themTTV(ttv)){
            DSTTV.add(ttv);
            return true;
        }
        return false;    
    }
    
    public boolean suaTTV(int index, TheThanhVienDTO ttv){
        TheThanhVienDAO data=new TheThanhVienDAO();
        if(data.suaTTV(ttv)){
            DSTTV.set(index, ttv);
            return true;
        }
        return false;
    }

    public boolean xoaTTV(int index, String matv){
        TheThanhVienDAO data=new TheThanhVienDAO();
        if(data.xoaTTV(matv)) {
            DSTTV.remove(index);
            return true;
        }
        return false;
    }
    public ArrayList<TheThanhVienDTO> timkiem(String keyword){
        ArrayList<TheThanhVienDTO> tvList=new ArrayList<>();
        for(TheThanhVienDTO ttv: DSTTV){
        	if(Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE).matcher(ttv.getTenTV()).find()
                    || ttv.getMaTTV().contains(keyword)) 
        		tvList.add(ttv);
        }
        return tvList;
    }
   
}
