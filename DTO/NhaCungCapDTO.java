package DTO;

public class NhaCungCapDTO {
	private String maNhaCungCap;
	private String tenNhaCungCap;
	private String soDienThoai;
	private String diaChi;
	public NhaCungCapDTO() {
	}
	public NhaCungCapDTO(String maNhaCungCap,String tenNhaCungCap,String soDienThoai,String diaChi) {
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.soDienThoai = soDienThoai ;
		this.diaChi = diaChi;
	}
	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return maNhaCungCap +" - "+ tenNhaCungCap ;
	}
	
	
}
