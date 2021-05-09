package DTO;

public class ChiTietPhieuNhapDTO {
	private String maPhieuNhap;
	private String maNguyenLieu;
	private String tenNgyenLieu;
	private double soLuong;
	private double donGia;
	private double thanhTien;
	public ChiTietPhieuNhapDTO() {
	}
	public ChiTietPhieuNhapDTO(String maPhieuNhap,String maNguyenLieu,String tenNguyenLieu,double soLuong,double donGia,double thanhTien ) {
		this.maPhieuNhap = maPhieuNhap;
		this.maNguyenLieu = maNguyenLieu;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
		this.tenNgyenLieu = tenNguyenLieu;
	}
	public String getTenNgyenLieu() {
		return tenNgyenLieu;
	}
	public void setTenNgyenLieu(String tenNgyenLieu) {
		this.tenNgyenLieu = tenNgyenLieu;
	}
	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}
	public String getMaNguyenLieu() {
		return maNguyenLieu;
	}
	public void setMaNguyenLieu(String maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}
	public double getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	@Override
	public String toString() {
		return "ChiTietPhieuNhapDTO [maPhieuNhap=" + maPhieuNhap + ", maNguyenLieu=" + maNguyenLieu + ", tenNgyenLieu="
				+ tenNgyenLieu + ", soLuong=" + soLuong + ", donGia=" + donGia + ", thanhTien=" + thanhTien + "]";
	}
	
}

