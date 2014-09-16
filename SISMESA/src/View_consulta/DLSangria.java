/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DLSuprimento.java
 *
 * Created on 23/07/2010, 12:03:36
 */
package View_consulta;

import classess.GetsSets;
import classess.Utilitario;
import Views.FMaster;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Demir
 */
public class DLSangria extends javax.swing.JDialog {

    int id_abrefechacaixa;

    /** Creates new form DLSuprimento */
    public DLSangria(java.awt.Frame parent, boolean modal, int id_abrefechacaixa) {
        super(parent, modal);
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
        SwingUtilities.updateComponentTreeUI(this);
        this.pack();
        this.id_abrefechacaixa = id_abrefechacaixa;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAMotivo = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        FTFValor = new Componentes.DKJTFFloat();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sangria");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jLabel1.setText("Valor");

        TAMotivo.setColumns(20);
        TAMotivo.setRows(5);
        jScrollPane1.setViewportView(TAMotivo);

        jLabel2.setText("Motivo/Descrição");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-403)/2, (screenSize.height-230)/2, 403, 230);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LancaSangria();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            LancaSangria();
        }
    }//GEN-LAST:event_jButton1KeyPressed
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                DLSuprimento dialog = new DLSuprimento(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Componentes.DKJTFFloat FTFValor;
    private javax.swing.JTextArea TAMotivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private ResultSet rsMovCaixa;
    private ResultSet rsMovItemCaixa;
    private ResultSet rsSequnciaItemCaixa;

    private void LancaSangria() {
        try {
            rsMovCaixa = FMaster.con.executeSQL("Select * from cxaabrefecha where id_abrefechacaixa = " + id_abrefechacaixa);
            rsMovCaixa.first();
            if (rsMovCaixa.isFirst()) {
                rsMovItemCaixa = FMaster.con.executeSQL("Select * from cxaitemcaixa where id_abrefechacaixa = " + rsMovCaixa.getInt("id_abrefechacaixa"));
                rsMovItemCaixa.first();
                

                rsMovItemCaixa.moveToInsertRow();
                rsMovItemCaixa.updateInt("id_caixaitem", Utilitario.getSequencia("cxaitemcaixa", "id_caixaitem"));
                rsMovItemCaixa.updateInt("id_abrefechacaixa", rsMovCaixa.getInt("id_abrefechacaixa"));
                rsMovItemCaixa.updateFloat("valor", Float.parseFloat(FTFValor.getText().replace(",", ".")));
                rsMovItemCaixa.updateInt("tipo_lancamento", 1);
                rsMovItemCaixa.updateInt("natureza", 2);
                rsMovItemCaixa.updateTimestamp("data_lancamento", Utilitario.getDateAndTimeAtual());
                rsMovItemCaixa.updateInt("tipo_movimento", 3);
                rsMovItemCaixa.updateString("motivo", TAMotivo.getText().isEmpty()?"":TAMotivo.getText());
                rsMovItemCaixa.updateInt("id_usuario", GetsSets.getCodUser());
                rsMovItemCaixa.insertRow();
                AtualizaTotais(rsMovCaixa.getInt("id_abrefechacaixa"));
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DLSangria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void AtualizaTotais(int aInt) {
        String sql = "update cxaabrefecha set valor_credito = (select COALESCE(sum(valor),0) from cxaitemcaixa where cxaitemcaixa.id_abrefechacaixa = cxaabrefecha.id_abrefechacaixa and cxaitemcaixa.natureza = 1), "
                + "valor_debito = (select COALESCE(sum(valor),0) from cxaitemcaixa where cxaitemcaixa.id_abrefechacaixa = cxaabrefecha.id_abrefechacaixa and cxaitemcaixa.natureza = 2) "
                + "where cxaabrefecha.id_abrefechacaixa = " + aInt;
        FMaster.con.executeUpdate(sql);
        sql = "update cxaabrefecha set saldo = valor_credito - valor_debito where cxaabrefecha.id_abrefechacaixa = " + aInt;
        FMaster.con.executeUpdate(sql);

    }
}
