package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_serie")
public class Serie extends Conteudo{

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id_serie")
    //private Long id;

    @OneToMany(mappedBy = "serie")
    private List<Temporada> temporadas;
    public Serie() {}

    //public Long getIdSerie() { return id; }
    //public void setIdSerie(Long idSerie) { this.id = idSerie; }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Serie serie = (Serie) o;
//        return Objects.equals(id, serie.id);
//    }
//
//    @Override
//    public int hashCode() { return Objects.hash(id); }
//
//    @Override
//    public String toString() { return "Serie{idSerie=" + id + "}"; }


}