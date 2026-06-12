package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.SerieRequestDTO;
import br.edu.ifpb.es.daw.dto.SerieResponseDTO;
import br.edu.ifpb.es.daw.entities.Administrador;
import br.edu.ifpb.es.daw.entities.Genero;
import br.edu.ifpb.es.daw.entities.Serie;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.AdministradorRepository;
import br.edu.ifpb.es.daw.repository.SerieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {

    private final SerieRepository serieRepository;
    private final AdministradorRepository administradorRepository;
    private final GeneroService generoService;

    public SerieService(SerieRepository serieRepository, AdministradorRepository administradorRepository, GeneroService generoService) {
        this.serieRepository = serieRepository;
        this.administradorRepository = administradorRepository;
        this.generoService = generoService;
    }

    public List<SerieResponseDTO> listarTodos() {
        return serieRepository.findAll().stream()
                .map(SerieResponseDTO::new)
                .collect(Collectors.toList());
    }

    public SerieResponseDTO buscarPorId(Long id) {
        return serieRepository.findById(id)
                .map(SerieResponseDTO::new)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Série não encontrada"));
    }

    @Transactional
    public SerieResponseDTO salvar(SerieRequestDTO dto) {
        Administrador adm = administradorRepository.findById(dto.idAdministrador())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Administrador não encontrado!"));

        Serie serie = new Serie();
        serie.setTitulo(dto.titulo());
        serie.setDescricao(dto.descricao());
        serie.setTipo("SERIE");
        serie.setAdministrador(adm);

        if (dto.generosIds() != null && !dto.generosIds().isEmpty()) {
            List<Genero> generos = generoService.buscarEntidadesPorIds(dto.generosIds());
            serie.setGeneros(generos);
        }

        Serie salva = serieRepository.save(serie);
        return new SerieResponseDTO(salva);
    }

    @Transactional
    public void deletar(Long id) {
        if (!serieRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Série não encontrada");
        }
        serieRepository.deleteById(id);
    }
}