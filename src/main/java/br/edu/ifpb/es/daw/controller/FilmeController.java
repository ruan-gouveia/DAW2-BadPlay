package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.FilmeRequestDTO;
import br.edu.ifpb.es.daw.dto.FilmeResponseDTO;
import br.edu.ifpb.es.daw.service.FilmeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/filmes")
@CrossOrigin(origins = "*")
@Tag(name = "Filmes", description = "Endpoints para gerenciamento de Filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os filmes com paginação")
    public ResponseEntity<Page<FilmeResponseDTO>> listarTodos(Pageable pageable) {
        return ResponseEntity.ok(filmeService.listarTodos(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um filme pelo ID")
    public ResponseEntity<FilmeResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filmeService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo filme")
    public ResponseEntity<FilmeResponseDTO> criar(@Valid @RequestBody FilmeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.salvar(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um filme pelo ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        filmeService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um filme existente")
    public ResponseEntity<FilmeResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody FilmeRequestDTO dto) {
        return ResponseEntity.ok(filmeService.atualizar(id, dto));
    }

}