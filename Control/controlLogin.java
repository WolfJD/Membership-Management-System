/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.db;
import Model.logindetails;
import View.MainMenu;
import javax.swing.JOptionPane;

/**
 *
 * @author janid
 */
public class controlLogin {
    public static void registerClick(){
        if (Validate.registerValidate()){
            boolean check = db.insertData("insert into user values ('"+logindetails.fname+"','"+logindetails.lname+"','"+logindetails.email+"','"+logindetails.pass+"');");
            if (check)
                JOptionPane.showMessageDialog(null, "Registered Successfully");
        }
    }
    public static boolean loginClick(){
        boolean check = db.login(logindetails.email,logindetails.pass);
        if (check)
        {
            new MainMenu().setVisible(true);
            return true;
        }
        return false;
    }
}
