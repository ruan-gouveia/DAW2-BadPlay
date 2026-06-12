package br.edu.ifpb.es.daw.repository;

import br.edu.ifpb.es.daw.entities.Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura, Long> {
    List<Assinatura> findAllByUsuario_IdAndStatus(Long idUsuario, String status);
}