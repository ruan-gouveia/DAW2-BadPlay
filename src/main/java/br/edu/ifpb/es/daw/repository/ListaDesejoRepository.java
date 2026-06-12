package br.edu.ifpb.es.daw.repository;

import br.edu.ifpb.es.daw.entities.ListaDesejo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaDesejoRepository extends JpaRepository<ListaDesejo, Long> {

    List<ListaDesejo> findByUsuario_Id(Long idUsuario);

    @Modifying
    @Query(value = "DELETE FROM tb_lista_conteudo WHERE id_conteudo = :conteudoId", nativeQuery = true)
    void deleteConteudoFromAllListas(@Param("conteudoId") Long conteudoId);
}