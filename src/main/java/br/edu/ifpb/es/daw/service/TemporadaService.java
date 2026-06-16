package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.TemporadaRequestDTO;
import br.edu.ifpb.es.daw.dto.TemporadaResponseDTO;
import br.edu.ifpb.es.daw.entities.Serie;
import br.edu.ifpb.es.daw.entities.Temporada;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.SerieRepository;
import br.edu.ifpb.es.daw.repository.TemporadaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemporadaService {

    private final TemporadaRepository temporadaRepository;
    private final SerieRepository serieRepository;

    public TemporadaService(TemporadaRepository temporadaRepository, SerieRepository serieRepository) {
        this.temporadaRepository = temporadaRepository;
        this.serieRepository = serieRepository;
    }

    public List<TemporadaResponseDTO> listarTodos() {
        return temporadaRepository.findAll().stream()
                .map(TemporadaResponseDTO::new)
                .collect(Collectors.toList());
    }

    public TemporadaResponseDTO buscarPorId(Long id) {
        return temporadaRepository.findById(id)
                .map(TemporadaResponseDTO::new)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Temporada não encontrada"));
    }

    @Transactional
    public TemporadaResponseDTO salvar(TemporadaRequestDTO dto) {
        Serie serie = serieRepository.findById(dto.idSerie())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Série não encontrada"));

        Temporada temporada = new Temporada();
        temporada.setNumeroTemporada(dto.numeroTemporada());
        temporada.setSerie(serie); // Vínculo da associação

        Temporada salva = temporadaRepository.save(temporada);
        return new TemporadaResponseDTO(salva);
    }

    @Transactional
    public void deletar(Long id) {
        if (!temporadaRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Temporada não encontrada");
        }
        temporadaRepository.deleteById(id);
    }

    @Transactional
    public TemporadaResponseDTO atualizar(Long id, TemporadaRequestDTO dto) {
        Temporada temporada = temporadaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Temporada não encontrada"));

        Serie serie = serieRepository.findById(dto.idSerie())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Série não encontrada"));

        temporada.setNumeroTemporada(dto.numeroTemporada());
        temporada.setSerie(serie);

        return new TemporadaResponseDTO(temporadaRepository.save(temporada));
    }

}