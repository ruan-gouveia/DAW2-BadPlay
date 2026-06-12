package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.EpisodioRequestDTO;
import br.edu.ifpb.es.daw.dto.EpisodioResponseDTO;
import br.edu.ifpb.es.daw.entities.Episodio;
import br.edu.ifpb.es.daw.entities.Temporada;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.EpisodioRepository;
import br.edu.ifpb.es.daw.repository.TemporadaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodioService {

    private final EpisodioRepository episodioRepository;
    private final TemporadaRepository temporadaRepository;

    public EpisodioService(EpisodioRepository episodioRepository, TemporadaRepository temporadaRepository) {
        this.episodioRepository = episodioRepository;
        this.temporadaRepository = temporadaRepository;
    }

    public List<EpisodioResponseDTO> listarTodos() {
        return episodioRepository.findAll().stream()
                .map(EpisodioResponseDTO::new)
                .collect(Collectors.toList());
    }

    public EpisodioResponseDTO buscarPorId(Long id) {
        return episodioRepository.findById(id)
                .map(EpisodioResponseDTO::new)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Episódio não encontrado"));
    }

    @Transactional
    public EpisodioResponseDTO salvar(EpisodioRequestDTO dto) {
        Temporada temporada = temporadaRepository.findById(dto.idTemporada())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Temporada não encontrada"));

        Episodio ep = new Episodio();
        ep.setNomeEpisodio(dto.nomeEpisodio());
        ep.setNumeroEpisodio(dto.numeroEpisodio());
        ep.setDuracao(dto.duracaoMinutos());
        ep.setUrlEpisodio(dto.urlEpisodio());
        ep.setTemporada(temporada);

        Episodio salvo = episodioRepository.save(ep);
        return new EpisodioResponseDTO(salvo);
    }

    @Transactional
    public void deletar(Long id) {
        if (!episodioRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Episódio não encontrado");
        }
        episodioRepository.deleteById(id);
    }
}