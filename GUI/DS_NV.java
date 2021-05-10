package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.border.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import BUS.*;
import DTO.*;

public class DS_NV {
    JFrame frame = new JFrame();
    
    JTextField txtMaNV, txtHoNV, txtTenNV, txtEmailNV, txtSDT, txtChucVu;
    JLabel lbMaNV, lbHoNV, lbtnenNV, lbGm, lbSDT, lbGT, lbCV;
    DefaultTableModel modelNV;
    JRadioButton rbNam, rbNu;
    ButtonGroup bg;
    NhanVienBUS bus=new NhanVienBUS();
    JButton btnXoa, btnCapNhat, btnThem, btnThoat, btnexit, btnReset;
    JTextField txtTimKiemNV;
    JLabel lbTimKiemNV, lbNoValid;
    
    
    JTable tblNV;
    JPanel pNV, pBG;
    
    public DS_NV(){
    	initComponents();
    	if(NhanVienBUS.DSNV==null) bus.docDSNV();
        showDuLieu(NhanVienBUS.DSNV);
    }
    private void initComponents() {
    	frame.setSize(1250,500);
        frame.setLayout(null);
        frame.setUndecorated(true);
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pNV = new JPanel();
        pNV.setBackground(new Color(155, 207, 243));
        pNV.setLayout(null);
        pNV.setBounds(0,0,1250,100);
        pNV.setBorder(BorderFactory.createTitledBorder(blackBorder, " Nhân viên  ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pBG = new JPanel();
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,1250,500);
                
        txtMaNV = new JTextField();
        txtHoNV = new JTextField();
        txtTenNV = new JTextField();
        txtEmailNV = new JTextField();
        txtSDT = new JTextField();
        txtChucVu = new JTextField();
        lbMaNV = new JLabel("Mã nhân viên");
        lbHoNV = new JLabel("Họ nhân viên");
        lbtnenNV = new JLabel("Tên nhân viên");
        lbGm = new JLabel("Email");
        lbSDT = new JLabel("Số điện thoại");
        lbGT = new JLabel("Giới tính");
        lbCV = new JLabel("Chức vụ");
        rbNam = new JRadioButton("Nam");
        rbNam.setBackground(new Color(155, 207, 243));
        rbNu = new JRadioButton("Nữ");
        rbNu.setBackground(new Color(155, 207, 243));
        bg = new ButtonGroup();
        bg.add(rbNam);
        bg.add(rbNu);
        txtTimKiemNV = new JTextField();
        lbTimKiemNV = new JLabel("Tìm kiếm");
        lbTimKiemNV.setFont(new Font("Arial", Font.ITALIC, 16));
        lbNoValid=new JLabel();
        lbNoValid.setFont(new Font("Arial", Font.ITALIC, 15));
        lbNoValid.setForeground(Color.red);
        lbMaNV.setBounds(100,20,80,20);
        txtMaNV.setBounds(180,20,100,20);
        lbHoNV.setBounds(320,20,80,20);
        txtHoNV.setBounds(400,20,100,20);
        lbtnenNV.setBounds(540,20,100,20);
        txtTenNV.setBounds(640,20,100,20);
        lbGm.setBounds(780,20,80,20);
        txtEmailNV.setBounds(840,20,100,20);
        lbSDT.setBounds(100,60,100,20);
        txtSDT.setBounds(180,60,100,20);
        lbGT.setBounds(540,60,100,20);
        rbNam.setBounds(640,60,50,20);
        rbNu.setBounds(700,60,50,20);
        lbCV.setBounds(320,60,80,20);
        txtChucVu.setBounds(400,60,100,20);
        lbTimKiemNV.setBounds(20, 120, 120, 20);
        txtTimKiemNV.setBounds(100, 120, 200, 20);
        lbNoValid.setBounds(100, 150, 200, 20);
        
        pNV.add(lbMaNV);
        pNV.add(txtMaNV);
        pNV.add(lbHoNV);
        pNV.add(txtHoNV);
        pNV.add(lbtnenNV);
        pNV.add(txtTenNV);
        pNV.add(lbGm);
        pNV.add(txtEmailNV);
        pNV.add(lbSDT);
        pNV.add(txtSDT);
        pNV.add(lbGT);
        pNV.add(rbNam);
        pNV.add(rbNu);
        pNV.add(lbCV);
        pNV.add(txtChucVu);
        
        pBG.add(lbTimKiemNV);
        pBG.add(txtTimKiemNV);
        pBG.add(lbNoValid);
        
        btnReset = new JButton("Reset");
        btnReset.setBorder(BorderFactory.createEmptyBorder());
        btnReset.setBackground(Color.BLUE);
        btnReset.setForeground(Color.WHITE);
        btnXoa = new JButton("Xóa");
        btnXoa.setBorder(BorderFactory.createEmptyBorder());
        btnXoa.setBackground(Color.BLUE);
        btnXoa.setForeground(Color.WHITE);
        btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setBorder(BorderFactory.createEmptyBorder());
        btnCapNhat.setBackground(Color.BLUE);
        btnCapNhat.setForeground(Color.WHITE);
        btnThem = new JButton("Thêm");
        btnThem.setBorder(BorderFactory.createEmptyBorder());
        btnThem.setBackground(Color.BLUE);
        btnThem.setForeground(Color.WHITE);
        btnThoat = new JButton("<");
        btnThoat.setBorder(BorderFactory.createEmptyBorder());
        btnThoat.setBackground(Color.BLUE);
        btnThoat.setForeground(Color.WHITE);
        btnThem.setBounds(980,20,100,20);
        btnCapNhat.setBounds(1100,20,100,20);
        btnXoa.setBounds(980,50,100,20);
        btnReset.setBounds(1100,50,100,20);
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
        
        btnThoat.setBounds(20,20,20,20);
        pNV.add(btnThem);
        pNV.add(btnCapNhat);
        pNV.add(btnXoa);
        pNV.add(btnThoat);
        pNV.add(btnReset);
        pBG.add(pNV);
        
        modelNV = new DefaultTableModel();
        tblNV = new JTable();
        JScrollPane jcNV = new JScrollPane();
        jcNV.setViewportView(tblNV);
        modelNV.addColumn("Mã nhân viên");
        modelNV.addColumn("Họ tên nhân viên");
        modelNV.addColumn("Gmail");
        modelNV.addColumn("Số điện thoại");
        modelNV.addColumn("Giới tính");
        modelNV.addColumn("Chức vụ");
        modelNV.addColumn("TT làm việc");
        jcNV.setBounds(20,180,1200,300);
        pBG.add(jcNV);
        tblNV.setModel(modelNV);
        
        frame.add(pBG);
        
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new MainFrame();
                    frame.hide();
            }
        });
        
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        
        txtMaNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txtHoNV.requestFocus();
                }
            }
        }); 
        txtHoNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txtTenNV.requestFocus();
                }
            }
        }); 
        txtTenNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txtEmailNV.requestFocus();
                }
            }
        }); 
        txtEmailNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                	
                    txtSDT.requestFocus();
                }
            }
        }); 
        txtSDT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txtChucVu.requestFocus();
                }
            }
        }); 
        txtChucVu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnThem.doClick();
                }
            }
        }); 
        
        txtTimKiemNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
            	lbNoValid.setText("");
            	ArrayList<NhanVienDTO> temp=new ArrayList<>();
                temp=bus.timKiem(txtTimKiemNV.getText());
                if(temp.size()>0) showDuLieu(temp);
                else lbNoValid.setText("Không tìm thấy dữ liệu ");            
        	}
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode()==KeyEvent.VK_ENTER){
                  if(txtTimKiemNV.getText().equals(""))
                  {
                      JOptionPane.showMessageDialog(frame, "Vui lòng nhập dữ liệu tìm kiếm!");
                      txtTimKiemNV.requestFocus();
                  }
            	}
            }
        });
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    private void showDuLieu(ArrayList<NhanVienDTO> arr){
        modelNV.setRowCount(0);
        arr.forEach((nv) -> {
            modelNV.addRow(new Object[]{
                nv.getMaNV(),
                nv.getHoNV()+" "+nv.getTenNv(),
                nv.getEmailNV(),
                nv.getSdtNV(),
                nv.getGtinhNV(),
                nv.getChucVu(),
                String.valueOf(nv.getTTLamviec())
            });
        });
    }
    private void reset(){
        txtMaNV.setText("");
        txtHoNV.setText("");
        txtTenNV.setText("");
        txtEmailNV.setText("");
        txtSDT.setText("");
        txtChucVu.setText("");
        bg.clearSelection();
        txtMaNV.setEditable(true);
        txtMaNV.setBackground(Color.WHITE);
        tblNV.clearSelection();
        showDuLieu(NhanVienBUS.DSNV);
        btnThem.setEnabled(true);
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {                                        
        StringBuilder sb=new StringBuilder();
        
    	if(txtMaNV.getText().equals("")){
            sb.append("*Mã nhân viên không được để trống\n");
        }
    	else 
        {
        	for(NhanVienDTO nv: NhanVienBUS.DSNV){
	            if(txtMaNV.getText().equals(String.valueOf(nv.getMaNV()))){
	                JOptionPane.showMessageDialog(frame, "Mã nhân viên đã tồn tại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
	                return;
	            } 
        	}
        }
    	// tên nhân viên k chứa kí tự số
    	if(txtTenNV.getText().equals("")) {
            sb.append("*Tên nhân viên không được để trống\n");
    	}
    	else if(!Pattern.matches("\\D+", txtTenNV.getText())) {
    		sb.append("Tên nhân viên không hợp lệ\n");
    	}
    	    	
    	//kiểm tra định dạng email
    	/*Bắt đầu bằng ký tự a-z hoặc A-Z – (^[a-zA-Z]+).
        Email không được chứa các ký tự đặt biệt – ([a-zA-Z0-9]*)
        @ xuất hiện 1 lần trong sau nó là các chữ cái, ví dụ @gmail, @yahoo etc – (@{1}[a-zA-Z]+).
        Email kết thúc với .com – mail.com$
        */
    	if(txtEmailNV.getText().equals("")) {
    		sb.append("*Email không được để trống\n");
    	}
    	else if(!Pattern.matches("^[a-zA-Z]+[a-zA-Z0-9]*@{1}[a-zA-Z]+mail.com$", txtEmailNV.getText())) {
    		sb.append("Email không hợp lệ\n");
    	}
    	
    	//kiểm tra SDT
    	// số điện thoại có 10 chữ số, bắt đầu bằng số 0. Số tiếp theo không được là số 0.
    	if(txtSDT.getText().equals("")) {
    		sb.append("*Số điện thoại không được để trống\n");
    	}
    	else if(!Pattern.matches("^0{1}[1-9]{1}[0-9]{8}$", txtSDT.getText())) {
    			sb.append("Số điện thoại không hợp lệ\n");
    	}
    	if(txtChucVu.getText().equals("")) {
    		sb.append("*chức vụ không được để trống\n");
    	}
    	if(sb.length()>0) {
    		JOptionPane.showMessageDialog(frame, sb.toString(),"Thông báo",JOptionPane.ERROR_MESSAGE);
    		return;
    	}
        String gt="";
        gt=rbNam.isSelected()?"Nam":"Nữ";
        NhanVienDTO nv=new NhanVienDTO(
                txtMaNV.getText(),
                txtHoNV.getText(),
                txtTenNV.getText(),
                txtEmailNV.getText(),
                txtSDT.getText(),
                gt, 
                txtChucVu.getText()
        );
        
        if(bus.themNV(nv)){
            modelNV.addRow(new Object[]{
                nv.getMaNV(),
                nv.getHoNV()+" "+nv.getTenNv(),
                nv.getEmailNV(),
                nv.getSdtNV(),
                nv.getGtinhNV(), 
                nv.getChucVu(),
                "true"
            });
            JOptionPane.showMessageDialog(frame,"Đã thêm nhân viên mới");
        } else JOptionPane.showMessageDialog(frame, "Thêm không thành công","Thông báo",
                JOptionPane.ERROR_MESSAGE);
        reset();
    }                                    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int row=tblNV.getSelectedRow();
        if (row >= 0) {
            NhanVienDTO nv=new NhanVienDTO();
            nv= NhanVienBUS.DSNV.get(row);
            if(nv.getTTLamviec()==(true)){
                if(bus.setTTLamviec(nv.getMaNV())){
                    tblNV.setValueAt("false", row, 6 );
                    JOptionPane.showMessageDialog(frame,"Đã xóa thành công");
                }else JOptionPane.showMessageDialog(frame, "Xóa không thành công","Thông báo",JOptionPane.ERROR_MESSAGE);
            } else return;
        }
    }      
    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {                                         
        ListSelectionModel lsm=tblNV.getSelectionModel();
        lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int row = tblNV.getSelectedRow();
        if (row >= 0) {
        	NhanVienDTO nv=new NhanVienDTO();
        	nv=bus.DSNV.get(row);
        	txtMaNV.setText(nv.getMaNV());
            txtHoNV.setText(nv.getHoNV());
            txtTenNV.setText(nv.getTenNv());
            txtEmailNV.setText(nv.getEmailNV());
            txtSDT.setText(nv.getSdtNV());
            txtChucVu.setText(nv.getChucVu());
            String g=String.valueOf(nv.getGtinhNV());
            if ("Nam".equals(g)) rbNam.setSelected(true);
            else if("Nữ".equals(g)) rbNu.setSelected(true);
            txtMaNV.setEditable(false);
            txtMaNV.setBackground(new Color(229, 228, 228));
            btnThem.setEnabled(false); 
            btnCapNhat.setEnabled(true);
            btnXoa.setEnabled(true);
        }
    }         
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
        reset();
    }
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {                                       
        String gt="";
        gt=rbNam.isSelected()?"Nam":"Nữ";
        int row=tblNV.getSelectedRow();
        StringBuilder sb=new StringBuilder();
        if(txtTenNV.getText().equals("")) {
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập Tên thành viên ","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtTenNV.requestFocus();
            return;
        } else if(!Pattern.matches("\\D+", txtTenNV.getText())) {  // tên thành viên k chứa kí tự số
            sb.append("Tên thành viên không hợp lệ\n");
    	}
        if(txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập Số điện thoại ","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return;
        }else if(!Pattern.matches("^0{1}[1-9]{1}[0-9]{8}$", txtSDT.getText())) {
    			sb.append("Số điện thoại không hợp lệ\n");
    	}
        if(txtEmailNV.getText().equals("")) {
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập Email","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return;
    	}
    	else if(!Pattern.matches("^[a-zA-Z]+[a-zA-Z0-9]*@{1}[a-zA-Z]+mail.com$", txtEmailNV.getText())) {
    		sb.append("Email không hợp lệ\n");
    	}
        if(sb.length()>0) {
    		JOptionPane.showMessageDialog(frame, sb.toString(),"Thông báo",JOptionPane.ERROR_MESSAGE);
    		return;
    	}
        NhanVienDTO nv=new NhanVienDTO(txtMaNV.getText(),
                txtHoNV.getText(),
                txtTenNV.getText(),
                txtEmailNV.getText(),
                txtSDT.getText(),
                gt, 
                txtChucVu.getText());
        bus.suaNV(row, nv);
        modelNV.setValueAt(nv.getHoNV()+" "+nv.getTenNv(), row, 1);
        modelNV.setValueAt(nv.getEmailNV(), row, 2);
        modelNV.setValueAt(nv.getSdtNV(), row, 3);
        modelNV.setValueAt(nv.getGtinhNV(), row, 4);
        modelNV.setValueAt(nv.getChucVu(), row, 5);
        modelNV.setValueAt(nv.getTTLamviec(), row, 6);
        reset();
    }
    
    public static void main(String[] args){
        new DS_NV();
    }
}
