package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private Long idGenero;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    public Genero() {}

    public Long getIdGenero() { return idGenero; }
    public void setIdGenero(Long idGenero) { this.idGenero = idGenero; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(idGenero, genero.idGenero);
    }

    @Override
    public int hashCode() { return Objects.hash(idGenero); }

    @Override
    public String toString() { return "Genero{idGenero=" + idGenero + ", nome='" + nome + "'}"; }
}