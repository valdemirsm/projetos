/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DLProduto.java
 *
 * Created on 26/05/2010, 00:01:13
 */

package View_consulta;

import classess.GetsSets;
import classess.Utilitario;
import Views.FMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Demir
 */
public class DLProduto extends java.awt.Dialog {
    ResultSet rsProduto;

    /** Creates new form DLProduto */
    public DLProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
        SwingUtilities.updateComponentTreeUI(this);
        this.pack();
        PreencherJtable();

        DefaultTableCellRenderer CellRight = Utilitario.cellRender(0);

        TBProdutos.getColumn("Vlr Unit").setCellRenderer(CellRight);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBProdutos = new javax.swing.JTable();
        TFConsultaProduto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        TBProdutos.setAutoCreateRowSorter(true);
        TBProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Seq", "Cód. Produto", "Desc. Produto", "Vlr Unit", "Selecionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TBProdutos.setSelectionBackground(new java.awt.Color(0, 204, 204));
        TBProdutos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(TBProdutos);
        TBProdutos.getColumnModel().getColumn(0).setMinWidth(0);
        TBProdutos.getColumnModel().getColumn(0).setPreferredWidth(0);
        TBProdutos.getColumnModel().getColumn(0).setMaxWidth(0);
        TBProdutos.getColumnModel().getColumn(1).setMinWidth(80);
        TBProdutos.getColumnModel().getColumn(1).setPreferredWidth(80);
        TBProdutos.getColumnModel().getColumn(1).setMaxWidth(80);
        TBProdutos.getColumnModel().getColumn(2).setMinWidth(300);
        TBProdutos.getColumnModel().getColumn(2).setPreferredWidth(300);
        TBProdutos.getColumnModel().getColumn(2).setMaxWidth(1200);
        TBProdutos.getColumnModel().getColumn(3).setMinWidth(80);
        TBProdutos.getColumnModel().getColumn(3).setPreferredWidth(80);
        TBProdutos.getColumnModel().getColumn(3).setMaxWidth(80);
        TBProdutos.getColumnModel().getColumn(4).setMinWidth(80);
        TBProdutos.getColumnModel().getColumn(4).setPreferredWidth(80);
        TBProdutos.getColumnModel().getColumn(4).setMaxWidth(80);

        TFConsultaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFConsultaProdutoActionPerformed(evt);
            }
        });
        TFConsultaProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFConsultaProdutoFocusLost(evt);
            }
        });
        TFConsultaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFConsultaProdutoKeyReleased(evt);
            }
        });

        jButton1.setText("Lançar Selecionados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TFConsultaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TFConsultaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        try {
            if (rsProduto != null){
                rsProduto.close();
                rsProduto = null;
            }
        } catch (Exception e) {
        }
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void TFConsultaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFConsultaProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFConsultaProdutoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GetsSets.setGrid(TBProdutos);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TFConsultaProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFConsultaProdutoKeyReleased
        PreencherJtable();
    }//GEN-LAST:event_TFConsultaProdutoKeyReleased

    private void TFConsultaProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFConsultaProdutoFocusLost
       if (TBProdutos.getRowCount() > 0) {
           TBProdutos.requestFocus();
           TBProdutos.setRowSelectionInterval(0, 0) ;
           TBProdutos.setColumnSelectionInterval(0, 4) ;
       }
    }//GEN-LAST:event_TFConsultaProdutoFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBProdutos;
    private javax.swing.JTextField TFConsultaProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

 private void PreencherJtable() {
        if (TFConsultaProduto.getText().isEmpty()) {
            rsProduto = FMaster.con.executeSQL("select * from estproduto");
        } else {
            rsProduto = FMaster.con.executeSQL("select * from estproduto  where UPPER(descricao) like UPPER('%" + TFConsultaProduto.getText() + "%')");
        }
        DefaultTableModel modelo = (DefaultTableModel) TBProdutos.getModel();
        modelo.setNumRows(0);
        try {
            while (rsProduto.next()) {
                modelo.addRow(new Object[]{rsProduto.getRow(), rsProduto.getInt("id_produto"), rsProduto.getString("descricao"), Utilitario.getFomatDecimal(rsProduto.getFloat("vlr_unitario"))});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DLProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
