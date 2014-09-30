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
public class AdicionaContatoLogic implements BusinessLogic {

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Contato contato = new Contato();

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");

        //Setando o Contato 
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setEndereco(endereco);

        ContatoDAO contatoDao = new ContatoDAO();
        contatoDao.adiciona(contato);

        RequestDispatcher rd = request.getRequestDispatcher("mvc?business=ListarContatosLogic");
        rd.forward(request, response);
    }
}
