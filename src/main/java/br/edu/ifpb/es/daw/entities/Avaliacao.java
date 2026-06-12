package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "tb_avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nota")
    private Double nota;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_conteudo")
    private Conteudo conteudo;

    public Avaliacao(){

    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao that = (Avaliacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Avaliacao{" + "id=" + id + ", nota=" + nota + "}";
    }

    public void setUsuario(Usuario u) {
        this.usuario = u;
    }

    public Conteudo getConteudo(){
        return conteudo;
    }

    public void setConteudo(Conteudo c) {
            this.conteudo = c;
    }
}
