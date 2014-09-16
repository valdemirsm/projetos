/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classess;

import Views.FMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Demir
 */
public class MovimentoCaixa {

    public MovimentoCaixa() {
    }
    /**
     * (tipo_lancamento)  -----> 1 = Dinheiro, 2 = Cartão Débito, 3 = Cartão Crédito, 4 = Cheque, 5 = Cédula, 6 = Moéda
     * (natureza) -------------> 1 = Crédito, 2 = Débito
     * (data_lancamento) ------> deve ser passado a data que esta fazendo o lançamento, no caso a data atual no formato 2010-11-25 21:12:10
     * (tipo_movimento) -------> 1 = Troco, 2 = Venda, 3 = Sangria, 4 = Suprimento, 5 = Crédito
     */
    public static int LancaMovimento(float valor, int id_comanda, int id_delivery, int tipo_lancamento, int natureza, Timestamp data_lancamento, int tipo_movimento) {
        int retorno = 0;
        ResultSet rsCaixa = FMaster.con.executeSQL("select * from cxacaixa where situacao = '1'");
        try {
            rsCaixa.first();
            if (rsCaixa.isFirst()) {
                ResultSet rsMovCaixa = FMaster.con.executeSQL("select * from cxaabrefecha where id_abrefechacaixa = '" + rsCaixa.getString("id_abrefechacaixa") + "'");
                rsMovCaixa.first();
                if (rsMovCaixa.isFirst()) {
                    if (valor > 0) {
                        ResultSet rsMovItemCaixa = FMaster.con.executeSQL("select * from cxaitemcaixa where id_abrefechacaixa = '" + rsMovCaixa.getString("id_abrefechacaixa") + "'");
                        rsMovItemCaixa.first();
                        rsMovItemCaixa.moveToInsertRow();
                        rsMovItemCaixa.updateInt("id_caixaitem", Utilitario.getSequencia("cxaitemcaixa", "id_caixaitem"));
                        rsMovItemCaixa.updateInt("id_abrefechacaixa", rsMovCaixa.getInt("id_abrefechacaixa"));
                        rsMovItemCaixa.updateFloat("valor", valor);
                        rsMovItemCaixa.updateInt("id_comanda", id_comanda);
                        rsMovItemCaixa.updateInt("id_delivery", id_delivery);
                        rsMovItemCaixa.updateInt("tipo_lancamento", tipo_lancamento);
                        rsMovItemCaixa.updateInt("natureza", natureza); //1= Credito
                        rsMovItemCaixa.updateTimestamp("data_lancamento", data_lancamento);
                        rsMovItemCaixa.updateInt("tipo_movimento", tipo_movimento); //2 = Venda
                        rsMovItemCaixa.updateInt("id_usuario", GetsSets.getCodUser());
                        rsMovItemCaixa.insertRow();
                        rsMovItemCaixa.close();

                        /*Atualiza saldo do movimento de caixa*/
                        FMaster.con.executeUpdate("update cxaabrefecha  set valor_debito = (select coalesce(sum(valor),0) from cxaitemcaixa  where cxaitemcaixa.id_abrefechacaixa = cxaabrefecha.id_abrefechacaixa and cxaitemcaixa.natureza = 2), "
                                + "valor_credito = (select coalesce(sum(valor),0) from cxaitemcaixa  where cxaitemcaixa.id_abrefechacaixa = cxaabrefecha.id_abrefechacaixa and cxaitemcaixa.natureza = 1) "
                                + "where cxaabrefecha.id_abrefechacaixa = '" + rsMovCaixa.getString("id_abrefechacaixa") + "'");
                        FMaster.con.executeUpdate("update cxaabrefecha  set saldo = (valor_credito - valor_debito)  where cxaabrefecha.id_abrefechacaixa = '" + rsMovCaixa.getString("id_abrefechacaixa") + "'");

                        rsMovItemCaixa.close();
                        retorno = 1;
                    }
                }
                rsMovCaixa.close();
            }
            rsCaixa.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
