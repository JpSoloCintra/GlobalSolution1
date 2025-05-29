package br.com.rm551941.joaopedro.dto;

import br.com.rm551941.joaopedro.entity.Regiao;

public record RegiaoDTO(Long id, String nome) {
	public RegiaoDTO(Regiao regiao) {
		this(regiao.getId(), regiao.getNome());
	}
}
