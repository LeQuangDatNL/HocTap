package bean;

public class SinhVien {
	private String MaSv, HoTen;
	
	public SinhVien(String maSv, String hoTen) {
		super();
		MaSv = maSv;
		HoTen = hoTen;
	}
	
	public String getMaSv() {
		return MaSv;
	}

	public void setMaSv(String maSv) {
		MaSv = maSv;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	@Override
	public String toString() {
		return MaSv + ";" + HoTen + ";";
	}
	
	
}
