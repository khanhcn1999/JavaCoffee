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
       
        pBG = new JPanel();
        pBG.setBackground(new Color(255,251,164));
        pBG.setBounds(0,0,1000,500);
        pBG.setLayout(null);

        lbName = new JLabel("Các Chức Năng Quản Lý");
        lbName.setForeground(Color.BLUE);
        lbName.setFont(new Font("Courier New", Font.ITALIC, 30));
        lbTitle = new JLabel("Blue && White");
        lbTitle.setForeground(Color.BLUE);
        lbTitle.setFont(new Font("Courier New", Font.ITALIC, 24));
        lbTitle.setBounds(20,10,200,50);
        lbName.setBounds(300,70,400,50);
        pBG.add(lbName);
        pBG.add(lbTitle);
        
        btHD = new JButton("Hóa Đơn");
        btHD.setBorder(BorderFactory.createEmptyBorder());
        btHD.setBackground(new Color(155, 207, 243));
        btHD.setFont(new Font("Arial", Font.ITALIC, 14));
        btHD.setForeground(Color.BLUE);
        
        btSP = new JButton("Sản Phẩm");
        btSP.setBorder(BorderFactory.createEmptyBorder());
        btSP.setBackground(new Color(155, 207, 243));
        btSP.setFont(new Font("Arial", Font.ITALIC, 14));
        btSP.setForeground(Color.BLUE);
        
        btKM = new JButton("Chương trình khuyến mãi");
        btKM.setBorder(BorderFactory.createEmptyBorder());
        btKM.setBackground(new Color(155, 207, 243));
        btKM.setFont(new Font("Arial", Font.ITALIC, 14));
        btKM.setForeground(Color.BLUE);
      
        btNV = new JButton("Nhân viên");
        btNV.setBorder(BorderFactory.createEmptyBorder());
        btNV.setBackground(new Color(155, 207, 243));
        btNV.setFont(new Font("Arial", Font.ITALIC, 14));
        btNV.setForeground(Color.BLUE);
        
        btNCC = new JButton("Nhà Cung Cấp");
        btNCC.setBorder(BorderFactory.createEmptyBorder());
        btNCC.setBackground(new Color(155, 207, 243));
        btNCC.setFont(new Font("Arial", Font.ITALIC, 14));
        btNCC.setForeground(Color.BLUE);
        
        btPNH = new JButton("Phiếu Nhập Hàng");
        btPNH.setBorder(BorderFactory.createEmptyBorder());
        btPNH.setBackground(new Color(155, 207, 243));
        btPNH.setFont(new Font("Arial", Font.ITALIC, 14));
        btPNH.setForeground(Color.BLUE);
        
        btKH = new JButton("Khách Hàng Thân Thiết");
        btKH.setBorder(BorderFactory.createEmptyBorder());
        btKH.setBackground(new Color(155, 207, 243));
        btKH.setFont(new Font("Arial", Font.ITALIC, 14));
        btKH.setForeground(Color.BLUE);
        
        btL = new JButton("Loại");
        btL.setBorder(BorderFactory.createEmptyBorder());
        btL.setBackground(new Color(155, 207, 243));
        btL.setFont(new Font("Arial", Font.ITALIC, 14));
        btL.setForeground(Color.BLUE);
        
        btNL = new JButton("Nguyên Liệu");
        btNL.setBorder(BorderFactory.createEmptyBorder());
        btNL.setBackground(new Color(155, 207, 243));
        btNL.setFont(new Font("Arial", Font.ITALIC, 14));
        btNL.setForeground(Color.BLUE);
        
        btDX = new JButton("Đăng Xuất");
        btDX.setBackground(new Color(255,251,164));
        btDX.setFont(new Font("Arial", Font.ITALIC, 14));
        btDX.setBorder(BorderFactory.createEmptyBorder());
        btDX.setForeground(Color.BLUE);
        
        btHD.setBounds(100,170, 200,50);
        btKM.setBounds(400,170, 200,50);
        btNV.setBounds(700,170, 200,50);
        btSP.setBounds(100,270,200,50);
        btNCC.setBounds(400,270,200,50);
        btPNH.setBounds(700,270,200,50);
        btKH.setBounds(100,370,200,50);
        btNL.setBounds(400,370,200,50);
        btL.setBounds(700,370,200,50);
        btDX.setBounds(880,20,100,40);
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
                frame.setVisible(false);
                new DS_HD();
            }
        });
        btKM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new DS_CTKM();
            }
        });
        btNV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new DS_NV();
            }
        });
        btKH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new DS_TTV();
            }
        });
        btSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new DS_SP();
            }
        });
        btNCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new DS_NCC();
            }
        });
        btPNH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new DS_PNH();
            }
        });
        btNL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new DS_NL();
            }
        });
        btL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new DS_L();
            }
        });
        
        btDX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(frame,"Bạn có chắc muốn đăng xuất ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION) {
                    frame.setVisible(false);
                    new Login();
                }
            }
        });

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
