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

public class DS_L {
    JFrame frame = new JFrame();
    
    JTextField txMaL, txTenL;
    JLabel lbMaL, lbTenL;
    DefaultTableModel modelL;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    
    JComboBox cb;
    
    JTable tblL;
    JPanel pL, pBG;
    public DS_L(){
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setUndecorated(true);
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pL = new JPanel();
        pL.setBackground(new Color(155, 207, 243));
        pL.setLayout(null);
        pL.setBounds(0,0,500,100);
        pL.setBorder(BorderFactory.createTitledBorder(blackBorder, "  Loại  ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pBG = new JPanel();
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,500,500);
        
        txMaL = new JTextField();
        lbMaL = new JLabel("Mã loại");
        txTenL = new JTextField();
        lbTenL = new JLabel("Tên loại");
        lbMaL.setBounds(100,20,80,20);
        txMaL.setBounds(180,20,100,20);
        lbTenL.setBounds(100,60,80,20);
        txTenL.setBounds(180,60,100,20);
        pL.add(lbMaL);
        pL.add(txMaL);
        pL.add(lbTenL);
        pL.add(txTenL);
        
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
        btThem.setBounds(300,20,80,20);
        btCapNhat.setBounds(400,20,80,20);
        btXoa.setBounds(350,60,80,20);
        btThoat.setBounds(20,20,20,20);
        pL.add(btThem);
        pL.add(btCapNhat);
        pL.add(btXoa);
        pL.add(btThoat);
        pBG.add(pL);
        
        modelL = new DefaultTableModel();
        tblL = new JTable();
        JScrollPane jcL = new JScrollPane();
        jcL.setViewportView(tblL);
        modelL.addColumn("Mã loại");
        modelL.addColumn("Tên loại");
        jcL.setBounds(20,180,460,300);
        pBG.add(jcL);
        tblL.setModel(modelL);
        
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
