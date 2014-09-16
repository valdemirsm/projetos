/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Administrador
 */
public class DKJTFFloat3Casas extends JTextField {
    public DKJTFFloat3Casas() {
        super.setDocument(new JFilter());
        super.setHorizontalAlignment(RIGHT);
        super.setInputVerifier(new InpuVerifier());
        setText("0,000");
    }

    @Override
    protected void processFocusEvent(FocusEvent e) {
        selectAll();
        super.processFocusEvent(e);
    }

    private class InpuVerifier extends InputVerifier {

        @Override
        public boolean verify(JComponent input) {
            JTextField tf = (JTextField) input;
            Float texto = null;
            try {
                texto = Float.parseFloat(tf.getText().isEmpty() ? "0" : tf.getText().replaceAll(",", "."));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Formato inválido!", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
            
            DecimalFormat decimal = new DecimalFormat("0.000");
            String textoFormadado = decimal.format(texto);
            setText(textoFormadado);
            return true;
        }
    }

    private class JFilter extends PlainDocument {

        private String filter = "1234567890,";

        private int size = 10;
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {


           


            int strsize = str.length();
            for (int count = strsize; count > 0; count--) {
                String str2 = str.substring(count - 1, count);

                if ((filter.indexOf(str2) != -1)) {
                //    setBackground(Color.white);
                    super.insertString(offs, str2, a);
                }// else {
                //    setBackground(new java.awt.Color(204, 204, 255));
               // }
            }

        }

//        public int QtdeAspas(){
//            int size = getText().length();
//            int cont = 0;
//            for (int i = 0; i < size; i++) {
//                String aspas = getText().isEmpty()?"":getText();
//                if (aspas.substring(i, i+1).equals(",")) {
//                    cont ++;
//                }
//            }
//            return cont;
//        }
    }
}
