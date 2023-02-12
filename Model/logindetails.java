/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author janid
 */
public class logindetails {
    public static String email;
    public static String fname;
    public static String lname;
    public static String pass;
    public static String repass;
    
    public static void regdetails(String email,String fname,String lname,String pass,String repass){
        logindetails.fname=fname;
        logindetails.lname=lname;
        logindetails.email=email;
        logindetails.pass=pass;
        logindetails.repass=repass;
    }
    public static void logDetails(String email,String pass){
        logindetails.email=email;
        logindetails.pass=pass;
        logindetails.fname=db.getData(email, "FirstName", "user");
        logindetails.lname=db.getData(email, "LastName", "user");
        logindetails.repass=null;
    }
}
