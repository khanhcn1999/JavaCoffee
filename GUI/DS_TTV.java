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

public class DS_TTV {
    JFrame frame = new JFrame();
    
    JTextField txMaTTV, txTenTV, txSDT, txDiem, txUD;
    JLabel lbMaTTV, lbTenTV, lbSDT, lbD, lbUD;
    DefaultTableModel modelTTV;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    JTextField txTimKiemTTV;
    JLabel lbTimKiemTTV;
    
    JComboBox cb;
    
    JTable tblTTV;
    JPanel pTTV, pBG;
    public DS_TTV(){
        frame.setSize(1250,500);
        frame.setLayout(null);
        frame.setUndecorated(true);

        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pTTV = new JPanel();
        pTTV.setBackground(new Color(155, 207, 243));
        pTTV.setLayout(null);
        pTTV.setBounds(0,0,1250,100);
        pTTV.setBorder(BorderFactory.createTitledBorder(blackBorder, "  Thẻ thành viên  ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pBG = new JPanel();
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,1250,500);
        
        String c[] = {"Mã thẻ", "Tên thành viên", "Số điện thoại"};
        cb = new JComboBox(c);
        cb.setBounds(300,120,140,20);
        pBG.add(cb);
        
        lbMaTTV = new JLabel("Mã thẻ thành viên");
        lbTenTV = new JLabel("Tên thành viên");
        lbSDT = new JLabel("Số điện thoại");
        lbD = new JLabel("Điểm");
        lbUD = new JLabel("Ưa đãi");
        txTimKiemTTV = new JTextField();
        lbTimKiemTTV = new JLabel("Tìm Kiếm");
        lbTimKiemTTV.setFont(new Font("Arial", Font.ITALIC, 16));
        txMaTTV = new JTextField();
        txTenTV = new JTextField();
        txSDT = new JTextField();
        txDiem = new JTextField();
        txUD = new JTextField();
        lbMaTTV.setBounds(100,20,120,20);
        txMaTTV.setBounds(220,20,120,20);
        lbTenTV.setBounds(380,20,100,20);
        txTenTV.setBounds(480,20,120,20);
        lbSDT.setBounds(640,20,100,20);
        txSDT.setBounds(740,20,120,20);
        lbD.setBounds(100,60,120,20);
        txDiem.setBounds(220,60,120,20);
        lbUD.setBounds(380,60,100,20);
        txUD.setBounds(480,60,120,20);
        lbTimKiemTTV.setBounds(20, 120, 120, 20);
        txTimKiemTTV.setBounds(100, 120, 200, 20);
        pTTV.add(lbMaTTV);
        pTTV.add(txMaTTV);
        pTTV.add(lbTenTV);
        pTTV.add(txTenTV);
        pTTV.add(lbSDT);
        pTTV.add(txSDT);
        pTTV.add(lbD);
        pTTV.add(txDiem);
        pTTV.add(lbUD);
        pTTV.add(txUD);
        pBG.add(lbTimKiemTTV);
        pBG.add(txTimKiemTTV);
        
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
        pTTV.add(btThem);
        pTTV.add(btCapNhat);
        pTTV.add(btXoa);
        pTTV.add(btThoat);
        pBG.add(pTTV);
        
        modelTTV = new DefaultTableModel();
        tblTTV = new JTable();
        JScrollPane jcNV = new JScrollPane();
        jcNV.setViewportView(tblTTV);
        modelTTV.addColumn("Mã thẻ thành viên");
        modelTTV.addColumn("Tên thành viên");
        modelTTV.addColumn("Số điện thoại");
        modelTTV.addColumn("Điểm");
        modelTTV.addColumn("Ưa đãi");
        jcNV.setBounds(20,180,1200,300);
        pBG.add(jcNV);
        tblTTV.setModel(modelTTV);
        
        frame.add(pBG);
        
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new MainFrame();
                    frame.hide();
            }
        });
        txMaTTV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txTenTV.requestFocus();
                }
            }
        }); 
        txTenTV.addKeyListener(new KeyAdapter() {
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
                    txDiem.requestFocus();
                }
            }
        }); 
        txDiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txUD.requestFocus();
                }
            }
        }); 
        txUD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btThem.requestFocus();
                }
            }
        }); 
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
