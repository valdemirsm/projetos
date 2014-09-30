
import java.io.IOException;
import java.io.PrintWriter;
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
public class TestaParametros extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recebe o writer 
        PrintWriter writer = resp.getWriter();
        // escreve o texto 
        writer.println("<html>");
        writer.println("Caelum explica o parametro: " + req.getParameter("idade"));
        writer.println("</html>");
    }
}
