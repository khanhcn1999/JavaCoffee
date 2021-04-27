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
        lbMaMon.setBounds(220,20,80,20);
        txMaMon.setBounds(300,20,120,20);
        lbMaLoaiSP.setBounds(460,20,100,20);
        txMaLoaiSP.setBounds(560,20,120,20);
        lbTenMon.setBounds(720,20,80,20);
        txTenMon.setBounds(800,20,120,20);
        lbDonGia.setBounds(220,60,80,20);
        txDonGia.setBounds(300,60,120,20);
        lbSoLuongDT.setBounds(460,60,100,20);
        txSoLuongDT.setBounds(560,60,120,20);
        lbDonViTinh.setBounds(720,60,80,20);
        txDonViTinh.setBounds(800,60,120,20);
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

        btThem.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               if(!txMaMon.getText().equals("")){
                   if(!txMaLoaiSP.getText().equals("")){
                       if(!txTenMon.getText().equals("")){
                           if(!txDonGia.getText().equals("")){
                                SanPham sp = new SanPham();
                                sp.setMaMon(txMaMon.getText());
                                sp.setMaLoaiSP(txMaLoaiSP.getText());
                                sp.setTenMon(txTenMon.getText());
                                sp.setDonGia(Double.parseDouble(txDonGia.getText()));
                                sp.setSoLuongDT(Double.parseDouble(txSoLuongDT.getText()));
                                sp.setDonViTinh(txDonViTinh.getText());
                                if(data.InsertSP(sp)){
                                    modelSP.addRow(new String[] {sp.getMaMon(), sp.getMaLoaiSP(), sp.getTenMon(), String.valueOf(sp.getDonGia()), String.valueOf(sp.getSoLuongDT()), sp.getDonViTinh()});
                                    JOptionPane.showMessageDialog(frame,"Thêm thành công sản phẩm !", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                                    tblSP.setModel(modelSP);
                                    txMaMon.setText("");
                                    txMaLoaiSP.setText("");
                                    txTenMon.setText("");
                                    txDonGia.setText("");
                                    txSoLuongDT.setText("");
                                    txDonViTinh.setText("");
                                    txMaMon.requestFocus();
                                }
                           }
                           else{
                               JOptionPane.showMessageDialog(frame,"Phải điền đơn giá của món","Thông báo",JOptionPane.ERROR_MESSAGE);
                               txDonGia.requestFocus();
                           }                            
                       }
                       else{
                           JOptionPane.showMessageDialog(frame,"Phải điền tên món","Thông báo",JOptionPane.ERROR_MESSAGE);
                           txTenMon.requestFocus();
                       }
                   }
                   else{
                       JOptionPane.showMessageDialog(frame,"Phải điền mã loại của sản phẩm","Thông báo",JOptionPane.ERROR_MESSAGE);
                       txMaLoaiSP.requestFocus();
                   }
               }
               else{
                   JOptionPane.showMessageDialog(frame,"Phải điền mã món ăn","Thông báo",JOptionPane.ERROR_MESSAGE);
                   txMaMon.requestFocus();
               }
           }
        }); 
        
        btXoa.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               int i = tblSP.getSelectedRow();
               if(i >= 0){
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn xóa thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION)
                    {
                        if(data.DeleteSP((String) tblSP.getValueAt(i, 0))){ 
                            modelSP.removeRow(i);
                            tblSP.setModel(modelSP);
                            JOptionPane.showMessageDialog(frame, "Xóa thành công !!!");
                            txMaMon.setText("");
                            txMaLoaiSP.setText("");
                            txTenMon.setText("");
                            txDonGia.setText("");
                            txSoLuongDT.setText("");
                            txDonViTinh.setText("");
                            txMaMon.requestFocus();
                            txMaMon.setEditable(true);
                        }else{
                            JOptionPane.showMessageDialog(frame, "Error", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        } 
                    }
                    else if(result == JOptionPane.NO_OPTION)
                    {
                        JOptionPane.showMessageDialog(frame, "Không xóa thông tin");
                    }
               }
               else{
                    JOptionPane.showMessageDialog(frame,"Không tìm thấy dữ liệu cần xóa !!!","Thông báo",JOptionPane.ERROR_MESSAGE);
                }  
           }
        });
        btCapNhat.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int i = tblSP.getSelectedRow();
               if(i >= 0)
               {
                   int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn cập nhật thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                   if(result == JOptionPane.YES_OPTION){
                        SanPham sp = new SanPham();
                        sp.setMaMon(txMaMon.getText());
                        sp.setMaLoaiSP(txMaLoaiSP.getText());
                        sp.setTenMon(txTenMon.getText());
                        sp.setDonGia(Double.parseDouble(txDonGia.getText()));
                        sp.setSoLuongDT(Double.parseDouble(txSoLuongDT.getText()));
                        sp.setDonViTinh(txDonViTinh.getText());
                        if(data.UpdateSP(sp, (String) tblSP.getValueAt(i, 0))){
                            SanPham old = GetData.dssp.set(i,sp);
                            modelSP.setValueAt(sp.getMaMon(),i,0);
                            modelSP.setValueAt(sp.getMaLoaiSP(),i,1);
                            modelSP.setValueAt(sp.getTenMon(),i,2);
                            modelSP.setValueAt(sp.getDonGia(),i,3);
                            modelSP.setValueAt(sp.getSoLuongDT(),i,4);
                            modelSP.setValueAt(sp.getDonViTinh(),i,5);
                            tblSP.setModel(modelSP);
                            JOptionPane.showMessageDialog(frame, "Cập nhật thành công", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                            txMaMon.setText("");
                            txMaLoaiSP.setText("");
                            txTenMon.setText("");
                            txDonGia.setText("");
                            txSoLuongDT.setText("");
                            txDonViTinh.setText("");
                            txMaMon.requestFocus();
                            txMaMon.setEditable(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(frame, "Error", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "Không cập nhật thông tin");
                    }  
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Không tìm thấy dữ liệu cần cập nhật !!!","Thông báo",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
               
        tblSP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblSP.getSelectedRow();
                if (i >= 0){
                    txMaMon.setText(String.valueOf(modelSP.getValueAt(i,0)));
                    txMaLoaiSP.setText(String.valueOf(modelSP.getValueAt(i,1)));
                    txTenMon.setText(String.valueOf(modelSP.getValueAt(i,2)));
                    txDonGia.setText(String.valueOf(modelSP.getValueAt(i,3)));
                    txSoLuongDT.setText(String.valueOf(modelSP.getValueAt(i,4)));
                    txDonViTinh.setText(String.valueOf(modelSP.getValueAt(i,5)));
                    txMaMon.setEditable(false);
                    try{
                        modelCTSP.setRowCount(0);
                        String MaMon = String.valueOf(modelSP.getValueAt(i,0));
                        for(ChiTietSP a: GetData.dsctsp){
                            if(a.getMaMon().contains(MaMon)){
                                modelCTSP.addRow(new String[] {a.getMaMon(), a.getMaNL(), String.valueOf(a.getKhoiLuong()), String.valueOf(a.getDonViTinh())});
                                tblCTSP.setModel(modelCTSP);
                            }
                        }  
                    }catch(Exception E){
                    }
                }
            }
        });
        
        
        txMaMon.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txMaLoaiSP.requestFocus();
                }
            }
        });
        txMaLoaiSP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txTenMon.requestFocus();
                }
            }
        });
        txTenMon.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txDonGia.requestFocus();
                }
            }
        });
        txDonGia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txSoLuongDT.requestFocus();
                }
            }
        });
        txSoLuongDT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txDonViTinh.requestFocus();
                }
            }
        });
        txDonViTinh.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btThem.doClick();
                }
            }
        });

//Chi Tiết Sản Phẩm
        txMaMonCT = new JTextField();
        txMaNL = new JTextField();
        txKhoiLuong = new JTextField();
        txDonViTinhCT = new JTextField();
        txSearchCT = new JTextField();
        lbMaMonCT = new JLabel("Mã món");
        lbMaNL = new JLabel("Mã NL");
        lbKhoiLuong = new JLabel("Khối lượng");
        lbDonViTinhCT = new JLabel("Đơn vị tính");
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
        lbDonViTinhCT.setBounds(300,70,100,20);
        txDonViTinhCT.setBounds(380,70,150,20);
        jp2.add(lbMaMonCT);
        jp2.add(txMaMonCT);
        jp2.add(lbMaNL);
        jp2.add(txMaNL);
        jp2.add(lbKhoiLuong);
        jp2.add(txKhoiLuong);
        jp2.add(lbDonViTinhCT);
        jp2.add(txDonViTinhCT);
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
        
        txMaMonCT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txMaNL.requestFocus();
                }
            }
        });
        txMaNL.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txKhoiLuong.requestFocus();
                }
            }
        });
        txKhoiLuong.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txDonViTinhCT.requestFocus();
                }
            }
        });
        txDonViTinhCT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btThemCT.doClick();
                }
            }
        });
        tblCTSP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblCTSP.getSelectedRow();
                if (i >= 0){
                    txMaMonCT.setText(String.valueOf(modelCTSP.getValueAt(i,0)));
                    txMaNL.setText(String.valueOf(modelCTSP.getValueAt(i,1)));
                    txKhoiLuong.setText(String.valueOf(modelCTSP.getValueAt(i,2)));
                    txDonViTinhCT.setText(String.valueOf(modelCTSP.getValueAt(i,3)));
                    txMaMonCT.setEditable(false);
                    txMaNL.setEditable(false);
                }
            }
        });
        
        btThemCT.addActionListener(new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent e){
                if(!txMaMonCT.getText().equals("")){
                    if(!txMaNL.getText().equals("")){
                        if(!txKhoiLuong.getText().equals("")){
                            if(!txDonViTinhCT.getText().equals("")){
                                ChiTietSP ctsp = new ChiTietSP();
                                ctsp.setMaMon(txMaMonCT.getText());
                                ctsp.setMaNL(txMaNL.getText());
                                ctsp.setKhoiLuong(Double.parseDouble(txKhoiLuong.getText()));
                                ctsp.setDonViTinh(txDonViTinhCT.getText());
                                if(data.InsertCTSP(ctsp)){
                                    modelCTSP.addRow(new String[] {ctsp.getMaMon(), ctsp.getMaNL(), String.valueOf(ctsp.getKhoiLuong()), ctsp.getDonViTinh()});
                                    JOptionPane.showMessageDialog(frame,"Thêm thành công chi tiết sản phẩm !", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                                    tblCTSP.setModel(modelCTSP);
                                    txMaMonCT.setText("");
                                    txMaNL.setText("");
                                    txKhoiLuong.setText("");
                                    txDonViTinhCT.setText("");
                                    txMaMonCT.requestFocus();
                                }
                            }
                        }
                    }
                }
            }
        });
        btXoaCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int i = tblCTSP.getSelectedRow();
                if(i >= 0)
                 {
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn xóa thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION)
                    {
                        if(data.DeleteCTSP((String) tblCTSP.getValueAt(i, 0), (String) tblCTSP.getValueAt(i, 1))){ 
                            modelCTSP.removeRow(i);
                            tblCTSP.setModel(modelCTSP);
                            JOptionPane.showMessageDialog(frame, "Xóa thành công !!!");
                            txMaMonCT.setText("");
                            txMaNL.setText("");
                            txKhoiLuong.setText("");
                            txDonViTinhCT.setText("");
                            txMaMonCT.setEditable(true);
                        }else{
                            JOptionPane.showMessageDialog(frame, "Error", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        } 
                    }
                    else if(result == JOptionPane.NO_OPTION){
                        JOptionPane.showMessageDialog(frame, "Không xóa thông tin");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Không tìm thấy dữ liệu cần xóa !!!","Thông báo",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        btCapNhatCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int i = tblCTSP.getSelectedRow();
                if(i >= 0)
                {
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn cập nhật thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        ChiTietSP ctsp = new ChiTietSP();
                        ctsp.setMaMon(txMaMonCT.getText());
                        ctsp.setMaNL(txMaNL.getText());
                        ctsp.setKhoiLuong(Double.parseDouble(txKhoiLuong.getText()));
                        ctsp.setDonViTinh(txDonViTinhCT.getText());
                        if(data.UpdateCTSP(ctsp,(String) tblCTSP.getValueAt(i, 0), (String) tblCTSP.getValueAt(i, 1))){
                            ChiTietSP old = GetData.dsctsp.set(i,ctsp);
                            modelCTSP.setValueAt(ctsp.getMaMon(),i,0);
                            modelCTSP.setValueAt(ctsp.getMaNL(),i,1);
                            modelCTSP.setValueAt(ctsp.getKhoiLuong(),i,2);
                            modelCTSP.setValueAt(ctsp.getDonViTinh(),i,3);
                            tblCTSP.setModel(modelCTSP);
                            JOptionPane.showMessageDialog(frame, "Cập nhật thành công", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                            txMaMonCT.setText("");
                            txMaNL.setText("");
                            txKhoiLuong.setText("");
                            txDonViTinhCT.setText("");
                            txMaMonCT.setEditable(true);
                        }else{
                            JOptionPane.showMessageDialog(frame, "Error", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        }
                   }
                   else{
                       JOptionPane.showMessageDialog(frame, "Không cập nhật thông tin");
                   }
               }
               else{
                   JOptionPane.showMessageDialog(frame,"Không tìm thấy dữ liệu cần cập nhật !!!","Thông báo",JOptionPane.ERROR_MESSAGE);
               }
            }
        });
                        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
