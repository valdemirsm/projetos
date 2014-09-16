/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classess;

import Views.IFComanda;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Demir
 */
public class GetsSets {
    public static JTable Grid = null;
    public static int Comanda = 0;
    private static int codUser = 0;
    private static String nomeUser = "";
    private static int codUserSistema = 0;
    private static String idGrid01 = "";
    private static IFComanda JIFComanda; //Aberto ou Fechado
    private static JTextField jtfield_id_mesa;
    private static JDesktopPane jdesktopPanelViews;

    public static JDesktopPane getJdesktopPanelViews() {
        return jdesktopPanelViews;
    }

    public static void setJdesktopPanelViews(JDesktopPane jdesktopPanelViews) {
        GetsSets.jdesktopPanelViews = jdesktopPanelViews;
    }

    public static JTextField getJtfield_id_mesa() {
        return jtfield_id_mesa;
    }

    public static void setJtfield_id_mesa(JTextField jtfield_id_mesa) {
        GetsSets.jtfield_id_mesa = jtfield_id_mesa;
    }

    public static IFComanda getJIFComanda() {
        return JIFComanda;
    }

    public static void setJIFComanda(IFComanda JIFComanda) {
        GetsSets.JIFComanda = JIFComanda;
    }

    public static String getIdGrid01() {
        return idGrid01;
    }

    public static void setIdGrid01(String idGrid01) {
        GetsSets.idGrid01 = idGrid01;
    }
    public GetsSets(){
        
    }
    public static int getCodUser() {
        return codUser;
    }

    public static void setCodUser(int codUser) {
        GetsSets.codUser = codUser;
    }

    public static String getNomeUser() {
        return nomeUser;
    }

    public static void setNomeUser(String nomeUser) {
        GetsSets.nomeUser = nomeUser;
    }

    public static JTable getGrid() {
        return Grid;
    }

    public static void setGrid(JTable Grid) {
        GetsSets.Grid = Grid;
    }

    public static int getComanda() {
        return Comanda;
    }

    public static void setComanda(int Comanda) {
        GetsSets.Comanda = Comanda;
    }


}
