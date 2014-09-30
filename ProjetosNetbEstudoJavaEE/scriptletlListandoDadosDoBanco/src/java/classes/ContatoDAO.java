/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Valdemir
 */
public class ContatoDAO {
    // a conexão com o banco de dados 

    private Connection connection;

    public ContatoDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public void adiciona(Contato contato) throws SQLException {
        // prepared statement para inserção 
        PreparedStatement stmt = this.connection.prepareStatement(
                "insert into "
                + "contatos(nome,email,endereco) values(?, ?, ?)");
        // seta os valores 
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEmail());
        stmt.setString(3, contato.getEndereco());
        // executa 
        stmt.execute();
        stmt.close();
    }

    public List<Contato> getLista() throws SQLException {
        PreparedStatement stmt =
                this.connection.prepareStatement("select * from contatos");
        ResultSet rs = stmt.executeQuery();
        List<Contato> contatos = new ArrayList<Contato>();
        while (rs.next()) {
// criando o objeto Contato 
            Contato contato = new Contato();
            contato.setId(rs.getLong("id"));
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
            contato.setEndereco(rs.getString("endereco"));
            // adicionando o objeto à lista 
            contatos.add(contato);
        }
        rs.close();
        stmt.close();
        return contatos;
    }
}
