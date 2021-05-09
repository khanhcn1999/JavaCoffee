package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.border.*;
import BUS.*;
import DTO.*;

public class DS_PNH {
    JFrame frame = new JFrame();
    private static DefaultTableModel modelPNH;
    private static DefaultTableModel modelCTPNH;
    JScrollPane scCTPNH;
    String ma = null;
    JButton btThemPN, btThoat;
    JTextField txMaPNH, txNgayNhap, txTongCong, txSearch ;
    JLabel lbMaPNH, lbMaNV, lbMaNCC, lbNgayNhap, lbTongCong, lbSearch;
  
    JLabel lbMaPhieuNhap, lbMaNguyenLieu, lbTenNguyenLieu,lbSoLuong, lbDonGia;
    JButton btSua, btXoa, btThem, btLuu; 
    
    JTable tbPNH, tbCTPNH;
    JPanel pPNH, pCTPNH, pBG;
    private static JComboBox<NhaCungCapDTO> cbMaNhaCungCap;
    private static JComboBox<NhanVien> cbMaNhanVien;
    NhanVien nvsl;
	NhaCungCapDTO nccsl;
    public DS_PNH(){
        frame.setSize(1250,700);
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pPNH = new JPanel();
        pPNH.setBackground(new Color(155, 207, 243));
        pPNH.setLayout(null);
        pPNH.setBounds(0,0,1250,100);
        pPNH.setBorder(BorderFactory.createTitledBorder(blackBorder, " Hóa Đơn   ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pCTPNH = new JPanel();
        pCTPNH.setBackground(new Color(155, 207, 243));
        pCTPNH.setLayout(null);
        pCTPNH.setBounds(30, 420, 692, 240);
        pCTPNH.setBorder(BorderFactory.createTitledBorder(blackBorder, " Chi Tiết Hóa Đơn   ",TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        pBG = new JPanel();
        pBG.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				reset();
			}	
		});
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,1250,700);
        
// Phiếu Nhập Hàng
        txMaPNH = new JTextField();
        txMaPNH.setEnabled(false);
        txNgayNhap = new JTextField();
        txNgayNhap.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btThemPN.doClick();
                }
            }
        });
        txTongCong = new JTextField(); 
        txTongCong.setEnabled(false);
        txSearch = new JTextField();
        lbMaPNH = new JLabel("Mã phiếu nhập ");
        lbMaNV = new JLabel("Mã nhân viên"); 
        lbMaNCC = new JLabel("Mã nhà cung cấp");
        lbNgayNhap = new JLabel("Ngày nhập");
        lbTongCong = new JLabel("Tổng cộng");
        lbSearch = new JLabel("Tìm kiếm");
        lbSearch.setFont(new Font("Arial", Font.ITALIC, 16));
        lbSearch.setBounds(20, 120, 120, 20);
        txSearch.setBounds(125, 120, 200, 20);
        lbMaPNH.setBounds(100,20,100,20);
        txMaPNH.setBounds(200,20,120,20);
        lbMaNV.setBounds(370,20,120,20);
        lbMaNCC.setBounds(660,20,100,20);
        lbNgayNhap.setBounds(100,60,100,20);
        txNgayNhap.setBounds(200,60,120,20);
        lbTongCong.setBounds(370,60,120,20);
        txTongCong.setBounds(490,60,120,20);
        pPNH.add(lbMaPNH);
        pPNH.add(txMaPNH);
        pPNH.add(lbMaNV);
        pPNH.add(lbMaNCC);
        pPNH.add(lbNgayNhap);
        pPNH.add(txNgayNhap);
        pPNH.add(lbTongCong);
        pPNH.add(txTongCong);
        pBG.add(lbSearch);
        pBG.add(txSearch);
        
        btThemPN = new JButton("Thêm PN");
        btThemPN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			PhieuNhapHangDTO pnh = new PhieuNhapHangDTO();
			PhieuNhapHangBUS pnb = new PhieuNhapHangBUS();
			pnh.setMaPhieuNhap(txMaPhieuNhap.getText());
			pnh.setMaNhanVien(nvsl.getMaNV());
			pnh.setMaNhaCungCap(nccsl.getMaNhaCungCap());
			pnh.setNgayNhap(txNgayNhap.getText());
			pnh.setTongCong(Double.parseDouble(txTongCong.getText()));
			pnb.them(pnh);
			reset();
			loadPNH();
			}
		});
        btThemPN.setBorder(BorderFactory.createEmptyBorder());
        btThemPN.setBackground(Color.BLUE);
        btThemPN.setForeground(Color.WHITE);
        btThoat = new JButton("");
        btThoat.setIcon(new ImageIcon("Imager\\back_25px.png"));
        btThoat.setBorder(BorderFactory.createEmptyBorder());
        btThoat.setBackground(Color.BLUE);
        btThoat.setForeground(Color.WHITE);
        btThemPN.setBounds(980,20,100,20);
        btThoat.setBounds(10,11,31,20);
        pPNH.add(btThemPN);
        pPNH.add(btThoat);
        pBG.add(pPNH);
        
      cbMaNhanVien = new JComboBox<NhanVien>();
        loadcmbnv();
        cbMaNhanVien.setBounds(490, 20, 120, 20);
        cbMaNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbMaNhanVien.getSelectedItem() ==  null) {
					return ;
				}
				nvsl = (NhanVien) cbMaNhanVien.getSelectedItem();
			}
		});
        pPNH.add(cbMaNhanVien);
        
        cbMaNhaCungCap = new JComboBox<NhaCungCapDTO>();
        loadcmbncc();
        cbMaNhaCungCap.setBounds(785, 19, 120, 20);
        cbMaNhaCungCap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbMaNhaCungCap.getSelectedItem() ==  null) {
					return ;
				}
			nccsl = (NhaCungCapDTO) cbMaNhaCungCap.getSelectedItem();			
			}
		});
        pPNH.add(cbMaNhaCungCap);
        
        modelPNH = new DefaultTableModel();
        tbPNH = new JTable();
        tbPNH.addMouseListener(new MouseAdapter() {
    	 	@Override
    	 	public void mouseClicked(MouseEvent e) {
    	 		int i = tbPNH.getSelectedRow();
    	 		btThemPN.setEnabled(false);
    	 		txMaPNH.setText(tbPNH.getValueAt(i, 0).toString());
    	 		for(NhanVien nv : nv) {
					
					if(tbPNH.getValueAt(i, 1 ).toString().equals(nv.getMaNV())) {							
						cbMaNhanVien.setSelectedItem(nv);									
						break;
					}
				}
				for(NhaCungCapDTO ncc : ncc) {
					if(tbPNH.getValueAt(i, 2).toString().equals(ncc.getMaNhaCungCap())) {
						cbMaNhaCungCap.setSelectedItem(ncc);
						break;
					}
				}
				txNgayNhap.setText(tbPNH.getValueAt(i, 3).toString());
				txTongCong.setText(tbPNH.getValueAt(i, 4).toString());
    	 		modelCTPNH.setRowCount(0);
    	 		String MaPN = String.valueOf(modelPNH.getValueAt(i, 0));
    	 		for(ChiTietPhieuNhapDTO ct: ChiTietPhieuNhapBUS.dsctpn) {
    	 			if(ct.getMaPhieuNhap().contains(MaPN)) {
    	 				modelCTPNH.addRow(new String[] { ct.getMaPhieuNhap(),ct.getMaNguyenLieu(),ct.getTenNgyenLieu(),String.valueOf(ct.getSoLuong()),String.valueOf(ct.getDonGia()),String.valueOf(ct.getThanhTien())});
    	 				tbCTPNH.setModel(modelCTPNH);
    	 				}
    	 			}
    	 		}
        });
        
        JScrollPane jcPNH = new JScrollPane();
        jcPNH.setViewportView(tbPNH);
        modelPNH.addColumn("Mã phiếu nhập");
        modelPNH.addColumn("Mã nhân viên");
        modelPNH.addColumn("Mã nhà cung cấp");
        modelPNH.addColumn("Ngày nhập");
        modelPNH.addColumn("Tổng cộng");
        jcPNH.setBounds(30,160,692,200);
        pBG.add(jcPNH);
        tbPNH.setModel(modelPNH);
        
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {             
                    new MainFrame();
                    frame.hide();
            }
        });

// Chi Tiết Phiếu Nhập Hàng

        lbMaPhieuNhap = new JLabel("Mã phiếu nhập");
        lbMaNguyenLieu = new JLabel("Mã nguyên liệu"); 
        lbTenNguyenLieu = new JLabel("Tên nguyên liệu");
        lbSoLuong = new JLabel("Số lượng");
        lbDonGia = new JLabel("Đơn giá");
        lbMaPhieuNhap.setBounds(20,30,100,20);
        
        lbMaNguyenLieu.setBounds(20,70,100,20);
       
        lbSoLuong.setBounds(404,30,100,20);
      
        lbDonGia.setBounds(404,70,100,20);
      
        pCTPNH.add(lbMaPhieuNhap);
       
        pCTPNH.add(lbMaNguyenLieu);
       
        pCTPNH.add(lbSoLuong);
       
      
        pCTPNH.add(lbDonGia);
      
        
        btXoa = new JButton("Xóa CTHĐ");
        btXoa.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    		int i = tbCTPNH.getSelectedRow()	;
    		ChiTietPhieuNhapBUS ctb = new ChiTietPhieuNhapBUS();
    		if(i>=0) {
    			if(kiemtrama(txMaPhieuNhap.getText())) {
   				 JOptionPane.showMessageDialog(jcPNH, "Không thể xóa");
   			 }else {
    			ctb.xoa((String) tbCTPNH.getValueAt(i, 0), (String) tbCTPNH.getValueAt(i, 1));
    			reset();
   			 }
    		}
    		else {
    			JOptionPane.showMessageDialog(pBG,"Vui lòng chọn dòng muốn xóa!");
    		}
    		}
    	 }
    			 );
        btXoa.setBorder(BorderFactory.createEmptyBorder());
        btXoa.setBackground(Color.BLUE);
        btXoa.setForeground(Color.WHITE);
        btSua = new JButton("Cập nhật");
        btSua.addActionListener(new ActionListener() {
    		@Override 
    			 public void actionPerformed(ActionEvent e) {
    		 int i = tbCTPNH.getSelectedRow();
    		 ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
    		 ChiTietPhieuNhapBUS ctb = new ChiTietPhieuNhapBUS();
    		 ctpn.setMaPhieuNhap(txMaPhieuNhap.getText());
    		 ctpn.setMaNguyenLieu(txMaNguyenLieu.getText());
    		 ctpn.setTenNgyenLieu(txTenNguyenLieu.getText());
    		 ctpn.setSoLuong(Double.parseDouble(txSoLuong.getText()));
    		 ctpn.setDonGia(Double.parseDouble(txDonGia.getText()));
    		 ctpn.setThanhTien(ctpn.getDonGia()*ctpn.getSoLuong());
    		 if(i>=0) {
    			 if(kiemtrama(txMaPhieuNhap.getText())) {
    				 JOptionPane.showMessageDialog(jcPNH, "Không thể sửa");
    			 }else {
    			 ctb.sua((String) tbCTPNH.getValueAt(i, 0),(String) tbCTPNH.getValueAt(i, 1),ctpn);
    			reset();
    			 }
    		 }
    		 else {
    			 JOptionPane.showMessageDialog(pBG, "Vui lòng chọn dòng muốn sửa!");
    		 }
    	 }
    			 
    	 });

        btSua.setBorder(BorderFactory.createEmptyBorder());
        btSua.setBackground(Color.BLUE);
        btSua.setForeground(Color.WHITE);
        btThem = new JButton("Thêm CTHĐ");
        btThem.addActionListener(new ActionListener() {
    	 	public void actionPerformed(ActionEvent e) {
    	 	 ChiTietPhieuNhapDTO ct = new ChiTietPhieuNhapDTO();
    	 	 double sl = 0;
			 NguyenLieuBUS nlb = new NguyenLieuBUS();
    		 ct.setMaPhieuNhap(txMaPhieuNhap.getText());
    		 ct.setMaNguyenLieu(txMaNguyenLieu.getText());
    		 ct.setTenNgyenLieu(txTenNguyenLieu.getText());
    		 ct.setSoLuong(Double.parseDouble(txSoLuong.getText()));
    		 ct.setDonGia(Double.parseDouble(txDonGia.getText()));
    		 ct.setThanhTien(ct.getDonGia()*ct.getSoLuong());
    		 ChiTietPhieuNhapBUS ctb = new ChiTietPhieuNhapBUS();	 
    		if(kiemtrama(txMaPhieuNhap.getText())){
    			JOptionPane.showMessageDialog(pBG,"Phiếu Nhập đã tồn tại");
    		}
    		else {
    			 ctb.them(ct);	
    			 reset();
    			 if(kiemtranl(txMaNguyenLieu.getText())){
    				for(NguyenLieuDTO nl: DSNL) {
    					if(nl.getMaNguyenLieu().equals(txMaNguyenLieu.getText())) {
    						sl = nl.getSoLuong() + Double.parseDouble(txSoLuong.getText());
    						nl.setSoLuong(sl);
    						nl.setDonGia(Double.parseDouble(txDonGia.getText()));
    						nlb.UpdateNL(nl, txMaNguyenLieu.getText()); 						
    					}
    				}
    			 }else {
    				 NguyenLieuDTO nl = new NguyenLieuDTO();
    				 nl.setMaNguyenLieu(txMaNguyenLieu.getText());
    				 nl.setTenNl(txTenNguyenLieu.getText());
    				 nl.setSoLuong(Double.parseDouble(txSoLuong.getText()));
    				 nl.setDonGia(Double.parseDouble(txDonGia.getText()));
    				 nlb.themNL(nl);
    			 }
    		} 
    	 	}
    			 });
        btThem.setBorder(BorderFactory.createEmptyBorder());
        btThem.setBackground(Color.BLUE);
        btThem.setForeground(Color.WHITE);
        btThem.setBounds(100,167,100,20);
        btSua.setBounds(560,167,100,20);
        btXoa.setBounds(332,167,100,20);
        pCTPNH.add(btThem);
        pCTPNH.add(btSua);
        pCTPNH.add(btXoa);
        pBG.add(pCTPNH);
        
      
      
        
        JLabel lbTenNguyenLieu = new JLabel("Tên nguyên liệu");
        lbTenNguyenLieu.setBounds(20, 110, 100, 20);
        pCTPNH.add(lbTenNguyenLieu);
        
        txMaPhieuNhap = new JTextField();
        txMaPhieuNhap.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txMaNguyenLieu.requestFocus();
                }
            }
        });
        txMaPhieuNhap.setBounds(123, 30, 142, 20);
        pCTPNH.add(txMaPhieuNhap);
        txMaPhieuNhap.setColumns(10);
        
        txMaNguyenLieu = new JTextField();
        txMaNguyenLieu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txTenNguyenLieu.requestFocus();
                }
            }
        });
        txMaNguyenLieu.setColumns(10);
        txMaNguyenLieu.setBounds(123, 70, 142, 20);
        pCTPNH.add(txMaNguyenLieu);
        
        txTenNguyenLieu = new JTextField();
        txTenNguyenLieu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txSoLuong.requestFocus();
                }
            }
        });
        txTenNguyenLieu.setColumns(10);
        txTenNguyenLieu.setBounds(123, 110, 142, 20);
        pCTPNH.add(txTenNguyenLieu);
        
        txSoLuong = new JTextField();
        txSoLuong.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txDonGia.requestFocus();
                }
            }
        });
        txSoLuong.setColumns(10);
        txSoLuong.setBounds(514, 30, 142, 20);
        pCTPNH.add(txSoLuong);
        
        txDonGia = new JTextField();
        txDonGia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btThem.doClick();
                }
            }
        });
        txDonGia.setColumns(10);
        txDonGia.setBounds(514, 70, 142, 20);
        pCTPNH.add(txDonGia);
        
        modelCTPNH = new DefaultTableModel();
        tbCTPNH = new JTable();
        JScrollPane jcCTPNH = new JScrollPane();
        tbCTPNH.setModel(modelCTPNH);
        tbCTPNH.addMouseListener(new MouseAdapter() {
    	 	@Override
    	 	public void mouseClicked(MouseEvent e) {
    	 		int i = tbCTPNH.getSelectedRow();
    	 		if(i>=0) {
    	 			ma = modelCTPNH.getValueAt(i, 0).toString() ;
    						ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
    						ctpn=ChiTietPhieuNhapBUS.dsctpn.get(i);
    						txMaPhieuNhap.setText(ctpn.getMaPhieuNhap());
    						txMaNguyenLieu.setText(ctpn.getMaNguyenLieu());
    						txTenNguyenLieu.setText(ctpn.getTenNgyenLieu());
    						txSoLuong.setText(String.valueOf(ctpn.getSoLuong()));
    						txDonGia.setText(String.valueOf(ctpn.getDonGia()));
    					}
    				}

    			});	
        jcCTPNH.setViewportView(tbCTPNH);
        modelCTPNH.addColumn("Mã PNH");
        modelCTPNH.addColumn("Mã NL");
        modelCTPNH.addColumn("Tên NL");
        modelCTPNH.addColumn("Số lượng");
        modelCTPNH.addColumn("Đơn giá");
        modelCTPNH.addColumn("Thành tiền");
        jcCTPNH.setBounds(752,160,463,457);
        pBG.add(jcCTPNH);

        frame.getContentPane().add(pBG);
        btLuu = new JButton("Lưu");
        btLuu.addActionListener(new ActionListener() {
    	 	public void actionPerformed(ActionEvent e) {
    	 		    	 		
    	 		txMaPNH.setText(ma);
    	 		loadtxTongCong();
    	 	}	
    	 });
        btLuu.setBounds(1115, 640, 100, 20);
        pBG.add(btLuu);
        btLuu.setBorder(BorderFactory.createEmptyBorder());
        btLuu.setBackground(Color.BLUE);
        btLuu.setForeground(Color.WHITE);
        loadPNH();
        loadCTPN();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public ArrayList<NhanVien> nv = new ArrayList<NhanVien>();
	public void loadcmbnv() {
		nv = null;
		NhanVienBUS nvb = new NhanVienBUS();
		nv = nvb.docDSNV();
		for(NhanVien nv : nv) {
			cbMaNhanVien.addItem(nv);

		}
	}
	public ArrayList<NhaCungCapDTO> ncc = new ArrayList<NhaCungCapDTO>();
	private JTextField txMaPhieuNhap;
	private JTextField txMaNguyenLieu;
	private JTextField txTenNguyenLieu;
	private JTextField txSoLuong;
	private JTextField txDonGia;
	public void loadcmbncc() {
		ncc = null;
		NhaCungCapBUS ncb = new NhaCungCapBUS();
		ncc = ncb.docDSNCC();
		for(NhaCungCapDTO ncc : ncc) {
			cbMaNhaCungCap.addItem(ncc);
		}
	}
	private static void loadCTPN() {
		ChiTietPhieuNhapBUS ctb = new ChiTietPhieuNhapBUS();
		
		try {
			
			ctb.docCTPN();
			
			modelCTPNH.setRowCount(0);
			for(ChiTietPhieuNhapDTO ct : ChiTietPhieuNhapBUS.dsctpn) {
				Vector<String> row = new Vector<String>();
				row.add(ct.getMaPhieuNhap());
				row.add(ct.getMaNguyenLieu());
				row.add(ct.getTenNgyenLieu());
				row.add(String.valueOf(ct.getSoLuong()));
				row.add(String.valueOf(ct.getDonGia()));
				row.add(String.valueOf(ct.getThanhTien()));
				modelCTPNH.addRow(row);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	public void reset() {
		loadCTPN();
		loadPNH();
		txMaPNH.setText("");
		cbMaNhanVien.setSelectedIndex(0);
		cbMaNhaCungCap.setSelectedIndex(0);
		txNgayNhap.setText("");
		txTongCong.setText("");
		txMaPhieuNhap.setText("");
		txMaNguyenLieu.setText("");
		txTenNguyenLieu.setText("");
		txSoLuong.setText("");
		txDonGia.setText("");
		btThemPN.setEnabled(true);
	}
	private void loadtxTongCong() {
		double tongCong = 0;
		for(int i=0;i<tbCTPNH.getRowCount();i++) {
			if(tbCTPNH.getValueAt(i, 0).equals(ma)) {
			tongCong+= Float.parseFloat(tbCTPNH.getValueAt(i, 5).toString());
			}
		}
		txTongCong.setText(tongCong +"");
		
	}
	private static void loadPNH() {
		PhieuNhapHangBUS pnb = new PhieuNhapHangBUS();
		try {
			pnb.doc();
			modelPNH.setRowCount(0);
			for(PhieuNhapHangDTO pnh : PhieuNhapHangBUS.dspn) {
				Vector<String> row = new Vector<String>();
				row.add(pnh.getMaPhieuNhap());
				row.add(pnh.getMaNhanVien());
				row.add(pnh.getMaNhaCungCap());
				row.add(pnh.getNgayNhap());
				row.add(String.valueOf(pnh.getTongCong()));
				modelPNH.addRow(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean kiemtrama(String a) {
		int i= tbPNH.getSelectedRow();
		for(i=0;i<tbPNH.getRowCount();i++) {
			if(tbPNH.getValueAt(i, 0).equals(a)) {
				return true; 
			}
		}
		return false;
	}
	  public ArrayList<NguyenLieuDTO> DSNL = new ArrayList<NguyenLieuDTO>();
	public boolean kiemtranl(String a) {
		DSNL =null;
		NguyenLieuBUS nlb = new  NguyenLieuBUS();
		DSNL = nlb.LoadNL();
		for(NguyenLieuDTO nl:DSNL) {
			if(nl.getMaNguyenLieu().equals(a)) {
				return true;
			}
		}
		return false;
	}
	
    public static void main(String[] args) {
    	new DS_PNH();

    }
} 

