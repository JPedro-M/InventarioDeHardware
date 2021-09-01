package br.ulbra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author troll
 */
public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bdinventario";
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
            return null;
        }
    }
    public static void closeConnection(Connection con){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmp){
        try {
            if(stmp != null){
                stmp.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
        }
    }
    
    public static void closeConnection(Connection con,
            PreparedStatement stmp,ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
        }
    }
}
