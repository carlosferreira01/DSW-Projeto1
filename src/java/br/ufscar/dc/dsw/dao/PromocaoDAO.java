package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Promocao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    public void update(Promocao promocao) {
        String sql = "UPDATE Promocao SET nome=?, cnpj=?, url=?, preco=?, =?, cnpj=? WHERE id=?"; 
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, promocao.getNome());
            statement.setString(2, promocao.getCnpj());
            statement.setString(3, promocao.getUrl());
            statement.setFloat(4, promocao.getPreco());
            statement.setDate(5, (java.sql.Date) (Date) promocao.getData());

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(Promocao promocao) {
      String sql = "DELETE FROM Promocao WHERE " + "url = ? AND cnpj= ? AND horario = ?";
      try {
        Connection conn = this.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        

        statement.setString(1, promocao.getUrl());
        statement.setString(2, promocao.getCnpj());
        statement.setTimestamp(3, new Timestamp(promocao.getData().getTime()));
        statement.executeUpdate();
        statement.close();
        conn.close();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    
    public boolean checkValidity(String url,String cnpj,Date data) throws SQLException{
        String sql = "SELECT * FROM Promocao WHERE (url = ? AND horario = ?) OR (cnpj = ? AND horario = ?)";
        try{
        Connection conn = this.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,url);
        statement.setString(3,cnpj);
        statement.setTimestamp(2, new Timestamp(data.getTime()));
        statement.setTimestamp(4, new Timestamp(data.getTime()));
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return false;
            }
        else{
            return true;
        }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Promocao getFromKey(String url,String cnpj,Date horario){
        Promocao promocao = new Promocao();
        String sql = "SELECT * FROM Promocao WHERE url = ? AND cnpj = ? AND horario = ?";
        try{
        Connection conn = this.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,url);
        statement.setString(2,cnpj);
        statement.setTimestamp(3, new Timestamp(horario.getTime()));
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
        String nome = resultSet.getString("nome");
        Float preco = resultSet.getFloat("preco");
        promocao.setCnpj(cnpj);
        promocao.setData(horario);
        promocao.setUrl(url);
        promocao.setNome(nome);
        promocao.setPreco(preco);
        }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return promocao;
    }
    
    public List<Promocao> getFromCnpj(String CNPJ){
       
            List<Promocao> promocoes = new ArrayList<>();
            String sql = "SELECT * FROM Promocao WHERE cnpj = ?";
             try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,CNPJ);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String url = resultSet.getString("url");
                String cnpj = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                float preco = resultSet.getFloat("preco");
                Date data = new Date(resultSet.getTimestamp("data").getTime());

                Promocao promocao = new Promocao(url, cnpj, nome, preco, data);
                promocoes.add(promocao);
            }
                 resultSet.close();
                 conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PromocaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return promocoes; 
    }
}

