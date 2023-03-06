package com.supermarket.market;

public class user {
    
    private String username;
    private String cpf;

    public user(String username, String cpf) {
        this.username = username;
        this.cpf = cpf;
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

    @Override
    public String toString() {
        return "user{" + "username=" + username + ", cpf=" + cpf + '}';
    }
    
    
    
}
