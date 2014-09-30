
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Valdemir
 */
public class ControleDeAplicacao implements ServletContextListener{

    public void contextInitialized(ServletContextEvent event) {
        Date inicializacao = new Date();
        ServletContext context = event.getServletContext();
        context.setAttribute("inicializacao", inicializacao);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
