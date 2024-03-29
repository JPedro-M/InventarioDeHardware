package br.ulbra.view;

import br.ulbra.dao.HardwareDao;
import br.ulbra.model.Categoria;
import br.ulbra.model.Hardware;
import br.ulbra.model.Marca;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author troll
 */
public class FrConHard extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrConUsu
     */
    public FrConHard() {
        initComponents();
        btListar.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        rbTodos = new javax.swing.JRadioButton();
        rbAZ = new javax.swing.JRadioButton();
        rbNome = new javax.swing.JRadioButton();
        txtNomePesq = new javax.swing.JTextField();
        btListar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        txtPreco = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        btExcluir = new javax.swing.JButton();
        cbCategoria = new javax.swing.JComboBox();
        cbMarca = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCaracteristica = new javax.swing.JTextArea();

        setClosable(true);
        setTitle("Consulta de usuários");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Modelo", "Estado", "Data", "Preço", "Categoria", "Marca", "Caracteristicas"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        buttonGroup1.add(rbTodos);
        rbTodos.setSelected(true);
        rbTodos.setText("Todos");

        buttonGroup1.add(rbAZ);
        rbAZ.setText("A-Z");

        buttonGroup1.add(rbNome);
        rbNome.setText("Filtrar por nome");
        rbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNomeActionPerformed(evt);
            }
        });

        btListar.setText("Listar");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Nome:");

        jLabel2.setText("modelo:");

        jLabel3.setText("Estado:");

        jLabel4.setText("data:");

        jLabel5.setText("Preço:");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        jLabel6.setText("Categoria:");

        jLabel7.setText("Marca:");

        jLabel8.setText("Caracteristicas:");

        txtData.setEditable(false);
        txtData.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtDataAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        cbCategoria.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbCategoriaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        cbMarca.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbMarcaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtCaracteristica.setColumns(20);
        txtCaracteristica.setRows(3);
        jScrollPane2.setViewportView(txtCaracteristica);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(135, 135, 135)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(187, 187, 187))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(182, 182, 182)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(403, 403, 403)
                            .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btSalvar)
                        .addComponent(btLimpar)
                        .addComponent(btExcluir)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(26, 26, 26)))
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbTodos)
                        .addGap(0, 0, 0)
                        .addComponent(rbAZ)
                        .addGap(0, 0, 0)
                        .addComponent(rbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNomePesq, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btListar))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTodos)
                    .addComponent(rbAZ)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbNome)
                        .addComponent(btListar)
                        .addComponent(txtNomePesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int idSelec = -1;
    int row;
    private void rbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNomeActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        HardwareDao har = null;
        
        if (rbTodos.isSelected()) {
            try {
                har = new HardwareDao();
                for (Hardware h : har.read()) {
                    modelo.addRow(new Object[]{
                    h.getId(),
                    h.getHardware(),
                    h.getModelo(),
                    h.getEstado(),
                    h.getData(),
                    h.getPreco(),
                    h.getCategoria(),
                    h.getMarca(),
                    h.getCaracteristica()
                    });
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if(rbAZ.isSelected()) {
            try {
                har = new HardwareDao();
                for (Hardware h : har.readAZ()) {
                    modelo.addRow(new Object[]{
                    h.getId(),
                    h.getHardware(),
                    h.getModelo(),
                    h.getEstado(),
                    h.getData(),
                    h.getPreco(),
                    h.getCategoria(),
                    h.getMarca(),
                    h.getCaracteristica()
                    });
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }else {
            try {
                har = new HardwareDao();
                for (Hardware h : har.readPesq(txtNomePesq.getText())) {
                    modelo.addRow(new Object[]{
                    h.getId(),
                    h.getHardware(),
                    h.getModelo(),
                    h.getEstado(),
                    h.getData(),
                    h.getPreco(),
                    h.getCategoria(),
                    h.getMarca(),
                    h.getCaracteristica()
                    });
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btListarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
      
      /*  row = tabela.getSelectedRow();
        String nome = String.valueOf(tabela.getValueAt(row, 1));
        String modelo = String.valueOf(tabela.getValueAt(row, 2));
        String estado = String.valueOf(tabela.getValueAt(row, 3));
        String preco = String.valueOf(tabela.getValueAt(row, 5));
        Categoria categoria = (Categoria) tabela.getValueAt(row, 6);
        Marca marca =(Marca) tabela.getValueAt(row, 7);
        String caracteristica = String.valueOf(tabela.getValueAt(row, 8));
        LocalDateTime agora = LocalDateTime.now();
        
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");

        txtData.setText(formatterData.format(agora));
        
        txtNome.setText(nome);
        txtModelo.setText(modelo);
        txtEstado.setText(estado);
        txtPreco.setText(preco);
        txtCaracteristica.setText(caracteristica);
        idSelec = Integer.parseInt(String.valueOf(tabela.getValueAt(row,0)));
        cbCategoria.setSelectedItem(categoria);
        cbMarca.setSelectedItem(marca);*/
        
            idSelec = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
            txtNome.setText(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
            txtModelo.setText(tabela.getValueAt(tabela.getSelectedRow(), 2).toString());
            txtEstado.setText(tabela.getValueAt(tabela.getSelectedRow(), 3).toString());
            txtPreco.setText(tabela.getValueAt(tabela.getSelectedRow(), 5).toString());
            txtCaracteristica.setText(tabela.getValueAt(tabela.getSelectedRow(), 8).toString());
            
            txtData.setText(tabela.getValueAt(tabela.getSelectedRow(), 4).toString());
            cbCategoria.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 6));
            cbMarca.setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 7));
    }//GEN-LAST:event_tabelaMouseClicked

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        Hardware u = new Hardware();
        HardwareDao usu = null;
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        try {
            usu = new HardwareDao();
            List<Categoria> categoria = usu.listaCategoria();

            String data = (formatterData.format(agora));

            if (!txtNome.getText().isEmpty() && !txtModelo.getText().isEmpty() && !txtPreco.getText().isEmpty() && !txtEstado.getText().isEmpty() && !txtData.getText().isEmpty() && !cbCategoria.getSelectedItem().equals("Selecione") && !cbMarca.getSelectedItem().equals("Selecione")) {
              u.setHardware(txtNome.getText());
                u.setModelo(txtModelo.getText());
                u.setEstado(txtEstado.getText());
                u.setData(data);
                u.setPreco(Double.valueOf(txtPreco.getText()));
                u.setCategoria((Categoria) cbCategoria.getSelectedItem());
                u.setMarca((Marca) cbMarca.getSelectedItem());
                u.setCaracteristica(txtCaracteristica.getText());

                usu.update(u);
                btLimpar.doClick();
            } else {
                JOptionPane.showMessageDialog(null, "Os campos não podem estar em branco");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        txtNome.setText(null);
        txtModelo.setText(null);
        txtEstado.setText(null);
        txtPreco.setText(null);
        cbCategoria.setSelectedItem("Selecione");
        cbMarca.setSelectedItem("Selecione");
        txtCaracteristica.setText(null);
    }//GEN-LAST:event_btLimparActionPerformed

    private void txtDataAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtDataAncestorAdded
        
    }//GEN-LAST:event_txtDataAncestorAdded

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_btExcluirActionPerformed

    private void cbCategoriaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbCategoriaAncestorAdded
         HardwareDao hdao;
        try {
            hdao = new HardwareDao();
            List<Categoria> categoria = hdao.listaCategoria();
            cbCategoria.removeAll();
            for (Categoria c : categoria) {
                cbCategoria.addItem(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        }      
    }//GEN-LAST:event_cbCategoriaAncestorAdded

    private void cbMarcaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbMarcaAncestorAdded
        HardwareDao hdao;
        try {
            hdao = new HardwareDao();
            List<Marca> marca = hdao.listaMarca();
            cbMarca.removeAll();
            for (Marca m : marca) {
                cbMarca.addItem(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        }      
    }//GEN-LAST:event_cbMarcaAncestorAdded

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbAZ;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tabela;
    private javax.swing.JTextArea txtCaracteristica;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomePesq;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
