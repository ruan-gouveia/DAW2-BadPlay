package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.HistoricoRequestDTO;
import br.edu.ifpb.es.daw.dto.HistoricoResponseDTO;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.Historico;
import br.edu.ifpb.es.daw.entities.Usuario;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.ConteudoRepository;
import br.edu.ifpb.es.daw.repository.HistoricoRepository;
import br.edu.ifpb.es.daw.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ConteudoRepository conteudoRepository;

    public HistoricoService(HistoricoRepository historicoRepository, UsuarioRepository usuarioRepository, ConteudoRepository conteudoRepository) {
        this.historicoRepository = historicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.conteudoRepository = conteudoRepository;
    }

    public List<HistoricoResponseDTO> buscarHistoricoPorUsuario(Long idUsuario) {
        // Atualizado para chamar o método corrigido
        return historicoRepository.findByUsuario_IdOrderByTimestampDesc(idUsuario).stream()
                .map(HistoricoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public HistoricoResponseDTO registrarOuAtualizar(HistoricoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));

        Conteudo conteudo = conteudoRepository.findById(dto.idConteudo())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Conteúdo não encontrado"));

        Historico historico = historicoRepository
                .findByUsuario_IdAndConteudo_Id(usuario.getIdUsuario(), conteudo.getIdConteudo())
                .orElse(new Historico());

        if (historico.getId() == null) {
            historico.setUsuario(usuario);
            historico.setConteudo(conteudo);
        }

        historico.setTimestamp(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        return new HistoricoResponseDTO(historicoRepository.save(historico));
    }

    @Transactional
    public void deletar(Long id) {
        if (!historicoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Registro de histórico não encontrado");
        }
        historicoRepository.deleteById(id);
    }
}