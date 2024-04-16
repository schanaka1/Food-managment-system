/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Anushan Dharmarathna
 */
public class OpenPdf {
    public static void openById(String id){
        try{
            if ((new File("C:\\Users\\Anushan Dharmarathna\\OneDrive\\Documents\\NetBeansProjects\\Food Management System\\Bill\\"+id+".pdf")).exists()){
                Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\Anushan Dharmarathna\\OneDrive\\Documents\\NetBeansProjects\\Food Management System\\Bill\\"+id+".pdf");
                
            }
            else
                JOptionPane.showInputDialog(null, "File is not Exists");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
