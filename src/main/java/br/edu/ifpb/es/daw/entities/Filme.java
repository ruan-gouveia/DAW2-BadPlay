package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filme")
    private Long idFilme;

    @Column(name = "url_filme")
    private String urlFilme;

    @Column(name = "duracao_minutos")
    private Integer duracao;

    public Filme() {}

    public Long getIdFilme() { return idFilme; }
    public void setIdFilme(Long idFilme) { this.idFilme = idFilme; }

    public String getUrlFilme() { return urlFilme; }
    public void setUrlFilme(String urlFilme) { this.urlFilme = urlFilme; }

    public Integer getDuracao() { return duracao; }
    public void setDuracao(Integer duracao) { this.duracao = duracao; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(idFilme, filme.idFilme);
    }

    @Override
    public int hashCode() { return Objects.hash(idFilme); }

    @Override
    public String toString() {
        return "Filme{idFilme=" + idFilme + ", urlFilme='" + urlFilme + "'}";
    }
}