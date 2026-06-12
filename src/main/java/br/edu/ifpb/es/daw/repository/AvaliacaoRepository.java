package br.edu.ifpb.es.daw.repository;

import br.edu.ifpb.es.daw.entities.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    List<Avaliacao> findByConteudo_Id(Long idConteudo);

    Optional<Avaliacao> findByUsuario_IdAndConteudo_Id(Long idUsuario, Long idConteudo);

    @Modifying
    @Query("DELETE FROM Avaliacao a WHERE a.conteudo.id = :conteudoId")
    void deleteByConteudoId(@Param("conteudoId") Long conteudoId);
}