package br.edu.ifpb.es.daw.repository;

import br.edu.ifpb.es.daw.entities.Filme;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    @EntityGraph(attributePaths = {"generos"})
    List<Filme> findAll();
}