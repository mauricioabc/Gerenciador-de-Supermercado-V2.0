package com.supermarket.market;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Janela_Carrinho extends javax.swing.JPanel {

    public Janela_Carrinho() {
        initComponents();
        
        atualizaPreco();
        listarItens();
        
    }

    public void abreCompras(){
        Janela.p3 = new Janela_Compra();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.p4);
        janela.add(Janela.p3, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void listarItens(){
            ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
            for (int i = 0; i < Janela_Compra.carrinho.size(); i++) {
                    ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                        Janela_Compra.carrinho.get(i).getSetor(),
                        Janela_Compra.carrinho.get(i).getProduto(),
                        Janela_Compra.carrinho.get(i).getMarca(),
                        Janela_Compra.carrinho.get(i).getValor(),
                        Janela_Compra.carrinho.get(i).getQtde(),
                        Janela_Compra.carrinho.get(i).getDescricao()
                    });
            }
            if (Janela_Compra.carrinho.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O carrinho está vazio.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    
    public void removeItem(){
        if (tb_Produtos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Janela_Compra.carrinho.remove(tb_Produtos.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso.", "Remoção", JOptionPane.INFORMATION_MESSAGE);
            atualizaPreco();
            listarItens();
        }
    }
    
    public void salvar(){
        for (int i = 0; i < Janela_Compra.carrinho.size(); i++) {
            Janela_Compra.carrinho.get(i).setQtde((int)tb_Produtos.getModel().getValueAt(i, 4));
        }
        atualizaPreco();
        listarItens();
    }
    
    public void atualizaPreco(){
        Double valor = 0.00;
        for (int i = 0; i < Janela_Compra.carrinho.size(); i++) {
            valor = valor + ((Janela_Compra.carrinho.get(i).getQtde()) * (Janela_Compra.carrinho.get(i).getValor()));
        }
        String result = String.format("%.2f", valor);
        lb_Valor.setText(result);
    }
    
    public void add(){
        if (tb_Produtos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            tb_Produtos.setValueAt((int)tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow(), 4) + 1, tb_Produtos.getSelectedRow(), 4);
            atualizaPreco();
        }
    }
    
    public void sub(){
        if (tb_Produtos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if ((int)tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow(), 4) == 1) {
                JOptionPane.showMessageDialog(null, "Não é possível comprar zero produtos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
            tb_Produtos.setValueAt((int)tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow(), 4) -1, tb_Produtos.getSelectedRow(), 4);
            atualizaPreco();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_Produtos = new javax.swing.JTable();
        bt_Voltar = new javax.swing.JButton();
        bt_Remover = new javax.swing.JButton();
        bt_Salvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lb_Valor = new javax.swing.JLabel();
        bt_Add = new javax.swing.JButton();
        bt_Sub = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Meu Carrinho");

        tb_Produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Setor", "Produto", "Marca", "Preço", "Quantidade", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_Produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ProdutosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_Produtos);

        bt_Voltar.setText("Voltar");
        bt_Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_VoltarMouseClicked(evt);
            }
        });

        bt_Remover.setText("Remover");
        bt_Remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_RemoverMouseClicked(evt);
            }
        });

        bt_Salvar.setText("Salvar");
        bt_Salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_SalvarMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Total: ");

        lb_Valor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_Valor.setText("<valor>");

        bt_Add.setText("+");
        bt_Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_AddMouseClicked(evt);
            }
        });

        bt_Sub.setText("-");
        bt_Sub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_SubMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_Voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Salvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Remover))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Sub)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_Valor)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(lb_Valor)
                    .addComponent(bt_Add)
                    .addComponent(bt_Sub))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Voltar)
                    .addComponent(bt_Remover)
                    .addComponent(bt_Salvar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ProdutosMouseClicked
        //exibeProduto();
    }//GEN-LAST:event_tb_ProdutosMouseClicked

    private void bt_VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_VoltarMouseClicked
        abreCompras();
    }//GEN-LAST:event_bt_VoltarMouseClicked

    private void bt_RemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_RemoverMouseClicked
        removeItem();
    }//GEN-LAST:event_bt_RemoverMouseClicked

    private void bt_SalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_SalvarMouseClicked
        salvar();
    }//GEN-LAST:event_bt_SalvarMouseClicked

    private void bt_AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_AddMouseClicked
        add();
    }//GEN-LAST:event_bt_AddMouseClicked

    private void bt_SubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_SubMouseClicked
        sub();
    }//GEN-LAST:event_bt_SubMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Add;
    private javax.swing.JButton bt_Remover;
    private javax.swing.JButton bt_Salvar;
    private javax.swing.JButton bt_Sub;
    private javax.swing.JButton bt_Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lb_Valor;
    private javax.swing.JTable tb_Produtos;
    // End of variables declaration//GEN-END:variables
}
