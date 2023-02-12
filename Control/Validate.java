/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Model.logindetails;
import Model.memberdetails;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author janid
 */
public class Validate {
    public static boolean numbersonly(String check){
        for (int i = 0; i<check.length();i++){
            if (!Character.isDigit(check.charAt(i)))
                return true;
        }
        return false;
    }
    public static boolean lettersonly(String check){
        for (int i = 0; i<check.length();i++){
            if (Character.isDigit(check.charAt(i)))
                return true;
        }
        return false;
    }
    public static boolean emailcheck(String check){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(check);
        return !matcher.matches();
    }
    public static boolean passwordCheck(String check){
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(check);
        return !matcher.matches();
    }
    public static void FocusLost(String check){
        if (check.isEmpty())
            JOptionPane.showMessageDialog(null, "Invalid Entry");
    }
    public static boolean registerValidate(){
        if (logindetails.fname.isEmpty())
            JOptionPane.showMessageDialog(null, "Please insert an First Name");
        else if (Validate.lettersonly(logindetails.fname))
            JOptionPane.showMessageDialog(null, "First Name can only have letters");
        else if (logindetails.lname.isEmpty())
            JOptionPane.showMessageDialog(null, "Please insert a Last Name");
        else if (Validate.lettersonly(logindetails.lname))
            JOptionPane.showMessageDialog(null, "Last Name can only have letters");
        else if (logindetails.email.isEmpty())
            JOptionPane.showMessageDialog(null, "Please insert an Email");
        else if (Validate.emailcheck(logindetails.email))
            JOptionPane.showMessageDialog(null, "Please enter a valid email");
        else if (logindetails.pass.isEmpty())
            JOptionPane.showMessageDialog(null, "Please insert a password");
        else if (Validate.passwordCheck(logindetails.pass))
            JOptionPane.showMessageDialog(null, "Invalid Password\n" + "Must have at least one numeric character\n" + "Must have at least one lowercase character\n" + "Must have at least one uppercase character\n" + "Must have at least one special symbol among @#$%\n" + "Password length should be between 8 and 20");
        else if (!logindetails.repass.equals(logindetails.pass))
            JOptionPane.showMessageDialog(null, "Passwords dont match");
        else
            return true;
        return false;
    }
    public static boolean memberValidate(){
        if (memberdetails.nic.isEmpty())
            JOptionPane.showMessageDialog(null, "Please insert a NIC number");
        else if (memberdetails.fname.isEmpty())
            JOptionPane.showMessageDialog(null, "Please insert a First Name");
        else if (Validate.lettersonly(memberdetails.fname))
            JOptionPane.showMessageDialog(null, "First Name can only have letters");
        else if (memberdetails.lname.isEmpty())
            JOptionPane.showMessageDialog(null, "Please insert a Last Name");
        else if (Validate.lettersonly(memberdetails.lname))
            JOptionPane.showMessageDialog(null, "Last Name can only have letters");
        else if (memberdetails.tp.isEmpty())
            JOptionPane.showMessageDialog(null, "Please insert a Telephone Number");
        else if (Validate.numbersonly(memberdetails.tp))
            JOptionPane.showMessageDialog(null, "TP can only have numbers\n 07XXXXXXXX");
        else if (memberdetails.address.isEmpty())
            JOptionPane.showMessageDialog(null, "Please insert an Address");
        else if (memberdetails.email.isEmpty())
            JOptionPane.showMessageDialog(null, "Please insert an Email");
        else if (Validate.emailcheck(memberdetails.email))
            JOptionPane.showMessageDialog(null, "Please enter a valid email");
        else if (memberdetails.gender==null)
            JOptionPane.showMessageDialog(null, "Please select a gender");
        else if (!(memberdetails.gender.equals("Male")||memberdetails.gender.equals("Female")))
            JOptionPane.showMessageDialog(null, "Invalid Gender");
        else
            return true;
        return false;
    }
}
