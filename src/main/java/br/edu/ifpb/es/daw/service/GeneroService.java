package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.GeneroRequestDTO;
import br.edu.ifpb.es.daw.dto.GeneroResponseDTO;
import br.edu.ifpb.es.daw.entities.Genero;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.GeneroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeneroService {

    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<GeneroResponseDTO> listarTodos() {
        return generoRepository.findAll().stream()
                .map(GeneroResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public GeneroResponseDTO salvar(GeneroRequestDTO dto) {
        Optional<Genero> existente = generoRepository.findByNomeIgnoreCase(dto.nome());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Este Gênero já existe!");
        }

        Genero genero = new Genero();
        genero.setNome(dto.nome());
        genero.setDescricao(dto.descricao());

        Genero salvo = generoRepository.save(genero);
        return new GeneroResponseDTO(salvo);
    }

    public List<Genero> buscarEntidadesPorIds(List<Long> ids) {
        return generoRepository.findAllById(ids);
    }

    @Transactional
    public GeneroResponseDTO atualizar(Long id, GeneroRequestDTO dto) {
        Genero genero = generoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Gênero não encontrado"));

        genero.setNome(dto.nome());
        genero.setDescricao(dto.descricao());

        return new GeneroResponseDTO(generoRepository.save(genero));
    }

}