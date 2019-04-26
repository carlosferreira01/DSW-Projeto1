<%-- 
    Document   : CadastrarSites.jsp
    Created on : 22/04/2019, 09:46:05
    Author     : carlos
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Ingressos</title>
    </head>
    <body>
    <center>
        <h1>Sites de Vendas</h1>
    </center>
    <div align="center">
        <c:if test="${site != null}"> 
            <form action="atualizarSite" method="post">
            </c:if>
            <c:if test="${site == null}">
                <form action="inserirSite" method="post">
                </c:if>
                <form name="form">
                    <table border="1" cellpadding="5">
                        <caption>
                            <h2>
                                <c:if test="${site != null}">
                                    Edição
                                    <input type="hidden" name="url" value="<c:out value='${site.url}' />" 
                                           />
                                </c:if>
                                <c:if test="${site == null}">
                                    Cadastro   
                                <tr>
                                    <th>E-mail: </th>
                                    <td>
                                        <input type="text" name="email" size="45" required
                                               value= "<c:out value='${site.email}' />"
                                               />
                                    </td>
                                </tr>
                                </c:if>
                                <tr>
                                    <th>Senha: </th>
                                    <td>
                                        <input type="password" name="senha" size="45" required
                                               value= "<c:out value='${site.senha}' />"       
                                               />
                                    </td>    
                                </tr>
                                    <tr>
                                        <th>URL: </th>
                                        <td>
                                            <input type="text" name="url" size="45" required
                                                   value= "<c:out value='${site.url}' />"       
                                                   />
                                        </td>
                                    </tr>
                                <tr>
                                    <th>Nome: </th>
                                    <td>
                                        <input type="text" name="nome" size="45" required
                                               value= "<c:out value='${site.nome}' />"
                                               />
                                    </td><br>
                                </tr>


                                <tr>
                                    <th>Telefone: </th>
                                    <td>
                                        <input type="text" name="telefone" size="45"
                                               placeholder="xxxxx-xxxx" required
                                               value= "<c:out value='${site.telefone}' />"       
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
