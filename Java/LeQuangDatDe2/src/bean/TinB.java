package bean;

public class TinB extends SinhVien{
	private double DExcel , DPower, DWeb;

	public TinB(String maSv, String hoTen, double dExcel, double dPower, double dWeb) {
		super(maSv, hoTen);
		DExcel = dExcel;
		DPower = dPower;
		DWeb = dWeb;
	}
	public double getDTB() {
		return (DExcel + DPower + DWeb)/3;
	}
	public double getDExcel() {
		return DExcel;
	}

	public void setDExcel(double dExcel) {
		DExcel = dExcel;
	}

	public double getDPower() {
		return DPower;
	}

	public void setDPower(double dPower) {
		DPower = dPower;
	}

	public double getDWeb() {
		return DWeb;
	}

	public void setDWeb(double dWeb) {
		DWeb = dWeb;
	}

	@Override
	public String toString() {
		return super.toString() + DExcel + ";" + DPower + ";" + DWeb + ";" + getDTB();
	}

}
