<%@ page isErrorPage="true" %>
<html> 
    <h1>Um erro ocorreu.</h1><br/> 
    ${pageContext.errorData.throwable} 
</html>