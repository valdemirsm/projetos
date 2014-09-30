/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.dao.ContatoDAO;
import modelo.Contato;

/**
 *
 * @author Valdemir
 */
public class ListarContatosLogic implements BusinessLogic{

    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        List<Contato> contatos = new ArrayList(); 
        ContatoDAO contatoDao = new ContatoDAO(); 
        contatos = contatoDao.getLista(); 
 
        //Setando um atributo de escopo request 
        req.setAttribute("contatos", contatos); 
 
        RequestDispatcher rd = req.getRequestDispatcher("/ListarContatos.jsp"); 
        rd.forward(req, res);
    }
    
}
