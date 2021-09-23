package br.ulbra.model;

/**
 *
 * @author troll
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String fone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "usuario{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", fone=" + fone + '}';
    }
    
    
}
