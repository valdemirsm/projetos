/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IFConfigEc.java
 *
 * Created on 03/05/2011, 22:04:02
 */
package Views;

import classess.Utilitario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author stevan t
 */
public class IFConfigEc extends javax.swing.JInternalFrame {

    /** Creates new form IFConfigEc */
    public IFConfigEc() {
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
//        SwingUtilities.updateComponentTreeUI(this);
//        this.pack();
        PreencheHeder();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        TFDescAliquota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TFValorAliquota = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        TFComanda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFDelivery = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        CBImprimirCF = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Visualização da configuração do Cupom Fiscal");
        setMinimumSize(new java.awt.Dimension(441, 301));
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aliquota configurada para emissão do Cupom FIscal"));

        TFDescAliquota.setEditable(false);
        TFDescAliquota.setToolTipText("Descrição do tipo de aliquota configurada para impressão fiscal!");

        jLabel3.setText("Descricao");

        jLabel4.setText("Valor(%)");

        TFValorAliquota.setEditable(false);
        TFValorAliquota.setToolTipText("Valor em percentual da aliquota.");
        TFValorAliquota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFValorAliquotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFDescAliquota)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFValorAliquota)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFDescAliquota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFValorAliquota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 10, 410, 100);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro do ultimo atendimento gerado Cupom Fiscal"));

        TFComanda.setEditable(false);

        jLabel1.setText("Cód. Comanda");

        jLabel2.setText("Cód. Delivery");

        TFDelivery.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TFComanda, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TFDelivery, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 110, 410, 100);

        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 230, 90, 23);

        CBImprimirCF.setText("Impirmir Cupom Fiscal?");
        CBImprimirCF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBImprimirCFActionPerformed(evt);
            }
        });
        getContentPane().add(CBImprimirCF);
        CBImprimirCF.setBounds(10, 230, 210, 23);

        setBounds(100, 50, 441, 301);
    }// </editor-fold>//GEN-END:initComponents

    private void TFValorAliquotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFValorAliquotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFValorAliquotaActionPerformed

    private void CBImprimirCFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBImprimirCFActionPerformed
        SalvarConfiguracao();
    }//GEN-LAST:event_CBImprimirCFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PreencheHeder();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CBImprimirCF;
    private javax.swing.JTextField TFComanda;
    private javax.swing.JTextField TFDelivery;
    private javax.swing.JTextField TFDescAliquota;
    private javax.swing.JTextField TFValorAliquota;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void PreencheHeder() {
        ResultSet rsConfigECF = FMaster.con.executeSQL("select * from atnconfigecf");
        try {
            rsConfigECF.first();
            if (rsConfigECF.isFirst()) {
                TFComanda.setText(rsConfigECF.getString("id_Comanda"));
                TFDelivery.setText(rsConfigECF.getString("id_delivery"));
                TFDescAliquota.setText(rsConfigECF.getString("desc_aliquota"));
                TFValorAliquota.setText(rsConfigECF.getString("vlr_aliquota"));
                
                int status = rsConfigECF.getInt("imprimir_cf");
                if (status == 0){
                    CBImprimirCF.setSelected(false);
                }
                
                if (status == 1){
                    CBImprimirCF.setSelected(true);
                }
            }
            rsConfigECF.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFConfigEc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void SalvarConfiguracao() {
        //FMaster.con.executeUpdate("delete from atnconfigecf");
        ResultSet rsConfiguracao = FMaster.con.executeSQL("select * from atnconfigecf");
        try {
            int status;
            if (CBImprimirCF.isSelected()==true){
                status =1;
            }
            else {
                status =0;
            }
            rsConfiguracao.first();
            if (rsConfiguracao.isFirst()) {
                rsConfiguracao.absolute(rsConfiguracao.getRow());
                rsConfiguracao.updateInt("imprimir_cf", status);
                rsConfiguracao.updateRow();
            } else {
                rsConfiguracao.moveToInsertRow();
                rsConfiguracao.updateInt("imprimir_cf", status);
                rsConfiguracao.insertRow();
            }
            rsConfiguracao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
