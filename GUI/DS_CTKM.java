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

public class DS_CTKM {
    JFrame frame = new JFrame();
    DefaultTableModel modelKM, modelCTKM;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    JTextField txMaKM, txTenCT, txNgayBD, txNgayKT, txTimKiemKM;
    JLabel lbMaKM, lbTenCT, lbNgayBD, lbNgayKT, lbTimKiemKM;
    
    JTextField txMaKMCT, txMaMon, txGG , txTimKiemCTKM;
    JLabel lbMaKMCT, lbMaMon, lbGG, lbTimKiemCTKM;
    JButton btCapNhatCT, btXoaCT, btThemCT;
    
    JComboBox cb;
    
    JTable tblKM, tblCTKM;
    JPanel pKM, pCTKM;
    
    GetData data = new GetData();
    
    public DS_CTKM()
    {
        frame.setSize(1250,700);
        frame.setLayout(null);
        frame.setUndecorated(true);

        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pKM = new JPanel();
        pCTKM = new JPanel();
        pKM.setBackground(new Color(155, 207, 243));
        pKM.setLayout(null);
        pKM.setBounds(0,0,1250,100);
        pKM.setBorder(BorderFactory.createTitledBorder(blackBorder, "  Chương Trình Khuyến Mãi  ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pCTKM.setBackground(new Color(155, 207, 243));
        pCTKM.setLayout(null);
        pCTKM.setBounds(20, 420, 850, 240);
        pCTKM.setBorder(BorderFactory.createTitledBorder(blackBorder, "  Chi Tiết Khuyến Mãi  ",TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION));   
        
// Chương Trình Khuyến Mãi

        String c[] = {"Mã khuyến mãi", "Tên chương trình"};
        cb = new JComboBox(c);
        cb.setBounds(300,120,140,20);
        frame.add(cb);
        
        txMaKM = new JTextField();
        txTenCT = new JTextField();
        txNgayBD = new JTextField();
        txNgayKT = new JTextField();
        txTimKiemKM = new JTextField();
        lbMaKM = new JLabel("Mã khuyến mãi");
        lbTenCT = new JLabel("Tên chương trình");
        lbNgayBD = new JLabel("Ngày bắt đầu");
        lbNgayKT = new JLabel("Ngày kết thúc");
        lbTimKiemKM = new JLabel("Tìm Kiếm");
        lbTimKiemKM.setFont(new Font("Arial", Font.ITALIC, 16));
        lbTimKiemKM.setBounds(20, 120, 120, 20);
        txTimKiemKM.setBounds(100, 120, 200, 20);
        lbMaKM.setBounds(300,20,100,20);
        txMaKM.setBounds(400,20,150,20);    
        lbTenCT.setBounds(650,20,150,20);
        txTenCT.setBounds(760,20,150,20); 
        lbNgayBD.setBounds(300,60,100,20);
        txNgayBD.setBounds(400,60,150,20);  
        lbNgayKT.setBounds(650,60,100,20);
        txNgayKT.setBounds(760,60,150,20);
        pKM.add(lbMaKM);
        pKM.add(txMaKM);
        pKM.add(lbTenCT);
        pKM.add(txTenCT);
        pKM.add(lbNgayBD);
        pKM.add(txNgayBD);
        pKM.add(lbNgayKT);
        pKM.add(txNgayKT);
        frame.add(lbTimKiemKM);
        frame.add(txTimKiemKM);

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
        pKM.add(btThem);
        pKM.add(btCapNhat);
        pKM.add(btXoa);
        pKM.add(btThoat);
        frame.add(pKM);
        
        modelKM = new DefaultTableModel();
        tblKM = new JTable();
        JScrollPane jcKM = new JScrollPane();
        jcKM.setViewportView(tblKM);
        modelKM.addColumn("Mã khuyến mãi");
        modelKM.addColumn("Tên chương trình khuyến mãi");
        modelKM.addColumn("Ngày bắt đầu");
        modelKM.addColumn("Ngày kết thúc");
        jcKM.setBounds(20,160,850,220);
        frame.add(jcKM);
        if(data.dsctkm == null){
            data.LoadKM();
        }
        for(ChuongTrinhKhuyenMai ctkm: GetData.dsctkm){
            modelKM.addRow(new String[] {ctkm.getMaKM(), ctkm.getTenCT(), ctkm.getNgayBD(), ctkm.getNgayKT()});
        }        
        tblKM.setModel(modelKM);

        txTimKiemKM.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent ex){
                if(cb.getItemAt(cb.getSelectedIndex()) == "Tên chương trình"){
                    SearchTenKM();
                }
                if(cb.getItemAt(cb.getSelectedIndex()) == "Mã khuyến mãi"){
                    SearchMaKM();
                }
            }
            
            @Override
            public void insertUpdate(DocumentEvent ex){
                if(cb.getItemAt(cb.getSelectedIndex()) == "Tên chương trình"){
                    SearchTenKM();
                }
                if(cb.getItemAt(cb.getSelectedIndex()) == "Mã khuyến mãi"){
                    SearchMaKM();
                }
            }
            
            @Override
            public void changedUpdate(DocumentEvent ex){
                if(cb.getItemAt(cb.getSelectedIndex()) == "Tên chương trình"){
                    SearchTenKM();
                }
                if(cb.getItemAt(cb.getSelectedIndex()) == "Mã khuyến mãi"){
                    SearchMaKM();
                }
            }
            
            public void SearchTenKM(){
                try{
                    modelKM.setRowCount(0);
                    if(txTimKiemKM.getText().isEmpty()){
                        tblKM.setModel(modelKM);
                    }
                    String km = txTimKiemKM.getText().toLowerCase();
                    for(ChuongTrinhKhuyenMai a: GetData.dsctkm){
                        if(a.getTenCT().toLowerCase().contains(km)){
                            modelKM.addRow(new String[] {a.getMaKM(), a.getTenCT(), a.getNgayBD(), a.getNgayKT()});
                            tblKM.setModel(modelKM);
                        }
                    }  
                }catch(Exception E){
                }
            }
            public void SearchMaKM(){
                try{
                    modelKM.setRowCount(0);
                    if(txTimKiemKM.getText().isEmpty()){
                        tblKM.setModel(modelKM);
                    }
                    String maKM = txTimKiemKM.getText().toLowerCase();
                    for(ChuongTrinhKhuyenMai a: GetData.dsctkm){
                        if(a.getMaKM().toLowerCase().contains(maKM)){
                            modelKM.addRow(new String[] {a.getMaKM(), a.getTenCT(), a.getNgayBD(), a.getNgayKT()});
                            tblKM.setModel(modelKM);
                        }
                    }  
                }catch(Exception E){
                }
            }
        });
        
        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txMaKM.getText().equals("")){
                    if(!txTenCT.getText().equals("")){
                        if(!txNgayBD.getText().equals("")){
                            if(!txNgayKT.getText().equals("")){
                                ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai();
                                ctkm.setMaKM(txMaKM.getText());
                                ctkm.setTenCT(txTenCT.getText());
                                ctkm.setNgayBD(txNgayBD.getText());
                                ctkm.setNgayKT(txNgayKT.getText());
                                if(data.InsertKM(ctkm)){
                                    modelKM.addRow(new String[] {ctkm.getMaKM(), ctkm.getTenCT(), ctkm.getNgayBD(), ctkm.getNgayKT()});
                                    JOptionPane.showMessageDialog(frame,"Thêm thành công", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                                    tblKM.setModel(modelKM);
                                    txMaKM.setText("");
                                    txTenCT.setText("");
                                    txNgayBD.setText("");
                                    txNgayKT.setText("");
                                    txMaKM.requestFocus();
                                }
                                else{
                                    JOptionPane.showMessageDialog(frame,"Không thể thêm chương trình khuyến mãi","Thông báo",JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(frame,"Phải điền ngày kết thúc chương trình","Thông báo",JOptionPane.ERROR_MESSAGE);
                                txNgayKT.requestFocus();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(frame,"Phải điền ngày bắt đầu chương trình","Thông báo",JOptionPane.ERROR_MESSAGE);
                            txNgayBD.requestFocus();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,"Phải điền tên chương trình","Thông báo",JOptionPane.ERROR_MESSAGE);
                        txTenCT.requestFocus();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Phải điền mã khuyến mãi","Thông báo",JOptionPane.ERROR_MESSAGE);
                    txMaKM.requestFocus();
                }
            }
        });
        
        btXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblKM.getSelectedRow();
                if(i >= 0)
                {
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn xóa thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION)
                    {
                        if(data.DeleteKM((String) tblKM.getValueAt(i, 0))){
                            modelKM.removeRow(i);
                            tblKM.setModel(modelKM);
                            JOptionPane.showMessageDialog(frame, "Xóa thành công !!!");
                            txMaKM.setText("");
                            txTenCT.setText("");
                            txNgayBD.setText("");
                            txNgayKT.setText("");
                            txMaKM.requestFocus();
                            txMaKM.setEditable(true);
                        }
                        else{
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
                    txMaKM.requestFocus();
                }
            }
        });
        btCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblKM.getSelectedRow();
                if(i >= 0)
                {
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn cập nhật thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai();
                        ctkm.setMaKM(txMaKM.getText());
                        ctkm.setTenCT(txTenCT.getText());
                        ctkm.setNgayBD(txNgayBD.getText());
                        ctkm.setNgayKT(txNgayKT.getText());
                        if(data.UpdateKM(ctkm, (String) tblKM.getValueAt(i, 0))){
                            ChuongTrinhKhuyenMai old = GetData.dsctkm.set(i,ctkm);
                            modelKM.setValueAt(ctkm.getMaKM(),i,0);
                            modelKM.setValueAt(ctkm.getTenCT(),i,1);
                            modelKM.setValueAt(ctkm.getNgayBD(),i,2);
                            modelKM.setValueAt(ctkm.getNgayKT(),i,3);
                            tblKM.setModel(modelKM);
                            txMaKM.setText("");
                            txTenCT.setText("");
                            txNgayBD.setText("");
                            txNgayKT.setText("");
                            txMaKM.requestFocus();
                            txMaKM.setEditable(true);
                        }
                    }
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
        tblKM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tblKM.getSelectedRow();
                if (i >= 0){
                    txMaKM.setEditable(false);
                    txMaKM.setText(String.valueOf(modelKM.getValueAt(i,0)));
                    txTenCT.setText(String.valueOf(modelKM.getValueAt(i,1)));
                    txNgayBD.setText(String.valueOf(modelKM.getValueAt(i,2)));
                    txNgayKT.setText(String.valueOf(modelKM.getValueAt(i,3)));
                    try{
                        modelCTKM.setRowCount(0);
                        String km = String.valueOf(modelKM.getValueAt(i,0));
                        for(ChiTietCTKM a: GetData.dskmct){
                            if(a.getMaKM().contains(km)){
                                modelCTKM.addRow(new String[] {a.getMaKM(), a.getMaMon(), String.valueOf(a.getGG())});
                                tblCTKM.setModel(modelCTKM);
                            }
                        }  
                    }catch(Exception E){
                    }
                }
            }
        });
        
// Chi Tiết Khuyến Mãi        
        
        txMaKMCT = new JTextField();
        txMaMon = new JTextField();
        txGG = new JTextField();
        txTimKiemCTKM = new JTextField();
        lbMaKMCT = new JLabel("Mã khuyến mãi");
        lbMaMon = new JLabel("Mã món");
        lbGG = new JLabel("% giảm giá");
        lbTimKiemCTKM = new JLabel("Tìm Kiếm");
        lbTimKiemCTKM.setFont(new Font("Arial", Font.ITALIC, 16));
        lbTimKiemCTKM.setBounds(900,120,120,20);
        txTimKiemCTKM.setBounds(980,120,200,20);
        lbMaKMCT.setBounds(20,30,100,20);
        txMaKMCT.setBounds(120,30,150,20);
        lbMaMon.setBounds(300,30,100,20);
        txMaMon.setBounds(380,30,150,20);
        lbGG.setBounds(220,70,100,20);
        txGG.setBounds(300,70,150,20);
        pCTKM.add(lbMaKMCT);
        pCTKM.add(txMaKMCT);
        pCTKM.add(lbMaMon);
        pCTKM.add(txMaMon);
        pCTKM.add(lbGG);
        pCTKM.add(txGG);
        frame.add(lbTimKiemCTKM);
        frame.add(txTimKiemCTKM);
        
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
        pCTKM.add(btThemCT);
        pCTKM.add(btCapNhatCT);
        pCTKM.add(btXoaCT);
        frame.add(pCTKM);

        modelCTKM = new DefaultTableModel();
        tblCTKM = new JTable();
        JScrollPane jcCTKM = new JScrollPane();
        jcCTKM.setViewportView(tblCTKM);
        modelCTKM.addColumn("Mã khuyến mãi");
        modelCTKM.addColumn("Mã món");
        modelCTKM.addColumn("% giảm giá");
        jcCTKM.setBounds(900,160,305,500);
        frame.add(jcCTKM);
        if(GetData.dskmct == null){
            data.LoadCTKM();
        }
        for(ChiTietCTKM kmct: GetData.dskmct){
            modelCTKM.addRow(new String[] {kmct.getMaKM(), kmct.getMaMon(), String.valueOf(kmct.getGG())});
        }        
        tblCTKM.setModel(modelCTKM);
        
        txTimKiemCTKM.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent ex){
                SearchMaKM();
            }
            
            @Override
            public void insertUpdate(DocumentEvent ex){
                SearchMaKM();
            }
            
            @Override
            public void changedUpdate(DocumentEvent ex){
                SearchMaKM();
            }
            
            public void SearchMaKM(){
                try{
                    modelCTKM.setRowCount(0);
                    if(txTimKiemCTKM.getText().isEmpty()){
                        tblCTKM.setModel(modelCTKM);
                    }
                    String km = txTimKiemCTKM.getText().toLowerCase();
                    for(ChiTietCTKM a: GetData.dskmct){
                        if(a.getMaKM().toLowerCase().contains(km)){
                            modelCTKM.addRow(new String[] {a.getMaKM(), a.getMaMon(), String.valueOf(a.getGG())});
                            tblCTKM.setModel(modelCTKM);
                        }
                    }  
                }catch(Exception E){
                }
            }
        });
        
        tblCTKM.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               int i = tblCTKM.getSelectedRow();
               if(i >= 0){
                    txMaKMCT.setEditable(false);
                    txMaMon.setEditable(false);
                    txMaKMCT.setText(String.valueOf(modelCTKM.getValueAt(i,0)));
                    txMaMon.setText(String.valueOf(modelCTKM.getValueAt(i,1)));
                    txGG.setText(String.valueOf(modelCTKM.getValueAt(i,2)));
               }
           }
        });
        
        btXoaCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblCTKM.getSelectedRow();
                if(i >= 0)
                {
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn xóa thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION)
                    {
                        if(data.DeleteCTKM((String) tblCTKM.getValueAt(i, 0), (String) tblCTKM.getValueAt(i, 1))){
                            modelCTKM.removeRow(i);
                            tblCTKM.setModel(modelCTKM);
                            JOptionPane.showMessageDialog(frame, "Xóa thành công !!!");
                        }
                        else{
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
                    txMaKM.requestFocus();
                }
            }
        });
        btCapNhatCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tblCTKM.getSelectedRow();
                if(i >= 0)
                {
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn cập nhật thông tin này ?", "Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        ChiTietCTKM ctkm = new ChiTietCTKM();
                        ctkm.setMaKM(txMaKMCT.getText());
                        ctkm.setMaMon(txMaMon.getText());
                        ctkm.setGG(Double.parseDouble(txGG.getText()));
                        if(data.UpdateCTKM(ctkm, (String) tblCTKM.getValueAt(i, 0), (String) tblCTKM.getValueAt(i, 1))){
                            ChiTietCTKM old = GetData.dskmct.set(i,ctkm);
                            modelCTKM.setValueAt(ctkm.getMaKM(),i,0);
                            modelCTKM.setValueAt(ctkm.getMaMon(),i,1);
                            modelCTKM.setValueAt(ctkm.getGG(),i,2);
                            tblCTKM.setModel(modelCTKM);
                            txMaKMCT.setText("");
                            txMaMon.setText("");
                            txGG.setText("");
                            txMaKMCT.requestFocus();
                            txMaKMCT.setEditable(true);
                        }
                    }
                }
            }
        });
        btThemCT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txMaKMCT.getText().equals("")){
                    if(!txMaMon.getText().equals("")){
                        if(!txGG.getText().equals("")){
                            ChiTietCTKM ctkm = new ChiTietCTKM();
                            ctkm.setMaKM(txMaKMCT.getText());
                            ctkm.setMaMon(txMaMon.getText());
                            ctkm.setGG(Double.parseDouble(txGG.getText()));
                            if(data.InsertCTKM(ctkm)){
                                modelCTKM.addRow(new String[] {ctkm.getMaKM(), ctkm.getMaMon(), String.valueOf(ctkm.getGG())});
                                JOptionPane.showMessageDialog(frame, "Thêm thành công chi tiết !", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                                txMaKMCT.setText("");
                                txMaMon.setText("");
                                txGG.setText("");
                                txMaKMCT.requestFocus();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(frame,"Không được để trống % !","Thông báo",JOptionPane.ERROR_MESSAGE);
                            txGG.requestFocus();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,"Không được để trống mã món ăn !","Thông báo",JOptionPane.ERROR_MESSAGE);
                        txMaMon.requestFocus();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Không được để trống mã khuyến mãi !","Thông báo",JOptionPane.ERROR_MESSAGE);
                    txMaKMCT.requestFocus();
                }
            }
        });
        
        
        txMaKM.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txTenCT.requestFocus();
                }
            }
        });
        txTenCT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txNgayBD.requestFocus();
                }
            }
        });
        txNgayBD.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txNgayKT.requestFocus();
                }
            }
        });
        txNgayKT.addKeyListener(new KeyAdapter() {
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
