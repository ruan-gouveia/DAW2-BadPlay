package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_filme")
public class Filme extends Conteudo { // Deve remover o campo id para a herança funcionar

    // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_filme")
    //private Long id;

    @Column(name = "url_filme")
    private String urlFilme;

    @Column(name = "duracao_minutos")
    private Integer duracao;

    public Filme() {}

    // public Long getIdFilme() { return id; }
    // public void setIdFilme(Long idFilme) { this.id = idFilme; }

    public String getUrlFilme() { return urlFilme; }
    public void setUrlFilme(String urlFilme) { this.urlFilme = urlFilme; }

    public Integer getDuracao() { return duracao; }
    public void setDuracao(Integer duracao) { this.duracao = duracao; }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Filme filme = (Filme) o;
//        return Objects.equals(id, filme.id);
//    }
//
//    @Override
//    public int hashCode() { return Objects.hash(id); }
//
//    @Override
//    public String toString() {
//        return "Filme{idFilme=" + id + ", urlFilme='" + urlFilme + "'}";
//    }
}