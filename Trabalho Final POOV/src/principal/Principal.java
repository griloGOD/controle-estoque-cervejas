
package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Principal {

    
    public static void main(String[] args) {
       
       
       Tela1 tela = new Tela1();
       tela.setLocationRelativeTo(null);
       tela.setTitle("GERMAN BEER - SINCE 1907");
       tela.setVisible(true);
      
    }
}