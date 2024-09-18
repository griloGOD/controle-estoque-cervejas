
package principal;

import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.JPanel;
import java.awt.Color;
import rojerusan.RSButtonMetro;


public class Tela1 extends javax.swing.JFrame {
 
    public Tela1() {
        initComponents();
        setIcon();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        JBT_Cervejas = new rojerusan.RSButtonMetro();
        JBT_pedidos = new rojerusan.RSButtonMetro();
        JBT_clientes = new rojerusan.RSButtonMetro();
        JBT_menu = new rojerusan.RSButtonMetro();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        JDP_fundo = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(23, 35, 51));

        JBT_Cervejas.setBackground(new java.awt.Color(23, 35, 51));
        JBT_Cervejas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/beericon.png"))); // NOI18N
        JBT_Cervejas.setText("Cervejas");
        JBT_Cervejas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_CervejasActionPerformed(evt);
            }
        });

        JBT_pedidos.setBackground(new java.awt.Color(23, 35, 51));
        JBT_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/check-list.png"))); // NOI18N
        JBT_pedidos.setText("Pedidos");
        JBT_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_pedidosActionPerformed(evt);
            }
        });

        JBT_clientes.setBackground(new java.awt.Color(23, 35, 51));
        JBT_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/clientes.png"))); // NOI18N
        JBT_clientes.setText("Clientes");
        JBT_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_clientesActionPerformed(evt);
            }
        });

        JBT_menu.setBackground(new java.awt.Color(23, 35, 51));
        JBT_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/house.png"))); // NOI18N
        JBT_menu.setText("Menu    ");
        JBT_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_menuActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/beer-mug.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GERMAN BEER");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JBT_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(JBT_clientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(JBT_Cervejas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(JBT_pedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(JBT_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBT_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(JBT_Cervejas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBT_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 560));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JDP_fundo.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout JDP_fundoLayout = new javax.swing.GroupLayout(JDP_fundo);
        JDP_fundo.setLayout(JDP_fundoLayout);
        JDP_fundoLayout.setHorizontalGroup(
            JDP_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        JDP_fundoLayout.setVerticalGroup(
            JDP_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jPanel4.add(JDP_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 820, 560));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 830, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBT_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_clientesActionPerformed
        ClienteTela cliente = ClienteTela.getInstance();
        cliente.pack();
        
        if(cliente.isVisible()){
        } else{
            JDP_fundo.add(cliente);
            cliente.setVisible(true);
        }
        try{
            cliente.setMaximum(true);
        }catch (PropertyVetoException ex) {
        Logger.getLogger(Tela1.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_JBT_clientesActionPerformed

    private void JBT_CervejasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_CervejasActionPerformed
        CervejaTela cerveja = CervejaTela.getInstance();
        cerveja.pack();
        
        if(cerveja.isVisible()){
        } else{
            JDP_fundo.add(cerveja);
            cerveja.setVisible(true);
        }
        try{
            cerveja.setMaximum(true);
        }catch (PropertyVetoException ex) {
        Logger.getLogger(Tela1.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_JBT_CervejasActionPerformed

    private void JBT_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_pedidosActionPerformed
        PedidoTela pedido = PedidoTela.getInstance();
        pedido.pack();
        
        if(pedido.isVisible()){
        } else{
            JDP_fundo.add(pedido);
            pedido.setVisible(true);
        }
        try{
            pedido.setMaximum(true);
        }catch (PropertyVetoException ex) {
        Logger.getLogger(Tela1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBT_pedidosActionPerformed

    private void JBT_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_menuActionPerformed
        Menu menu = Menu.getInstance();
        menu.pack();
        
        if(menu.isVisible()){
        } else{
            JDP_fundo.add(menu);
            menu.setVisible(true);
        }
        try{
            menu.setMaximum(true);
        }catch (PropertyVetoException ex) {
        Logger.getLogger(Tela1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_JBT_menuActionPerformed

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
            java.util.logging.Logger.getLogger(Tela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela1().setVisible(true);
            }
        });
    }

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("beer-mug.png"))); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro JBT_Cervejas;
    private rojerusan.RSButtonMetro JBT_clientes;
    private rojerusan.RSButtonMetro JBT_menu;
    private rojerusan.RSButtonMetro JBT_pedidos;
    private javax.swing.JDesktopPane JDP_fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    private void setColor(RSButtonMetro JBT_menu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
