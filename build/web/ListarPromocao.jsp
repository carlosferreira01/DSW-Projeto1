<%-- 
    Document   : ListarPromocao
    Created on : 22/04/2019, 09:57:53
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda de Ingressos</title>
    </head>
    <body>
        
        <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista promoções</h2></caption>
            <tr>
                <th>URL</th>
                <th>CNPJ</th>
                <th>Nome</th>
                <th>Data</th>
                <th>Preço</th>
                <th>Ações</th>
          
            </tr>
            <c:forEach var="promocao" items="${requestScope.ListaPromocao}">
                <tr>
                    <td><c:out value="${promocao.url}" /></td>
                    <td><c:out value="${promocao.cnpj}" /></td>
                    <td><c:out value="${promocao.nome}" /></td>
                    <td><c:out value="${promocao.horario}" /></td>
                    <td><c:out value="${promocao.preco}" /></td>
                  
                    <td>
                        <a href="edicaoPromocao?cnpj=<c:out value='${promocao.cnpj}' />&url=<c:out value='${promocao.url}'/>&horario=<c:out value='${promocao.horario}'/>">Edição</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocaoPromocao?cnpj=<c:out value='${promocao.cnpj}' />&url=<c:out value='${promocao.url}'/>&horario=<c:out value='${promocao.horario}'/>" 
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            Remoção
                        </a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
        
    <center>    
        <br><a href="CadastroPromocao.jsp">Cadastrar nova promoção</a>
    </center>
    </body>
</html>
