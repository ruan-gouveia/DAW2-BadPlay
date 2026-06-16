package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.AdministradorRequestDTO;
import br.edu.ifpb.es.daw.dto.AdministradorResponseDTO;
import br.edu.ifpb.es.daw.service.AdministradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
@CrossOrigin(origins = "*")
@Tag(name = "Administradores", description = "Endpoints para gerenciamento de administradores")
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os administradores")
    public ResponseEntity<List<AdministradorResponseDTO>> listar() {
        return ResponseEntity.ok(administradorService.listarTodos());
    }

    @PostMapping
    @Operation(summary = "Criar um novo administrador")
    public ResponseEntity<AdministradorResponseDTO> criar(@Valid @RequestBody AdministradorRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorService.salvar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um administrador existente")
    public ResponseEntity<AdministradorResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AdministradorRequestDTO dto) {
        return ResponseEntity.ok(administradorService.atualizar(id, dto));
    }

}