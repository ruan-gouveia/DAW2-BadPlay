package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.ConteudoResponseDTO;
import br.edu.ifpb.es.daw.service.ConteudoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conteudos")
@CrossOrigin(origins = "*")
@Tag(name = "Conteúdos", description = "Busca genérica de Filmes e Séries")
public class ConteudoController {

    private final ConteudoService conteudoService;

    public ConteudoController(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar conteúdos por parte do título")
    public ResponseEntity<List<ConteudoResponseDTO>> buscar(@RequestParam("q") String termo) {
        return ResponseEntity.ok(conteudoService.buscarPorTitulo(termo));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar detalhes de um conteúdo pelo ID")
    public ResponseEntity<ConteudoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(conteudoService.buscarPorId(id));
    }
}