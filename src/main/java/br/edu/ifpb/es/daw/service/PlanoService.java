package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.PlanoRequestDTO;
import br.edu.ifpb.es.daw.dto.PlanoResponseDTO;
import br.edu.ifpb.es.daw.entities.Plano;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.PlanoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public List<PlanoResponseDTO> listarTodos() {
        return planoRepository.findAll().stream()
                .map(PlanoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public PlanoResponseDTO salvar(PlanoRequestDTO dto) {
        Plano plano = new Plano();
        plano.setTipo(dto.tipo());
        plano.setValor(dto.valor());

        Plano planoSalvo = planoRepository.save(plano);
        return new PlanoResponseDTO(planoSalvo);
    }

    @Transactional
    public PlanoResponseDTO atualizar(Long id, PlanoRequestDTO dto) {
        Plano plano = planoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Plano não encontrado"));
        plano.setTipo(dto.tipo());
        plano.setValor(dto.valor());
        return new PlanoResponseDTO(planoRepository.save(plano));
    }
}