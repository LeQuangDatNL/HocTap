package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import bean.SinhVien;
import bean.TinA;
import bean.TinB;

public class SinhVienDao {
	public ArrayList<SinhVien> getds() throws Exception{
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		FileReader r = new FileReader("ds.txt");
		BufferedReader R = new BufferedReader(r);
		while (true) {
			String line = R.readLine();
			if (line == "" || line == null) break;
			String []DS = line.split("[;]");
			if (DS.length == 4) {
				ds.add(new TinA(DS[0], DS[1], Double.parseDouble(DS[2]), Double.parseDouble(DS[3])));
			}
			else if (DS.length == 5) {
				ds.add(new TinB(DS[0], DS[1],Double.parseDouble(DS[2]), Double.parseDouble(DS[3]), Double.parseDouble(DS[4])));
			}
			else {
				System.out.println("Loi o dao SinhVien");
			}
		}
		R.close();
		return ds;
	}
}
