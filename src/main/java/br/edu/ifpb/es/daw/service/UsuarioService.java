package br.edu.ifpb.es.daw.service;

import br.edu.ifpb.es.daw.dto.UsuarioRequestDTO;
import br.edu.ifpb.es.daw.dto.UsuarioResponseDTO;
import br.edu.ifpb.es.daw.entities.Usuario;
import br.edu.ifpb.es.daw.exception.RecursoNaoEncontradoException;
import br.edu.ifpb.es.daw.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioResponseDTO> listarTodos() {

        return usuarioRepository.findAll().stream()
                .map(UsuarioResponseDTO::daEntidade)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO requestDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(requestDTO.nome());
        usuario.setEmail(requestDTO.email());
        usuario.setSenha(requestDTO.senha());
        usuario.setDataNascimento(requestDTO.dataNascimento());
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return UsuarioResponseDTO.daEntidade(usuarioSalvo);
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado com o ID: " + id));
        return UsuarioResponseDTO.daEntidade(usuario);
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO requestDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado para atualizar."));

        usuario.setNome(requestDTO.nome());
        usuario.setEmail(requestDTO.email());
        usuario.setSenha(requestDTO.senha());
        usuario.setDataNascimento(requestDTO.dataNascimento());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return UsuarioResponseDTO.daEntidade(usuarioAtualizado);
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Usuário não encontrado para deleção.");
        }
        usuarioRepository.deleteById(id);
    }

}