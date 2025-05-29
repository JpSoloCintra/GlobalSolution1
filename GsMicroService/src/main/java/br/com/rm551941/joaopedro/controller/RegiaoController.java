package br.com.rm551941.joaopedro.controller;

import br.com.rm551941.joaopedro.dto.RegiaoDTO;
import br.com.rm551941.joaopedro.dto.RegiaoCreateDTO;
import br.com.rm551941.joaopedro.service.RegiaoService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regioes")
public class RegiaoController {

	private final RegiaoService service;

	public RegiaoController(RegiaoService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<RegiaoDTO> create(@RequestBody @Valid RegiaoCreateDTO dto) {
		return ResponseEntity.ok(service.create(dto));
	}

	@GetMapping
	public List<RegiaoDTO> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public RegiaoDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}