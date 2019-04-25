<%-- 
    Document   : CadastrarPromocao.jsp
    Created on : 22/04/2019, 09:28:34
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
        <h1>Promoções</h1>
    </center>
    <div align="center">
        <c:if test="${promocao != null}"> 
            <form action="atualizarPromocao" method="post">
            </c:if>
            <c:if test="${promocao == null}">
                <form action="inserirPromocao" method="post">
                </c:if>
                <form name="form">
                    <table border="1" cellpadding="5">
                        <caption>
                            <h2>
                                <c:if test="${promocao != null}">
                                    Edição
                                    <input type="hidden" name="url" value="<c:out value='${promocao.url}' />"/> 
                                    <input type="hidden" name="cnpj" value="<c:out value='${promocao.cnpj}' />"/>
                                    <input type="hidden" name="data" value="<c:out value='${promocao.data}'/>"/>                                
                                </c:if>
                                <c:if test="${promocao == null}">
                                    Cadastro    
                                    <tr>
                                        <th>URL do site: </th>
                                        <td>
                                            <input type="text" name="url" size="45" required
                                                   value= "<c:out value='${promocao.url}' />"       
                                                   />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>CNPJ do teatro: </th>
                                        <td>
                                            <input type="text" name="cnpj" size="45" required
                                                   value= "<c:out value='${promocao.cnpj}' />"
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Data: </th>
                                        <td>
                                            <input type="date" name="data" size="45" required
                                                   value= "<c:out value='${promocao.data}' />"
                                                   />
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>Horario: </th>
                                        <td>
                                            <input type="time" name="data" size="45" required
                                                   value= "<c:out value='${promocao.data}' />"
                                                   />
                                        </td>
                                    </tr>
                                </c:if>
                            </h2>
                        </caption>
                        <tr>
                            <th>Nome da peça: </th>
                            <td>
                                <input type="text" name="nome" size="45" required
                                       value= "<c:out value='${promocao.nome}' />"
                                       />
                            </td><br>
                        </tr>
                        <tr>
                            <th>Preço: </th>
                            <td>
                                <input type="number" name="preco" size="45" required
                                       value= "<c:out value='${promocao.preco}' />"
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
            <c:if test='${mensagem_insercao}'>
                    <script>
                        alert("O cadastro falhou pois o teatro e/ou o site já possuem promocao neste horário");
                    </script>
            </c:if>
    </body>
</html>
