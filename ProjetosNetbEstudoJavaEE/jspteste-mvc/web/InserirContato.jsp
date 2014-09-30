<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Inserir Contato</title> 
    </head> 
    <body> 
        <form  name="formInserirContatoLogic" 
               action="mvc?business=AdicionaContatoLogic" method="POST"> 
                                    
            <table border="1"> 
                <thead> 
                    <tr> 
                        <td colspan="2">Inserir Contato</td> 
                    </tr> 
                </thead> 
                <tbody> 
                    <tr> 
                        <td>Nome:</td> 
                        <td><input type="text" name="nome" value="" /></td> 
                    </tr> 
                    <tr> 
                        <td>E-mail:</td> 
                        <td><input type="text" name="email" value="" /></td> 
                    </tr> 
                    <tr> 
                        <td>Endereco:</td> 
                        <td><input type="text" name="endereco" value="" /></td> 
                    </tr> 
                    <tr> 
                        <td><input type="reset" value="Limpar" name="btLimpar" /></td> 
                        <td><input type="submit" value="Confirmar" name="btConfirmar"/></td> 
                    </tr> 
                </tbody> 
            </table> 
        </form> 
    </body> 
</html> 