package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.EpisodioRequestDTO;
import br.edu.ifpb.es.daw.dto.EpisodioResponseDTO;
import br.edu.ifpb.es.daw.service.EpisodioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodios")
@CrossOrigin(origins = "*")
@Tag(name = "Episódios", description = "Endpoints para gerenciamento de Episódios")
public class EpisodioController {

    private final EpisodioService episodioService;

    public EpisodioController(EpisodioService episodioService) {
        this.episodioService = episodioService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os episódios")
    public ResponseEntity<List<EpisodioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(episodioService.listarTodos());
    }

    @PostMapping
    @Operation(summary = "Criar novo episódio vinculado a uma Temporada")
    public ResponseEntity<EpisodioResponseDTO> criar(@Valid @RequestBody EpisodioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(episodioService.salvar(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar episódio por ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        episodioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um episódio existente")
    public ResponseEntity<EpisodioResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EpisodioRequestDTO dto) {
        return ResponseEntity.ok(episodioService.atualizar(id, dto));
    }

}