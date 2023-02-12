/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.db;
import Model.memberdetails;
import javax.swing.JOptionPane;

/**
 *
 * @author janid
 */
public class controlMemberReg {
    public static void registerClick(){
        try{
            if (Validate.memberValidate()){
                boolean check = db.insertData("insert into member (NIC,FirstName,LastName,TP,Address,Email,Gender) values ('"+memberdetails.nic+"','"+memberdetails.fname+"','"+memberdetails.lname+"','"+memberdetails.tp+"','"+memberdetails.address+"','"+memberdetails.email+"','"+memberdetails.gender+"');");
                JOptionPane.showMessageDialog(null, "Member Registered");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error\n"+e);
        }
    }
}
