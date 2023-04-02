/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.supernartendalTest;

import com.mycompany.supermartendal.entities.Pedido;
import com.mycompany.supermartendal.controller.PedidoController;
import com.mycompany.supermartendal.entities.FormaPagamentoEnum;
import com.mycompany.supermartendal.entities.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
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
    public void deve_excluir_produto_no_pedido(){
       PedidoController controller = new PedidoController();
       Produto produtoExcluido = new Produto("PC Positivo", 200);
       controller.adicionarProduto(produtoExcluido);
       
       String result = controller.excluirProduto(produtoExcluido);
       
       assertEquals("Produto excluído do pedido com sucesso.", result);
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
     
}
