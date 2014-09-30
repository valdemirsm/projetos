package logic;

import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdbc.dao.ContatoDAO;
import modelo.Contato;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class RemoverContatoLogic implements BusinessLogic {

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Contato contato = new Contato();

        Long id = Long.parseLong(request.getParameter("id"));

        //Setando o Contato 
        contato.setId(id);

        ContatoDAO contatoDao = new ContatoDAO();
        contatoDao.remove(contato);

        RequestDispatcher rd =  request.getRequestDispatcher("mvc?business=ListarContatosLogic");
        rd.forward(request, response);
    }
}
