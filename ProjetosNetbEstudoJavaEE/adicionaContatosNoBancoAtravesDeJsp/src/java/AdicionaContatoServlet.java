/*Pagina 138 da apostila CEFETES-PW-Apostila_24*/
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Valdemir
 */
public class AdicionaContatoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String endereco = req.getParameter("endereco");
        String email = req.getParameter("email");

        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);


        try {
            ContatoDAO dao = new ContatoDAO();
            dao.adiciona(contato);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/contato-adicionado.jsp");
        rd.forward(req, resp);

    }
}
