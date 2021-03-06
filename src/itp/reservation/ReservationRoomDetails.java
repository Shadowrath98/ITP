/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itp.reservation;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SHADOWRATH
 */
public class ReservationRoomDetails extends javax.swing.JFrame {
    
     private Connection connection = DBConnection.getDbConnection();
     public String custID;
     public static int roomNo ;
     ResultSet rs;

    /**
     * Creates new form ReservationRoomDetails
     */
    public ReservationRoomDetails() {
        initComponents();
        //getData();
        System.out.println("Room No :"+roomNo);
    }
    
    public void updateData(int no){
        System.out.println("GetData Executed");
        try{
            String sql = "SELECT customer.Cname,customer.CEmail,customer.NIC,customer.CContact,Reservation.checkIn,Reservation.checkOut from customer,Reservation where customer.Cid = Reservation.CusID AND Rno ='"+no+"'";
            System.out.println("SQL CODE : "+sql);
            //String sql = "SELECT Room_Number,status_ from Reservations WHWRE rooms="+roomNo+"";
            PreparedStatement pst;
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery(); 
            System.out.println("Rs received");
            
            while (rs.next()) {
                System.out.println("exe");
                ////////////////////////
                //System.out.println("Rs Output [0]: "+rs.getString(1));
                //System.out.println("Rs Output [1]: "+rs.getString(1));
                lblName.setText(rs.getString(1));
                lblEmail.setText(rs.getString(2));
                lblNIC.setText(rs.getString(3));
                lblContact.setText(rs.getString(4));
                lblCIn.setText(rs.getString(5));
                lblCOut.setText(rs.getString(6));
                
                
                
                /////////////////////////
                
            }                  

        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

          public void initialize(int roomNo){
                /* try {  
          String sql = "SELECT Room_Number,status_ from Reservations WHWRE rooms="+roomNo+"";
          PreparedStatement pst;
              pst = connection.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
                     System.out.println(jTable1);
                     DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                   model.setRowCount(0);
                 
                      List<itp.reservation.model.RoomReservation> arrList = new ArrayList<itp.reservation.model.RoomReservation>(); 
                      
                while (rs.next()) {
                     itp.reservation.model.RoomReservation roomReservation = new   itp.reservation.model.RoomReservation();
                     
                     roomReservation.setRoomNumber(rs.getInt(1));
                     roomReservation.setStatus(rs.getBoolean(2));
                     System.out.println(roomReservation);
                     
                       arrList.add(roomReservation);
                  

                }
               for(int i = arrList.size()-1 ; i >=0 ; i--){
                   itp.reservation.model.RoomReservation tempRoom = arrList.get(i);
                   if(tempRoom.isStatus()){
                  model.insertRow(0,new Object[]{tempRoom.getRoomNumber(),STATUS_BOOKED});
               }
                   else{
                     model.insertRow(0,new Object[]{tempRoom.getRoomNumber(),STATUS_NOT_BOOKED});   
                   }
               }
               
      
            jTable2.setModel(model);
                   
                   
          
     
        } catch (SQLException ex) {
            Logger.getLogger(RoomReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
                */
      }
    
    public void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlb1 = new javax.swing.JLabel();
        BTNReservation = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BTNadd = new javax.swing.JButton();
        BTNdelete = new javax.swing.JButton();
        BTNupdate = new javax.swing.JButton();
        Backbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jlb2 = new javax.swing.JLabel();
        VEmail = new javax.swing.JLabel();
        VContact = new javax.swing.JLabel();
        VCin = new javax.swing.JLabel();
        VCout = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblNIC = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        lblCOut = new javax.swing.JLabel();
        VNIC = new javax.swing.JLabel();
        lblCIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlb1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlb1.setText("jLabel1");

        BTNReservation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTNReservation.setText("Reservation");
        BTNReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNReservationActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("LOGOUT");

        BTNadd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTNadd.setText("ADD");
        BTNadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNaddActionPerformed(evt);
            }
        });

        BTNdelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTNdelete.setText("DELETE");
        BTNdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNdeleteActionPerformed(evt);
            }
        });

        BTNupdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTNupdate.setText("UPDATE");

        Backbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Backbtn.setText("Back");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Name    : ");

        lblName.setText("not booked");

        jlb2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlb2.setText("jLabel1");

        VEmail.setText("Email     :");

        VContact.setText("Contact :");

        VCin.setText("CheckIn :");

        VCout.setText("CheckOut :");

        lblEmail.setText("not booked");

        lblNIC.setText("not booked");

        lblContact.setText("not booked");

        lblCOut.setText("not booked");

        VNIC.setText("NIC      :");

        lblCIn.setText("not booked");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 80, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                                .addComponent(VEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(VCout)
                                                    .addComponent(VContact)
                                                    .addComponent(VCin))
                                                .addGap(4, 4, 4)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                            .addComponent(lblCOut, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblCIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(VNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Backbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addComponent(jlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlb2)
                                .addGap(33, 33, 33)))
                        .addComponent(BTNReservation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(BTNadd)
                        .addGap(86, 86, 86)
                        .addComponent(BTNdelete)
                        .addGap(61, 61, 61)
                        .addComponent(BTNupdate)
                        .addGap(72, 72, 72)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNReservation)
                    .addComponent(jButton2)
                    .addComponent(Backbtn)
                    .addComponent(jlb2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VEmail)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNIC)
                    .addComponent(VNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblContact)
                    .addComponent(VContact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VCin)
                    .addComponent(lblCIn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VCout)
                    .addComponent(lblCOut))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNdelete)
                    .addComponent(BTNadd)
                    .addComponent(BTNupdate))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNReservationActionPerformed
        close();
        ReservationHome z = new ReservationHome();
        z.setVisible(true);
    }//GEN-LAST:event_BTNReservationActionPerformed

    private void BTNaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNaddActionPerformed
        close();
        String p = lblName.getText().toString();
        if(p == "not booked"){
            ReservationRInput x = new ReservationRInput();
            x.jlbNum.setText(jlb2.getText());
            x.setVisible(true);
            RoomReservation k = new RoomReservation();
            DefaultTableModel model = (DefaultTableModel) k.jTable2.getModel();
            int row = k.jTable2.getSelectedRow()+1;
            x.jLabel1.setText("Enter Reservation Details for Room ");
        }else{
            System.out.println("false");
            JOptionPane.showMessageDialog(null, "This room is already booked");
        
        }
        
    }//GEN-LAST:event_BTNaddActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        close();
       
            RoomReservation k = new RoomReservation();
            k.setVisible(true);
        
    }//GEN-LAST:event_BackbtnActionPerformed

    private void BTNdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNdeleteActionPerformed
        try{
            
            String sql = "DELETE from Reservation where Rno = ?";
            
            String sqlx = "UPDATE Rooms SET status_= FALSE WHERE Room_Number = ?";
            
            PreparedStatement pst;
            PreparedStatement pstx;
            pst = connection.prepareStatement(sql);
            pstx = connection.prepareStatement(sqlx);
            pst.setString(1, jlb2.getText());
            pstx.setString(1, jlb2.getText());
            int m = JOptionPane.showConfirmDialog(null,"Delete this reservation","DELETE",JOptionPane.YES_NO_OPTION);
            if(m == 0){
            pst.executeUpdate();
            pstx.executeUpdate();
            close();
            RoomReservation z = new RoomReservation();
            z.setVisible(true);
            }
            else{}
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_BTNdeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReservationRoomDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationRoomDetails.class.getNlblNIC(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationRoomDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationRoomDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>*/

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationRoomDetails().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNReservation;
    private javax.swing.JButton BTNadd;
    private javax.swing.JButton BTNdelete;
    private javax.swing.JButton BTNupdate;
    private javax.swing.JButton Backbtn;
    private javax.swing.JLabel VCin;
    private javax.swing.JLabel VContact;
    private javax.swing.JLabel VCout;
    private javax.swing.JLabel VEmail;
    private javax.swing.JLabel VNIC;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jlb1;
    public javax.swing.JLabel jlb2;
    private javax.swing.JLabel lblCIn;
    private javax.swing.JLabel lblCOut;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNIC;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables

}
