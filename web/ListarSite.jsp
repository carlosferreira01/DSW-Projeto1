<%-- 
    Document   : ListarSite.jsp
    Created on : 22/04/2019, 09:46:27
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Ingressos</title>
    </head>
    <body>
        
        <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista sites</h2></caption>
            <tr>
                <th>URL</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Ações</th>
          
            </tr>
            <c:forEach var="site" items="${requestScope.ListaSites}">
                <tr>
                    <td><c:out value="${site.url}" /></td>
                    <td><c:out value="${site.nome}" /></td>
                    <td><c:out value="${site.telefone}" /></td>
                  
                    <td>
                        <a href="edicao?url=<c:out value='${site.url}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocao?url=<c:out value='${site.url}' />" 
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção
                        </a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
        
    <center>    
        <br><a href="CadastrarSite.jsp">Cadastrar novo site</a>
    </center>
    </body>
</html>
