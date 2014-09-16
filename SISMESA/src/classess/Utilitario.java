/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classess;

import Views.DLRecebimentoComanda;
import Views.FMaster;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Demir
 */
public class Utilitario {

    public Utilitario() {
    }

    public static int getSequencia(String tabela, String campo) {
        int maxseq = 0;
        String sql = "SELECT MAX(" + campo + ") as camposeq FROM " + tabela;
        ResultSet rsTemptete = FMaster.con.executeSQL(sql);
        try {
            rsTemptete.first();
            maxseq = rsTemptete.getInt("camposeq");
        } catch (SQLException ex) {
            Logger.getLogger(Utilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxseq + 1;
    }

    public static String getValueColumn(String nomeColumn, JTable tabela) {
        int qtdeColuna = tabela.getColumnCount();
        String nomeColuna = "", valorColuna = "0";

        for (int i = 0; i < qtdeColuna; i++) {
            nomeColuna = tabela.getColumnName(i);
            if (nomeColuna == nomeColumn) {
                if (tabela.getSelectedRow() >= 0) {
                    valorColuna = (String) String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), i));
                }
            }
        }
        if (valorColuna.equals("null")) {
            valorColuna = "";
        }
        return valorColuna;
    }

    public static int getIndiceColumn(String nomeColumn, JTable tabela) {
        int qtdeColuna = tabela.getColumnCount();
        String nomeColuna = "", valorColuna = "0";
        int indiceColuna = 0;

        for (int i = 0; i < qtdeColuna; i++) {
            nomeColuna = tabela.getColumnName(i);
            if (nomeColuna == nomeColumn) {
                if (tabela.getSelectedRow() >= 0) {
                    indiceColuna = i;
                }
            }
        }
        return indiceColuna;
    }

    /**
     *
     * Funcao de formatacao de valores numericos com decimal,o padrao de formatacao dos valores é: (",##0.00")
     * @return
     */
    public static String getFomatDecimal(Float valor) {
        DecimalFormat decimal = new DecimalFormat("0.00");
        String vlrFomatado = decimal.format(valor);
        return vlrFomatado;
    }

    public static String getFomatDecimal3Casas(Float valor) {
        DecimalFormat decimal = new DecimalFormat("0.000");
        String vlrFomatado = decimal.format(valor);
        return vlrFomatado;
    }

    public static String getDataAtual() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date minhadata = new Date();
        String data = formato.format(minhadata);
        return data;
    }

    public static String getHoraAtual() {
        SimpleDateFormat formato = new SimpleDateFormat("h:mm - a");
        Date data = new Date();
        String hora = formato.format(data);
        return hora;
    }

    //Retorna a data no formato sql
    public static Date getPegaDataSql(String data) {
        if (!data.replace("/", "").trim().equalsIgnoreCase("")) {

            String Dia = data.substring(0, 2);// 0, 2
            Dia = "-" + Dia;
            String Mes = data.substring(3, 5);// 3,5
            Mes = "-" + Mes;
            String DataSql = data.substring(6, 10).concat(Mes).concat(Dia).trim();
            return java.sql.Date.valueOf(DataSql);
        } else {
            return null;
        }
    }

    public static Timestamp getDateAndTimeAtual() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date data = new Date();
        String hora = formato.format(data);
        return java.sql.Timestamp.valueOf(hora);
    }

    public static Timestamp getDateAndTime(String dat) {
        if (!dat.replace("/", "").trim().equalsIgnoreCase("")) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String Dia = dat.substring(0, 2);// 0, 2
            Dia = "" + Dia;
            String Mes = dat.substring(3, 5);// 3,5
            Mes = "" + Mes;
            String DataSql = dat.substring(6, 10).concat(Mes).concat(Dia).trim();
            DataSql = formato.format(DataSql);
            return java.sql.Timestamp.valueOf(DataSql);
        } else {
            return null;
        }
    }

    public static String FormatDate(java.sql.Date data) {
        if (data != null) {
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String dat = String.valueOf(formato.format(data));
            return dat;
        } else {
            return "";
        }
    }

    public static DefaultTableCellRenderer cellRender(final int destaque) {
        DefaultTableCellRenderer CellRight = new DefaultTableCellRenderer() {

            public void setValue(Object value) {
                setHorizontalAlignment(JLabel.RIGHT);
                //setBackground(Color.YELLOW);
                if (destaque == 1) {
                    setBackground(Color.GREEN);
                } else {
                    setForeground(Color.blue);
                }



                super.setValue(value);
            }
        };
        return CellRight;
    }

    public static boolean validaUsuario(String usuario, String senha) {
        ResultSet rsUser;
        rsUser = FMaster.con.executeSQL("select * from grcusuario  where nome = '" + usuario.trim() + "' and senha = '" + EncriptaSenha.encripta(senha.trim()) + "'");
        try {
            rsUser.first();
            if (rsUser.isFirst()) {
                GetsSets.setCodUser(rsUser.getInt("id_usuario"));
                GetsSets.setNomeUser(rsUser.getString("nome"));
                rsUser.close();
                return true;
            } else {
                GetsSets.setCodUser(0);
                GetsSets.setNomeUser("");
                rsUser.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Utilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
        GetsSets.setCodUser(0);
        GetsSets.setNomeUser("");
        return false;
    }

    public static boolean verStringNumber(String input) {
        boolean bValid = true;
        if (!input.equals("")) {
            if (input.matches("[a-zA-Z\\s]+")) {
                bValid = false;
            }
        }
        return bValid;
    }

    /**
     * Formado do valor recebido é assim 6634212199
     * Retornará no formato (66)3421-2199
     */
    public static String FormataFone(String str) {
        str = str==null?"":str;
        int strsize = str.length();
        String foneFormatado = "";
        for (int count = 1; count <= strsize; count++) {
            String str2 = str.substring(count - 1, count);
            if (count == 1) {
                foneFormatado = "(";
                foneFormatado = foneFormatado + str2;
            } else if (count == 2) {
                foneFormatado = foneFormatado + str2;
                foneFormatado = foneFormatado + ")";
            } else if (count == 6) {
                foneFormatado = foneFormatado + str2;
                foneFormatado = foneFormatado + "-";
            } else {
                foneFormatado = foneFormatado + str2;
            }
        }
        return foneFormatado;
    }

    /*Verifica se existe caixa aberto*/
    public static int VerExisteCaixaAberto() {

        ResultSet rsVerCaixaAberto = FMaster.con.executeSQL("select * from cxacaixa where situacao = '1'");
        try {
            rsVerCaixaAberto.first();
            if (!rsVerCaixaAberto.isFirst()) {
                JOptionPane.showMessageDialog(null, "Não existe caixa aberto! Para abrir o caixa vá até o cadastro de caixa.", "Alerta", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DLRecebimentoComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public static void SalvaAliquota(String desc_aliquota, String vlr_aliquota) {
        ResultSet rsAliquota = FMaster.con.executeSQL("select * from atnconfigecf");
        try {
            rsAliquota.first();
            if (rsAliquota.isFirst()) {
                rsAliquota.absolute(rsAliquota.getRow());
                rsAliquota.updateString("vlr_aliquota", vlr_aliquota);
                rsAliquota.updateString("desc_aliquota", desc_aliquota);
                rsAliquota.updateRow();
            } else {
                rsAliquota.moveToInsertRow();
                rsAliquota.updateString("vlr_aliquota", vlr_aliquota);
                rsAliquota.updateString("desc_aliquota", desc_aliquota);
                rsAliquota.insertRow();
            }
            rsAliquota.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void SalvaUltimoCFGeradoComanda(int id_comanda) {
        ResultSet rsUltimoECF = FMaster.con.executeSQL("select * from atnconfigecf");
        try {
            rsUltimoECF.first();
            if (rsUltimoECF.isFirst()) {
                rsUltimoECF.absolute(rsUltimoECF.getRow());
                rsUltimoECF.updateInt("id_comanda", id_comanda);
                rsUltimoECF.updateRow();
            } else {
                rsUltimoECF.moveToInsertRow();
                rsUltimoECF.updateInt("id_comanda", id_comanda);
                rsUltimoECF.insertRow();
            }
            rsUltimoECF.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void SalvaUltimoCFGeradoDelivery(int id_delivery) {
        ResultSet rsUltimoECF = FMaster.con.executeSQL("select * from atnconfigecf");
        try {
            rsUltimoECF.first();
            if (rsUltimoECF.isFirst()) {
                rsUltimoECF.absolute(rsUltimoECF.getRow());
                rsUltimoECF.updateInt("id_delivery", id_delivery);
                rsUltimoECF.updateRow();
            } else {
                rsUltimoECF.moveToInsertRow();
                rsUltimoECF.updateInt("id_delivery", id_delivery);
                rsUltimoECF.insertRow();
            }
            rsUltimoECF.close();
        } catch (SQLException ex) {
            Logger.getLogger(Utilitario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
