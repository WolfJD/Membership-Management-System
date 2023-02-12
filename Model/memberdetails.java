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
public class memberdetails {
    public static String id;
    public static String nic;
    public static String fname;
    public static String lname;
    public static String tp;
    public static String address;
    public static String email;
    public static String gender;
    
    public static void regdetails(String nic, String fname, String lname, String tp, String address, String email, String gender){
        memberdetails.nic = nic;
        memberdetails.fname = fname;
        memberdetails.lname = lname;
        memberdetails.tp = tp;
        memberdetails.address = address;
        memberdetails.email = email;
        memberdetails.gender = gender;
    }
    public static void details(String id,String nic, String fname, String lname, String tp, String address, String email, String gender){
        memberdetails.id = id;
        memberdetails.nic = nic;
        memberdetails.fname = fname;
        memberdetails.lname = lname;
        memberdetails.tp = tp;
        memberdetails.address = address;
        memberdetails.email = email;
        memberdetails.gender = gender;
    }
}
