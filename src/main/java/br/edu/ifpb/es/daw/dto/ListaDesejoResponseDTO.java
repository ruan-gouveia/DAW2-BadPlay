package br.edu.ifpb.es.daw.dto;

import br.edu.ifpb.es.daw.entities.ListaDesejo;
import java.time.LocalDateTime; // Import atualizado
import java.util.List;
import java.util.stream.Collectors;

public record ListaDesejoResponseDTO(
        Long idLista,
        String nome,
        LocalDateTime dataCriacao, // Tipo atualizado aqui
        Long idUsuario,
        String nomeUsuario,
        List<String> conteudos
) {
    public ListaDesejoResponseDTO(ListaDesejo lista) {
        this(
                lista.getIdLista(),
                lista.getNome(),
                lista.getDataCriacao(),
                lista.getUsuario().getIdUsuario(),
                lista.getUsuario().getNome(),
                lista.getConteudos().stream().map(c -> c.getTitulo()).collect(Collectors.toList())
        );
    }
}