package Bo;

import java.sql.Date;
import java.util.ArrayList;

import Bean.MatHangBean;
import Dao.KetNoiDao;
import Dao.MatHangDao;

public class MatHangBo {
	ArrayList<MatHangBo> ds = new ArrayList<MatHangBo>();
	KetNoiDao knd = new KetNoiDao();
	MatHangDao hd = new MatHangDao();
	public void ketnoi() throws Exception {
		knd.ketnoi();
	}
	public void DocFile() throws Exception {
		hd.DocFile();
	}
	public MatHangBean TimHang(ArrayList<MatHangBean> ds,String Ma) {
		return hd.TimHang(ds, Ma);
	}
	public ArrayList<MatHangBean> LayDS() throws Exception {
		return hd.LayDS();
	}
	public int Them(String maHang, String tenHang, Date ngayNhapHang, int soluong, int gia) throws Exception{
		return hd.Them(maHang, tenHang, ngayNhapHang, soluong, gia);
	}
	public ArrayList<MatHangBean> TimTen(String Ten) throws Exception{
		return hd.TimTen(Ten);
	}
	public int Xoa(String MaHang) throws Exception{
		return hd.Xoa(MaHang);
	}
	public int Sua(String MaHang , String TenHang , Date NgayNhapHang, int SoLuong , int Gia) throws Exception {
		return hd.Sua(MaHang, TenHang, NgayNhapHang, SoLuong, Gia);
	}
	public ArrayList<MatHangBean> TimNgay(Date a, Date b) throws Exception{
		return hd.TimNgay(a, b);
	}
}
