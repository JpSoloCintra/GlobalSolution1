package br.com.rm551941.joaopedro.service;

import br.com.rm551941.joaopedro.dto.EventoCreateDTO;
import br.com.rm551941.joaopedro.dto.EventoDTO;
import br.com.rm551941.joaopedro.entity.Evento;
import br.com.rm551941.joaopedro.entity.Regiao;
import br.com.rm551941.joaopedro.repository.EventoRepository;
import br.com.rm551941.joaopedro.repository.RegiaoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {
	
	private final EventoRepository eventoRepository;
	private final RegiaoRepository regiaoRepository;

	public EventoService(EventoRepository eventoRepository, RegiaoRepository regiaoRepository) {
		this.eventoRepository = eventoRepository;
		this.regiaoRepository = regiaoRepository;
	}

	public EventoDTO create(EventoCreateDTO dto) {
		Regiao regiao = regiaoRepository.findById(dto.getRegiaoId())
				.orElseThrow(() -> new RuntimeException("Região não encontrada"));

		Evento evento = new Evento();
		evento.setNome(dto.getNome());
		evento.setDescricao(dto.getDescricao());
		evento.setData(dto.getData());
		evento.setRegiao(regiao);

		return new EventoDTO(eventoRepository.save(evento));
	}

	public List<EventoDTO> findAll() {
		return eventoRepository.findAll().stream().map(EventoDTO::new).collect(Collectors.toList());
	}

	public EventoDTO findById(Long id) {
		Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
		return new EventoDTO(evento);
	}

	public EventoDTO update(Long id, EventoCreateDTO dto) {
		Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));

		Regiao regiao = regiaoRepository.findById(dto.getRegiaoId())
				.orElseThrow(() -> new RuntimeException("Região não encontrada"));

		evento.setNome(dto.getNome());
		evento.setDescricao(dto.getDescricao());
		evento.setData(dto.getData());
		evento.setRegiao(regiao);

		return new EventoDTO(eventoRepository.save(evento));
	}

	public void delete(Long id) {
		if (!eventoRepository.existsById(id)) {
			throw new RuntimeException("Evento não encontrado");
		}
		eventoRepository.deleteById(id);
	}
}
