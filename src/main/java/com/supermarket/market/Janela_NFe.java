package com.supermarket.market;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Janela_NFe extends javax.swing.JPanel {

    private boolean status_emissao = false;
    
    public Janela_NFe() {
        initComponents();
        
        preencheSupermercado();
        preencheProdutos();
        preencheCliente();
        preencheImpostos();
        
    }

    public void preencheSupermercado(){
        lb_NomeSupermercado.setText(Janela_Login.dadosSupermercado.getNome());
        lb_Endereco.setText(Janela_Login.dadosSupermercado.getEndereco());
        lb_Bairro.setText(Janela_Login.dadosSupermercado.getBairro());
        lb_Cidade.setText(Janela_Login.dadosSupermercado.getCidade());
        lb_CEP.setText(Janela_Login.dadosSupermercado.getCep());
        lb_CNPJ.setText(Janela_Login.dadosSupermercado.getCnpj());
        lb_IE.setText(Janela_Login.dadosSupermercado.getIe());
        lb_Telefone.setText(Janela_Login.dadosSupermercado.getTelefone());
    }
    
    public void preencheProdutos(){
        ((DefaultTableModel) tb_Produtos.getModel()).setRowCount(0);
            for (int i = 0; i < Janela_Compra.carrinho.size(); i++) {
                    ((DefaultTableModel) tb_Produtos.getModel()).addRow(new Object[]{
                        Janela_Compra.carrinho.get(i).getProduto(),
                        Janela_Compra.carrinho.get(i).getMarca(),
                        Janela_Compra.carrinho.get(i).getValor(),
                        Janela_Compra.carrinho.get(i).getQtde(),
                        Janela_Compra.carrinho.get(i).getValor() * Janela_Compra.carrinho.get(i).getQtde()
                    });
            }
        String total = String.format("%.2f", Janela_Compra.valor);
        lb_Valor.setText(total);
    }
    
    public void preencheCliente(){
        lb_Username.setText(Janela_Login.loggedUser);
        lb_CPF.setText(Janela_Login.loggedCPF);
    }
    
    public void preencheImpostos(){
        
        Double totalF = Janela_Compra.valor * Janela_Login.dadosTax.getFederalTax();
        String resultF = String.format("%.2f", totalF);
        lb_ImpFed.setText(resultF);
        Double totalE = Janela_Compra.valor * Janela_Login.dadosTax.getEstadualTax();
        String resultE = String.format("%.2f", totalE);
        lb_ImpEst.setText(resultE);
        Double totalM = Janela_Compra.valor * Janela_Login.dadosTax.getMunicipalTax();
        String resultM = String.format("%.2f", totalM);
        lb_ImpMun.setText(resultM);
        Double total = totalF + totalE + totalM;
        String result = String.format("%.2f", total);
        lb_ImpTotal.setText(result);
        
    }

    public void emitirNFe(){
        status_emissao = true;
        
        Random rand = new Random();
        int randomNum = rand.nextInt((9999 - 0) + 1) + 0;
        lb_Numero.setText(Integer.toString(randomNum));
        
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String time = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        lb_DataEmissao.setText(data + ":" +time);
        
        System.out.println("NF-e " + randomNum + " emitida às " + data + ":" + time);
        
        bt_EmiteNFe.setEnabled(false);
        bt_Volta_Novo.setText("Logout/Tela de Login");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lb_NomeSupermercado = new javax.swing.JLabel();
        lb_Endereco = new javax.swing.JLabel();
        lb_Bairro = new javax.swing.JLabel();
        lb_Cidade = new javax.swing.JLabel();
        lb_CEP = new javax.swing.JLabel();
        lb_CNPJ = new javax.swing.JLabel();
        lb_IE = new javax.swing.JLabel();
        lb_Telefone = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lb_DataEmissao = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lb_Numero = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_Produtos = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lb_Username = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lb_CPF = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lb_ImpFed = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lb_ImpEst = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lb_ImpTotal = new javax.swing.JLabel();
        lb_ImpMun = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        lb_Valor = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel38 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        bt_Volta_Novo = new javax.swing.JButton();
        bt_EmiteNFe = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Total: ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nota Fiscal Eletrônica - NF-e");

        lb_NomeSupermercado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_NomeSupermercado.setText("<Nome>");

        lb_Endereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_Endereco.setText("<Endereço>");

        lb_Bairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_Bairro.setText("<Bairro>");

        lb_Cidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_Cidade.setText("<Cidade>");

        lb_CEP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_CEP.setText("<CEP>");

        lb_CNPJ.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_CNPJ.setText("<CNPJ>");

        lb_IE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_IE.setText("<IE>");

        lb_Telefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_Telefone.setText("<Telefone>");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Inscrição Estadual:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("CNPJ:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Telefone:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("CEP:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Cidade:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Bairro:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Endereço:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Razão Social:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Data de Emissão:");

        lb_DataEmissao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_DataEmissao.setText("<Data_Emissao>");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Número NF-e:");

        lb_Numero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_Numero.setText("<Numero>");

        tb_Produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Marca", "Preço", "Quatidade", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
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

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Dados do Supermercado");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Nome:");

        lb_Username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_Username.setText("<username>");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("CPF:");

        lb_CPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_CPF.setText("<CPF>");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Impostos Federais:");

        lb_ImpFed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_ImpFed.setText("<Imp_Fed>");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Impostos Estaduais:");

        lb_ImpEst.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_ImpEst.setText("<Imp_Est>");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Impostos Municipais:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Total de impostos:");

        lb_ImpTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_ImpTotal.setText("<Imp_Total>");

        lb_ImpMun.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_ImpMun.setText("<Imp_Mun>");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setText("Total:");

        lb_Valor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_Valor.setText("<Valor>");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Dados do Consumidor");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Cálculo de Imposto");

        bt_Volta_Novo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bt_Volta_Novo.setText("Retornar para Compras");
        bt_Volta_Novo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Volta_NovoMouseClicked(evt);
            }
        });

        bt_EmiteNFe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bt_EmiteNFe.setText("Emitir Nota Fiscal");
        bt_EmiteNFe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_EmiteNFeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator7)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_DataEmissao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_Numero))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_Endereco))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_NomeSupermercado)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_Valor))
                            .addComponent(jSeparator6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel41)
                                        .addGap(8, 8, 8)))
                                .addGap(124, 124, 124)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_ImpEst))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_ImpTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_ImpMun))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_ImpFed)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator5)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_Volta_Novo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_EmiteNFe))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_CPF))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_Username)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jLabel23))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_Bairro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lb_CNPJ))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lb_Telefone))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lb_IE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_Cidade)
                                .addGap(45, 45, 45)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_CEP)
                        .addGap(20, 20, 20))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lb_NomeSupermercado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lb_Endereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lb_Cidade)
                            .addComponent(jLabel14)
                            .addComponent(lb_CEP))
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lb_Bairro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lb_Telefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lb_CNPJ))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lb_IE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lb_DataEmissao)
                    .addComponent(jLabel21)
                    .addComponent(lb_Numero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(lb_Valor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lb_Username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lb_CPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(lb_ImpFed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lb_ImpEst))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(lb_ImpMun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lb_ImpTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Volta_Novo)
                    .addComponent(bt_EmiteNFe))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ProdutosMouseClicked
        //exibeProduto();
    }//GEN-LAST:event_tb_ProdutosMouseClicked

    private void bt_Volta_NovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Volta_NovoMouseClicked
        if (status_emissao == true) {
            Janela_Compra.carrinho.clear();
            Janela.p1 = new Janela_Login();
            JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
            janela.getContentPane().remove(Janela.p5);
            janela.add(Janela.p1, BorderLayout.CENTER);
            janela.pack();
            janela.setLocationRelativeTo(null);
        } else {
            Janela.p3 = new Janela_Compra();
            JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
            janela.getContentPane().remove(Janela.p5);
            janela.add(Janela.p3, BorderLayout.CENTER);
            janela.pack();
            janela.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_bt_Volta_NovoMouseClicked

    private void bt_EmiteNFeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_EmiteNFeMouseClicked
        if (status_emissao == false) {
            switch (JOptionPane.showConfirmDialog(this, "Confirma Emissão?")){
                    case 0: System.out.println("Selecionou: Sim;");
                            emitirNFe();
                    break;
                case 1: System.out.println("Selecionou: Não;");
                    break;
                case 2: System.out.println("Selecionou: Cancelar;");
                    break;
            }
        }
    }//GEN-LAST:event_bt_EmiteNFeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_EmiteNFe;
    private javax.swing.JButton bt_Volta_Novo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lb_Bairro;
    private javax.swing.JLabel lb_CEP;
    private javax.swing.JLabel lb_CNPJ;
    private javax.swing.JLabel lb_CPF;
    private javax.swing.JLabel lb_Cidade;
    private javax.swing.JLabel lb_DataEmissao;
    private javax.swing.JLabel lb_Endereco;
    private javax.swing.JLabel lb_IE;
    private javax.swing.JLabel lb_ImpEst;
    private javax.swing.JLabel lb_ImpFed;
    private javax.swing.JLabel lb_ImpMun;
    private javax.swing.JLabel lb_ImpTotal;
    private javax.swing.JLabel lb_NomeSupermercado;
    private javax.swing.JLabel lb_Numero;
    private javax.swing.JLabel lb_Telefone;
    private javax.swing.JLabel lb_Username;
    private javax.swing.JLabel lb_Valor;
    private javax.swing.JTable tb_Produtos;
    // End of variables declaration//GEN-END:variables
}
