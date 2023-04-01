package com.mycompany.supermartendal.controller;

import com.mycompany.supermartendal.entities.FormaPagamentoEnum;
import com.mycompany.supermartendal.entities.Pedido;
import com.mycompany.supermartendal.entities.Produto;

public class PedidoController {

    private Pedido pedido;
    
    public PedidoController() {
        pedido = new Pedido();
    }
    
    public String adicionarProduto(Produto produto){
        boolean result = this.pedido.inserirProduto(produto);
        
        if(result) return "Produto inserido no pedido com sucesso.";
        else return "Erro ao inserir produto no pedido.";
    }
    
    public String excluirProduto(Produto produto) {
       boolean result = this.pedido.excluirProduto(produto);
       
       if(result) return "Produto excluído do pedido com sucesso.";
       else return "Erro ao excluir produto do pedido.";
    }
    
    public String fecharPedido(FormaPagamentoEnum formaPagamento) {
       boolean result = this.pedido.setTipoPagamento(formaPagamento);
       
       if(result) return "Pedido fechado com sucesso.";
       else return "Erro ao registrar forma de pagamento.";
    }
    
    public double retornaValorTotal() {
       double result = this.pedido.getValorTotal();
       
       return result;
    }
    
}
