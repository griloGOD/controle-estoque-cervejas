
package dao;

import bean.Cerveja;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CervejaDAO {
    private static Connection conn_conexao;
    
    private static void estabelecerConexao() throws SQLException, ClassNotFoundException{
        CervejaDAO.conn_conexao = Conexao.getConexao();
    } 
    
    public static void adicionarCerveja(Cerveja cerveja) throws SQLException, ClassNotFoundException
    {
        estabelecerConexao();
        PreparedStatement ps_estado;
        String s_msgSql = "insert into cerveja(idBeer,descricao,valor) values(?,?,?)";
        
        ps_estado =  CervejaDAO.conn_conexao.prepareStatement(s_msgSql);
        ps_estado.setString(1, cerveja.getIdBeer());
        ps_estado.setString(2, cerveja.getDescricao());
        ps_estado.setFloat(3, cerveja.getValor());
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n CERVEJA CADASTRADA COM SUCESSO");
    }
    public static void atualizar(Cerveja cerveja) throws SQLException, ClassNotFoundException
   {
        PreparedStatement ps_estado;
        estabelecerConexao();
        String s_msgSql = "update cerveja set descricao=?, valor=? where idBeer=?";
        ps_estado =  CervejaDAO.conn_conexao.prepareStatement(s_msgSql);
        ps_estado.setString(1, cerveja.getDescricao());
        ps_estado.setFloat(2, cerveja.getValor());
        ps_estado.setString(3, cerveja.getIdBeer());
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n CERVEJA ATUALIZADA COM SUCESSO.");
   }
    public static void remover(String idBeer) throws SQLException, ClassNotFoundException
   {
        PreparedStatement ps_estado;
        estabelecerConexao();
        String s_msgSql = "delete from cerveja where idBeer = ?";
        ps_estado =  CervejaDAO.conn_conexao.prepareStatement(s_msgSql);
        ps_estado.setString(1, idBeer);
        ps_estado.execute();
        ps_estado.close();
        System.out.println("\n CERVEJA DELETADA COM SUCESSO.");
   }
     public static ArrayList<Cerveja> buscarID(String idBeer) throws SQLException, ClassNotFoundException 
   {
        estabelecerConexao();
        ArrayList<Cerveja> al_listaid = new ArrayList();
        ResultSet rs_executaOperacao;
        PreparedStatement ps_estado;
        String s_operacao = "select * from cerveja where idBeer = ?";
        ps_estado= CervejaDAO.conn_conexao.prepareStatement(s_operacao);
        ps_estado.setString(1, idBeer);
        rs_executaOperacao = ps_estado.executeQuery();
        
        while(rs_executaOperacao.next() == true)
        {
            Cerveja beer = new Cerveja();
            beer.setIdBeer((rs_executaOperacao.getString("idBeer")));
            beer.setDescricao(rs_executaOperacao.getString("descricao"));
            beer.setValor(rs_executaOperacao.getFloat("valor"));
            al_listaid.add(beer);
        }
        rs_executaOperacao.close();
        ps_estado.close();
        return(al_listaid);
   }
       public static ArrayList<Cerveja> buscarCervejas() throws SQLException, ClassNotFoundException 
   {
        estabelecerConexao();
        ArrayList<Cerveja> al_listaTodos = new ArrayList();
        ResultSet rs_executaOperacao;
        PreparedStatement ps_estado;
        String s_operacao = "select * from cerveja";
        ps_estado= CervejaDAO.conn_conexao.prepareStatement(s_operacao);
        rs_executaOperacao = ps_estado.executeQuery();

        while(rs_executaOperacao.next() == true)
        {
            
            Cerveja beer = new Cerveja();
            beer.setIdBeer((rs_executaOperacao.getString("idBeer")));
            beer.setDescricao(rs_executaOperacao.getString("descricao"));
            beer.setValor(rs_executaOperacao.getFloat("valor"));
            al_listaTodos.add(beer);  
        }
        rs_executaOperacao.close();
        ps_estado.close();
        return(al_listaTodos);
   }
       public static ArrayList<Cerveja> buscarAvancada(String idBeer) throws SQLException, ClassNotFoundException 
   {
      
        estabelecerConexao();
        ArrayList<Cerveja> al_listaTodos = new ArrayList();
        ResultSet rs_executaOperacao;
        PreparedStatement ps_estado;
        String s_operacao = "SELECT * FROM cerveja WHERE idBeer LIKE ? ";
        ps_estado= CervejaDAO.conn_conexao.prepareStatement(s_operacao);
        ps_estado.setString(1, "%" + idBeer + "%");
        rs_executaOperacao = ps_estado.executeQuery();
        while(rs_executaOperacao.next() == true)
        {
        Cerveja beer = new Cerveja();
        beer.setIdBeer(rs_executaOperacao.getString("idBeer"));
        beer.setDescricao(rs_executaOperacao.getString("descricao"));
        beer.setValor(rs_executaOperacao.getFloat("valor"));
        al_listaTodos.add(beer);     
        }
        
        rs_executaOperacao.close();
        ps_estado.close();
        return(al_listaTodos);
    
    }
}
