package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.ConteudoResponseDTO;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.ConteudoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConteudoService {

    private final ConteudoRepository conteudoRepository;

    public ConteudoService(ConteudoRepository conteudoRepository) {
        this.conteudoRepository = conteudoRepository;
    }

    public List<ConteudoResponseDTO> buscarPorTitulo(String termo) {
        if (termo == null || termo.trim().length() < 2) {
            return List.of();
        }
        return conteudoRepository.findByTituloContainingIgnoreCaseOrderByTituloAsc(termo.trim())
                .stream()
                .map(ConteudoResponseDTO::daEntidade)
                .collect(Collectors.toList());
    }

    public ConteudoResponseDTO buscarPorId(Long id) {
        return conteudoRepository.findById(id)
                .map(ConteudoResponseDTO::daEntidade)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Conteúdo não encontrado com o ID: " + id));
    }
}