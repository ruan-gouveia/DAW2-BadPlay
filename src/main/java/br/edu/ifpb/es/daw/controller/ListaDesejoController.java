package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.ListaDesejoRequestDTO;
import br.edu.ifpb.es.daw.dto.ListaDesejoResponseDTO;
import br.edu.ifpb.es.daw.service.ListaDesejoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
@CrossOrigin(origins = "*")
@Tag(name = "Listas de Desejo", description = "Endpoints para gerenciamento de listas de filmes/séries")
public class ListaDesejoController {

    private final ListaDesejoService listaService;

    public ListaDesejoController(ListaDesejoService listaService) {
        this.listaService = listaService;
    }

    @GetMapping
    @Operation(summary = "Listar todas as listas do sistema")
    public ResponseEntity<List<ListaDesejoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(listaService.listarTodos());
    }

    @GetMapping("/usuario/{idUsuario}")
    @Operation(summary = "Buscar listas de um usuário específico")
    public ResponseEntity<List<ListaDesejoResponseDTO>> buscarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(listaService.buscarPorUsuario(idUsuario));
    }

    @PostMapping
    @Operation(summary = "Criar nova lista de desejos")
    public ResponseEntity<ListaDesejoResponseDTO> criar(@Valid @RequestBody ListaDesejoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(listaService.criarLista(dto));
    }

    @PutMapping("/{listaId}/adicionar/{conteudoId}")
    @Operation(summary = "Adicionar conteúdo à lista")
    public ResponseEntity<ListaDesejoResponseDTO> adicionarConteudo(@PathVariable Long listaId, @PathVariable Long conteudoId) {
        return ResponseEntity.ok(listaService.adicionarConteudo(listaId, conteudoId));
    }

    @DeleteMapping("/{listaId}/remover/{conteudoId}")
    @Operation(summary = "Remover conteúdo da lista")
    public ResponseEntity<ListaDesejoResponseDTO> removerConteudo(@PathVariable Long listaId, @PathVariable Long conteudoId) {
        return ResponseEntity.ok(listaService.removerConteudo(listaId, conteudoId));
    }

    @DeleteMapping("/{listaId}")
    @Operation(summary = "Deletar lista de desejos")
    public ResponseEntity<Void> deletarLista(@PathVariable Long listaId) {
        listaService.deletarLista(listaId);
        return ResponseEntity.noContent().build();
    }
}