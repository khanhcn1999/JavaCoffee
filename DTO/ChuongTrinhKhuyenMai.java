package DTO;


public class ChuongTrinhKhuyenMai {
    private String MaKM;
    private String TenCT;
    private String NgayBD;
    private String NgayKT;
    public ChuongTrinhKhuyenMai()
    {
    }
    public void setMaKM(String mkm){
        this.MaKM = mkm;
    }

    public String getMaKM() {
        return this.MaKM;
    }
    public void setTenCT(String tct){
        this.TenCT = tct;
    }

    public String getTenCT() {
        return this.TenCT;
    }
    public void setNgayBD(String ngaybd){
        this.NgayBD = ngaybd;
    }
    public String getNgayBD(){
        return this.NgayBD;
    }
    public void setNgayKT(String ngaykt){
        this.NgayKT = ngaykt;
    }
    public String getNgayKT(){
        return this.NgayKT;
    }
}
