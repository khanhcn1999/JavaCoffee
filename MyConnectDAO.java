package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectDAO {
    private final String className = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/coffee";
    private final String user = "root";
    private final String pass = "";
    private Connection con;
    public MyConnectDAO(){
        
    }
    public Connection connect(){
        try{
            Class.forName(className);
            con = DriverManager.getConnection(url,user,pass);
            System.err.println("Kết nối thành công.");
            return con;
        }   
        catch(ClassNotFoundException ex) {
            System.err.println("Không tìm thấy driver.");
        } catch (SQLException ex) {
            System.err.println("Không kết nối được đến MySQL.");
        }
        return null;
    } 
}
