package bean;

public class NhanVien {
	private String Ma, HT,LHD;
	private double HSL;
	public NhanVien(String ma, String hT, String lHD, double hSL) {
		super();
		Ma = ma;
		HT = hT;
		LHD = lHD;
		HSL = hSL;
	}
	public String getMa() {
		return Ma;
	}
	public void setMa(String ma) {
		Ma = ma;
	}
	public String getHT() {
		return HT;
	}
	public void setHT(String hT) {
		HT = hT;
	}
	public String getLHD() {
		return LHD;
	}
	public void setLHD(String lHD) {
		LHD = lHD;
	}
	public double getHSL() {
		return HSL;
	}
	public void setHSL(double hSL) {
		HSL = hSL;
	}
	@Override
	public String toString() {
		return Ma + ";" + HT + ";" + LHD +";" + HSL;
	}
	public String[] tovetor() {
		return this.toString().split("[;]");
	}
}
