package bo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import bean.NhanVien;
import dao.NhanVienDao;

public class NhanVienBo {
	NhanVienDao D = new NhanVienDao();
	ArrayList<NhanVien> ds;
	public ArrayList<NhanVien> layds() throws Exception{
		ds = D.LayDS();
		for (NhanVien x:ds) {
			System.out.println(x.toString());
		}
		return ds;
	}
	public void LuuFile() throws Exception{
		FileWriter r = new FileWriter("luu.txt");
		PrintWriter R = new PrintWriter(r);
		for (NhanVien x:ds) {
			R.println(x.toString());
		}
		R.close();
	}
	public ArrayList<NhanVien> HienThiChinhThuc() throws Exception{
		ArrayList<NhanVien> temp = new ArrayList<NhanVien>();
		for (NhanVien x:ds) {
			if (x.tovetor()[2].equals("chinhthuc")) {
				System.out.println(x.toString());	
				temp.add(x);
			}
		}
		return temp;
	}
}
