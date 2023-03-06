package com.supermarket.market;

public class Supermercado {
    
    private String Nome, endereco, bairro, cidade, cep, cnpj, ie, telefone;

    public Supermercado(String Nome, String endereco, String bairro, String cidade, String cep, String cnpj, String ie, String telefone) {
        this.Nome = Nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.cnpj = cnpj;
        this.ie = ie;
        this.telefone = telefone;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Supermercado{" + "Nome=" + Nome + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + ", cnpj=" + cnpj + ", ie=" + ie + ", telefone=" + telefone + '}';
    }

}
