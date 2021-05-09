package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.border.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import BUS.*;
import DTO.*;

public class DS_NCC {
    JFrame frame = new JFrame();
    
    JTextField txMaNCC, txTenNCC, txSDT, txDiaChi;
    JLabel lbMaNCC, lbTenNCC, lbSDT, lbDiaChi;
    static DefaultTableModel modelNCC;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    JTextField txTimKiemNCC;
    JLabel lbTimKiemNCC;
    
    JTable tblNCC;
    JPanel pNCC, pBG;
    public DS_NCC(){
        frame.setSize(1250,500);
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);

        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pNCC = new JPanel();
        pNCC.setBackground(new Color(155, 207, 243));
        pNCC.setLayout(null);
        pNCC.setBounds(0,0,1250,100);
        pNCC.setBorder(BorderFactory.createTitledBorder(blackBorder, "  Nhà Cung Cấp  ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pBG = new JPanel();
        pBG.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txMaNCC.setText("");
				txTenNCC.setText("");
				txSDT.setText("");
				txDiaChi.setText("");

			}	
		});
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,1250,500);
        
        
        txMaNCC = new JTextField();
        txTenNCC = new JTextField();
        txSDT = new JTextField();
        txDiaChi = new JTextField();
        lbMaNCC = new JLabel("Mã nhà cung cấp");
        lbTenNCC = new JLabel("Tên nhà cung cấp");
        lbSDT = new JLabel("Số điện thoại");
        lbDiaChi = new JLabel("Địa chỉ");
        txTimKiemNCC = new JTextField();
        lbTimKiemNCC = new JLabel("");
        lbTimKiemNCC.setIcon(new ImageIcon("C:\\Users\\khoaa\\eclipse-workspace\\DoAnJava\\src\\Imager\\timkiem-25.png"));
        lbTimKiemNCC.setFont(new Font("Arial", Font.ITALIC, 16));
        lbMaNCC.setBounds(100,20,100,20);
        txMaNCC.setBounds(200,20,120,20);
        lbTenNCC.setBounds(507,20,120,20);
        txTenNCC.setBounds(648,20,120,20);
        lbSDT.setBounds(100,60,100,20);
        txSDT.setBounds(200,60,120,20);
        lbDiaChi.setBounds(507,60,120,20);
        txDiaChi.setBounds(648,60,120,20);
        lbTimKiemNCC.setBounds(20, 120, 25, 20);
        txTimKiemNCC.setBounds(57, 120, 203, 20);
        pNCC.add(lbMaNCC);
        pNCC.add(txMaNCC);
        pNCC.add(lbTenNCC);
        pNCC.add(txTenNCC);
        pNCC.add(lbSDT);
        pNCC.add(txSDT);
        pNCC.add(lbDiaChi);
        pNCC.add(txDiaChi);
        pBG.add(lbTimKiemNCC);
        pBG.add(txTimKiemNCC);
        
        btXoa = new JButton("Xóa");
        btXoa.setBorder(BorderFactory.createEmptyBorder());
        btXoa.setBackground(Color.BLUE);
        btXoa.setForeground(Color.WHITE);
        btCapNhat = new JButton("Cập nhật");
        btCapNhat.setBorder(BorderFactory.createEmptyBorder());
        btCapNhat.setBackground(Color.BLUE);
        btCapNhat.setForeground(Color.WHITE);
        btThem = new JButton("Thêm");
        btThem.setBorder(BorderFactory.createEmptyBorder());
        btThem.setBackground(Color.BLUE);
        btThem.setForeground(Color.WHITE);
        btThoat = new JButton("<");
        btThoat.setBorder(BorderFactory.createEmptyBorder());
        btThoat.setBackground(Color.BLUE);
        btThoat.setForeground(Color.WHITE);
        btThem.setBounds(954,20,100,20);
        btCapNhat.setBounds(1100,20,100,20);
        btXoa.setBounds(1040,60,100,20);
        btThoat.setBounds(20,20,20,20);
        pNCC.add(btThem);
        pNCC.add(btCapNhat);
        pNCC.add(btXoa);
        pNCC.add(btThoat);
        pBG.add(pNCC);
        
        modelNCC = new DefaultTableModel();
        tblNCC = new JTable();
        JScrollPane jcNCC = new JScrollPane();
        jcNCC.setViewportView(tblNCC);
        modelNCC.addColumn("Mã nhà cung cấp");
        modelNCC.addColumn("Tên nhà cung cấp");
        modelNCC.addColumn("Số điện thoại");
        modelNCC.addColumn("Địa chỉ");
        jcNCC.setBounds(20,180,1200,300);
        pBG.add(jcNCC);
        tblNCC.setModel(modelNCC);
        
        frame.getContentPane().add(pBG);
        
        tblNCC.addMouseListener(new MouseAdapter() {
    	 	@Override
    	 	public void mouseClicked(MouseEvent e) {
    	 		int i = tblNCC.getSelectedRow();
    	 		if(i>=0) {
    						NhaCungCapDTO ncc = new NhaCungCapDTO();
    						ncc =NhaCungCapBUS.dsncc.get(i);
    						txMaNCC.setText(ncc.getMaNhaCungCap());
    						txTenNCC.setText(ncc.getTenNhaCungCap());
    						txSDT.setText(ncc.getSoDienThoai());
    						txDiaChi.setText(ncc.getDiaChi());
    					}
    				}

    			});	
        
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   new MainFrame();
                    frame.hide();
            }
        });
        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 
                  NhaCungCapDTO ncc = new NhaCungCapDTO();
                  NhaCungCapBUS ncb = new NhaCungCapBUS();
                  ncc.setMaNhaCungCap(txMaNCC.getText());
                  if(txMaNCC.getText().equals("")) {
                	  JOptionPane.showMessageDialog(jcNCC, " Mã Nhà Cung Cấp không được để trống");
                  }
                  ncc.setTenNhaCungCap(txTenNCC.getText());
                  if(txTenNCC.getText().equals("")) {
                	  JOptionPane.showMessageDialog(jcNCC, "Tên Nhà Cung Cấp không được để trống");
                  }
                  ncc.setSoDienThoai(txSDT.getText());
                  if(txSDT.getText().equals("")) {
              		JOptionPane.showMessageDialog(jcNCC, "Số điện thoại không được để trống");
              	}else if(!Pattern.matches("^0{1}[1-9]{1}[0-9]{8}$", txSDT.getText())) {
              		JOptionPane.showMessageDialog(jcNCC, "Số điện thoại không hợp lệ");
              	}
                  ncc.setDiaChi(txDiaChi.getText());     
                  if(txDiaChi.getText().equals("")){
                	  JOptionPane.showMessageDialog(jcNCC, "Địa chỉ không được để trống");
                  }else {
                	  ncb.themNCC(ncc);
                	  loadNCC();
                  }
            }
        });
        btXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  NhaCungCapBUS ncb = new NhaCungCapBUS();
                  int i = tblNCC.getSelectedRow();
                  if(i>=0) {
                	  ncb.xoaNCC((String)tblNCC.getValueAt(i, 0));
                	  loadNCC();
                  }else {
                	  JOptionPane.showMessageDialog(pBG,"Vui lòng chọn dòng muốn xóa!");
                  }
                 
            }
        });
        btCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  NhaCungCapDTO ncc = new NhaCungCapDTO();
                  NhaCungCapBUS ncb = new NhaCungCapBUS();
                  int i = tblNCC.getSelectedRow();
                  ncc.setMaNhaCungCap(txMaNCC.getText());
                  if(txMaNCC.getText().equals("")) {
                	  JOptionPane.showMessageDialog(jcNCC, " Mã Nhà Cung Cấp không được để trống");
                  }
                  ncc.setTenNhaCungCap(txTenNCC.getText());
                  if(txTenNCC.getText().equals("")) {
                	  JOptionPane.showMessageDialog(jcNCC, "Tên Nhà Cung Cấp không được để trống");
                  }
                  ncc.setSoDienThoai(txSDT.getText());
                  if(txSDT.getText().equals("")) {
                		JOptionPane.showMessageDialog(jcNCC, "Số điện thoại không được để trống");
                	}else if(!Pattern.matches("^0{1}[1-9]{1}[0-9]{8}$", txSDT.getText())) {
                		JOptionPane.showMessageDialog(jcNCC, "Số điện thoại không hợp lệ");
                	}
                  ncc.setDiaChi(txDiaChi.getText());
                  if(txDiaChi.getText().equals("")){
                	  JOptionPane.showMessageDialog(jcNCC, "Địa chỉ không được để trống");
                  }
                 if(i>=0) {
                	  ncb.suaNCC((String)tblNCC.getValueAt(i, 0), ncc);
                	  loadNCC();
                  }else {
                	  JOptionPane.showMessageDialog(pBG,"Vui lòng chọn dòng muốn sửa!");
                  }
                 
            }
        });
        txMaNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txTenNCC.requestFocus();
                }
            }
        }); 
        txTenNCC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txSDT.requestFocus();
                }
            }
        });
        txSDT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txDiaChi.requestFocus();
                }
            }
        });
        txDiaChi.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btThem.doClick();
                }
            }
        });
        
        loadNCC();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public static void loadNCC() {
    	NhaCungCapBUS ncb = new NhaCungCapBUS();
    	
    	ncb.docDSNCC();
    	modelNCC.setRowCount(0);
    	for(NhaCungCapDTO ncc: NhaCungCapBUS.dsncc) {
    		Vector<String> row = new Vector<String>();
    		row.add(ncc.getMaNhaCungCap());
    		row.add(ncc.getTenNhaCungCap());
    		row.add(ncc.getSoDienThoai());
    		row.add(ncc.getDiaChi());
    		modelNCC.addRow(row);
    	}
    	
    }
    public static void main(String[] args) {
    	new DS_NCC();
    }
}
