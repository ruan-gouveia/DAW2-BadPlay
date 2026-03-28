package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_serie")
    private Long idSerie;

    public Serie() {}

    public Long getIdSerie() { return idSerie; }
    public void setIdSerie(Long idSerie) { this.idSerie = idSerie; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(idSerie, serie.idSerie);
    }

    @Override
    public int hashCode() { return Objects.hash(idSerie); }

    @Override
    public String toString() { return "Serie{idSerie=" + idSerie + "}"; }
}