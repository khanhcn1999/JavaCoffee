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
public class NhanVienDTO {
    private String maNV, hoNV, tenNv, emailNV, sdtNV, gtinhNV, chucVu;
    boolean TTLamViec=true;
    public NhanVienDTO() {
    }

    public NhanVienDTO(String maNV, String hoNV, String tenNv, String emailNV, String sdtNV, String gtinhNV, String chucVu) {
        this.maNV = maNV;
        this.hoNV = hoNV;
        this.tenNv = tenNv;
        this.emailNV = emailNV;
        this.sdtNV = sdtNV;
        this.gtinhNV = gtinhNV;
        this.chucVu = chucVu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoNV() {
        return hoNV;
    }

    public void setHoNV(String hoNV) {
        this.hoNV = hoNV;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getEmailNV() {
        return emailNV;
    }

    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public String getGtinhNV() {
        return gtinhNV;
    }

    public void setGtinhNV(String gtinhNV) {
        this.gtinhNV = gtinhNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public boolean getTTLamviec() {
        return TTLamViec;
    }

    public void setTTLamViec(boolean lamviec) {
        this.TTLamViec = lamviec;
    }
    
    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", hoNV=" + hoNV + ", tenNv=" + tenNv + ", emailNV=" + emailNV + ", sdtNV=" + sdtNV + ", gtinhNV=" + gtinhNV + ", chucVu=" + chucVu + ", TTLamViec=" + TTLamViec + '}';
    }
    
}
