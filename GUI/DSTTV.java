package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.border.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import BUS.*;
import DTO.*;
import java.util.regex.Pattern;
public class DSTTV {
    JFrame frame = new JFrame();
    
    JTextField txtMaTTV, txtTenTV, txtSDT, txtDiem, txtUD;
    JLabel lbMaTTV, lbTenTV, lbSDT, lbD, lbUD;
    DefaultTableModel modelTTV;
    
    JButton btnXoa, btnCapNhat, btnThem, btThoat,btnexit, btnReset;
    JTextField txtTimKiemTTV;
    JLabel lbTimKiemTTV, lbNoValid;
    
    
    JTable tblTTV;
    JPanel pTTV, pBG;
    TheThanhVienBUS bus=new TheThanhVienBUS();
    public DSTTV(){
    	initComponents();
    	if(TheThanhVienBUS.DSTTV==null) {
    		bus.docDSTTV();
    	}
    	 showDuLieu(TheThanhVienBUS.DSTTV);
    }
    private void initComponents() {
        frame.setSize(1250,500);
        frame.setLayout(null);
        frame.setUndecorated(true);

        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pTTV = new JPanel();
        pTTV.setBackground(new Color(155, 207, 243));
        pTTV.setLayout(null);
        pTTV.setBounds(0,0,1250,100);
        pTTV.setBorder(BorderFactory.createTitledBorder(blackBorder, "Thẻ thành viên  ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pBG = new JPanel();
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,1250,500);
        

        lbMaTTV = new JLabel("Mã thẻ thành viên");
        lbTenTV = new JLabel("Tên thành viên");
        lbSDT = new JLabel("Số điện thoại");
        lbD = new JLabel("Điểm");
//        lbUD = new JLabel("Ưa đãi");
        txtTimKiemTTV = new JTextField();
        lbTimKiemTTV = new JLabel("Tìm Kiếm");
        lbTimKiemTTV.setFont(new Font("Arial", Font.ITALIC, 16));
        lbNoValid=new JLabel();
        lbNoValid.setFont(new Font("Arial", Font.ITALIC, 15));
        lbNoValid.setForeground(Color.red);
        txtMaTTV = new JTextField();
        txtTenTV = new JTextField();
        txtSDT = new JTextField();
        txtDiem = new JTextField();
        txtDiem.setEditable(false);
        lbMaTTV.setBounds(100,20,120,20);
        txtMaTTV.setBounds(220,20,120,20);
        lbTenTV.setBounds(380,20,100,20);
        txtTenTV.setBounds(480,20,120,20);
        lbSDT.setBounds(640,20,100,20);
        txtSDT.setBounds(740,20,120,20);
        lbD.setBounds(100,60,120,20);
        txtDiem.setBounds(220,60,120,20);
        lbTimKiemTTV.setBounds(20, 120, 120, 20);
        txtTimKiemTTV.setBounds(100, 120, 200, 20);
        lbNoValid.setBounds(100, 150, 200, 20);
        pTTV.add(lbMaTTV);
        pTTV.add(txtMaTTV);
        pTTV.add(lbTenTV);
        pTTV.add(txtTenTV);
        pTTV.add(lbSDT);
        pTTV.add(txtSDT);
        pTTV.add(lbD);
        pTTV.add(txtDiem);
        pBG.add(lbTimKiemTTV);
        pBG.add(txtTimKiemTTV);
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
        btThoat = new JButton("<");
        btThoat.setBorder(BorderFactory.createEmptyBorder());
        btThoat.setBackground(Color.BLUE);
        btThoat.setForeground(Color.WHITE);
        btnThem.setBounds(980,20,100,20);
        btnCapNhat.setBounds(1100,20,100,20);
        btnXoa.setBounds(980,50,100,20);
        btnReset.setBounds(1100,50,100,20);
        btThoat.setBounds(20,20,20,20);
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
        pTTV.add(btnThem);
        pTTV.add(btnCapNhat);
        pTTV.add(btnXoa);
        pTTV.add(btThoat);
        pTTV.add(btnReset);
        pBG.add(pTTV);
        
        modelTTV = new DefaultTableModel();
        tblTTV = new JTable();
        JScrollPane jcTTV = new JScrollPane();
        jcTTV.setViewportView(tblTTV);
        modelTTV.addColumn("Mã thẻ thành viên");
        modelTTV.addColumn("Tên thành viên");
        modelTTV.addColumn("Số điện thoại");
        modelTTV.addColumn("Điểm");
        jcTTV.setBounds(20,180,1200,300);
        pBG.add(jcTTV);
        tblTTV.setModel(modelTTV);
        
        frame.add(pBG);
    
        btThoat.addActionListener(new ActionListener() {
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
        
        tblTTV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTVMouseClicked(evt);
            }
        });
        
        txtMaTTV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txtTenTV.requestFocus();
                }
            }
        }); 
        txtTenTV.addKeyListener(new KeyAdapter() {
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
                    txtDiem.requestFocus();
                }
            }
        }); 
        txtDiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txtUD.requestFocus();
                }
            }
        }); 
//        txtUD.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode() == KeyEvent.VK_ENTER){
//                    btnThem.requestFocus();
//                }
//            }
//        }); 
        txtTimKiemTTV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
            	lbNoValid.setText("");
            	ArrayList<TheThanhVienDTO> temp=new ArrayList<>();
                temp=bus.timkiem(txtTimKiemTTV.getText());
                if(temp.size()>0) showDuLieu(temp);
                else lbNoValid.setText("Không tìm thấy dữ liệu ");            
        	}
            public void keyPressed(KeyEvent e) {
            	if(e.getKeyCode()==KeyEvent.VK_ENTER){
                  if(txtTimKiemTTV.getText().equals(""))
                  {
                      JOptionPane.showMessageDialog(frame, "Vui lòng nhập dữ liệu tìm kiếm!");
                      txtTimKiemTTV.requestFocus();
                  }
            	}
            }
        });
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
      
    private void showDuLieu(ArrayList<TheThanhVienDTO> arr){
        modelTTV.setRowCount(0);
        arr.forEach((tv) -> {
            modelTTV.addRow(new Object[]{
                tv.getMaTTV(),
                tv.getTenTV(),
                tv.getSDT(),
                tv.getDiemTichLuy()
            });
        });
    }
    private void reset(){
        txtMaTTV.setText("");
        txtTenTV.setText("");
        txtSDT.setText("");
        txtMaTTV.setEditable(true);
        txtMaTTV.setBackground(Color.WHITE);
        tblTTV.clearSelection();
        showDuLieu(TheThanhVienBUS.DSTTV);
        btnThem.setEnabled(true);
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
        txtDiem.setText("");
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {                                        
        StringBuilder sb=new StringBuilder();
        if(txtMaTTV.getText().equals("")){
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập Mã thành viên","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtMaTTV.requestFocus();
            return;        
        }
    	else 
        {
            for(TheThanhVienDTO ttv: TheThanhVienBUS.DSTTV){
                if(txtMaTTV.getText().equals(String.valueOf(ttv.getMaTTV()))){
                    JOptionPane.showMessageDialog(frame, "Mã thành viên đã tồn tại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    return;
                } 
            }
        }
        if(txtTenTV.getText().equals("")) {
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập Tên thành viên ","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtTenTV.requestFocus();
            return;
        } else if(!Pattern.matches("\\D+", txtTenTV.getText())) {  // tên thành viên k chứa kí tự số
            sb.append("Tên thành viên không hợp lệ\n");
    	}
        if(txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập Số điện thoại ","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return;
        } 
        else if(!Pattern.matches("^0{1}[1-9]{1}[0-9]{8}$", txtSDT.getText())) {
    			sb.append("Số điện thoại không hợp lệ\n");
    	}
        if(sb.length()>0) {
    		JOptionPane.showMessageDialog(frame, sb.toString(),"Thông báo",JOptionPane.ERROR_MESSAGE);
    		return;
    	}

        TheThanhVienDTO tv=new TheThanhVienDTO(
                txtMaTTV.getText(),
                txtTenTV.getText(),
                txtSDT.getText()
        );
        if(bus.themTTV(tv)){
            modelTTV.addRow(new Object[]{
                    tv.getMaTTV(),
                    tv.getTenTV(),
                    tv.getSDT(),
                    tv.getDiemTichLuy()
            });
            JOptionPane.showMessageDialog(frame,"Đã thêm thành viên mới");
        } else JOptionPane.showMessageDialog(frame, "Thêm không thành công","Thông báo",
                JOptionPane.ERROR_MESSAGE);
        reset();
    }                                    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int row=tblTTV.getSelectedRow();
        if (row >= 0) {
            int option = JOptionPane.showConfirmDialog(frame, "Bạn chắc chắn muốn xóa hay không?");
            if (option == JOptionPane.YES_OPTION) {
	            TheThanhVienDTO tv=new TheThanhVienDTO();
	            tv= TheThanhVienBUS.DSTTV.get(row);
	            if(bus.xoaTTV(row, tv.getMaTTV())){
                        modelTTV.removeRow(row);
                        JOptionPane.showMessageDialog(frame,"Đã xóa thành công");
                    }else JOptionPane.showMessageDialog(frame, "Xóa không thành công","Thông báo",JOptionPane.ERROR_MESSAGE);
            } else return;
        }
        reset();
    }      
    private void tblTTVMouseClicked(java.awt.event.MouseEvent evt) {                                         
        ListSelectionModel lsm=tblTTV.getSelectionModel();
        lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        int row = tblTTV.getSelectedRow();
        if (row >= 0) {
        	TheThanhVienDTO tv=new TheThanhVienDTO();
        	tv=TheThanhVienBUS.DSTTV.get(row);
        	txtMaTTV.setText(tv.getMaTTV());
            txtTenTV.setText(tv.getTenTV());
            txtSDT.setText(tv.getSDT());
            txtDiem.setText(String.valueOf(tv.getDiemTichLuy()));
            txtMaTTV.setEditable(false);
            txtMaTTV.setBackground(new Color(229, 228, 228));
            btnThem.setEnabled(false); 
            btnCapNhat.setEnabled(true);
            btnXoa.setEnabled(true);
        }
    }         
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
        reset();
    }
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {                                       
        int row=tblTTV.getSelectedRow();
        StringBuilder sb=new StringBuilder();
        if(txtTenTV.getText().equals("")) {
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập Tên thành viên ","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtTenTV.requestFocus();
            return;
        } else if(!Pattern.matches("\\D+", txtTenTV.getText())) {  // tên thành viên k chứa kí tự số
            sb.append("Tên thành viên không hợp lệ\n");
    	}
        if(txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(frame,"Vui lòng nhập Số điện thoại ","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return;
        }else if(!Pattern.matches("^0{1}[1-9]{1}[0-9]{8}$", txtSDT.getText())) {
    			sb.append("Số điện thoại không hợp lệ\n");
    	}
        if(sb.length()>0) {
    		JOptionPane.showMessageDialog(frame, sb.toString(),"Thông báo",JOptionPane.ERROR_MESSAGE);
    		return;
    	}
       TheThanhVienDTO tv=new TheThanhVienDTO(
    		    txtMaTTV.getText(),
    		    txtTenTV.getText(),
                txtSDT.getText(),
                Double.parseDouble(txtDiem.getText())
       );
        if(bus.suaTTV(row, tv)){
            modelTTV.setValueAt(tv.getTenTV(), row, 1);
            modelTTV.setValueAt(tv.getSDT(), row, 2);
            JOptionPane.showMessageDialog(frame,"Đã cập nhật thành công");
        }else JOptionPane.showMessageDialog(frame, "Cập nhật không thành công","Thông báo",JOptionPane.ERROR_MESSAGE);
        reset();
    }
     public static void main(String[] args){
        new DSTTV();
    }  
    	
}

