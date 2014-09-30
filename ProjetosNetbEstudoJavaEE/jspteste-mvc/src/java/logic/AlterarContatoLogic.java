/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.dao.ContatoDAO;
import modelo.Contato;

/**
 *
 * @author Valdemir
 */
public class AlterarContatoLogic implements BusinessLogic {

    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Contato contato = new Contato();

        Long id = Long.parseLong(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String endereco = req.getParameter("endereco");

        //Setando o Contato 
        contato.setId(id);
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);

        ContatoDAO contatoDao = new ContatoDAO();
        contatoDao.altera(contato);

        RequestDispatcher rd =
                req.getRequestDispatcher("mvc?business=ListarContatosLogic");
        rd.forward(req, res);
    }
}
