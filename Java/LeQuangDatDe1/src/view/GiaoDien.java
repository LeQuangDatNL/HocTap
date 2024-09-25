package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.NhanVien;
import bo.NhanVienBo;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GiaoDien extends JFrame {

	private JPanel contentPane;
	NhanVienBo B = new NhanVienBo();
	private JTable tb;
	/**
	 * Launch the application.
	 */
	void HienThi(ArrayList<NhanVien> A) {
		DefaultTableModel TB = new DefaultTableModel();
		TB.addColumn("Ma");
		TB.addColumn("Ho Ten");
		TB.addColumn("Loai Hop Dong");
		TB.addColumn("He So Luong");
		for (NhanVien x:A) {
			TB.addRow(x.tovetor());
		}
		tb.setModel(TB);
	}
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
	 */
	public GiaoDien() {
		try {
			B.layds();
			B.HienThiChinhThuc();
			B.LuuFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(62, 29, 219, 163);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Thong Tin", null, scrollPane, null);
		
		tb = new JTable();
		scrollPane.setViewportView(tb);
		
		JButton btHienThi = new JButton("HienThi");
		btHienThi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					HienThi(B.layds());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btHienThi.setBounds(25, 216, 89, 23);
		contentPane.add(btHienThi);
		
		JButton btChinhThuc = new JButton("HT chinh thuc");
		btChinhThuc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					HienThi(B.HienThiChinhThuc());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btChinhThuc.setBounds(144, 216, 122, 23);
		contentPane.add(btChinhThuc);
		
		JButton btLuu = new JButton("Luu File");
		btLuu.addMouseListener(new MouseAdapter() {
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
		btLuu.setBounds(305, 216, 89, 23);
		contentPane.add(btLuu);
	}
}
