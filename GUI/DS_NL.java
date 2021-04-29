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

public class DS_NL {
    JFrame frame = new JFrame();
    
    JTextField txMaNL, txTenNL, txSoLuong;
    JLabel lbMaNL, lbTenNL, lbSoLuong;
    DefaultTableModel modelNL;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    
    JComboBox cb;
    
    JTable tblNL;
    JPanel pNL, pBG;
    public DS_NL(){
        frame.setSize(800,500);
        frame.setLayout(null);
        frame.setUndecorated(true);
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pNL = new JPanel();
        pNL.setBackground(new Color(155, 207, 243));
        pNL.setLayout(null);
        pNL.setBounds(0,0,800,100);
        pNL.setBorder(BorderFactory.createTitledBorder(blackBorder, "  Nguyên Liệu  ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pBG = new JPanel();
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,800,500);
        
        txMaNL = new JTextField();
        txTenNL = new JTextField(); 
        txSoLuong = new JTextField();
        lbMaNL = new JLabel("Mã nguyên liệu");
        lbTenNL = new JLabel("Tên nguyên liệu"); 
        lbSoLuong = new JLabel("Số lượng");
        lbMaNL.setBounds(80,20,100,20);
        txMaNL.setBounds(180,20,120,20);
        lbTenNL.setBounds(320,20,100,20);
        txTenNL.setBounds(420,20,120,20);
        lbSoLuong.setBounds(80,60,80,20);
        txSoLuong.setBounds(180,60,120,20);
        pNL.add(lbMaNL);
        pNL.add(txMaNL);
        pNL.add(lbTenNL);
        pNL.add(txTenNL);
        pNL.add(lbSoLuong);
        pNL.add(txSoLuong);
        
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
        btThem.setBounds(600,20,80,20);
        btCapNhat.setBounds(700,20,80,20);
        btXoa.setBounds(650,60,80,20);
        btThoat.setBounds(20,20,20,20);
        pNL.add(btThem);
        pNL.add(btCapNhat);
        pNL.add(btXoa);
        pNL.add(btThoat);
        pBG.add(pNL);
        
        modelNL = new DefaultTableModel();
        tblNL = new JTable();
        JScrollPane jcNL = new JScrollPane();
        jcNL.setViewportView(tblNL);
        modelNL.addColumn("Mã nguyên liệu");
        modelNL.addColumn("Tên nguyên liệu");
        modelNL.addColumn("Số lượng");
        jcNL.setBounds(20,180,760,300);
        pBG.add(jcNL);
        tblNL.setModel(modelNL);
        
        frame.add(pBG);
        
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new MainFrame();
                    frame.hide();
            }
        });
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
