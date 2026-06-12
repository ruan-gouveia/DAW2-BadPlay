package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.ListaDesejoRequestDTO;
import br.edu.ifpb.es.daw.dto.ListaDesejoResponseDTO;
import br.edu.ifpb.es.daw.entities.Conteudo;
import br.edu.ifpb.es.daw.entities.ListaDesejo;
import br.edu.ifpb.es.daw.entities.Usuario;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.ConteudoRepository;
import br.edu.ifpb.es.daw.repository.ListaDesejoRepository;
import br.edu.ifpb.es.daw.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListaDesejoService {

    private final ListaDesejoRepository listaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ConteudoRepository conteudoRepository;

    public ListaDesejoService(ListaDesejoRepository listaRepository, UsuarioRepository usuarioRepository, ConteudoRepository conteudoRepository) {
        this.listaRepository = listaRepository;
        this.usuarioRepository = usuarioRepository;
        this.conteudoRepository = conteudoRepository;
    }

    public List<ListaDesejoResponseDTO> listarTodos() {
        return listaRepository.findAll().stream().map(ListaDesejoResponseDTO::new).collect(Collectors.toList());
    }

    public List<ListaDesejoResponseDTO> buscarPorUsuario(Long idUsuario) {
        return listaRepository.findByUsuario_Id(idUsuario).stream()
                .map(ListaDesejoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ListaDesejoResponseDTO criarLista(ListaDesejoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.idUsuario())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));

        ListaDesejo lista = new ListaDesejo();
        lista.setNome(dto.nome());
        lista.setUsuario(usuario);
        lista.setDataCriacao(java.time.LocalDateTime.now());

        ListaDesejo salva = listaRepository.save(lista);
        return new ListaDesejoResponseDTO(salva);
    }

    @Transactional
    public ListaDesejoResponseDTO adicionarConteudo(Long listaId, Long conteudoId) {
        ListaDesejo lista = listaRepository.findById(listaId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Lista não encontrada"));

        Conteudo conteudo = conteudoRepository.findById(conteudoId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Conteúdo não encontrado"));

        if (!lista.getConteudos().contains(conteudo)) {
            lista.getConteudos().add(conteudo);
            listaRepository.save(lista);
        }

        return new ListaDesejoResponseDTO(lista);
    }

    @Transactional
    public ListaDesejoResponseDTO removerConteudo(Long listaId, Long conteudoId) {
        ListaDesejo lista = listaRepository.findById(listaId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Lista não encontrada"));

        Conteudo conteudo = conteudoRepository.findById(conteudoId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Conteúdo não encontrado"));

        lista.getConteudos().remove(conteudo);
        return new ListaDesejoResponseDTO(listaRepository.save(lista));
    }

    @Transactional
    public void deletarLista(Long listaId) {
        if (!listaRepository.existsById(listaId)) {
            throw new RecursoNaoEncontradoException("Lista não encontrada");
        }
        listaRepository.deleteById(listaId);
    }
}