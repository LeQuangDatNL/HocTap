package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Bean.MatHangBean;
import Bo.MatHangBo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class QLBanHangView extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenHangMua;
	private JTextField txtSoLuongMua;
	private JTextField txtGiaMua;
	private JTextField txtThanhTienMua;
	private JTextField txtCNMa;
	private JTextField txtCNTenHang;
	private JTextField txtCNSoLuong;
	private JTextField txtCNNam;
	private JTextField txtCNGia;
	private JTextField txtCNThang;
	private JTextField txtCNNgay;
	private JTextField txtSNgay;
	private JTable tbCSDL;
	private JTable table_1;
	private JTextField txtSThang;
	private JTextField txtSNam;
	private JTextField txtENgay;
	private JTextField txtEThang;
	private JTextField txtENam;
	public JComboBox<String> cmbMaHangMua = new JComboBox<String>();
	public MatHangBo hb = new MatHangBo();
	public SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField txtTimKiem;
	public ArrayList<MatHangBean> DsMua = new ArrayList<MatHangBean>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLBanHangView frame = new QLBanHangView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void HienThi(ArrayList<MatHangBean> ds) {
		DefaultTableModel Bang = new DefaultTableModel();
		Bang.addColumn("Ma Hang");
		Bang.addColumn("Ten Hang");
		Bang.addColumn("Ngay Nhap");
		Bang.addColumn("So Luong");
		Bang.addColumn("Gia");
		for (MatHangBean x:ds) {
			Bang.addRow(x.toVector());
		}
		tbCSDL.setModel(Bang);
	}
	public void HienThiMuaHang(ArrayList<MatHangBean> ds) {
		DefaultTableModel Bang = new DefaultTableModel();
		Bang.addColumn("Ma Hang");
		Bang.addColumn("Ten Hang");
		Bang.addColumn("Ngay Nhap");
		Bang.addColumn("So Luong");
		Bang.addColumn("Gia");
		for (MatHangBean x:ds) {
			Bang.addRow(x.toVector());
		}
		tbCSDL.setModel(Bang);
	}
	public void DocVaoThanhChon() throws Exception {
		cmbMaHangMua.removeAllItems();
		for (MatHangBean x:hb.LayDS()) {
			cmbMaHangMua.addItem(x.getMaHang());
		}
	}

	public QLBanHangView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					hb.ketnoi();
					HienThi(hb.LayDS());
					DocVaoThanhChon();
					hb.DocFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tbpCSDL = new JTabbedPane(JTabbedPane.TOP);
		tbpCSDL.setBounds(10, 2, 335, 269);
		contentPane.add(tbpCSDL);
		
		JScrollPane scrollPane = new JScrollPane();
		tbpCSDL.addTab("Danh Sach Hang", null, scrollPane, null);
		
		tbCSDL = new JTable();
		scrollPane.setViewportView(tbCSDL);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(669, 2, 301, 271);
		contentPane.add(tabbedPane_1);
		
		JScrollPane tbDSMua = new JScrollPane();
		tabbedPane_1.addTab("Danh Sach Mua Hang", null, tbDSMua, null);
		
		table_1 = new JTable();
		tbDSMua.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("Ma Hang");
		lblNewLabel.setBounds(355, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ten Hang");
		lblNewLabel_1.setBounds(355, 89, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("So Luong Mua");
		lblNewLabel_2.setBounds(355, 177, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gia");
		lblNewLabel_3.setBounds(355, 133, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtTenHangMua = new JTextField();
		txtTenHangMua.setBounds(452, 86, 122, 20);
		contentPane.add(txtTenHangMua);
		txtTenHangMua.setColumns(10);
		
		txtSoLuongMua = new JTextField();
		txtSoLuongMua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == 10) {
					int SoLuongMua = Integer.parseInt("0" + txtSoLuongMua.getText() );
					String MaHang = cmbMaHangMua.getSelectedItem().toString();
					try {
						MatHangBean Hang = hb.TimHang(hb.LayDS(), MaHang);
						if (SoLuongMua <= 0 || Hang.getSoLuong() < SoLuongMua) JOptionPane.showMessageDialog(null,"So Luong khong thich ung vui long nhap so duong <= " + Hang.getSoLuong());
						else {
							int ThanhTien = SoLuongMua * Hang.getGia();
							txtThanhTienMua.setText(Integer.toString(ThanhTien));
							
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		txtSoLuongMua.setBounds(452, 174, 122, 20);
		contentPane.add(txtSoLuongMua);
		txtSoLuongMua.setColumns(10);
		
		txtGiaMua = new JTextField();
		txtGiaMua.setBounds(452, 130, 122, 20);
		contentPane.add(txtGiaMua);
		txtGiaMua.setColumns(10);

		cmbMaHangMua.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					String Mhang = cmbMaHangMua.getSelectedItem().toString();
					for (MatHangBean x:hb.LayDS()) {
						if (Mhang.equals(x.getMaHang())) {
							txtTenHangMua.setText(x.getTenHang());
							txtGiaMua.setText(Integer. toString(x.getGia()));
							break;
						}
					}
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		cmbMaHangMua.setBounds(452, 40, 122, 20);
		contentPane.add(cmbMaHangMua);
		
		txtThanhTienMua = new JTextField();
		txtThanhTienMua.setBounds(452, 216, 122, 20);
		contentPane.add(txtThanhTienMua);
		txtThanhTienMua.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Thanh Tien");
		lblNewLabel_4.setBounds(355, 219, 87, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btThemVaoGio = new JButton("Mua");
		btThemVaoGio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String MaHang = cmbMaHangMua.getSelectedItem().toString();
				try {
					MatHangBean HangMua = hb.TimHang(hb.LayDS(), MaHang);
					String TenHang = HangMua.getTenHang();
					Date NgayNhapHang = HangMua.getNgayNhapHang();
					int SoLuong = HangMua.getSoLuong();
					int Gia = HangMua.getGia();
					int SoLuongMua = Integer.parseInt(txtSoLuongMua.getText());
					DsMua.add(new MatHangBean(MaHang, TenHang, NgayNhapHang,  SoLuongMua, Gia));
					hb.Sua(MaHang, TenHang, NgayNhapHang, SoLuong - SoLuongMua, Gia);
					HienThi(hb.LayDS());
					HienThiMuaHang(DsMua);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btThemVaoGio.setBounds(416, 247, 122, 23);
		contentPane.add(btThemVaoGio);
		
		txtCNMa = new JTextField();
		txtCNMa.setBounds(68, 305, 86, 20);
		contentPane.add(txtCNMa);
		txtCNMa.setColumns(10);
		
		txtCNTenHang = new JTextField();
		txtCNTenHang.setBounds(180, 305, 86, 20);
		contentPane.add(txtCNTenHang);
		txtCNTenHang.setColumns(10);
		
		txtCNSoLuong = new JTextField();
		txtCNSoLuong.setBounds(452, 305, 86, 20);
		contentPane.add(txtCNSoLuong);
		txtCNSoLuong.setColumns(10);
		
		JLabel label = new JLabel("Ma Hang");
		label.setBounds(68, 282, 86, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Ten Hang");
		label_1.setBounds(180, 281, 86, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("So Luong");
		label_2.setBounds(452, 280, 86, 14);
		contentPane.add(label_2);
		
		JButton btSua = new JButton("Sua");
		btSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String MaHang = txtCNMa.getText();
				try {
					if (hb.TimHang(hb.LayDS(), MaHang) == null) {
						JOptionPane.showMessageDialog(null,"Khong Tim Thay Ma Hang");
						return;
					}
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
				String TenHang = txtCNTenHang.getText();
				String Ngay = txtCNNgay.getText() + "/" + txtCNThang.getText() + "/" + txtCNNam.getText();
				int SoLuong = Integer.parseInt(txtCNSoLuong.getText());
				int Gia = Integer.parseInt(txtCNGia.getText());
				try {
					Date NgayNhapHang = new Date(dd.parse(Ngay).getTime());
					hb.Sua(MaHang, TenHang, NgayNhapHang, SoLuong, Gia);
					HienThi(hb.LayDS());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btSua.setBounds(10, 336, 89, 23);
		contentPane.add(btSua);
		
		txtCNNam = new JTextField();
		txtCNNam.setBounds(384, 305, 46, 20);
		contentPane.add(txtCNNam);
		txtCNNam.setColumns(10);
		
		txtCNGia = new JTextField();
		txtCNGia.setBounds(552, 305, 86, 20);
		contentPane.add(txtCNGia);
		txtCNGia.setColumns(10);
		
		txtCNThang = new JTextField();
		txtCNThang.setBounds(339, 305, 35, 20);
		contentPane.add(txtCNThang);
		txtCNThang.setColumns(10);
		
		txtCNNgay = new JTextField();
		txtCNNgay.setBounds(288, 305, 35, 20);
		contentPane.add(txtCNNgay);
		txtCNNgay.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Ngay        Thang      Nam");
		lblNewLabel_5.setBounds(290, 281, 140, 14);
		contentPane.add(lblNewLabel_5);
		
		txtSNgay = new JTextField();
		txtSNgay.setBounds(20, 397, 38, 20);
		contentPane.add(txtSNgay);
		txtSNgay.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Cap Nhat");
		lblNewLabel_6.setBounds(10, 308, 48, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btThem = new JButton("Them");
		btThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btThem.setBounds(131, 336, 89, 23);
		contentPane.add(btThem);
		
		JLabel lblNewLabel_7 = new JLabel("Gia");
		lblNewLabel_7.setBounds(556, 283, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btHienThiNgay = new JButton("Tim Ngay");
		btHienThiNgay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String NgayBD = txtSNgay.getText() + "/" + txtSThang.getText() + "/" + txtSNam.getText();
				String NgayKT = txtENgay.getText() + "/" + txtEThang.getText() + "/" + txtENam.getText();
				try {
					HienThi(hb.TimNgay(new Date(dd.parse(NgayBD).getTime()), new Date(dd.parse(NgayKT).getTime())));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		btHienThiNgay.setBounds(394, 396, 112, 23);
		contentPane.add(btHienThiNgay);
		
		txtSThang = new JTextField();
		txtSThang.setColumns(10);
		txtSThang.setBounds(68, 397, 35, 20);
		contentPane.add(txtSThang);
		
		txtSNam = new JTextField();
		txtSNam.setColumns(10);
		txtSNam.setBounds(113, 397, 46, 20);
		contentPane.add(txtSNam);
		
		txtENgay = new JTextField();
		txtENgay.setColumns(10);
		txtENgay.setBounds(208, 397, 35, 20);
		contentPane.add(txtENgay);
		
		txtEThang = new JTextField();
		txtEThang.setColumns(10);
		txtEThang.setBounds(253, 397, 35, 20);
		contentPane.add(txtEThang);
		
		txtENam = new JTextField();
		txtENam.setColumns(10);
		txtENam.setBounds(306, 397, 46, 20);
		contentPane.add(txtENam);
		
		JLabel label_3 = new JLabel("Ngay        Thang      Nam");
		label_3.setBounds(20, 370, 140, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Ngay        Thang      Nam");
		label_4.setBounds(208, 370, 140, 14);
		contentPane.add(label_4);
		
		JLabel lblNewLabel_8 = new JLabel("---->");
		lblNewLabel_8.setBounds(167, 400, 35, 14);
		contentPane.add(lblNewLabel_8);
		
		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar() == 10) {
					try {
						HienThi(hb.TimTen(txtTimKiem.getText()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(180, 2, 132, 20);
		contentPane.add(txtTimKiem);
		
		JLabel txtTimKiemTen = new JLabel("Ten");
		txtTimKiemTen.setBounds(137, 5, 46, 14);
		contentPane.add(txtTimKiemTen);
	}
}
