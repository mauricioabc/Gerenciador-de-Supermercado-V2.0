package com.supermarket.market;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Janela_Compra extends javax.swing.JPanel {
    
    static double valor = 0.00;
    static ArrayList <Produto> carrinho = new ArrayList();
    
    public Janela_Compra() {
        initComponents();
        //Janela_Cadastro.listaProdutos.clear();
        
        //cadastraTeste();
        atualizaBotao();
        atualizaPreco();
        //lb_Valor.setText(Double.toString(valor));
        
    }

    //Para teste
    public void cadastraTeste(){
        
        Produto produto = new Produto("Leite", "Tirol", "Leite Longa Vida 1L", "Frios", 4.59);
        Janela_Cadastro.listaProdutos.add(produto);
        
        produto = new Produto("Leite", "Piá", "Leite Longa Vida 1L", "Frios", 4.79);
        Janela_Cadastro.listaProdutos.add(produto);
        
        produto = new Produto("Pão Frânces", "Paduá", "Pão Francês Unidade", "Padaria", 0.15);
        Janela_Cadastro.listaProdutos.add(produto);
        
        produto = new Produto("Arroz", "Kiarroz", "Pacote de Arroz 5 Kg", "Cereais", 15.59);
        Janela_Cadastro.listaProdutos.add(produto);
        
        produto = new Produto("Refrigerante", "Guarána", "Guaraná 1L", "Bebidas", 5.21);
        Janela_Cadastro.listaProdutos.add(produto);
        
    }
    //Para teste fim
    
    public void mostrarTudo(){
        if (Janela_Cadastro.listaProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há produtos cadastrados.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
            for (int i = 0; i < Janela_Cadastro.listaProdutos.size(); i++) {
                    ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                        Janela_Cadastro.listaProdutos.get(i).getSetor(),
                        Janela_Cadastro.listaProdutos.get(i).getProduto(),
                        Janela_Cadastro.listaProdutos.get(i).getMarca(),
                        Janela_Cadastro.listaProdutos.get(i).getValor(),
                        Janela_Cadastro.listaProdutos.get(i).getDescricao()
                    });
            }
        }
    }
    
    public void exibeProduto(){
        
        tf_Setor.setText((String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,0));
        tf_Nome.setText((String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,1));
        tf_Marca.setText((String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,2));
        tf_Preco.setText(Double.toString((double) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,3)));
        ta_Descricao.setText((String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,4));       
        
    }
    
    public void adicionaCarrinho(){
        if (tf_Nome.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else { 
            if ((int) sp_Qtde.getValue() == 0) {
                JOptionPane.showMessageDialog(null, "Não é possível adicionar zero produtos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                String nome, marca, setor, descricao;
                double preco;
                int qtde;

                nome = tf_Nome.getText();
                marca = tf_Marca.getText();
                preco = Double.parseDouble(tf_Preco.getText());
                setor = tf_Setor.getText();
                descricao = ta_Descricao.getText();
                qtde = (int) sp_Qtde.getValue();

                Produto produto = new Produto(nome, marca, descricao, setor, preco, qtde);

                carrinho.add(produto);
                atualizaBotao();
                atualizaPreco();
                System.out.println("teste " + carrinho.toString());
                JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void atualizaPreco(){
        valor = 0.00;
        for (int i = 0; i < carrinho.size(); i++) {
            valor = valor + ((carrinho.get(i).getQtde()) * (carrinho.get(i).getValor()));
        }
        String result = String.format("%.2f", valor);
        lb_Valor.setText(result);
    }

    public void atualizaBotao(){
        bt_MeuCarrinho.setText("Meu Carrinho ("+ carrinho.size() +")");
    }
    
    public void pesquisa(){
        //Caso só o nome esteja preenchido
        if (tf_NomePesquisa.getText().equals("") == false &&
            tf_MarcaPesquisa.getText().equals("") == true &&
            cb_SetorPesquisa.getSelectedItem().toString().equals("Selecione") == true) {
                ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
                for (int i = 0; i < Janela_Cadastro.listaProdutos.size(); i++) {
                    if (tf_NomePesquisa.getText().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getProduto()) == true) {
                        ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                            Janela_Cadastro.listaProdutos.get(i).getSetor(),
                            Janela_Cadastro.listaProdutos.get(i).getProduto(),
                            Janela_Cadastro.listaProdutos.get(i).getMarca(),
                            Janela_Cadastro.listaProdutos.get(i).getValor(),
                            Janela_Cadastro.listaProdutos.get(i).getDescricao()
                            });
                        }
                    }
                if (tb_Produtos.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
        } else {
            //Caso nome e marca estejam preenchidos
            if (tf_NomePesquisa.getText().equals("") == false &&
            tf_MarcaPesquisa.getText().equals("") == false &&
            cb_SetorPesquisa.getSelectedItem().toString().equals("Selecione") == true) {
                ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
                for (int i = 0; i < Janela_Cadastro.listaProdutos.size(); i++) {
                    if (tf_NomePesquisa.getText().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getProduto()) == true &&
                        tf_MarcaPesquisa.getText().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getMarca()) == true) {
                        ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                            Janela_Cadastro.listaProdutos.get(i).getSetor(),
                            Janela_Cadastro.listaProdutos.get(i).getProduto(),
                            Janela_Cadastro.listaProdutos.get(i).getMarca(),
                            Janela_Cadastro.listaProdutos.get(i).getValor(),
                            Janela_Cadastro.listaProdutos.get(i).getDescricao()
                            });
                        }
                    }
                if (tb_Produtos.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
        } else {
                //Caso só a marca esteja preenchida
                if (tf_NomePesquisa.getText().equals("") == true &&
                tf_MarcaPesquisa.getText().equals("") == false &&
                cb_SetorPesquisa.getSelectedItem().toString().equals("Selecione") == true) {
                    ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
                    for (int i = 0; i < Janela_Cadastro.listaProdutos.size(); i++) {
                        if (tf_MarcaPesquisa.getText().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getMarca()) == true) {
                            ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                                Janela_Cadastro.listaProdutos.get(i).getSetor(),
                                Janela_Cadastro.listaProdutos.get(i).getProduto(),
                                Janela_Cadastro.listaProdutos.get(i).getMarca(),
                                Janela_Cadastro.listaProdutos.get(i).getValor(),
                                Janela_Cadastro.listaProdutos.get(i).getDescricao()
                                });
                            }
                        }
                    if (tb_Produtos.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    //Caso só o setor esteja preenchido
                    if (tf_NomePesquisa.getText().equals("") == true &&
                    tf_MarcaPesquisa.getText().equals("") == true &&
                    cb_SetorPesquisa.getSelectedItem().toString().equals("Selecione") == false) {
                        ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
                        for (int i = 0; i < Janela_Cadastro.listaProdutos.size(); i++) {
                            if (cb_SetorPesquisa.getSelectedItem().toString().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getSetor()) == true) {
                                ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                                    Janela_Cadastro.listaProdutos.get(i).getSetor(),
                                    Janela_Cadastro.listaProdutos.get(i).getProduto(),
                                    Janela_Cadastro.listaProdutos.get(i).getMarca(),
                                    Janela_Cadastro.listaProdutos.get(i).getValor(),
                                    Janela_Cadastro.listaProdutos.get(i).getDescricao()
                                    });
                                }
                            }
                        if (tb_Produtos.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        //Caso nome e setor estejam preenchidos
                        if (tf_NomePesquisa.getText().equals("") == false &&
                        tf_MarcaPesquisa.getText().equals("") == true &&
                        cb_SetorPesquisa.getSelectedItem().toString().equals("Selecione") == false) {
                            ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
                            for (int i = 0; i < Janela_Cadastro.listaProdutos.size(); i++) {
                                if (cb_SetorPesquisa.getSelectedItem().toString().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getSetor()) == true &&
                                    tf_NomePesquisa.getText().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getProduto()) == true) {
                                    ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                                        Janela_Cadastro.listaProdutos.get(i).getSetor(),
                                        Janela_Cadastro.listaProdutos.get(i).getProduto(),
                                        Janela_Cadastro.listaProdutos.get(i).getMarca(),
                                        Janela_Cadastro.listaProdutos.get(i).getValor(),
                                        Janela_Cadastro.listaProdutos.get(i).getDescricao()
                                        });
                                    }
                                }
                            if (tb_Produtos.getRowCount() == 0) {
                            JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            //Caso marca e setor estejam preenchidos
                            if (tf_NomePesquisa.getText().equals("") == true &&
                            tf_MarcaPesquisa.getText().equals("") == false &&
                            cb_SetorPesquisa.getSelectedItem().toString().equals("Selecione") == false) {
                                ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
                                for (int i = 0; i < Janela_Cadastro.listaProdutos.size(); i++) {
                                    if (cb_SetorPesquisa.getSelectedItem().toString().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getSetor()) == true &&
                                        tf_MarcaPesquisa.getText().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getMarca()) == true) {
                                        ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                                            Janela_Cadastro.listaProdutos.get(i).getSetor(),
                                            Janela_Cadastro.listaProdutos.get(i).getProduto(),
                                            Janela_Cadastro.listaProdutos.get(i).getMarca(),
                                            Janela_Cadastro.listaProdutos.get(i).getValor(),
                                            Janela_Cadastro.listaProdutos.get(i).getDescricao()
                                            });
                                        }
                                    }
                                if (tb_Produtos.getRowCount() == 0) {
                                JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                //Caso nome, marca e setor estejam preenchidos
                                if (tf_NomePesquisa.getText().equals("") == false &&
                                tf_MarcaPesquisa.getText().equals("") == false &&
                                cb_SetorPesquisa.getSelectedItem().toString().equals("Selecione") == false) {
                                    ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
                                    for (int i = 0; i < Janela_Cadastro.listaProdutos.size(); i++) {
                                        if (cb_SetorPesquisa.getSelectedItem().toString().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getSetor()) == true &&
                                            tf_MarcaPesquisa.getText().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getMarca()) == true &&
                                            tf_NomePesquisa.getText().equalsIgnoreCase(Janela_Cadastro.listaProdutos.get(i).getProduto()) == true) {
                                            ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                                                Janela_Cadastro.listaProdutos.get(i).getSetor(),
                                                Janela_Cadastro.listaProdutos.get(i).getProduto(),
                                                Janela_Cadastro.listaProdutos.get(i).getMarca(),
                                                Janela_Cadastro.listaProdutos.get(i).getValor(),
                                                Janela_Cadastro.listaProdutos.get(i).getDescricao()
                                                });
                                            }
                                        }
                                    if (tb_Produtos.getRowCount() == 0) {
                                    JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "É necessário preencer pelo menos um dos campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void abreCarrinho(){
        Janela.p4 = new Janela_Carrinho();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.p3);
        janela.add(Janela.p4, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void abreNFe(){
        Janela.p5 = new Janela_NFe();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.p3);
        janela.add(Janela.p5, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_Produtos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_MarcaPesquisa = new javax.swing.JTextField();
        tf_NomePesquisa = new javax.swing.JTextField();
        cb_SetorPesquisa = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        bt_MostrarTudo = new javax.swing.JButton();
        bt_Pesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_Descricao = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        bt_Adicionar = new javax.swing.JButton();
        sp_Qtde = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_Preco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_Marca = new javax.swing.JTextField();
        tf_Nome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_Setor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lb_Valor = new javax.swing.JLabel();
        bt_MeuCarrinho = new javax.swing.JButton();
        bt_EmiteNota = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        bt_Voltar = new javax.swing.JButton();
        bt_Limpar = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Painel de Compras");

        tb_Produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Setor", "Produto", "Marca", "Preço", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Pesquisar Produto:");

        jLabel9.setText("Marca:");

        jLabel10.setText("Nome:");

        cb_SetorPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Padaria", "Açougue", "Frios", "Congelados", "Cereais", "Higiene", "Limpeza", "Bebidas", "Hortifruti", "Doces", "Condimentos", "Pet", "Outros" }));

        jLabel11.setText("Setor:");

        bt_MostrarTudo.setText("Mostrar Tudo");
        bt_MostrarTudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_MostrarTudoMouseClicked(evt);
            }
        });

        bt_Pesquisar.setText("Pesquisar");
        bt_Pesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_PesquisarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_MarcaPesquisa)
                            .addComponent(tf_NomePesquisa)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_SetorPesquisa, 0, 351, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_MostrarTudo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Pesquisar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tf_NomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_MarcaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cb_SetorPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_MostrarTudo)
                    .addComponent(bt_Pesquisar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        ta_Descricao.setEditable(false);
        ta_Descricao.setColumns(20);
        ta_Descricao.setRows(5);
        jScrollPane2.setViewportView(ta_Descricao);

        jLabel17.setText("Descrição:");

        bt_Adicionar.setText("Adicionar ao Carrinho");
        bt_Adicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_AdicionarMouseClicked(evt);
            }
        });

        sp_Qtde.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel19.setText("Quantidade:");

        jLabel2.setText("Comprar:");

        jLabel6.setText("Setor:");

        tf_Preco.setEditable(false);

        jLabel12.setText("Preço:");

        jLabel7.setText("Marca:");

        tf_Marca.setEditable(false);

        tf_Nome.setEditable(false);

        jLabel8.setText("Nome:");

        tf_Setor.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_Adicionar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sp_Qtde, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel12)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tf_Nome)
                                        .addComponent(tf_Marca)
                                        .addComponent(tf_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tf_Setor, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tf_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tf_Setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sp_Qtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(bt_Adicionar)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Total: ");

        lb_Valor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_Valor.setText("<valor>");

        bt_MeuCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bt_MeuCarrinho.setText("Meu Carrinho");
        bt_MeuCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_MeuCarrinhoMouseClicked(evt);
            }
        });

        bt_EmiteNota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bt_EmiteNota.setText("Visualizar Nota Fiscal");
        bt_EmiteNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_EmiteNotaMouseClicked(evt);
            }
        });

        jLabel13.setText("Opções:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_MeuCarrinho))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_Valor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_EmiteNota)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_MeuCarrinho)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_EmiteNota)
                    .addComponent(jLabel4)
                    .addComponent(lb_Valor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_Voltar.setText("Voltar");
        bt_Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_VoltarMouseClicked(evt);
            }
        });

        bt_Limpar.setText("Limpar");
        bt_Limpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_LimparMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(353, 353, 353))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_Voltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Limpar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Voltar)
                    .addComponent(bt_Limpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_MostrarTudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_MostrarTudoMouseClicked
        mostrarTudo();
    }//GEN-LAST:event_bt_MostrarTudoMouseClicked

    private void tb_ProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ProdutosMouseClicked
        exibeProduto();
    }//GEN-LAST:event_tb_ProdutosMouseClicked

    private void bt_AdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_AdicionarMouseClicked
        adicionaCarrinho();
    }//GEN-LAST:event_bt_AdicionarMouseClicked

    private void bt_PesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_PesquisarMouseClicked
        pesquisa();
    }//GEN-LAST:event_bt_PesquisarMouseClicked

    private void bt_MeuCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_MeuCarrinhoMouseClicked
        abreCarrinho();
    }//GEN-LAST:event_bt_MeuCarrinhoMouseClicked

    private void bt_EmiteNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_EmiteNotaMouseClicked
        if (carrinho.isEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário possuir ao menos um produto no carrinho para emitir uma NF-e.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            abreNFe();
        }
    }//GEN-LAST:event_bt_EmiteNotaMouseClicked

    private void bt_VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_VoltarMouseClicked
        Janela.p1 = new Janela_Login();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.p3);
        janela.add(Janela.p1, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }//GEN-LAST:event_bt_VoltarMouseClicked

    private void bt_LimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_LimparMouseClicked
        ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
    }//GEN-LAST:event_bt_LimparMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Adicionar;
    private javax.swing.JButton bt_EmiteNota;
    private javax.swing.JButton bt_Limpar;
    private javax.swing.JButton bt_MeuCarrinho;
    private javax.swing.JButton bt_MostrarTudo;
    private javax.swing.JButton bt_Pesquisar;
    private javax.swing.JButton bt_Voltar;
    private javax.swing.JComboBox<String> cb_SetorPesquisa;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lb_Valor;
    private javax.swing.JSpinner sp_Qtde;
    private javax.swing.JTextArea ta_Descricao;
    private javax.swing.JTable tb_Produtos;
    private javax.swing.JTextField tf_Marca;
    private javax.swing.JTextField tf_MarcaPesquisa;
    private javax.swing.JTextField tf_Nome;
    private javax.swing.JTextField tf_NomePesquisa;
    private javax.swing.JTextField tf_Preco;
    private javax.swing.JTextField tf_Setor;
    // End of variables declaration//GEN-END:variables
}
