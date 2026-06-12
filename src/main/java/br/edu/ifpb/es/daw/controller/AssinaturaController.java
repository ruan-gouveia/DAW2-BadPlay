package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.AssinaturaRequestDTO;
import br.edu.ifpb.es.daw.dto.AssinaturaResponseDTO;
import br.edu.ifpb.es.daw.service.AssinaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assinaturas")
@CrossOrigin(origins = "*")
@Tag(name = "Assinaturas", description = "Endpoints para gerenciamento de pagamentos e assinaturas")
public class AssinaturaController {

    private final AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @GetMapping
    @Operation(summary = "Listar todas as assinaturas")
    public ResponseEntity<List<AssinaturaResponseDTO>> listarTodos() {
        return ResponseEntity.ok(assinaturaService.listarTodos());
    }

    @PostMapping
    @Operation(summary = "Criar nova assinatura e cancelar a anterior se houver")
    public ResponseEntity<AssinaturaResponseDTO> assinar(@Valid @RequestBody AssinaturaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(assinaturaService.assinar(dto));
    }
}