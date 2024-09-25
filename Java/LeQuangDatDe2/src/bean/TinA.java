package bean;

public class TinA extends SinhVien{
	private double DWin , DWord;
	public TinA(String maSv, String hoTen, double dWin, double dWord) {
		super(maSv, hoTen);
		DWin = dWin;
		DWord = dWord;
	}
	public double getDTB() {
		return (DWin + DWord)/2;
	}
	public double getDWin() {
		return DWin;
	}
	public void setDWin(double dWin) {
		DWin = dWin;
	}
	public double getDWord() {
		return DWord;
	}
	public void setDWord(double dWord) {
		DWord = dWord;
	}
	@Override
	public String toString() {
		return	super.toString() + DWin + ";" + DWord + ";" + getDTB();
	}
	

	
}
