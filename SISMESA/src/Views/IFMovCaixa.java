/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IFMovCaixa.java
 *
 * Created on 15/07/2010, 23:15:52
 */
package Views;

import classess.GetsSets;
import classess.Utilitario;
import View_consulta.DLCaixa;
import View_consulta.DLSangria;
import View_consulta.DLSuprimento;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maicol
 */
public class IFMovCaixa extends javax.swing.JInternalFrame {

    Object[] options = {"Sim", "Não"};

    /** Creates new form IFMovCaixa */
    public IFMovCaixa() {
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
//        SwingUtilities.updateComponentTreeUI(this);
//        this.pack();

        DefaultTableCellRenderer CellRight = Utilitario.cellRender(0);



        TBMovCaixa.getColumn("Valor").setCellRenderer(CellRight);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        TBMovCaixa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        dKJTFInteger1 = new Componentes.DKJTFInteger();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BTAbreFecha = new javax.swing.JButton();
        LBAbertoFechado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        FTFVlrCredito = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        FTFVlrDebito = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        FTFSaldo = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BTSangria = new javax.swing.JButton();
        BTSuprimento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        FTFDataAbertura = new javax.swing.JFormattedTextField();
        FTFDataFechamento = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        FTFUsuario = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        BTExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Movimentação do caixa");
        setMinimumSize(new java.awt.Dimension(658, 428));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        TBMovCaixa.setAutoCreateRowSorter(true);
        TBMovCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_abrefechacaixa", "id_caixaitem", "Tipo Lanç.", "Data Lanç.", "Tipo Mov.", "Natureza", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBMovCaixa.setSelectionBackground(new java.awt.Color(0, 204, 204));
        TBMovCaixa.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(TBMovCaixa);
        TBMovCaixa.getColumnModel().getColumn(0).setMinWidth(0);
        TBMovCaixa.getColumnModel().getColumn(0).setPreferredWidth(0);
        TBMovCaixa.getColumnModel().getColumn(0).setMaxWidth(0);
        TBMovCaixa.getColumnModel().getColumn(1).setMinWidth(0);
        TBMovCaixa.getColumnModel().getColumn(1).setPreferredWidth(0);
        TBMovCaixa.getColumnModel().getColumn(1).setMaxWidth(0);
        TBMovCaixa.getColumnModel().getColumn(2).setPreferredWidth(47);
        TBMovCaixa.getColumnModel().getColumn(3).setPreferredWidth(85);
        TBMovCaixa.getColumnModel().getColumn(4).setPreferredWidth(35);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 429;
        gridBagConstraints.ipady = 275;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 0);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        dKJTFInteger1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        dKJTFInteger1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dKJTFInteger1FocusLost(evt);
            }
        });
        dKJTFInteger1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dKJTFInteger1KeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 1, 0);
        jPanel1.add(dKJTFInteger1, gridBagConstraints);

        jLabel9.setText("Caixa (Consulta-F1)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jLabel9, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search_16.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        BTAbreFecha.setText("Abrir");
        BTAbreFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTAbreFechaActionPerformed(evt);
            }
        });
        BTAbreFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BTAbreFechaKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.insets = new java.awt.Insets(3, 6, 0, 0);
        jPanel1.add(BTAbreFecha, gridBagConstraints);

        LBAbertoFechado.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        LBAbertoFechado.setForeground(new java.awt.Color(0, 0, 153));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(4, 6, 0, 0);
        jPanel1.add(LBAbertoFechado, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        FTFVlrCredito.setEditable(false);
        FTFVlrCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        FTFVlrCredito.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 140;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        jPanel2.add(FTFVlrCredito, gridBagConstraints);

        jLabel8.setText("Valor Crédito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel2.add(jLabel8, gridBagConstraints);

        FTFVlrDebito.setEditable(false);
        FTFVlrDebito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        FTFVlrDebito.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 140;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        jPanel2.add(FTFVlrDebito, gridBagConstraints);

        jLabel7.setText("Valor Débito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel2.add(jLabel7, gridBagConstraints);

        FTFSaldo.setEditable(false);
        FTFSaldo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 140;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 0);
        jPanel2.add(FTFSaldo, gridBagConstraints);

        jLabel5.setText("Saldo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel2.add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 4, 0, 0);
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        BTSangria.setText("Sangria");
        BTSangria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSangriaActionPerformed(evt);
            }
        });
        BTSangria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BTSangriaFocusGained(evt);
            }
        });
        BTSangria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BTSangriaKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(BTSangria, gridBagConstraints);

        BTSuprimento.setText("Suprimento");
        BTSuprimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSuprimentoActionPerformed(evt);
            }
        });
        BTSuprimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BTSuprimentoFocusGained(evt);
            }
        });
        BTSuprimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BTSuprimentoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        jPanel3.add(BTSuprimento, gridBagConstraints);

        jLabel3.setText("Data Abertura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        jPanel3.add(jLabel3, gridBagConstraints);

        FTFDataAbertura.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(FTFDataAbertura, gridBagConstraints);

        FTFDataFechamento.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(FTFDataFechamento, gridBagConstraints);

        jLabel4.setText("Data Fechamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        jPanel3.add(jLabel4, gridBagConstraints);

        FTFUsuario.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(FTFUsuario, gridBagConstraints);

        jLabel2.setText("Usuário");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        jPanel3.add(jLabel2, gridBagConstraints);

        BTExcluir.setText("Excluir");
        BTExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTExcluirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        jPanel3.add(BTExcluir, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 0, 0);
        getContentPane().add(jPanel3, gridBagConstraints);

        setBounds(100, 50, 658, 428);
    }// </editor-fold>//GEN-END:initComponents

    private void BTAbreFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTAbreFechaActionPerformed
        if (!dKJTFInteger1.getText().isEmpty() && !dKJTFInteger1.getText().equalsIgnoreCase("0")) {
            AutorizaCaixa();
        }
    }//GEN-LAST:event_BTAbreFechaActionPerformed

    private void BTSangriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSangriaActionPerformed
        SangriaSuprimento(3);
    }//GEN-LAST:event_BTSangriaActionPerformed

    private void BTSuprimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSuprimentoActionPerformed
        SangriaSuprimento(4);
    }//GEN-LAST:event_BTSuprimentoActionPerformed

    private void BTAbreFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTAbreFechaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            AutorizaCaixa();
        }
    }//GEN-LAST:event_BTAbreFechaKeyPressed

    private void BTSangriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTSangriaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            SangriaSuprimento(3);
        }
    }//GEN-LAST:event_BTSangriaKeyPressed

    private void BTSuprimentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTSuprimentoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            SangriaSuprimento(4);
        }
    }//GEN-LAST:event_BTSuprimentoKeyPressed

    private void BTSuprimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTSuprimentoFocusGained
        if (id_CaixaLancadoSangriaSuprimento != 0) {
            PreencheHeder(id_CaixaLancadoSangriaSuprimento);
            id_CaixaLancadoSangriaSuprimento = 0;
        }

    }//GEN-LAST:event_BTSuprimentoFocusGained

    private void BTSangriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BTSangriaFocusGained
        if (id_CaixaLancadoSangriaSuprimento != 0) {
            PreencheHeder(id_CaixaLancadoSangriaSuprimento);
            id_CaixaLancadoSangriaSuprimento = 0;
        }
    }//GEN-LAST:event_BTSangriaFocusGained

    private void BTExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTExcluirActionPerformed
        ExcluirLancamento();
    }//GEN-LAST:event_BTExcluirActionPerformed

    private void dKJTFInteger1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dKJTFInteger1FocusLost
        PosicionaCaixaAberto();
    }//GEN-LAST:event_dKJTFInteger1FocusLost

    private void dKJTFInteger1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dKJTFInteger1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            P_buscaCaixa();
        }
    }//GEN-LAST:event_dKJTFInteger1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        P_buscaCaixa();
        PosicionaCaixaAberto();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTAbreFecha;
    private javax.swing.JButton BTExcluir;
    private javax.swing.JButton BTSangria;
    private javax.swing.JButton BTSuprimento;
    private javax.swing.JFormattedTextField FTFDataAbertura;
    private javax.swing.JFormattedTextField FTFDataFechamento;
    private javax.swing.JFormattedTextField FTFSaldo;
    private javax.swing.JFormattedTextField FTFUsuario;
    private javax.swing.JFormattedTextField FTFVlrCredito;
    private javax.swing.JFormattedTextField FTFVlrDebito;
    private javax.swing.JLabel LBAbertoFechado;
    private javax.swing.JTable TBMovCaixa;
    private Componentes.DKJTFInteger dKJTFInteger1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private ResultSet rsMovCaixa, rsItemMovCaixa, rsCaixa, rsUsuario;
    private int id_CaixaLancadoSangriaSuprimento;

    private void P_buscaCaixa() {
        DLCaixa Caixas = new DLCaixa(null, true);
        Caixas.setVisible(true);
        JTable TBCaixa = GetsSets.getGrid();
        String valor = Utilitario.getValueColumn("Seq", TBCaixa);


        if (!valor.equals("0")) {
            try {

                DLCaixa.rsConsultaCaixa.absolute(Integer.parseInt(valor));
                dKJTFInteger1.setText(String.valueOf(DLCaixa.rsConsultaCaixa.getInt("id_caixa")));
                dKJTFInteger1.requestFocus();
                DLCaixa.rsConsultaCaixa.close();
                DLCaixa.rsConsultaCaixa = null;

                PosicionaCaixaAberto();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problema no posicionamento do caixa");


            }
        }
    }

    private void AutorizaCaixa() {

        AbreFechaCaixa();

    }

    private void PreencherJtable(int idAbreFechaCaixa) {
        DefaultTableModel modelo = (DefaultTableModel) TBMovCaixa.getModel();
        modelo.setNumRows(0);
        try {
            rsItemMovCaixa = FMaster.con.executeSQL("Select * from cxaitemcaixa where id_abrefechacaixa = " + idAbreFechaCaixa);

            while (rsItemMovCaixa.next()) {
                String tipo_lancamento = rsItemMovCaixa.getString("tipo_lancamento");
                if (tipo_lancamento.equals("1")) {
                    tipo_lancamento = "Dinheiro";
                }
                if (tipo_lancamento.equals("2")) {
                    tipo_lancamento = "Cartão Débito";
                }
                if (tipo_lancamento.equals("3")) {
                    tipo_lancamento = "Cartão Crédito";
                }
                if (tipo_lancamento.equals("4")) {
                    tipo_lancamento = "Cheque";
                }
                if (tipo_lancamento.equals("5")) {
                    tipo_lancamento = "Cédula";
                }
                if (tipo_lancamento.equals("6")) {
                    tipo_lancamento = "Moéda";
                }

                String natureza = rsItemMovCaixa.getString("natureza");

                if (natureza.equals("1")) {
                    natureza = "Crédito";
                }
                if (natureza.equals("2")) {
                    natureza = "Débito";
                }

                String tipo_movimento = rsItemMovCaixa.getString("tipo_movimento");

                if (tipo_movimento.equals("1")) {
                    tipo_movimento = "Troco";
                }
                if (tipo_movimento.equals("2")) {
                    tipo_movimento = "Venda";
                }
                if (tipo_movimento.equals("3")) {
                    tipo_movimento = "Sangria";
                }
                if (tipo_movimento.equals("4")) {
                    tipo_movimento = "Suprimento";
                }
                if (tipo_movimento.equals("5")) {
                    tipo_movimento = "Recebimento";
                }

                modelo.addRow(new Object[]{rsItemMovCaixa.getString("id_abrefechacaixa"),
                            rsItemMovCaixa.getString("id_caixaitem"),
                            tipo_lancamento,
                            Utilitario.FormatDate(rsItemMovCaixa.getDate("data_lancamento")),
                            tipo_movimento,
                            natureza,
                            Utilitario.getFomatDecimal(rsItemMovCaixa.getFloat("valor"))});
            }
            rsItemMovCaixa.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFMovCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void AbreFechaCaixa() {
        try {
            int id_Caixa = Integer.parseInt(dKJTFInteger1.getText().isEmpty() ? "0" : dKJTFInteger1.getText());

            rsCaixa = FMaster.con.executeSQL("Select * from cxacaixa where id_caixa = " + id_Caixa);
            rsCaixa.first();

            if (rsCaixa.isFirst()) {
                if (rsCaixa.getInt("situacao") == 1 && rsCaixa.getInt("id_abrefechacaixa") != 0) {
                    FechaCaixa();
                } else {
                    AbreCaixa();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Caixa nao cadastrado!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
            rsCaixa.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFMovCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void limpaCampos() {

        dKJTFInteger1.setText("");
        FTFDataAbertura.setText("");
        FTFDataFechamento.setText("");
        FTFUsuario.setText("");
        FTFVlrCredito.setText(Utilitario.getFomatDecimal(Float.parseFloat("0")));
        FTFVlrDebito.setText(Utilitario.getFomatDecimal(Float.parseFloat("0")));
        FTFSaldo.setText(Utilitario.getFomatDecimal(Float.parseFloat("0")));
        BTAbreFecha.setText("Abrir");
        LBAbertoFechado.setText("");
    }

    private void SangriaSuprimento(int tipoMovimento) {
//        DLLoginAut login = new DLLoginAut(null, true);
//        login.setVisible(true);
//        if (GetsSets.getCodUser() != 0) {
        int id_Caixa = Integer.parseInt(dKJTFInteger1.getText().isEmpty() ? "0" : dKJTFInteger1.getText());

        try {
            rsCaixa = FMaster.con.executeSQL("Select * from cxacaixa where id_caixa = " + id_Caixa);
            rsCaixa.first();
            if (rsCaixa.isFirst()) {
                if (rsCaixa.getInt("situacao") == 1 && rsCaixa.getInt("id_abrefechacaixa") != 0) {
                    rsMovCaixa = FMaster.con.executeSQL("Select * from cxaabrefecha where id_abrefechacaixa = " + rsCaixa.getInt("id_abrefechacaixa"));
                    rsMovCaixa.first();
                    if (rsMovCaixa.isFirst()) {
                        id_CaixaLancadoSangriaSuprimento = rsMovCaixa.getInt("id_abrefechacaixa");
                        if (tipoMovimento == 3) {
                            DLSangria sagria = new DLSangria(null, true, rsMovCaixa.getInt("id_abrefechacaixa"));
                            sagria.setVisible(true);
                        } else if (tipoMovimento == 4) {
                            DLSuprimento suprimento = new DLSuprimento(null, true, rsMovCaixa.getInt("id_abrefechacaixa"));
                            suprimento.setVisible(true);
                        }
                    }
                    rsMovCaixa.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Precisa abrir o caixa", "Alerta", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Caixa nao cadastrado!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
            rsCaixa.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFMovCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }



//        }
    }

    private void AbreCaixa() {
        try {
            int iresp = JOptionPane.showOptionDialog(null, "Deseja abrir o caixa?", "", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, //do not use a custom Icon
                    options, //the titles of buttons
                    options[0]); //default button title
            if (iresp == 0) {
                int achou = VerificaQtdeCaixaAberto();
                if (achou == 0) {
                    rsMovCaixa = FMaster.con.executeSQL("Select * from cxaabrefecha where id_abrefechacaixa = 0");
                    rsMovCaixa.first();

                    //salva movimentação
                    rsMovCaixa.moveToInsertRow();
                    int id_abrefechacaixa = Utilitario.getSequencia("cxaabrefecha", "id_abrefechacaixa");
                    rsMovCaixa.updateInt("id_abrefechacaixa", id_abrefechacaixa);
                    rsMovCaixa.updateInt("id_caixa", Integer.parseInt(dKJTFInteger1.getText()));
                    rsMovCaixa.updateInt("id_usuario", GetsSets.getCodUser());
                    rsMovCaixa.updateTimestamp("data_abertura", Utilitario.getDateAndTimeAtual());
                    rsMovCaixa.insertRow();

                    //Altera o caixa como aberto
                    rsCaixa = FMaster.con.executeSQL("Select * from cxacaixa where id_caixa = " + Integer.parseInt(dKJTFInteger1.getText()));
                    rsCaixa.first();
                    if (rsCaixa.isFirst()) {
                        rsCaixa.absolute(rsCaixa.getRow());
                        rsCaixa.updateInt("situacao", 1);
                        rsCaixa.updateInt("id_abrefechacaixa", id_abrefechacaixa);
                        rsCaixa.updateRow();
                    }

                    //posiciona no movimento gravado para setar os valores na tela
                    rsMovCaixa = FMaster.con.executeSQL("Select * from cxaabrefecha where id_abrefechacaixa = " + id_abrefechacaixa);
                    rsMovCaixa.first();

                    if (rsMovCaixa.isFirst()) {
                        PreencheHeder(rsMovCaixa.getInt("id_abrefechacaixa"));
                    }
                    rsMovCaixa.close();
                    rsCaixa.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(IFMovCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void PreencheHeder(int id_abrefechacaixa) {
        try {
            rsMovCaixa = FMaster.con.executeSQL("Select * from cxaabrefecha where id_abrefechacaixa = " + id_abrefechacaixa);
            rsMovCaixa.first();
            if (rsMovCaixa.isFirst()) {
                rsUsuario = FMaster.con.executeSQL("Select * from grcusuario where id_usuario = " + rsMovCaixa.getInt("id_usuario"));
                rsUsuario.first();
                if (rsUsuario.isFirst()) {
                    FTFUsuario.setText(String.valueOf(rsUsuario.getString("nome")));
                }
                rsCaixa = FMaster.con.executeSQL("Select * from cxacaixa where id_caixa = " + rsMovCaixa.getInt("id_caixa"));
                rsCaixa.first();
                if (rsCaixa.isFirst()) {
                    if (rsCaixa.getInt("situacao") == 1) {
                        BTAbreFecha.setText("Fechar");
                        LBAbertoFechado.setText("Aberto");
                    } else if (rsCaixa.getInt("situacao") == 2) {
                        BTAbreFecha.setText("Abrir");
                        LBAbertoFechado.setText("Fechado");
                    }
                }
                dKJTFInteger1.setText(String.valueOf(rsMovCaixa.getInt("id_caixa")));
                FTFDataAbertura.setText(Utilitario.FormatDate(rsMovCaixa.getDate("data_abertura")));
                FTFDataFechamento.setText(Utilitario.FormatDate(rsMovCaixa.getDate("data_fechamento")));
                FTFVlrDebito.setText(Utilitario.getFomatDecimal(rsMovCaixa.getFloat("valor_debito")));
                FTFVlrCredito.setText(Utilitario.getFomatDecimal(rsMovCaixa.getFloat("valor_credito")));
                FTFSaldo.setText(Utilitario.getFomatDecimal(rsMovCaixa.getFloat("saldo")));

                PreencherJtable(rsMovCaixa.getInt("id_abrefechacaixa"));
                rsUsuario.close();
                rsCaixa.close();
            }
            rsMovCaixa.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFMovCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void FechaCaixa() {
        try {
            int iresp = JOptionPane.showOptionDialog(null, "Deseja fechar o caixa?", "", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, //do not use a custom Icon
                    options, //the titles of buttons
                    options[0]); //default button title
            if (iresp == 0) {


                int id_Caixa = Integer.parseInt(dKJTFInteger1.getText().isEmpty() ? "0" : dKJTFInteger1.getText());
                rsCaixa = FMaster.con.executeSQL("Select * from cxacaixa where id_caixa = " + id_Caixa);
                rsCaixa.first();
                if (rsCaixa.isFirst()) {
                    try {
                        rsMovCaixa = FMaster.con.executeSQL("Select * from cxaabrefecha where id_abrefechacaixa = " + rsCaixa.getInt("id_abrefechacaixa"));
                        rsMovCaixa.first();
                        if (rsMovCaixa.isFirst()) {
                            rsMovCaixa.updateTimestamp("data_fechamento", Utilitario.getDateAndTimeAtual());
                            rsMovCaixa.updateRow();
                        }
                        rsMovCaixa.close();
                    } catch (Exception e) {
                    }
                    rsCaixa.updateInt("situacao", 2);
                    rsCaixa.updateRow();
                    limpaCampos();
                    PreencherJtable(0);
                }
                rsCaixa.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(IFMovCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void PosicionaCaixaAberto() {
        int id_Caixa = Integer.parseInt(dKJTFInteger1.getText().isEmpty() ? "0" : dKJTFInteger1.getText());
        try {
            rsCaixa = FMaster.con.executeSQL("Select * from cxacaixa where id_caixa = " + id_Caixa);
            rsCaixa.first();
            if (rsCaixa.isFirst()) {
                if (rsCaixa.getInt("situacao") == 1 && rsCaixa.getInt("id_abrefechacaixa") != 0) {
                    PreencheHeder(rsCaixa.getInt("id_abrefechacaixa"));
                } else {
                    FTFDataAbertura.setText("");
                    FTFDataFechamento.setText("");
                    FTFUsuario.setText("");
                    FTFVlrCredito.setText(Utilitario.getFomatDecimal(Float.parseFloat("0")));
                    FTFVlrDebito.setText(Utilitario.getFomatDecimal(Float.parseFloat("0")));
                    FTFSaldo.setText(Utilitario.getFomatDecimal(Float.parseFloat("0")));
                    BTAbreFecha.setText("Abrir");
                    LBAbertoFechado.setText("Fechado");
                    PreencherJtable(0);
                }
            } else {
                FTFDataAbertura.setText("");
                FTFDataFechamento.setText("");
                FTFUsuario.setText("");
                FTFVlrCredito.setText(Utilitario.getFomatDecimal(Float.parseFloat("0")));
                FTFVlrDebito.setText(Utilitario.getFomatDecimal(Float.parseFloat("0")));
                FTFSaldo.setText(Utilitario.getFomatDecimal(Float.parseFloat("0")));
                BTAbreFecha.setText("Abrir");
                LBAbertoFechado.setText("");
                PreencherJtable(0);
            }
            rsCaixa.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFMovCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ExcluirLancamento() {
        int id_Caixa = Integer.parseInt(dKJTFInteger1.getText().isEmpty() ? "0" : dKJTFInteger1.getText());
        if (TBMovCaixa.getSelectedRow() != -1) {
            int iresp = JOptionPane.showOptionDialog(null, "Deseja excluir o lançamento selecionado?", "", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, //do not use a custom Icon
                    options, //the titles of buttons
                    options[0]); //default button title
            if (iresp == 0) {
                String id_caixaitem = Utilitario.getValueColumn("id_caixaitem", TBMovCaixa);
                String id_abrefechacaixa = Utilitario.getValueColumn("id_abrefechacaixa", TBMovCaixa);
                try {
                    FMaster.con.executeUpdate("delete from cxaitemcaixa where id_caixaitem = '" + id_caixaitem + "' and id_abrefechacaixa = '" + id_abrefechacaixa + "'");
                    rsCaixa = FMaster.con.executeSQL("Select * from cxacaixa where id_caixa = " + id_Caixa);
                    rsCaixa.first();
                    if (rsCaixa.isFirst()) {
                        AtualizaTotais(rsCaixa.getInt("id_abrefechacaixa"));
                        PreencheHeder(rsCaixa.getInt("id_abrefechacaixa"));
                    }
                    rsCaixa.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IFMovCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma movimentacao!", "Alerta", JOptionPane.ERROR_MESSAGE);
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

    //Verifica se existe mais de caixa aberto
    private int VerificaQtdeCaixaAberto() {
        int achou = 0;
        try {
            ResultSet rsCaixa2 = FMaster.con.executeSQL("select count(*) as qtdecaixa from cxacaixa where situacao = 1");
            rsCaixa2.first();
            if (rsCaixa2.isFirst()) {
                if (rsCaixa2.getInt("qtdecaixa") > 0) {
                    JOptionPane.showMessageDialog(null, "Não é permitido abrir mais e um caixa!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    achou = 1;
                } else {
                    achou = 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(IFCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return achou;
    }
}
