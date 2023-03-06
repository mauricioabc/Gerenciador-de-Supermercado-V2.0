package com.supermarket.market;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Janela_Login extends javax.swing.JPanel {

   static String loggedUser;
   static String loggedCPF;
   private String Chave = "4321";
   
   static ArrayList  <admin> listaAdmin = new ArrayList();
   static ArrayList  <user> listaUser = new ArrayList();
   static Supermercado dadosSupermercado;
   static tax dadosTax;
   
    public Janela_Login() {
        initComponents();
        //Cadastra dados do Supermercado
        dadosSupermercado = new Supermercado(
            "Super Koch", "Pres. Vargas, 541", "Coral", "Lages", "88508-110", 
            "99.494.785/0001-63", "864.831.218", "(49) 3291-9260");
        lb_NomeSupermercado.setText(dadosSupermercado.getNome());
        //Cadastra impostos
        dadosTax = new tax(0.17,0.00,0.00);
        // Parte login
        lb_Senha.setVisible(false);
        tf_Senha.setVisible(false);
        
        tf_Username.setEnabled(false);
        tf_cpf.setEnabled(false);
        tf_Senha.setEnabled(false);
        // Parte cadastro
        lb_Senha2.setVisible(false);
        tf_Senha2.setVisible(false);
        
        tf_Username2.setEnabled(false);
        tf_cpf2.setEnabled(false);
        tf_Senha2.setEnabled(false);
        
        lb_Chave.setVisible(false);
        tf_Chave.setVisible(false);
        
        
    }
    
    public void verificaUserTypeLogin(){
        
        if (bt_Adm.isSelected() == true) {
            lb_Senha.setVisible(true);
            tf_Senha.setVisible(true);
            tf_Username.setEnabled(true);
            tf_cpf.setEnabled(true);
            tf_Senha.setEnabled(true);
            
        } else {
            if (bt_Cliente.isSelected() == true) {
                lb_Senha.setVisible(false);
                tf_Senha.setVisible(false);
                tf_Username.setEnabled(true);
                tf_cpf.setEnabled(true);
                tf_Senha.setEnabled(true);
            }
        }
        
    }
    
    public void verificaUserTypeCadastro(){
        
        if (bt_Adm2.isSelected() == true) {
            lb_Senha2.setVisible(true);
            tf_Senha2.setVisible(true);
            tf_Username2.setEnabled(true);
            tf_cpf2.setEnabled(true);
            tf_Senha2.setEnabled(true);
            lb_Chave.setVisible(true);
            tf_Chave.setVisible(true);
            
        } else {
            if (bt_Cliente2.isSelected() == true) {
                lb_Senha2.setVisible(false);
                tf_Senha2.setVisible(false);
                tf_Username2.setEnabled(true);
                tf_cpf2.setEnabled(true);
                tf_Senha2.setEnabled(true);
                lb_Chave.setVisible(false);
                tf_Chave.setVisible(false);
            }
        }
        
    }
    
    public boolean verificaCpf(String CPF){
                // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
    }
    
    public void gotoJanela_Cadastro(){
        Janela.p2 = new Janela_Cadastro();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.p1);
        janela.add(Janela.p2, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void gotoJanela_Compra(){
        Janela.p3 = new Janela_Compra();
        JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(Janela.p1);
        janela.add(Janela.p3, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
    }
    
    public void cadastraUser(){
        if (bt_Adm2.isSelected() == true) {
            
            boolean aut = verificaCampos();
            System.out.println(aut);
            if (aut == true) {
                String nome, cpf;
            
                nome = tf_Username2.getText();
                cpf = tf_cpf2.getText();
                String senha = new String(tf_Senha2.getPassword());

                admin userAdmin = new admin(nome, cpf, senha); 

                listaAdmin.add(userAdmin);

                System.out.println("lista: " + listaAdmin.toString());
            }
        }
            
            if (bt_Cliente2.isSelected() == true) {
                boolean aut = verificaCampos();
                System.out.println(aut);
                if (aut == true) {
                    String nome, cpf;

                    nome = tf_Username2.getText();
                    cpf = tf_cpf2.getText();

                    user user = new user(nome, cpf); 
                    
                    listaUser.add(user);

                    System.out.println("lista: " + listaUser.toString());
            }
        }
    }
    
    public boolean verificaCampos(){
        
        String senha = new String(tf_Senha2.getPassword());
        String chave = new String(tf_Chave.getPassword());
        
        if (bt_Adm2.isSelected() == true || bt_Cliente2.isSelected() == true) {
            if (tf_Username2.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "O campo Usuário não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                if (tf_cpf2.getText().isEmpty() == true) {
                    JOptionPane.showMessageDialog(null, "O campo CPF não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    if (verificaCpf(tf_cpf2.getText()) == false) {
                        JOptionPane.showMessageDialog(null, "CFP inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return false;
                } else {
                        if (bt_Cliente2.isSelected() == true) {
                            return true;
                        } else {
                            if (senha.equals("") == true) {
                            JOptionPane.showMessageDialog(null, "O campo Senha não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                            return false;
                            } else {
                                if (chave.equals("") == true) {
                                    JOptionPane.showMessageDialog(null, "Chave de autorização não informada.", "Erro", JOptionPane.ERROR_MESSAGE);
                                    return false;
                                } else {
                                        if (chave.equals(Chave) == false) {
                                            JOptionPane.showMessageDialog(null, "Chave de autorização inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
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
        } // fim if admin 

        return false;
    }
    
    public boolean login(){
        String senha = new String(tf_Senha.getPassword());
        
        if (bt_Adm.isSelected() == true || bt_Cliente.isSelected() == true) {
            if (tf_Username.getText().isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "O campo Usuário não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                if (tf_cpf.getText().isEmpty() == true) {
                    JOptionPane.showMessageDialog(null, "O campo CPF não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    if (verificaCpf(tf_cpf.getText()) == false) {
                        JOptionPane.showMessageDialog(null, "CFP inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return false;
                } else {
                        if (bt_Cliente.isSelected() == true) {
                            for (int i = 0; i < listaUser.size(); i++) {
                                if (listaUser.get(i).getUsername().equals(tf_Username.getText()) == true) {
                                    return true;
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Cliente não cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                            return false;
                        } else {
                            if (senha.equals("") == true) {
                            JOptionPane.showMessageDialog(null, "O campo Senha não foi preenchido.", "Erro", JOptionPane.ERROR_MESSAGE);
                            return false;
                            } else {
                                // lógica da senha
                                for (int i = 0; i < listaAdmin.size(); i++) {
                                    if (listaAdmin.get(i).getUsername().equals(tf_Username.getText()) == true) {
                                        String control = listaAdmin.get(i).getSenha();
                                        if (senha.equals(control) == true) {
                                            return true;
                                        }
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "Senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        }
                    }
                }
            }
        } // fim if admin 

        return false;
    }
    
    public void limpaCamposCadastro(){
        tf_Username2.setText("");
        tf_cpf2.setText("");
        tf_Senha2.setText("");
        tf_Chave.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        lb_NomeSupermercado = new javax.swing.JLabel();
        bt_Login = new javax.swing.JButton();
        bt_Sair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bt_Cliente = new javax.swing.JRadioButton();
        tf_Username = new javax.swing.JTextField();
        lb_Username = new javax.swing.JLabel();
        lb_cpf = new javax.swing.JLabel();
        lb_Senha = new javax.swing.JLabel();
        tf_Senha = new javax.swing.JPasswordField();
        tf_cpf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bt_Adm = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lb_Username2 = new javax.swing.JLabel();
        lb_cpf2 = new javax.swing.JLabel();
        lb_Senha2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bt_Cliente2 = new javax.swing.JRadioButton();
        bt_Adm2 = new javax.swing.JRadioButton();
        tf_Username2 = new javax.swing.JTextField();
        tf_cpf2 = new javax.swing.JTextField();
        tf_Senha2 = new javax.swing.JPasswordField();
        lb_Chave = new javax.swing.JLabel();
        tf_Chave = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        bt_Cadastrar = new javax.swing.JButton();

        lb_NomeSupermercado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_NomeSupermercado.setText("<Nome>");

        bt_Login.setText("Login");
        bt_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_LoginMouseClicked(evt);
            }
        });

        bt_Sair.setText("Sair");
        bt_Sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_SairMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        bt_Cliente.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(bt_Cliente);
        bt_Cliente.setText("Cliente");
        bt_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ClienteMouseClicked(evt);
            }
        });

        tf_Username.setBackground(new java.awt.Color(255, 255, 255));

        lb_Username.setBackground(new java.awt.Color(204, 204, 204));
        lb_Username.setText("Usuário");

        lb_cpf.setBackground(new java.awt.Color(204, 204, 204));
        lb_cpf.setText("CPF");

        lb_Senha.setBackground(new java.awt.Color(204, 204, 204));
        lb_Senha.setText("Senha");

        tf_Senha.setBackground(new java.awt.Color(255, 255, 255));

        tf_cpf.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Tipo de usuário");

        bt_Adm.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(bt_Adm);
        bt_Adm.setText("Administrador");
        bt_Adm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_AdmMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_Adm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Cliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_Username)
                            .addComponent(lb_cpf)
                            .addComponent(lb_Senha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_Username, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(tf_cpf)
                            .addComponent(tf_Senha))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Adm)
                    .addComponent(bt_Cliente))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Username)
                    .addComponent(tf_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cpf)
                    .addComponent(tf_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Senha)
                    .addComponent(tf_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Login");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lb_Username2.setBackground(new java.awt.Color(204, 204, 204));
        lb_Username2.setText("Usuário");

        lb_cpf2.setBackground(new java.awt.Color(204, 204, 204));
        lb_cpf2.setText("CPF");

        lb_Senha2.setBackground(new java.awt.Color(204, 204, 204));
        lb_Senha2.setText("Senha");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Tipo de usuário");

        bt_Cliente2.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(bt_Cliente2);
        bt_Cliente2.setText("Cliente");
        bt_Cliente2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Cliente2MouseClicked(evt);
            }
        });

        bt_Adm2.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup2.add(bt_Adm2);
        bt_Adm2.setText("Administrador");
        bt_Adm2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_Adm2MouseClicked(evt);
            }
        });

        tf_Username2.setBackground(new java.awt.Color(255, 255, 255));

        tf_cpf2.setBackground(new java.awt.Color(255, 255, 255));

        tf_Senha2.setBackground(new java.awt.Color(255, 255, 255));

        lb_Chave.setText("Chave");

        tf_Chave.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bt_Adm2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt_Cliente2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_Username2)
                            .addComponent(lb_cpf2)
                            .addComponent(lb_Senha2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(tf_Senha2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_Chave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_Chave, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(tf_Username2)
                            .addComponent(tf_cpf2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Adm2)
                    .addComponent(bt_Cliente2))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Username2)
                    .addComponent(tf_Username2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cpf2)
                    .addComponent(tf_cpf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Senha2)
                    .addComponent(tf_Senha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Chave)
                    .addComponent(tf_Chave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Cadastro de Usuários");

        bt_Cadastrar.setText("Cadastrar");
        bt_Cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_CadastrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bt_Login)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_Sair))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(bt_Cadastrar))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(lb_NomeSupermercado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lb_NomeSupermercado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Sair)
                    .addComponent(bt_Login)
                    .addComponent(bt_Cadastrar))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_LoginMouseClicked
        boolean status = login();
        if (status == true && bt_Adm.isSelected() == true) {
            gotoJanela_Cadastro();
        }
        if (status == true && bt_Cliente.isSelected() == true) {
            loggedUser = tf_Username.getText();
            loggedCPF = tf_cpf.getText();
            gotoJanela_Compra();
        }
    }//GEN-LAST:event_bt_LoginMouseClicked

    private void bt_SairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_SairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_bt_SairMouseClicked

    private void bt_AdmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_AdmMouseClicked
        verificaUserTypeLogin();
    }//GEN-LAST:event_bt_AdmMouseClicked

    private void bt_ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ClienteMouseClicked
        verificaUserTypeLogin();
    }//GEN-LAST:event_bt_ClienteMouseClicked

    private void bt_Adm2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Adm2MouseClicked
        verificaUserTypeCadastro();
    }//GEN-LAST:event_bt_Adm2MouseClicked

    private void bt_Cliente2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_Cliente2MouseClicked
        verificaUserTypeCadastro();
    }//GEN-LAST:event_bt_Cliente2MouseClicked

    private void bt_CadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_CadastrarMouseClicked
        cadastraUser();
        limpaCamposCadastro();
    }//GEN-LAST:event_bt_CadastrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bt_Adm;
    private javax.swing.JRadioButton bt_Adm2;
    private javax.swing.JButton bt_Cadastrar;
    private javax.swing.JRadioButton bt_Cliente;
    private javax.swing.JRadioButton bt_Cliente2;
    private javax.swing.JButton bt_Login;
    private javax.swing.JButton bt_Sair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_Chave;
    private javax.swing.JLabel lb_NomeSupermercado;
    private javax.swing.JLabel lb_Senha;
    private javax.swing.JLabel lb_Senha2;
    private javax.swing.JLabel lb_Username;
    private javax.swing.JLabel lb_Username2;
    private javax.swing.JLabel lb_cpf;
    private javax.swing.JLabel lb_cpf2;
    private javax.swing.JPasswordField tf_Chave;
    private javax.swing.JPasswordField tf_Senha;
    private javax.swing.JPasswordField tf_Senha2;
    private javax.swing.JTextField tf_Username;
    private javax.swing.JTextField tf_Username2;
    private javax.swing.JTextField tf_cpf;
    private javax.swing.JTextField tf_cpf2;
    // End of variables declaration//GEN-END:variables
}
