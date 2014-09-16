/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classess;

/**
 *
 * @author Demir
 */
import Views.FMaster;
import Views.IFComanda;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class Botoes extends JButton {

    public Botoes(final JDesktopPane dpBotoes, final JDesktopPane dpMaster, final String i) {
//        //cria internalframe para posteriormente adicionar o botão
//        JInternalFrame fr = new JInternalFrame("");
//        ((BasicInternalFrameUI)fr.getUI()).setNorthPane(null); //retira barra heder do internalframe
//        fr.setBorder(null); //seta borda null
//        fr.setPreferredSize(new Dimension(80,80));//seta tamanho do internalfreme
//
//        dp.add(fr); //adiciona frame no desktopPanel
//        dp.setLayout(new FlowLayout(FlowLayout.CENTER));
//        fr.setLocation(0, 0);
//
//        JLabel bt = new JLabel(String.valueOf(i)); // cria botão
//        bt.setBackground(Color.ORANGE);
//        bt.setFont(new Font(null, 1, 30));
//        fr.add(bt); // adiciona botão no frame
//
//
//        fr.setVisible(true); //seta visible para o frame

        JButton bt = new JButton(String.valueOf(i)); // cria botão
        bt.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (GetsSets.getJIFComanda() == null) {
                    ResultSet rsComanda = FMaster.con.executeSQL("select * from atncomanda where id_mesa = '" + i + "' and situacao = 1");
                    try {
                        rsComanda.first();
                        if (rsComanda.isFirst()) {
                            JInternalFrame JIFComanda = new IFComanda(i);
                            dpMaster.add(JIFComanda);
                            JIFComanda.setVisible(true);
                            GetsSets.getJtfield_id_mesa().setText(i);
                            GetsSets.getJIFComanda().PreencheHerder();
                            GetsSets.getJIFComanda().PreencherJtableCliente(rsComanda.getString("id_comanda"), i);
                        }
                        rsComanda.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Botoes.class.getName()).log(Level.SEVERE, null, ex);
                    }


                } else {
                    try {

                        ResultSet rsComanda = FMaster.con.executeSQL("select * from atncomanda where id_mesa = '" + i + "' and situacao = 1");
                        rsComanda.first();
                        if (rsComanda.isFirst()) {
                            GetsSets.getJtfield_id_mesa().setText(i);
                            GetsSets.getJIFComanda().PreencheHerder();
                            GetsSets.getJIFComanda().PreencherJtableCliente(rsComanda.getString("id_comanda"), i);

                        }
                        rsComanda.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Botoes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        bt.setBackground(Color.LIGHT_GRAY);
        bt.setFont(new Font(null, 1, 33));
        dpBotoes.add(bt);
        dpBotoes.setLayout(new FlowLayout(FlowLayout.LEFT));
        dpBotoes.validate();

    }

    ;
}
