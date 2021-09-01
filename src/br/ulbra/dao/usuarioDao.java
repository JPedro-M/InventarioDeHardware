package br.ulbra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.ulbra.model.usuario;

/**
 *
 * @author troll
 */
public class usuarioDao {
    Connection con;
    
    public usuarioDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
    public boolean  checkLogin(String email, String senha){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario"
                    + " where email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check = true;
            }
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
        }
        return check;
    }
    
    public void create(usuario u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbusuario (nome,"
                    + "email,senha,fone) VALUE (?,?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getFone());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario "+u.getNome()
                    +" Salvo com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de usuarios na tabela do formulario   ---   R
    
    public ArrayList<usuario> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<usuario> usuarios = new ArrayList<usuario>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario");
            rs = stmt.executeQuery();
            while(rs.next()){
                usuario Usuario = new usuario();
                Usuario.setId(rs.getInt("idusuario"));
                Usuario.setNome(rs.getString("nome"));
                Usuario.setEmail(rs.getString("email"));
                Usuario.setSenha(rs.getString("senha"));
                Usuario.setFone(rs.getString("fone"));
                usuarios.add(Usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<usuario>) usuarios;
    }
    
    public ArrayList<usuario> readPesq(String nome){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<usuario> usuarios = new ArrayList<usuario>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                usuario Usuario = new usuario();
                Usuario.setId(rs.getInt("idusuario"));
                Usuario.setNome(rs.getString("nome"));
                Usuario.setEmail(rs.getString("email"));
                Usuario.setSenha(rs.getString("senha"));
                Usuario.setFone(rs.getString("fone"));
                usuarios.add(Usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<usuario>) usuarios;
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(usuario u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbusuario SET nome = ?,"
                    + "email = ?, senha = ? ,fone = ? WHERE idusuario = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getFone());
            stmt.setInt   (5, u.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario "+u.getNome()
                    +" Modificado com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(usuario u){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbusuario WHERE idusuario = ?");
           
            stmt.setInt   (1, u.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que"
                    + " deseja excluir o Usuario(a)"+u.getNome(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Usuario(a) "+u.getNome()
                    +" excluído(a)com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão do Usuario(a) "+u.getNome()
                    +" Cancelado(a)com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
