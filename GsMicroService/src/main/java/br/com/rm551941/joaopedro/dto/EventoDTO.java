package br.com.rm551941.joaopedro.dto;

import br.com.rm551941.joaopedro.entity.Evento;

import java.time.LocalDate;

public record EventoDTO(Long id, String nome, String descricao, LocalDate data, RegiaoDTO regiao) {

	public EventoDTO(Evento evento) {
		this(evento.getId(), evento.getNome(), evento.getDescricao(), evento.getData(),
				new RegiaoDTO(evento.getRegiao()));
	}
}
