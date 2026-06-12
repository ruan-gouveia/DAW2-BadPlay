package br.edu.ifpb.es.daw.repository;

import br.edu.ifpb.es.daw.entities.Episodio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodioRepository extends JpaRepository<Episodio, Long> {

    List<Episodio> findByTemporada_Id(Long idTemporada);
}