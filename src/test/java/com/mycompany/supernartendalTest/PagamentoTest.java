package com.mycompany.supernartendalTest;

import com.mycompany.supermartendal.controller.PedidoController;
import com.mycompany.supermartendal.entities.FormaPagamentoEnum;
import com.mycompany.supermartendal.entities.Produto;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mauricio.rodrigues
 */
public class PagamentoTest {
    
    public PagamentoTest() {
    }

    @Test
    public void fechaCompraAVista() {
        PedidoController controller = new PedidoController();
        Produto produto = new Produto("PC Positivo", 200);
        controller.adicionarProduto(produto);
        produto = new Produto("PC Positivo", 300);
        controller.adicionarProduto(produto);
        
        String retorno = controller.processaPagamento(FormaPagamentoEnum.dinheiro, 5);
        assertEquals("Pagamento realizado com sucesso.", retorno);
     }
    
    @Test
    public void fazParcelamentoDeCompra_500ReaisEm5Vezes() {
        PedidoController controller = new PedidoController();
        Produto produto = new Produto("PC Positivo", 200);
        controller.adicionarProduto(produto);
        produto = new Produto("PC Positivo", 300);
        controller.adicionarProduto(produto);
        
        List retorno = controller.realizaParcelamento();
        assertEquals("5x de R$ 100,00", retorno.get(4));
    }
    
    @Test
    public void fazParcelamentoDeCompra_200ReaisEm2Vezes() {
        PedidoController controller = new PedidoController();
        Produto produto = new Produto("PC Positivo", 200);
        controller.adicionarProduto(produto);
        
        List retorno = controller.realizaParcelamento();
        assertEquals("2x de R$ 100,00", retorno.get(1));
    }
    
    @Test
    public void verificaTamanhoDoRetornoDosParcelamentosEmCompraPequena_200Reais() {
        PedidoController controller = new PedidoController();
        Produto produto = new Produto("PC Positivo", 200);
        controller.adicionarProduto(produto);
        
        List retorno = controller.realizaParcelamento();
        assertEquals(9, retorno.size());
    }
    
    @Test
    public void verificaTamanhoDoRetornoDosParcelamentosEmCompraGrande_1000Reais() {
        PedidoController controller = new PedidoController();
        Produto produto = new Produto("PC Positivo", 200);
        controller.adicionarProduto(produto);
        produto = new Produto("PC Positivo", 400);
        controller.adicionarProduto(produto);
        produto = new Produto("PC Positivo", 400);
        controller.adicionarProduto(produto);
        
        List retorno = controller.realizaParcelamento();
        assertEquals(12, retorno.size());
    }
    
    @Test
    public void fechaCompraParceladaCorretamente() {
        PedidoController controller = new PedidoController();
        Produto produto = new Produto("PC Positivo", 200);
        controller.adicionarProduto(produto);
        produto = new Produto("PC Positivo", 300);
        controller.adicionarProduto(produto);
        
        List retorno = controller.realizaParcelamento();
        assertEquals("5x de R$ 100,00", retorno.get(4));
        String returno2 = controller.processaPagamento(FormaPagamentoEnum.credito, 5);
        assertEquals("Pagamento realizado com sucesso.", returno2);
    }
    
    @Test
    public void erroAoFecharCompraParcelada_ParcelaMenorQue20Reais() {
        PedidoController controller = new PedidoController();
        Produto produto = new Produto("PC Positivo", 200);
        controller.adicionarProduto(produto);
        produto = new Produto("PC Positivo", 300);
        controller.adicionarProduto(produto);

        String returno2 = controller.processaPagamento(FormaPagamentoEnum.credito, 30);
        assertEquals("Valor de parcela menor que R$ 20,00.", returno2);
    }

}
