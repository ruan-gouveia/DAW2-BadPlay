package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_temporada")
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_temporada")
    private Long idTemporada;

    @Column(name = "numero_temporada", nullable = false)
    private Integer numeroTemporada;

    public Temporada() {}

    public Long getIdTemporada() { return idTemporada; }
    public void setIdTemporada(Long idTemporada) { this.idTemporada = idTemporada; }

    public Integer getNumeroTemporada() { return numeroTemporada; }
    public void setNumeroTemporada(Integer numeroTemporada) { this.numeroTemporada = numeroTemporada; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temporada temporada = (Temporada) o;
        return Objects.equals(idTemporada, temporada.idTemporada);
    }

    @Override
    public int hashCode() { return Objects.hash(idTemporada); }

    @Override
    public String toString() { return "Temporada{idTemporada=" + idTemporada + ", numero=" + numeroTemporada + "}"; }
}