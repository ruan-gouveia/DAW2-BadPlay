package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.AdministradorRequestDTO;
import br.edu.ifpb.es.daw.dto.AdministradorResponseDTO;
import br.edu.ifpb.es.daw.entities.Administrador;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.AdministradorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdministradorService {

    private final AdministradorRepository administradorRepository;

    public AdministradorService(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public List<AdministradorResponseDTO> listarTodos() {
        return administradorRepository.findAll().stream()
                .map(AdministradorResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public AdministradorResponseDTO salvar(AdministradorRequestDTO dto) {
        Optional<Administrador> existente = administradorRepository.findByEmail(dto.email());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Já existe um administrador cadastrado com este e-mail!");
        }

        Administrador adm = new Administrador();
        adm.setNome(dto.nome());
        adm.setEmail(dto.email());
        adm.setSenha(dto.senha());

        Administrador salvo = administradorRepository.save(adm);
        return new AdministradorResponseDTO(salvo);
    }

    @Transactional
    public AdministradorResponseDTO atualizar(Long id, AdministradorRequestDTO dto) {
        Administrador adm = administradorRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Administrador não encontrado"));

        adm.setNome(dto.nome());
        adm.setEmail(dto.email());
        adm.setSenha(dto.senha());

        return new AdministradorResponseDTO(administradorRepository.save(adm));
    }
}