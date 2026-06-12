package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.AvaliacaoRequestDTO;
import br.edu.ifpb.es.daw.dto.AvaliacaoResponseDTO;
import br.edu.ifpb.es.daw.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
@CrossOrigin(origins = "*")
@Tag(name = "Avaliações", description = "Endpoints para usuários avaliarem conteúdos")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    @Operation(summary = "Listar todas as avaliações")
    public ResponseEntity<List<AvaliacaoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(avaliacaoService.listarTodos());
    }

    @GetMapping("/conteudo/{conteudoId}")
    @Operation(summary = "Listar avaliações de um conteúdo específico")
    public ResponseEntity<List<AvaliacaoResponseDTO>> listarPorConteudo(@PathVariable Long conteudoId) {
        return ResponseEntity.ok(avaliacaoService.buscarPorConteudo(conteudoId));
    }

    @PostMapping
    @Operation(summary = "Avaliar ou atualizar a nota de um conteúdo")
    public ResponseEntity<AvaliacaoResponseDTO> avaliar(@Valid @RequestBody AvaliacaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.salvar(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar avaliação por ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        avaliacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}