package br.ulbra.dao;

import br.ulbra.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.ulbra.model.Hardware;
import br.ulbra.model.Marca;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author troll
 */
public class HardwareDao {
    Connection con;
    
    public HardwareDao() throws SQLException{
        con = ConnectionFactory.getConnection();
    }
    
       public void create(Hardware h){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbhardware (nome,modelo,estado,dataa,caracteristica,fkidcat,fkidmarca,preco) VALUE (?,?,?,?,?,?,?,?)");
            stmt.setString(1, h.getHardware());
            stmt.setString(2, h.getModelo());
            stmt.setString(3, h.getEstado());
            stmt.setString(4, h.getData());
            stmt.setString(5, h.getCaracteristica());
            stmt.setInt(6, h.getCategoria().getId());
            stmt.setInt(7, h.getMarca().getId());
            stmt.setDouble(8, h.getPreco());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hardware salvo com sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de usuarios na tabela do formulario   ---   R
    
    public ArrayList<Hardware> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Hardware> hs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT h.idhard, h.nome, h.modelo, h.estado, h.dataa, h.preco, h.caracteristica, c.categoria, c.idcat, m.idmarca, m.marca FROM tbhardware as h join tbcategoria as c on (h.fkidcat=c.idcat) join tbmarca as m on (h.fkidmarca = m.idmarca)");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Hardware hard = new Hardware();
                Categoria c = new Categoria();
                c.setId(rs.getInt("idcat"));
                c.setCategoria(rs.getString("categoria"));
                Marca m = new Marca();
                m.setId(rs.getInt("idmarca"));
                m.setMarca(rs.getString("marca"));
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/uuuu");

                hard.setId(rs.getInt("idhard"));
                hard.setHardware(rs.getString("nome"));
                hard.setModelo(rs.getString("modelo"));
                hard.setEstado(rs.getString("estado"));
                hard.setData(formato.format(rs.getDate("dataa")));
                hard.setPreco(rs.getDouble("preco"));
                hard.setCaracteristica(rs.getString("caracteristica"));
                hard.setCategoria(c);
                hard.setMarca(m);

                hs.add(hard);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HardwareDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<Hardware>) hs;

    }
    
    public ArrayList<Hardware> readAZ(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Hardware> hs = new ArrayList<Hardware>();
        try {
            stmt = con.prepareStatement("SELECT h.idhard, h.nome, h.modelo, h.estado, h.dataa, h.preco, h.caracteristica, c.categoria, m.marca FROM tbhardware as h join tbcategoria as c on (h.fkidcat=c.idcat) join tbmarca as m on (h.fkidmarca = m.idmarca) ORDER BY nome ASC");
            rs = stmt.executeQuery();
            while (rs.next()) {

                Hardware hard = new Hardware();
                Categoria c = new Categoria();
                c.setCategoria(rs.getString("categoria"));
                Marca m = new Marca();
                m.setMarca(rs.getString("marca"));
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/uuuu");

                hard.setId(rs.getInt("idhard"));
                hard.setHardware(rs.getString("nome"));
                hard.setModelo(rs.getString("modelo"));
                hard.setEstado(rs.getString("estado"));
                hard.setData(formato.format(rs.getDate("dataa")));
                hard.setPreco(rs.getDouble("preco"));
                hard.setCaracteristica(rs.getString("caracteristica"));
                hard.setCategoria(c);
                hard.setMarca(m);

                hs.add(hard);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Hardware>) hs;
    }
    
    public ArrayList<Hardware> readPesq(String nome){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Hardware> hs = new ArrayList<Hardware>();
        try {
            stmt = con.prepareStatement("SELECT h.idhard, h.nome, h.modelo, h.estado, h.dataa, h.preco, h.caracteristica, c.categoria, m.marca FROM tbhardware as h join tbcategoria as c on (h.fkidcat=c.idcat) join tbmarca as m on (h.fkidmarca = m.idmarca) WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            while (rs.next()) {

                Hardware hard = new Hardware();
                Categoria c = new Categoria();
                c.setCategoria(rs.getString("categoria"));
                Marca m = new Marca();
                m.setMarca(rs.getString("marca"));
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/uuuu");

                hard.setId(rs.getInt("idhard"));
                hard.setHardware(rs.getString("nome"));
                hard.setModelo(rs.getString("modelo"));
                hard.setEstado(rs.getString("estado"));
                hard.setData(formato.format(rs.getDate("dataa")));
                hard.setPreco(rs.getDouble("preco"));
                hard.setCaracteristica(rs.getString("caracteristica"));
                hard.setCategoria(c);
                hard.setMarca(m);

                hs.add(hard);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Hardware>) hs;
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(Hardware h){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbhardware SET hardware = ?, modelo = ?, estado = ? , dataa = ?, caracterisca = ?, fkidcat = ?, fkidmarca = ?, preco = ? WHERE idhard = ?");
            stmt.setString(1, h.getHardware());
            stmt.setString(2, h.getModelo());
            stmt.setString(3, h.getEstado());
            stmt.setString(4, h.getData());
            stmt.setString(5, h.getCaracteristica());
            stmt.setInt(7, h.getCategoria().getId());
            stmt.setInt(8, h.getMarca().getId());
            stmt.setDouble(8, h.getPreco());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hardware modificado com sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Hardware h){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbhardware WHERE idhard = ?");
           
            stmt.setInt   (1, h.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Tem certeza que"
                    + " deseja excluir o hardware", "Exclusão",
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Hardware"
                    +" excluído com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão do hardware foi cancelada com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public ArrayList<Categoria> listaCategoria() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Categoria> cs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategoria order by categoria ASC ");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria c = new Categoria();

                c.setId(rs.getInt("idcat"));
                c.setCategoria(rs.getString("categoria"));

                cs.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HardwareDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<Categoria>) cs;

    }

    //MÉTODO PARA RETORNAR AS MARCA PARA A COMBOBOX
    public ArrayList<Marca> listaMarca() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Marca> ms = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbmarca");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Marca m = new Marca();

                m.setId(rs.getInt("idmarca"));
                m.setMarca(rs.getString("marca"));

                ms.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HardwareDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<Marca>) ms;

    }
}
