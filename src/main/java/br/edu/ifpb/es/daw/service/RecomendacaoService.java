package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.RecomendacaoRequestDTO;
import br.edu.ifpb.es.daw.dto.RecomendacaoResponseDTO;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Recomendacao;
import br.edu.ifpb.es.daw.entities.Usuario;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.ConteudoRepository;
import br.edu.ifpb.es.daw.repository.RecomendacaoRepository;
import br.edu.ifpb.es.daw.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecomendacaoService {

    private final RecomendacaoRepository recomendacaoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ConteudoRepository conteudoRepository;

    public RecomendacaoService(RecomendacaoRepository recomendacaoRepository, UsuarioRepository usuarioRepository, ConteudoRepository conteudoRepository) {
        this.recomendacaoRepository = recomendacaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.conteudoRepository = conteudoRepository;
    }

    public List<RecomendacaoResponseDTO> listarPorUsuario(Long idUsuario) {

        return recomendacaoRepository.findByUsuario_Id(idUsuario).stream()
                .map(RecomendacaoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public RecomendacaoResponseDTO salvar(RecomendacaoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));

        Conteudo conteudo = conteudoRepository.findById(dto.idConteudo())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Conteúdo não encontrado"));

        Recomendacao rec = new Recomendacao();
        rec.setUsuario(usuario);
        rec.setConteudo(conteudo);
        rec.setMotivo(dto.motivo());

        return new RecomendacaoResponseDTO(recomendacaoRepository.save(rec));
    }

    @Transactional
    public void deletar(Long id) {
        if (!recomendacaoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Recomendação não encontrada");
        }
        recomendacaoRepository.deleteById(id);
    }
}