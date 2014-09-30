<%@page import="classes.Contato"%>
<%@page import="java.util.List"%>
<%@page import="classes.ContatoDAO"%>
<html> 
    <%
        ContatoDAO dao = new ContatoDAO();
        List contatos = dao.getLista();
        for (int i = 0; i < contatos.size(); i++) {
            Contato contato = (Contato) contatos.get(i);
    %> 
    <li><%=contato.getId()%><%=contato.getNome()%>, <%=contato.getEmail()%>: 
        <%=contato.getEndereco()%></li> 
        <%
            }
        %>
</html>