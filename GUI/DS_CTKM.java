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
    DefaultTableModel modelKM;
    
    JButton btXoa, btCapNhat, btThem, btThoat;
    JTextField txMaKM, txTenCT, txGG, txNgayBD, txNgayKT, txTimKiemKM;
    JLabel lbMaKM, lbTenCT, lbGG, lbNgayBD, lbNgayKT, lbTimKiemKM;
    
    JComboBox cb;
    
    JTable tblKM;
    JPanel pKM, pBG;
    
    GetData data = new GetData();
    
    public DS_CTKM()
    {
        frame.setSize(1250,500);
        frame.setLayout(null);
        frame.setUndecorated(true);

        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        pKM = new JPanel();
        pKM.setBackground(new Color(155, 207, 243));
        pKM.setLayout(null);
        pKM.setBounds(0,0,1250,100);
        pKM.setBorder(BorderFactory.createTitledBorder(blackBorder, "  Chương Trình Khuyến Mãi  ",TitledBorder.CENTER, TitledBorder.BOTTOM));
        pBG = new JPanel();
        pBG.setBackground(new Color(255,251,164));
        pBG.setLayout(null);
        pBG.setBounds(0,0,1250,700);
        
// Chương Trình Khuyến Mãi

        String c[] = {"Mã khuyến mãi", "Tên chương trình"};
        cb = new JComboBox(c);
        cb.setBounds(300,120,140,20);
        pBG.add(cb);
        
        txMaKM = new JTextField();
        txTenCT = new JTextField();
        txGG = new JTextField();
        txNgayBD = new JTextField();
        txNgayKT = new JTextField();
        txTimKiemKM = new JTextField();
        lbMaKM = new JLabel("Mã khuyến mãi");
        lbTenCT = new JLabel("Tên chương trình");
        lbGG = new JLabel("Giảm giá");
        lbNgayBD = new JLabel("Ngày bắt đầu");
        lbNgayKT = new JLabel("Ngày kết thúc");
        lbTimKiemKM = new JLabel("Tìm Kiếm");
        lbTimKiemKM.setFont(new Font("Arial", Font.ITALIC, 16));
        lbTimKiemKM.setBounds(20, 120, 120, 20);
        txTimKiemKM.setBounds(100, 120, 200, 20);
        lbMaKM.setBounds(100,20,100,20);
        txMaKM.setBounds(200,20,120,20);    
        lbTenCT.setBounds(400,20,120,20);
        txTenCT.setBounds(520,20,120,20); 
        lbGG.setBounds(700,20,80,20);
        txGG.setBounds(770,20,120,20);
        lbNgayBD.setBounds(100,60,100,20);
        txNgayBD.setBounds(200,60,120,20);  
        lbNgayKT.setBounds(400,60,100,20);
        txNgayKT.setBounds(520,60,120,20);
        pKM.add(lbMaKM);
        pKM.add(txMaKM);
        pKM.add(lbTenCT);
        pKM.add(txTenCT);
        pKM.add(lbGG);
        pKM.add(txGG);
        pKM.add(lbNgayBD);
        pKM.add(txNgayBD);
        pKM.add(lbNgayKT);
        pKM.add(txNgayKT);
        pBG.add(lbTimKiemKM);
        pBG.add(txTimKiemKM);

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
        pBG.add(pKM);
        
        modelKM = new DefaultTableModel();
        tblKM = new JTable();
        JScrollPane jcKM = new JScrollPane();
        jcKM.setViewportView(tblKM);
        modelKM.addColumn("Mã khuyến mãi");
        modelKM.addColumn("Tên chương trình khuyến mãi");
        modelKM.addColumn("% Giảm giá");
        modelKM.addColumn("Ngày bắt đầu");
        modelKM.addColumn("Ngày kết thúc");
        jcKM.setBounds(20,160,1200,220);
        pBG.add(jcKM);
        if(GetData.dsctkm == null){
            data.LoadKM();
        }
        for(ChuongTrinhKhuyenMai ctkm: GetData.dsctkm){
            modelKM.addRow(new String[] {ctkm.getMaKM(), ctkm.getTenCT(), String.valueOf(ctkm.getGG()), ctkm.getNgayBD(), ctkm.getNgayKT()});
        }        
        tblKM.setModel(modelKM);
        
        frame.add(pBG);

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
                        if(!txGG.getText().equals("")){
                            if(!txNgayBD.getText().equals("")){
                                if(!txNgayKT.getText().equals("")){
                                    ChuongTrinhKhuyenMai ctkm = new ChuongTrinhKhuyenMai();
                                    ctkm.setMaKM(txMaKM.getText());
                                    ctkm.setTenCT(txTenCT.getText());
                                    ctkm.setGG(Double.parseDouble(txGG.getText()));
                                    ctkm.setNgayBD(txNgayBD.getText());
                                    ctkm.setNgayKT(txNgayKT.getText());
                                    if(data.InsertKM(ctkm)){
                                        modelKM.addRow(new String[] {ctkm.getMaKM(), ctkm.getTenCT(), String.valueOf(ctkm.getGG()), ctkm.getNgayBD(), ctkm.getNgayKT()});
                                        JOptionPane.showMessageDialog(frame,"Thêm thành công", "Thông báo", JOptionPane.PLAIN_MESSAGE);
                                        tblKM.setModel(modelKM);
                                        txMaKM.setText("");
                                        txTenCT.setText("");
                                        txGG.setText("");
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
                            JOptionPane.showMessageDialog(frame,"Phải điền % giảm giá","Thông báo",JOptionPane.ERROR_MESSAGE);
                            txGG.requestFocus();
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
                            txGG.setText("");
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
                        ctkm.setGG(Double.parseDouble(txGG.getText()));
                        ctkm.setNgayBD(txNgayBD.getText());
                        ctkm.setNgayKT(txNgayKT.getText());
                        if(data.UpdateKM(ctkm, (String) tblKM.getValueAt(i, 0))){
                        	JOptionPane.showMessageDialog(frame,"Cập nhật thành công","Thông báo",JOptionPane.PLAIN_MESSAGE);
                            ChuongTrinhKhuyenMai old = GetData.dsctkm.set(i,ctkm);
                            modelKM.setValueAt(ctkm.getMaKM(),i,0);
                            modelKM.setValueAt(ctkm.getTenCT(),i,1);
                            modelKM.setValueAt(ctkm.getGG(),i,2);
                            modelKM.setValueAt(ctkm.getNgayBD(),i,3);
                            modelKM.setValueAt(ctkm.getNgayKT(),i,4);
                            tblKM.setModel(modelKM);
                            txMaKM.setText("");
                            txTenCT.setText("");
                            txGG.setText("");
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
            		
            		frame.setVisible(false);
                    
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
                    txGG.setText(String.valueOf(modelKM.getValueAt(i,2)));
                    txNgayBD.setText(String.valueOf(modelKM.getValueAt(i,3)));
                    txNgayKT.setText(String.valueOf(modelKM.getValueAt(i,4)));
                    btThem.setEnabled(false);
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
                    txGG.requestFocus();
                }
            }
        });
        txGG.addKeyListener(new KeyAdapter() {
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
