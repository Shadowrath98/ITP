/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itp.reservation;


import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SHADOWRATH
 */
public class HallReservation extends javax.swing.JFrame {

    /**
     * Creates new form HallReservation
     */
    private Connection connection = DBConnection.getDbConnection();
    private static final String STATUS_BOOKED = "Booked";
    private static final String STATUS_NOT_BOOKED ="Not booked";
    public HallReservation() {
        
        initComponents();
            initialize();
             
    }
    
    public void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }  
    
     public void initialize(){
                 try {  
          String sql = "SELECT HallName,status_ from Halls";
          PreparedStatement pst;
              pst = connection.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
                     System.out.println(HallDTable);
                     DefaultTableModel model = (DefaultTableModel) HallDTable.getModel();
                   model.setRowCount(0);
                 
                      List<     itp.reservation.model.HallReservation> arrList = new ArrayList<     itp.reservation.model.HallReservation>(); 
                      
                while (rs.next()) {
                          itp.reservation.model.HallReservation hallReservation = new   itp.reservation.model.HallReservation();
                     
                     hallReservation .setHallName(rs.getString(1).charAt(0));
                     hallReservation.setStatus(rs.getBoolean(2));
                     System.out.println(hallReservation);
                     
                       arrList.add(hallReservation);
                     
                    
                     

                }
               for(int i = arrList.size()-1 ; i >=0 ; i--){
                   itp.reservation.model.HallReservation tempRoom = arrList.get(i);
                   if(tempRoom.isStatus()){
                  model.insertRow(0,new Object[]{tempRoom.getHallName(),STATUS_BOOKED});
               }
                   else{
                     model.insertRow(0,new Object[]{tempRoom.getHallName(),STATUS_NOT_BOOKED});   
                   }
               }
               
      
            HallDTable.setModel(model);
                   
                   
          
     
        } catch (SQLException ex) {
            Logger.getLogger(HallReservation.class.getName()).log(Level.SEVERE, null, ex);
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
        BTNHome = new javax.swing.JButton();
        BTNlogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        HallDTable = new javax.swing.JTable();
        BTNHhistory = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        VDetailsbtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Reservation Rooms");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Hall Reservation");

        BTNHome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTNHome.setText("Reservation");
        BTNHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHomeActionPerformed(evt);
            }
        });

        BTNlogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTNlogout.setText("LOGOUT");

        HallDTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Hall Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        HallDTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HallDTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(HallDTable);

        BTNHhistory.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTNHhistory.setText("Reservation History");
        BTNHhistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNHhistoryActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        VDetailsbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        VDetailsbtn.setText("View Details");
        VDetailsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VDetailsbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTNHome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTNlogout)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(BTNHhistory, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(VDetailsbtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNHome)
                    .addComponent(BTNlogout)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNHhistory)
                    .addComponent(VDetailsbtn))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
        ReservationHome z = new ReservationHome();
        z.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BTNHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNHomeActionPerformed
        close();
        ReservationHome c = new ReservationHome();
        c.setVisible(true);
    }//GEN-LAST:event_BTNHomeActionPerformed

    private void BTNHhistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNHhistoryActionPerformed
        close();
        ResHistory1 n = new ResHistory1();
        n.setVisible(true);
    }//GEN-LAST:event_BTNHhistoryActionPerformed

    private void VDetailsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VDetailsbtnActionPerformed
       DefaultTableModel model = (DefaultTableModel) HallDTable.getModel();
        if(HallDTable.getSelectedRow()!=-1){
                close();
                ReservationHallDetails l = new ReservationHallDetails();
                
                
                l.jLabel1.setText("Reservation Details for Hall "+HallDTable.getSelectionModel());
                l.setVisible(true);
        }
    }//GEN-LAST:event_VDetailsbtnActionPerformed

    private void HallDTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HallDTableMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel)HallDTable.getModel();
       
        //Set data to the text feilds when a row is selected
       
        String roomNo = tblModel.getValueAt(HallDTable.getSelectedRow(), 0).toString();
        String status = tblModel.getValueAt(HallDTable.getSelectedRow(), 1).toString();
     
        System.out.println(roomNo);
        System.out.println(status);
    }//GEN-LAST:event_HallDTableMouseClicked

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
            java.util.logging.Logger.getLogger(HallReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HallReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HallReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HallReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HallReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNHhistory;
    private javax.swing.JButton BTNHome;
    private javax.swing.JButton BTNlogout;
    private javax.swing.JTable HallDTable;
    private javax.swing.JButton VDetailsbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
