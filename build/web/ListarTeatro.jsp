<%-- 
    Document   : ListarTeatro
    Created on : 22/04/2019, 09:49:12
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
            <caption><h2>Lista Salas</h2></caption>
            <tr>
                <th>CNPJ</th>
                <th>Nome</th>
                <th>Cidade</th>
                <th>Ações</th>
          
            </tr>
            <c:forEach var="sala" items="${requestScope.ListaTeatros}">
                <tr>
                    <td><c:out value="${sala.cnpj}" /></td>
                    <td><c:out value="${sala.nome}" /></td>
                    <td><c:out value="${sala.cidade}" /></td>
                  
                    <td>
                        <a href="edicaoTeatro?CNPJ=<c:out value='${sala.cnpj}' />">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocaoTeatro?CNPJ=<c:out value='${sala.cnpj}' />" 
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção
                        </a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
        
    <center>    
        <br><a href="CadastrarTeatro.jsp">Cadastrar nova sala</a>
    </center>
    </body>
</html>
