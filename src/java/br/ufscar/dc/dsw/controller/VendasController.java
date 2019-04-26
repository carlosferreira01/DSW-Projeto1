/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.VendasDAO;
import br.ufscar.dc.dsw.model.Vendas;
import java.io.IOException;
import java.util.List;
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
@WebServlet(urlPatterns = {"/VendasController"})
public class VendasController extends HttpServlet {
    private VendasDAO dao;
    
    @Override
    public void init(){
    dao = new VendasDAO();
    }
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch(action){
            case "/cadastrarSite":
                apresentaForm(request,response);
                break;
            case "/editarSite":
                apresentaFormEdicao(request,response);
            case "/inserirSite":
                insere(request,response);
                break;
            case "/removerSite":
                remove(request,response);
                break;
            case "/atualizarSite":
                atualize(request,response);
                break;
            default:
                lista(request,response);
                                      
        }
    }

    public void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Vendas> lista = dao.getAll();
        request.setAttribute("listarSites", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarSites.jsp");
        dispatcher.forward(request,response); 
    }
    public void apresentaForm(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarSite.jsp");
        dispatcher.forward(request,response);
    }
    
    public void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String url = request.getParameter("url");
        Vendas site = dao.getFromURL(url);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarSite.jsp");
        request.setAttribute("site",site);
        dispatcher.forward(request,response);       
    }
    
   public void insere(HttpServletRequest request, HttpServletResponse response)throws IOException{
       String email = request.getParameter("email");
       String senha = request.getParameter("senha");
       String url = request.getParameter("url");
       String nome = request.getParameter("nome");
       String telefone = request.getParameter("telefone");
       
       Vendas site = new Vendas(email,senha,url,nome,telefone);
       dao.insert(site);
       response.sendRedirect("listarSite.jsp");
   }
   public void remove(HttpServletRequest request, HttpServletResponse response)throws IOException{
       String url = request.getParameter("url");
       Vendas site = new Vendas();
       site.setUrl(url);
       dao.delete(site);
       response.sendRedirect("listarSite.jsp");
   }
   
   public void atualize(HttpServletRequest request, HttpServletResponse response)throws IOException{
       String email = request.getParameter("email");
       String senha = request.getParameter("senha");
       String nome = request.getParameter("nome");
       String url = request.getParameter("url");
       String telefone = request.getParameter("telefone");
       Vendas site = new Vendas(email,senha,url,nome,telefone);
       dao.update(site);
       response.sendRedirect("listarSite.jsp");
   }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    doGet(request, response);
    }
}
