package ProjectDao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conection {

    public static  Statement stm;
    public static  ResultSet rs;
    private  final String driver = "org.postgresql.Driver";
    private  final String local = "jdbc:postgresql://queenie.db.elephantsql.com:5432/ecvboiwt";
    private  final String login = "ecvboiwt";
    private  final String password = "wRUOEbOHd93-MQK0MwTPmjxWzfqq9GF2";

    /**
     *
     */
    public Connection con;

  
    /**
     *
     */
    public void Conection() {
        System.setProperty("jdbc.Drivers", driver);
        try {
            con = DriverManager.getConnection(local, login, password);
            
            
        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro de execução do SQL\n" + ex.getMessage());
        }
    }

    public void desconecta() {
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão com BD \n" + ex);
        }
    }

    public void executaSql(String sql) {
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Execução do Sql\n" + ex.getMessage());
        }
    }

}
