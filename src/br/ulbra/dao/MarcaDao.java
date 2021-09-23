/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import br.ulbra.model.Marca;
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
public class MarcaDao {
    Connection con;
    
    public MarcaDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Marca m){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbmarca (marca) VALUE (?)");
            stmt.setString(1, m.getMarca());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca "+m.getMarca()
                    +" Salva com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de usuarios na tabela do formulario   ---   R
    
    public ArrayList<Marca> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<Marca>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmarca");
            rs = stmt.executeQuery();
            while(rs.next()){
                Marca Marca = new Marca();
                Marca.setId(rs.getInt("idmarca"));
                Marca.setMarca(rs.getString("marca"));
                marcas.add(Marca);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Marca>) marcas;
    }
    
    public ArrayList<Marca> readAZ(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<Marca>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmarca ORDER BY marca ASC");
            rs = stmt.executeQuery();
            while(rs.next()){
                Marca Marca = new Marca();
                Marca.setId(rs.getInt("idmarca"));
                Marca.setMarca(rs.getString("marca"));
                marcas.add(Marca);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Marca>) marcas;
    }
    
    public ArrayList<Marca> readPesq(String sala){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<Marca>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmarca WHERE marca LIKE ?");
            stmt.setString(1, "%"+sala+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Marca Marca = new Marca();
                Marca.setId(rs.getInt("idmarca"));
                Marca.setMarca(rs.getString("marca"));
                marcas.add(Marca);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Marca>) marcas;
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(Marca m){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbmarca SET marca = ? WHERE idmarca = ?");
            stmt.setString(1, m.getMarca());
            stmt.setInt   (2, m.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "sala "+m.getMarca()
                    +" Modificada com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Marca m){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbmarca WHERE idmarca = ?");
           
            stmt.setInt   (1, m.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Tem certeza que"
                    + " deseja excluir a marca", "Exclusão"+m.getMarca(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Marca "+m.getMarca()
                    +" excluída com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão da marca "+m.getMarca()
                    +" Cancelada com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
