
package principal;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import principal.ClienteTela;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import bean.Cerveja;
import dao.CervejaDAO;
import java.sql.Connection;

public class CervejaTela extends javax.swing.JInternalFrame {
    
    DefaultTableModel dtm_tabela;
    DefaultTableModel dtm_tabelabusca;
    ArrayList<Cerveja> al_listaCliente;
     Connection con_conexao = null;
     PreparedStatement pst = null;
     ResultSet rs = null;
    
    private static CervejaTela telacerveja;
    
    public static CervejaTela getInstance(){
        if(telacerveja == null){
            telacerveja = new CervejaTela();
        }
        return telacerveja;
    }
    
    public CervejaTela() {
        initComponents();
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("imagens/beer16px.png"));
        this.setFrameIcon(icon);
        dtm_tabela = new DefaultTableModel(null, new String[]{"Id Cerveja","Descrição","Valor"});
        dtm_tabelabusca = new DefaultTableModel(null, new String[]{"Id Cerveja","Descrição","Valor"});
        try {
            atualizaTabela();
        } catch (SQLException ex) {
            System.out.print("SQLException: "+ex.toString());
        } catch (ClassNotFoundException ex){
            System.out.print("ClassNotFoundException: "+ex.toString());
        }
    }
    private void limparTela()
    {
        JTF_idbeer.setText("");
        JTF_descricao.setText("");
        JTF_valor.setText("");
        JTF_buscar.setText("");
        JTF_remover.setText("");
    }
    
    private void atualizaTabela() throws SQLException, ClassNotFoundException
    {
        JTB_dadosBeer.setModel(dtm_tabelabusca);
        JTB_dadosBeer1.setModel(dtm_tabela);
        JTB_dadosBeer2.setModel(dtm_tabela);
        JTB_dadosBeer3.setModel(dtm_tabela);
        dtm_tabela.setNumRows(0);
        al_listaCliente = CervejaDAO.buscarCervejas();
        for (Cerveja c : al_listaCliente) 
        {
            dtm_tabela.addRow(new Object[]{c.getIdBeer(), c.getDescricao(), c.getValor()});
            dtm_tabelabusca.addRow(new Object[]{c.getIdBeer(), c.getDescricao(), c.getValor()});
            
	}
    }
    private void buscarNaTabela(String id) throws SQLException, ClassNotFoundException
    {
        JTB_dadosBeer.setModel(dtm_tabelabusca);
        dtm_tabelabusca.setNumRows(0);
        al_listaCliente = CervejaDAO.buscarCervejas();
        for (Cerveja c : CervejaDAO.buscarAvancada(id)) 
        {
            dtm_tabelabusca.addRow(new Object[]{c.getIdBeer(), c.getDescricao(),c.getValor()});
	}
    }
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTP_cliente = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        JTF_buscar = new javax.swing.JTextField();
        JBT_buscarCerveja = new rojerusan.RSButtonMetro();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_dadosBeer = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTB_dadosBeer1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JBT_insereCerveja = new rojerusan.RSButtonMetro();
        JTF_idbeer = new javax.swing.JFormattedTextField();
        JTF_descricao = new javax.swing.JFormattedTextField();
        JTF_valor = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTB_dadosBeer2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JBT_alteraCerveja = new rojerusan.RSButtonMetro();
        JTF_idbeer1 = new javax.swing.JFormattedTextField();
        JTF_descricao1 = new javax.swing.JFormattedTextField();
        JTF_valor1 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        JBT_remover = new rojerusan.RSButtonMetro();
        JTF_remover = new javax.swing.JFormattedTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTB_dadosBeer3 = new javax.swing.JTable();

        setBackground(new java.awt.Color(8, 30, 65));
        setBorder(null);
        setTitle("CERVEJAS");
        setToolTipText("ADICIONAR CLIENTE");

        JTP_cliente.setBackground(new java.awt.Color(95, 133, 171));
        JTP_cliente.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        JTP_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTP_cliente.setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(24, 52, 81));

        JTF_buscar.setBackground(new java.awt.Color(69, 104, 139));
        JTF_buscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_buscar.setForeground(new java.awt.Color(255, 255, 255));
        JTF_buscar.setBorder(null);
        JTF_buscar.setCaretColor(new java.awt.Color(255, 255, 255));
        JTF_buscar.setPreferredSize(new java.awt.Dimension(2, 20));
        JTF_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_buscarActionPerformed(evt);
            }
        });

        JBT_buscarCerveja.setBackground(new java.awt.Color(24, 52, 81));
        JBT_buscarCerveja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search.png"))); // NOI18N
        JBT_buscarCerveja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_buscarCervejaActionPerformed(evt);
            }
        });
        JBT_buscarCerveja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JBT_buscarCervejaKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID Cerveja");

        jScrollPane1.setBorder(null);

        JTB_dadosBeer.setAutoCreateRowSorter(true);
        JTB_dadosBeer.setBackground(new java.awt.Color(69, 104, 139));
        JTB_dadosBeer.setForeground(new java.awt.Color(255, 255, 255));
        JTB_dadosBeer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTB_dadosBeer.setGridColor(new java.awt.Color(204, 204, 204));
        JTB_dadosBeer.setInheritsPopupMenu(true);
        JTB_dadosBeer.setSelectionBackground(new java.awt.Color(204, 255, 255));
        JTB_dadosBeer.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(JTB_dadosBeer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JTF_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(JBT_buscarCerveja, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBT_buscarCerveja, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(JTF_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTP_cliente.addTab("BUSCAR", jPanel1);

        jPanel2.setBackground(new java.awt.Color(24, 52, 81));

        jScrollPane2.setBorder(null);

        JTB_dadosBeer1.setAutoCreateRowSorter(true);
        JTB_dadosBeer1.setBackground(new java.awt.Color(69, 104, 139));
        JTB_dadosBeer1.setForeground(new java.awt.Color(255, 255, 255));
        JTB_dadosBeer1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTB_dadosBeer1.setGridColor(new java.awt.Color(204, 204, 204));
        JTB_dadosBeer1.setInheritsPopupMenu(true);
        JTB_dadosBeer1.setSelectionBackground(new java.awt.Color(204, 255, 255));
        JTB_dadosBeer1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(JTB_dadosBeer1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id Cerveja");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descrição");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Valor");

        JBT_insereCerveja.setBackground(new java.awt.Color(24, 52, 81));
        JBT_insereCerveja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        JBT_insereCerveja.setText("Inserir Cerveja");
        JBT_insereCerveja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_insereCervejaActionPerformed(evt);
            }
        });

        JTF_idbeer.setBackground(new java.awt.Color(69, 104, 139));
        JTF_idbeer.setBorder(null);
        JTF_idbeer.setForeground(new java.awt.Color(255, 255, 255));
        JTF_idbeer.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_descricao.setBackground(new java.awt.Color(69, 104, 139));
        JTF_descricao.setBorder(null);
        JTF_descricao.setForeground(new java.awt.Color(255, 255, 255));
        JTF_descricao.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_valor.setBackground(new java.awt.Color(69, 104, 139));
        JTF_valor.setBorder(null);
        JTF_valor.setForeground(new java.awt.Color(255, 255, 255));
        JTF_valor.setCaretColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBT_insereCerveja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(JTF_idbeer, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(JTF_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addGap(215, 215, 215)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(108, 108, 108))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTF_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTF_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JTF_idbeer, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JBT_insereCerveja, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTP_cliente.addTab("INSERIR", jPanel2);

        jPanel3.setBackground(new java.awt.Color(24, 52, 81));

        jScrollPane3.setBorder(null);

        JTB_dadosBeer2.setAutoCreateRowSorter(true);
        JTB_dadosBeer2.setBackground(new java.awt.Color(69, 104, 139));
        JTB_dadosBeer2.setForeground(new java.awt.Color(255, 255, 255));
        JTB_dadosBeer2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTB_dadosBeer2.setGridColor(new java.awt.Color(204, 204, 204));
        JTB_dadosBeer2.setInheritsPopupMenu(true);
        JTB_dadosBeer2.setSelectionBackground(new java.awt.Color(204, 255, 255));
        JTB_dadosBeer2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(JTB_dadosBeer2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id Cerveja");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Descrição");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Valor");

        JBT_alteraCerveja.setBackground(new java.awt.Color(24, 52, 81));
        JBT_alteraCerveja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/refresh.png"))); // NOI18N
        JBT_alteraCerveja.setText("Alterar Dados");
        JBT_alteraCerveja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_alteraCervejaActionPerformed(evt);
            }
        });

        JTF_idbeer1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_idbeer1.setBorder(null);
        JTF_idbeer1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_idbeer1.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_descricao1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_descricao1.setBorder(null);
        JTF_descricao1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_descricao1.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_valor1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_valor1.setBorder(null);
        JTF_valor1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_valor1.setCaretColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBT_alteraCerveja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(JTF_idbeer1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTF_descricao1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JTF_valor1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4)
                        .addGap(215, 215, 215)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(98, 98, 98)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTF_valor1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTF_descricao1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JTF_idbeer1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JBT_alteraCerveja, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
        );

        JTP_cliente.addTab("ALTERAR", jPanel3);

        jPanel4.setBackground(new java.awt.Color(24, 52, 81));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Id Cerveja");

        JBT_remover.setBackground(new java.awt.Color(24, 52, 81));
        JBT_remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remove.png"))); // NOI18N
        JBT_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_removerActionPerformed(evt);
            }
        });

        JTF_remover.setBackground(new java.awt.Color(69, 104, 139));
        JTF_remover.setBorder(null);
        JTF_remover.setForeground(new java.awt.Color(255, 255, 255));
        JTF_remover.setCaretColor(new java.awt.Color(255, 255, 255));

        jScrollPane4.setBorder(null);

        JTB_dadosBeer3.setAutoCreateRowSorter(true);
        JTB_dadosBeer3.setBackground(new java.awt.Color(69, 104, 139));
        JTB_dadosBeer3.setForeground(new java.awt.Color(255, 255, 255));
        JTB_dadosBeer3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTB_dadosBeer3.setGridColor(new java.awt.Color(204, 204, 204));
        JTB_dadosBeer3.setInheritsPopupMenu(true);
        JTB_dadosBeer3.setSelectionBackground(new java.awt.Color(204, 255, 255));
        JTB_dadosBeer3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(JTB_dadosBeer3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(JTF_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBT_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBT_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(JTF_remover, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTP_cliente.addTab("REMOVER", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTP_cliente)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTP_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_buscarActionPerformed
        
    }//GEN-LAST:event_JTF_buscarActionPerformed

    private void JBT_buscarCervejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_buscarCervejaActionPerformed
        try {
           buscarNaTabela(JTF_buscar.getText());
        } catch (SQLException ex) {
            System.out.print("SQLException: "+ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.print("ClassNotFoundException: "+ex.toString());
        } 
        limparTela();
    }//GEN-LAST:event_JBT_buscarCervejaActionPerformed

    private void JBT_buscarCervejaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBT_buscarCervejaKeyPressed

    }//GEN-LAST:event_JBT_buscarCervejaKeyPressed

    private void JBT_insereCervejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_insereCervejaActionPerformed
        try {
            Cerveja beer = new Cerveja();
            String s_idBeer, s_descricao;
            float f_valor;
            s_idBeer = JTF_idbeer.getText();
            s_descricao = JTF_descricao.getText();
            f_valor = Float.parseFloat(JTF_valor.getText());
            beer.setIdBeer(s_idBeer);
            beer.setDescricao(s_descricao);
            beer.setValor(f_valor);
            CervejaDAO.adicionarCerveja(beer);
            atualizaTabela();
            limparTela();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        JOptionPane.showMessageDialog(null, "Cerveja adicionada com sucesso ");
    }//GEN-LAST:event_JBT_insereCervejaActionPerformed

    private void JBT_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_removerActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja"
                + "remover essa cerveja?");
        if(confirma == JOptionPane.YES_OPTION)
        {
             String s_idBuscado = JTF_remover.getText();
            try {
                CervejaDAO.remover(s_idBuscado);
                atualizaTabela();
                limparTela();
                JOptionPane.showMessageDialog(null, "Cerveja removida com sucesso");
            } catch (SQLException ex) {
                System.out.print("SQLException: "+ex.toString());
            } catch (ClassNotFoundException ex) {
                System.out.print("ClassNotFoundException: "+ex.toString());
            }
        } 
    }//GEN-LAST:event_JBT_removerActionPerformed

    private void JBT_alteraCervejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_alteraCervejaActionPerformed
       try {
            Cerveja beer = new Cerveja();
            String s_idBeer, s_descricao;
            float f_valor;
            s_idBeer = JTF_idbeer1.getText();
            s_descricao = JTF_descricao1.getText();
            f_valor = Float.parseFloat(JTF_valor1.getText());
            beer.setIdBeer(s_idBeer);
            beer.setDescricao(s_descricao);
            beer.setValor(f_valor);
            CervejaDAO.atualizar(beer);
            atualizaTabela();
            limparTela();
            JOptionPane.showMessageDialog(null, "Cerveja alterado com sucesso");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_JBT_alteraCervejaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro JBT_alteraCerveja;
    private rojerusan.RSButtonMetro JBT_buscarCerveja;
    private rojerusan.RSButtonMetro JBT_insereCerveja;
    private rojerusan.RSButtonMetro JBT_remover;
    private javax.swing.JTable JTB_dadosBeer;
    private javax.swing.JTable JTB_dadosBeer1;
    private javax.swing.JTable JTB_dadosBeer2;
    private javax.swing.JTable JTB_dadosBeer3;
    private javax.swing.JTextField JTF_buscar;
    private javax.swing.JFormattedTextField JTF_descricao;
    private javax.swing.JFormattedTextField JTF_descricao1;
    private javax.swing.JFormattedTextField JTF_idbeer;
    private javax.swing.JFormattedTextField JTF_idbeer1;
    private javax.swing.JFormattedTextField JTF_remover;
    private javax.swing.JFormattedTextField JTF_valor;
    private javax.swing.JFormattedTextField JTF_valor1;
    private javax.swing.JTabbedPane JTP_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
