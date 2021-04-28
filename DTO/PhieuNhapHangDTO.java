package DTO;

import java.util.Date;

public class PhieuNhapHangDTO {
	private String maPhieuNhap;
	private String maNhanVien;
	private String maNhaCungCap;
	private String  ngayNhap;
	private double tongCong;
	public PhieuNhapHangDTO() {
	}
	public PhieuNhapHangDTO(String maPhieuNhap,String maNhanVien,String maNhaCungCap,String ngayNhap,float tongCong) {
		this.maPhieuNhap = maPhieuNhap;
		this.maNhanVien = maNhanVien;
		this.maNhaCungCap = maNhaCungCap;
		this.ngayNhap = ngayNhap;
		this.tongCong = tongCong;
	}
	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String NgayNhap) {
		this.ngayNhap = NgayNhap;
	}
	public double getTongCong() {
		return tongCong;
	}
	public void setTongCong(double tongCong) {
		this.tongCong = tongCong;
	}
	@Override
	public String toString() {
		return "PhieuNhapHangDTO [maPhieuNhap=" + maPhieuNhap + ", maNhanVien=" + maNhanVien + ", maNhaCungCap="
				+ maNhaCungCap + ", ngayNhap=" + ngayNhap + ", tongCong=" + tongCong + "]";
	}
	
}

