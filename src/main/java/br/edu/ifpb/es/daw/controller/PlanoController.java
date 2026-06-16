package br.edu.ifpb.es.daw.controller;

import br.edu.ifpb.es.daw.dto.PlanoRequestDTO;
import br.edu.ifpb.es.daw.dto.PlanoResponseDTO;
import br.edu.ifpb.es.daw.service.PlanoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planos")
@CrossOrigin(origins = "*")
@Tag(name = "Planos", description = "Endpoints para gerenciamento de planos de assinatura")
public class PlanoController {
	
	  private final PlanoService planoService;

	    public PlanoController(PlanoService planoService) {
	        this.planoService = planoService;
	    }

	    @GetMapping
	    @Operation(summary = "Listar todos os planos")
	    public ResponseEntity<List<PlanoResponseDTO>> listarTodos() {
	        return ResponseEntity.ok(planoService.listarTodos());
	    }

	    @PostMapping
	    @Operation(summary = "Criar um novo plano")
	    public ResponseEntity<PlanoResponseDTO> criar(@Valid @RequestBody PlanoRequestDTO dto) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(planoService.salvar(dto));
	    }

		@PutMapping("/{id}")
		@Operation(summary = "Atualizar um plano existente")
		public ResponseEntity<PlanoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PlanoRequestDTO dto) {
			return ResponseEntity.ok(planoService.atualizar(id, dto));
		}

}
