package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class HangHoa implements Serializable{
	private int maSanPham;
	private String tenSanPham;
	private Tinh noiSanXuat;
	private Date ngayNhap;
	private boolean loaiSP;
	private float soTienNhap, soTienBan, soLuong;
	
	public HangHoa() {
	}
	

	public HangHoa(int maSanPham, String tenSanPham, Tinh noiSanXuat, Date ngayNhap, boolean loaiSP, float soTienNhap,float soTienBan, float soLuong) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.noiSanXuat = noiSanXuat;
		this.ngayNhap = ngayNhap;
		this.loaiSP = loaiSP;
		this.soTienNhap = soTienNhap;
		this.soTienBan = soTienBan;
		this.soLuong = soLuong;
	}


	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public Tinh getNoiSanXuat() {
		return noiSanXuat;
	}

	public void setNoiSanXuat(Tinh noiSanXuat) {
		this.noiSanXuat = noiSanXuat;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public boolean isLoaiSP() {
		return loaiSP;
	}

	public void setLoaiSP(boolean loaiSP) {
		this.loaiSP = loaiSP;
	}

	public float getSoTienNhap() {
		return soTienNhap;
	}

	public void setSoTienNhap(float soTienNhap) {
		this.soTienNhap = soTienNhap;
	}

	public float getSoTienBan() {
		return soTienBan;
	}

	public void setSoTienBan(float soTienBan) {
		this.soTienBan = soTienBan;
	}

	public float getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(float soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ThiSinh [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", noiSanXuat=" + noiSanXuat
				+ ", ngayNhap=" + ngayNhap + ", loaiSP=" + loaiSP + ", soTienNhap=" + soTienNhap + ", soTienBan="
				+ soTienBan + ", soLuong=" + soLuong + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(loaiSP, maSanPham, ngayNhap, noiSanXuat, soLuong, soTienBan, soTienNhap, tenSanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangHoa other = (HangHoa) obj;
		return loaiSP == other.loaiSP && maSanPham == other.maSanPham && Objects.equals(ngayNhap, other.ngayNhap)
				&& Objects.equals(noiSanXuat, other.noiSanXuat)
				&& Float.floatToIntBits(soLuong) == Float.floatToIntBits(other.soLuong)
				&& Float.floatToIntBits(soTienBan) == Float.floatToIntBits(other.soTienBan)
				&& Float.floatToIntBits(soTienNhap) == Float.floatToIntBits(other.soTienNhap)
				&& Objects.equals(tenSanPham, other.tenSanPham);
	}

	
	}