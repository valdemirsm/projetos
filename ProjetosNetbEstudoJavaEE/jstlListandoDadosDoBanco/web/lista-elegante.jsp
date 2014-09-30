<%-- 
    Document   : lista-elegante
    Created on : 20/10/2011, 23:37:28
    Author     : Valdemir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="classes.ContatoDAO"/>
<html>
    <c:forEach var="contato" items="${dao.lista}">
        <li> 
            nome: ${contato.nome}, 
            email ${contato.email}, 
            endereço ${contato.endereco} 
        </li> 
    </c:forEach> 
</html>
