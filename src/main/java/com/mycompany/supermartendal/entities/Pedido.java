package com.mycompany.supermartendal.entities;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    private List<Produto> produtosPedido;
    private double valorTotal;
    int tipoPagamento;

    public Pedido() {
        this.produtosPedido = new ArrayList<Produto>();
        this.valorTotal = 0.00;
    }

    public boolean inserir(Produto novoProduto){
        if(novoProduto.getNome().isEmpty() || novoProduto.getValor() <= 0)
            return false;
            
        produtosPedido.add(novoProduto);
        atualizaValor();
        return true;
    }
    public boolean editar(Produto produtoAntigo, Produto novoProduto){
        if(novoProduto.getNome().isEmpty() || novoProduto.getValor() <= 0)
            return false;
        
        for (Produto item : produtosPedido) {
            if(produtoAntigo.equals(item)){
                this.produtosPedido.remove(item);
                this.produtosPedido.add(novoProduto);
                atualizaValor();
                return true;
            }
        }
        
        return false;
    }
    public boolean excluir(Produto produto){
        for (Produto item : produtosPedido) {
            if(produto.equals(item)){
                this.produtosPedido.remove(item);
                return true;
            }
            atualizaValor();
        }

        return false;
    }
    
    public List<Produto> getProdutosPedido() {
        return produtosPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public boolean setTipoPagamento(int tipoPagamento) {
        if(this.produtosPedido.isEmpty())
            return false;
        this.tipoPagamento = tipoPagamento;
        return true;
    }
    
    public void atualizaValor(){
        valorTotal = 0.00;
        for (Produto item : produtosPedido) {
            valorTotal = valorTotal + item.getValor();
        }
    }
    
}
