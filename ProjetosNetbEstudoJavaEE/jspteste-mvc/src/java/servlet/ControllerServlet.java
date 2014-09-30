package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.BusinessLogic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class ControllerServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String businessLogicClassName = "logic." + request.getParameter("business");
        System.out.println(businessLogicClassName);
        try {
            Class businessLogicClass =  Class.forName(businessLogicClassName);
            if (!BusinessLogic.class.isAssignableFrom(businessLogicClass)) {
                throw new ServletException("classe  não  implementa  a  interface:  "
                        + businessLogicClassName);
            }
            BusinessLogic businessLogicObject = (BusinessLogic) businessLogicClass.newInstance();
            businessLogicObject.execute(request, response);
        } catch (Exception e) {
            throw new ServletException("A lógica de negócios causou uma exceção", e);
        }
    }
}
