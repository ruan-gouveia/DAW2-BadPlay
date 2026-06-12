package br.edu.ifpb.es.daw.repository;

import br.edu.ifpb.es.daw.entities.Temporada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemporadaRepository extends JpaRepository<Temporada, Long> {

    List<Temporada> findBySerie_Id(Long idSerie);
}