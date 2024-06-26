/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.management.system;

import Codes.Bill;
import Codes.Category;
import Codes.Product;
import Common.OpenPdf;
import Data.BillData;
import Data.CategoryData;
import Data.ProductData;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Anushan Dharmarathna
 */
public class PlaceOrder extends javax.swing.JFrame {

    public int billId = 1;
    public int grandTotal = 0;
    public int productPrice = 0;
    public int productTotal = 0;
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^[0-9]*$";
    public String userEmail;

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();
    }

    public PlaceOrder(String email) {
        initComponents();
        textProName.setEditable(false);
        textProPrice.setEditable(false);
        textProTotal.setEditable(false);
        btnAddToCart.setEnabled(false);
        btnPrint.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        tf.setEditable(false);
        userEmail = email;
    }

    public void productNameByCategory(String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductData.getAllRecordsByCategory(category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }

    public void filterProductByname(String name, String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductData.filterProductByname(name, category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }
    
    public void clearProductFields(){
        textProName.setText("");
        textProPrice.setText("");
        jSpinner1.setValue(1);
        textProTotal.setText("");
        btnAddToCart.setEnabled(false);
    }
    
    public void validateField(){
        String customerName = textCusName.getText();
        String customerMobileNumber = textCusMobileNo.getText();
        String customerEmail = textCusEmail.getText();
        if(!customerEmail.equals("") && customerMobileNumber.matches(mobileNumberPattern) && customerMobileNumber.length()==10 && customerEmail.matches(emailPattern) && grandTotal>0){
            btnPrint.setEnabled(true);
        }
        else{
            btnPrint.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textCusName = new javax.swing.JTextField();
        textCusEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textCusMobileNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textProName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        textProPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textProTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        labelGTotal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(85, 40));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MiniOrder.png"))); // NOI18N
        jLabel1.setText("Place Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Bill ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 74, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Coustomer Details:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 146, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Mobile Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 226, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 302, -1, -1));

        textCusName.setBackground(java.awt.SystemColor.controlHighlight);
        textCusName.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        textCusName.setForeground(new java.awt.Color(0, 0, 0));
        textCusName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCusNameActionPerformed(evt);
            }
        });
        textCusName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCusNameKeyReleased(evt);
            }
        });
        getContentPane().add(textCusName, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 178, 254, -1));

        textCusEmail.setBackground(java.awt.SystemColor.controlHighlight);
        textCusEmail.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        textCusEmail.setForeground(new java.awt.Color(0, 0, 0));
        textCusEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCusEmailActionPerformed(evt);
            }
        });
        textCusEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCusEmailKeyReleased(evt);
            }
        });
        getContentPane().add(textCusEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 334, 254, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("Category");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 74, -1, -1));

        textCusMobileNo.setBackground(java.awt.SystemColor.controlHighlight);
        textCusMobileNo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        textCusMobileNo.setForeground(new java.awt.Color(0, 0, 0));
        textCusMobileNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCusMobileNoKeyReleased(evt);
            }
        });
        getContentPane().add(textCusMobileNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 258, 254, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setText("Search");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        textSearch.setBackground(java.awt.SystemColor.controlHighlight);
        textSearch.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        textSearch.setForeground(new java.awt.Color(0, 0, 0));
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearchKeyReleased(evt);
            }
        });
        getContentPane().add(textSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 254, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 74, -1, -1));

        textProName.setBackground(java.awt.SystemColor.controlHighlight);
        textProName.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        textProName.setForeground(new java.awt.Color(0, 0, 0));
        textProName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textProNameActionPerformed(evt);
            }
        });
        getContentPane().add(textProName, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 110, 254, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 0));
        jLabel10.setText("Quantity");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 148, 180, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setText("Price");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(999, 74, -1, -1));

        textProPrice.setBackground(java.awt.SystemColor.controlHighlight);
        textProPrice.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        textProPrice.setForeground(new java.awt.Color(0, 0, 0));
        textProPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textProPriceActionPerformed(evt);
            }
        });
        getContentPane().add(textProPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(999, 112, 254, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 0));
        jLabel12.setText("Total");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(999, 150, -1, -1));

        textProTotal.setBackground(java.awt.SystemColor.controlHighlight);
        textProTotal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        textProTotal.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(textProTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(999, 182, 254, -1));

        jTable1.setBackground(java.awt.SystemColor.controlHighlight);
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 254, 410));

        jButton1.setBackground(new java.awt.Color(244, 79, 90));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(25, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1341, 0, -1, -1));

        btnClear.setBackground(new java.awt.Color(51, 102, 255));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, -1, -1));

        btnAddToCart.setBackground(new java.awt.Color(51, 102, 255));
        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddToCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cart.png"))); // NOI18N
        btnAddToCart.setText("Add to cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 220, -1, -1));

        jTable2.setBackground(java.awt.SystemColor.controlHighlight);
        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 291, 568, 350));

        btnPrint.setBackground(new java.awt.Color(51, 102, 255));
        btnPrint.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Bill.png"))); // NOI18N
        btnPrint.setText("Generate Bill & Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 680, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("--");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 74, -1, -1));

        jComboBox1.setBackground(java.awt.SystemColor.controlHighlight);
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 112, 254, -1));

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 180, 254, -1));

        labelGTotal.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelGTotal.setForeground(new java.awt.Color(0, 0, 0));
        labelGTotal.setText("000");
        getContentPane().add(labelGTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 680, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 0, 0));
        jLabel15.setText("Grand Total Rs.");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 680, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Background.jpg"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textCusNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCusNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCusNameActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearProductFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void textProPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textProPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textProPriceActionPerformed

    private void textCusEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCusEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCusEmailActionPerformed

    private void textProNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textProNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textProNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Home(userEmail).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        billId = Integer.parseInt(BillData.getId());
        jLabel13.setText(BillData.getId());
        ArrayList<Category> list = CategoryData.getAllRecords();
        Iterator<Category> itr = list.iterator();
        while(itr.hasNext()){
            Category categoryObj = itr.next();
            jComboBox1.addItem(categoryObj.getCategory());
        }
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_formComponentShown

    private void textSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyReleased
        // TODO add your handling code here:
        String name = textSearch.getText();
        String category = (String) jComboBox1.getSelectedItem();
        filterProductByname(name, category);
    }//GEN-LAST:event_textSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String productName = model.getValueAt(index, 0).toString();
        Product product = ProductData.getProductByname(productName);
        textProName.setText(product.getName());
        textProPrice.setText(product.getPrice());
        jSpinner1.setValue(1);
        productPrice = Integer.parseInt(product.getPrice());
        productTotal = Integer.parseInt(product.getPrice());
        btnAddToCart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        int quantity = (Integer) jSpinner1.getValue();
        if (quantity <=1){
            jSpinner1.setValue(1);
            quantity = 1;
        }
        productTotal = productPrice * quantity;
        textProTotal.setText(String.valueOf(productTotal));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String name = textProName.getText();
        String price = textProPrice.getText();
        String quantity = String.valueOf(jSpinner1.getValue());
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.addRow(new Object[]{name,price,quantity,productTotal});
        grandTotal = grandTotal + productTotal;
        labelGTotal.setText(String.valueOf(grandTotal));
        
        clearProductFields();
        validateField();
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void textCusNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCusNameKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_textCusNameKeyReleased

    private void textCusMobileNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCusMobileNoKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_textCusMobileNoKeyReleased

    private void textCusEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCusEmailKeyReleased
        // TODO add your handling code here:
        validateField();
    }//GEN-LAST:event_textCusEmailKeyReleased

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        String customerName = textCusName.getText();
        String customerMobileNumber = textCusMobileNo.getText();
        String customerEmail = textCusEmail.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todaydate = dFormat.format(date);
        String total = String.valueOf(grandTotal);
        String createdBy = userEmail;
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setName(customerName);
        bill.setMobileNumber(customerMobileNumber);
        bill.setEmail(customerEmail);
        bill.setDate(todaydate);
        bill.setToral(total);
        bill.setCreatedBy(createdBy);
        BillData.save(bill);
        
        //Creat Bill Document
        String path = "C:\\Users\\Anushan Dharmarathna\\OneDrive\\Documents\\NetBeansProjects\\Food Management System\\Bill\\";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + billId +".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                           Food Management System\n");
            doc.add(cafeName);
            Paragraph starLine = new Paragraph("****************************************************************************************************************");
            doc.add(starLine);
            Paragraph paraLine3 = new Paragraph("\tBill ID: "+billId+"\nCustomer Name: "+customerName+"\nTotal Paid: "+grandTotal);
            doc.add(paraLine3);
            doc.add(starLine);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for (int i=0; i < jTable2.getRowCount(); i++){
                String n = jTable2.getValueAt(i, 0).toString();
                String d = jTable2.getValueAt(i, 1).toString();
                String r = jTable2.getValueAt(i, 2).toString();
                String q = jTable2.getValueAt(i, 3).toString();
                tb1.addCell(n);
                tb1.addCell(d);
                tb1.addCell(r);
                tb1.addCell(q);                
            }
            doc.add(tb1);
            doc.add(starLine);
            Paragraph thankMsg = new Paragraph("Thank you, Please come again.");
            doc.add(thankMsg);
            OpenPdf.openById(String.valueOf(billId));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
        setVisible(false);
        new PlaceOrder(createdBy).setVisible(true);
    }//GEN-LAST:event_btnPrintActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int index = jTable2.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product", "Select", JOptionPane.YES_NO_OPTION);
        if (a==0){
            TableModel model =jTable2.getModel();
            String total = model.getValueAt(index, 3).toString();
            grandTotal = grandTotal - Integer.parseInt(total);
            labelGTotal.setText(String.valueOf(grandTotal));
            ((DefaultTableModel) jTable2.getModel()).removeRow(index);
            
        }
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labelGTotal;
    private javax.swing.JTextField textCusEmail;
    private javax.swing.JTextField textCusMobileNo;
    private javax.swing.JTextField textCusName;
    private javax.swing.JTextField textProName;
    private javax.swing.JTextField textProPrice;
    private javax.swing.JTextField textProTotal;
    private javax.swing.JTextField textSearch;
    // End of variables declaration//GEN-END:variables

    private PdfPTable PdfPTable(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
