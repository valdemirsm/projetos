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
public class VisualizarContatoLogic implements BusinessLogic {

    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Contato contato = new Contato();
        Long id = Long.parseLong(req.getParameter("id"));

        //Setando o Contato 
        contato.setId(id);

        ContatoDAO contatoDao = new ContatoDAO();
        contato = contatoDao.getContato(contato);

        //Setando um atributo de escopo request 
        req.setAttribute("contato", contato);

        RequestDispatcher rd = req.getRequestDispatcher("/AlterarContato.jsp");
        rd.forward(req, res);
    }
}
