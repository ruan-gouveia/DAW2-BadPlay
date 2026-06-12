package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.GeneroRequestDTO;
import br.edu.ifpb.es.daw.dto.GeneroResponseDTO;
import br.edu.ifpb.es.daw.service.GeneroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
@CrossOrigin(origins = "*")
@Tag(name = "Gêneros", description = "Endpoints para gerenciamento de gêneros de conteúdo")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os gêneros")
    public ResponseEntity<List<GeneroResponseDTO>> listar() {
        return ResponseEntity.ok(generoService.listarTodos());
    }

    @PostMapping
    @Operation(summary = "Criar um novo gênero")
    public ResponseEntity<GeneroResponseDTO> criar(@Valid @RequestBody GeneroRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(generoService.salvar(dto));
    }
}