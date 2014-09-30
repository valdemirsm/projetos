<html> 
  Acessando com EL: ${inicializacao}<br/> 
  Acessando escopo application: ${applicationScope['inicializacao']}<br/> 
  Acessando application com scriptlet: <%= application.getAttribute("inicializacao") %> 
  <br/> 
</html>