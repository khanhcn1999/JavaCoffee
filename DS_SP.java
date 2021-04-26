package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import BUS.*;
import DTO.*;
import javax.swing.border.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class DS_SP {
    JFrame frame = new JFrame();
    DefaultTableModel modelSP, modelCTSP;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    JTextField txMaMon, txMaLoaiSP, txTenMon, txDonGia, txSoLuongDT, txDonViTinh, txSearch;
    JLabel lbMaMon, lbMaLoaiSP, lbTenMon, lbDonGia, lbSoLuongDT, lbDonViTinh, lbSearch;
    
    JTextField txMaMonCT, txMaNL, txKhoiLuong, txDonViTinhCT, txSearchCT;
    JLabel lbMaMonCT, lbMaNL, lbKhoiLuong, lbDonViTinhCT, lbSearchCT;
    JButton btCapNhatCT, btXoaCT, btThemCT; 
    
    JComboBox cb;
    
    JTable tblSP, tblCTSP;
    JPanel jp1, jp2;
    
    GetData data = new GetData();
    
    public DS_SP(){
        frame.setSize(1250,700);
        frame.setLayout(null);
        frame.setUndecorated(true);
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        jp1 = new JPanel();
        jp1.setBackground(new Color(155, 207, 243));
        jp1.setLayout(null);
        jp1.setBounds(0,0,1250,100);
        jp1.setBorder(BorderFactory.createTitledBorder(blackBorder, " Hóa Đơn   ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        jp2 = new JPanel();
        jp2.setBackground(new Color(155, 207, 243));
        jp2.setLayout(null);
        jp2.setBounds(20, 420, 850, 240);
        jp2.setBorder(BorderFactory.createTitledBorder(blackBorder, " Chi Tiết Hóa Đơn   ",TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));
        
//Sản Phẩm
        txMaMon = new JTextField();
        txMaLoaiSP = new JTextField();
        txTenMon = new JTextField();
        txDonGia = new JTextField();
        txSoLuongDT = new JTextField();
        txDonViTinh = new JTextField();
        lbMaMon = new JLabel("Mã món");
        lbMaLoaiSP = new JLabel("Mã loại");
        lbTenMon = new JLabel("Tên món");
        lbDonGia = new JLabel("Đơn giá");
        lbSoLuongDT = new JLabel("Số lượng dự tính");
        lbDonViTinh = new JLabel("Đơn vị tính");
        lbSearch = new JLabel("Tìm kiếm");
        txSearch = new JTextField("");
        lbSearch.setFont(new Font("Arial", Font.ITALIC, 16));
        lbSearch.setBounds(20, 120, 120, 20);
        txSearch.setBounds(125, 120, 200, 20);
        lbMaMon.setBounds(140,20,100,20);
        txMaMon.setBounds(240,20,100,20);
        lbMaLoaiSP.setBounds(350,20,100,20);
        txMaLoaiSP.setBounds(450,20,100,20);
        lbTenMon.setBounds(560,20,100,20);
        txTenMon.setBounds(660,20,100,20);
        lbDonGia.setBounds(140,60,100,20);
        txDonGia.setBounds(240,60,100,20);
        lbSoLuongDT.setBounds(350,60,100,20);
        txSoLuongDT.setBounds(450,60,100,20);
        lbDonViTinh.setBounds(560,60,100,20);
        txDonViTinh.setBounds(660,60,100,20);
        jp1.add(lbMaMon);
        jp1.add(txMaMon);
        jp1.add(lbMaLoaiSP);
        jp1.add(txMaLoaiSP);
        jp1.add(lbTenMon);
        jp1.add(txTenMon);
        jp1.add(lbDonGia);
        jp1.add(txDonGia);
        jp1.add(lbSoLuongDT);
        jp1.add(txSoLuongDT);       
        jp1.add(lbDonViTinh);
        jp1.add(txDonViTinh);       
        frame.add(lbSearch);
        frame.add(txSearch);
        
        String c[] = {"Mã món", "Mã loại", "Tên món"};
        cb = new JComboBox(c);
        cb.setBounds(325,120,140,20);
        frame.add(cb);
        
        modelSP = new DefaultTableModel();
        tblSP = new JTable();
        JScrollPane jcSP = new JScrollPane();
        jcSP.setViewportView(tblSP);
        modelSP.addColumn("Mã món");
        modelSP.addColumn("Mã loại");
        modelSP.addColumn("Tên món");
        modelSP.addColumn("Đơn giá");
        modelSP.addColumn("Số lượng dự tính");
        modelSP.addColumn("Đơn vị tính");
        jcSP.setBounds(20,160,850,200);
        frame.add(jcSP);
        if(GetData.dssp == null){
            data.LoadSP();
        }
        for(SanPham sp: GetData.dssp){
            modelSP.addRow(new String[] {sp.getMaMon(), sp.getMaLoaiSP(), sp.getTenMon(), String.valueOf(sp.getDonGia()), String.valueOf(sp.getSoLuongDT()), sp.getDonViTinh()});
        }        
        tblSP.setModel(modelSP);
        
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
        jp1.add(btThem);
        jp1.add(btCapNhat);
        jp1.add(btXoa);
        jp1.add(btThoat);
        frame.add(jp1);


//Chi Tiết Sản Phẩm
        txMaMonCT = new JTextField();
        txMaNL = new JTextField();
        txKhoiLuong = new JTextField();
        txDonViTinh = new JTextField();
        txSearchCT = new JTextField();
        lbMaMonCT = new JLabel("Mã món");
        lbMaNL = new JLabel("Mã NL");
        lbKhoiLuong = new JLabel("Khối lượng");
        lbDonViTinh = new JLabel("Đơn vị tính");
        lbSearchCT = new JLabel("Tìm kiếm");
        lbSearchCT.setFont(new Font("Arial", Font.ITALIC, 16));
        lbSearchCT.setBounds(900,120,120,20);
        txSearchCT.setBounds(976,120,200,20);
        lbMaMonCT.setBounds(20,30,100,20);
        txMaMonCT.setBounds(120,30,150,20);
        lbMaNL.setBounds(300,30,100,20);
        txMaNL.setBounds(380,30,150,20);
        lbKhoiLuong.setBounds(20,70,100,20);
        txKhoiLuong.setBounds(120,70,150,20);
        lbDonViTinh.setBounds(300,70,100,20);
        txDonViTinh.setBounds(380,70,150,20);
        jp2.add(lbMaMonCT);
        jp2.add(txMaMonCT);
        jp2.add(lbMaNL);
        jp2.add(txMaNL);
        jp2.add(lbKhoiLuong);
        jp2.add(txKhoiLuong);
        jp2.add(lbDonViTinh);
        jp2.add(txDonViTinh);
        frame.add(lbSearchCT);
        frame.add(txSearchCT);
        
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
        jp2.add(btThemCT);
        jp2.add(btCapNhatCT);
        jp2.add(btXoaCT);
        frame.add(jp2);
        
        modelCTSP = new DefaultTableModel();
        tblCTSP = new JTable();
        JScrollPane jcCTSP = new JScrollPane();
        jcCTSP.setViewportView(tblCTSP);
        modelCTSP.addColumn("Mã món");
        modelCTSP.addColumn("Mã NL");
        modelCTSP.addColumn("Khối lượng");
        modelCTSP.addColumn("Đơn vị tính");
        jcCTSP.setBounds(900,160,305,500);
        frame.add(jcCTSP);
        if(GetData.dsctsp == null){
            data.LoadCTSP();
        }
        for(ChiTietSP ctsp: GetData.dsctsp){
            modelCTSP.addRow(new String[] {ctsp.getMaMon(), ctsp.getMaNL(), String.valueOf(ctsp.getKhoiLuong()), ctsp.getDonViTinh()});
        }        
        tblCTSP.setModel(modelCTSP);

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
