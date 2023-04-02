package com.mycompany.supermartendal.entities;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    private List<Produto> produtosPedido;
    private double valorTotal;
    
    public Pedido() {
        this.produtosPedido = new ArrayList();
        this.valorTotal = 0.00;
    }

    public boolean inserirProduto(Produto novoProduto){
        if(novoProduto.getNome().isEmpty() || novoProduto.getValor() <= 0)
            return false;
        produtosPedido.add(novoProduto);
        atualizaValor();
        return true;
    }
    
    public boolean excluirProduto(Produto produto){
        for (Produto item : produtosPedido) {
            if(produto.equals(item)){
                this.produtosPedido.remove(item);
                atualizaValor();
                return true;
            }
        }
        return false;
    }
    
    public List<Produto> getProdutosPedido() {
        return produtosPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    
    public void atualizaValor(){
        valorTotal = 0.00;
        for (Produto item : produtosPedido) {
            valorTotal = valorTotal + item.getValor();
        }
    }
    
}
