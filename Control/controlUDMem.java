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
public class controlUDMem {
    public static boolean search(String id){
        try{
            if (!id.isEmpty()){
                memberdetails.details("", "", "", "", "", "", "", "");
                db.search("select * from member where mid ='"+id+"';");
                return true;
            }
            return false;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error\n"+e);
            return false;
        }
    }
    public static boolean update(){
        try{
            if (Validate.memberValidate()){
                String query = "update member SET NIC='"+memberdetails.nic+"',FirstName='"+memberdetails.fname+"',LastName='"+memberdetails.lname+"',TP='"+memberdetails.tp+"',Address='"+memberdetails.address+"',Email='"+memberdetails.email+"', Gender='"+memberdetails.gender+"' where mid='"+memberdetails.id+"'";
                db.updatedelete(query);
                JOptionPane.showMessageDialog(null, "Update Successful");
                return true;
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }
    public static boolean delete(){
        try{
            if (!memberdetails.nic.isEmpty()){
                String query = "Delete from member where mid='"+memberdetails.id+"'";
                db.updatedelete(query);
                JOptionPane.showMessageDialog(null, "Deletion Successful");
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "No data to delete");
                return false;
            }
        }
        catch(Exception e){
            return false;
        }
    }
}
