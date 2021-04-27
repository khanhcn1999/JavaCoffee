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

/**
 *
 * @author Dell
 */
public class TheThanhVienBUS {
    static ArrayList<TheThanhVienDTO> DSTTV;

    public TheThanhVienBUS() {
    }
    public void docDSTTV(){
        TheThanhVienDAO data=new TheThanhVienDAO();
        if(DSTTV==null) DSTTV=new ArrayList<TheThanhVienDTO>();
        DSTTV=data.docDSTTV();
    }
    public void themTTV(TheThanhVienDTO ttv){
        TheThanhVienDAO data=new TheThanhVienDAO();
        data.themTTV(ttv);
        DSTTV.add(ttv);
    }
    
    public void suaTTV(int index, TheThanhVienDTO ttv){
        TheThanhVienDAO data=new TheThanhVienDAO();
        data.suaTTV(ttv);
        DSTTV.set(index, ttv);
    }

    public void xoaTTV(int index, String matv){
        TheThanhVienDAO data=new TheThanhVienDAO();
        data.xoaTTV(matv);
        DSTTV.remove(index);
    }
    public ArrayList<TheThanhVienDTO> timkiem(String keyword){
        ArrayList<TheThanhVienDTO> tvList=new ArrayList<>();
        tvList=null;
        for(TheThanhVienDTO ttv: DSTTV){
            if(ttv.getMaTTV().contains(keyword) || ttv.getTenTV().contains(keyword))
            {
                tvList.add(ttv);
            }
        }
            
        return tvList;
    }
   
}
