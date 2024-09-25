package Bean;

import java.sql.Date;

public class MatHangBean {
	private String MaHang , TenHang ;
	private Date NgayNhapHang;
	private int SoLuong , Gia;
	public MatHangBean(String maHang, String tenHang, Date ngayNhapHang, int soLuong, int gia) {
		super();
		MaHang = maHang;
		TenHang = tenHang;
		NgayNhapHang = ngayNhapHang;
		SoLuong = soLuong;
		Gia = gia;
	}
	@Override
	public String toString() {
		return MaHang + "|" + TenHang +  "|" + NgayNhapHang + "|" + SoLuong + "|" + Gia;
	}
	public String[] toVector() {
		return toString().split("[|]");
	}
	public String getMaHang() {
		return MaHang;
	}
	public void setMaHang(String maHang) {
		MaHang = maHang;
	}
	public String getTenHang() {
		return TenHang;
	}
	public void setTenHang(String tenHang) {
		TenHang = tenHang;
	}
	public Date getNgayNhapHang() {
		return NgayNhapHang;
	}
	public void setNgayNhapHang(Date ngayNhapHang) {
		NgayNhapHang = ngayNhapHang;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getGia() {
		return Gia;
	}
	public void setGia(int gia) {
		Gia = gia;
	}
	
}
