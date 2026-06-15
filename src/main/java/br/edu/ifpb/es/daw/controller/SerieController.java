package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.SerieRequestDTO;
import br.edu.ifpb.es.daw.dto.SerieResponseDTO;
import br.edu.ifpb.es.daw.service.SerieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/series")
@CrossOrigin(origins = "*")
@Tag(name = "Séries", description = "Endpoints para gerenciamento de Séries")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    @Operation(summary = "Listar todas as séries com paginação")
    public ResponseEntity<Page<SerieResponseDTO>> listarTodos(Pageable pageable) {
        return ResponseEntity.ok(serieService.listarTodos(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar série por ID")
    public ResponseEntity<SerieResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar nova série")
    public ResponseEntity<SerieResponseDTO> criar(@Valid @RequestBody SerieRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serieService.salvar(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar série por ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        serieService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}