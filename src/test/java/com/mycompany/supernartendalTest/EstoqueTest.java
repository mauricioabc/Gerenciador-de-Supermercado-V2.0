/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.supernartendalTest;

import com.mycompany.supermartendal.controller.EstoqueController;
import com.mycompany.supermartendal.entities.Estoque;
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
public class EstoqueTest {
    
    public EstoqueTest() {
    }
   
    
    // Cenários Positivos
    @Test
    public void deve_inserir_produto(){
      
       EstoqueController controller = new EstoqueController();
       Produto novoProduto = new Produto("PC Positivo", 200);
       
       String result = controller.inserir(novoProduto);
       
       assertEquals("Produto inserido com sucesso.", result);
    }
    
    @Test
    public void deve_editar_produto(){
      
       EstoqueController controller = new EstoqueController();
       Produto produto = new Produto("PC Positivo", 200);
       controller.inserir(produto);
       
       Produto produtoEditado = new Produto("PC Positivo", 500);
       
       
       String result = controller.editar(produto, produtoEditado);
       
       assertEquals("Produto editado com sucesso.", result);
    }
    
    @Test
    public void deve_excluir_produto(){
      
       EstoqueController controller = new EstoqueController();
       Produto produto = new Produto("PC Positivo", 200);
       controller.inserir(produto);
            
       String result = controller.excluir(produto);
       
       assertEquals("Produto excluído com sucesso.", result);
    }
     
    
    @Test
    public void deve_retornar_os_produto_cadastrados(){
      
        EstoqueController controller = new EstoqueController();
        Produto produto1 = new Produto("PC Positivo", 200);
        Produto produto2 = new Produto("Impressora Multilaser", 100);
        Produto produto3 = new Produto("Celular LG", 400);
       
        controller.inserir(produto1);
        controller.inserir(produto2);
        controller.inserir(produto3);

        var result = controller.retornarEstoque();
       
        assertEquals(3, result.size());
    }
    // Cenários negativos
     
    @Test 
    public void deve_gerar_falha_ao_tentar_inserir_produto_sem_nome(){
        EstoqueController controller = new EstoqueController();
        Produto novoProduto = new Produto("", 200);
       
        String result = controller.inserir(novoProduto);
       
        assertEquals("Erro ao inserir produto.", result);
    }
    
    @Test 
    public void deve_gerar_falha_ao_tentar_inserir_produto_com_zerado(){
        EstoqueController controller = new EstoqueController();
        Produto novoProduto = new Produto("PC Positivo", 0);
       
        String result = controller.inserir(novoProduto);
       
        assertEquals("Erro ao inserir produto.", result);
    }
    
    @Test 
    public void deve_gerar_falha_ao_tentar_inserir_produto_com_valor_negativo(){
        EstoqueController controller = new EstoqueController();
        Produto novoProduto = new Produto("PC Positivo", -500);
       
        String result = controller.inserir(novoProduto);
       
        assertEquals("Erro ao inserir produto.", result);
    }
     
    @Test
    public void deve_gerar_erro_ao_tentar_editar_produto_inexistente(){
      
       EstoqueController controller = new EstoqueController();
       Produto produto = new Produto("PC Positivo", 200);
       
       Produto produtoEditado = new Produto("PC Positivo", 500);
       
       String result = controller.editar(produto, produtoEditado);
       
       assertEquals("Erro ao editar produto.", result);
              
    }
    
    @Test
    public void deve_gerar_erro_ao_tentar_editar_produto_sem_nome(){
      
       EstoqueController controller = new EstoqueController();
       Produto produto = new Produto("PC Positivo", 200);
       controller.inserir(produto);
       
       Produto produtoEditado = new Produto("", 200);
       
       String result = controller.editar(produto, produtoEditado);
       
       assertEquals("Erro ao editar produto.", result);
              
    }
    
    @Test
    public void deve_gerar_erro_ao_tentar_editar_produto_com_valor_zerado(){
      
       EstoqueController controller = new EstoqueController();
       Produto produto = new Produto("PC Positivo", 200);
       controller.inserir(produto);
       
       Produto produtoEditado = new Produto("PC Positivo", 0);
       
       String result = controller.editar(produto, produtoEditado);
       
       assertEquals("Erro ao editar produto.", result);
              
    }
    
    @Test
    public void deve_gerar_erro_ao_tentar_editar_produto_com_valor_negativo(){
      
       EstoqueController controller = new EstoqueController();
       Produto produto = new Produto("PC Positivo", 200);
       controller.inserir(produto);
       
       Produto produtoEditado = new Produto("PC Positivo", -500);
       
       String result = controller.editar(produto, produtoEditado);
       
       assertEquals("Erro ao editar produto.", result);
              
    }
     
    @Test
    public void deve_gerar_erro_ao_tentar_excluir_produto_inexistente(){
        EstoqueController controller = new EstoqueController();
        Produto produto = new Produto("PC Positivo", 200);
       
        String result = controller.excluir(produto);
       
        assertEquals("Erro ao excluir produto.", result);
    }
    

    
}
