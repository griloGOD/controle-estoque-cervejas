
package dao;

import bean.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import conexao.Conexao;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;



public class PedidoDAO {
 
     private static Connection conn_conexao;
     private static void estabelecerConexao() throws SQLException, ClassNotFoundException
        {
            PedidoDAO.conn_conexao = Conexao.getConexao();
        }
   public static void adicionarPedido(Pedido pedido) throws SQLException, ClassNotFoundException
   {
        estabelecerConexao();
        PreparedStatement ps_estado;
        String s_operacao = "insert into pedidos (id_cerveja_pedido,id_pedido,fk_cpf_cliente,fk_id_cerveja,quantidade) values(?,?,?,?,?)";
        ps_estado = PedidoDAO.conn_conexao.prepareStatement(s_operacao);
        ps_estado.setString(1, pedido.getId_cerveja_pedido());
        ps_estado.setString(2, pedido.getId_pedido());
        ps_estado.setString(3, pedido.getFk_cpf_cliente());
        ps_estado.setString(4, pedido.getFk_id_cerveja());
        ps_estado.setInt(5, pedido.getQuantidade());
        ps_estado.execute();
        ps_estado.close();        
    }
   public static void atualizar(Pedido pedido) throws SQLException, ClassNotFoundException
   {
        PreparedStatement ps_estado;
        estabelecerConexao();
        String s_msgSql = "update pedidos set id_pedido=?, fk_cpf_cliente=?, fk_id_cerveja=?, quantidade=? where id_cerveja_pedido=?";
        ps_estado =  PedidoDAO.conn_conexao.prepareStatement(s_msgSql);
        ps_estado.setString(1, pedido.getId_pedido());
        ps_estado.setString(2, pedido.getFk_cpf_cliente());
        ps_estado.setString(3, pedido.getFk_id_cerveja());
        ps_estado.setInt(4, pedido.getQuantidade());
        ps_estado.setString(6, pedido.getId_cerveja_pedido());
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n PEDIDO ATUALIZADO COM SUCESSO.");
   }
   
   public static ArrayList<Pedido> buscarTodosPedidos() throws SQLException, ClassNotFoundException 
   {
      
        estabelecerConexao();
        ArrayList<Pedido> al_listaTodos = new ArrayList();
        ResultSet rs_executaOperacao;
        PreparedStatement ps_estado;
        String s_operacao = "SELECT * FROM pedidos ";
        ps_estado= PedidoDAO.conn_conexao.prepareStatement(s_operacao);
        rs_executaOperacao = ps_estado.executeQuery();
       while(rs_executaOperacao.next() == true)
        {
            Pedido pedido = new Pedido();
            pedido.setId_cerveja_pedido(rs_executaOperacao.getString("id_cerveja_pedido"));
            pedido.setId_pedido(rs_executaOperacao.getString("id_pedido"));
            pedido.setFk_cpf_cliente(rs_executaOperacao.getString("fk_cpf_cliente"));
            pedido.setFk_id_cerveja(rs_executaOperacao.getString("fk_id_cerveja"));
            pedido.setQuantidade(rs_executaOperacao.getInt("quantidade"));
            pedido.setData_pedido(rs_executaOperacao.getString("data_pedido"));
            al_listaTodos.add(pedido);     
        }
        rs_executaOperacao.close();
        ps_estado.close();
        return(al_listaTodos);
   }
   
public static ArrayList<Pedido> buscarID(String idBeer) throws SQLException, ClassNotFoundException 
   {
        estabelecerConexao();
        ArrayList<Pedido> al_listaid = new ArrayList();
        ResultSet rs_executaOperacao;
        PreparedStatement ps_estado;
        String s_operacao = "select * from pedido where id_cerveja_pedido= ?";
        ps_estado= PedidoDAO.conn_conexao.prepareStatement(s_operacao);
        ps_estado.setString(1, idBeer);
        rs_executaOperacao = ps_estado.executeQuery();
        
        while(rs_executaOperacao.next() == true)
        {
            Pedido pedido = new Pedido();
            pedido.setId_cerveja_pedido((rs_executaOperacao.getString("id_cerveja_pedido")));
            pedido.setId_pedido(rs_executaOperacao.getString("id_pedido"));
            pedido.setFk_cpf_cliente(rs_executaOperacao.getString("fk_cpf_cliente"));
            pedido.setFk_id_cerveja(rs_executaOperacao.getString("fk_id_cerveja"));
            pedido.setQuantidade(rs_executaOperacao.getInt("quantidade"));
            
            al_listaid.add(pedido);
        }
        rs_executaOperacao.close();
        ps_estado.close();
        return(al_listaid);
   }
 public static void removerPedido (String pedido) throws SQLException,
 ClassNotFoundException
 {
     estabelecerConexao();
     PreparedStatement ps_estado;
     String dale = "delete from pedidos where id_cerveja_pedido = ?";
     ps_estado = PedidoDAO.conn_conexao.prepareStatement(dale);
     ps_estado.setString(1, pedido);
     ps_estado.execute();
     ps_estado.close();
         
 }   

    
    
}
