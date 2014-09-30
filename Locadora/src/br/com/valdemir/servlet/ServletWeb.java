package br.com.valdemir.servlet;

import java.io.*;   
  
import javax.servlet.*;   
import javax.servlet.http.*;   

/**  
 *  
 * @author root  
 * @version  
 */  
   
  
@SuppressWarnings("serial")
public class ServletWeb extends HttpServlet {   
    @SuppressWarnings("unused")
	private ServletContext sc;   
    private  br.com.valdemir.dao.Conexao con; 
       
    public void init(ServletConfig config) throws ServletException {   
        super.init(config);   
        sc = config.getServletContext();   
        con = new br.com.valdemir.dao.Conexao();
        con.getConn();
    }   
       
       
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.  
     * @param request servlet request  
     * @param response servlet response  
     */  
    protected void service(HttpServletRequest request, HttpServletResponse response)   
    throws ServletException, IOException {   
        RequestDispatcher rd = request.getRequestDispatcher("");   
        rd.forward(request, response);   
    }   
       
    public void destroy() {   
        con.fecharConexao();   
    }   
}  
