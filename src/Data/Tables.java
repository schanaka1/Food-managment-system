/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import javax.swing.JOptionPane;

/**
 *
 * @author Anushan Dharmarathna
 */
public class Tables {

    public static void main(String[] args) {
        try {
            String userTable = "create table user(id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200),"
                    + "mobileNumber varchar (10), password varchar(50), status varchar(20), UNIQUE(email))";
            String adminDetails = "insert into user(name,email,mobileNumber,password,status) values('Admin','admin@email.com','0000000000','12345','true')";
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key, category varchar(200))";
            String productTable = "create table product(id int AUTO_INCREMENT primary key, name varchar(200), category varchar(200), price varchar(100))";
            String billTable = "create table bill(id int primary key, name varchar(200), mobileNumber varchar(10), email varchar(200), date varchar(50), total varchar(200), createdBy varchar(200))";
            DatabaseOperations.setDataorDelete(userTable, "User Table Created Successfully");
            DatabaseOperations.setDataorDelete(adminDetails, "Admin Details Added Successfully");
            DatabaseOperations.setDataorDelete(categoryTable, "Category Table Created Successfully");
            DatabaseOperations.setDataorDelete(productTable, "Product Table Created Successfully");
            DatabaseOperations.setDataorDelete(billTable, "Bill Table Created Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
