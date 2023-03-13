/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermartendal.controller;

import com.mycompany.supermartendal.entities.Estoque;
import com.mycompany.supermartendal.entities.Produto;
import java.util.ArrayList;
import java.util.List;

public class EstoqueController {
    private List<Produto> listaProdutos;
    private Estoque estoque;

    public EstoqueController() {
        this.listaProdutos = new ArrayList<Produto>();
        this.estoque = new Estoque();
    }
    
    public String inserir(Produto produto){
        boolean result = this.estoque.inserir(produto);
        
        if(result) return "Produto inserido com sucesso.";
        else return "Erro ao inserir produto.";
    }
  
    public String editar(Produto produtoAntigo, Produto novoProduto) {
        boolean result = this.estoque.editar(produtoAntigo, novoProduto);
        
        if(result) return "Produto editado com sucesso.";
        else return "Erro ao editar produto.";
    }
    
    public String excluir(Produto produto) {
       boolean result = this.estoque.excluir(produto);
       
       if(result) return "Produto excluído com sucesso.";
       else return "Erro ao excluir produto.";
    }
    
     public List<Produto> retornarEstoque() {
        return this.estoque.getListaProdutos();
    }
    
}
