/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classess;

import Views.FMaster;
import java.awt.BorderLayout;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Demir
 */
public class PrintRel extends FMaster {

    public PrintRel() {
    }

    public static void imprime(String relatorio, int filtro) {

        try {
            Connection conn = null;
            Conexao con = new Conexao();
            conn = con.conecta();
            HashMap<String, Integer> parameterMap = new HashMap<String, Integer>();

            parameterMap.put("pParametro", filtro);
            String arquivo = System.getProperty("user.dir")
                    + "/src/Relatorios/" + relatorio;

            JasperPrint jp = JasperFillManager.fillReport(arquivo, parameterMap, conn);
            JasperViewer.viewReport(jp, false);

            //JasperPrintManager.printPage(jp, 0, false);

            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrintRel.class.getName()).log(Level.SEVERE, null, ex);
            }


        } catch (JRException ex) {
            Logger.getLogger(PrintRel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void imprime(String relatorio, String filtro, String Param01, String Param02) {
        try {
            Connection conn = null;
            Conexao con = new Conexao();
            conn = con.conecta();
            HashMap<String, String> parameterMap = new HashMap<String, String>();

            parameterMap.put("Param01", Param01);
            parameterMap.put("Param02", Param02);
            parameterMap.put("pId_Comanda", filtro);

            String arquivo = System.getProperty("user.dir")
                    + "/Relatorios/" + relatorio;

            JasperPrint jp = JasperFillManager.fillReport(arquivo, parameterMap, conn);
            JasperViewer.viewReport(jp, false);

            //JasperPrintManager.printPage(jp, 0, false);

            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrintRel.class.getName()).log(Level.SEVERE, null, ex);
            }


        } catch (JRException ex) {
            Logger.getLogger(PrintRel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void PrintToIntenalFrame(String relatorio, String filtro, String titulo) {
//
//        try {
//            Connection conn = null;
//            Conexao con = new Conexao();
//            conn = con.conecta();
//            String arquivo = System.getProperty("user.dir")
//                    + "/Relatorios/" + relatorio;
//
//
//            ResultSet rs = con.executeSQL(filtro);
//            JRResultSetDataSource jrRs = new JRResultSetDataSource(rs);
//            JasperPrint jp = JasperFillManager.fillReport(arquivo, null, jrRs);
//
//            JRViewer jr = new JRViewer(jp);
//
//            JInternalFrame JInternalFrameRelatorios = new JInternalFrame(titulo);
//
//            JInternalFrameRelatorios.setSize(800, 600);
//            JInternalFrameRelatorios.setClosable(true);
//            JInternalFrameRelatorios.setIconifiable(true);
//            JInternalFrameRelatorios.setMaximizable(true);
//            JInternalFrameRelatorios.setLayout(new BorderLayout());
//            JInternalFrameRelatorios.setLocation(220, 30);
//
//            JInternalFrameRelatorios.add(jr);
//            jDesktopPane1.add(JInternalFrameRelatorios);
//
//            try {
//                JInternalFrameRelatorios.setMaximum(true);
//            } catch (PropertyVetoException ex) {
//                Logger.getLogger(PrintRel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            JInternalFrameRelatorios.setVisible(true);
//
//            try {
//                conn.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(PrintRel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (JRException ex) {
//            Logger.getLogger(PrintRel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
