package com.mycompany.supermartendal.entities;

public class Pagamento {

    FormaPagamento formaPagamento;
    double valorTotal;
    int qtdeParcelas;

    public Pagamento() {
        
    }
    
    public String finalizarPedido(FormaPagamento formaPagamento, double valorTotal, int qtdeParcelas){
        double valorParcela;
        if (formaPagamento == FormaPagamento.credito) {
            valorParcela = this.valorTotal / this.qtdeParcelas;
            if (valorParcela < 20.0 ) {
                return "Valor de parcela menor que R$ 20,00.";
            } else {
                return "Pagamento realizado com sucesso.";
            }
        } 
        return "Pagamento realizado com sucesso.";
    } 
}
