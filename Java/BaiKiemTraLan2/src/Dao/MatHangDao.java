package Dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Bean.MatHangBean;

public class MatHangDao {
	public SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
	public boolean TrungMa(String MaHang) throws Exception {
		String sql = "select * from Hang where MaHang = ?";
		PreparedStatement cmd = KetNoiDao.cn.prepareStatement(sql);
		cmd.setString(1, MaHang);
		ResultSet rs = cmd.executeQuery();
		boolean ok = rs.next();
		rs.close(); 
		return ok;
	}
	public MatHangBean TimHang(ArrayList<MatHangBean> ds,String Ma) {
		for (MatHangBean x:ds) {
			if (x.getMaHang().equals(Ma)) {
				return x;
			}
		}
		return null;
		
	}
	public int Them(String maHang, String tenHang, Date ngayNhapHang, int soluong, int gia) throws Exception{
        if (!TrungMa(maHang)) {
        	String sql = "INSERT INTO Hang (MaHang, TenHang, NgayNhapHang, SoLuong, Gia) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement cmd = KetNoiDao.cn.prepareStatement(sql);
	        cmd.setString(1, maHang);
	        cmd.setString(2, tenHang);
	        cmd.setDate(3, ngayNhapHang);
	        cmd.setInt(4, soluong);
	        cmd.setInt(5, gia);
	        return cmd.executeUpdate();
        }
        return 0;
          
	}
	public void DocFile() throws Exception {
		FileReader r = new FileReader("hang.txt");
		BufferedReader R = new BufferedReader(r);
		while (true) {
			String line = R.readLine();
			if (line == "" || line == null) break;
			String []Ls = line.split("[|]");
			String MaHang = Ls[0];
			String TenHang = Ls[1];
			Date NgayNhapHang= new Date(dd.parse(Ls[2]).getTime());
			int SoLuong = Integer.parseInt(Ls[3]);
			int Gia = Integer.parseInt(Ls[4]);
			Them(MaHang, TenHang, NgayNhapHang, SoLuong, Gia);
		}
		R.close();
	}
	public ArrayList<MatHangBean> LayDS() throws Exception{
		ArrayList<MatHangBean> ds  = new ArrayList<MatHangBean>();
		String sql = "select * from Hang ORDER BY MaHang";
		PreparedStatement cmd = KetNoiDao.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String MaHang = rs.getString("MaHang");
			String TenHang = rs.getString("TenHang");
			Date NgayNhapHang = rs.getDate("NgayNhapHang");
			int SoLuong = rs.getInt("SoLuong");
			int Gia = rs.getInt("Gia");
			ds.add(new MatHangBean(MaHang, TenHang, NgayNhapHang, SoLuong, Gia));
		}
		rs.close();
		return ds;
	}
	public ArrayList<MatHangBean> TimTen(String Ten) throws Exception{
		ArrayList<MatHangBean> ds  = new ArrayList<MatHangBean>();
		String sql = "select * from Hang where TenHang like ? ORDER BY TenHang";
		PreparedStatement cmd = KetNoiDao.cn.prepareStatement(sql);
		cmd.setString(1, "%" + Ten + "%");
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String MaHang = rs.getString("MaHang");
			String TenHang = rs.getString("TenHang");
			Date NgayNhapHang = rs.getDate("NgayNhapHang");
			int SoLuong = rs.getInt("SoLuong");
			int Gia = rs.getInt("Gia");
			ds.add(new MatHangBean(MaHang, TenHang, NgayNhapHang, SoLuong, Gia));
		}
		rs.close();
		return ds;
	}
	public int Xoa(String MaHang) throws Exception{
		String sql = "delete from Hang where MaHang = ?";
		PreparedStatement cmd = KetNoiDao.cn.prepareStatement(sql);
		cmd.setString(1, MaHang);
		return cmd.executeUpdate(); 
	}
	public int Sua(String MaHang , String TenHang , Date NgayNhapHang, int SoLuong , int Gia) throws Exception {
		String sql = "update Hang set TenHang = ? , NgayNhapHang = ? , SoLuong = ? , Gia = ? where MaHang = ?";
		PreparedStatement cmd = KetNoiDao.cn.prepareStatement(sql);
		cmd.setString(1, TenHang);
		cmd.setDate(2, NgayNhapHang);
		cmd.setInt(3, SoLuong);
		cmd.setInt(4, Gia);
		cmd.setString(5, MaHang);
		return cmd.executeUpdate();
	}
	public ArrayList<MatHangBean> TimNgay(Date a, Date b) throws Exception{
		ArrayList<MatHangBean> ds  = new ArrayList<MatHangBean>();
		String sql = "select * from Hang WHERE NgayNhapHang BETWEEN ? AND ? ORDER BY NgayNhapHang";
		PreparedStatement cmd = KetNoiDao.cn.prepareStatement(sql);
		cmd.setDate(1, a);
		cmd.setDate(2, b);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String MaHang = rs.getString("MaHang");
			String TenHang = rs.getString("TenHang");
			Date NgayNhapHang = rs.getDate("NgayNhapHang");
			int SoLuong = rs.getInt("SoLuong");
			int Gia = rs.getInt("Gia");
			ds.add(new MatHangBean(MaHang, TenHang, NgayNhapHang, SoLuong, Gia));
		}
		rs.close();
		return ds;
	}

}
