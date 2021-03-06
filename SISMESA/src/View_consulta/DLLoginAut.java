/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DLLoginAut.java
 *
 * Created on 15/07/2010, 23:51:52
 */
package View_consulta;

import classess.GetsSets;
import classess.Utilitario;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Maicol
 */
public class DLLoginAut extends javax.swing.JDialog {

    /** Creates new form DLLoginAut */
    public DLLoginAut(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //redimenciona o lookandFeeld de acordo com o selecionado
        SwingUtilities.updateComponentTreeUI(this);
        this.pack();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BTCancelar = new javax.swing.JButton();
        BTOK = new javax.swing.JButton();
        PTFSenha = new javax.swing.JPasswordField();
        FTFUsuario = new javax.swing.JFormattedTextField();
        LB_LOGIN = new javax.swing.JLabel();
        LB_SENHA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(null);
        setMinimumSize(new java.awt.Dimension(279, 187));
        setModal(true);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        BTCancelar.setText("Cancelar");
        BTCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCancelarActionPerformed(evt);
            }
        });
        BTCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BTCancelarKeyReleased(evt);
            }
        });
        jPanel1.add(BTCancelar);
        BTCancelar.setBounds(170, 130, 90, 30);

        BTOK.setText("OK");
        BTOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTOKActionPerformed(evt);
            }
        });
        BTOK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BTOKKeyReleased(evt);
            }
        });
        jPanel1.add(BTOK);
        BTOK.setBounds(90, 130, 67, 30);

        PTFSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(PTFSenha);
        PTFSenha.setBounds(90, 100, 110, 20);

        FTFUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FTFUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FTFUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(FTFUsuario);
        FTFUsuario.setBounds(90, 50, 162, 20);

        LB_LOGIN.setForeground(new java.awt.Color(51, 51, 51));
        LB_LOGIN.setText("Usuário:");
        jPanel1.add(LB_LOGIN);
        LB_LOGIN.setBounds(90, 30, 60, 14);

        LB_SENHA.setForeground(new java.awt.Color(51, 51, 51));
        LB_SENHA.setText("Senha:");
        jPanel1.add(LB_SENHA);
        LB_SENHA.setBounds(90, 80, 70, 14);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/template_login.png"))); // NOI18N
        jLabel2.setText("Login:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 280, 200);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 280, 190);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-279)/2, (screenSize.height-193)/2, 279, 193);
    }// </editor-fold>//GEN-END:initComponents

    private void FTFUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FTFUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FTFUsuarioActionPerformed

    private void BTOKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTOKKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            valida();
        }
    }//GEN-LAST:event_BTOKKeyReleased

    private void BTCancelarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BTCancelarKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {
            GetsSets.setCodUser(0);
            GetsSets.setNomeUser("");
            dispose();
        }
    }//GEN-LAST:event_BTCancelarKeyReleased

    private void BTCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCancelarActionPerformed
        GetsSets.setCodUser(0);
        GetsSets.setNomeUser("");
        dispose();
    }//GEN-LAST:event_BTCancelarActionPerformed

    private void BTOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTOKActionPerformed
        valida();
    }//GEN-LAST:event_BTOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTCancelar;
    private javax.swing.JButton BTOK;
    private javax.swing.JFormattedTextField FTFUsuario;
    private javax.swing.JLabel LB_LOGIN;
    private javax.swing.JLabel LB_SENHA;
    private javax.swing.JPasswordField PTFSenha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void valida() {
        boolean ok = Utilitario.validaUsuario(FTFUsuario.getText().toString(), String.valueOf(PTFSenha.getPassword()));
        if (ok) {
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario ou Senha inválida!", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
