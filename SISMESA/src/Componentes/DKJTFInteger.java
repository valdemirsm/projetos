/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Demir
 */
public class DKJTFInteger extends JTextField {

    public DKJTFInteger() {
        super.setDocument(new JFilter());
        super.setHorizontalAlignment(RIGHT);
    }
    @Override
    protected void processFocusEvent(FocusEvent e) {
        selectAll();
        super.processFocusEvent(e);
    }

    private class JFilter extends PlainDocument {

        private String filter = "1234567890";

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

            int strsize = str.length();
            for (int count = strsize; count > 0; count--) {
                String str2 = str.substring(count - 1, count);
              //  if (str.length() > 0) {

                    if (filter.indexOf(str2) != -1) {
                    //    setBackground(Color.white);
                        super.insertString(offs, str2, a);
                    } //else // {
    //                    setBackground(new java.awt.Color(204, 204, 255));
    //                }
              //  }
            }
        }
    }
}
