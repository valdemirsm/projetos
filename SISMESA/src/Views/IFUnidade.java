/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IFUsuario.java
 *
 * Created on 18/05/2010, 23:02:05
 */
package Views;

import classess.Utilitario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexandre
 */
public class IFUnidade extends javax.swing.JInternalFrame {

    Object[] options = {"Sim", "Não"};

    /** Creates new form IFUsuario */
    public IFUnidade() {
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
        SwingUtilities.updateComponentTreeUI(this);
        this.pack();
        LimpaCampos();
        PreencherJtableConsulta();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TFDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BTNovo = new javax.swing.JButton();
        BTSalvar = new javax.swing.JButton();
        BTExcluir = new javax.swing.JButton();
        TFCodUnidade = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TFNomeGeral = new javax.swing.JTextField();
        BT_FILTER = new javax.swing.JButton();
        TFUni_Ini = new Componentes.DKJTFInteger();
        TFUni_Fin = new Componentes.DKJTFInteger();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBConsultaUnidade = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de unidades");
        setMinimumSize(new java.awt.Dimension(447, 250));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(450, 351));

        jPanel1.setLayout(null);

        jLabel1.setText("Cód. Unidade"); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 11, 80, 14);

        TFDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFDescricaoActionPerformed(evt);
            }
        });
        jPanel1.add(TFDescricao);
        TFDescricao.setBounds(110, 30, 310, 20);

        jLabel2.setText("Descrição"); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 10, 140, 14);

        BTNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Clear-32.png"))); // NOI18N
        jPanel1.add(BTNovo);
        BTNovo.setBounds(120, 160, 100, 30);

        BTSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save_16.png"))); // NOI18N
        BTSalvar.setText("Salvar"); // NOI18N
        BTSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(BTSalvar);
        BTSalvar.setBounds(220, 160, 100, 30);

        BTExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete_16.png"))); // NOI18N
        BTExcluir.setText("Excluir"); // NOI18N
        BTExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(BTExcluir);
        BTExcluir.setBounds(320, 160, 100, 30);

        TFCodUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFCodUnidadeActionPerformed(evt);
            }
        });
        jPanel1.add(TFCodUnidade);
        TFCodUnidade.setBounds(10, 30, 90, 20);

        jTabbedPane1.addTab("Cadastro", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setMinimumSize(new java.awt.Dimension(500, 64));
        jPanel7.setName(""); // NOI18N

        jLabel9.setText("Uni.Ini.:"); // NOI18N

        jLabel10.setText("Uni.Fin.:"); // NOI18N

        jLabel13.setText("Desc/Uni:"); // NOI18N

        TFNomeGeral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFNomeGeralKeyReleased(evt);
            }
        });

        BT_FILTER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Clear-32.png"))); // NOI18N
        BT_FILTER.setText("Limpar"); // NOI18N
        BT_FILTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_FILTERActionPerformed(evt);
            }
        });
        BT_FILTER.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BT_FILTERKeyPressed(evt);
            }
        });

        TFUni_Ini.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFUni_IniFocusLost(evt);
            }
        });

        TFUni_Fin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFUni_FinFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(TFUni_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFUni_Fin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TFNomeGeral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BT_FILTER, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TFUni_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(TFUni_Fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(TFNomeGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(BT_FILTER, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        TBConsultaUnidade.setAutoCreateRowSorter(true);
        TBConsultaUnidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id_unidade", "Cód. Unidade", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBConsultaUnidade.setDragEnabled(true);
        TBConsultaUnidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBConsultaUnidadeMouseClicked(evt);
            }
        });
        TBConsultaUnidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TBConsultaUnidadeKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(TBConsultaUnidade);
        TBConsultaUnidade.getColumnModel().getColumn(0).setMinWidth(0);
        TBConsultaUnidade.getColumnModel().getColumn(0).setPreferredWidth(0);
        TBConsultaUnidade.getColumnModel().getColumn(0).setMaxWidth(0);
        TBConsultaUnidade.getColumnModel().getColumn(1).setMinWidth(100);
        TBConsultaUnidade.getColumnModel().getColumn(1).setPreferredWidth(100);
        TBConsultaUnidade.getColumnModel().getColumn(1).setMaxWidth(100);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 426, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pesquisa", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
        );

        setBounds(100, 50, 447, 250);
    }// </editor-fold>//GEN-END:initComponents

    private void TFNomeGeralKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFNomeGeralKeyReleased
        PreencherJtableConsulta();
    }//GEN-LAST:event_TFNomeGeralKeyReleased

    private void BT_FILTERKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BT_FILTERKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            LimpaCamposSelecao();
            PreencherJtableConsulta();
        }
    }//GEN-LAST:event_BT_FILTERKeyPressed

    private void TBConsultaUnidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBConsultaUnidadeMouseClicked
        if (evt.getClickCount() > 1) {
            posicionaUsuario();
        }
    }//GEN-LAST:event_TBConsultaUnidadeMouseClicked

    private void BT_FILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_FILTERActionPerformed
        LimpaCamposSelecao();
        PreencherJtableConsulta();
    }//GEN-LAST:event_BT_FILTERActionPerformed

    private void TBConsultaUnidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBConsultaUnidadeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            posicionaUsuario();
        }
    }//GEN-LAST:event_TBConsultaUnidadeKeyPressed

    private void TFUni_IniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFUni_IniFocusLost
        PreencherJtableConsulta();
        PreencherJtableConsulta();
    }//GEN-LAST:event_TFUni_IniFocusLost

    private void TFUni_FinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFUni_FinFocusLost
        PreencherJtableConsulta();
    }//GEN-LAST:event_TFUni_FinFocusLost

    private void BTNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNovoActionPerformed
        LimpaCampos();
}//GEN-LAST:event_BTNovoActionPerformed

    private void BTSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSalvarActionPerformed
        SalvaOrAltera();
//        if (TFCodUnidade.getText().isEmpty()) {
//            SalvaUsuario();
//        } else {
//            AlterarUsuario();
//        }
        PreencherJtableConsulta();
    }//GEN-LAST:event_BTSalvarActionPerformed

    private void BTExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTExcluirActionPerformed
        DeletaUsuario();
        PreencherJtableConsulta();
}//GEN-LAST:event_BTExcluirActionPerformed

    private void TFDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFDescricaoActionPerformed

    private void TFCodUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFCodUnidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFCodUnidadeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTExcluir;
    private javax.swing.JButton BTNovo;
    private javax.swing.JButton BTSalvar;
    private javax.swing.JButton BT_FILTER;
    private javax.swing.JTable TBConsultaUnidade;
    private javax.swing.JTextField TFCodUnidade;
    private javax.swing.JTextField TFDescricao;
    private javax.swing.JTextField TFNomeGeral;
    private Componentes.DKJTFInteger TFUni_Fin;
    private Componentes.DKJTFInteger TFUni_Ini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private void LimpaCampos() {
        TFCodUnidade.setText("");
        TFDescricao.setText("");
    }

    private void SalvaUsuario() {
        ResultSet rsUnidade = FMaster.con.executeSQL("select * from grcunidade where id_unidade = ''");
        try {
            rsUnidade.first();
            rsUnidade.moveToInsertRow();
            rsUnidade.updateString("id_unidade", TFCodUnidade.getText().toUpperCase());
            rsUnidade.updateString("descunidade", TFDescricao.getText());
            rsUnidade.insertRow();
            prencherHeder(rsUnidade.getString("id_unidade"));
            rsUnidade.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void LimpaCamposSelecao() {
        TFUni_Ini.setText("");
        TFUni_Fin.setText("");
        TFNomeGeral.setText("");
    }

    private void prencherHeder(String id) {
        ResultSet rsConsultaRegInserido = FMaster.con.executeSQL("select * from grcunidade where id_unidade = '" + id + "'");
        try {
            rsConsultaRegInserido.first();
            if (rsConsultaRegInserido.isFirst()) {
                TFCodUnidade.setText(rsConsultaRegInserido.getString("id_unidade"));
                TFDescricao.setText(rsConsultaRegInserido.getString("descunidade"));
                TFDescricao.requestFocus();
            }
            rsConsultaRegInserido.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problema no posicionamento do produto");
        }
    }

    private void AlterarUsuario() {
        String id_unidade = TFCodUnidade.getText().isEmpty() ? "" : TFCodUnidade.getText();

        try {
            ResultSet rsInsereUnidade = FMaster.con.executeSQL("select * from grcunidade where id_unidade = '" + id_unidade + "'");
            rsInsereUnidade.first();
            if (rsInsereUnidade.isFirst()) {
                int iresp = JOptionPane.showOptionDialog(null, "Deseja alterar?", "", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, //do not use a custom Icon
                        options, //the titles of buttons
                        options[0]); //default button title
                if (iresp == 0) {
                    rsInsereUnidade.absolute(rsInsereUnidade.getRow());
                    rsInsereUnidade.updateString("id_unidade", TFCodUnidade.getText().toUpperCase());
                    rsInsereUnidade.updateString("descunidade", TFDescricao.getText());
                    rsInsereUnidade.updateRow();
                }
            }
            rsInsereUnidade.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void posicionaUsuario() {
        String id_unidade = Utilitario.getValueColumn("id_unidade", TBConsultaUnidade);
        ResultSet rsUnidade = FMaster.con.executeSQL("select * from grcunidade where id_unidade = '" + id_unidade + "'");
        try {
            rsUnidade.first();
            if (rsUnidade.isFirst()) {
                prencherHeder(rsUnidade.getString("id_unidade"));
                jTabbedPane1.setSelectedIndex(0);
            }
            rsUnidade.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void DeletaUsuario() {
        if (!TFCodUnidade.getText().isEmpty()) {
            String id_unidade = TFCodUnidade.getText().isEmpty() ? "0" : TFCodUnidade.getText();
            ResultSet rsUnidade = FMaster.con.executeSQL("select * from grcunidade where id_unidade = '" + id_unidade + "'");
            try {
                rsUnidade.first();
                if (rsUnidade.isFirst()) {
                    rsUnidade.absolute(rsUnidade.getRow());
                    rsUnidade.deleteRow();
                    LimpaCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Uma unidade deve ser informado!", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
                rsUnidade.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void PreencherJtableConsulta() {
        ResultSet rsUnidade = FMaster.con.executeSQL("select * from grcunidade " + Filtra() + " order by id_unidade");
        DefaultTableModel modelo = (DefaultTableModel) TBConsultaUnidade.getModel();
        modelo.setNumRows(0);
        try {
            while (rsUnidade.next()) {
                modelo.addRow(new Object[]{rsUnidade.getString("id_unidade"), rsUnidade.getString("id_unidade"), rsUnidade.getString("descunidade"), Utilitario.getFomatDecimal(rsUnidade.getFloat("qtde"))});
            }
            rsUnidade.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String Filtra() {
        String sUniIni = TFUni_Ini.getText().isEmpty() ? "0" : TFUni_Ini.getText();
        String sUniFin = TFUni_Fin.getText().isEmpty() ? "0" : TFUni_Fin.getText();
        String descricao = TFNomeGeral.getText().isEmpty() ? "" : TFNomeGeral.getText();
        String filtro = "";

        if (!sUniIni.equals("0")) {
            if (filtro.equals("")) {
                filtro = " where id_unidade >= '" + sUniIni + "'";
            }
        }
        if (!sUniFin.equals("0")) {
            if (filtro.equals("")) {
                filtro = " where id_unidade <= '" + sUniFin + "'";
            } else {
                filtro = filtro + " and id_unidade <= '" + sUniFin + "'";
            }
        }

        if (!descricao.equals("")) {
            if (filtro.equals("")) {
                filtro = " where Upper(descunidade) like '%" + descricao.toUpperCase() + "%'";
            } else {
                filtro = filtro + " and Upper(descunidade) like '%" + descricao.toUpperCase() + "%'";
            }
        }
        return filtro;
    }

    private void SalvaOrAltera() {
        ResultSet rsAlter = FMaster.con.executeSQL("select * from grcunidade where id_unidade = '" + TFCodUnidade.getText() + "'");
        try {
            rsAlter.first();
            if (rsAlter.isFirst()) {
                AlterarUsuario();
            } else {
                SalvaUsuario();
            }
            rsAlter.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
