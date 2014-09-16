/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DLProdutos.java
 *
 * Created on 14/06/2010, 15:38:22
 */

package View_consulta;

import classess.Utilitario;
import Views.FMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Maicol
 */
public class DLProdutos extends javax.swing.JDialog {
    JTextField tfcod_produto;
    /** Creates new form DLProdutos */
    public DLProdutos(java.awt.Frame parent, boolean modal, JTextField tfcod_produto) {
        super(parent, modal);        
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
        SwingUtilities.updateComponentTreeUI(this);
        this.pack();
        this.tfcod_produto = tfcod_produto;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de produtos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        TBProdutos.setAutoCreateRowSorter(true);
        TBProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cód. Produto", "Desc. Produto", "Vlr Unit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        TBProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBProdutosMouseClicked(evt);
            }
        });
        TBProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TBProdutosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TBProdutos);
        TBProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TFConsultaProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(TFConsultaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-657)/2, (screenSize.height-405)/2, 657, 405);
    }// </editor-fold>//GEN-END:initComponents

    private void TBProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBProdutosMouseClicked
        if ( evt.getClickCount() > 1) {
            tfcod_produto.setText(Utilitario.getValueColumn("Cód. Produto", TBProdutos));
            dispose();
        }
    }//GEN-LAST:event_TBProdutosMouseClicked

    private void TBProdutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBProdutosKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
           tfcod_produto.setText(Utilitario.getValueColumn("Cód. Produto", TBProdutos));
           dispose();
        }
    }//GEN-LAST:event_TBProdutosKeyPressed

    private void TFConsultaProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFConsultaProdutoFocusLost
       if (!TFConsultaProduto.getText().isEmpty()) PreencherJtable();
       if (TBProdutos.getRowCount() > 0) {
           TBProdutos.requestFocus();
           TBProdutos.setRowSelectionInterval(0, 0) ;
       }
    }//GEN-LAST:event_TFConsultaProdutoFocusLost

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void TFConsultaProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFConsultaProdutoKeyReleased
        PreencherJtable();
    }//GEN-LAST:event_TFConsultaProdutoKeyReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBProdutos;
    private javax.swing.JTextField TFConsultaProduto;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

 private void PreencherJtable() {
     ResultSet rsProduto;
        if (TFConsultaProduto.getText().isEmpty()) {
            rsProduto = FMaster.con.executeSQL("select * from estproduto where tipo_produto = 1");
        } else {
            rsProduto = FMaster.con.executeSQL("select * from estproduto  where UPPER(descricao) like UPPER('%" + TFConsultaProduto.getText() + "%') and tipo_produto = 1");
        }
        DefaultTableModel modelo = (DefaultTableModel) TBProdutos.getModel();
        modelo.setNumRows(0);
        try {
            while (rsProduto.next()) {
                modelo.addRow(new Object[]{rsProduto.getInt("id_produto"), rsProduto.getString("descricao"), Utilitario.getFomatDecimal(rsProduto.getFloat("vlr_unitario"))});
            }
        } catch (SQLException ex) {
            Logger.getLogger(DLProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
