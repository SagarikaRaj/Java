/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Driver.crud;
import connector.JdbcUtilities;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class DataAnalytics extends javax.swing.JFrame 
{

    /**
     * Creates new form DataAnalytics
     */
    public DataAnalytics() 
    {
        initComponents();
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
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("  Data Analytics");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Winter Solistice", "Vernal Equinox", "Summer Solistice", "Autumnal Equinox", " " }));

        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(283, 283, 283)
                        .addComponent(jButton2)
                        .addGap(26, 26, 26)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(225, 225, 225))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int ind=jComboBox1.getSelectedIndex();
        Connection conn = JdbcUtilities.startConnection();
        Statement stmt = null;
        ResultSet rs=null;
switch(ind)
{
    case 0:
        try {
            stmt = conn.createStatement();
            rs= stmt.executeQuery("SELECT DATE_FORMAT(sunrise,'%m-%d-%Y') from DAYLIGHTRECORD "
                    + "where SUNRISE BETWEEN '2013-01-01' AND '2013-04-01' OR '2013-12-01' and '2013-12-31'"
                    + "and daylength = ( SELECT MIN(daylength) AS WINTERSOLISTICE FROM DAYLIGHTRECORD WHERE "
                    + "SUNRISE BETWEEN '2013-01-01' AND '2013-04-01' OR '2013-12-01' and '2013-12-31')"); 
           
            while(rs.next())
            {
                jTextField1.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DataAnalytics.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           JdbcUtilities.closeStatement(stmt);
           JdbcUtilities.closeresultSet(rs);
        JdbcUtilities.closeConnection(conn);
        
        }
    case 1:
        try {
            
            stmt = conn.createStatement();
            rs= stmt.executeQuery(" select DATE_FORMAT(sunrise,'%m-%d-%Y') "
                    + "from DAYLIGHTRECORD where sunrise between '2013-04-01' and '2013-06-30' "
                    + "and (daylength - nightlength) = "
                    + "(select min(daylength - nightlength) from DAYLIGHTRECORD "
                    + "where sunrise between '2013-04-01' and '2013-06-30')");
           
            while(rs.next())
            {
                jTextField1.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DataAnalytics.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           JdbcUtilities.closeStatement(stmt);
           JdbcUtilities.closeresultSet(rs);
        JdbcUtilities.closeConnection(conn);
        
        }
    case 2:
        try {
            stmt = conn.createStatement();
            rs= stmt.executeQuery(" SELECT DATE_FORMAT(sunrise,'%m-%d-%Y') from DAYLIGHTRECORD "
                    + "where SUNRISE BETWEEN '2013-06-01' AND '2013-09-30' AND daylength = "
                    + "(SELECT MAX(daylength) AS SUMMERSOLISTICE FROM DAYLIGHTRECORD WHERE "
                    + "SUNRISE BETWEEN '2013-06-01' AND '2013-09-30')");
           
            while(rs.next())
            {
                jTextField1.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DataAnalytics.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           JdbcUtilities.closeStatement(stmt);
           JdbcUtilities.closeresultSet(rs);
        JdbcUtilities.closeConnection(conn);
        
        }
    case 3:
         try {
            stmt = conn.createStatement();
            rs= stmt.executeQuery("select DATE_FORMAT(sunrise,'%m-%d-%Y') from DAYLIGHTRECORD "
                    + "where sunrise between '2013-09-01' and '2013-12-01' "
                    + "and (daylength - nightlength )"
                    + "=(select min(daylength - nightlength) from DAYLIGHTRECORD where "
                    + " sunrise between '2013-09-01' and '2013-12-01')");
           
            while(rs.next())
            {
                jTextField1.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DataAnalytics.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           JdbcUtilities.closeStatement(stmt);
           JdbcUtilities.closeresultSet(rs);
        JdbcUtilities.closeConnection(conn);
        
        }
       
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         crud op = new crud();
        op.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(DataAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataAnalytics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataAnalytics().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}