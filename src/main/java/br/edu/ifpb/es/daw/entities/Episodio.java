package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_episodio")
public class Episodio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_episodio")
    private Long idEpisodio;

    @Column(name = "duracao_minutos")
    private Integer duracao;

    @Column(name = "numero_episodio")
    private Integer numeroEpisodio;

    @Column(name = "url_episodio")
    private String urlEpisodio;

    public Episodio() {}

    public Long getIdEpisodio() { return idEpisodio; }
    public void setIdEpisodio(Long idEpisodio) { this.idEpisodio = idEpisodio; }

    public Integer getDuracao() { return duracao; }
    public void setDuracao(Integer duracao) { this.duracao = duracao; }

    public Integer getNumeroEpisodio() { return numeroEpisodio; }
    public void setNumeroEpisodio(Integer numeroEpisodio) { this.numeroEpisodio = numeroEpisodio; }

    public String getUrlEpisodio() { return urlEpisodio; }
    public void setUrlEpisodio(String urlEpisodio) { this.urlEpisodio = urlEpisodio; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episodio episodio = (Episodio) o;
        return Objects.equals(idEpisodio, episodio.idEpisodio);
    }

    @Override
    public int hashCode() { return Objects.hash(idEpisodio); }

    @Override
    public String toString() { return "Episodio{idEpisodio=" + idEpisodio + ", numero=" + numeroEpisodio + "}"; }
}