package br.com.cadastrar.model;

public class Pessoa {

    private long id;
    private String nomePessoa;
    private String email;

    public Pessoa(long id, String nomePessoa, String email) {
        this.id = id;
        this.nomePessoa = nomePessoa;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}