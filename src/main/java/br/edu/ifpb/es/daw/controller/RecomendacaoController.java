package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.RecomendacaoRequestDTO;
import br.edu.ifpb.es.daw.dto.RecomendacaoResponseDTO;
import br.edu.ifpb.es.daw.service.RecomendacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recomendacoes")
@CrossOrigin(origins = "*")
@Tag(name = "Recomendações", description = "Endpoints de recomendações de conteúdo para o usuário")
public class RecomendacaoController {

    private final RecomendacaoService recomendacaoService;

    public RecomendacaoController(RecomendacaoService recomendacaoService) {
        this.recomendacaoService = recomendacaoService;
    }

    @PostMapping
    @Operation(summary = "Criar recomendação para um usuário")
    public ResponseEntity<RecomendacaoResponseDTO> criar(@Valid @RequestBody RecomendacaoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recomendacaoService.salvar(dto));
    }

    @GetMapping("/usuario/{idUsuario}")
    @Operation(summary = "Listar as recomendações feitas para um usuário")
    public ResponseEntity<List<RecomendacaoResponseDTO>> listarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(recomendacaoService.listarPorUsuario(idUsuario));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma recomendação")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        recomendacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}