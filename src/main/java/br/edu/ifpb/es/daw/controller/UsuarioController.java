package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.UsuarioRequestDTO;
import br.edu.ifpb.es.daw.dto.UsuarioResponseDTO;
import br.edu.ifpb.es.daw.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuários", description = "Endpoints para gerenciamento de usuários do BadPlay")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os usuários")
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um usuário pelo ID")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar um novo usuário")
    public UsuarioResponseDTO criar(@Valid @RequestBody UsuarioRequestDTO requestDTO) {
        return usuarioService.criar(requestDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um usuário existente")
    public UsuarioResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO requestDTO) {
        return usuarioService.atualizar(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar um usuário pelo ID")
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}