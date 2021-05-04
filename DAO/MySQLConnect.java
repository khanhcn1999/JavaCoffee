/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class MySQLConnect {
    String host="localhost";
    String username="root";
    String password="";
    String database;
    
    Connection connect=null;
    Statement statement=null;
    ResultSet result=null;
    
    public MySQLConnect(String database) {
        this.database = database+"?useUnicode=true&characterEncoding=UTF-8";
    }
    
    public MySQLConnect(String host, String username, String password, String database){
        this.database=database;
        this.host=host;
        this.password=password;
        this.username=username;
    }
    protected void driverTest() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e){
            throw new Exception("MySQL JDBC Driver not found!");
            
        }
    }
    public Connection getConnect() throws Exception{
        if(this.connect==null){
            driverTest();
            String url="jdbc:mysql://"+this.host+":3306/"+this.database;
            try{
                this.connect=DriverManager.getConnection(url, this.username, this.password);
                
            }
            catch(java.sql.SQLException e){
                throw new Exception("Không thể kết nối đến database Sever."+url);
            }
        }
        return this.connect;
    }
    public Statement getStatement() throws SQLException, Exception{
        if(this.statement==null ? true : this.statement.isClosed()){
            this.statement=this.getConnect().createStatement();
        }
        return this.statement;
    }
    public ResultSet executeQuery(String Query) throws Exception{
        try{
            this.result=getStatement().executeQuery(Query);
        }
        catch (Exception e){
            throw new Exception("ERROR "+e.getMessage()+" - "+Query);
        }
        return this.result;
    }
   
    public void Close() throws Exception{
         if(this.result != null && !this.result.isClosed()){
             this.result.close();
             this.result=null;
         }
         if(this.statement !=null && !this.statement.isClosed()){
             this.statement.close();
             this.statement=null;
         }
         if(this.connect!=null&& !this.connect.isClosed()){
             this.connect.close();
             this.connect=null;
         }
    }

}
