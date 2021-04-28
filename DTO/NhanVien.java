package DTO;

public class NhanVien {
    String maNV, hoNV, tenNv, emailNV, sdtNV, gtinhNV, chucVu;
    boolean lamViec=true;
    public NhanVien() {
    }

    public NhanVien(String maNV, String hoNV, String tenNv, String emailNV, String sdtNV, String gtinhNV, String chucVu) {
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

    public boolean isLamviec() {
        return lamViec;
    }

    public void setLamViec(boolean lamviec) {
        this.lamViec = lamviec;
    }
    public void setNghiViec(){
        this.lamViec=false;
    }

	@Override
	public String toString() {
		return maNV;
	}

    
}

