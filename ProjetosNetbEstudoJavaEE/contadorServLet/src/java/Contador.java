
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
public class Contador extends HttpServlet{
    private int contador = 0;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        contador++;
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("Caelum explica: " + contador +"  visita a servlet."); 
        out.println("</html>");
        
    }
    
}
