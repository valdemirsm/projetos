package br.com.valdemir.dao;

import br.com.valdemir.model.Fatura;
import com.mysql.jdbc.Statement;
import java.sql.CallableStatement;



/**
 *
 * @author andii
 */
public class FaturaDAO {

    private Conexao conexao;
    @SuppressWarnings("unused")
	private Statement stmt;
    private CallableStatement pstmt;

    public FaturaDAO() {
    	conexao = new Conexao();
    }

    public void inserir(Fatura fatura) {
        try {
        	pstmt = conexao.getConn().prepareCall("call sp_insere_fatura(?,?)");
        	pstmt.setInt(1, fatura.getId_cliente());
        	if (fatura.getData_pagamento()!=null) {
        		pstmt.setDate(2, new java.sql.Date(fatura.getData_pagamento().getTime()));
	    	}
        	else pstmt.setDate(2, null);
        	
        	pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }
}
