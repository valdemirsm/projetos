package br.com.valdemir.dao;

import br.com.valdemir.model.Cliente;
import com.mysql.jdbc.Statement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author andii
 */
public class ClienteDAO {

    private Conexao conexao;
    @SuppressWarnings("unused")
	private Statement stmt;
    private CallableStatement pstmt;

    public ClienteDAO() {
        conexao = new Conexao();
    }

    public void inserir(Cliente cliente) {
        try {
        	pstmt = conexao.getConn().prepareCall("call sp_insere_cliente(?,?,?)");
        	pstmt.setString(1, cliente.getNome());
        	pstmt.setString(2, cliente.getCpf());
        	pstmt.setString(3, cliente.getRg());
        	pstmt.execute(); 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void alterar(Cliente cliente) {
    	
        try {
        	pstmt = conexao.getConn().prepareCall("call sp_altera_cliente(?,?,?,?)");
        	pstmt.setInt(1, cliente.getId_cliente());
        	pstmt.setString(2, cliente.getNome());
        	pstmt.setString(3, cliente.getCpf());
        	pstmt.setString(4, cliente.getRg());
        	pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public void remover(int id_cliente) {
        try {
        	pstmt = conexao.getConn().prepareCall("call sp_deleta_cliente(?)");
        	pstmt.setInt(1, id_cliente);
        	pstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
    }

    public List<Cliente> listar(Cliente cli) {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
        	pstmt =  conexao.getConn().prepareCall("call sp_consulta_cliente");
        	ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
            	cliente.setId_cliente(rs.getInt("id_cliente"));
            	cliente.setNome(rs.getString("nome"));
            	cliente.setCpf(rs.getString("cpf"));
            	cliente.setRg(rs.getString("rg"));
                clientes.add(cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return clientes;
    }
    
}
