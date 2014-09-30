package logic;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public interface BusinessLogic { 
  void execute(HttpServletRequest req, HttpServletResponse res) throws Exception; 
} 
