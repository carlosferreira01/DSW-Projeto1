<%-- 
    Document   : index
    Created on : 23/04/2019, 15:37:19
    Author     : carlos
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<f:bundle basename="i18n.mensagens">
<html>
     <head>
        <title>Site de Vendas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <center>
        <h1><f:message key="avaliacao.title" /></h1>
		
                        <div style="margin-top: 110px;"> 
                            <h3>
                                Sites
                            </h3>
			<a href="cadastrarSite.jsp"><font face="verdana" size="4" color="red"></font><f:message key="register.title" /></a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="listarSite.jsp"><f:message key="list.title" /></a>
                        </div>
			
			<div style="margin: 30px;">
                            <h3>
                                <f:message key="promo.title" />
                            </h3>
			<a href="cadastrarPromocao.jsp"><font face="verdana" size="4" color="red"></font><f:message key="register.title" /></a>
			&nbsp;&nbsp;&nbsp;
                        <a href="listarPromocao.jsp"><f:message key="list.title" /></a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="listarPromocaoTeatro.jsp"><f:message key="search.label" /></a>
                        </div>
			
			<div style="margin: 30px;">
                            <h3>
                                <f:message key="sala.title" />
                            </h3>
			<a href="cadastrarTeatro.jsp"><font face="verdana" size="4" color="red"></font><f:message key="register.title" /></a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="listarTeatro.jsp"><f:message key="list.title" /></a>
                        </div>
            
        </center>
    </body>
</f:bundle>

