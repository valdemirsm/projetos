/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;

/**
 *
 * @author Valdemir
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // pronto para gravar 
            Contato contato = new Contato();
            contato.setNome("Caelum");
            contato.setEmail("contato@caelum.com.br");
            contato.setEndereco("R. Vergueiro 3185 cj57");
            // grave nessa conexão!!! 
            ContatoDAO bd = new ContatoDAO();
            // método elegante 
            bd.adiciona(contato);
            System.out.println("Gravado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
