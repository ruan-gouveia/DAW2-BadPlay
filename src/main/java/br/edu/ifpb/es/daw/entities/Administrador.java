package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToMany(mappedBy = "administrador")
    private List<Conteudo> conteudosGerenciados;

    public Administrador() {}

    public Long getIdAdministrador() { return id; }
    public void setIdAdministrador(Long idAdministrador) { this.id = idAdministrador; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public List<Conteudo> getConteudosGerenciados() {
        return conteudosGerenciados;
    }

    public void setConteudosGerenciados(List<Conteudo> conteudosGerenciados) {
        this.conteudosGerenciados = conteudosGerenciados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrador that = (Administrador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Administrador{idAdministrador=" + id + ", nome='" + nome + "', email='" + email + "'}";
    }
}