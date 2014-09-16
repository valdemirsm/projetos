/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classess;

import Views.FMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valdemir
 */
public class MovimentoEstoque {

    public MovimentoEstoque() {
    }
    /**
     *
     * @param i             1=incrementa a qtde no estoque  2=decrementa a qtde no estoque
     * @param codProduto
     * @param qtde
     */
    public static void AtualizaSaldoProduto(int i, int codProduto, float qtde) {
        if (codProduto != 0) {

            ResultSet rsProduto = FMaster.con.executeSQL("select * from estproduto where id_produto = '" + codProduto + "'");
            try {
                rsProduto.first();
                if (rsProduto.isFirst()) {
                    if (i == 1) {
                        rsProduto.absolute(rsProduto.getRow());
                        rsProduto.updateFloat("saldo_estoque", (rsProduto.getFloat("saldo_estoque") + qtde));
                        rsProduto.updateRow();
                    }
                    if (i == 2) {
                        rsProduto.absolute(rsProduto.getRow());
                        rsProduto.updateFloat("saldo_estoque", (rsProduto.getFloat("saldo_estoque") - qtde));
                        rsProduto.updateRow();
                    }
                }
                rsProduto.close();

            } catch (SQLException ex) {
                Logger.getLogger(MovimentoEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
