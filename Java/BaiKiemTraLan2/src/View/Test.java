package View;


import java.sql.Date;
import java.text.SimpleDateFormat;

import Bean.MatHangBean;
import Bo.MatHangBo;

public class Test {
	public static SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
	public static void main(String[] args) throws Exception {
		MatHangBo hb = new MatHangBo();
		hb.ketnoi();
		hb.Them("01", "Lan",new Date(dd.parse("01/11/2004").getTime()), 23, 100);
		for (MatHangBean x:hb.LayDS()) {
			System.out.println(x.toString());
		}
		
		
	}

}
