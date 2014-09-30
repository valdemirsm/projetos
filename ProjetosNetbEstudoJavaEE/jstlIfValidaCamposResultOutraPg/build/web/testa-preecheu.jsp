<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html> 
    <c:if test="${empty param.nome}"> 
        Voce nao preencheu o campo nome. 
    </c:if> 
    <c:if test="${not empty param.nome}"> 
        Voce preencheu ${param.nome}. 
    </c:if> <br/>
    <c:if test="${empty param.telefone}"> 
        Voce nao preencheu o campo telefone. 
    </c:if> 
    <c:if test="${not empty param.telefone}"> 
        Voce preencheu ${param.telefone}. 
    </c:if>         
</html>
