/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Dell
 */
public class TheThanhVienDTO {
    private String maTTV, tenTV, SDT;
    private double diemTichLuy=0;
    public TheThanhVienDTO() {
    }

    public TheThanhVienDTO(String maTTV, String tenTV, String SDT) {
        this.maTTV = maTTV;
        this.tenTV = tenTV;
        this.SDT = SDT;
    }

    public String getMaTTV() {
        return maTTV;
    }

    public void setMaTTV(String maTTV) {
        this.maTTV = maTTV;
    }

    public String getTenTV() {
        return tenTV;
    }

    public void setTenTV(String tenTV) {
        this.tenTV = tenTV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public double getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(double diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }

    @Override
    public String toString() {
        return "TheThanhVien{" + "maTTV=" + maTTV + ", tenTV=" + tenTV + ", SDT=" + SDT + ", diemTichLuy=" + diemTichLuy + '}';
    }
    
    public void themdiem(double tongtien){
        this.diemTichLuy+=tongtien*0.05;
    }
    public boolean suDungDiem(Double tongtien){
        if(diemTichLuy>=tongtien){
            diemTichLuy-=tongtien;
            return true;
        } else {
            System.out.println("Không đủ điểm để thanh toán");
            return false;
        }
    }
}
