<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html> 
    <table border="1"> 
        <thead> 
            <tr> 
                <th>ID</th> 
                <th>Nome</th> 
                <th>Endereço</th> 
                <th>E-mail</th> 
                <th>Excluir Contato</th> 
            </tr> 
        </thead> 
        <tbody> 
            <c:forEach var="contato" items="${requestScope.contatos}"> 
                <tr> 
                    <td><a href="mvc?business=VisualizarContatoLogic&id=${contato.id}">${contato.id}</
                            a></td> 
                    <td>${contato.nome}</td>
                    <td>${contato.endereco}</td> 
                    <td>${contato.email}</td> 
                    <td><a href="mvc?business=RemoverContatoLogic&id=${contato.id}">Excluir</a></td> 
                </tr> 
            </c:forEach> 
        </tbody> 
    </table> 
    <a href="Index.jsp">Página Principal</a> 
</html>