
package principal;

import bean.Cerveja;
import bean.Cliente;
import bean.Pedido;
import dao.CervejaDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PedidoTela extends javax.swing.JInternalFrame {
    
    DefaultTableModel dtm_tabela;
    ArrayList<Pedido> al_pedido = new ArrayList();
    private static PedidoTela telapedido;
    
    public static PedidoTela getInstance(){
        if(telapedido == null){
            telapedido = new PedidoTela();
        }
        return telapedido;
    }
    
    public PedidoTela() {
        initComponents();
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("imagens/check-list16px.png"));
        this.setFrameIcon(icon);
        dtm_tabela = new DefaultTableModel(null, new String[]{"Comanda","Id Pedido","CPF Cliente","Id Cerveja","Quantidade","Data"});
        
        try{
            JTF_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
            JTF_data1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
            
        }catch (java.text.ParseException ex)
        {
            System.out.println("\n"+ex.toString());
        }
        
        try {
            atualizaTabela();
        } catch (SQLException ex) {
            System.out.print("SQLException: "+ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.print("ClassNotFoundException: "+ex.toString());
        }

        ClienteDAO cliente = new ClienteDAO();
        try {
            for (Cliente p: cliente.buscarClientes()){
                JCB_CPF.addItem(p);
                JCB_CPF1.addItem(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoTela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoTela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CervejaDAO cerveja = new CervejaDAO();
        try {
            for (Cerveja p: cerveja.buscarCervejas()){
                JCB_cerveja.addItem(p);
                JCB_cerveja1.addItem(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoTela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoTela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    private void atualizaTabela() throws SQLException, ClassNotFoundException
    {
        JTB_dados.setModel(dtm_tabela);
        JTB_dados1.setModel(dtm_tabela);
        JTB_dados2.setModel(dtm_tabela);
        JTB_dados3.setModel(dtm_tabela);
        dtm_tabela.setNumRows(0);
        al_pedido = PedidoDAO.buscarTodosPedidos();
        for (Pedido c : al_pedido) 
        {
           dtm_tabela.addRow(new Object[]{c.getId_cerveja_pedido(),c.getId_pedido(),c.getFk_cpf_cliente(),c.getFk_id_cerveja(),c.getQuantidade()});
	}
        
        
    }
    private void limparTela()
        {
            LocalDate ld_hoje = LocalDate.now();
            DateTimeFormatter df_formatador1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld_hoje.format(df_formatador1);
            ld_hoje.toString();
            
            
            JTF_idpedido.setText("");
            JTF_quantidade.setText("");
            JTF_idcervejapedido.setText("");
        }
    
    private void buscarNaTabela(String id) throws SQLException, ClassNotFoundException
    {
        JTB_dados.setModel(dtm_tabela);
        dtm_tabela.setNumRows(0);
        al_pedido = PedidoDAO.buscarTodosPedidos();
        for (Cerveja c : CervejaDAO.buscarAvancada(id)) 
        {
            dtm_tabela.addRow(new Object[]{c.getIdBeer(), c.getDescricao(),c.getValor()});
	}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTP_cliente = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        JTF_buscar = new javax.swing.JTextField();
        JBT_buscar = new rojerusan.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_dados = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTB_dados1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JBT_gerarpedido = new rojerusan.RSButtonMetro();
        JTF_idpedido = new javax.swing.JFormattedTextField();
        JTF_data = new javax.swing.JFormattedTextField();
        JTF_quantidade = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        JTF_idcervejapedido = new javax.swing.JFormattedTextField();
        JCB_CPF = new javax.swing.JComboBox<>();
        JCB_cerveja = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTB_dados2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JBT_alterarpedido = new rojerusan.RSButtonMetro();
        JTF_idpedido1 = new javax.swing.JFormattedTextField();
        JTF_data1 = new javax.swing.JFormattedTextField();
        JTF_quantidade1 = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        JTF_idcervejapedido1 = new javax.swing.JFormattedTextField();
        JCB_CPF1 = new javax.swing.JComboBox<>();
        JCB_cerveja1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTB_dados3 = new javax.swing.JTable();
        JTF_remover = new javax.swing.JTextField();
        JBT_remover = new rojerusan.RSButtonMetro();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(8, 30, 65));
        setBorder(null);
        setTitle("PEDIDOS");
        setToolTipText("ADICIONAR CLIENTE");
        getContentPane().setLayout(null);

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

        JBT_buscar.setBackground(new java.awt.Color(24, 52, 81));
        JBT_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search.png"))); // NOI18N
        JBT_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_buscarActionPerformed(evt);
            }
        });
        JBT_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JBT_buscarKeyPressed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        JTB_dados.setAutoCreateRowSorter(true);
        JTB_dados.setBackground(new java.awt.Color(69, 104, 139));
        JTB_dados.setForeground(new java.awt.Color(255, 255, 255));
        JTB_dados.setModel(new javax.swing.table.DefaultTableModel(
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
        JTB_dados.setGridColor(new java.awt.Color(204, 204, 204));
        JTB_dados.setInheritsPopupMenu(true);
        JTB_dados.setSelectionBackground(new java.awt.Color(204, 255, 255));
        JTB_dados.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(JTB_dados);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Id Comanda");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(JTF_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(JBT_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBT_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(JTF_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTP_cliente.addTab("BUSCAR", jPanel1);

        jPanel2.setBackground(new java.awt.Color(24, 52, 81));

        jScrollPane2.setBorder(null);

        JTB_dados1.setAutoCreateRowSorter(true);
        JTB_dados1.setBackground(new java.awt.Color(69, 104, 139));
        JTB_dados1.setForeground(new java.awt.Color(255, 255, 255));
        JTB_dados1.setModel(new javax.swing.table.DefaultTableModel(
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
        JTB_dados1.setGridColor(new java.awt.Color(204, 204, 204));
        JTB_dados1.setInheritsPopupMenu(true);
        JTB_dados1.setSelectionBackground(new java.awt.Color(204, 255, 255));
        JTB_dados1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(JTB_dados1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id Pedido");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CPF Cliente");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Id Cerveja");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Id Comanda");

        JBT_gerarpedido.setBackground(new java.awt.Color(24, 52, 81));
        JBT_gerarpedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        JBT_gerarpedido.setText("Gerar Pedido");
        JBT_gerarpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_gerarpedidoActionPerformed(evt);
            }
        });

        JTF_idpedido.setBackground(new java.awt.Color(69, 104, 139));
        JTF_idpedido.setBorder(null);
        JTF_idpedido.setForeground(new java.awt.Color(255, 255, 255));
        JTF_idpedido.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_data.setBackground(new java.awt.Color(69, 104, 139));
        JTF_data.setBorder(null);
        JTF_data.setForeground(new java.awt.Color(255, 255, 255));
        JTF_data.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_quantidade.setBackground(new java.awt.Color(69, 104, 139));
        JTF_quantidade.setBorder(null);
        JTF_quantidade.setForeground(new java.awt.Color(255, 255, 255));
        JTF_quantidade.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Quantidade");

        JTF_idcervejapedido.setBackground(new java.awt.Color(69, 104, 139));
        JTF_idcervejapedido.setBorder(null);
        JTF_idcervejapedido.setForeground(new java.awt.Color(255, 255, 255));
        JTF_idcervejapedido.setCaretColor(new java.awt.Color(255, 255, 255));

        JCB_CPF.setBackground(new java.awt.Color(69, 104, 139));
        JCB_CPF.setForeground(new java.awt.Color(255, 255, 255));
        JCB_CPF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< Escolha uma opção  abaixo >" }));
        JCB_CPF.setBorder(null);
        JCB_CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_CPFActionPerformed(evt);
            }
        });

        JCB_cerveja.setBackground(new java.awt.Color(69, 104, 139));
        JCB_cerveja.setForeground(new java.awt.Color(255, 255, 255));
        JCB_cerveja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< Escolha uma opção abaixo >" }));
        JCB_cerveja.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel5)
                .addGap(186, 186, 186)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(93, 93, 93))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1)
                .addGap(203, 203, 203)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(126, 126, 126))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTF_idpedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_idcervejapedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCB_CPF, 0, 250, Short.MAX_VALUE)
                            .addComponent(JCB_cerveja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTF_data, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(JTF_quantidade)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(JBT_gerarpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_data, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JCB_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTF_idcervejapedido, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel13))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_idpedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTF_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCB_cerveja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(JBT_gerarpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        JTP_cliente.addTab("INSERIR", jPanel2);

        jPanel3.setBackground(new java.awt.Color(24, 52, 81));

        jScrollPane3.setBorder(null);

        JTB_dados2.setAutoCreateRowSorter(true);
        JTB_dados2.setBackground(new java.awt.Color(69, 104, 139));
        JTB_dados2.setForeground(new java.awt.Color(255, 255, 255));
        JTB_dados2.setModel(new javax.swing.table.DefaultTableModel(
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
        JTB_dados2.setGridColor(new java.awt.Color(204, 204, 204));
        JTB_dados2.setInheritsPopupMenu(true);
        JTB_dados2.setSelectionBackground(new java.awt.Color(204, 255, 255));
        JTB_dados2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(JTB_dados2);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Id Comanda");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CPF Cliente");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Id Cerveja");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Id Pedido");

        JBT_alterarpedido.setBackground(new java.awt.Color(24, 52, 81));
        JBT_alterarpedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/refresh.png"))); // NOI18N
        JBT_alterarpedido.setText("Alterar Pedido");
        JBT_alterarpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_alterarpedidoActionPerformed(evt);
            }
        });

        JTF_idpedido1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_idpedido1.setBorder(null);
        JTF_idpedido1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_idpedido1.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_data1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_data1.setBorder(null);
        JTF_data1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_data1.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_quantidade1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_quantidade1.setBorder(null);
        JTF_quantidade1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_quantidade1.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Quantidade");

        JTF_idcervejapedido1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_idcervejapedido1.setBorder(null);
        JTF_idcervejapedido1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_idcervejapedido1.setCaretColor(new java.awt.Color(255, 255, 255));

        JCB_CPF1.setBackground(new java.awt.Color(69, 104, 139));
        JCB_CPF1.setForeground(new java.awt.Color(255, 255, 255));
        JCB_CPF1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< Escolha uma opção  abaixo >" }));
        JCB_CPF1.setBorder(null);
        JCB_CPF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_CPF1ActionPerformed(evt);
            }
        });

        JCB_cerveja1.setBackground(new java.awt.Color(69, 104, 139));
        JCB_cerveja1.setForeground(new java.awt.Color(255, 255, 255));
        JCB_cerveja1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< Escolha uma opção abaixo >" }));
        JCB_cerveja1.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel6)
                        .addGap(196, 196, 196)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(77, 77, 77))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel10)
                        .addGap(174, 174, 174)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(110, 110, 110))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTF_idpedido1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTF_idcervejapedido1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JCB_CPF1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCB_cerveja1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTF_data1)
                            .addComponent(JTF_quantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JBT_alterarpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_data1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JCB_CPF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTF_idcervejapedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_idpedido1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTF_quantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCB_cerveja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(JBT_alterarpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTP_cliente.addTab("ALTERAR", jPanel3);

        jPanel4.setBackground(new java.awt.Color(24, 52, 81));

        jScrollPane4.setBorder(null);

        JTB_dados3.setAutoCreateRowSorter(true);
        JTB_dados3.setBackground(new java.awt.Color(69, 104, 139));
        JTB_dados3.setForeground(new java.awt.Color(255, 255, 255));
        JTB_dados3.setModel(new javax.swing.table.DefaultTableModel(
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
        JTB_dados3.setGridColor(new java.awt.Color(204, 204, 204));
        JTB_dados3.setInheritsPopupMenu(true);
        JTB_dados3.setSelectionBackground(new java.awt.Color(204, 255, 255));
        JTB_dados3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(JTB_dados3);

        JTF_remover.setBackground(new java.awt.Color(69, 104, 139));
        JTF_remover.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTF_remover.setForeground(new java.awt.Color(255, 255, 255));
        JTF_remover.setBorder(null);
        JTF_remover.setCaretColor(new java.awt.Color(255, 255, 255));
        JTF_remover.setPreferredSize(new java.awt.Dimension(2, 20));
        JTF_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_removerActionPerformed(evt);
            }
        });

        JBT_remover.setBackground(new java.awt.Color(24, 52, 81));
        JBT_remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remove.png"))); // NOI18N
        JBT_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_removerActionPerformed(evt);
            }
        });
        JBT_remover.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JBT_removerKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Id Comanda");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(JTF_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBT_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBT_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTP_cliente.addTab("REMOVER", jPanel4);

        getContentPane().add(JTP_cliente);
        JTP_cliente.setBounds(0, 0, 820, 619);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_buscarActionPerformed
        JTF_buscar.setText("");
    }//GEN-LAST:event_JTF_buscarActionPerformed

    private void JBT_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_buscarActionPerformed
        try {
           buscarNaTabela(JTF_buscar.getText());
        } catch (SQLException ex) {
            System.out.print("SQLException: "+ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.print("ClassNotFoundException: "+ex.toString());
        }  
        limparTela();
                   
    }//GEN-LAST:event_JBT_buscarActionPerformed

    private void JBT_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBT_buscarKeyPressed

    }//GEN-LAST:event_JBT_buscarKeyPressed

    private void JBT_gerarpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_gerarpedidoActionPerformed

        
        if(JCB_CPF.getSelectedItem().equals("< Escolha uma opção abaixo >")){
            JOptionPane.showMessageDialog(null, "Opção inválida, escolha as outras abaixo", null, WIDTH);
        }else{
            if (JCB_cerveja.getSelectedItem().equals("< Escolha uma opção abaixo >")){
                JOptionPane.showMessageDialog(null, "Opção inválida, escolha as outras abaixo", null, WIDTH);
            }else{
                try{
                    Pedido pedido = new Pedido();
                    String s_idPedido, s_idCerveja, s_CPF, s_idCervejaPedido;
                    int i_quantidade;
                    Cliente cliente = (Cliente) JCB_CPF.getSelectedItem();
                    s_idCervejaPedido = JTF_idcervejapedido.getText();
                    s_idPedido = JTF_idpedido.getText();
                    s_CPF = JCB_CPF.getSelectedItem().toString();
                    s_idCerveja = JCB_cerveja.getSelectedItem().toString();
                    i_quantidade = Integer.parseInt(JTF_quantidade.getText());
                    pedido.setId_cerveja_pedido(s_idCervejaPedido);
                    pedido.setId_pedido(s_idPedido);
                    pedido.setFk_cpf_cliente(s_CPF);
                    pedido.setFk_id_cerveja(s_idCerveja);
                    pedido.setQuantidade(i_quantidade);
                    PedidoDAO.adicionarPedido(pedido);
                    atualizaTabela();
                    limparTela();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                JOptionPane.showMessageDialog(null, "Pedido gerado com sucesso ");
            }
        }
    }//GEN-LAST:event_JBT_gerarpedidoActionPerformed

    private void JCB_CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_CPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCB_CPFActionPerformed

    private void JBT_alterarpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_alterarpedidoActionPerformed
        if(JCB_CPF.getSelectedItem().equals("< Escolha uma opção abaixo >")){
            JOptionPane.showMessageDialog(null, "Opção inválida, escolha as outras abaixo", null, WIDTH);
        }else{
            if (JCB_cerveja.getSelectedItem().equals("< Escolha uma opção abaixo >")){
                JOptionPane.showMessageDialog(null, "Opção inválida, escolha as outras abaixo", null, WIDTH);
            }else{
                try {
                    Pedido pedido = new Pedido();
                    String s_id_cerveja_pedido, s_pedido, s_fk_cpf, s_fk_id_cerveja, s_data;
                    int i_quantidade;
                    s_id_cerveja_pedido = JTF_idcervejapedido1.getText();
                    s_pedido = JTF_idpedido.getText();
                    s_fk_cpf = JCB_CPF.getSelectedItem().toString();
                    s_fk_id_cerveja = JCB_cerveja.getSelectedItem().toString();
                    s_data = JTF_data1.getText();
                    i_quantidade = Integer.parseInt(JTF_quantidade1.getText());
                    pedido.setId_cerveja_pedido(s_id_cerveja_pedido);
                    pedido.setId_pedido(s_pedido);
                    pedido.setFk_cpf_cliente(s_fk_cpf);
                    pedido.setFk_id_cerveja(s_fk_id_cerveja);
                    pedido.setQuantidade(i_quantidade);
                    pedido.setData_pedido(s_data);
                    PedidoDAO.atualizar(pedido);
                    atualizaTabela();
                    limparTela();
                    JOptionPane.showMessageDialog(null, "Pedido alterado com sucesso");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_JBT_alterarpedidoActionPerformed

    private void JCB_CPF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_CPF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCB_CPF1ActionPerformed

    private void JTF_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_removerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_removerActionPerformed

    private void JBT_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_removerActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja"
                + "remover esse pedido?");
        if(confirma == JOptionPane.YES_OPTION)
        {
             String s_id_cerveja_pedido = JTF_remover.getText();
            try {
                PedidoDAO.removerPedido(s_id_cerveja_pedido);
                atualizaTabela();
                limparTela();
                JOptionPane.showMessageDialog(null, "Pedido removido com sucesso");
            } catch (SQLException ex) {
                System.out.print("SQLException: "+ex.toString());
            } catch (ClassNotFoundException ex) {
                System.out.print("ClassNotFoundException: "+ex.toString());
            }
        } 
    }//GEN-LAST:event_JBT_removerActionPerformed

    private void JBT_removerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBT_removerKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBT_removerKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro JBT_alterarpedido;
    private rojerusan.RSButtonMetro JBT_buscar;
    private rojerusan.RSButtonMetro JBT_gerarpedido;
    private rojerusan.RSButtonMetro JBT_remover;
    private javax.swing.JComboBox<Object> JCB_CPF;
    private javax.swing.JComboBox<Object> JCB_CPF1;
    private javax.swing.JComboBox<Object> JCB_cerveja;
    private javax.swing.JComboBox<Object> JCB_cerveja1;
    private javax.swing.JTable JTB_dados;
    private javax.swing.JTable JTB_dados1;
    private javax.swing.JTable JTB_dados2;
    private javax.swing.JTable JTB_dados3;
    private javax.swing.JTextField JTF_buscar;
    private javax.swing.JFormattedTextField JTF_data;
    private javax.swing.JFormattedTextField JTF_data1;
    private javax.swing.JFormattedTextField JTF_idcervejapedido;
    private javax.swing.JFormattedTextField JTF_idcervejapedido1;
    private javax.swing.JFormattedTextField JTF_idpedido;
    private javax.swing.JFormattedTextField JTF_idpedido1;
    private javax.swing.JFormattedTextField JTF_quantidade;
    private javax.swing.JFormattedTextField JTF_quantidade1;
    private javax.swing.JTextField JTF_remover;
    private javax.swing.JTabbedPane JTP_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
