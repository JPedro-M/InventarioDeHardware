package br.ulbra.dao;

import br.ulbra.model.Categoria;
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
public class CategoriaDao {
    Connection con;
    
    public CategoriaDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Categoria m){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbcategoria (categoria) VALUE (?)");
            stmt.setString(1, m.getCategoria());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria "+m.getCategoria()
                    +" Salva com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de usuarios na tabela do formulario   ---   R
    
    public ArrayList<Categoria> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Categoria> marcas = new ArrayList<Categoria>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategoria");
            rs = stmt.executeQuery();
            while(rs.next()){
                Categoria Marca = new Categoria();
                Marca.setId(rs.getInt("idcat"));
                Marca.setCategoria(rs.getString("categoria"));
                marcas.add(Marca);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Categoria>) marcas;
    }
    
    public ArrayList<Categoria> readAZ(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Categoria> marcas = new ArrayList<Categoria>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategoria ORDER BY categoria ASC");
            rs = stmt.executeQuery();
            while(rs.next()){
                Categoria Marca = new Categoria();
                Marca.setId(rs.getInt("idcat"));
                Marca.setCategoria(rs.getString("categoria"));
                marcas.add(Marca);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Categoria>) marcas;
    }
    
    public ArrayList<Categoria> readPesq(String sala){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Categoria> marcas = new ArrayList<Categoria>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategoria WHERE categoria LIKE ?");
            stmt.setString(1, "%"+sala+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Categoria Marca = new Categoria();
                Marca.setId(rs.getInt("idcat"));
                Marca.setCategoria(rs.getString("categoria"));
                marcas.add(Marca);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Categoria>) marcas;
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(Categoria m){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbcategoria SET categoria = ? WHERE idcat = ?");
            stmt.setString(1, m.getCategoria());
            stmt.setInt   (2, m.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria "+m.getCategoria()
                    +" Modificada com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Categoria m){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbcategoria WHERE idcat = ?");
           
            stmt.setInt   (1, m.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Tem certeza que"
                    + " deseja excluir a Categoria", "Exclusão"+m.getCategoria(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Categoria "+m.getCategoria()
                    +" excluída com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão da categoria "+m.getCategoria()
                    +" Cancelada com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
