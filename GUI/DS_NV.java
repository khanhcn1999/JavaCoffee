package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import BUS.*;
import DTO.*;

public class DS_NV {
    JFrame frame = new JFrame();
    
    JTextField txMaNV, txHoNV, txTenNV, txGm, txSDT, txCV;
    JLabel lbMaNV, lbHoNV, lbTenNV, lbGm, lbSDT, lbGT, lbCV;
    DefaultTableModel modelNV;
    JRadioButton rbNam, rbNu;
    ButtonGroup bg;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    JTextField txTimKiemNV;
    JLabel lbTimKiemNV;
    
    JComboBox cb;
    
    JTable tblNV;
    JPanel pNV, pBG;
    
    public DS_NV(){
        frame.setSize(1250,500);
        frame.setLayout(null);
        frame.setUndecorated(true);

        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pNV = new JPanel();
        pNV.setBackground(new Color(155, 207, 243));
        pNV.setLayout(null);
        pNV.setBounds(0,0,1250,100);
        pNV.setBorder(BorderFactory.createTitledBorder(blackBorder, "  Nhân Viên  ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pBG = new JPanel();
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,1250,500);
        
        String c[] = {"Mã nhân viên", "Tên nhân viên", "Giới tính", "Chức vụ"};
        cb = new JComboBox(c);
        cb.setBounds(300,120,140,20);
        pBG.add(cb);
        
        txMaNV = new JTextField();
        txHoNV = new JTextField();
        txTenNV = new JTextField();
        txGm = new JTextField();
        txSDT = new JTextField();
        txCV = new JTextField();
        lbMaNV = new JLabel("Mã nhân viên");
        lbHoNV = new JLabel("Họ nhân viên");
        lbTenNV = new JLabel("Tên nhân viên");
        lbGm = new JLabel("Gmail");
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
        txTimKiemNV = new JTextField();
        lbTimKiemNV = new JLabel("Tìm Kiếm");
        lbTimKiemNV.setFont(new Font("Arial", Font.ITALIC, 16));
        lbMaNV.setBounds(100,20,80,20);
        txMaNV.setBounds(180,20,100,20);
        lbHoNV.setBounds(320,20,80,20);
        txHoNV.setBounds(400,20,100,20);
        lbTenNV.setBounds(540,20,100,20);
        txTenNV.setBounds(640,20,100,20);
        lbGm.setBounds(780,20,80,20);
        txGm.setBounds(840,20,100,20);
        lbSDT.setBounds(100,60,100,20);
        txSDT.setBounds(180,60,100,20);
        lbGT.setBounds(540,60,100,20);
        rbNam.setBounds(640,60,50,20);
        rbNu.setBounds(700,60,50,20);
        lbCV.setBounds(320,60,80,20);
        txCV.setBounds(400,60,100,20);
        lbTimKiemNV.setBounds(20, 120, 120, 20);
        txTimKiemNV.setBounds(100, 120, 200, 20);
        pNV.add(lbMaNV);
        pNV.add(txMaNV);
        pNV.add(lbHoNV);
        pNV.add(txHoNV);
        pNV.add(lbTenNV);
        pNV.add(txTenNV);
        pNV.add(lbGm);
        pNV.add(txGm);
        pNV.add(lbSDT);
        pNV.add(txSDT);
        pNV.add(lbGT);
        pNV.add(rbNam);
        pNV.add(rbNu);
        pNV.add(lbCV);
        pNV.add(txCV);
        
        pBG.add(lbTimKiemNV);
        pBG.add(txTimKiemNV);
        
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
        btThem.setBounds(980,20,100,20);
        btCapNhat.setBounds(1100,20,100,20);
        btXoa.setBounds(1040,60,100,20);
        btThoat.setBounds(20,20,20,20);
        pNV.add(btThem);
        pNV.add(btCapNhat);
        pNV.add(btXoa);
        pNV.add(btThoat);
        pBG.add(pNV);
        
        modelNV = new DefaultTableModel();
        tblNV = new JTable();
        JScrollPane jcNV = new JScrollPane();
        jcNV.setViewportView(tblNV);
        modelNV.addColumn("Mã nhân viên");
        modelNV.addColumn("Họ nhân viên");
        modelNV.addColumn("Tên nhân viên");
        modelNV.addColumn("Gmail");
        modelNV.addColumn("Số điện thoại");
        modelNV.addColumn("Giới tính");
        modelNV.addColumn("Chức vụ");
        modelNV.addColumn("TT làm việc");
        jcNV.setBounds(20,180,1200,300);
        pBG.add(jcNV);
        tblNV.setModel(modelNV);
        
        frame.add(pBG);
        
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new MainFrame();
                    frame.hide();
            }
        });
        txMaNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txHoNV.requestFocus();
                }
            }
        }); 
        txHoNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txTenNV.requestFocus();
                }
            }
        }); 
        txTenNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txGm.requestFocus();
                }
            }
        }); 
        txGm.addKeyListener(new KeyAdapter() {
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
                    txCV.requestFocus();
                }
            }
        }); 
        txCV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btThem.doClick();
                }
            }
        }); 
        
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
