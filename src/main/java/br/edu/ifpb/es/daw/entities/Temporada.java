package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_temporada")
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_temporada")
    private Long id;

    @Column(name = "numero_temporada", nullable = false)
    private Integer numeroTemporada;

    @ManyToOne
    @JoinColumn(name = "id_serie")
    private Serie serie;
    @OneToMany(mappedBy = "temporada")
    private List<Episodio> episodios;

    public Temporada() {}

    public Long getIdTemporada() { return id; }
    public void setIdTemporada(Long idTemporada) { this.id = idTemporada; }

    public Integer getNumeroTemporada() { return numeroTemporada; }
    public void setNumeroTemporada(Integer numeroTemporada) { this.numeroTemporada = numeroTemporada; }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temporada temporada = (Temporada) o;
        return Objects.equals(id, temporada.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() { return "Temporada{idTemporada=" + id + ", numero=" + numeroTemporada + "}"; }
}