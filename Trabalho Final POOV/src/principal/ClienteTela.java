
package principal;

import bean.Cliente;
import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ClienteTela extends javax.swing.JInternalFrame {
    
    DefaultTableModel dtm_tabela;
    DefaultTableModel dtm_tabelabusca;
    ArrayList<Cliente> al_listaCliente;
    
    private static ClienteTela telacliente;
    
    public static ClienteTela getInstance(){
        if(telacliente == null){
            telacliente = new ClienteTela();
        }
        return telacliente;
    }
        
    public ClienteTela() {
        initComponents();
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("imagens/cliente16px.png"));
        this.setFrameIcon(icon);
        dtm_tabela = new DefaultTableModel(null, new String[]{"CPF","Nome","Telefone","Endereço","Instagram"});
        dtm_tabelabusca = new DefaultTableModel(null, new String[]{"CPF","Nome","Telefone","Endereço","Instagram"});
        try{
            JTF_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
            JTF_tel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
            JTF_cpf1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
            JTF_tel1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
            JTF_remover.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
            JTF_buscar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        }catch (java.text.ParseException ex)
        {
            System.out.println("\n"+ex.toString());
        }
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
        JTF_cpf.setText("");
        JTF_nome.setText("");
        JTF_tel.setText("");
        JTF_end.setText("");
        JTF_insta.setText("");
        JTF_buscar.setText("");
        JTF_remover.setText("");
    }
    private void buscarNaTabela(String nome) throws SQLException, ClassNotFoundException
        {
            JTB_dados.setModel(dtm_tabelabusca);
            dtm_tabelabusca.setNumRows(0);
            al_listaCliente = ClienteDAO.buscarClientes();
        for (Cliente c : ClienteDAO.buscarAvancada(nome)) 
        {
            dtm_tabelabusca.addRow(new Object[]{c.getCPF(), c.getNome(),c.getTel(),
                c.getEnd(), c.getInsta()});
	}
        }
    private void atualizaTabela() throws SQLException, ClassNotFoundException
    {
        JTB_dados.setModel(dtm_tabelabusca);
        JTB_dados1.setModel(dtm_tabela);
        JTB_dados2.setModel(dtm_tabela);
        JTB_dados3.setModel(dtm_tabela);
        dtm_tabela.setNumRows(0);
        al_listaCliente = ClienteDAO.buscarClientes();
        for (Cliente c : al_listaCliente) 
        {
            dtm_tabela.addRow(new Object[]{c.getCPF(), c.getNome(), c.getTel(), c.getEnd(), c.getInsta()});
            dtm_tabelabusca.addRow(new Object[]{c.getCPF(), c.getNome(), c.getTel(), c.getEnd(), c.getInsta()});
	}
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTP_cliente = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        JBT_buscarCliente = new rojerusan.RSButtonMetro();
        JBT_ordenar = new rojerusan.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_dados = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        JTF_buscar = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTB_dados1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JBT_insereCliente = new rojerusan.RSButtonMetro();
        JTF_cpf = new javax.swing.JFormattedTextField();
        JTF_nome = new javax.swing.JFormattedTextField();
        JTF_tel = new javax.swing.JFormattedTextField();
        JTF_end = new javax.swing.JFormattedTextField();
        JTF_insta = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTB_dados2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JBT_alteraCliente = new rojerusan.RSButtonMetro();
        JTF_cpf1 = new javax.swing.JFormattedTextField();
        JTF_nome1 = new javax.swing.JFormattedTextField();
        JTF_tel1 = new javax.swing.JFormattedTextField();
        JTF_end1 = new javax.swing.JFormattedTextField();
        JTF_insta1 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        JBT_remover = new rojerusan.RSButtonMetro();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTB_dados3 = new javax.swing.JTable();
        JTF_remover = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(8, 30, 65));
        setBorder(null);
        setResizable(true);
        setTitle("CLIENTES");
        setToolTipText("ADICIONAR CLIENTE");

        JTP_cliente.setBackground(new java.awt.Color(95, 133, 171));
        JTP_cliente.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        JTP_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTP_cliente.setFocusable(false);

        jPanel1.setBackground(new java.awt.Color(24, 52, 81));

        JBT_buscarCliente.setBackground(new java.awt.Color(24, 52, 81));
        JBT_buscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Search.png"))); // NOI18N
        JBT_buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_buscarClienteActionPerformed(evt);
            }
        });
        JBT_buscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JBT_buscarClienteKeyPressed(evt);
            }
        });

        JBT_ordenar.setBackground(new java.awt.Color(24, 52, 81));
        JBT_ordenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/AtoZ.png"))); // NOI18N
        JBT_ordenar.setText("Ordenar");
        JBT_ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_ordenarActionPerformed(evt);
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
        jLabel11.setText("NOME");

        JTF_buscar.setBackground(new java.awt.Color(69, 104, 139));
        JTF_buscar.setBorder(null);
        JTF_buscar.setForeground(new java.awt.Color(255, 255, 255));
        JTF_buscar.setCaretColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(JTF_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(JBT_buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBT_ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JBT_buscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(JTF_buscar))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JBT_ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
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
        jLabel1.setText("CPF");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOME");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TELEFONE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ENDEREÇO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INSTAGRAM");

        JBT_insereCliente.setBackground(new java.awt.Color(24, 52, 81));
        JBT_insereCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        JBT_insereCliente.setText("Inserir Cliente");
        JBT_insereCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_insereClienteActionPerformed(evt);
            }
        });

        JTF_cpf.setBackground(new java.awt.Color(69, 104, 139));
        JTF_cpf.setBorder(null);
        JTF_cpf.setForeground(new java.awt.Color(255, 255, 255));
        JTF_cpf.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_nome.setBackground(new java.awt.Color(69, 104, 139));
        JTF_nome.setBorder(null);
        JTF_nome.setForeground(new java.awt.Color(255, 255, 255));
        JTF_nome.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_tel.setBackground(new java.awt.Color(69, 104, 139));
        JTF_tel.setBorder(null);
        JTF_tel.setForeground(new java.awt.Color(255, 255, 255));
        JTF_tel.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_end.setBackground(new java.awt.Color(69, 104, 139));
        JTF_end.setBorder(null);
        JTF_end.setForeground(new java.awt.Color(255, 255, 255));
        JTF_end.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_insta.setBackground(new java.awt.Color(69, 104, 139));
        JTF_insta.setBorder(null);
        JTF_insta.setForeground(new java.awt.Color(255, 255, 255));
        JTF_insta.setCaretColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBT_insereCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(70, 70, 70))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(JTF_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JTF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JTF_end))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTF_tel, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(JTF_insta))))
                        .addGap(6, 6, 6)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(229, 229, 229)
                .addComponent(jLabel3)
                .addGap(93, 93, 93))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_tel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTF_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTF_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_end, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_insta, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBT_insereCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jLabel6.setText("CPF");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NOME");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TELEFONE");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ENDEREÇO");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("INSTAGRAM");

        JBT_alteraCliente.setBackground(new java.awt.Color(24, 52, 81));
        JBT_alteraCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/refresh.png"))); // NOI18N
        JBT_alteraCliente.setText("Alterar Dados");
        JBT_alteraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_alteraClienteActionPerformed(evt);
            }
        });

        JTF_cpf1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_cpf1.setBorder(null);
        JTF_cpf1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_cpf1.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_nome1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_nome1.setBorder(null);
        JTF_nome1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_nome1.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_tel1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_tel1.setBorder(null);
        JTF_tel1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_tel1.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_end1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_end1.setBorder(null);
        JTF_end1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_end1.setCaretColor(new java.awt.Color(255, 255, 255));

        JTF_insta1.setBackground(new java.awt.Color(69, 104, 139));
        JTF_insta1.setBorder(null);
        JTF_insta1.setForeground(new java.awt.Color(255, 255, 255));
        JTF_insta1.setCaretColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBT_alteraCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(70, 70, 70))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(JTF_cpf1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JTF_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(JTF_end1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTF_tel1)
                                    .addComponent(JTF_insta1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(229, 229, 229)
                        .addComponent(jLabel8)
                        .addGap(83, 83, 83)))
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTF_tel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTF_cpf1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTF_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_end1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_insta1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JBT_alteraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTP_cliente.addTab("ALTERAR", jPanel3);

        jPanel4.setBackground(new java.awt.Color(24, 52, 81));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CPF");

        JBT_remover.setBackground(new java.awt.Color(24, 52, 81));
        JBT_remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remove.png"))); // NOI18N
        JBT_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_removerActionPerformed(evt);
            }
        });

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
        JTF_remover.setBorder(null);
        JTF_remover.setForeground(new java.awt.Color(255, 255, 255));
        JTF_remover.setCaretColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(JTF_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBT_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBT_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(JTF_remover, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JTP_cliente.addTab("REMOVER", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTP_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTP_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBT_buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_buscarClienteActionPerformed
      try {
           buscarNaTabela(JTF_buscar.getText());
        } catch (SQLException ex) {
            System.out.print("SQLException: "+ex.toString());
        } catch (ClassNotFoundException ex) {
            System.out.print("ClassNotFoundException: "+ex.toString());
        }  
      limparTela();
    }//GEN-LAST:event_JBT_buscarClienteActionPerformed

    private void JBT_insereClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_insereClienteActionPerformed
       try {
            Cliente cli_cliente = new Cliente();
            String s_cpf, s_nome, s_end, s_insta, s_tel; 
            s_cpf = JTF_cpf.getText();
            s_nome = JTF_nome.getText();
            s_tel = JTF_tel.getText();
            s_end = JTF_end.getText();
            s_insta = JTF_insta.getText();
            cli_cliente.setCPF(s_cpf);
            cli_cliente.setNome(s_nome);
            cli_cliente.setTel(s_tel);
            cli_cliente.setEnd(s_end);
            cli_cliente.setInsta(s_insta);
            ClienteDAO.adicionarCliente(cli_cliente);
            atualizaTabela();
            limparTela();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso ");
    }//GEN-LAST:event_JBT_insereClienteActionPerformed

    private void JBT_ordenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_ordenarActionPerformed
        try {
            al_listaCliente = ClienteDAO.buscarClientesEmOrdem();
            JTB_dados.setModel(dtm_tabela);
            dtm_tabela.setNumRows(0);
            for (Cliente c : al_listaCliente)
            {
                dtm_tabela.addRow(new Object[]{c.getCPF(), c.getNome(),c.getTel(),
                c.getEnd(), c.getInsta()});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteTela.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteTela.class.getName()).log(Level.SEVERE, null, ex);
        }
        limparTela();
    }//GEN-LAST:event_JBT_ordenarActionPerformed

    private void JBT_buscarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBT_buscarClienteKeyPressed
       
    }//GEN-LAST:event_JBT_buscarClienteKeyPressed

    private void JBT_alteraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_alteraClienteActionPerformed
       try {
            Cliente cliente = new Cliente();
            String s_cpf, s_nome, s_tel, s_end, s_insta;
            s_cpf = JTF_cpf1.getText();
            s_nome = JTF_nome1.getText();
            s_tel = JTF_tel1.getText();
            s_end = JTF_end1.getText();
            s_insta = JTF_insta1.getText();
            cliente.setCPF(s_cpf);
            cliente.setNome(s_nome);
            cliente.setTel(s_tel);
            cliente.setEnd(s_end);
            cliente.setInsta(s_insta);
            ClienteDAO.atualizar(cliente);
            atualizaTabela();
            limparTela();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_JBT_alteraClienteActionPerformed

    private void JBT_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_removerActionPerformed
       int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja"
                + "remover esse cliente?");
        if(confirma == JOptionPane.YES_OPTION)
        {
             String s_idBuscado = JTF_remover.getText();
            try {
                ClienteDAO.remover(s_idBuscado);
                atualizaTabela();
                limparTela();
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
            } catch (SQLException ex) {
                System.out.print("SQLException: "+ex.toString());
            } catch (ClassNotFoundException ex) {
                System.out.print("ClassNotFoundException: "+ex.toString());
            }
        } 
    }//GEN-LAST:event_JBT_removerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonMetro JBT_alteraCliente;
    private rojerusan.RSButtonMetro JBT_buscarCliente;
    private rojerusan.RSButtonMetro JBT_insereCliente;
    private rojerusan.RSButtonMetro JBT_ordenar;
    private rojerusan.RSButtonMetro JBT_remover;
    private javax.swing.JTable JTB_dados;
    private javax.swing.JTable JTB_dados1;
    private javax.swing.JTable JTB_dados2;
    private javax.swing.JTable JTB_dados3;
    private javax.swing.JFormattedTextField JTF_buscar;
    private javax.swing.JFormattedTextField JTF_cpf;
    private javax.swing.JFormattedTextField JTF_cpf1;
    private javax.swing.JFormattedTextField JTF_end;
    private javax.swing.JFormattedTextField JTF_end1;
    private javax.swing.JFormattedTextField JTF_insta;
    private javax.swing.JFormattedTextField JTF_insta1;
    private javax.swing.JFormattedTextField JTF_nome;
    private javax.swing.JFormattedTextField JTF_nome1;
    private javax.swing.JFormattedTextField JTF_remover;
    private javax.swing.JFormattedTextField JTF_tel;
    private javax.swing.JFormattedTextField JTF_tel1;
    private javax.swing.JTabbedPane JTP_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
