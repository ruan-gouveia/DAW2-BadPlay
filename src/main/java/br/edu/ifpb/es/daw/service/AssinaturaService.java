package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.AssinaturaRequestDTO;
import br.edu.ifpb.es.daw.dto.AssinaturaResponseDTO;
import br.edu.ifpb.es.daw.entities.Assinatura;
import br.edu.ifpb.es.daw.entities.Plano;
import br.edu.ifpb.es.daw.entities.Usuario;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.AssinaturaRepository;
import br.edu.ifpb.es.daw.repository.PlanoRepository;
import br.edu.ifpb.es.daw.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssinaturaService {

    private final AssinaturaRepository assinaturaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PlanoRepository planoRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository, UsuarioRepository usuarioRepository, PlanoRepository planoRepository) {
        this.assinaturaRepository = assinaturaRepository;
        this.usuarioRepository = usuarioRepository;
        this.planoRepository = planoRepository;
    }

    public List<AssinaturaResponseDTO> listarTodos() {
        return assinaturaRepository.findAll().stream().map(AssinaturaResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public AssinaturaResponseDTO assinar(AssinaturaRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado no banco"));

        Plano plano = planoRepository.findById(dto.idPlano())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Plano não encontrado"));


        List<Assinatura> ativas = assinaturaRepository.findAllByUsuario_IdAndStatus(usuario.getIdUsuario(), "ATIVA");
        for (Assinatura ativa :ativas) {
            ativa.setStatus("CANCELADA");
            assinaturaRepository.save(ativa);
        }

        Assinatura assinatura = new Assinatura();
        assinatura.setUsuario(usuario);
        assinatura.setPlano(plano);
        assinatura.setDataInicio(LocalDate.now());
        assinatura.setDataFim(LocalDate.now().plusDays(30));
        assinatura.setStatus("ATIVA");

        return new AssinaturaResponseDTO(assinaturaRepository.save(assinatura));
    }
}