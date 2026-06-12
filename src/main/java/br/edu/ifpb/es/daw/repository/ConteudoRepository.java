package br.edu.ifpb.es.daw.repository;

import br.edu.ifpb.es.daw.entities.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {
    List<Conteudo> findByTituloContainingIgnoreCaseOrderByTituloAsc(String termo);
}