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

public class DS_HD {
    JFrame frame = new JFrame();
    DefaultTableModel modelHD, modelCTHD;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    JTextField txMaHD, txMaTV, txMaNV, txMaKM, txNgayLHD, txTongTien, txTongKM, txTongTT, txSearch ;
    JLabel lbMaHD, lbMaTV, lbMaNV, lbMaKM, lbNgayLHD, lbTongTien, lbTongKM, lbTongTT, lbSearch;
    
    JTextField txMaHDCT, txMaMon, txSoLuong, txDonGia, txTT, txSearchCT;
    JLabel lbMaHDCT, lbMaMon, lbSoLuong, lbDonGia, lbTT, lbSearchCT;
    JButton btCapNhatCT, btXoaCT, btThemCT; 
    
    JComboBox cb;
    
    JTable tblHD, tblCTHD;
    JPanel jp1, jp2;
    
    GetData data = new GetData();
    
    public DS_HD()
    {        
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
        
        
// Hóa Đơn        
        txMaHD = new JTextField();
        txMaTV = new JTextField();
        txMaNV = new JTextField();
        txMaKM = new JTextField();
        txNgayLHD = new JTextField();
        txTongTien = new JTextField();
        txTongKM = new JTextField();
        txTongTT = new JTextField();
        txSearch = new JTextField();
        lbMaHD = new JLabel("Mã hóa đơn");
        lbMaTV = new JLabel("Mã thành viên");
        lbMaNV = new JLabel("Mã nhân viên");
        lbMaKM = new JLabel("Mã khuyến mãi");
        lbNgayLHD = new JLabel("Ngày lập hóa đơn");
        lbTongTien = new JLabel("Tổng tiền");
        lbTongKM = new JLabel("Tổng khuyến mãi");
        lbTongTT = new JLabel("Thanh toán");
        lbSearch = new JLabel("Tìm kiếm");
        lbSearch.setFont(new Font("Arial", Font.ITALIC, 16));
        lbSearch.setBounds(20, 120, 120, 20);
        txSearch.setBounds(125, 120, 200, 20);
        lbMaHD.setBounds(140,20,100,20);
        txMaHD.setBounds(240,20,100,20);
        lbMaNV.setBounds(350,20,100,20);
        txMaNV.setBounds(450,20,100,20);
        lbMaTV.setBounds(560,20,100,20);
        txMaTV.setBounds(660,20,100,20);
        lbMaKM.setBounds(770,20,100,20);
        txMaKM.setBounds(870,20,100,20);
        lbNgayLHD.setBounds(140,60,100,20);
        txNgayLHD.setBounds(240,60,100,20);
        lbTongTien.setBounds(350,60,100,20);
        txTongTien.setBounds(450,60,100,20);
        lbTongKM.setBounds(560,60,100,20);
        txTongKM.setBounds(660,60,100,20);
        lbTongTT.setBounds(770,60,100,20);
        txTongTT.setBounds(870,60,100,20);
        jp1.add(lbMaHD);
        jp1.add(txMaHD);
        jp1.add(lbMaTV);
        jp1.add(txMaTV);
        jp1.add(lbMaNV);
        jp1.add(txMaNV);
        jp1.add(lbMaKM);
        jp1.add(txMaKM);
        jp1.add(lbNgayLHD);
        jp1.add(txNgayLHD);       
        jp1.add(lbTongTien);
        jp1.add(txTongTien);       
        jp1.add(lbTongKM);
        jp1.add(txTongKM);       
        jp1.add(lbTongTT);
        jp1.add(txTongTT);
        frame.add(lbSearch);
        frame.add(txSearch);
        
        String c[] = {"Mã hóa đơn", "Mã nhân viên", "Mã thành viên", "Mã khuyến mãi"};
        cb = new JComboBox(c);
        cb.setBounds(325,120,140,20);
        frame.add(cb);
        
        modelHD = new DefaultTableModel();
        tblHD = new JTable();
        JScrollPane jcHD = new JScrollPane();
        jcHD.setViewportView(tblHD);
        modelHD.addColumn("Mã hóa đơn");
        modelHD.addColumn("Mã nhân viên");
        modelHD.addColumn("Mã thẻ thành viên");
        modelHD.addColumn("Mã khuyến mãi");
        modelHD.addColumn("Ngày lập hóa đơn");
        modelHD.addColumn("Tổng tiền");
        modelHD.addColumn("Tổng khuyến mãi");
        modelHD.addColumn("Tiền thanh toán");
        jcHD.setBounds(20,160,850,200);
        frame.add(jcHD);
        if(GetData.dshd == null){
            data.LoadHD();
        }
        for(HoaDon hd: GetData.dshd){
            modelHD.addRow(new String[] {hd.getMaHD(), hd.getMaNV(), hd.getMaTV(), hd.getMaKM(), hd.getNgayLHD(), String.valueOf(hd.getTongTien()),  String.valueOf(hd.getTongKM()),  String.valueOf(hd.getTongTT())});
        }        
        tblHD.setModel(modelHD);
        
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
               if(!txMaHD.getText().equals("")){
                   if(!txMaNV.getText().equals("")){
                       if(!txNgayLHD.getText().equals("")){
                           if(!txTongTien.getText().equals("")){
                                HoaDon hd = new HoaDon();
                                hd.setMaHD(txMaHD.getText());
                                hd.setMaNV(txMaNV.getText());
                                hd.setMaTV(txMaTV.getText());
                                hd.setMaKM(txMaKM.getText());
                                hd.setNgayLHD(txNgayLHD.getText());
                                hd.setTongTien(Double.parseDouble(txTongTien.getText()));
                                hd.setTongKM(Double.parseDouble(txTongKM.getText()));
                                hd.setTongTT(Double.parseDouble(txTongTien.getText()) - Double.parseDouble(txTongKM.getText()));
                                if(data.InsertHD(hd)){
                                    modelHD.addRow(new String[] {hd.getMaHD(), hd.getMaNV(), hd.getMaTV(), hd.getMaKM(), hd.getNgayLHD(), String.valueOf(hd.getTongTien()), String.valueOf(hd.getTongKM()), String.valueOf(hd.getTongTT())});
                                    JOptionPane.showMessageDialog(frame,"Thêm thành công hóa đơn !", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                                    tblHD.setModel(modelHD);
                                    txMaHD.setText("");
                                    txMaNV.setText("");
                                    txMaTV.setText("");
                                    txMaKM.setText("");
                                    txNgayLHD.setText("");
                                    txTongTien.setText("");
                                    txTongKM.setText("");
                                    txTongTT.setText("");
                                    txMaHD.requestFocus();
                                }
                                else{
                                    JOptionPane.showMessageDialog(frame,"Error","Thông báo",JOptionPane.ERROR_MESSAGE);
                                }    
                           }
                           else{
                               JOptionPane.showMessageDialog(frame,"Phải điền tổng tiền cần thanh toán","Thông báo",JOptionPane.ERROR_MESSAGE);
                               txNgayLHD.requestFocus();
                           }                            
                       }
                       else{
                           JOptionPane.showMessageDialog(frame,"Phải điền ngày lập hóa đơn","Thông báo",JOptionPane.ERROR_MESSAGE);
                           txNgayLHD.requestFocus();
                       }
                   }
                   else{
                       JOptionPane.showMessageDialog(frame,"Phải điền mã nhân viên","Thông báo",JOptionPane.ERROR_MESSAGE);
                       txMaNV.requestFocus();
                   }
               }
               else{
                   JOptionPane.showMessageDialog(frame,"Phải điền mã hóa đơn","Thông báo",JOptionPane.ERROR_MESSAGE);
                   txMaHD.requestFocus();
               }
           }
        }); 
        
        btXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblHD.getSelectedRow();
                if(i >= 0)
                {
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn xóa thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION)
                    {
                        if(data.DeleteHD((String) tblHD.getValueAt(i, 0))){ 
                            modelHD.removeRow(i);
                            tblHD.setModel(modelHD);
                            JOptionPane.showMessageDialog(frame, "Xóa thành công !!!");
                            txMaHD.setText("");
                            txMaNV.setText("");
                            txMaTV.setText("");
                            txMaKM.setText("");
                            txNgayLHD.setText("");
                            txTongTien.setText("");
                            txTongKM.setText("");
                            txTongTT.setText("");
                            txMaHD.requestFocus();
                            txMaHD.setEditable(true);
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
               int i = tblHD.getSelectedRow();
               if(i >= 0)
               {
                   int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn cập nhật thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                   if(result == JOptionPane.YES_OPTION){
                        HoaDon hd = new HoaDon();
                        hd.setMaHD(txMaHD.getText());
                        hd.setMaNV(txMaNV.getText());
                        hd.setMaTV(txMaTV.getText());
                        hd.setMaKM(txMaKM.getText());
                        hd.setNgayLHD(txNgayLHD.getText());
                        hd.setTongTien(Double.parseDouble(txTongTien.getText()));
                        hd.setTongKM(Double.parseDouble(txTongKM.getText()));
                        hd.setTongTT(Double.parseDouble(txTongTien.getText()) - Double.parseDouble(txTongKM.getText()));
                        if(data.UpdateHD(hd, (String) tblHD.getValueAt(i, 0))){
                            HoaDon old = GetData.dshd.set(i,hd);
                            modelHD.setValueAt(hd.getMaHD(),i,0);
                            modelHD.setValueAt(hd.getMaNV(),i,1);
                            modelHD.setValueAt(hd.getMaTV(),i,2);
                            modelHD.setValueAt(hd.getMaKM(),i,3);
                            modelHD.setValueAt(hd.getNgayLHD(),i,4);
                            modelHD.setValueAt(hd.getTongTien(),i,5);
                            modelHD.setValueAt(hd.getTongKM(),i,6);
                            modelHD.setValueAt(hd.getTongTT(),i,7);
                            tblHD.setModel(modelHD);
                            JOptionPane.showMessageDialog(frame, "Cập nhật thành công", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                            txMaHD.setText("");
                            txMaNV.setText("");
                            txMaTV.setText("");
                            txMaKM.setText("");
                            txNgayLHD.setText("");
                            txTongTien.setText("");
                            txTongKM.setText("");
                            txTongTT.setText("");
                            txMaHD.requestFocus();
                            txMaHD.setEditable(true);
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
        
        tblHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblHD.getSelectedRow();
                if (i >= 0){
                    txMaHD.setText(String.valueOf(modelHD.getValueAt(i,0)));
                    txMaNV.setText(String.valueOf(modelHD.getValueAt(i,1)));
                    txMaTV.setText(String.valueOf(modelHD.getValueAt(i,2)));
                    txMaKM.setText(String.valueOf(modelHD.getValueAt(i,3)));
                    txNgayLHD.setText(String.valueOf(modelHD.getValueAt(i,4)));
                    txTongTien.setText(String.valueOf(modelHD.getValueAt(i,5)));
                    txTongKM.setText(String.valueOf(modelHD.getValueAt(i,6)));
                    txTongTT.setText(String.valueOf(modelHD.getValueAt(i,7)));
                    txMaHD.setEditable(false);
                    
                    try{
                        modelCTHD.setRowCount(0);
                        String MaHD = String.valueOf(modelHD.getValueAt(i,0));
                        for(ChiTietHD a: GetData.dscthd){
                            if(a.getMaHD().contains(MaHD)){
                                modelCTHD.addRow(new String[] {a.getMaHD(), a.getMaMon(), String.valueOf(a.getSoLuong()), String.valueOf(a.getDonGia()), String.valueOf(a.getThanhTien())});
                                tblCTHD.setModel(modelCTHD);
                            }
                        }  
                    }catch(Exception E){
                    }
                }
            }
        });
        txMaHD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txMaNV.requestFocus();
                }
            }
        });
        txMaNV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txMaTV.requestFocus();
                }
            }
        });
        txMaTV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txMaKM.requestFocus();
                }
            }
        });
        txMaKM.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txNgayLHD.requestFocus();
                }
            }
        }); 
        txNgayLHD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txTongTien.requestFocus();
                }
            }
        }); 
        txTongTien.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txTongKM.requestFocus();
                }
            }
        });
        txTongKM.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txTongTT.requestFocus();
                }
            }
        });
        txTongTT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btThem.doClick();
                }
            }
        });       
        
// Chi Tiết Hóa Đơn        
        
        txMaHDCT = new JTextField();
        txMaMon = new JTextField();
        txSoLuong = new JTextField();
        txDonGia = new JTextField();
        txTT = new JTextField();
        txSearchCT = new JTextField();
        lbMaHDCT = new JLabel("Mã hóa đơn");
        lbMaMon = new JLabel("Mã món");
        lbSoLuong = new JLabel("Số lượng");
        lbDonGia = new JLabel("Đơn giá");
        lbTT = new JLabel("Thành tiền");
        lbSearchCT = new JLabel("Tìm kiếm");
        lbSearchCT.setFont(new Font("Arial", Font.ITALIC, 16));
        lbSearchCT.setBounds(900,120,120,20);
        txSearchCT.setBounds(976,120,200,20);
        lbMaHDCT.setBounds(20,30,100,20);
        txMaHDCT.setBounds(120,30,150,20);
        lbMaMon.setBounds(300,30,100,20);
        txMaMon.setBounds(380,30,150,20);
        lbSoLuong.setBounds(20,70,100,20);
        txSoLuong.setBounds(120,70,150,20);
        lbDonGia.setBounds(300,70,100,20);
        txDonGia.setBounds(380,70,150,20);
        lbTT.setBounds(20,110,100,20);
        txTT.setBounds(120,110,150,20);
        jp2.add(lbMaHDCT);
        jp2.add(txMaHDCT);
        jp2.add(lbMaMon);
        jp2.add(txMaMon);
        jp2.add(lbSoLuong);
        jp2.add(txSoLuong);
        jp2.add(lbDonGia);
        jp2.add(txDonGia);
        jp2.add(lbTT);
        jp2.add(txTT);
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

        modelCTHD = new DefaultTableModel();
        tblCTHD = new JTable();
        JScrollPane jcCTHD = new JScrollPane();
        jcCTHD.setViewportView(tblCTHD);
        modelCTHD.addColumn("Mã HD");
        modelCTHD.addColumn("Mã món");
        modelCTHD.addColumn("Số lượng");
        modelCTHD.addColumn("Đơn giá");
        modelCTHD.addColumn("Thành tiền");
        jcCTHD.setBounds(900,160,305,500);
        frame.add(jcCTHD);
        if(GetData.dscthd == null){
            data.LoadCTHD();
        }
        for(ChiTietHD cthd: GetData.dscthd){
            modelCTHD.addRow(new String[] {cthd.getMaHD(), cthd.getMaMon(), String.valueOf(cthd.getSoLuong()), String.valueOf(cthd.getDonGia()), String.valueOf(cthd.getThanhTien())});
        }        
        tblCTHD.setModel(modelCTHD);
        
        txSearchCT.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent ex){
                SearchMaCT();
            }
            
            @Override
            public void insertUpdate(DocumentEvent ex){
                SearchMaCT();
            }
            
            @Override
            public void changedUpdate(DocumentEvent ex){
                SearchMaCT();
            }
            
            public void SearchMaCT(){
                try{
                    modelCTHD.setRowCount(0);
                    if(txSearchCT.getText().isEmpty()){
                        tblCTHD.setModel(modelCTHD);
                    }
                    String hd = txSearchCT.getText().toLowerCase();
                    for(ChiTietHD a: GetData.dscthd){
                        if(a.getMaHD().toLowerCase().contains(hd)){
                            modelCTHD.addRow(new String[] {a.getMaHD(), a.getMaMon(), String.valueOf(a.getSoLuong()), String.valueOf(a.getDonGia()), String.valueOf(a.getThanhTien())});
                            tblCTHD.setModel(modelCTHD);
                        }
                    }  
                }catch(Exception E){
                }
            }
        });
        
        txSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent ex){
                if(cb.getItemAt(cb.getSelectedIndex()) == "Mã hóa đơn"){
                    SearchMaHD();
                }
                else if(cb.getItemAt(cb.getSelectedIndex()) == "Mã nhân viên"){
                    SearchMaNV();
                }
                else if(cb.getItemAt(cb.getSelectedIndex()) == "Mã thành viên"){
                    SearchMaTV();
                }
                else if(cb.getItemAt(cb.getSelectedIndex()) == "Mã khuyến mãi"){
                    SearchMaKM();
                }
            }
            
            @Override
            public void insertUpdate(DocumentEvent ex){
                if(cb.getItemAt(cb.getSelectedIndex()) == "Mã hóa đơn"){
                    SearchMaHD();
                }
                else if(cb.getItemAt(cb.getSelectedIndex()) == "Mã nhân viên"){
                    SearchMaNV();
                }
                else if(cb.getItemAt(cb.getSelectedIndex()) == "Mã thành viên"){
                    SearchMaTV();
                }
                else if(cb.getItemAt(cb.getSelectedIndex()) == "Mã khuyến mãi"){
                    SearchMaKM();
                }
            }
            
            @Override
            public void changedUpdate(DocumentEvent ex){
                if(cb.getItemAt(cb.getSelectedIndex()) == "Mã hóa đơn"){
                    SearchMaHD();
                }
                else if(cb.getItemAt(cb.getSelectedIndex()) == "Mã nhân viên"){
                    SearchMaNV();
                }
                else if(cb.getItemAt(cb.getSelectedIndex()) == "Mã thành viên"){
                    SearchMaTV();
                }
                else if(cb.getItemAt(cb.getSelectedIndex()) == "Mã khuyến mãi"){
                    SearchMaKM();
                }
            }
            
            public void SearchMaHD(){
                try{
                    modelHD.setRowCount(0);
                    if(txSearch.getText().isEmpty()){
                        tblHD.setModel(modelHD);
                    }
                    String hd = txSearch.getText().toLowerCase();
                    for(HoaDon a: GetData.dshd){
                        if(a.getMaHD().toLowerCase().contains(hd)){
                            modelHD.addRow(new String[] {a.getMaHD(), a.getMaNV(), a.getMaTV(), a.getMaKM(), a.getNgayLHD(), String.valueOf(a.getTongTien()), String.valueOf(a.getTongKM()), String.valueOf(a.getTongTT())});
                            tblHD.setModel(modelHD);
                        }
                    }  
                }catch(Exception E){
                }
            }
            public void SearchMaNV(){
                try{
                    modelHD.setRowCount(0);
                    if(txSearch.getText().isEmpty()){
                        tblHD.setModel(modelHD);
                    }
                    String hd = txSearch.getText().toLowerCase();
                    for(HoaDon a: GetData.dshd){
                        if(a.getMaNV().toLowerCase().contains(hd)){
                            modelHD.addRow(new String[] {a.getMaHD(), a.getMaNV(), a.getMaTV(), a.getMaKM(), a.getNgayLHD(), String.valueOf(a.getTongTien()), String.valueOf(a.getTongKM()), String.valueOf(a.getTongTT())});
                            tblHD.setModel(modelHD);
                        }
                    }  
                }catch(Exception E){
                }
            }
            public void SearchMaTV(){
                try{
                    modelHD.setRowCount(0);
                    if(txSearch.getText().isEmpty()){
                        tblHD.setModel(modelHD);
                    }
                    String hd = txSearch.getText().toLowerCase();
                    for(HoaDon a: GetData.dshd){
                        if(a.getMaTV().toLowerCase().contains(hd)){
                            modelHD.addRow(new String[] {a.getMaHD(), a.getMaNV(), a.getMaTV(), a.getMaKM(), a.getNgayLHD(), String.valueOf(a.getTongTien()), String.valueOf(a.getTongKM()), String.valueOf(a.getTongTT())});
                            tblHD.setModel(modelHD);
                        }
                    }  
                }catch(Exception E){
                }
            }
            public void SearchMaKM(){
                try{
                    modelHD.setRowCount(0);
                    if(txSearch.getText().isEmpty()){
                        tblHD.setModel(modelHD);
                    }
                    String hd = txSearch.getText().toLowerCase();
                    for(HoaDon a: GetData.dshd){
                        if(a.getMaKM().toLowerCase().contains(hd)){
                            modelHD.addRow(new String[] {a.getMaHD(), a.getMaNV(), a.getMaTV(), a.getMaKM(), a.getNgayLHD(), String.valueOf(a.getTongTien()), String.valueOf(a.getTongKM()), String.valueOf(a.getTongTT())});
                            tblHD.setModel(modelHD);
                        }
                    }  
                }catch(Exception E){
                }
            }
        });
        
        
        btThemCT.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               if(!txMaHDCT.getText().equals("")){
                   if(!txMaMon.getText().equals("")){
                       if(!txSoLuong.getText().equals("")){
                           if(!txDonGia.getText().equals("")){
                               ChiTietHD cthd = new ChiTietHD();
                               cthd.setMaHD(txMaHDCT.getText());
                               cthd.setMaMon(txMaMon.getText());
                               cthd.setSoLuong(Double.parseDouble(txSoLuong.getText()));
                               cthd.setDonGia(Double.parseDouble(txDonGia.getText()));
                               cthd.setThanhTien(Double.parseDouble(txSoLuong.getText()) * Double.parseDouble(txDonGia.getText()));
                               if(data.InsertCTHD(cthd)){
                                    modelCTHD.addRow(new String[] {cthd.getMaHD(), cthd.getMaMon(), String.valueOf(cthd.getSoLuong()), String.valueOf(cthd.getDonGia()), String.valueOf(cthd.getThanhTien())});
                                    JOptionPane.showMessageDialog(frame,"Thêm thành công chi tiết hóa đơn !", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                                    tblCTHD.setModel(modelCTHD);
                                    txMaHDCT.setText("");
                                    txMaMon.setText("");
                                    txSoLuong.setText("");
                                    txDonGia.setText("");
                                    txTT.setText("");
                                    txMaHDCT.requestFocus();
                                }
                           }
                           else{
                                JOptionPane.showConfirmDialog(frame,"Không được để đơn giá !", "Thông báo",JOptionPane.ERROR_MESSAGE);
                            }
                       }
                       else{
                            JOptionPane.showConfirmDialog(frame,"Không được để trống số lượng !", "Thông báo",JOptionPane.ERROR_MESSAGE);
                        }
                   }
                   else{
                        JOptionPane.showConfirmDialog(frame,"Không được để trống mã món ăn !", "Thông báo",JOptionPane.ERROR_MESSAGE);
                    }
               }
               else{
                   JOptionPane.showConfirmDialog(frame,"Không được để trống mã hóa đơn !", "Thông báo",JOptionPane.ERROR_MESSAGE);
               }
           }
        });
        btCapNhatCT.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               int i = tblCTHD.getSelectedRow();
               if(i >= 0)
               {
                   int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn cập nhật thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                   if(result == JOptionPane.YES_OPTION){
                        ChiTietHD cthd = new ChiTietHD();
                        cthd.setMaHD(txMaHD.getText());
                        cthd.setMaMon(txMaNV.getText());
                        cthd.setSoLuong(Double.parseDouble(txSoLuong.getText()));
                        cthd.setDonGia(Double.parseDouble(txDonGia.getText()));
                        cthd.setThanhTien(Double.parseDouble(txSoLuong.getText()) * Double.parseDouble(txDonGia.getText()));
                        if(data.UpdateCTHD(cthd, (String) tblHD.getValueAt(i, 0), (String) tblHD.getValueAt(i, 1))){
                            ChiTietHD old = GetData.dscthd.set(i,cthd);
                            modelCTHD.setValueAt(cthd.getMaHD(),i,0);
                            modelCTHD.setValueAt(cthd.getMaMon(),i,1);
                            modelCTHD.setValueAt(cthd.getSoLuong(),i,2);
                            modelCTHD.setValueAt(cthd.getDonGia(),i,3);
                            modelCTHD.setValueAt(cthd.getThanhTien(),i,4);
                            tblCTHD.setModel(modelCTHD);
                            JOptionPane.showMessageDialog(frame, "Cập nhật thành công", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                            txMaHDCT.setText("");
                            txMaMon.setText("");
                            txSoLuong.setText("");
                            txDonGia.setText("");
                            txTT.setText("");
                            txMaHDCT.requestFocus();
                            txMaHDCT.setEditable(true);
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
        btXoaCT.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               int i = tblCTHD.getSelectedRow();
               if(i >= 0)
                {
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn xóa thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION)
                    {
                        if(data.DeleteCTHD((String) tblCTHD.getValueAt(i, 0), (String) tblCTHD.getValueAt(i, 1))){ 
                            modelCTHD.removeRow(i);
                            tblCTHD.setModel(modelCTHD);
                            JOptionPane.showMessageDialog(frame, "Xóa thành công !!!");
                            txMaHDCT.setText("");
                            txMaMon.setText("");
                            txSoLuong.setText("");
                            txDonGia.setText("");
                            txTT.setText("");
                            txMaHD.setEditable(true);
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
        
        tblCTHD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblCTHD.getSelectedRow();
                if(i >= 0 )
                {
                    txMaHDCT.setText(String.valueOf(modelCTHD.getValueAt(i,0)));
                    txMaMon.setText(String.valueOf(modelCTHD.getValueAt(i,1)));
                    txSoLuong.setText(String.valueOf(modelCTHD.getValueAt(i,2)));
                    txDonGia.setText(String.valueOf(modelCTHD.getValueAt(i,3)));
                    txTT.setText(String.valueOf(modelCTHD.getValueAt(i,4)));      
                    txMaHDCT.setEditable(false);
                }
            }
        });
        
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
