package com.mycompany.supermartendal.entities;

import java.util.ArrayList;
import java.util.List;

public class Pagamento {

    public Pagamento() {
        
    }
    
    public List<String> calcularParcelas(double valorTotal) {
        List<String> parcelas = new ArrayList<>();
        int maxParcelas = 12;
        double parcelaMinima = 20.0;
        for (int i = 1; i <= maxParcelas; i++) {
            double valorParcela = valorTotal / i;
            if (valorParcela > parcelaMinima) {
                parcelas.add(i + "x de R$ " + String.format("%.2f", valorParcela));
            }
        }
        return parcelas;
    }
    
    public String finalizarPedido(FormaPagamentoEnum formaPagamento, double valorTotal, int qtdeParcelas){
        double valorParcela;
        if (formaPagamento == FormaPagamentoEnum.credito) {
            valorParcela = valorTotal / qtdeParcelas;
            if (valorParcela < 20.0 ) {
                return "Valor de parcela menor que R$ 20,00.";
            } else {
                return "Pagamento realizado com sucesso.";
            }
        } 
        return "Pagamento realizado com sucesso.";
    } 
}
