package com.whatsappandroid.viniciusnunes.joiceapp.Model;

/**
 * Created by Vinicius Nunes on 15/12/2017.
 */
// CLASSE RESPONSAVEL PELO lOGIN DO CUIDADOR/Cliente

public class Usuario {

    private int id;
    private String tipoLogin;
    private String telefone;
    private String senha;
    private String nome;

    public Usuario() {
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoLogin() {
        return tipoLogin;
    }

    public void setTipoLogin(String tipoLogin) {
        this.tipoLogin = tipoLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
