/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import br.ulbra.model.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author troll
 */
public class SalaDao {
    Connection con;
    
    public SalaDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Sala s){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbsala (sala,"
                    + "andar,local) VALUE (?,?,?)");
            stmt.setString(1, s.getSala());
            stmt.setString(2, s.getAndar());
            stmt.setString(3, s.getLocal());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sala "+s.getSala()
                    +" Salva com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de usuarios na tabela do formulario   ---   R
    
    public ArrayList<Sala> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sala> salas = new ArrayList<Sala>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbsala");
            rs = stmt.executeQuery();
            while(rs.next()){
                Sala Sala = new Sala();
                Sala.setId(rs.getInt("idsala"));
                Sala.setSala(rs.getString("sala"));
                Sala.setAndar(rs.getString("andar"));
                Sala.setLocal(rs.getString("local"));
                salas.add(Sala);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Sala>) salas;
    }
    
    public ArrayList<Sala> readAZ(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sala> salas = new ArrayList<Sala>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbsala ORDER BY sala ASC");
            rs = stmt.executeQuery();
            while(rs.next()){
                Sala Sala = new Sala();
                Sala.setId(rs.getInt("idsala"));
                Sala.setSala(rs.getString("sala"));
                Sala.setAndar(rs.getString("andar"));
                Sala.setLocal(rs.getString("local"));
                salas.add(Sala);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Sala>) salas;
    }
    
    public ArrayList<Sala> readPesq(String sala){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sala> salas = new ArrayList<Sala>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbsala WHERE sala LIKE ?");
            stmt.setString(1, "%"+sala+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Sala Sala = new Sala();
                Sala.setId(rs.getInt("idsala"));
                Sala.setSala(rs.getString("sala"));
                Sala.setAndar(rs.getString("andar"));
                Sala.setLocal(rs.getString("local"));
                salas.add(Sala);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Sala>) salas;
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(Sala s){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbsala SET sala = ?,"
                    + "andar = ?, local = ? WHERE idsala = ?");
            stmt.setString(1, s.getSala());
            stmt.setString(2, s.getAndar());
            stmt.setString(3, s.getLocal());
            stmt.setInt   (4, s.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "sala "+s.getSala()
                    +" Modificada com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Sala s){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbsala WHERE idsala = ?");
           
            stmt.setInt   (1, s.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Tem certeza que"
                    + " deseja excluir a sala", "Exclusão"+s.getSala(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "sala excluída com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão da sala "+s.getSala()
                    +" Cancelada com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
