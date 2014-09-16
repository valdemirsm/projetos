/*
 * To change this

@Override
public boolean verify(JComponent input) {
throw new UnsupportedOperationException("Not supported yet.");
}
}emplate, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DLRecebimentoComanda.java
 *
 * Created on 03/11/2010, 21:19:05
 */
package Views;

import classess.MovimentoCaixa;
import classess.MovimentoEstoque;
import classess.PrintRel;
import classess.Utilitario;
import Classes.bematech.BemaECF;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Demir
 */
public class DLRecebimentoComanda extends javax.swing.JDialog {

    String comanda;
    IFComanda frameComada;

    /** Creates new form DLRecebimentoComanda */
    public DLRecebimentoComanda(java.awt.Frame parent, boolean modal, final String comanda, IFComanda frameComada) {
        super(parent, modal);
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
//        SwingUtilities.updateComponentTreeUI(this);
//        this.pack();
        this.getContentPane().setBackground(Color.lightGray);
        this.comanda = comanda;
        this.frameComada = frameComada;
        MarcaTodosCheckBox();
        PreencheJtableRecebimento();
        BuscaValorCredito();

        DefaultTableCellRenderer CellRight = Utilitario.cellRender(0);
        TBRecebimento.getColumn("Qtde").setCellRenderer(CellRight);
        TBRecebimento.getColumn("Vlr Unitario").setCellRenderer(CellRight);
        TBRecebimento.getColumn("Vlr Total").setCellRenderer(CellRight);
        TBRecebimento.getColumn("Qtde Pago").setCellRenderer(CellRight);
        TBRecebimento.getColumn("Vlr Pago").setCellRenderer(CellRight);
        TBRecebimento.getColumn("Vlr á Pagar").setCellRenderer(CellRight);
        DefaultTableCellRenderer CellRight2 = Utilitario.cellRender(1);
        TBRecebimento.getColumn("Qtde á Pagar").setCellRenderer(CellRight2);

        TFValorCredito.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                JTextField texto = (JTextField) input;
                TFValorCredito.setText(Utilitario.getFomatDecimal(Float.parseFloat(texto.getText().isEmpty() ? "0" : texto.getText().replace(",", "."))));
                float saldoCredito = Float.parseFloat(TFSaldoCredito.getText().isEmpty() ? "0" : TFSaldoCredito.getText().replace(",", "."));
                float valorCredito = Float.parseFloat(texto.getText().isEmpty() ? "0" : texto.getText().replace(",", "."));

                if (valorCredito > saldoCredito) {
                    JOptionPane.showMessageDialog(null, "Valor de crédito maior que saldo de crédito", "Alerta", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    return true;
                }

            }
        });

        TFVlrDesconto.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                JTextField texto = (JTextField) input;
                float vlrsubTotal = Float.parseFloat(TFSubtotal.getText().isEmpty() ? "0" : TFSubtotal.getText().replace(",", "."));
                float vlrDesconto = Float.parseFloat(texto.getText().isEmpty() ? "0" : texto.getText().replace(",", "."));

                if (vlrDesconto >= vlrsubTotal) {
                    JOptionPane.showMessageDialog(null, "Valor de desconto não pode ser maior ou igual que o sub total!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    return true;
                }

            }
        });

        TFVlrAcrecimo.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                JTextField texto = (JTextField) input;
                float vlrsubTotal = Float.parseFloat(TFSubtotal.getText().isEmpty() ? "0" : TFSubtotal.getText().replace(",", "."));
                float vlrAcrescimo = Float.parseFloat(texto.getText().isEmpty() ? "0" : texto.getText().replace(",", "."));

                if (vlrAcrescimo >= vlrsubTotal) {
                    JOptionPane.showMessageDialog(null, "Valor de acréscimo não pode ser maior ou igual que o sub total!", "Alerta", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    return true;
                }

            }
        });

        final JTableHeader heder = TBRecebimento.getTableHeader();
        heder.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String nomeColuna = (String) TBRecebimento.getColumnModel().getColumn(heder.columnAtPoint(e.getPoint())).getIdentifier();

                if (nomeColuna.equals("Pagar")) {
                    int qtdeLinha = TBRecebimento.getRowCount();
                    ResultSet rsProdComanda = FMaster.con.executeSQL("select count(*)as cont from atncompro where id_comanda = '" + comanda + "' and selecao = 1");
                    try {
                        rsProdComanda.first();
                        if (rsProdComanda.isFirst()) {
                            if (qtdeLinha != rsProdComanda.getInt("cont")) {
                                MarcaTodosCheckBox();
                                PreencheJtableRecebimento();
                                BuscaValorCredito();
                            } else {
                                DesmarcaTodosCheckBox();
                                PreencheJtableRecebimento();
                                BuscaValorCredito();
                            }
                        }
                        rsProdComanda.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

//        TFVlrRecebido.setInputVerifier(new InputVerifier() {
//
//            @Override
//            public boolean verify(JComponent input) {
//                boolean status = false;
//                JTextField texto = (JTextField) input;
//                TFVlrRecebido.setText(Utilitario.getFomatDecimal(Float.parseFloat(texto.getText().isEmpty() ? "0" : texto.getText().replace(",", "."))));
//                float valorRecebido = Float.parseFloat(texto.getText().isEmpty() ? "0" : texto.getText().replace(",", "."));
//                float valorSaldoCredito = Float.parseFloat(TFSaldoCredito.getText().isEmpty() ? "0" : TFSaldoCredito.getText().replace(",", "."));
//
//                ResultSet rsComanda = FMaster.con.executeSQL("select * from atncomanda where id_comanda = '" + comanda + "'");
//                try {
//                    rsComanda.first();
//                    if (rsComanda.isFirst()) {
//                        float vlrAPagarComanda = rsComanda.getFloat("vlr_saldo_pagar");
//
//                        if ((valorRecebido + valorSaldoCredito) > vlrAPagarComanda) {
//                            JOptionPane.showMessageDialog(null, "Valor de crédito maior que saldo de crédito", "Alerta", JOptionPane.ERROR_MESSAGE);
//                            status = true;
//                        } else {
//                            status = false;
//                        }
//                    }
//                    return status;
//                } catch (SQLException ex) {
//                    Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//            }
//        });
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

        LBTroco = new javax.swing.JLabel();
        LBValorAcrescimo = new javax.swing.JLabel();
        TFVlrAcrecimo = new Componentes.DKJTFFloat();
        LBValorDesconto = new javax.swing.JLabel();
        LBFormaPagamento = new javax.swing.JLabel();
        TFVlrDesconto = new Componentes.DKJTFFloat();
        LBSubtotal = new javax.swing.JLabel();
        CBFormaPagamento = new javax.swing.JComboBox();
        BTConfirma = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBRecebimento = new javax.swing.JTable();
        TFSubtotal = new Componentes.DKJTFFloat();
        TFValorLancarCredito = new Componentes.DKJTFFloat();
        BTAlteraQtdeAPagar = new javax.swing.JButton();
        LBValorRecebido = new javax.swing.JLabel();
        TFVlrRecebido = new Componentes.DKJTFFloat();
        BTLancaCredito = new javax.swing.JButton();
        TFSaldoCredito = new Componentes.DKJTFFloat();
        LBSaldoCredito = new javax.swing.JLabel();
        TFValorCredito = new Componentes.DKJTFFloat();
        LBValorCredito = new javax.swing.JLabel();
        TFTroco = new javax.swing.JTextField();
        LBValorLancarCredito = new javax.swing.JLabel();
        TFTotal = new Componentes.DKJTFFloat();
        LBTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recebimento");
        setMinimumSize(new java.awt.Dimension(850, 483));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        LBTroco.setText("Troco");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(LBTroco, gridBagConstraints);

        LBValorAcrescimo.setText("Valor acréscimo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(LBValorAcrescimo, gridBagConstraints);

        TFVlrAcrecimo.setText("");
        TFVlrAcrecimo.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        TFVlrAcrecimo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFVlrAcrecimoFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 4, 0);
        getContentPane().add(TFVlrAcrecimo, gridBagConstraints);

        LBValorDesconto.setText("Valor desconto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(LBValorDesconto, gridBagConstraints);

        LBFormaPagamento.setText("Forma de pagamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(LBFormaPagamento, gridBagConstraints);

        TFVlrDesconto.setText("");
        TFVlrDesconto.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        TFVlrDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFVlrDescontoFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 4, 0);
        getContentPane().add(TFVlrDesconto, gridBagConstraints);

        LBSubtotal.setText("Valor Subtotal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(LBSubtotal, gridBagConstraints);

        CBFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CBFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cartão de Débito", "Cartão de Crédito", "Cheque" }));
        CBFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBFormaPagamentoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(CBFormaPagamento, gridBagConstraints);

        BTConfirma.setText("Confirmar");
        BTConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTConfirmaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 4);
        getContentPane().add(BTConfirma, gridBagConstraints);

        TBRecebimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_comanda", "id_compro", "id_comclie", "Pagar", "Nome Cliente", "Produto", "Qtde", "Vlr Unitario", "Vlr Total", "Qtde Pago", "Vlr Pago", "Qtde á Pagar", "Vlr á Pagar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBRecebimento.setSelectionBackground(new java.awt.Color(204, 255, 255));
        TBRecebimento.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TBRecebimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TBRecebimentoMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TBRecebimento);
        TBRecebimento.getColumnModel().getColumn(0).setMinWidth(0);
        TBRecebimento.getColumnModel().getColumn(0).setPreferredWidth(0);
        TBRecebimento.getColumnModel().getColumn(0).setMaxWidth(0);
        TBRecebimento.getColumnModel().getColumn(1).setMinWidth(0);
        TBRecebimento.getColumnModel().getColumn(1).setPreferredWidth(0);
        TBRecebimento.getColumnModel().getColumn(1).setMaxWidth(0);
        TBRecebimento.getColumnModel().getColumn(2).setMinWidth(0);
        TBRecebimento.getColumnModel().getColumn(2).setPreferredWidth(0);
        TBRecebimento.getColumnModel().getColumn(2).setMaxWidth(0);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 800;
        gridBagConstraints.ipady = 230;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        TFSubtotal.setEditable(false);
        TFSubtotal.setText("");
        TFSubtotal.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(TFSubtotal, gridBagConstraints);

        TFValorLancarCredito.setText("");
        TFValorLancarCredito.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(TFValorLancarCredito, gridBagConstraints);

        BTAlteraQtdeAPagar.setText("Alterar qtde á pagar");
        BTAlteraQtdeAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTAlteraQtdeAPagarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        getContentPane().add(BTAlteraQtdeAPagar, gridBagConstraints);

        LBValorRecebido.setText("Valor Recebido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(LBValorRecebido, gridBagConstraints);

        TFVlrRecebido.setText("");
        TFVlrRecebido.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        TFVlrRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFVlrRecebidoFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 0);
        getContentPane().add(TFVlrRecebido, gridBagConstraints);

        BTLancaCredito.setText("Lançar crédito");
        BTLancaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTLancaCreditoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        getContentPane().add(BTLancaCredito, gridBagConstraints);

        TFSaldoCredito.setEditable(false);
        TFSaldoCredito.setText("");
        TFSaldoCredito.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(TFSaldoCredito, gridBagConstraints);

        LBSaldoCredito.setText("Valor Saldo Crédito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(LBSaldoCredito, gridBagConstraints);

        TFValorCredito.setText("");
        TFValorCredito.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TFValorCredito.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFValorCreditoFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 0);
        getContentPane().add(TFValorCredito, gridBagConstraints);

        LBValorCredito.setText("Valor Crédito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(LBValorCredito, gridBagConstraints);

        TFTroco.setEditable(false);
        TFTroco.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        TFTroco.setForeground(new java.awt.Color(204, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 4, 0);
        getContentPane().add(TFTroco, gridBagConstraints);

        LBValorLancarCredito.setText("Valor Larçar Crédito");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(LBValorLancarCredito, gridBagConstraints);

        TFTotal.setEditable(false);
        TFTotal.setText("");
        TFTotal.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(TFTotal, gridBagConstraints);

        LBTotal.setText("Valor Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 0);
        getContentPane().add(LBTotal, gridBagConstraints);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-854)/2, (screenSize.height-469)/2, 854, 469);
    }// </editor-fold>//GEN-END:initComponents

    private void TBRecebimentoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBRecebimentoMouseReleased
        SelecionaUnicoProdutoCheckBox();
    }//GEN-LAST:event_TBRecebimentoMouseReleased

    private void TFVlrRecebidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFVlrRecebidoFocusLost
        CalculaValorTroco();
    }//GEN-LAST:event_TFVlrRecebidoFocusLost

    private void TFVlrDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFVlrDescontoFocusLost
        CalculaValorTroco();
    }//GEN-LAST:event_TFVlrDescontoFocusLost

    private void TFVlrAcrecimoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFVlrAcrecimoFocusLost
        CalculaValorTroco();
    }//GEN-LAST:event_TFVlrAcrecimoFocusLost

    private void BTConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTConfirmaActionPerformed
        Recebimento();
    }//GEN-LAST:event_BTConfirmaActionPerformed

    private void BTAlteraQtdeAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTAlteraQtdeAPagarActionPerformed
        DLAlterQtde alterQtde = new DLAlterQtde(null, rootPaneCheckingEnabled, comanda, this);
        alterQtde.setVisible(true);
    }//GEN-LAST:event_BTAlteraQtdeAPagarActionPerformed

    private void CBFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBFormaPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBFormaPagamentoActionPerformed

    private void TFValorCreditoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFValorCreditoFocusLost
//        float vlr_saldo_credito = Float.parseFloat(TFSaldoCredito.getText().isEmpty() ? "0" : TFSaldoCredito.getText().replace(",", "."));
//        float vlr_credito = Float.parseFloat(TFValorCredito.getText().isEmpty() ? "0" : TFValorCredito.getText().replace(",", "."));
//        if (vlr_credito > vlr_saldo_credito) {
//            JOptionPane.showMessageDialog(null, "Valor de crédito maior que saldo de crédito", "Alerta", JOptionPane.ERROR_MESSAGE);
//            TFValorCredito.requestFocus();
//            return;
//        }
        CalculaValorTroco();
    }//GEN-LAST:event_TFValorCreditoFocusLost

    private void BTLancaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTLancaCreditoActionPerformed
        LancaCredito();
}//GEN-LAST:event_BTLancaCreditoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTAlteraQtdeAPagar;
    private javax.swing.JButton BTConfirma;
    private javax.swing.JButton BTLancaCredito;
    private javax.swing.JComboBox CBFormaPagamento;
    private javax.swing.JLabel LBFormaPagamento;
    private javax.swing.JLabel LBSaldoCredito;
    private javax.swing.JLabel LBSubtotal;
    private javax.swing.JLabel LBTotal;
    private javax.swing.JLabel LBTroco;
    private javax.swing.JLabel LBValorAcrescimo;
    private javax.swing.JLabel LBValorCredito;
    private javax.swing.JLabel LBValorDesconto;
    private javax.swing.JLabel LBValorLancarCredito;
    private javax.swing.JLabel LBValorRecebido;
    private javax.swing.JTable TBRecebimento;
    private Componentes.DKJTFFloat TFSaldoCredito;
    private Componentes.DKJTFFloat TFSubtotal;
    private Componentes.DKJTFFloat TFTotal;
    private javax.swing.JTextField TFTroco;
    private Componentes.DKJTFFloat TFValorCredito;
    private Componentes.DKJTFFloat TFValorLancarCredito;
    private Componentes.DKJTFFloat TFVlrAcrecimo;
    private Componentes.DKJTFFloat TFVlrDesconto;
    private Componentes.DKJTFFloat TFVlrRecebido;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public void PreencheJtableRecebimento() {
        ResultSet rsRecebimento = FMaster.con.executeSQL("select * from atncompro "
                + "inner join atncomcli on atncompro.id_com_clie = atncomcli.id_com_clie and atncompro.id_comanda = atncomcli.id_comanda "
                + "inner join estproduto on atncompro.id_produto = estproduto.id_produto "
                + "where atncompro.id_comanda = '" + comanda + "' and atncompro.vlr_total <> atncompro.vlr_pago order by atncomcli.nome, estproduto.descricao");
        try {
            DefaultTableModel modelo = (DefaultTableModel) TBRecebimento.getModel();
            modelo.setNumRows(0);
            while (rsRecebimento.next()) {
                boolean selecao;
                if (rsRecebimento.getInt("selecao") == 1) {
                    selecao = true;
                } else {
                    selecao = false;
                }
                modelo.addRow(new Object[]{rsRecebimento.getString("id_comanda"),
                            rsRecebimento.getString("id_com_pro"),
                            rsRecebimento.getString("id_com_clie"),
                            selecao,
                            rsRecebimento.getString("nome"),
                            rsRecebimento.getString("descricao"),
                            rsRecebimento.getString("qtde"),
                            Utilitario.getFomatDecimal(rsRecebimento.getFloat("vlr_unitario")),
                            Utilitario.getFomatDecimal(rsRecebimento.getFloat("vlr_total")),
                            rsRecebimento.getString("qtde_pago"),
                            Utilitario.getFomatDecimal(rsRecebimento.getFloat("vlr_pago")),
                            rsRecebimento.getInt("qtde_a_pagar"),
                            Utilitario.getFomatDecimal(rsRecebimento.getFloat("vlr_a_pagar"))});
            }
            rsRecebimento.close();
            SomaValorPagamento();
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    private void SomaValorPagamento() {
        ResultSet rsVlrPagamento = FMaster.con.executeSQL("select sum(vlr_a_pagar)as vlr_a_pagar from atncompro where id_comanda = '" + comanda + "' and selecao = 1");
        try {
            rsVlrPagamento.first();
            if (rsVlrPagamento.isFirst()) {
                TFSubtotal.setText(Utilitario.getFomatDecimal(rsVlrPagamento.getFloat("vlr_a_pagar")));
            }
            rsVlrPagamento.close();
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        CalculaValorTroco();
        TFSubtotal.validate();
    }

    private void MarcaTodosCheckBox() {
        FMaster.con.executeUpdate("update atncompro set selecao = 1 where id_comanda = '" + comanda + "' and vlr_total <> vlr_pago");
        FMaster.con.executeUpdate("update atncompro set selecao = 0 where id_comanda = '" + comanda + "' and vlr_total = vlr_pago");
    }

    private void DesmarcaTodosCheckBox() {
        FMaster.con.executeUpdate("update atncompro set selecao = 0 where id_comanda = '" + comanda + "'");
    }

    private void SelecionaUnicoProdutoCheckBox() {
        int selecao;

        //
        String idComPro = Utilitario.getValueColumn("id_compro", TBRecebimento);
        String cliente = Utilitario.getValueColumn("id_comclie", TBRecebimento);
        String comanda = Utilitario.getValueColumn("id_comanda", TBRecebimento);
        //

        //
        boolean selecionado = Boolean.valueOf(Utilitario.getValueColumn("Pagar", TBRecebimento));
        //

        //
        if (selecionado == true) {
            selecao = 1;
        } else {
            selecao = 0;
        }
        //

        //
        FMaster.con.executeUpdate("Update atncompro set selecao = " + selecao + " where id_com_clie = '" + cliente + "' and id_comanda = '" + comanda + "' and id_com_pro = '" + idComPro + "'");
        //

        //
        ResultSet rsSelecao = FMaster.con.executeSQL("select * from atncompro where id_com_clie = '" + cliente + "' and id_comanda = '" + comanda + "' and id_com_pro = '" + idComPro + "'");
        try {
            rsSelecao.first();
            if (rsSelecao.isFirst()) {
                TBRecebimento.setValueAt(rsSelecao.getBoolean("selecao"), TBRecebimento.getSelectedRow(), Utilitario.getIndiceColumn("Pagar", TBRecebimento));
            }
        } catch (Exception e) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                rsSelecao.close();
            } catch (SQLException ex) {
                Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        SomaValorPagamento();
    }

    private void CalculaValorTroco() {
        ResultSet rsComanda = FMaster.con.executeSQL("select * from atncomanda where id_comanda = '" + comanda + "'");
        try {
            rsComanda.first();
            if (rsComanda.isFirst()) {
                float vlr_desconto = Float.parseFloat(TFVlrDesconto.getText().isEmpty() ? "0" : TFVlrDesconto.getText().replace(",", "."));
                float vlr_acrescimo = Float.parseFloat(TFVlrAcrecimo.getText().isEmpty() ? "0" : TFVlrAcrecimo.getText().replace(",", "."));
                if (rsComanda.getFloat("vlr_desconto") == 0 && rsComanda.getFloat("vlr_desconto") == 0) {

                    if (vlr_desconto != 0) {
                        TFVlrAcrecimo.setText(Utilitario.getFomatDecimal(Float.parseFloat("0.00")));
                        TFVlrAcrecimo.setEnabled(false);
                        TFVlrDesconto.setEnabled(true);
                    } else {
                        TFVlrAcrecimo.setEnabled(true);
                    }
                    if (vlr_acrescimo != 0) {
                        TFVlrDesconto.setText(Utilitario.getFomatDecimal(Float.parseFloat("0.00")));
                        TFVlrDesconto.setEnabled(false);
                        TFVlrAcrecimo.setEnabled(true);
                    } else {
                        TFVlrDesconto.setEnabled(true);
                    }
                } else {
                    TFVlrDesconto.setText(Utilitario.getFomatDecimal(Float.parseFloat("0.00")));
                    TFVlrAcrecimo.setText(Utilitario.getFomatDecimal(Float.parseFloat("0.00")));
                    TFVlrDesconto.setEnabled(false);
                    TFVlrAcrecimo.setEnabled(false);
                }
                float vlr_troco = Float.parseFloat(TFTroco.getText().isEmpty() ? "0" : TFTroco.getText().replace(",", "."));
                float vlr_pagamento = Float.parseFloat(TFSubtotal.getText().isEmpty() ? "0" : TFSubtotal.getText().replace(",", "."));
                float vlr_credito = Float.parseFloat(TFValorCredito.getText().isEmpty() ? "0" : TFValorCredito.getText().replace(",", "."));
                float vlr_recebido = Float.parseFloat(TFVlrRecebido.getText().isEmpty() ? "0" : TFVlrRecebido.getText().replace(",", "."));

                float troco = (vlr_recebido - (((vlr_pagamento - vlr_credito) + vlr_acrescimo) - vlr_desconto));
                TFTroco.setText(Utilitario.getFomatDecimal(troco));
                TFTotal.setText(Utilitario.getFomatDecimal((vlr_pagamento + vlr_acrescimo) - vlr_desconto));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Recebimento() {
        Object[] options = {"Sim", "Não"};
        float valorPagamento = Float.parseFloat(TFSubtotal.getText().isEmpty() ? "0" : TFSubtotal.getText().replace(",", "."));
        float valorTroco = Float.parseFloat(TFTroco.getText().isEmpty() ? "0" : TFTroco.getText().replace(",", "."));
        float valorRecebido = Float.parseFloat(TFVlrRecebido.getText().isEmpty() ? "0" : TFVlrRecebido.getText().replace(",", "."));
        float valorCredito = Float.parseFloat(TFValorCredito.getText().isEmpty() ? "0" : TFValorCredito.getText().replace(",", "."));
        float valorSaldoCredito = Float.parseFloat(TFSaldoCredito.getText().isEmpty() ? "0" : TFSaldoCredito.getText().replace(",", "."));
        float valorDesconto = Float.parseFloat(TFVlrDesconto.getText().isEmpty() ? "0" : TFVlrDesconto.getText().replace(",", "."));
        float valorAcrescimo = Float.parseFloat(TFVlrAcrecimo.getText().isEmpty() ? "0" : TFVlrAcrecimo.getText().replace(",", "."));
        float valorLiquido = Float.parseFloat(TFTotal.getText().isEmpty() ? "0" : TFTotal.getText().replace(",", "."));
        /*Verifica se foi informado o valor de pagamento*/
        if (valorPagamento == 0) {
            JOptionPane.showMessageDialog(null, "Não há valor a ser recebido!", "Alerta", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /*Verifica se existe troco*/
        if (valorTroco < 0) {
            JOptionPane.showMessageDialog(null, "Valores inválidos", "Alerta", JOptionPane.ERROR_MESSAGE);
            return;
        }

        /*Verifica se existe caixa aberto, se returnar 0 é porque não existe caixa aberto*/
        int existe = Utilitario.VerExisteCaixaAberto();
        if (existe == 0) {
            return;
        }

        /*Verifica se o saldo a pagar é menor ou igual ao credito, caso seja obriga usar o crédito*/
        ResultSet rsCompro = FMaster.con.executeSQL("select * from atncomanda where id_comanda = '" + comanda + "'");
        try {
            rsCompro.first();
            if (rsCompro.isFirst()) {
                //if ((((rsCompro.getFloat("vlr_saldo_pagar") - valorPagamento) - (valorSaldoCredito - valorCredito)) <= (valorSaldoCredito - valorCredito)) && (valorSaldoCredito != 0)) {
                if ((rsCompro.getFloat("vlr_saldo_pagar") - valorPagamento) < (valorSaldoCredito - valorCredito)) {

                    JOptionPane.showMessageDialog(null, "Favor usar o crédito lançado para essa comanda", "Alerta", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            rsCompro.close();
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }


        String valorPgto = TFSubtotal.getText().isEmpty() ? "0,00" : TFSubtotal.getText();
        String valorAcresc = TFVlrAcrecimo.getText().isEmpty() ? "0,00" : TFVlrAcrecimo.getText();
        String valorDesc = TFVlrDesconto.getText().isEmpty() ? "0,00" : TFVlrDesconto.getText();
        String valorReceb = TFVlrRecebido.getText().isEmpty() ? "0,00" : TFVlrRecebido.getText();
        String valorCred = TFValorCredito.getText().isEmpty() ? "0,00" : TFValorCredito.getText();
        String troc = TFTroco.getText().isEmpty() ? "0,00" : TFTroco.getText();
        String htmlmsg = "<html>"
                + "<body>"
                + "	<table border = 0>"
                + "     <Caption Align=Bottom> <Font Size=10></Font> </Caption>"
                + "         <tr>"
                + "             <th colspan=2 color = red>"
                + "                 <Font size=6>"
                + "                     Confirma os seguintes valores de recebimento abaixo?"
                + "                 </Font>"
                + "             </th>"
                + "         </tr>"
                + "         <tr>"
                + "             <td>"
                + "                 <Font size=6>"
                + "                     Valor a ser pago é:---------------------------------"
                + "                 </Font>"
                + "             </td>"
                + "             <td align=right color = blue>"
                + "                 <Font size=6>"
                + "                     " + valorPgto + "	"
                + "                 </Font>"
                + "             </td>"
                + "         </tr>"
                + "         <tr>"
                + "             <td>"
                + "                 <Font size=6>"
                + "                     Valor de acréscimo é:------------------------------"
                + "                 </Font>"
                + "             </td>"
                + "             <td align=right color = blue>"
                + "                 <Font size=6>"
                + "                     " + valorAcresc + ""
                + "                 </Font>"
                + "             </td>"
                + "         </tr>"
                + "         <tr>"
                + "             <td>"
                + "                 <Font size=6>"
                + "                     Valor de desconto é:-------------------------------"
                + "                 </Font>"
                + "     	</td>"
                + "		<td align=right color = blue>"
                + "                 <Font size=6>"
                + "			" + valorDesc + ""
                + "                 </Font>"
                + "             </td>"
                + "         </tr>"
                + "         <tr>"
                + "             <td>"
                + "                 <Font size=6>"
                + "                     Valor usado do crédito é:--------------------------"
                + "                 </Font>"
                + "             </td>"
                + "             <td align=right color = blue>"
                + "                 <Font size=6>"
                + "                     " + valorCred + ""
                + "                 </Font>"
                + "             </td>"
                + "         </tr>"
                + "         <tr>"
                + "             <td>"
                + "                 <Font size=6>"
                + "                     Valor recebido é:-----------------------------------"
                + "                 </Font>"
                + "             </td>"
                + "             <td align=right color = blue>"
                + "                 <Font size=6>"
                + "                     " + valorReceb + ""
                + "                 </Font>"
                + "             </td>"
                + "         </tr>"
                + "         <tr>"
                + "             <td>"
                + "                 <Font size=6>"
                + "                     Valor de troco é:-----------------------------------"
                + "                 </Font>"
                + "             </td>"
                + "             <td align=right color = blue>"
                + "                 <Font size=6>"
                + "                     " + troc + ""
                + "                 </Font>"
                + "             </td>"
                + "         </tr>"
                + "     </table>"
                + "</body>"
                + "</html>";

        int iresp = JOptionPane.showOptionDialog(null, htmlmsg, "", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title

        if (iresp != 0) {
            return;
        }



        /*atualiza valor temporario para aperecer no cupom*/
//        FMaster.con.executeUpdate("update atncomanda set tmp_vlr_recebido = '" + valorRecebido + "'"
//                + ", tmp_vlr_desconto = '" + valorDesconto + "', tmp_vlr_acrescimo = '" + valorAcrescimo + "', tmp_vlr_troco = '" + valorTroco + "', tmp_vlr_liquido = '" + valorLiquido + "' where atncomanda.id_comanda = '" + comanda + "'");


        /*atualiza valor pago e qtde pago na tabela atncompro */
        FMaster.con.executeUpdate("update atncompro set vlr_pago = (vlr_pago + vlr_a_pagar), qtde_pago = (qtde_pago + qtde_a_pagar) where atncompro.selecao = 1 and atncompro.id_comanda = '" + comanda + "'");


        /*atualiza valor pago na tabela atncomcli */
        FMaster.con.executeUpdate("update atncomcli set vlr_pago = "
                + "(select coalesce(sum(vlr_pago),0) from atncompro where atncompro.id_com_clie = atncomcli.id_com_clie and atncompro.id_comanda = atncomcli.id_comanda) where atncomcli.id_comanda = '" + comanda + "'");


        /*atualiza o saldo na tabela atncomcli */
        FMaster.con.executeUpdate("update atncomcli set vlr_saldo = (atncomcli.vlr_total - atncomcli.vlr_pago) where atncomcli.id_comanda = '" + comanda + "'");

        /*atualiza valor pago na tabela atncomanda */
        FMaster.con.executeUpdate("update atncomanda set vlr_pago = (select coalesce(sum(vlr_pago),0) from atncomcli where atncomcli.id_comanda = atncomanda.id_comanda) where atncomanda.id_comanda = '" + comanda + "'");

        /*atualiza saldo na tabela atncomanda */
        FMaster.con.executeUpdate("update atncomanda set vlr_saldo_pagar = (vlr_total - vlr_pago) where atncomanda.id_comanda = '" + comanda + "'");



        ResultSet rsComanda = FMaster.con.executeSQL("select * from atncomanda where id_comanda = '" + comanda + "'");
        try {
            rsComanda.first();
            if (rsComanda.isFirst()) {
                /*caso o recebimento for do total da comanda altera o status da comanda para fechado */
                if (rsComanda.getFloat("vlr_total") == rsComanda.getFloat("vlr_pago")) {
                    rsComanda.updateInt("situacao", 2);
                    rsComanda.updateRow();

                    /*atualiza estoque*/
                    ResultSet rsAtualizaEstoque = FMaster.con.executeSQL("select * from atncompro where id_comanda = '" + comanda + "'");
                    while (rsAtualizaEstoque.next()) {
                        ResultSet rsProdutoItem = FMaster.con.executeSQL("select * from estitemproduto where id_produto = '" + rsAtualizaEstoque.getInt("id_produto") + "'");
                        while (rsProdutoItem.next()) {
                            for (int i = 1; i <= rsAtualizaEstoque.getInt("qtde_pago"); i++) {
                                MovimentoEstoque.AtualizaSaldoProduto(2, rsProdutoItem.getInt("id_itemproduto"), rsProdutoItem.getFloat("qtde"));
                            }
                        }
                        rsProdutoItem.close();
                    }
                    rsAtualizaEstoque.close();

                    frameComada.LimparCamposHerder();
                }
                rsComanda.updateFloat("vlr_recebido", rsComanda.getFloat("vlr_recebido") + (Float.parseFloat(TFVlrRecebido.getText().isEmpty() ? "0" : TFVlrRecebido.getText().replace(",", ".")) + Float.parseFloat(TFValorCredito.getText().isEmpty() ? "0" : TFValorCredito.getText().replace(",", "."))));
                rsComanda.updateFloat("vlr_troco", rsComanda.getFloat("vlr_troco") + Float.parseFloat(TFTroco.getText().isEmpty() ? "0" : TFTroco.getText().replace(",", ".")));
                rsComanda.updateFloat("vlr_desconto", rsComanda.getFloat("vlr_desconto") + Float.parseFloat(TFVlrDesconto.getText().isEmpty() ? "0" : TFVlrDesconto.getText().replace(",", ".")));
                rsComanda.updateFloat("vlr_acrescimo", rsComanda.getFloat("vlr_acrescimo") + Float.parseFloat(TFVlrAcrecimo.getText().isEmpty() ? "0" : TFVlrAcrecimo.getText().replace(",", ".")));
                rsComanda.updateFloat("vlr_credito", rsComanda.getFloat("vlr_credito") - Float.parseFloat(TFValorCredito.getText().isEmpty() ? "0" : TFValorCredito.getText().replace(",", ".")));
                rsComanda.updateRow();

                /*Lança o valor recebido no movimento de caixa*/
                MovimentoCaixa.LancaMovimento(Float.parseFloat(TFVlrRecebido.getText().isEmpty() ? "0" : TFVlrRecebido.getText().replace(",", ".")),
                        Integer.parseInt(comanda), 0,
                        CBFormaPagamento.getSelectedIndex() + 1,
                        1,
                        Utilitario.getDateAndTimeAtual(),
                        2);

                /*Lança o valor de troco no movimento de caixa*/
                MovimentoCaixa.LancaMovimento(Float.parseFloat(TFTroco.getText().isEmpty() ? "0" : TFTroco.getText().replace(",", ".")),
                        Integer.parseInt(comanda), 0,
                        1,
                        2,
                        Utilitario.getDateAndTimeAtual(),
                        1);



                frameComada.PreencheHerder();
                frameComada.PreencherJtableCliente(comanda, rsComanda.getString("id_mesa"));

                if (rsComanda.getFloat("vlr_total") == rsComanda.getFloat("vlr_pago")) {


                    int imprimirCF = 0;
                    ResultSet rsConfiguracao = FMaster.con.executeSQL("select * from atnconfigecf");
                    rsConfiguracao.first();
                    if (rsConfiguracao.isFirst()) {
                        imprimirCF = rsConfiguracao.getInt("imprimir_cf");
                    }
                    rsConfiguracao.close();

                    if (imprimirCF == 1) {
                        int iresp2 = JOptionPane.showOptionDialog(null, "Deseja imprimir o Cupom Fiscal?", "", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null, //do not use a custom Icon
                                options, //the titles of buttons
                                options[0]); //default button title

                        if (iresp2 == 0) {
                            ImprimirCupomFiscal();
                        }
                    }
                    int iresp3 = JOptionPane.showOptionDialog(null, "Deseja imprimir o Cupom Não Fiscal?", "", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null, //do not use a custom Icon
                            options, //the titles of buttons
                            options[0]); //default button title
                    if (iresp3 == 0) {
                        PrintRel.imprime("CupomNaoFiscalComanda.jasper", Integer.parseInt(comanda));
                    }
                }
            }
            rsComanda.close();
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }

    private void LancaCredito() {
        ResultSet rsComanda = FMaster.con.executeSQL("select * from atncomanda where id_comanda = '" + comanda + "'");
        try {
            rsComanda.first();
            if (rsComanda.isFirst()) {
                /*Verifica se existe caixa aberto, se returnar 0 é porque não existe caixa aberto*/
                int existe = Utilitario.VerExisteCaixaAberto();
                if (existe == 0) {
                    return;
                }


                rsComanda.updateFloat("vlr_credito", rsComanda.getFloat("vlr_credito") + Float.parseFloat(TFValorLancarCredito.getText().isEmpty() ? "0" : TFValorLancarCredito.getText().replace(",", ".")));
                rsComanda.updateRow();
                /*Lança movimento de credito no caixa*/
                MovimentoCaixa.LancaMovimento(Float.parseFloat(TFValorLancarCredito.getText().isEmpty() ? "0" : TFValorLancarCredito.getText().replace(",", ".")),
                        rsComanda.getInt("id_comanda"), 0, 1, 1, Utilitario.getDateAndTimeAtual(), 5);

                TFValorLancarCredito.setText("");
                BuscaValorCredito();
                CalculaValorTroco();
            }
            rsComanda.close();
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void BuscaValorCredito() {
        ResultSet rsComanda = FMaster.con.executeSQL("select * from atncomanda where id_comanda = '" + comanda + "'");
        try {
            rsComanda.first();
            if (rsComanda.isFirst()) {
                float vlr_credito = rsComanda.getFloat("vlr_credito");
                TFSaldoCredito.setText(Utilitario.getFomatDecimal(vlr_credito));
            }
            rsComanda.close();
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ImprimirCupomFiscal() {
        String formaPagamento = "";
        if (CBFormaPagamento.getSelectedIndex() == 0) {
            formaPagamento = "Dinheiro";
        }
        if (CBFormaPagamento.getSelectedIndex() == 1) {
            formaPagamento = "Cartão";
        }
        if (CBFormaPagamento.getSelectedIndex() == 2) {
            formaPagamento = "Cartão";
        }
        if (CBFormaPagamento.getSelectedIndex() == 3) {
            formaPagamento = "Cheque";
        }

        String Aliquota = "";
        ResultSet rsAliquota = FMaster.con.executeSQL("select * from atnconfigecf");
        try {
            rsAliquota.first();
            if (rsAliquota.isFirst()) {
                Aliquota = rsAliquota.getString("vlr_aliquota");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }


        ResultSet rsComanda = FMaster.con.executeSQL(" SELECT * "
                + " FROM atncomanda where id_comanda = '" + comanda + "'");
        try {
            rsComanda.first();
            if (rsComanda.isFirst()) {
                String TipoAcrescimoDesconto = "$";
                String sAcrescimoDesconto = "D";
                String ValorAcrescimoDesconto = "0";
                float fAcrescimoDesconto = rsComanda.getFloat("vlr_desconto");
                if (fAcrescimoDesconto != 0) {
                    sAcrescimoDesconto = "D";
                    ValorAcrescimoDesconto = Utilitario.getFomatDecimal(fAcrescimoDesconto);
                }
                fAcrescimoDesconto = rsComanda.getFloat("vlr_acrescimo");
                if (fAcrescimoDesconto != 0) {
                    sAcrescimoDesconto = "A";
                    ValorAcrescimoDesconto = Utilitario.getFomatDecimal(fAcrescimoDesconto);
                }
                //if (!TFVlrDesconto.getText().isEmpty() || TFVlrDesconto.getText().equals("0,00"))
                ResultSet rsComPro = FMaster.con.executeSQL("SELECT * from atncompro inner join estproduto on atncompro.id_produto = estproduto.id_produto where atncompro.id_comanda = '" + comanda + "' and atncompro.vlr_total = atncompro.vlr_pago");
                rsComPro.first();
                if (rsComPro.isFirst()) {
                    BemaECF.abreCupom();
                    do {
                        if (BemaECF.iRet == 0) {
                            BemaECF.vendeItem(rsComPro.getString("id_produto"), rsComPro.getString("descricao"), Aliquota, "I", rsComPro.getString("qtde_pago"), 2, Utilitario.getFomatDecimal(rsComPro.getFloat("vlr_unitario")), "$", "00000000");
                        }
                    } while (rsComPro.next());
                    if (BemaECF.iRet == 0) {
                        FMaster.con.executeUpdate("update atncomanda set gerado_cf = 1 where atncomanda.id_comanda = '" + comanda + "'");
                    }
                    BemaECF.fechaCupom(sAcrescimoDesconto, TipoAcrescimoDesconto, ValorAcrescimoDesconto, "Comanda de número: " + rsComanda.getInt("id_comanda"), formaPagamento, Utilitario.getFomatDecimal(rsComanda.getFloat("vlr_recebido")));
                    Utilitario.SalvaUltimoCFGeradoComanda(rsComanda.getInt("id_comanda"));
                }
                rsComPro.close();
            }
            rsComanda.close();
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
