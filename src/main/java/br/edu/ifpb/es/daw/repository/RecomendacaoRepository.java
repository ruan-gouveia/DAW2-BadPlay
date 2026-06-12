package br.edu.ifpb.es.daw.repository;

import br.edu.ifpb.es.daw.entities.Recomendacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecomendacaoRepository extends JpaRepository<Recomendacao, Long> {

    List<Recomendacao> findByUsuario_Id(Long idUsuario);
}