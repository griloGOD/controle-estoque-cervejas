
package principal;

import bean.Cerveja;
import bean.Cliente;
import bean.Pedido;
import dao.CervejaDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Menu extends javax.swing.JInternalFrame {
    
        ArrayList<Cliente> al_cliente = new ArrayList();
        ArrayList<Cerveja> al_cerveja = new ArrayList();
        ArrayList<Pedido> al_pedido = new ArrayList();
    
    private static Menu telamenu;
    
    public static Menu getInstance(){
        if(telamenu == null){
            telamenu = new Menu();
        }
        return telamenu;
    }
    
    public Menu() {
        initComponents();
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("imagens/house16px.png"));
        this.setFrameIcon(icon);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBT_pdf = new rojerusan.RSButtonMetro();
        JBT_txt = new rojerusan.RSButtonMetro();

        setBackground(new java.awt.Color(24, 52, 81));
        setBorder(null);
        setTitle("MENU");
        setPreferredSize(new java.awt.Dimension(820, 560));

        JBT_pdf.setBackground(new java.awt.Color(24, 52, 81));
        JBT_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pdf.png"))); // NOI18N
        JBT_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_pdfActionPerformed(evt);
            }
        });

        JBT_txt.setBackground(new java.awt.Color(24, 52, 81));
        JBT_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/file.png"))); // NOI18N
        JBT_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_txtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(JBT_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(JBT_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBT_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBT_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBT_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_pdfActionPerformed
        
    }//GEN-LAST:event_JBT_pdfActionPerformed

    private void JBT_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_txtActionPerformed
        String s_local, s_texto;
        try {
                al_cliente = ClienteDAO.buscarClientes();
                al_cerveja = CervejaDAO.buscarCervejas();
                al_pedido = PedidoDAO.buscarTodosPedidos();
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            Scanner scn_entrada = new Scanner(System.in);
        try {
            
                s_local = "H:\\Bagunça da facul\\Cerveja_Luís_Filipi\\Arquivo TXT/todas_Tabelas.txt";
                File fl_arquivo = new File(s_local);
                
                if(!fl_arquivo.exists())
                {
                    JOptionPane.showMessageDialog(null, "Não existe arquivo criado. Criaremos um...");
                    if(fl_arquivo.createNewFile())
                    {
                        JOptionPane.showMessageDialog(null, "O arquivo foi criado");
                        FileWriter fw_leitorDeArquivo = new FileWriter(fl_arquivo);
                        BufferedWriter bw_gravadorEmBuffer = new BufferedWriter(fw_leitorDeArquivo);
                    
                        for (int i = 0; i < al_cliente.size(); i++) {
                            s_texto = al_cliente.get(i).toString();
                            bw_gravadorEmBuffer.write(s_texto);
                            bw_gravadorEmBuffer.newLine();
                        }
                        for (int i = 0; i < al_cerveja.size(); i++) {
                                s_texto = al_cerveja.get(i).toString();
                                bw_gravadorEmBuffer.write(s_texto);
                                bw_gravadorEmBuffer.newLine();
   
                        }
                        for (int i = 0; i < al_pedido.size(); i++) {
                                s_texto = al_pedido.get(i).toString();
                                bw_gravadorEmBuffer.write(s_texto);
                                bw_gravadorEmBuffer.newLine();
   
                        }
                        bw_gravadorEmBuffer.close();
                        fw_leitorDeArquivo.close();
                    }else{
                    JOptionPane.showMessageDialog(null, "O arquivo não foi criado ");
                }
            }else{
                fl_arquivo.delete();
                JOptionPane.showMessageDialog(null, "Arquivo já existente ");
                FileWriter fw_leitorDeArquivo = new FileWriter(fl_arquivo, true);
                BufferedWriter bw_gravadorEmBuffer = new BufferedWriter(fw_leitorDeArquivo);
                JOptionPane.showMessageDialog(null, "Atualizando arquivo: ");
                for (int i = 0; i < al_cliente.size(); i++) {
                        s_texto = al_cliente.get(i).toString();
                        bw_gravadorEmBuffer.write(s_texto);
                        bw_gravadorEmBuffer.newLine();
                }
                for (int i = 0; i < al_cerveja.size(); i++) {
                        s_texto = al_cerveja.get(i).toString();
                        bw_gravadorEmBuffer.write(s_texto);
                        bw_gravadorEmBuffer.newLine();
                }
                for (int i = 0; i < al_pedido.size(); i++) {
                        s_texto = al_pedido.get(i).toString();
                        bw_gravadorEmBuffer.write(s_texto);
                        bw_gravadorEmBuffer.newLine();
                }
                
                bw_gravadorEmBuffer.close();
                fw_leitorDeArquivo.close();
            }
        }catch(IOException e){
            System.out.print("Erro ao escrever: "+e.toString());
        }
    }//GEN-LAST:event_JBT_txtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro JBT_pdf;
    private rojerusan.RSButtonMetro JBT_txt;
    // End of variables declaration//GEN-END:variables
}
