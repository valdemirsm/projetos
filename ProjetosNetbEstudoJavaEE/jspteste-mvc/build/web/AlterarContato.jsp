<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Alterar Contato</title> 
    </head> 
    <body> 

        <form  name="formAlterarContatoLogic" 
               action="mvc?business=AlterarContatoLogic" method="POST"> 
            <table border="1"> 
                <thead> 
                    <tr> 
                        <td colspan="3">Alterar Contato</td> 
                    </tr> 
                </thead> 
                <tbody> 
                    <tr> 
                        <td>Código:</td> 
                        <td><input type="text" name="id" 
                                   value="${requestScope.contato.id}" readonly="readonly" /></td> 
                    </tr> 
                    <tr> 
                        <td>Nome:</td> 
                        <td><input type="text" name="nome" 
                                   value="${requestScope.contato.nome}" /></td>

                    </tr> 
                    <tr> 
                        <td>E-mail:</td> 
                        <td><input type="text" name="email" 
                                   value="${requestScope.contato.email}" /></td> 
                    </tr> 
                    <tr> 
                        <td>Endereço:</td> 
                        <td><input type="text" name="endereco" 
                                   value="${requestScope.contato.endereco}" /></td> 
                    </tr> 
                    <tr> 
                        <td><input type="reset" value="Limpar" name="btLimpar" /></td> 
                        <td><input type="submit" value="Confirmar" name="btConfirmar" /></td> 
                    </tr> 
                </tbody> 
            </table> 
        </form> 
    </body> 
</html> 