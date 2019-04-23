/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.model.Promocao;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos
 */
@WebServlet(urlPatterns = {"/PromocaoController"})
public class PromocaoController extends HttpServlet {
    private PromocaoDAO dao = new PromocaoDAO();
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
             String action = request.getServletPath();
             switch(action){
                 case "/inserirPromocao":
                     insere(request,response);
                     break;
                 case "/atualizarPromocao":
                     update(request,response);
                     break;
                 case "/removerPromocao":
                     remove(request,response);
                     break;
                 case "/cadastrarPromocao":
                     apresentaForm(request,response);
                     break;
                 case "/editaroPromocao":
                     apresentaFormEdicao(request,response);
                     break;
                 case "/listarTeatro":
                     listTeatro(request,response);
                     break;
                 default:
                     list(request,response);
                     
             }
         
        }catch(SQLException ex) {
             Logger.getLogger(PromocaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void apresentaForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("CadastrarPromocao.jsp");
        dispatcher.forward(request, response);
    
    }
    
    public void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("CadastrarPromocao.jsp");
        String url = request.getParameter("url");
        String CNPJ = request.getParameter("cnpj");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
        String data = request.getParameter("data");
        Date hora = dateFormat.parse(data);
        Promocao promocao = dao.getFromKey(url, CNPJ,hora);
        request.setAttribute("promocao",promocao);
        dispatcher.forward(request,response);
        
      //imcompleto  
    }
    
    public void insere(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException, SQLException, ServletException{
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        String nome = request.getParameter("nome");
        float preco = parseFloat(request.getParameter("preco"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String data = request.getParameter("data");
        data += " " + request.getParameter("data");
        Date horario = dateFormat.parse(data);
        if(dao.checkValidity(url, cnpj, horario)){
        Promocao promocao = new Promocao(url,cnpj,nome,preco,horario);
        dao.insert(promocao);
        response.sendRedirect("PromocaoController");
        }
        else{
        RequestDispatcher dispatcher = request.getRequestDispatcher("CadastrarPromocao.jsp");
        request.setAttribute("mensagem_insercao",true);
        dispatcher.forward(request, response);
        }
    }
    
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        String nome = request.getParameter("nome");
        float preco = parseFloat(request.getParameter("preco"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
        String hora = request.getParameter("data");
        Date data = dateFormat.parse(hora);   
        Promocao promocao = new Promocao(url,cnpj,nome,preco,data);
        dao.update(promocao);
        response.sendRedirect("PromocaoController");
    }
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
        //incompleto
        String url = request.getParameter("url");
        String cnpj = request.getParameter("cnpj");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
        String hora = request.getParameter("data");
        Date data = dateFormat.parse(hora);    
        Promocao promocao = new Promocao();
        promocao.setData(data);
        promocao.setCnpj(cnpj);
        promocao.setUrl(url);

        dao.delete(promocao);
        response.sendRedirect("PromocaoController");

    }
   
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //incompleto
        List<Promocao> lista = dao.getAll();
        request.setAttribute("ListaPromocao", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListarPromocao.jsp");
        dispatcher.forward(request,response);
    }
   
   public void listTeatro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String cnpj = request.getParameter("cnpj");
        List<Promocao> lista = dao.getFromCnpj(cnpj);
        request.setAttribute("ListarPromocaoFeitoPorTeatro", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListarPromocaoFeitoPorTeatro.jsp");
        dispatcher.forward(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
