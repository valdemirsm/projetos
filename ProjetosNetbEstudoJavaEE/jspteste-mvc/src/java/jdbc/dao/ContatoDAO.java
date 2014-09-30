package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionFactory;
import modelo.Contato;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class ContatoDAO {
// a conexão com o banco de dados 

    private Connection connection;

    public ContatoDAO() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
    }

    public void adiciona(Contato contato) throws SQLException {
        // prepared statement para inserção 
        PreparedStatement stmt = this.connection.prepareStatement("insert into "
                + "contatos(nome,email,endereco) values(?, ?, ?)");
        // seta os valores 
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEmail());
        stmt.setString(3, contato.getEndereco());
        // executa 
        stmt.execute();
        stmt.close();
    }

    public void remove(Contato contato) throws SQLException {
        // prepared statement para inserção 
        PreparedStatement stmt = this.connection.prepareStatement("delete from contatos where id = ?");
        // seta os valores 
        stmt.setLong(1, contato.getId());
        // executa 
        stmt.execute();
        stmt.close();
    }

    public List<Contato> getLista() throws SQLException {
        PreparedStatement stmt =
                this.connection.prepareStatement("select  *  from contatos order by id");
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

    public void altera(Contato contato) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
        "update contatos set " + "nome =  ?, email =  ?, endereco =  ? where  id =  ?"); 
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEmail());
        stmt.setString(3, contato.getEndereco());
        stmt.setLong(4, contato.getId());
        stmt.execute();
        stmt.close();
    }

    public Contato getContato(Contato contato) throws SQLException{
        PreparedStatement stmt =  connection.prepareStatement(
        "select * from contatos where id = ?"); 
        stmt.setLong(1, contato.getId());
        ResultSet rs = stmt.executeQuery();
        
        rs.next();
        contato.setId(rs.getLong("id"));
        contato.setNome(rs.getString("nome"));
        contato.setEmail(rs.getString("email"));
        contato.setEndereco(rs.getString("endereco"));
        rs.close();
        stmt.close();
        
        return contato;
    }
}
