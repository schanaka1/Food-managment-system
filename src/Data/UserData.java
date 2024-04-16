/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Codes.User;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Anushan Dharmarathna
 */
public class UserData {
    public static void save(User user){
        String query = "insert into user(name,email,mobileNumber,password,status) values"
                + "('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getPassword()+"','false')";
        DatabaseOperations.setDataorDelete(query, "Registered Successfully! Wait for Admin Approval!");
    }
    
    public static User login(String email, String password){
        User user = null;
        try{
            ResultSet rs = DatabaseOperations.getData("select *from user where email='"+email+"' and password='"+password+"'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("Status"));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DatabaseOperations.getData("select *from user where email like '%"+email+"%'");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void changeStatus(String email, String status){
        String query = "update user set status = '"+status+"' where email ='"+email+"'";
        DatabaseOperations.setDataorDelete(query, "Status changed successfully");
    }
    
    public static void update(String email, String newPassword){
        String query = "update user set password = '" + newPassword + "' where email='" + email + "'";
        DatabaseOperations.setDataorDelete(query, "Password Changed Successfully");
    }
    
    public static void changePassword(String email,String oldPassword,String newPassword){
        try{
            ResultSet rs = DatabaseOperations.getData("select *from user where email='"+email+"' and password='"+oldPassword+"'");
            if(rs.next()){
                update(email, newPassword);
            }
            else{
                JOptionPane.showMessageDialog(null, "Old Password is Wrong!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
