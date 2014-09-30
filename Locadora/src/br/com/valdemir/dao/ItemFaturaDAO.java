package br.com.valdemir.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.valdemir.model.ItemFatura;

public class ItemFaturaDAO {
	private Conexao conexao;
	private CallableStatement pstmt;
    
    public ItemFaturaDAO() {
        conexao = new Conexao();
    }
    
    public void inserir(ItemFatura itemfatura) {
        try {
        	pstmt = conexao.getConn().prepareCall("SELECT f_retorna_id_fatura() AS id_fatura");
			ResultSet rs = pstmt.executeQuery();
	    	rs.first();
	    	itemfatura.setId_fatura(rs.getInt("id_fatura"));
	    	
        	pstmt = conexao.getConn().prepareCall("call sp_insere_item_fatura(?,?,?,?,?)");
        	pstmt.setInt(1, itemfatura.getId_fatura());
        	pstmt.setInt(2, itemfatura.getId_filme());
        	pstmt.setFloat(3, itemfatura.getPreco_filme());
        	pstmt.setInt(4, 1);
        	if (itemfatura.getData_devolucao()!=null) {
        		pstmt.setDate(5, new java.sql.Date(itemfatura.getData_devolucao().getTime()));
	    	}
        	else pstmt.setDate(5, null);
        	
        	pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }
    
    public List<ItemFatura> listar(ItemFatura itemfat) {
        List<ItemFatura> itensfatura = new ArrayList<ItemFatura>();
        try {
        	pstmt = conexao.getConn().prepareCall("call sp_consulta_item_fatura");
        	ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ItemFatura itemfatura = new ItemFatura();
                itemfatura.setId_filme_alugado(rs.getInt("id_filme_alugado"));
                itemfatura.setId_fatura(rs.getInt("id_fatura"));
                itemfatura.setId_filme(rs.getInt("id_filme"));
                itemfatura.setNome_cliente(rs.getString("nome_cliente"));
                itemfatura.setNome_filme(rs.getString("nome_filme"));
                itemfatura.setPreco_filme(rs.getFloat("preco_filme"));
                itemfatura.setData_devolucao(rs.getDate("data_devolucao"));
                itemfatura.setData_pagamento(rs.getDate("data_pagamento"));
                itemfatura.setData_retirada(rs.getDate("data_retirada"));
                itemfatura.setSituacao(rs.getInt("situacao"));
                itemfatura.setDesc_situacao(rs.getString("desc_situacao"));
                itensfatura.add(itemfatura);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return itensfatura;
    }
    
    public void remover(int id_filme_alugado) {
    	try {
        	pstmt = conexao.getConn().prepareCall("call sp_deleta_item_fatura(?)");
        	pstmt.setInt(1, id_filme_alugado);
        	pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }
    
    public void alterar(ItemFatura itemFatura) {
    	try {
    		System.out.println(itemFatura.getId_filme_alugado());
        	pstmt = conexao.getConn().prepareCall("call sp_altera_status_filme_alugado(?,?,?)");
        	pstmt.setInt(1, itemFatura.getId_filme_alugado());
        	pstmt.setInt(2, itemFatura.getSituacao());
        	if (itemFatura.getData_pagamento()!=null) {
        		pstmt.setDate(3, new java.sql.Date(itemFatura.getData_pagamento().getTime()));
	    	}
        	else pstmt.setDate(3, null);
        	pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }
}
