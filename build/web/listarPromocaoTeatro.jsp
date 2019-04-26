<%-- 
    Document   : listaPromocaoTeatro
    Created on : 26/04/2019, 20:00:00
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<f:bundle basename="i18n.mensagens">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><f:message key="page.title" /></title>
    </head>
    <body>

        <div align="center">
            <c:if test="${promocao != null}"> 
                <form action="listaTeatro" method="post">
                </c:if>
                <c:if test="${promocao == null}">
                    <form action="listaTeatro" method="post">
                    </c:if>
                        <c:if test="${promocao != null}">
                                    <f:message key="edit.title" />
                                    <input type="hidden" name="url" value="<c:out value='${promocao.url}' />"/> 
                                    <input type="hidden" name="CNPJ" value="<c:out value='${promocao.cnpj}' />"/>
                                    <input type="hidden" name="horario" value="<c:out value='${promocao.horario}'/>"/>                                
                                </c:if>
                    <caption><h2><f:message key="listpromo.title" /></h2></caption>
                    <br><br><tr>
                        
                    <p><f:message key="cnpj.message" /></p>
                        <th><f:message key="cnpj.label" /> </th>
                        <td>
                            <input type="text" name="CNPJ" size="15" required
                                   value= "<c:out value='${promocao.cnpj}' />"
                                   />
                        </td><br>
                    </tr><br>
                    <table border="1" cellpadding="5">
                        <input type="hidden"
                               name="${_csrf.parameterName}"
                               value="${_csrf.token}"/> 
                        <tr>
                            <th><f:message key="url.label" /></th>
                            <th><f:message key="name.label" /></th>
                            <th><f:message key="date.label" /></th>
                            <th><f:message key="price.label" /></th>
                            <th><f:message key="action.label" /></th>

                        </tr>
                        <c:forEach var="promocao" items="${requestScope.ListaPromocaoTeatro}">
                            <tr>
                                <td><c:out value="${promocao.url}" /></td>
                                <td><c:out value="${promocao.nome}" /></td>
                                <td><c:out value="${promocao.horario}" /></td>
                                <td><c:out value="${promocao.preco}" /></td>

                                <td>
                                    <a href="edicaoPromocao?CNPJ=<c:out value='${promocao.cnpj}' />&url=<c:out value='${promocao.url}'/>&horario=<c:out value='${promocao.horario}'/>&listaByTeatro=true"><f:message key="edit.title" /></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="remocaoPromocao?CNPJ=<c:out value='${promocao.CNPJ}' />&url=<c:out value='${promocao.url}'/>&horario=<c:out value='${promocao.horario}'/>&listaByTeatro=true" 
                           onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                            <f:message key="remove.label" />
                        </a>                    	
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                    <br><tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="<f:message key="search.label" />" />
                        </td>
                    </tr>
                    </div>

                    <center>    
                        <br><a href="cadastrarPromocao.jsp"><f:message key="newregister.label" /></a>
                    </center>
                    </body>
</f:bundle>
                    </html>

