/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Promocao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author carlos
 */
public class PromocaoDAO {
    public PromocaoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Projeto1", "root", "root");
    }
    
    public void insert(Promocao promocao) {
        String sql = "INSERT INTO Promocao (nome, cnpj, url, preco, data) VALUES (?, ?, ?, ?, ?)";
        
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, promocao.getNome());
            statement.setString(2, promocao.getCnpj());
            statement.setString(3, promocao.getUrl());
            statement.setFloat(4, promocao.getPreco());
            statement.setDate(5, (java.sql.Date) (Date) promocao.getData());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Promocao> getAll() {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql = "SELECT * FROM Promocao";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cnpj = resultSet.getString("cnpj");
                String url = resultSet.getString("url");
                float preco= resultSet.getFloat("preco");
                Date data = resultSet.getDate("data");
                Promocao promocao = new Promocao(nome, cnpj, url, preco, data);
                listaPromocao.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocao;
    }
    
//    public void update(Promocao promocao) {
//        String sql = "UPDATE Promocao SET nome=?, cnpj=?, url=?, preco=?, =?, cnpj=? WHERE id=?"; 
//        try {
//            Connection conn = this.getConnection();
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, promocao.getNome());
//            statement.setString(2, promocao.getCnpj());
//            statement.setString(3, promocao.getUrl());
//            statement.setFloat(4, promocao.getPreco());
//            statement.setDate(5, (java.sql.Date) (Date) promocao.getData());
//
//            statement.close();
//            conn.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}

