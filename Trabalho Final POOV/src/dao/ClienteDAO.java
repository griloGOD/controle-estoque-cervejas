
package dao;

import bean.Cliente;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    private static Connection conn_conexao;
    
    private static void estabelecerConexao() throws SQLException, ClassNotFoundException{
        ClienteDAO.conn_conexao = Conexao.getConexao();
    }    
     public static void adicionarCliente(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        estabelecerConexao();
        PreparedStatement ps_estado;
        String s_msgSql = "insert into cliente(cpf,nome,telefone,endereco,insta) values(?,?,?,?,?)";
        
        ps_estado =  ClienteDAO.conn_conexao.prepareStatement(s_msgSql);
        ps_estado.setString(1, cliente.getCPF());
        ps_estado.setString(2, cliente.getNome());
        ps_estado.setString(3, cliente.getTel());
        ps_estado.setString(4, cliente.getEnd());
        ps_estado.setString(5, cliente.getInsta());
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n CLIENTE CADASTRADO COM SUCESSO");
    }
     public static void atualizar(Cliente cliente) throws SQLException, ClassNotFoundException
   {
        PreparedStatement ps_estado;
        estabelecerConexao();
        String s_msgSql = "update cliente set nome=?, telefone=?, endereco=?, insta=? where cpf=?";
        ps_estado =  ClienteDAO.conn_conexao.prepareStatement(s_msgSql);
        ps_estado.setString(1, cliente.getNome());
        ps_estado.setString(2, cliente.getTel());
        ps_estado.setString(3, cliente.getEnd());
        ps_estado.setString(4, cliente.getInsta());
        ps_estado.setString(5, cliente.getCPF());
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n CLIENTE ATUALIZADO COM SUCESSO.");
   }
     public static void remover(String CPF) throws SQLException, ClassNotFoundException
   {
        PreparedStatement ps_estado;
        estabelecerConexao();
        String s_msgSql = "delete from cliente where cpf = ?";
        ps_estado =  ClienteDAO.conn_conexao.prepareStatement(s_msgSql);
        ps_estado.setString(1, CPF);
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n CLIENTE DELETADO COM SUCESSO.");
   }
     public static ArrayList<Cliente> buscarClientes() throws SQLException, ClassNotFoundException 
   {
        estabelecerConexao();
        ArrayList<Cliente> al_listaTodos = new ArrayList();
        ResultSet rs_executaOperacao;
        PreparedStatement ps_estado;
        String s_operacao = "select * from cliente";
        ps_estado= ClienteDAO.conn_conexao.prepareStatement(s_operacao);
        rs_executaOperacao = ps_estado.executeQuery();

        while(rs_executaOperacao.next() == true)
        {
            
            Cliente client = new Cliente();
            client.setCPF((rs_executaOperacao.getString("cpf")));
            client.setNome(rs_executaOperacao.getString("nome"));
            client.setTel(rs_executaOperacao.getString("telefone"));
            client.setEnd(rs_executaOperacao.getString("endereco"));
            client.setInsta(rs_executaOperacao.getString("insta"));
            al_listaTodos.add(client);  
        }
        rs_executaOperacao.close();
        ps_estado.close();
        return(al_listaTodos);
   }
     public static ArrayList<Cliente> buscarClientesEmOrdem() throws SQLException, ClassNotFoundException 
   {
      
        estabelecerConexao();
        ArrayList<Cliente> al_listaTodos = new ArrayList();
        ResultSet rs_executaOperacao;
        PreparedStatement ps_estado;
        String s_operacao = "select * from cliente order by nome";
        ps_estado= ClienteDAO.conn_conexao.prepareStatement(s_operacao);
        rs_executaOperacao = ps_estado.executeQuery();
       while(rs_executaOperacao.next() == true)
        {
        Cliente cliente = new Cliente();
        cliente.setCPF(rs_executaOperacao.getString("cpf"));
        cliente.setNome(rs_executaOperacao.getString("nome"));
        cliente.setTel(rs_executaOperacao.getString("telefone"));
        cliente.setEnd(rs_executaOperacao.getString("endereco"));
        cliente.setInsta(rs_executaOperacao.getString("Insta"));
        al_listaTodos.add(cliente);     
        }
        rs_executaOperacao.close();
        ps_estado.close();
        return(al_listaTodos);
   }
     public static ArrayList<Cliente> buscarAvancada(String nome) throws SQLException, ClassNotFoundException 
   {
      
        estabelecerConexao();
        ArrayList<Cliente> al_listaTodos = new ArrayList();
        ResultSet rs_executaOperacao;
        PreparedStatement ps_estado;
        String s_operacao = "SELECT * FROM cliente WHERE nome LIKE ? ";
        ps_estado= ClienteDAO.conn_conexao.prepareStatement(s_operacao);
        ps_estado.setString(1, "%" + nome + "%");
        rs_executaOperacao = ps_estado.executeQuery();
        while(rs_executaOperacao.next() == true)
        {
        Cliente cliente = new Cliente();
        cliente.setCPF(rs_executaOperacao.getString("cpf"));
        cliente.setNome(rs_executaOperacao.getString("nome"));
        cliente.setTel(rs_executaOperacao.getString("telefone"));
        cliente.setEnd(rs_executaOperacao.getString("endereco"));
        cliente.setInsta(rs_executaOperacao.getString("insta"));
        al_listaTodos.add(cliente);     
        }
        
        rs_executaOperacao.close();
        ps_estado.close();
        return(al_listaTodos);
    
    }
     public static ArrayList<Cliente> buscarNome(String idBeer) throws SQLException, ClassNotFoundException 
   {
        estabelecerConexao();
        ArrayList<Cliente> al_listaid = new ArrayList();
        ResultSet rs_executaOperacao;
        PreparedStatement ps_estado;
        String s_operacao = "select * from cliente where cpf = ?";
        ps_estado= ClienteDAO.conn_conexao.prepareStatement(s_operacao);
        ps_estado.setString(1, idBeer);
        rs_executaOperacao = ps_estado.executeQuery();
        
        while(rs_executaOperacao.next() == true)
        {
            Cliente client = new Cliente();
            client.setCPF((rs_executaOperacao.getString("cpf")));
            client.setNome(rs_executaOperacao.getString("nome"));
            client.setTel(rs_executaOperacao.getString("telefone"));
            client.setEnd(rs_executaOperacao.getString("endereco"));
            client.setInsta(rs_executaOperacao.getString("insta"));
            
            al_listaid.add(client);
        }
        rs_executaOperacao.close();
        ps_estado.close();
        return(al_listaid);
   }

    public static ArrayList<Cliente> buscarCPF() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
     
}
