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

public class DS_NCC {
    JFrame frame = new JFrame();
    
    JTextField txMaNCC, txTenNCC, txGm, txSDT, txDiaChi;
    JLabel lbMaNCC, lbTenNCC, lbGm, lbSDT, lbDiaChi;
    DefaultTableModel modelNCC;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    JTextField txTimKiemNCC;
    JLabel lbTimKiemNCC;
    
    JComboBox cb;
    
    JTable tblNCC;
    JPanel pNCC, pBG;
    public DS_NCC(){
        frame.setSize(1250,500);
        frame.setLayout(null);
        frame.setUndecorated(true);

        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pNCC = new JPanel();
        pNCC.setBackground(new Color(155, 207, 243));
        pNCC.setLayout(null);
        pNCC.setBounds(0,0,1250,100);
        pNCC.setBorder(BorderFactory.createTitledBorder(blackBorder, "  Nhà Cung Cấp  ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pBG = new JPanel();
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,1250,500);
        
        String c[] = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại"};
        cb = new JComboBox(c);
        cb.setBounds(300,120,140,20);
        pBG.add(cb);
        
        txMaNCC = new JTextField();
        txTenNCC = new JTextField();
        txGm = new JTextField();
        txSDT = new JTextField();
        txDiaChi = new JTextField();
        lbMaNCC = new JLabel("Mã nhà cung cấp");
        lbTenNCC = new JLabel("Tên nhà cung cấp");
        lbGm = new JLabel("Gmail");
        lbSDT = new JLabel("Số điện thoại");
        lbDiaChi = new JLabel("Địa chỉ");
        txTimKiemNCC = new JTextField();
        lbTimKiemNCC = new JLabel("Tìm Kiếm");
        lbTimKiemNCC.setFont(new Font("Arial", Font.ITALIC, 16));
        lbMaNCC.setBounds(100,20,100,20);
        txMaNCC.setBounds(200,20,120,20);
        lbTenNCC.setBounds(370,20,120,20);
        txTenNCC.setBounds(490,20,120,20);
        lbGm.setBounds(660,20,80,20);
        txGm.setBounds(700,20,120,20);
        lbSDT.setBounds(100,60,100,20);
        txSDT.setBounds(200,60,120,20);
        lbDiaChi.setBounds(370,60,120,20);
        txDiaChi.setBounds(490,60,120,20);
        lbTimKiemNCC.setBounds(20, 120, 120, 20);
        txTimKiemNCC.setBounds(100, 120, 200, 20);
        pNCC.add(lbMaNCC);
        pNCC.add(txMaNCC);
        pNCC.add(lbTenNCC);
        pNCC.add(txTenNCC);
        pNCC.add(lbGm);
        pNCC.add(txGm);
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
        btThem.setBounds(980,20,100,20);
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
        modelNCC.addColumn("Gmail");
        modelNCC.addColumn("Số điện thoại");
        modelNCC.addColumn("Địa chỉ");
        jcNCC.setBounds(20,180,1200,300);
        pBG.add(jcNCC);
        tblNCC.setModel(modelNCC);
        
        frame.add(pBG);
        
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new MainFrame();
                    frame.hide();
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
        
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
