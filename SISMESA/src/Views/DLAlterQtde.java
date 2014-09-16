/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DLAlterQtde.java
 *
 * Created on 08/11/2010, 20:31:27
 */
package Views;

import classess.Utilitario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Demir
 */
public class DLAlterQtde extends javax.swing.JDialog {

    String comanda;
    DLRecebimentoComanda frame;

    /** Creates new form DLAlterQtde */
    public DLAlterQtde(java.awt.Frame parent, boolean modal, String comanda, DLRecebimentoComanda frame) {
        super(parent, modal);
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
        SwingUtilities.updateComponentTreeUI(this);
        this.pack();
        
        this.comanda = comanda;
        this.frame = frame;
        PreencheJtable();

        DefaultTableCellRenderer CellRight2 = Utilitario.cellRender(1);
        TBAlterQtde.getColumn("Quantidade").setCellRenderer(CellRight2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TBAlterQtde = new javax.swing.JTable();
        BTConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Altera quantidade");

        TBAlterQtde.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_comanda", "id_compro", "id_comclie", "Nome Cliente", "Produto", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBAlterQtde.setSelectionBackground(new java.awt.Color(204, 255, 255));
        TBAlterQtde.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(TBAlterQtde);
        TBAlterQtde.getColumnModel().getColumn(0).setMinWidth(0);
        TBAlterQtde.getColumnModel().getColumn(0).setPreferredWidth(0);
        TBAlterQtde.getColumnModel().getColumn(0).setMaxWidth(0);
        TBAlterQtde.getColumnModel().getColumn(1).setMinWidth(0);
        TBAlterQtde.getColumnModel().getColumn(1).setPreferredWidth(0);
        TBAlterQtde.getColumnModel().getColumn(1).setMaxWidth(0);
        TBAlterQtde.getColumnModel().getColumn(2).setMinWidth(0);
        TBAlterQtde.getColumnModel().getColumn(2).setPreferredWidth(0);
        TBAlterQtde.getColumnModel().getColumn(2).setMaxWidth(0);

        BTConfirmar.setText("Confirmar");
        BTConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(BTConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTConfirmar))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-371)/2, (screenSize.height-295)/2, 371, 295);
    }// </editor-fold>//GEN-END:initComponents

    private void BTConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTConfirmarActionPerformed
        AlteraQuantidade();
    }//GEN-LAST:event_BTConfirmarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTConfirmar;
    private javax.swing.JTable TBAlterQtde;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void PreencheJtable() {
        ResultSet rsProdutosAlter = FMaster.con.executeSQL("select * from atncompro "
                + "inner join atncomcli on atncompro.id_com_clie = atncomcli.id_com_clie and atncompro.id_comanda = atncomcli.id_comanda "
                + "inner join estproduto on atncompro.id_produto = estproduto.id_produto "
                + "where atncompro.id_comanda = '" + comanda + "' and atncompro.selecao = 1  order by atncomcli.nome, estproduto.descricao");
        try {
            DefaultTableModel modelo = (DefaultTableModel) TBAlterQtde.getModel();
            modelo.setNumRows(0);
            while (rsProdutosAlter.next()) {
                modelo.addRow(new Object[]{rsProdutosAlter.getString("id_comanda"),
                            rsProdutosAlter.getString("id_com_pro"),
                            rsProdutosAlter.getString("id_com_clie"),
                            rsProdutosAlter.getString("nome"),
                            rsProdutosAlter.getString("descricao"),
                            rsProdutosAlter.getString("qtde_a_pagar")});
            }
            rsProdutosAlter.close();
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void AlteraQuantidade() {
        int qtdeRow = TBAlterQtde.getRowCount();
        for (int l = 0; l < qtdeRow; l++) {
            int qtde = Integer.parseInt(String.valueOf(TBAlterQtde.getValueAt(l, Utilitario.getIndiceColumn("Quantidade", TBAlterQtde))));
            int id_comanda = Integer.parseInt(String.valueOf(TBAlterQtde.getValueAt(l, Utilitario.getIndiceColumn("id_comanda", TBAlterQtde))));
            int id_compro = Integer.parseInt(String.valueOf(TBAlterQtde.getValueAt(l, Utilitario.getIndiceColumn("id_compro", TBAlterQtde))));
            int id_comclie = Integer.parseInt(String.valueOf(TBAlterQtde.getValueAt(l, Utilitario.getIndiceColumn("id_comclie", TBAlterQtde))));
            String nomeProduto = String.valueOf(TBAlterQtde.getValueAt(l, Utilitario.getIndiceColumn("Produto", TBAlterQtde)));
            String nomeCliente = String.valueOf(TBAlterQtde.getValueAt(l, Utilitario.getIndiceColumn("Nome Cliente", TBAlterQtde)));
            ResultSet rsCompro = FMaster.con.executeSQL("select * from atncompro where id_com_clie = '"+id_comclie+"' and id_comanda = '"+id_comanda+"' and id_com_pro = '"+id_compro+"'");
            try {
                rsCompro.first();
                if (rsCompro.isFirst()) {
                    if (qtde > (rsCompro.getInt("qtde")-rsCompro.getFloat("qtde_pago"))) {
                            JOptionPane.showMessageDialog(null, "Quantidade informado é maior que a quantidade a ser pago! Produto: "+nomeProduto+" Cliente: "+nomeCliente, "Alerta", JOptionPane.ERROR_MESSAGE);
                            return;
                    }
                }
                rsCompro.close();
            } catch (SQLException ex) {
                Logger.getLogger(DLAlterQtde.class.getName()).log(Level.SEVERE, null, ex);
            }

            FMaster.con.executeUpdate("update atncompro set qtde_a_pagar = " + qtde + " where id_comanda = '" + id_comanda + "' and id_com_clie = '" + id_comclie + "' and id_com_pro = '" + id_compro + "'");
            FMaster.con.executeUpdate("update atncompro set vlr_a_pagar = (qtde_a_pagar * vlr_unitario) where id_comanda = '" + id_comanda + "' and id_com_clie = '" + id_comclie + "' and id_com_pro = '" + id_compro + "'");

            frame.PreencheJtableRecebimento();
            
        }
        dispose();
    }
}
