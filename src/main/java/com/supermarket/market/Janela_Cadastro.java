package com.supermarket.market;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Janela_Cadastro extends javax.swing.JPanel {

    static ArrayList <Produto> listaProdutos = new ArrayList();
    
    
    public Janela_Cadastro() {
        initComponents();
    }
    
    public void cadastraProduto(){
        boolean status = verificaCamposCadastro();
        if (status == true) {
            String nome, marca, setor, descricao;
            double preco;
            
            nome = tf_Nome.getText();
            marca = tf_Marca.getText();
            preco = Double.parseDouble(tf_Preco.getText());
            setor = cb_Setor.getSelectedItem().toString();
            descricao = ta_Descricao.getText();
            
            Produto produto = new Produto(nome, marca, descricao, setor, preco);
            
            listaProdutos.add(produto);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            
            atualizaEdit(tf_Nome.getText());
            
            limpaCamposCadastro();
            
            System.out.println("lista: " + listaProdutos.toString());
        }
    }
    
    public boolean verificaCamposCadastro(){
        
        if (tf_Nome.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "O campo Nome não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            if (tf_Marca.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "O campo Marca não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                if (tf_Preco.getText().isEmpty() == true) {
                    JOptionPane.showMessageDialog(null, "O campo Preço não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    try {
                       double d = Double.parseDouble(tf_Preco.getText()); 
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Preço inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    if (Double.parseDouble(tf_Preco.getText()) <= 0.00) {
                        JOptionPane.showMessageDialog(null, "Preço inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return false;
                    } else {
                        if (cb_Setor.getSelectedItem().equals("Selecione") == true) {
                            JOptionPane.showMessageDialog(null, "Setor não selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
                            return false;
                        } else {
                            if (verificaDuplicata() == true) {
                                JOptionPane.showMessageDialog(null, "Não é possível cadastrar dois produtos iguais.", "Erro", JOptionPane.ERROR_MESSAGE);
                                return false;
                            } else {
                            return true;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean verificaDuplicata(){
        
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getSetor().equals(cb_Setor.getSelectedItem().toString()) &&
                listaProdutos.get(i).getProduto().equalsIgnoreCase(tf_Nome.getText()) &&
                listaProdutos.get(i).getMarca().equalsIgnoreCase(tf_Marca.getText())
                ) {
                return true;
                }
            }
        return false;
    }
    
    public void limpaCamposCadastro(){
        
        tf_Nome.setText("");
        tf_Marca.setText("");
        tf_Preco.setText("");
        cb_Setor.setSelectedIndex(0);
        ta_Descricao.setText("");
        
    }
    
    public void limpaCamposEdit(){
        
        tf_Nome2.setText("");
        tf_Marca2.setText("");
        tf_Preco2.setText("");
        cb_Setor2.setSelectedIndex(0);
        ta_Descricao2.setText("");
        
        
    }
    
    public void pesquisa(){
    ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
    boolean status = verificaCamposPesquisa();
    
        if (status == true) {
            for (int i = 0; i < listaProdutos.size(); i++) {
                if (tf_NomePesquisa.getText().equalsIgnoreCase(listaProdutos.get(i).getProduto()) == true) {
                    ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                        listaProdutos.get(i).getSetor(),
                        listaProdutos.get(i).getProduto(),
                        listaProdutos.get(i).getMarca(),
                        listaProdutos.get(i).getValor(),
                        listaProdutos.get(i).getDescricao()
                        });
                    }
                }
            if (tb_Produtos.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean pesquisaEdit(){
            int cont = 0;
            for (int i = 0; i < listaProdutos.size(); i++) {
                if (cb_Setor2.getSelectedItem().toString().equalsIgnoreCase(listaProdutos.get(i).getSetor()) ||
                    tf_Nome2.getText().equalsIgnoreCase(listaProdutos.get(i).getProduto()) ||
                    tf_Marca2.getText().equalsIgnoreCase(listaProdutos.get(i).getMarca()) ||
                    Double.parseDouble(tf_Preco2.getText()) == listaProdutos.get(i).getValor() ||
                    ta_Descricao2.getText().equalsIgnoreCase(listaProdutos.get(i).getDescricao())
                        ) {
                    cont++;
                    return true;
                    }
                }
            if (cont == 0) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return false;
    }
    
    public void atualizaEdit(String nome){
        ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
        
                for (int i = 0; i < listaProdutos.size(); i++) {
                    if (nome.equalsIgnoreCase(listaProdutos.get(i).getProduto()) == true) {
                        ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                            listaProdutos.get(i).getSetor(),
                            listaProdutos.get(i).getProduto(),
                            listaProdutos.get(i).getMarca(),
                            listaProdutos.get(i).getValor(),
                            listaProdutos.get(i).getDescricao()
                            });
                        }
                    }
                if (tb_Produtos.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            
    }
    
    public boolean verificaCamposPesquisa(){
        
        if (tf_NomePesquisa.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "O campo Nome não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

    }
    
    public void exibeProduto(){
        
        cb_Setor2.setSelectedItem(tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,0));
        tf_Nome2.setText((String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,1));
        tf_Marca2.setText((String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,2));
        tf_Preco2.setText(Double.toString((double) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,3)));
        ta_Descricao2.setText((String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,4));       
        
    }
    
    public boolean verificaCamposEdit(){
    
        if (tf_Nome2.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "O campo Nome não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            if (tf_Marca2.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "O campo Marca não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                if (tf_Preco2.getText().isEmpty() == true) {
                    JOptionPane.showMessageDialog(null, "O campo Preço não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    try {
                       double d = Double.parseDouble(tf_Preco2.getText()); 
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Preço inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    if (Double.parseDouble(tf_Preco2.getText()) <= 0.00) {
                        JOptionPane.showMessageDialog(null, "Preço inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return false;
                    } else {
                        if (cb_Setor2.getSelectedItem().equals("Selecione") == true) {
                            JOptionPane.showMessageDialog(null, "Setor não selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
                            return false;
                        } else {
                            return true;
                        }
                    }
                }
            }
        }
}
    
    public void editaProduto(){
        
        if (tb_Produtos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (verificaCamposEdit() == true) {

            String setor, nome, marca, descricao;
            double valor;

            setor = (String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,0);
            nome = (String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,1);
            marca = (String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,2);
            valor = (double) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,3);
            descricao = (String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,4);

            Produto teste = new Produto(nome, marca, descricao, setor, valor);

            for (int i = 0; i < listaProdutos.size(); i++) {
                if (listaProdutos.get(i).getSetor().equals(teste.getSetor()) &&
                    listaProdutos.get(i).getProduto().equals(teste.getProduto()) &&
                    listaProdutos.get(i).getMarca().equals(teste.getMarca()) &&
                    listaProdutos.get(i).getValor() == teste.getValor() &&
                    listaProdutos.get(i).getDescricao().equals(teste.getDescricao()) 
                    ) {
                    listaProdutos.get(i).setSetor(cb_Setor2.getSelectedItem().toString());
                    listaProdutos.get(i).setProduto(tf_Nome2.getText());
                    listaProdutos.get(i).setMarca(tf_Marca2.getText());
                    listaProdutos.get(i).setValor(Double.parseDouble(tf_Preco2.getText()));
                    listaProdutos.get(i).setDescricao(ta_Descricao2.getText());
                    atualizaEdit(tf_Nome2.getText());
                    limpaCamposEdit();
                    System.out.println("editado");
                    }
                }
            }
        }
    }
    
    public void removeProduto(){
        
        if (tb_Produtos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "É necessário selecionar um produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (verificaCamposEdit() == true || pesquisaEdit() == true) {

        String setor, nome, marca, descricao;
        double valor;
        
        setor = (String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,0);
        nome = (String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,1);
        marca = (String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,2);
        valor = (double) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,3);
        descricao = (String) tb_Produtos.getModel().getValueAt(tb_Produtos.getSelectedRow() ,4);
        
        Produto teste = new Produto(nome, marca, descricao, setor, valor);
        System.out.println("teste; " + teste.toString());
        for (int i = 0; i < listaProdutos.size(); i++) {
                if (listaProdutos.get(i).getSetor().equals(teste.getSetor()) &&
                    listaProdutos.get(i).getProduto().equals(teste.getProduto()) &&
                    listaProdutos.get(i).getMarca().equals(teste.getMarca()) &&
                    listaProdutos.get(i).getValor() == teste.getValor() &&
                    listaProdutos.get(i).getDescricao().equals(teste.getDescricao()) 
                    ) {
                    listaProdutos.remove(i);
                    limpaCamposEdit();
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("removido");
                    mostrarTudo();
                    }
                }
            }
        }
    }
    
    public void mostrarTudo(){
        if (listaProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há produtos cadastrados.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
            for (int i = 0; i < listaProdutos.size(); i++) {
                    ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                        listaProdutos.get(i).getSetor(),
                        listaProdutos.get(i).getProduto(),
                        listaProdutos.get(i).getMarca(),
                        listaProdutos.get(i).getValor(),
                        listaProdutos.get(i).getDescricao()
                    });
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_Nome = new javax.swing.JTextField();
        tf_Marca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_Setor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Descricao = new javax.swing.JTextArea();
        bt_Cadastrar = new javax.swing.JButton();
        bt_Limpar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tf_Preco = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_NomePesquisa = new javax.swing.JTextField();
        bt_Pesquisar = new javax.swing.JButton();
        bt_Finalizar = new javax.swing.JButton();
        bt_Sair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_Produtos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        pn_Edit = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tf_Nome2 = new javax.swing.JTextField();
        tf_Marca2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cb_Setor2 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_Descricao2 = new javax.swing.JTextArea();
        bt_Editar = new javax.swing.JButton();
        bt_Remover = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        tf_Preco2 = new javax.swing.JTextField();
        tb_MostrarTudo = new javax.swing.JButton();
        bt_LimparTb = new javax.swing.JButton();

        jLabel9.setText("jLabel9");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Painel de Controle de Produtos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Adicionar Produto");

        jLabel3.setText("Nome:");

        jLabel4.setText("Marca:");

        jLabel5.setText("Setor:");

        cb_Setor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Padaria", "Açougue", "Frios", "Congelados", "Cereais", "Higiene", "Limpeza", "Bebidas", "Hortifruti", "Doces", "Condimentos", "Pet", "Outros" }));

        jLabel6.setText("Descrição:");

        ta_Descricao.setColumns(20);
        ta_Descricao.setRows(5);
        jScrollPane1.setViewportView(ta_Descricao);

        bt_Cadastrar.setText("Cadastrar");
        bt_Cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_CadastrarMouseClicked(evt);
            }
        });

        bt_Limpar.setText("Limpar");
        bt_Limpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_LimparMouseClicked(evt);
            }
        });

        jLabel12.setText("Preço:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tf_Nome, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(tf_Marca)
                                    .addComponent(tf_Preco)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_Setor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_Limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Cadastrar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tf_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tf_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cb_Setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_Cadastrar)
                    .addComponent(bt_Limpar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setText("Pesquisar Produtos");

        jLabel8.setText("Nome:");

        tf_NomePesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_NomePesquisaKeyPressed(evt);
            }
        });

        bt_Pesquisar.setText("Pesquisar");
        bt_Pesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_PesquisarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_NomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_Pesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tf_NomePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_Pesquisar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        bt_Finalizar.setText("Finalizar");
        bt_Finalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_FinalizarMouseClicked(evt);
            }
        });

        bt_Sair.setText("Sair");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

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

        jLabel10.setText("Tela de Produtos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(187, 187, 187))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_Edit.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setText("Edição e Remoção de Produtos");

        jLabel14.setText("Nome:");

        jLabel15.setText("Marca:");

        jLabel16.setText("Setor:");

        cb_Setor2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Padaria", "Açougue", "Frios", "Congelados", "Cereais", "Higiene", "Limpeza", "Bebidas", "Hortifruti", "Doces", "Condimentos", "Pet", "Outros" }));

        jLabel17.setText("Descrição:");

        ta_Descricao2.setColumns(20);
        ta_Descricao2.setRows(5);
        jScrollPane2.setViewportView(ta_Descricao2);

        bt_Editar.setText("Editar");
        bt_Editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_EditarMouseClicked(evt);
            }
        });

        bt_Remover.setText("Remover");
        bt_Remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_RemoverMouseClicked(evt);
            }
        });

        jLabel18.setText("Preço:");

        javax.swing.GroupLayout pn_EditLayout = new javax.swing.GroupLayout(pn_Edit);
        pn_Edit.setLayout(pn_EditLayout);
        pn_EditLayout.setHorizontalGroup(
            pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_EditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_EditLayout.createSequentialGroup()
                        .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18)
                            .addComponent(jLabel13)
                            .addGroup(pn_EditLayout.createSequentialGroup()
                                .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tf_Nome2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(tf_Marca2)
                                    .addComponent(tf_Preco2)))
                            .addGroup(pn_EditLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_Setor2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_EditLayout.createSequentialGroup()
                        .addComponent(bt_Remover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Editar)))
                .addContainerGap())
        );
        pn_EditLayout.setVerticalGroup(
            pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_EditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pn_EditLayout.createSequentialGroup()
                        .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(tf_Nome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_Marca2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(3, 3, 3)
                        .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(tf_Preco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cb_Setor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_Editar)
                    .addComponent(bt_Remover))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_MostrarTudo.setText("Mostrar Tudo");
        tb_MostrarTudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_MostrarTudoMouseClicked(evt);
            }
        });

        bt_LimparTb.setText("Limpar");
        bt_LimparTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_LimparTbMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pn_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(bt_Sair))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_LimparTb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tb_MostrarTudo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_Finalizar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel1)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pn_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Sair)
                    .addComponent(bt_Finalizar)
                    .addComponent(tb_MostrarTudo)
                    .addComponent(bt_LimparTb))
                .addGap(0, 8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_CadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_CadastrarMouseClicked
        cadastraProduto();
    }//GEN-LAST:event_bt_CadastrarMouseClicked

    private void bt_LimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_LimparMouseClicked
        limpaCamposCadastro();
    }//GEN-LAST:event_bt_LimparMouseClicked

    private void bt_PesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_PesquisarMouseClicked
        pesquisa();
    }//GEN-LAST:event_bt_PesquisarMouseClicked

    private void bt_EditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_EditarMouseClicked
        editaProduto();
    }//GEN-LAST:event_bt_EditarMouseClicked

    private void bt_RemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_RemoverMouseClicked
        removeProduto();
    }//GEN-LAST:event_bt_RemoverMouseClicked

    private void tb_ProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ProdutosMouseClicked
        exibeProduto();
    }//GEN-LAST:event_tb_ProdutosMouseClicked

    private void tb_MostrarTudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_MostrarTudoMouseClicked
        ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
        mostrarTudo();
    }//GEN-LAST:event_tb_MostrarTudoMouseClicked

    private void bt_LimparTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_LimparTbMouseClicked
        ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
        limpaCamposEdit();
    }//GEN-LAST:event_bt_LimparTbMouseClicked

    private void tf_NomePesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_NomePesquisaKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            pesquisa();
        }
    }//GEN-LAST:event_tf_NomePesquisaKeyPressed

    private void bt_FinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_FinalizarMouseClicked
        switch (JOptionPane.showConfirmDialog(this, "Deseja finalizar?")){
                    case 0: System.out.println("Selecionou: Sim;");
                            Janela.p1 = new Janela_Login();
                            JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
                            janela.getContentPane().remove(Janela.p2);
                            janela.add(Janela.p1, BorderLayout.CENTER);
                            janela.pack();
                            janela.setLocationRelativeTo(null);
                    break;
                case 1: System.out.println("Selecionou: Não;");
                    break;
                case 2: System.out.println("Selecionou: Cancelar;");
                    break;
            }
    }//GEN-LAST:event_bt_FinalizarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Cadastrar;
    private javax.swing.JButton bt_Editar;
    private javax.swing.JButton bt_Finalizar;
    private javax.swing.JButton bt_Limpar;
    private javax.swing.JButton bt_LimparTb;
    private javax.swing.JButton bt_Pesquisar;
    private javax.swing.JButton bt_Remover;
    private javax.swing.JButton bt_Sair;
    private javax.swing.JComboBox<String> cb_Setor;
    private javax.swing.JComboBox<String> cb_Setor2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pn_Edit;
    private javax.swing.JTextArea ta_Descricao;
    private javax.swing.JTextArea ta_Descricao2;
    private javax.swing.JButton tb_MostrarTudo;
    private javax.swing.JTable tb_Produtos;
    private javax.swing.JTextField tf_Marca;
    private javax.swing.JTextField tf_Marca2;
    private javax.swing.JTextField tf_Nome;
    private javax.swing.JTextField tf_Nome2;
    private javax.swing.JTextField tf_NomePesquisa;
    private javax.swing.JTextField tf_Preco;
    private javax.swing.JTextField tf_Preco2;
    // End of variables declaration//GEN-END:variables
}
