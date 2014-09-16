/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Valdemir
 */
public class DKJTFFone extends JTextField {

    public DKJTFFone() {
        super.setDocument(new JFilter());
    }
    private class JFilter extends PlainDocument{
        private String filter = "1234567890";
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            int sizetext = super.getLength();
            if (str.length() == 1) {
                if (sizetext == 2) {
                    super.insertString(offs, ")", a);
                }
                if (sizetext == 7) {
                    super.insertString(offs, "-", a);
                }
                if ((filter.indexOf(str) != -1) && sizetext <= 12) {
                    super.insertString(offs, str, a);
                }
                if (sizetext == 0) {
                    super.insertString(offs, "(", a);
                }


            } else {
                str = str.replace("(", "").replace(")", "").replace("-", "");
                int strsize = str.length();
                for (int count = strsize; count > 0; count--) {
                    String str2 = str.substring(count - 1, count);

                    if ((filter.indexOf(str2) != -1) && sizetext <= 12) {
                        if (count == 6) super.insertString(offs, "-", a);

                        if (count == 2) super.insertString(offs, ")", a);
                        super.insertString(offs, str2, a);
                        if (count == 1) super.insertString(offs, "(", a);
                    }
                }
            }
        }

    }
}
