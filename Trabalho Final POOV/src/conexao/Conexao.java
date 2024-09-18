package conexao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao 
{
   public static Connection getConexao() throws SQLException
   {
       Connection conn_conexao=null;
       try{
            Class.forName("com.mysql.jdbc.Driver");
            conn_conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/fabrica","root","admwindows");
       }catch(ClassNotFoundException e){
           System.out.print("\n Erro ao conectar: "+e.toString());
       }
       return(conn_conexao);
    }
}
