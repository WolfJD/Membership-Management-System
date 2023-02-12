/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author janid
 */

public class db {
    public static Connection createConnection() throws Exception{
            String url="jdbc:mysql://localhost:3306/eadcw2?autoReconnect=true&useSSL=false";
            Connection con=DriverManager.getConnection(url,"root","");
        return con;  
    }
    public static boolean login(String email, String pass){
        try
        {
            String query = "select password from user where email='"+email+"';";
            Statement st = createConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
                    {
                        String password = rs.getString("password");
                        if (pass.equals(password))
                            return true;
                    }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Incorrect Email or Password");
        return false;
    }
    public static boolean insertData(String query){
        try {
            PreparedStatement preparedStmt = createConnection().prepareStatement(query);
            preparedStmt.execute();
            createConnection().close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Registration Failed\n"+e);
            return false;
        }
        return true;
    }
    public static String getData(String email, String required, String from){
        try
        {
            String query = "select "+required+" from "+from+" where email='"+email+"';";
            Statement st = createConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            String request;
            while (rs.next())
                    {
                        request = rs.getString(required);
                        return request;
                    }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    public static ResultSet selectAll(){
        try{
            String query = "select * from member;";
            Statement st = createConnection().createStatement();
            return st.executeQuery(query);
            /*while(rs.next()){
                memberdetails.id = rs.getString("mid");
                memberdetails.nic = rs.getString("NIC");
                memberdetails.fname = rs.getString("FirstName");
                memberdetails.lname = rs.getString("LastName");
                memberdetails.tp = rs.getString("TP");
                memberdetails.address = rs.getString("Email");
                memberdetails.gender = rs.getString("Gender");
            }*/
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public static ResultSet search1(String query){
        try{
            Statement st = createConnection().createStatement();
            return st.executeQuery(query);
            
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public static void search(String query){
        try{
            Statement st = createConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                memberdetails.id = rs.getString("mid");
                memberdetails.nic = rs.getString("NIC");
                memberdetails.fname = rs.getString("FirstName");
                memberdetails.lname = rs.getString("LastName");
                memberdetails.tp = rs.getString("TP");
                memberdetails.address = rs.getString("Address");
                memberdetails.email = rs.getString("Email");
                memberdetails.gender = rs.getString("Gender");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static boolean updatedelete(String query){
        try {
            PreparedStatement preparedStmt = createConnection().prepareStatement(query);
            preparedStmt.execute();
            createConnection().close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Failed\n"+e);
            return false;
        }
        return true;
    }
}
