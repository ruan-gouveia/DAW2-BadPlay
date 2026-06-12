package br.edu.ifpb.es.daw.repository;

import br.edu.ifpb.es.daw.entities.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    List<Historico> findByUsuario_IdOrderByTimestampDesc(Long idUsuario);

    Optional<Historico> findByUsuario_IdAndConteudo_Id(Long idUsuario, Long idConteudo);
}