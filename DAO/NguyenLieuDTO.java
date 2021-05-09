package DTO;

public class NguyenLieuDTO {
	private String maNguyenLieu;
    private String tenNl;
	private double soLuong;
	private double donGia;
	public NguyenLieuDTO() {
	}
	public String getMaNguyenLieu() {
		return maNguyenLieu;
	}
	public void setMaNguyenLieu(String maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}
	public String getTenNl() {
		return tenNl;
	}
	public void setTenNl(String tenNl) {
		this.tenNl = tenNl;
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
	public NguyenLieuDTO(String maNguyenLieu, String tenNl, double soLuong,double donGia) {
		this.maNguyenLieu = maNguyenLieu;
		this.tenNl = tenNl;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	
}
