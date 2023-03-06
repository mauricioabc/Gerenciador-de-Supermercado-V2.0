package com.supermarket.market;

public class Produto {
    private String Produto;
    private String Marca;
    private String Descricao;
    private String setor;
    private double Valor;
    private int qtde;

    public Produto(String Produto, String Marca, String Descricao, String setor, double Valor) {
        this.Produto = Produto;
        this.Marca = Marca;
        this.Descricao = Descricao;
        this.setor = setor;
        this.Valor = Valor;
    }
    
    public Produto(String Produto, String Marca, String Descricao, String setor, double Valor, int qtde) {
        this.Produto = Produto;
        this.Marca = Marca;
        this.Descricao = Descricao;
        this.setor = setor;
        this.Valor = Valor;
        this.qtde = qtde;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String Produto) {
        this.Produto = Produto;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
    
    @Override
    public String toString() {
        return "Produto{" + "Produto=" + Produto + ", Marca=" + Marca + ", Descricao=" + Descricao + ", setor=" + setor + ", Valor=" + Valor + '}';
    }

}
