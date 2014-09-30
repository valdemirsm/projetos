/*Pagina 132 da apostila CEFETES-PW-Apostila_24*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletContext;
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
public class AcessaAplicacao extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext aplicacao = getServletContext();
        Date inicializacao = (Date) aplicacao.getAttribute("inicializacao");
        Date agora = new Date();
        long diferenca = agora.getTime() - inicializacao.getTime();
        double minutos = diferenca / (60 * 1000);

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("Momento inicial: " + inicializacao + "<br/>");
        writer.println("Momento atual: " + agora + "<br/>");
        writer.println("Minutos: " + minutos + "<br/>");
        writer.println("</html>");
    }
}
