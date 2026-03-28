package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_conteudo")
public class Conteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conteudo")
    private Long idConteudo;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "tipo")
    private String tipo;

    public Conteudo() {}

    public Long getIdConteudo() { return idConteudo; }
    public void setIdConteudo(Long idConteudo) { this.idConteudo = idConteudo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conteudo conteudo = (Conteudo) o;
        return Objects.equals(idConteudo, conteudo.idConteudo);
    }

    @Override
    public int hashCode() { return Objects.hash(idConteudo); }

    @Override
    public String toString() {
        return "Conteudo{idConteudo=" + idConteudo + ", titulo='" + titulo + "'}";
    }
}