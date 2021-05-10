package GUI;

import javax.swing.*;

import BUS.NhanVienBUS;
import BUS.TaiKhoanNguoiDungBUS;
import BUS.TheThanhVienBUS;

import java.awt.*;
//import java.awt.desktop.OpenFilesEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;
import DTO.*;

public class Login {
    JFrame frame;
    JTextField txTK;
    JPasswordField txMK;
    JButton btDN, btDK, btX;
    JLabel lbTK, lbMK, lbB, lbW, lb1, lb2,  lbNoValid;
    JLabel Name1, Name2, Name3, Name4;
    JPanel pLeft, pRight;
//    private String user = "admin";
//    private String pass = "admin";
    TaiKhoanNguoiDungBUS bus=new TaiKhoanNguoiDungBUS();
    public Login()
    { 
    	initComponents();
    	if(NhanVienBUS.DSNV==null) {
    		bus.docDSND();
    	}
    }	
    private void initComponents() {
        frame = new JFrame("Login");
        frame.setSize(1000,500);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,0));

        pLeft = new RoundedPanel(50, new Color(155, 207, 243));
        pLeft.setOpaque(false);
        pRight = new RoundedPanel(50, Color.WHITE);
        pLeft.setBounds(30,30,600,400);
        pRight.setBounds(380,50,580,400);
        pLeft.setLayout(null);
        pRight.setLayout(null);
        pRight.setBackground(new Color(0,0,0,0));
        
        Name1 = new JLabel("Châu Ngọc Khanh");
        Name2 = new JLabel("Trần Đăng Khoa");
        Name3 = new JLabel("Lao Gia Hào");
        Name4 = new JLabel("Huỳnh Thị Hồng Chi");
        Name1.setFont(new Font("Arial", Font.ITALIC, 14));
        Name2.setFont(new Font("Arial", Font.ITALIC, 14));
        Name3.setFont(new Font("Arial", Font.ITALIC, 14));
        Name4.setFont(new Font("Arial", Font.ITALIC, 14));
        Name1.setForeground(Color.BLUE);
        Name2.setForeground(Color.BLUE);
        Name3.setForeground(Color.BLUE);
        Name4.setForeground(Color.BLUE);
        Name1.setBounds(30,250,150,20);
        Name2.setBounds(30,280,150,20);
        Name3.setBounds(30,310,150,20);
        Name4.setBounds(30,340,150,20);
        pLeft.add(Name1);
        pLeft.add(Name2);
        pLeft.add(Name3);
        pLeft.add(Name4);
        
        lbB = new JLabel("Beach");
        lbW = new JLabel("House");
        lbB.setForeground(Color.BLUE);
        lbW.setForeground(Color.BLACK);
        lbB.setFont(new Font("Courier New", Font.ITALIC, 40));
        lbW.setFont(new Font("Courier New", Font.ITALIC, 40));
        lbB.setBounds(220,40,400,50);
        lbW.setBounds(8,20,400,50);
        pRight.add(lbW);
        pLeft.add(lbB);
        
        lb1 = new JLabel("Energy = Milk");
        lb2 = new JLabel("pow(Coffee, 2)");
        lb1.setForeground(Color.BLUE);
        lb2.setForeground(Color.BLACK);
        lb1.setFont(new Font("Courier New", Font.ITALIC, 20));
        lb2.setFont(new Font("Courier New", Font.ITALIC, 20));
        lb1.setBounds(190,100,400,50);
        lb2.setBounds(5,80,400,50);
        pLeft.add(lb1);
        pRight.add(lb2); 
        
        btX = new JButton("X");
        btX.setBackground(Color.WHITE);
        btX.setBorder(BorderFactory.createEmptyBorder());
        btX.setBounds(525,20,25,25);
        pRight.add(btX);
        frame.add(pRight);

        txTK = new JTextField();
        txTK.setBackground(Color.WHITE);
        txTK.setForeground(Color.BLACK);
        txTK.setFont(new Font("Arial", Font.ITALIC, 20));
        txTK.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));
        txMK = new JPasswordField();
        txMK.setBackground(Color.WHITE);
        txMK.setForeground(Color.BLACK);
        txMK.setFont(new Font("Arial", Font.ITALIC, 20));
        txMK.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.BLACK));   
        lbTK = new JLabel("Tài khoản");
        lbMK = new JLabel("Mật khẩu");
        lbNoValid = new JLabel();
        lbTK.setFont(new Font("Arial", Font.ITALIC, 18));
        lbTK.setForeground(Color.BLACK);
        lbMK.setFont(new Font("Arial", Font.ITALIC, 18));
        lbMK.setForeground(Color.BLACK);
        lbNoValid.setFont(new Font("Arial", Font.ITALIC, 18));
        lbNoValid.setForeground(Color.red);
        pRight.add(lbTK);
        pRight.add(txTK);
        pRight.add(lbMK);
        pRight.add(txMK);
        pRight.add(lbNoValid);
        lbTK.setBounds(150,175,100,20);
        txTK.setBounds(250,175,200,20);
        lbMK.setBounds(150,225,100,20);
        txMK.setBounds(250,225,200,20);
        lbNoValid.setBounds(200,260,300,20);
        
        btDN = new JButton("Đăng nhập");
        btDN.setBorder(BorderFactory.createEmptyBorder());
        btDN.setForeground(Color.BLUE);
        btDN.setBackground(new Color(155, 207, 243));
        
        btDN.setBounds(250,290,110,30);
        pRight.add(btDN);
        
        frame.add(pRight);
        frame.add(pLeft);

        btX.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
        });
        
        txTK.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    txMK.requestFocus();
                }
            }
        });
        txMK.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btDN.doClick();
                }
            }
        });
        btDN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String username, passwd, cfmPasswd;
                username=txTK.getText();
                passwd=String.valueOf(txMK.getPassword());
                if(username.equals("")){
                    lbNoValid.setText("Vui lòng nhập username!");
                    txTK.requestFocus();
                    return;
                } else if(passwd.equals("")) {
                            lbNoValid.setText("Vui lòng nhập password!");
                            txMK.requestFocus();
                            return;
                		}
                for(TaiKhoanNguoiDungDTO user : TaiKhoanNguoiDungBUS.DSND){
                    if(username.equals(String.valueOf(user.getUsername()))) {
                        if(passwd.equals(user.getPassword())) {
                        	JOptionPane.showMessageDialog(frame,"Đăng nhập thành công","Thông báo",JOptionPane.PLAIN_MESSAGE);
                    		new MainFrame();
                    		frame.hide();
                    		return;
                        } else lbNoValid.setText("Mật khẩu không đúng.");
                    }
                }
            	JOptionPane.showMessageDialog(frame,"Không tìm thấy tài khoản.","Thông báo",JOptionPane.PLAIN_MESSAGE);
            	txTK.requestFocus();
//                if(txTK.getText().equals("") || txMK.getPassword().equals(""))
//                {
//                    JOptionPane.showMessageDialog(frame,"Ä�iá»�n thÃ´ng tin tÃ i khoáº£n","Thông báo",JOptionPane.ERROR_MESSAGE);
//                    txTK.requestFocus();
//                }
//                else if(!txTK.getText().equals(user) || !txMK.getText().equals(pass))
//                {
//                    JOptionPane.showMessageDialog(frame,"Sai thÃ´ng tin tÃ i khoáº£n hoáº·c máº­t kháº©u","Thông báo",JOptionPane.ERROR_MESSAGE);
//                    txTK.requestFocus();
//                }
//                else if(txTK.getText().equals(user) && txMK.getText().equals(pass))
//                {
//                    JOptionPane.showMessageDialog(frame,"Ä�Äƒng nháº­p thÃ nh cÃ´ng","Thông báo",JOptionPane.PLAIN_MESSAGE);
//                    new MainFrame();
//                    frame.hide();
//                }
            }
        });
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Login();
    } 
}
