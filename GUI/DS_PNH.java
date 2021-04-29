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

public class DS_PNH {
    JFrame frame = new JFrame();
    DefaultTableModel modelPNH, modelCTPNH;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    JTextField txMaPNH, txMaNV, txMaNCC, txNgayNhap, txTongCong, txSearch ;
    JLabel lbMaPNH, lbMaNV, lbMaNCC, lbNgayNhap, lbTongCong, lbSearch;
    
    JTextField txMaP, txMaNL, txSoLuong, txDonGia, txThanhTien, txSearchCT;
    JLabel lbMaP, lbMaNL, lbSoLuong, lbDonGia, lbThanhTien, lbSearchCT;
    JButton btCapNhatCT, btXoaCT, btThemCT; 
    
    JComboBox cb;
    
    JTable tblPNH, tblCTPNH;
    JPanel pPNH, pCTPNH, pBG;
    public DS_PNH(){
        frame.setSize(1250,700);
        frame.setLayout(null);
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
        pCTPNH.setBounds(20, 420, 850, 240);
        pCTPNH.setBorder(BorderFactory.createTitledBorder(blackBorder, " Chi Tiết Hóa Đơn   ",TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        pBG = new JPanel();
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,1250,700);
        
// Phiếu Nhập Hàng
        txMaPNH = new JTextField();
        txMaNV = new JTextField();
        txMaNCC = new JTextField();
        txNgayNhap = new JTextField();
        txTongCong = new JTextField(); 
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
        txMaNV.setBounds(490,20,120,20);
        lbMaNCC.setBounds(660,20,100,20);
        txMaNCC.setBounds(780,20,120,20);
        lbNgayNhap.setBounds(100,60,100,20);
        txNgayNhap.setBounds(200,60,120,20);
        lbTongCong.setBounds(370,60,120,20);
        txTongCong.setBounds(490,60,120,20);
        pPNH.add(lbMaPNH);
        pPNH.add(txMaPNH);
        pPNH.add(lbMaNV);
        pPNH.add(txMaNV);
        pPNH.add(lbMaNCC);
        pPNH.add(txMaNCC);
        pPNH.add(lbNgayNhap);
        pPNH.add(txNgayNhap);
        pPNH.add(lbTongCong);
        pPNH.add(txTongCong);
        pBG.add(lbSearch);
        pBG.add(txSearch);
        
        String c[] = {"Mã phiếu nhập", "Mã nhân viên", "Mã nhà cung cấp"};
        cb = new JComboBox(c);
        cb.setBounds(325,120,140,20);
        pBG.add(cb);
        
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
        pPNH.add(btThem);
        pPNH.add(btCapNhat);
        pPNH.add(btXoa);
        pPNH.add(btThoat);
        pBG.add(pPNH);
        
        modelPNH = new DefaultTableModel();
        tblPNH = new JTable();
        JScrollPane jcPNH = new JScrollPane();
        jcPNH.setViewportView(tblPNH);
        modelPNH.addColumn("Mã phiếu nhập");
        modelPNH.addColumn("Mã nhân viên");
        modelPNH.addColumn("Mã nhà cung cấp");
        modelPNH.addColumn("Ngày nhập");
        modelPNH.addColumn("Tổng cộng");
        jcPNH.setBounds(20,160,850,200);
        pBG.add(jcPNH);
        tblPNH.setModel(modelPNH);
        
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {             
                    new MainFrame();
                    frame.hide();
            }
        });

// Chi Tiết Phiếu Nhập Hàng

        txMaP = new JTextField();
        txMaNL = new JTextField(); 
        txSoLuong = new JTextField();
        txDonGia = new JTextField();
        txThanhTien = new JTextField();
        txSearchCT = new JTextField();
        lbMaP = new JLabel("Mã phiếu nhập");
        lbMaNL = new JLabel("Mã nguyên liệu"); 
        lbSoLuong = new JLabel("Số lượng");
        lbDonGia = new JLabel("Đơn giá");
        lbThanhTien = new JLabel("Thành tiền");
        lbSearchCT = new JLabel("Tìm kiếm");
        lbSearchCT.setFont(new Font("Arial", Font.ITALIC, 16));
        lbSearchCT.setBounds(900,120,120,20);
        txSearchCT.setBounds(976,120,200,20);
        lbMaP.setBounds(20,30,100,20);
        txMaP.setBounds(120,30,120,20);
        lbMaNL.setBounds(300,30,100,20);
        txMaNL.setBounds(390,30,120,20);
        lbSoLuong.setBounds(20,70,100,20);
        txSoLuong.setBounds(120,70,120,20);
        lbDonGia.setBounds(300,70,100,20);
        txDonGia.setBounds(390,70,120,20);
        lbThanhTien.setBounds(20,110,100,20);
        txThanhTien.setBounds(120,110,120,20);
        pCTPNH.add(lbMaP);
        pCTPNH.add(txMaP);
        pCTPNH.add(lbMaNL);
        pCTPNH.add(txMaNL);
        pCTPNH.add(lbSoLuong);
        pCTPNH.add(txSoLuong);
        pCTPNH.add(lbDonGia);
        pCTPNH.add(txDonGia);
        pCTPNH.add(lbThanhTien);
        pCTPNH.add(txThanhTien);
        pBG.add(lbSearchCT);
        pBG.add(txSearchCT);
        
        btXoaCT = new JButton("Xóa");
        btXoaCT.setBorder(BorderFactory.createEmptyBorder());
        btXoaCT.setBackground(Color.BLUE);
        btXoaCT.setForeground(Color.WHITE);
        btCapNhatCT = new JButton("Cập nhật");
        btCapNhatCT.setBorder(BorderFactory.createEmptyBorder());
        btCapNhatCT.setBackground(Color.BLUE);
        btCapNhatCT.setForeground(Color.WHITE);
        btThemCT = new JButton("Thêm");
        btThemCT.setBorder(BorderFactory.createEmptyBorder());
        btThemCT.setBackground(Color.BLUE);
        btThemCT.setForeground(Color.WHITE);
        btThemCT.setBounds(570,30,100,20);
        btCapNhatCT.setBounds(700,30,100,20);
        btXoaCT.setBounds(630,70,100,20);
        pCTPNH.add(btThemCT);
        pCTPNH.add(btCapNhatCT);
        pCTPNH.add(btXoaCT);
        pBG.add(pCTPNH);
        
        modelCTPNH = new DefaultTableModel();
        tblCTPNH = new JTable();
        JScrollPane jcCTPNH = new JScrollPane();
        jcCTPNH.setViewportView(tblCTPNH);
        modelCTPNH.addColumn("Mã PNH");
        modelCTPNH.addColumn("Mã NL");
        modelCTPNH.addColumn("Số lượng");
        modelCTPNH.addColumn("Đơn giá");
        modelCTPNH.addColumn("Thành tiền");
        jcCTPNH.setBounds(900,160,315,500);
        tblCTPNH.setModel(modelCTPNH);
        pBG.add(jcCTPNH);

        frame.add(pBG);
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
