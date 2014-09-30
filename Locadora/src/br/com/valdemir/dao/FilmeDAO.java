package br.com.valdemir.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.valdemir.model.Filme;

public class FilmeDAO {
	private Conexao conexao;
	private CallableStatement pstmt;

    public FilmeDAO() {
        conexao = new Conexao();
    }

    public void inserir(Filme filme) {
        try {
        	System.out.println("A");
        	pstmt = conexao.getConn().prepareCall("call sp_insere_filme(?,?,?,?)");
        	pstmt.setString(1, filme.getNome());
        	pstmt.setFloat(2, filme.getPreco());
        	pstmt.setInt(3, filme.getQuantidade_estoque());
        	pstmt.setString(4, filme.getGenero());
        	pstmt.execute();
        	System.out.println("B");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void alterar(Filme filme) {
    	try {
        	pstmt = conexao.getConn().prepareCall("call sp_altera_filme(?,?,?,?,?)");
        	pstmt.setInt(1, filme.getId_filme());
        	pstmt.setString(2, filme.getNome());
        	pstmt.setFloat(3, filme.getPreco());
        	pstmt.setInt(4, filme.getQuantidade_estoque());
        	pstmt.setString(5, filme.getGenero());
        	pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void remover(int id_filme) {
    	try {
        	pstmt = conexao.getConn().prepareCall("call sp_deleta_filme(?)");
        	pstmt.setInt(1, id_filme);
        	pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public List<Filme> listar(Filme film) {
        List<Filme> filmes = new ArrayList<Filme>();
        try {
        	pstmt =  conexao.getConn().prepareCall("call sp_consulta_filme");
        	ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId_filme(rs.getInt("id_filme"));
                filme.setNome(rs.getString("nome"));
                filme.setPreco(rs.getFloat("preco"));
                filme.setQuantidade_estoque(rs.getInt("quantidade_estoque"));
                filme.setGenero(rs.getString("genero"));
                filmes.add(filme);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return filmes;
    }
}
