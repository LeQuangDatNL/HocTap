package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.TinA;
import bean.TinB;
import bo.SinhVienBo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GiaoDien extends JFrame {

	private JPanel contentPane;
	private JTable tbB;
	private JTable tbA;
	private JTextField txtTimTen;
	SinhVienBo B = new SinhVienBo();
	public void HienThiA(ArrayList<TinA> A) {
		DefaultTableModel TB = new DefaultTableModel();
		TB.addColumn("Ma Sv");
		TB.addColumn("Ho Ten");
		TB.addColumn("Diem Win");
		TB.addColumn("Diem Word");
		TB.addColumn("Diem TB");
		for (TinA x:A) {
			TB.addRow(x.toString().split("[;]"));
		}
		tbA.setModel(TB);
	}
	public void HienThiB(ArrayList<TinB> B) {
		DefaultTableModel TB = new DefaultTableModel();
		TB.addColumn("Ma Sv");
		TB.addColumn("Ho Ten");
		TB.addColumn("Diem Exel");
		TB.addColumn("Diem Power");
		TB.addColumn("Diem Web");
		TB.addColumn("Diem TB");
		for (TinB x:B) {
			TB.addRow(x.toString().split("[;]"));
		}
		tbB.setModel(TB);
	}
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien frame = new GiaoDien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public GiaoDien() throws Exception {
		B.layds();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(21, 11, 330, 247);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Tin A", null, scrollPane_1, null);
		
		tbA = new JTable();
		scrollPane_1.setViewportView(tbA);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Tin B", null, scrollPane, null);
		
		tbB = new JTable();
		scrollPane.setViewportView(tbB);
		
		JButton btHienThi = new JButton("HienThi");
		btHienThi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					HienThiA(B.HienThiA());
					HienThiB(B.HienThiB());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btHienThi.setBounds(51, 307, 89, 23);
		contentPane.add(btHienThi);
		
		JButton btTimKiem = new JButton("Tim Kiem");
		btTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Ten = txtTimTen.getText();
				try {
					HienThiA(B.HienThiTenA(Ten));
					HienThiB(B.HienThiTenB(Ten));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btTimKiem.setBounds(189, 307, 89, 23);
		contentPane.add(btTimKiem);
		
		JButton btLuuFile = new JButton("LuuFile");
		btLuuFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					JOptionPane.showMessageDialog(null,"Da Luu");
					B.LuuFile();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btLuuFile.setBounds(361, 307, 89, 23);
		contentPane.add(btLuuFile);
		
		txtTimTen = new JTextField();
		txtTimTen.setBounds(189, 276, 139, 20);
		contentPane.add(txtTimTen);
		txtTimTen.setColumns(10);
	}
}
