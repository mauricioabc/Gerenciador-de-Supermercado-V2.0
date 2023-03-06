package com.supermarket.market;

public class admin {
    private String username;
    private String cpf;
    private String senha;

    public admin(String username, String cpf, String senha) {
        this.username = username;
        this.cpf = cpf;
        this.senha = senha;
    }

    public admin() {
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "admin{" + "username=" + username + ", cpf=" + cpf + ", senha=" + senha + '}';
    }
    
    
    
}
