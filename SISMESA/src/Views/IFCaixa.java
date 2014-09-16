/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJInternalFrame.java
 *
 * Created on 20/05/2010, 22:42:47
 */
package Views;

import classess.GetsSets;
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
 * @author Maicol
 */
public class IFCaixa extends javax.swing.JInternalFrame {
    //Declarando resultSet * recebe o resultado da sentecao SQl

    //  public static ArrayList FiltrosAtivos = new ArrayList();
    //  public static ArrayList Operadores = new ArrayList();
    /** Creates new form NewJInternalFrame */
    public IFCaixa() {
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
        SwingUtilities.updateComponentTreeUI(this);
        this.pack();
        PreencherJtable();
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
        lbCodigo = new javax.swing.JLabel();
        TFCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TFDescricao = new javax.swing.JTextField();
        TFSituacao = new javax.swing.JTextField();
        LBSituacao = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BTNovo = new javax.swing.JButton();
        BTSalvar = new javax.swing.JButton();
        BTExcluir = new javax.swing.JButton();
        BTAbrirFechar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        FTFfiltro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CB_STATUS = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TFDESC_GERAL = new javax.swing.JTextField();
        BT_FILTER = new javax.swing.JButton();
        TFCod_Ini = new Componentes.DKJTFInteger();
        TFCod_Fin = new Componentes.DKJTFInteger();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbPadrao = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cadastro de Caixa");
        setMinimumSize(new java.awt.Dimension(658, 340));

        jPanel1.setFocusable(false);

        lbCodigo.setText("Código");

        TFCodigo.setEditable(false);

        jLabel3.setText("Descrição");

        TFDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFDescricaoActionPerformed(evt);
            }
        });

        TFSituacao.setEditable(false);
        TFSituacao.setText("Fechado");

        LBSituacao.setText("Situação");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        BTNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Clear-32.png"))); // NOI18N
        BTNovo.setText("Limpar");
        BTNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNovoActionPerformed(evt);
            }
        });

        BTSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save_16.png"))); // NOI18N
        BTSalvar.setText("Salvar");
        BTSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSalvarActionPerformed(evt);
            }
        });

        BTExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete_16.png"))); // NOI18N
        BTExcluir.setText("Excluir");
        BTExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        BTAbrirFechar.setText("...");
        BTAbrirFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTAbrirFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbCodigo)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(TFSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTAbrirFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LBSituacao))
                .addContainerGap(61, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCodigo)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TFSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTAbrirFechar)
                        .addComponent(TFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LBSituacao)
                        .addGap(29, 29, 29)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        jPanel2.setMinimumSize(new java.awt.Dimension(579, 542));

        FTFfiltro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        FTFfiltro.setMinimumSize(new java.awt.Dimension(564, 83));

        jLabel1.setText("Código Inicial:");

        jLabel2.setText("Código Final:");

        CB_STATUS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Aberto", "Fechado" }));
        CB_STATUS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_STATUSItemStateChanged(evt);
            }
        });

        jLabel4.setText("Situação:");

        jLabel5.setText("Descrição/ Geral:");

        TFDESC_GERAL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFDESC_GERALKeyReleased(evt);
            }
        });

        BT_FILTER.setText("Limpar");
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

        TFCod_Ini.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFCod_IniFocusLost(evt);
            }
        });

        TFCod_Fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFCod_FinActionPerformed(evt);
            }
        });
        TFCod_Fin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFCod_FinFocusLost(evt);
            }
        });

        javax.swing.GroupLayout FTFfiltroLayout = new javax.swing.GroupLayout(FTFfiltro);
        FTFfiltro.setLayout(FTFfiltroLayout);
        FTFfiltroLayout.setHorizontalGroup(
            FTFfiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FTFfiltroLayout.createSequentialGroup()
                .addGroup(FTFfiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FTFfiltroLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFDESC_GERAL, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BT_FILTER, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FTFfiltroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TFCod_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFCod_Fin, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CB_STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        FTFfiltroLayout.setVerticalGroup(
            FTFfiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FTFfiltroLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(FTFfiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFCod_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(TFCod_Fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(CB_STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(FTFfiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FTFfiltroLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5))
                    .addGroup(FTFfiltroLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(FTFfiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFDESC_GERAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BT_FILTER))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TbPadrao.setAutoCreateRowSorter(true);
        TbPadrao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TbPadrao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        TbPadrao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbPadraoMouseClicked(evt);
            }
        });
        TbPadrao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TbPadraoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TbPadrao);
        TbPadrao.getColumnModel().getColumn(0).setMinWidth(50);
        TbPadrao.getColumnModel().getColumn(0).setPreferredWidth(50);
        TbPadrao.getColumnModel().getColumn(0).setMaxWidth(50);
        TbPadrao.getColumnModel().getColumn(1).setMinWidth(50);
        TbPadrao.getColumnModel().getColumn(1).setPreferredWidth(100);
        TbPadrao.getColumnModel().getColumn(1).setMaxWidth(150);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FTFfiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(FTFfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pesquisar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(100, 50, 658, 340);
    }// </editor-fold>//GEN-END:initComponents

    private void BTNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNovoActionPerformed
        LimpaCampos();
}//GEN-LAST:event_BTNovoActionPerformed

    private void BTSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSalvarActionPerformed
        GravarCaixa();
        PreencherJtable();
        LimpaCampos();
}//GEN-LAST:event_BTSalvarActionPerformed

    private void BTExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTExcluirActionPerformed
        try {
            if (TFCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione um Caixa");
                return;
            } else {
                String id_caixa = TFCodigo.getText();
                ResultSet rsCaxa = FMaster.con.executeSQL("select * from cxacaixa where id_caixa = '" + id_caixa + "'");
                rsCaxa.first();
                if (rsCaxa.isFirst()) {
                    rsCaxa.absolute(rsCaxa.getRow());
                    rsCaxa.deleteRow();
                    PreencherJtable();
                    LimpaCampos();
                }
                rsCaxa.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(IFProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_BTExcluirActionPerformed

    private void TbPadraoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPadraoMouseClicked
        if (evt.getClickCount() > 1) {
            prencherHeder();
        }

    }//GEN-LAST:event_TbPadraoMouseClicked

    private void TFDESC_GERALKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFDESC_GERALKeyReleased
        PreencherJtable();
    }//GEN-LAST:event_TFDESC_GERALKeyReleased

    private void CB_STATUSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_STATUSItemStateChanged
        PreencherJtable();
    }//GEN-LAST:event_CB_STATUSItemStateChanged

    private void BT_FILTERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_FILTERActionPerformed
        LimpaCamposSelecao();
        PreencherJtable();
    }//GEN-LAST:event_BT_FILTERActionPerformed

    private void BT_FILTERKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BT_FILTERKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            LimpaCamposSelecao();
            PreencherJtable();
        }
    }//GEN-LAST:event_BT_FILTERKeyPressed

    private void TbPadraoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TbPadraoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            prencherHeder();
        }
    }//GEN-LAST:event_TbPadraoKeyPressed

    private void BTAbrirFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTAbrirFecharActionPerformed
        AbrirFechaCaixa();
    }//GEN-LAST:event_BTAbrirFecharActionPerformed

    private void TFCod_IniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFCod_IniFocusLost
        PreencherJtable();
    }//GEN-LAST:event_TFCod_IniFocusLost

    private void TFCod_FinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFCod_FinFocusLost
        PreencherJtable();
    }//GEN-LAST:event_TFCod_FinFocusLost

    private void TFCod_FinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFCod_FinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFCod_FinActionPerformed

    private void TFDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFDescricaoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTAbrirFechar;
    private javax.swing.JButton BTExcluir;
    private javax.swing.JButton BTNovo;
    private javax.swing.JButton BTSalvar;
    private javax.swing.JButton BT_FILTER;
    private javax.swing.JComboBox CB_STATUS;
    private javax.swing.JPanel FTFfiltro;
    private javax.swing.JLabel LBSituacao;
    private Componentes.DKJTFInteger TFCod_Fin;
    private Componentes.DKJTFInteger TFCod_Ini;
    private javax.swing.JTextField TFCodigo;
    private javax.swing.JTextField TFDESC_GERAL;
    private javax.swing.JTextField TFDescricao;
    private javax.swing.JTextField TFSituacao;
    private javax.swing.JTable TbPadrao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbCodigo;
    // End of variables declaration//GEN-END:variables

    private void PreencherJtable() {
        String sCod_Ini = TFCod_Ini.getText();
        String sCod_Fin = TFCod_Fin.getText();
        String sDescReral = TFDESC_GERAL.getText().trim();
        Integer iStatus = CB_STATUS.getSelectedIndex();
        String sFiltro = "";
        String sSituacao = "";
        ResultSet rsCaixa;

        if (!sCod_Ini.equals("")) {
            sFiltro = (" ID_CAIXA>=" + sCod_Ini);
        }
        if (!sCod_Fin.equals("")) {
            if (!sFiltro.equals("")) {
                sFiltro = (sFiltro + " AND");
            }
            sFiltro = (sFiltro + " ID_CAIXA<=" + sCod_Fin);
        }

        if (!iStatus.equals(0)) {
            if (!sFiltro.equals("")) {
                sFiltro = (sFiltro + " AND");
            }
            sFiltro = (sFiltro + " SITUACAO=" + iStatus);
        }

        if (!sDescReral.equals("")) {
            if (!sFiltro.equals("")) {
                sFiltro = (sFiltro + " AND");
            }
            sFiltro = (sFiltro + (" (UPPER(CAST(ID_CAIXA AS VARCHAR))) LIKE '%" + sDescReral.toUpperCase() + "%' OR"
                    + " (UPPER(DESCRICAO)) LIKE '%" + sDescReral.toUpperCase() + "%'"));
        }
        if (!sFiltro.equals("")) {
            sFiltro = (sFiltro + "ORDER BY ID_CAIXA");
        }

        if (sFiltro.isEmpty()) {
            rsCaixa = FMaster.con.executeSQL("select * from cxacaixa");
        } else {
            rsCaixa = FMaster.con.executeSQL("select * from cxacaixa where " + sFiltro);
        }

        DefaultTableModel modelo = (DefaultTableModel) TbPadrao.getModel();
        modelo.setNumRows(0);
        try {
            while (rsCaixa.next()) {

                if (rsCaixa.getInt("situacao") == 1) {
                    sSituacao = "Aberto";
                } else {
                    sSituacao = "Fechado";
                }

                modelo.addRow(new Object[]{rsCaixa.getInt("id_caixa"), rsCaixa.getString("descricao"), sSituacao});
            }
            rsCaixa.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(IFCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void GravarCaixa() {
        int id_caixa, iSituacao;
        id_caixa = Utilitario.getSequencia("cxacaixa", "id_caixa");

        try {
            if (TFCodigo.getText().isEmpty()) {
                ResultSet rsCaixa = FMaster.con.executeSQL("select * from cxacaixa where id_caixa = 0");
                rsCaixa.first();
                rsCaixa.moveToInsertRow();
                rsCaixa.updateInt("id_caixa", id_caixa);
                rsCaixa.updateString("descricao", TFDescricao.getText());
                rsCaixa.updateInt("situacao", 2);
                rsCaixa.insertRow();
                rsCaixa.close();
            } else {
                ResultSet rsCaixa = FMaster.con.executeSQL("select * from cxacaixa where id_caixa = '" + TFCodigo.getText() + "'");
                rsCaixa.first();
                if (rsCaixa.isFirst()) {
                    if (TFSituacao.getText().equals("Fechado")) {
                        iSituacao = 1;
                    } else {
                        iSituacao = 2;
                    }
                    rsCaixa.updateString("descricao", TFDescricao.getText());
                    rsCaixa.updateInt("situacao", iSituacao);
                    rsCaixa.updateRow();
                }
                rsCaixa.close();
                // rsCaixa.updateInt("id_caixa", id_caixa);

            }
            PreencherJtable();
        } catch (Exception ex) {
        }
    }

    private void HabilitaCampos() {
    }

    private void LimpaCampos() {
        TFCodigo.setText("");
        TFDescricao.setText("");
        TFSituacao.setText("");
        TFSituacao.setText("Fechado");
    }

    private void prencherHeder() {
        String id_caixa = Utilitario.getValueColumn("Código", TbPadrao);
        if (!id_caixa.equals("0")) {
            ResultSet rsCaixa = FMaster.con.executeSQL("select * from cxacaixa where id_caixa = '" + id_caixa + "'");
            try {
                rsCaixa.first();
                if (rsCaixa.isFirst()) {
                    TFCodigo.setText(String.valueOf(rsCaixa.getInt("id_caixa")));
                    TFDescricao.setText(rsCaixa.getString("descricao"));
                    TFSituacao.setText((rsCaixa.getInt("situacao")) == 1 ? "Aberto" : "Fechado");
                    jTabbedPane1.setSelectedIndex(0);
                    TFDescricao.requestFocus();
                    SetaLabelBtn();
                }
                rsCaixa.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problema no posicionamento do produto");
            }
        }
    }

//    private void Filtra(String sFiltroGeral) {
//        String sCod_Ini = TFCod_Ini.getText();
//        String sCod_Fin = TFCod_Fin.getText();
//        Integer iStatus = CB_STATUS.getSelectedIndex();
//        String sFiltro = "";
//
//        if (!sCod_Ini.equals("")) {
//            sFiltro = (" ID_CAIXA>=" + sCod_Ini);
//        }
//        if (!sCod_Fin.equals("")) {
//            if (!sFiltro.equals("")) {
//                sFiltro = (sFiltro + " AND");
//            }
//            sFiltro = (sFiltro + " ID_CAIXA<=" + sCod_Fin);
//        }
//
//        if (!iStatus.equals(0)) {
//            if (!sFiltro.equals("")) {
//                sFiltro = (sFiltro + " AND");
//            }
//            sFiltro = (sFiltro + " SITUACAO=" + iStatus);
//        }
//
//        if ((!sFiltroGeral.equals("")) && (!sFiltro.equals(""))) {
//            sFiltro = (sFiltro + " AND (" + sFiltroGeral + ")");
//        } else if (sFiltro.equals("")) {
//            sFiltro = sFiltroGeral;
//        }
//        if (!sFiltro.equals("")) {
//            sFiltro = (sFiltro + "ORDER BY ID_CAIXA");
//        }
//
//        PreencherJtable(sFiltro);
//
//    }
//    private void FiltraGeral() {
//        String sFiltro = TFDESC_GERAL.getText().trim();
//        Integer iSituacao = 0;
//        if (!sFiltro.equals("")) {
//
//            if (sFiltro.toUpperCase().contains("ABERTO")) {
//                iSituacao = 1;
//            }
//            if (sFiltro.toUpperCase().contains("FECHADO")) {
//                iSituacao = 2;
//            }
//
//            sFiltro = (" (UPPER(CAST(ID_CAIXA AS VARCHAR))) LIKE '%" + sFiltro.toUpperCase() + "%' OR"
//                    + " (UPPER(DESCRICAO)) LIKE '%" + sFiltro.toUpperCase() + "%'");
//            if (iSituacao != 0) {
//                sFiltro = (sFiltro + " OR" + " SITUACAO=" + iSituacao + " ");
//            }
//
//        }
//        Filtra(sFiltro);
//    }
    private void LimpaCamposSelecao() {
        TFCod_Ini.setText("");
        TFCod_Fin.setText("");
        TFDESC_GERAL.setText("");

    }

    private void AbrirFechaCaixa() {
        if (!TFCodigo.getText().isEmpty()) {

            try {
                ResultSet rsAbreCaixa = FMaster.con.executeSQL("Select * from cxacaixa where id_caixa = " + Integer.parseInt(TFCodigo.getText()));
                rsAbreCaixa.first();
                if (rsAbreCaixa.isFirst()) {
                    if (rsAbreCaixa.getInt("situacao") == 1) {
                        rsAbreCaixa.updateInt("situacao", 2);
                        rsAbreCaixa.updateRow();
                        rsAbreCaixa.refreshRow();
                        FechaCaixa(rsAbreCaixa.getInt("id_caixa"));
                        TFCodigo.setText(String.valueOf(rsAbreCaixa.getInt("id_caixa")));
                        TFDescricao.setText(rsAbreCaixa.getString("descricao"));
                        TFSituacao.setText((rsAbreCaixa.getInt("situacao")) == 1 ? "Aberto" : "Fechado");

                    } else {
                        // verifica se existe mais de um caixa aberto
                        // se exitir mais de um caixa aberto returna 1 senao 0
                        int achou = VerificaQtdeCaixaAberto();
                        if (achou == 0) {
                            rsAbreCaixa.updateInt("situacao", 1);
                            rsAbreCaixa.updateRow();
                            rsAbreCaixa.refreshRow();
                            AbreCaixa(rsAbreCaixa.getInt("id_caixa"));
                            TFCodigo.setText(String.valueOf(rsAbreCaixa.getInt("id_caixa")));
                            TFDescricao.setText(rsAbreCaixa.getString("descricao"));
                            TFSituacao.setText((rsAbreCaixa.getInt("situacao")) == 1 ? "Aberto" : "Fechado");
                        }
                    }
                }

                rsAbreCaixa.close();
                SetaLabelBtn();


            } catch (SQLException ex) {
                Logger.getLogger(IFCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void AbreCaixa(int aInt) {
        ResultSet rsMovCaixa = FMaster.con.executeSQL("Select * from cxaabrefecha where id_abrefechacaixa = 0");
        try {
            rsMovCaixa.first();
            //salva movimentação
            rsMovCaixa.moveToInsertRow();
            int id_abrefechacaixa = Utilitario.getSequencia("cxaabrefecha", "id_abrefechacaixa");
            rsMovCaixa.updateInt("id_abrefechacaixa", id_abrefechacaixa);
            rsMovCaixa.updateInt("id_caixa", aInt);
            rsMovCaixa.updateInt("id_usuario", GetsSets.getCodUser());
            rsMovCaixa.updateTimestamp("data_abertura", Utilitario.getDateAndTimeAtual());
            rsMovCaixa.insertRow();

            //Altera o caixa como aberto
            ResultSet rsCaixa2 = FMaster.con.executeSQL("Select * from cxacaixa where id_caixa = " + aInt);
            rsCaixa2.first();
            if (rsCaixa2.isFirst()) {
                rsCaixa2.absolute(rsCaixa2.getRow());
                rsCaixa2.updateInt("situacao", 1);
                rsCaixa2.updateInt("id_abrefechacaixa", id_abrefechacaixa);
                rsCaixa2.updateRow();
            }
            rsCaixa2.close();
            rsMovCaixa.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private void FechaCaixa(int aInt) {
        try {
            ResultSet rsCaixa2 = FMaster.con.executeSQL("Select * from cxacaixa where id_caixa = " + aInt);
            rsCaixa2.first();
            if (rsCaixa2.isFirst()) {
                try {
                    ResultSet rsMovCaixa = FMaster.con.executeSQL("Select * from cxaabrefecha where id_abrefechacaixa = " + rsCaixa2.getInt("id_abrefechacaixa"));
                    rsMovCaixa.first();
                    if (rsMovCaixa.isFirst()) {
                        rsMovCaixa.updateTimestamp("data_fechamento", Utilitario.getDateAndTimeAtual());
                        rsMovCaixa.updateRow();
                    }
                    rsMovCaixa.close();
                } catch (Exception e) {
                }
                rsCaixa2.updateInt("situacao", 2);
                rsCaixa2.updateRow();
            }
            rsCaixa2.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void SetaLabelBtn() {
        if (TFSituacao.getText().equalsIgnoreCase("Fechado")) {
            BTAbrirFechar.setText("Abrir");
        }
        if (TFSituacao.getText().equalsIgnoreCase("Aberto")) {
            BTAbrirFechar.setText("Fechar");
        }
        if (TFSituacao.getText().isEmpty()) {
            BTAbrirFechar.setText("...");
        }
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
            rsCaixa2.close();
        } catch (SQLException ex) {
            Logger.getLogger(IFCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return achou;
    }
}
