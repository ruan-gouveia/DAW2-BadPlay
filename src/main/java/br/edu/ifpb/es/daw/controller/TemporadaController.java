package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.TemporadaRequestDTO;
import br.edu.ifpb.es.daw.dto.TemporadaResponseDTO;
import br.edu.ifpb.es.daw.service.TemporadaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temporadas")
@CrossOrigin(origins = "*")
@Tag(name = "Temporadas", description = "Endpoints para gerenciamento de temporadas de Séries")
public class TemporadaController {

    private final TemporadaService temporadaService;

    public TemporadaController(TemporadaService temporadaService) {
        this.temporadaService = temporadaService;
    }

    @GetMapping
    @Operation(summary = "Listar todas as temporadas")
    public ResponseEntity<List<TemporadaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(temporadaService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar temporada por ID")
    public ResponseEntity<TemporadaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(temporadaService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar nova temporada vinculada a uma Série")
    public ResponseEntity<TemporadaResponseDTO> criar(@Valid @RequestBody TemporadaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(temporadaService.salvar(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar temporada por ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        temporadaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma temporada existente")
    public ResponseEntity<TemporadaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody TemporadaRequestDTO dto) {
        return ResponseEntity.ok(temporadaService.atualizar(id, dto));
    }

}