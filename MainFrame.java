package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import DTO.*;

public class MainFrame {
    JFrame frame;
    JLabel lbName, lbTitle;
    JPanel pBG;
    JButton btHD, btKM, btNV, btSP, btNCC, btPNH, btKH, btNL, btL, btDX;
    public MainFrame(){
        frame = new JFrame();
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(1000,500);
        frame.setBackground(new Color(0,0,0,0));
       
        pBG = new RoundedPanel(100, Color.lightGray);
        pBG.setOpaque(false);
        pBG.setBounds(0,0,1000,500);
        pBG.setLayout(null);

        lbName = new JLabel("Các Chức Năng Quản Lý");
        lbName.setForeground(Color.WHITE);
        lbName.setFont(new Font("Courier New", Font.ITALIC, 30));
        lbTitle = new JLabel("Black && White");
        lbTitle.setForeground(Color.BLACK);
        lbTitle.setFont(new Font("Courier New", Font.ITALIC, 20));
        lbTitle.setBounds(20,10,200,50);
        lbName.setBounds(300,50,400,50);
        pBG.add(lbName);
        pBG.add(lbTitle);
        
        btHD = new JButton("Hóa Đơn");
        btHD.setBorder(BorderFactory.createEmptyBorder());
        btHD.setBackground(new Color(29,47,219));
        btHD.setFont(new Font("Arial", Font.ITALIC, 14));
        btHD.setForeground(Color.WHITE);
        btSP = new JButton("Sản Phẩm");
        btSP.setBorder(BorderFactory.createEmptyBorder());
        btSP.setBackground(new Color(29,47,219));
        btSP.setFont(new Font("Arial", Font.ITALIC, 14));
        btSP.setForeground(Color.WHITE);
        btKM = new JButton("Chương trình khuyến mãi");
        btKM.setBorder(BorderFactory.createEmptyBorder());
        btKM.setBackground(new Color(29,47,219));
        btKM.setFont(new Font("Arial", Font.ITALIC, 14));
        btKM.setForeground(Color.WHITE);
        btNV = new JButton("Nhân viên");
        btNV.setBorder(BorderFactory.createEmptyBorder());
        btNV.setBackground(new Color(29,47,219));
        btNV.setFont(new Font("Arial", Font.ITALIC, 14));
        btNV.setForeground(Color.WHITE);
        btNCC = new JButton("Nhà Cung Cấp");
        btNCC.setBorder(BorderFactory.createEmptyBorder());
        btNCC.setBackground(new Color(29,47,219));
        btNCC.setFont(new Font("Arial", Font.ITALIC, 14));
        btNCC.setForeground(Color.WHITE);
        btPNH = new JButton("Phiếu Nhập Hàng");
        btPNH.setBorder(BorderFactory.createEmptyBorder());
        btPNH.setBackground(new Color(29,47,219));
        btPNH.setFont(new Font("Arial", Font.ITALIC, 14));
        btPNH.setForeground(Color.WHITE);
        btKH = new JButton("Khách Hàng Thân Thiết");
        btKH.setBorder(BorderFactory.createEmptyBorder());
        btKH.setBackground(new Color(29,47,219));
        btKH.setFont(new Font("Arial", Font.ITALIC, 14));
        btKH.setForeground(Color.WHITE);
        btL = new JButton("Loại");
        btL.setBorder(BorderFactory.createEmptyBorder());
        btL.setBackground(new Color(29,47,219));
        btL.setFont(new Font("Arial", Font.ITALIC, 14));
        btL.setForeground(Color.WHITE);
        btNL = new JButton("Nguyên Liệu");
        btNL.setBorder(BorderFactory.createEmptyBorder());
        btNL.setBackground(new Color(29,47,219));
        btNL.setFont(new Font("Arial", Font.ITALIC, 14));
        btNL.setForeground(Color.WHITE);
        btDX = new JButton("Đăng Xuất");
        btDX.setBackground(Color.lightGray);
        btDX.setBorder(BorderFactory.createEmptyBorder());
        btHD.setBounds(100,150, 200,50);
        btKM.setBounds(400,150, 200,50);
        btNV.setBounds(700,150, 200,50);
        btSP.setBounds(100,250,200,50);
        btNCC.setBounds(400,250,200,50);
        btPNH.setBounds(700,250,200,50);
        btKH.setBounds(100,350,200,50);
        btNL.setBounds(400,350,200,50);
        btL.setBounds(700,350,200,50);
        btDX.setBounds(880,20,100,20);
        pBG.add(btHD);
        pBG.add(btKM);
        pBG.add(btNV);
        pBG.add(btSP);
        pBG.add(btNCC);
        pBG.add(btPNH);
        pBG.add(btKH);
        pBG.add(btNL);
        pBG.add(btL);
        pBG.add(btDX);
        frame.add(pBG);
        
        btHD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new DS_HD();
                frame.hide();
               
            }
        });
        btKM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new DS_CTKM();
                frame.hide();
            }
        });
        btSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new DS_SP();
                frame.hide();
            }
        });
        
        btDX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn đăng xuất ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION) {
                    new Login();
                    frame.hide();
                }
            }
        });

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
