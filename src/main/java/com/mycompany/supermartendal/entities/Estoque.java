package com.mycompany.supermartendal.entities;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> listaProdutos;

    public Estoque() {
        this.listaProdutos = new ArrayList<Produto>();
    }
    public boolean inserir(Produto novoProduto){
        if(novoProduto.getNome().isEmpty() || novoProduto.getValor() <= 0)
            return false;
            
        listaProdutos.add(novoProduto);
        return true;
    }
    public boolean editar(Produto produtoAntigo, Produto novoProduto){
        if(novoProduto.getNome().isEmpty() || novoProduto.getValor() <= 0)
            return false;
        
        for (Produto item : listaProdutos) {
            if(produtoAntigo.equals(item)){
                this.listaProdutos.remove(item);
                this.listaProdutos.add(novoProduto);
                return true;
            }
        }
        
        return false;
    }
    public boolean excluir(Produto produto){
        for (Produto item : listaProdutos) {
            if(produto.equals(item)){
                this.listaProdutos.remove(item);
                return true;
            }
        }

        return false;
    }
    
    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

}
