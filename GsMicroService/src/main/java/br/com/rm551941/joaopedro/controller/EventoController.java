package br.com.rm551941.joaopedro.controller;

import br.com.rm551941.joaopedro.dto.EventoCreateDTO;
import br.com.rm551941.joaopedro.dto.EventoDTO;
import br.com.rm551941.joaopedro.service.EventoService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	private final EventoService service;

	public EventoController(EventoService service) {
		this.service = service;
	}

	// GET /eventos
	@GetMapping
	public ResponseEntity<List<EventoDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	// GET /eventos/{id}
	@GetMapping("/{id}")
	public ResponseEntity<EventoDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	// POST /eventos
	@PostMapping
	public ResponseEntity<EventoDTO> create(@RequestBody @Valid EventoCreateDTO dto) {
		EventoDTO created = service.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}

	// PUT /eventos/{id}
	@PutMapping("/{id}")
	public ResponseEntity<EventoDTO> update(@PathVariable Long id, @RequestBody @Valid EventoCreateDTO dto) {
		EventoDTO updated = service.update(id, dto);
		return ResponseEntity.ok(updated);
	}

	// DELETE /eventos/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
