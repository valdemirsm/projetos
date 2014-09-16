/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classess;

import Views.FMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;

/**
 *
 * @author Demir
 */
public class ThreadMesas implements Runnable {

    Thread t1 = new Thread(this);
    JDesktopPane dpBotoes;
    JDesktopPane dpMaster;

    public ThreadMesas(JDesktopPane dpBotoes, JDesktopPane dpMaster) {
        this.dpBotoes = dpBotoes;
        this.dpMaster = dpMaster;
        t1.start();
    }

    public void run() {

        int loopInfinito = 0;
        int achou = 0;

        ArrayList<String> numerosMesasUsadasAtual = new ArrayList<String>();

        ArrayList<String> numerosMesasUsadasAnterior = new ArrayList<String>();

        while (loopInfinito == 0) {
            try {
                t1.sleep(1 * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadMesas.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rsMesa = FMaster.con.executeSQL("select * from atncomanda where situacao = 1 order by id_mesa");
            try {
                int contMesa = 0;
                numerosMesasUsadasAtual.clear();
                rsMesa.first();
                if (rsMesa.isFirst()) {
                    do {
                        numerosMesasUsadasAtual.add(rsMesa.getString("id_mesa"));
                    } while (rsMesa.next());
                }


                if (numerosMesasUsadasAnterior.size() != numerosMesasUsadasAtual.size()) {

                    LimpAInternalFrame();
                    dpBotoes.validate();
                    rsMesa.first();
                    if (rsMesa.isFirst()) {
                        do {
                            try {
                                t1.sleep(1 * 100);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ThreadMesas.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            new Botoes(dpBotoes, dpMaster, rsMesa.getString("id_mesa"));
                        } while (rsMesa.next());
                    }
                }

                numerosMesasUsadasAnterior.clear();
                rsMesa.first();
                if (rsMesa.isFirst()) {
                    do {
                        numerosMesasUsadasAnterior.add(rsMesa.getString("id_mesa"));
                    } while (rsMesa.next());

                }
            } catch (SQLException ex) {
                Logger.getLogger(ThreadMesas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void LimpAInternalFrame() {
//        JInternalFrame[] frames = dp.getAllFrames();
//        for (int f = 0; f < frames.length; f++) {
//            frames[f].dispose();
//        }

        //remove todos os componentes do jdesktopPanel
        dpBotoes.removeAll();
        dpBotoes.setVisible(false);
        dpBotoes.setVisible(true);
    }
}
