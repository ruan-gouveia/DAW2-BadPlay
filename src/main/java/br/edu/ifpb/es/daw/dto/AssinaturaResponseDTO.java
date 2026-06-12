package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.Assinatura;
import java.time.LocalDate;

public record AssinaturaResponseDTO(
        Long id,
        LocalDate dataInicio,
        LocalDate dataFim,
        String status,
        String planoTipo,
        String usuarioNome,
        String usuarioEmail
) {
    public AssinaturaResponseDTO(Assinatura assinatura) {
        this(
                assinatura.getId(),
                assinatura.getDataInicio(),
                assinatura.getDataFim(),
                assinatura.getStatus(),
                assinatura.getPlano().getTipo().name(),
                assinatura.getUsuario().getNome(),
                assinatura.getUsuario().getEmail()
        );
    }
}