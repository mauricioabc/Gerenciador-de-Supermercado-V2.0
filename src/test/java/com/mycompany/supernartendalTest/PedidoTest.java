package com.mycompany.supernartendalTest;

import com.mycompany.supermartendal.controller.PedidoController;
import com.mycompany.supermartendal.entities.Produto;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alunolages
 */
public class PedidoTest {
    
    public PedidoTest() {
    }

     @Test
     public void deve_inserir_produto_no_pedido() {
       PedidoController controller = new PedidoController();
       Produto novoProduto = new Produto("PC Positivo", 200);
       
       String result = controller.adicionarProduto(novoProduto);
       
       assertEquals("Produto inserido no pedido com sucesso.", result);
     }
     
     @Test
     public void deve_retornar_erro_ao_inserir_produto_com_valor_zerado_no_pedido() {
       PedidoController controller = new PedidoController();
       Produto novoProduto = new Produto("PC Positivo", 0);
       
       String result = controller.adicionarProduto(novoProduto);
       
       assertEquals("Erro ao inserir produto no pedido.", result);
     }
     
     @Test
     public void deve_retornar_erro_ao_inserir_produto_com_valor_negativo_no_pedido() {
       PedidoController controller = new PedidoController();
       Produto novoProduto = new Produto("PC Positivo", -100);
       
       String result = controller.adicionarProduto(novoProduto);
       
       assertEquals("Erro ao inserir produto no pedido.", result);
     }
     
     @Test
     public void deve_retornar_erro_ao_inserir_produto_sem_nome_no_pedido() {
       PedidoController controller = new PedidoController();
       Produto novoProduto = new Produto("", 200);
       
       String result = controller.adicionarProduto(novoProduto);
       
       assertEquals("Erro ao inserir produto no pedido.", result);
     }
     
     @Test
    public void deve_retornar_os_produtos_do_pedido(){
        PedidoController controller = new PedidoController();
        Produto produto = new Produto("PC Positivo", 200);
        controller.adicionarProduto(produto);
        produto = new Produto("PC Positivo", 300);
        controller.adicionarProduto(produto);
        
        List result = controller.retornaProdutosPedido();
        assertEquals(2, result.size());
    }
     
    @Test
    public void deve_excluir_produto_no_pedido(){
       PedidoController controller = new PedidoController();
       Produto produtoExcluido = new Produto("PC Positivo", 200);
       controller.adicionarProduto(produtoExcluido);
       
       String result = controller.excluirProduto(produtoExcluido);
       
       assertEquals("Produto excluído do pedido com sucesso.", result);
    }
    
    @Test
    public void deve_retornar_erro_ao_excluir_produto_no_pedido(){
       PedidoController controller = new PedidoController();
       Produto produto = new Produto("PC Positivo", 200);
       controller.adicionarProduto(produto);
       Produto produtoExcluir = new Produto("Mouse Positivo", 100);
       
       String result = controller.excluirProduto(produtoExcluir);
       
       assertEquals("Erro ao excluir produto do pedido.", result);
    }
    
    @Test
    public void deve_retornar_valor_produtos(){
        PedidoController controller = new PedidoController();
        Produto produto = new Produto("PC Positivo", 200);
        controller.adicionarProduto(produto);
        produto = new Produto("PC Positivo", 300);
        controller.adicionarProduto(produto);
        
        double result = controller.retornaValorTotal();
        assertEquals(500.0, result);
    }
    
    @Test
    public void deve_retornar_valor_total_do_pedido_apos_edicoes(){
        PedidoController controller = new PedidoController();
        Produto produto = new Produto("PC Positivo", 200);
        controller.adicionarProduto(produto);
        produto = new Produto("PC Positivo", 300);
        controller.excluirProduto(produto);
        
        double result = controller.retornaValorTotal();
        assertEquals(200.0, result);
    }
     
}
