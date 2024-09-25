package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import bean.NhanVien;

public class NhanVienDao {
	public ArrayList<NhanVien> LayDS() throws Exception{
		ArrayList<NhanVien> DS = new ArrayList<NhanVien>();
		FileReader r = new FileReader("ds.txt");
		BufferedReader R = new BufferedReader(r);
		while (true) {
			String line = R.readLine();
			if (line == ""|| line == null) break;
			String []ds = line.split("[;]");
			if (ds.length == 4) {
				if (ds[2].equals("chinhthuc") || ds[2].equals("hopdong")) {
					DS.add(new NhanVien(ds[0],ds[1], ds[2], Double.parseDouble(ds[3])));
				}
			}
		}
		R.close();
		return DS;
	}
}
