package com.mycompany.supermartendal.controller;

import com.mycompany.supermartendal.entities.FormaPagamentoEnum;
import com.mycompany.supermartendal.entities.Pagamento;
import com.mycompany.supermartendal.entities.Pedido;
import com.mycompany.supermartendal.entities.Produto;
import java.util.List;

public class PedidoController {

    private Pedido pedido;
    private Pagamento pagamento;
    
    public PedidoController() {
        pedido = new Pedido();
        pagamento = new Pagamento();
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
    
    public double retornaValorTotal() {
       double result = this.pedido.getValorTotal();
       return result;
    }
    
    public List<Produto> retornaProdutosPedido() {
       List result = this.pedido.getProdutosPedido();
       return result;
    }
 
    public List<String> realizaParcelamento(){
        return pagamento.calcularParcelas(retornaValorTotal());
    }
    
    public String processaPagamento(FormaPagamentoEnum formaPagamento, int qtdeParcelas) {
       return pagamento.finalizarPedido(formaPagamento, retornaValorTotal(), qtdeParcelas);
    }
    
}
