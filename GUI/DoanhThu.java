package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DoanhThu extends JFrame {

	private JPanel contentPane;
	private JTextField txtDanhSchTng;
	private JTextField txtDanhSchTng_1;
	private JTextField txtTngDoanhThu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoanhThu frame = new DoanhThu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DoanhThu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(155, 207, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,251,164));
		panel.setBounds(0, 50, 1250, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
		DefaultTableModel modelTT = new DefaultTableModel();
        JTable tblTT = new JTable();
        JScrollPane jcTT = new JScrollPane();
        jcTT.setViewportView(tblTT);
        modelTT.addColumn("Ngày");
        modelTT.addColumn("Số lượng hóa đơn");
        modelTT.addColumn("Thành tiền");
        modelTT.addColumn("Ghi chú");
        jcTT.setBounds(120,103,967,300);
        tblTT.setModel(modelTT);
        panel.add(jcTT);
		
		txtDanhSchTng = new JTextField();
		txtDanhSchTng.setBounds(1090, 0, 150, 30);
		txtDanhSchTng.setForeground(new Color(0, 0, 0));
		txtDanhSchTng.setBackground(new Color(50, 205, 50));
		txtDanhSchTng.setFont(new Font("Sitka Text", Font.ITALIC, 14));
		txtDanhSchTng.setHorizontalAlignment(SwingConstants.CENTER);
		txtDanhSchTng.setText("Danh sách tổng thu");
		panel.add(txtDanhSchTng);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 251, 164));
		panel_1.setBounds(0, 50, 1250, 450);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtDanhSchTng_1 = new JTextField();
		txtDanhSchTng_1.setBounds(1090, 0, 150, 30);
		txtDanhSchTng_1.setText("Danh sách tổng chi");
		txtDanhSchTng_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtDanhSchTng_1.setForeground(Color.BLACK);
		txtDanhSchTng_1.setFont(new Font("Sitka Text", Font.ITALIC, 14));
		txtDanhSchTng_1.setColumns(10);
		txtDanhSchTng_1.setBackground(new Color(50, 205, 50));
		panel_1.add(txtDanhSchTng_1);
		
		DefaultTableModel modelTC = new DefaultTableModel();
        JTable tblTC = new JTable();
		JScrollPane jcTC = new JScrollPane();
		jcTC.setViewportView(tblTC);
        modelTC.addColumn("Ngày");
        modelTC.addColumn("Số lượng phiếu nhập");
        modelTC.addColumn("Thành tiền");
        modelTC.addColumn("Ghi chú");
		jcTC.setBounds(120,103,967,300);
		tblTC.setModel(modelTC);
		panel_1.add(jcTC);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 251, 164));
		panel_2.setBounds(0, 50, 1250, 450);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtTngDoanhThu = new JTextField();
		txtTngDoanhThu.setBounds(1090, 0, 150, 30);
		txtTngDoanhThu.setText("Tổng Doanh Thu");
		txtTngDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		txtTngDoanhThu.setForeground(Color.BLACK);
		txtTngDoanhThu.setFont(new Font("Sitka Text", Font.ITALIC, 14));
		txtTngDoanhThu.setColumns(10);
		txtTngDoanhThu.setBackground(new Color(50, 205, 50));
		panel_2.add(txtTngDoanhThu);
		
		DefaultTableModel modelDT = new DefaultTableModel();
        JTable tblDT = new JTable();
        JScrollPane jcDT = new JScrollPane();
        jcDT.setViewportView(tblDT);
        modelDT.addColumn("Ngày");
        modelDT.addColumn("Tổng Thu");
        modelDT.addColumn("Tổng Chi");
        modelDT.addColumn("Thành Tiền");
        modelDT.addColumn("Ghi Chú");
        jcDT.setBounds(120,103,967,300);
        tblDT.setModel(modelDT);
		panel_2.add(jcDT);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\admin\\eclipse-workspace\\BTL_T14\\Imager\\back_25px.png"));
		btnNewButton.setBounds(0, 0, 50, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tổng Thu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.setBounds(279, 30, 100, 20);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tổng Chi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 255));
		btnNewButton_2.setBounds(494, 30, 100, 20);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Doanh Thu");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 0, 255));
		btnNewButton_3.setBounds(702, 30, 100, 20);
		contentPane.add(btnNewButton_3);
	}
}
