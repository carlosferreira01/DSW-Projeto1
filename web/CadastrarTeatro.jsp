<%-- 
    Document   : CadastrarTeatro.jsp
    Created on : 22/04/2019, 08:28:23
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
    <center>
        <h1>Salas de Teatro</h1>
    </center>
    <div align="center">
        <c:if test="${sala != null}"> 
            <form action="atualizacaoTeatro" method="post">
            </c:if>
            <c:if test="${sala == null}">
                <form action="insercaoTeatro" method="post">
                </c:if>
                <form name="form">
                    <table border="1" cellpadding="5">
                        <caption>
                            <h2>
                                <c:if test="${sala != null}">
                                    Edição
                                    <input type="hidden" name="cnpj" value="<c:out value='${sala.cnpj}' />" 
                                           />
                                </c:if>
                                <c:if test="${sala == null}">
                                    Cadastro    
                                    <tr>
                                        <th>CNPJ: </th>
                                        <td>
                                            <input type="text" name="cnpj" size="45" 
                                                   placeholder="xx.xxx.xxx/xxxx-xx" required
                                                   value= "<c:out value='${sala.CNPJ}' />"       
                                                   />
                                        </td>
                                    </tr>
                                </c:if>
                            </h2>
                        </caption>
                        <tr>
                            <th>Nome: </th>
                            <td>
                                <input type="text" name="nome" size="45" required
                                       value= "<c:out value='${sala.nome}' />"
                                       />
                            </td><br>
                        </tr>
                        <tr>
                            <th>Cidade: </th>
                            <td>
                                <input type="text" name="cidade" size="45" required
                                       value= "<c:out value='${sala.cidade}' />"       
                                       />
                            </td>
                        </tr>
                        <tr>
                            <th>E-mail: </th>
                            <td>
                                <input type="text" name="email" size="45" required
                                       value= "<c:out value='${sala.email}' />"
                                       />
                            </td>
                        </tr>
                        <tr>
                            <th>Senha: </th>
                            <td>
                                <input type="password" name="senha" size="45" required
                                       value= "<c:out value='${sala.senha}' />"       
                                       />
                            </td>    
                        </tr>
                    </table>  
                    <br>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Cadastrar" />
                        </td>
                    </tr>
                </form>
    </div>
    </body>
</html>
