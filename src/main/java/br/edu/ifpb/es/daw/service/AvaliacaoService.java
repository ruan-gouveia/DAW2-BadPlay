package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.AvaliacaoRequestDTO;
import br.edu.ifpb.es.daw.dto.AvaliacaoResponseDTO;
import br.edu.ifpb.es.daw.entities.Avaliacao;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Usuario;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.AvaliacaoRepository;
import br.edu.ifpb.es.daw.repository.ConteudoRepository;
import br.edu.ifpb.es.daw.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ConteudoRepository conteudoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, UsuarioRepository usuarioRepository, ConteudoRepository conteudoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.conteudoRepository = conteudoRepository;
    }

    public List<AvaliacaoResponseDTO> listarTodos() {
        return avaliacaoRepository.findAll().stream().map(AvaliacaoResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public AvaliacaoResponseDTO salvar(AvaliacaoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));

        Conteudo conteudo = conteudoRepository.findById(dto.idConteudo())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Conteúdo não encontrado"));

        Avaliacao avaliacao = avaliacaoRepository
                .findByUsuario_IdAndConteudo_Id(usuario.getIdUsuario(), conteudo.getIdConteudo())
                .orElse(new Avaliacao());

        if (avaliacao.getId() == null) {
            avaliacao.setUsuario(usuario);
            avaliacao.setConteudo(conteudo);
        }

        avaliacao.setNota(dto.nota());
        return new AvaliacaoResponseDTO(avaliacaoRepository.save(avaliacao));
    }

    public List<AvaliacaoResponseDTO> buscarPorConteudo(Long conteudoId) {
        return avaliacaoRepository.findByConteudo_Id(conteudoId).stream()
                .map(AvaliacaoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletar(Long id) {
        if (!avaliacaoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Avaliação não encontrada");
        }
        avaliacaoRepository.deleteById(id);
    }
}