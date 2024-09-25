package bo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import bean.SinhVien;
import bean.TinA;
import bean.TinB;
import dao.SinhVienDao;

public class SinhVienBo {
	SinhVienDao Svd = new SinhVienDao();
	ArrayList<SinhVien> ds;
	ArrayList<TinA> A;
	ArrayList<TinB> B;
	public ArrayList<SinhVien> layds() throws Exception{
		ds = Svd.getds();
		A = HienThiA();
		B = HienThiB();
		return ds;
	}
	public ArrayList<TinA> HienThiA() throws Exception{
		ArrayList<TinA> temp = new ArrayList<TinA>();
		for (SinhVien x:ds) {
			if (x instanceof TinA) {
				TinA X = (TinA)x;
				temp.add(X);
			}
		}
		return temp;
	}
	public ArrayList<TinB> HienThiB() throws Exception{
		ArrayList<TinB> temp = new ArrayList<TinB>();
		for (SinhVien x:ds) {
			if (x instanceof TinB) {
				TinB X = (TinB)x;
				temp.add(X);
			}
		}
		return temp;
	}
	public ArrayList<TinA> HienThiTenA(String Ten) throws Exception{
		ArrayList<TinA> temp = new ArrayList<TinA>();
		for (SinhVien x:ds) {
			if (x instanceof TinA) {
				TinA X = (TinA)x;
				if (x.getHoTen().toLowerCase().contains(Ten.toLowerCase())) temp.add(X);
			}
		}
		return temp;
	}
	public ArrayList<TinB> HienThiTenB(String Ten) throws Exception{
		ArrayList<TinB> temp = new ArrayList<TinB>();
		for (SinhVien x:ds) {
			if (x instanceof TinB) {
				TinB X = (TinB)x;
				if (x.getHoTen().toLowerCase().contains(Ten.toLowerCase())) temp.add(X);
			}
		}
		return temp;
	}
	public void LuuFile() throws Exception{
		FileWriter f1 = new FileWriter("f1.txt" , true);
		PrintWriter F1 = new PrintWriter(f1);
		FileWriter f2 = new FileWriter("f2.txt" , true);
		PrintWriter F2 = new PrintWriter(f2);
		for (TinA x:A) {
			F1.println(x.toString());
		}
		for (TinB x:B) {
			F2.println(x.toString());
		}
		F1.close();
		F2.close();
	}
}
