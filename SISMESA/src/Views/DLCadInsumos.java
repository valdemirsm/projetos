/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DLCadInsumos.java
 *
 * Created on 13/10/2010, 22:30:39
 */
package Views;

import classess.GetsSets;
import classess.Utilitario;
//import View_consulta.DLProdutos;
import View_consulta.DLInsumos;
import View_consulta.DLProdutos;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrador
 */
public class DLCadInsumos extends javax.swing.JDialog {

    int id_itemproduto;
    int id_produto;
    int status;
    IFProduto frameProduto;

    /** Creates new form DLCadInsumos */
    public DLCadInsumos(java.awt.Frame parent, boolean modal, int id_itemproduto, int id_produto, int status, IFProduto frameProduto) {
        super(parent, modal);
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
//        SwingUtilities.updateComponentTreeUI(this);
//        this.pack();
        this.id_itemproduto = id_itemproduto;
        this.id_produto = id_produto;
        this.frameProduto = frameProduto;
        this.status = status;
        if (status == 2) {
            PreencheDadosTela();
        }
        TFCodInsumo.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                JTextField texto = (JTextField) input;
                boolean valida = false;
                if (!texto.getText().isEmpty()) {
                    try {
                        ResultSet rsproduto = FMaster.con.executeSQL("select * from estproduto where id_produto = '" + texto.getText() + "'");
                        rsproduto.first();
                        if (rsproduto.isFirst()) {
                            valida = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Insumo não cadastrado!", "Alerta", JOptionPane.ERROR_MESSAGE);
                            valida = false;
                        }
                        rsproduto.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DLCadProdComanda.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    valida = true;
                }
                return valida;
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        TFDescricao = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BTSalvar = new javax.swing.JButton();
        BTFechar = new javax.swing.JButton();
        TFCodInsumo = new Componentes.DKJTFInteger();
        TFUnidade = new javax.swing.JTextField();
        TFQtde = new Componentes.DKJTFFloat3Casas();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Insumos");
        getContentPane().setLayout(null);

        jLabel3.setText("Prod. Insumo(F1)");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 0, 90, 14);

        TFDescricao.setEditable(false);
        TFDescricao.setFocusable(false);
        getContentPane().add(TFDescricao);
        TFDescricao.setBounds(110, 20, 260, 20);

        jLabel4.setText("Descrição");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 0, 75, 14);

        jLabel5.setText("Quantidade");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 50, 69, 14);

        jLabel6.setText("Unidade");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 50, 90, 14);

        BTSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save_16.png"))); // NOI18N
        BTSalvar.setText("Salvar");
        BTSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(BTSalvar);
        BTSalvar.setBounds(190, 70, 92, 25);

        BTFechar.setText("Sair");
        BTFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTFecharActionPerformed(evt);
            }
        });
        BTFechar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BTFecharKeyPressed(evt);
            }
        });
        getContentPane().add(BTFechar);
        BTFechar.setBounds(300, 70, 77, 23);

        TFCodInsumo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFCodInsumoFocusLost(evt);
            }
        });
        TFCodInsumo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFCodInsumoKeyPressed(evt);
            }
        });
        getContentPane().add(TFCodInsumo);
        TFCodInsumo.setBounds(10, 20, 70, 20);

        TFUnidade.setEditable(false);
        TFUnidade.setFocusable(false);
        getContentPane().add(TFUnidade);
        TFUnidade.setBounds(10, 70, 90, 20);
        getContentPane().add(TFQtde);
        TFQtde.setBounds(110, 70, 64, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search_16.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(80, 20, 20, 20);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-395)/2, (screenSize.height-133)/2, 395, 133);
    }// </editor-fold>//GEN-END:initComponents

    private void BTSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSalvarActionPerformed
        int ret = 0;
        if (!TFCodInsumo.getText().isEmpty()) {
            if (status == 1) {
                SalvaProduto();
            } else if (status == 2) {
                AlteraProduto();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe um produto!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

        frameProduto.PreencherJtableInsumo();
    }//GEN-LAST:event_BTSalvarActionPerformed

    private void BTFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTFecharActionPerformed
        dispose();
}//GEN-LAST:event_BTFecharActionPerformed

    private void BTFecharKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTFecharKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            dispose();
        }
}//GEN-LAST:event_BTFecharKeyPressed

    private void TFCodInsumoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFCodInsumoFocusLost
        PegaDescProduto();
    }//GEN-LAST:event_TFCodInsumoFocusLost

    private void TFCodInsumoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFCodInsumoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            JTextField tfTextFiel;
            tfTextFiel = TFCodInsumo;
            DLInsumos Insumo = new DLInsumos(null, true, tfTextFiel);
            Insumo.setVisible(true);
            PegaDescProduto();
        }
    }//GEN-LAST:event_TFCodInsumoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JTextField tfTextFiel;
        tfTextFiel = TFCodInsumo;
        DLInsumos Insumo = new DLInsumos(null, true, tfTextFiel);
        Insumo.setVisible(true);
        PegaDescProduto();

    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTFechar;
    private javax.swing.JButton BTSalvar;
    private Componentes.DKJTFInteger TFCodInsumo;
    private javax.swing.JFormattedTextField TFDescricao;
    private Componentes.DKJTFFloat3Casas TFQtde;
    private javax.swing.JTextField TFUnidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    private void SalvaProduto() {
        ResultSet rsProduto = FMaster.con.executeSQL("select * from estproduto where id_produto = '" + id_produto + "'");
        try {
            rsProduto.first();
            if (rsProduto.isFirst()) {
                ResultSet rsProdutoExiste = FMaster.con.executeSQL("select * from estitemproduto where id_itemproduto = '" + Integer.parseInt(TFCodInsumo.getText().isEmpty() ? "0" : TFCodInsumo.getText()) + "' and id_produto = '" + id_produto + "'");
                rsProdutoExiste.first();
                if (rsProdutoExiste.isFirst()) {
                    JOptionPane.showMessageDialog(null, "Insumo já cadastrado!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    rsProdutoExiste.close();
                    return;
                }
                rsProdutoExiste.close();

                ResultSet rsInsereItemProduto = FMaster.con.executeSQL("select * from estitemproduto where id_itemproduto = 0");
                rsInsereItemProduto.first();
                rsInsereItemProduto.moveToInsertRow();
                rsInsereItemProduto.updateInt("id_itemproduto", Integer.parseInt(TFCodInsumo.getText().isEmpty() ? "0" : TFCodInsumo.getText()));
                rsInsereItemProduto.updateString("descricao", TFDescricao.getText());
                rsInsereItemProduto.updateInt("id_produto", id_produto);
                rsInsereItemProduto.updateString("unidade", TFUnidade.getText());
                rsInsereItemProduto.updateFloat("qtde", Float.parseFloat(TFQtde.getText().isEmpty() ? "0" : TFQtde.getText().replace(",", ".")));
                rsInsereItemProduto.insertRow();
                LimpaCampos();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DLCadItemEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LimpaCampos() {
        TFCodInsumo.setText("");
        TFDescricao.setText("");
        TFQtde.setText("");
        TFUnidade.setText("");
        TFCodInsumo.requestFocus();
    }

//    private void preencheUnidade() {
//        ResultSet rsUnidade = FMaster.con.executeSQL("select * from grcunidade order by id_unidade");
//        try {
//            rsUnidade.first();
//            do {
//                CBUnidade.addItem(rsUnidade.getString("id_unidade"));
//            } while (rsUnidade.next());
//            rsUnidade.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DLCadItemEntrada.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private void AlteraProduto() {
        ResultSet rsAlteraProduto = FMaster.con.executeSQL("select * from estitemproduto where id_itemproduto = '" + id_itemproduto + "' and id_produto = '" + id_produto + "'");
        try {
            rsAlteraProduto.first();
            if (rsAlteraProduto.isFirst()) {
                rsAlteraProduto.absolute(rsAlteraProduto.getRow());
                rsAlteraProduto.updateInt("id_itemproduto", Integer.parseInt(TFCodInsumo.getText().isEmpty() ? "0" : TFCodInsumo.getText()));
                rsAlteraProduto.updateString("descricao", TFDescricao.getText());
                rsAlteraProduto.updateInt("id_produto", id_produto);
                rsAlteraProduto.updateString("unidade", TFUnidade.getText());
                rsAlteraProduto.updateFloat("qtde", Float.parseFloat(TFQtde.getText().isEmpty() ? "0" : TFQtde.getText().replace(",", ".")));
                rsAlteraProduto.updateRow();
            }
            rsAlteraProduto.close();
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(DLCadProdComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void PreencheDadosTela() {
        ResultSet rsConsultaProduto = FMaster.con.executeSQL("select * from estitemproduto where estitemproduto.id_itemproduto = '" + id_itemproduto + "' and estitemproduto.id_produto = '" + id_produto + "'");
        try {
            rsConsultaProduto.first();
            if (rsConsultaProduto.isFirst()) {
                TFCodInsumo.setText(rsConsultaProduto.getString("id_itemproduto"));
                TFDescricao.setText(rsConsultaProduto.getString("descricao"));
                TFQtde.setText(Utilitario.getFomatDecimal3Casas(rsConsultaProduto.getFloat("qtde")));
                TFUnidade.setText(rsConsultaProduto.getString("unidade"));
            }
            rsConsultaProduto.close();

        } catch (SQLException ex) {
            Logger.getLogger(DLCadProdComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void PegaDescProduto() {
        if (!TFCodInsumo.getText().isEmpty()) {
            ResultSet rsproduto = FMaster.con.executeSQL("select * from estproduto where id_produto = '" + TFCodInsumo.getText() + "'");
            try {
                rsproduto.first();
                if (rsproduto.isFirst()) {
                    TFDescricao.setText(rsproduto.getString("descricao"));
                    TFUnidade.setText(rsproduto.getString("unidade_padrao"));
                    // TFVlrUnitario.setText(Utilitario.getFomatDecimal(rsproduto.getFloat("vlr_unitario")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DLCadItemEntrada.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    rsproduto.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DLCadInsumos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
