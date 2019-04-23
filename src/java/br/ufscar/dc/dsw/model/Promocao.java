/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.model;

import java.util.Date;

/**
 *
 * @author carlos
 */
public class Promocao {
    private String nome;
    private String cnpj;
    private String url;
    private float preco;
    private Date data;
    
    public Promocao(String nome, String cnpj, String url, float preco, Date data) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.url = url;
    this.preco = preco;
    this.data = data;
    }

    public Promocao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     * @return the data_sessao
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data_sessao the data_sessao to set
     */
    public void setData(Date data_sessao) {
        this.data = data_sessao;
    }
}
