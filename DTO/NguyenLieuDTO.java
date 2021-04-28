package DTO;

public class NguyenLieuDTO {
	private String maNguyenLieu;
	private double khoiLuong;
	public NguyenLieuDTO() {
	}
	public NguyenLieuDTO(String maNguyenLieu,double khoiLuong) {
		this.maNguyenLieu = maNguyenLieu;
		this.khoiLuong = khoiLuong;
	}
	public String getMaNguyenLieu() {
		return maNguyenLieu;
	}
	public void setMaNguyenLieu(String maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}
	public double getKhoiLuong() {
		return khoiLuong;
	}
	public void setKhoiLuong(double khoiLuong) {
		this.khoiLuong = khoiLuong;
	}
	@Override
	public String toString() {
		return "NguyenLieuDTO [maNguyenLieu=" + maNguyenLieu + ", khoiLuong=" + khoiLuong + "]";
	}
	
}
