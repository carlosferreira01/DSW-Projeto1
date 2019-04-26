/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.model.Teatro;
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
@WebServlet(name = "TeatroController", urlPatterns = {"/TeatroController"})
public class TeatroController extends HttpServlet {
private TeatroDAO dao = new TeatroDAO();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch(action){
            case "/cadastrarTeatro":
                apresentaForm(request,response);
                break;
            case "/editarTeatro":
                apresentaFormEdicao(request,response);
                break;
            case "/inserirTeatro":
                insere(request,response);
                break;
            case "/removerTeatro":
                remove(request,response);
                break;
            case "/atualizarTeatro":
                atualize(request,response);
                break;
            
            default:
                lista(request,response);
        
        }
    }
 
    public void lista(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        List<Teatro> lista = dao.getAll();
        request.setAttribute("listarTeatro", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response); 
    }
    
    
    public void apresentaForm(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarTeatro.jsp");
        dispatcher.forward(request,response);
    }
    public void apresentaFormEdicao(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarTeatro.jsp");
        String CNPJ = request.getParameter("cnpj");
        Teatro teatro = dao.getFromCnpj(CNPJ);
        request.setAttribute("teatro",teatro);
        dispatcher.forward(request, response);
    }
    
    public void insere(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String cnpj = request.getParameter("cnpj");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String cidade = request.getParameter("cidade");
        String nome = request.getParameter("nome");
        
        Teatro sala = new Teatro(email,senha,cnpj,nome,cidade);
        dao.insert(sala);
        response.sendRedirect("listarTeatro.jsp");
    }
    
    public void remove(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String cnpj = request.getParameter("CNPJ");
        Teatro sala = dao.getFromCnpj(cnpj);
        dao.delete(sala);
        response.sendRedirect("TeatroController");
    }
    
    public void atualize(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String cnpj = request.getParameter("cnpj");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String cidade = request.getParameter("cidade");
        String nome = request.getParameter("nome");
        
        Teatro sala = new Teatro(email,senha,cnpj,nome,cidade);
        dao.update(sala);
        response.sendRedirect("TeatroController");
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

