package com.supermarket.market;

import java.awt.BorderLayout;

public class Janela extends javax.swing.JFrame {

    static Janela_Login p1;
    static Janela_Cadastro p2;
    static Janela_Compra p3;
    static Janela_Carrinho p4;
    static Janela_NFe p5;
    
    public Janela() {
        initComponents();
        
        this.setLayout(new BorderLayout());
        
        p1 = new Janela_Login();
        
        this.add(p1, BorderLayout.CENTER);
        this.pack();
        
//        p2 = new Janela_Cadastro();
//        
//        this.add(p2, BorderLayout.CENTER);
//        this.pack();

//        p3 = new Janela_Compra();
//        
//        this.add(p3, BorderLayout.CENTER);
//        this.pack();
        
//        p4 = new Janela_Carrinho();
//        
//        this.add(p4, BorderLayout.CENTER);
//        this.pack();

//        p5 = new Janela_NFe();
//        
//        this.add(p5, BorderLayout.CENTER);
//        this.pack();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
