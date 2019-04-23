/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Teatro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class TeatroDAO {
    public TeatroDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Projeto1", "root", "root");
    }
    public void insert(Teatro teatro) {
        String sql = "INSERT INTO Teatro (email, senha, cnpj, nome, cidade)VALUES (?, ?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setString(3, teatro.getCnpj());
            statement.setString(4, teatro.getNome());
            statement.setString(5, teatro.getCidade());
            
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Teatro> getAll() {
        List<Teatro> listaTeatro = new ArrayList<>();
        String sql = "SELECT * FROM Teatro";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String cnpj = resultSet.getString("cnpj");
                String cidade= resultSet.getString("cidade");
                String telefone = resultSet.getString("telefone");
                Teatro teatro = new Teatro(email, senha, cnpj, cidade, telefone);
                listaTeatro.add(teatro);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTeatro;
    }
    
    public Teatro getFromCnpj(String CNPJ) {
        Teatro sala = null;
        String sql = "SELECT * FROM Teatro WHERE CNPJ = ?";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, CNPJ);
            ResultSet resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                
                sala = new Teatro(CNPJ, email, senha, nome, cidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return sala;
    }
        
    public void delete(Teatro sala) {
        String sql = "DELETE FROM Teatro WHERE CNPJ = ?";
    try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, sala.getCnpj());
            statement.executeUpdate();
            statement.close();
            conn.close();
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void update(Teatro teatro) {
        String sql = "UPDATE Teatro SET "
                + "email = ?, "
                + "senha = ?, "
                + "nome = ?, "
                + "cidade = ? "
                + "WHERE CNPJ = ?";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, teatro.getEmail());
            statement.setString(2, teatro.getSenha());
            statement.setString(3, teatro.getCnpj());
            statement.setString(4, teatro.getNome());
            statement.setString(5, teatro.getCidade());
            statement.executeUpdate();
            
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
