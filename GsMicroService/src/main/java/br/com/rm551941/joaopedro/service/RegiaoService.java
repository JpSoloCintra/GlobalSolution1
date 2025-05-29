package br.com.rm551941.joaopedro.service;

import br.com.rm551941.joaopedro.dto.RegiaoDTO;
import br.com.rm551941.joaopedro.dto.RegiaoCreateDTO;
import br.com.rm551941.joaopedro.entity.Regiao;
import br.com.rm551941.joaopedro.repository.RegiaoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegiaoService {

	private final RegiaoRepository repository;

	public RegiaoService(RegiaoRepository repository) {
		this.repository = repository;
	}

	public RegiaoDTO create(RegiaoCreateDTO dto) {
		Regiao regiao = new Regiao(null, null, null);
		regiao.setNome(dto.getNome());
		return new RegiaoDTO(repository.save(regiao));
	}

	public List<RegiaoDTO> findAll() {
		return repository.findAll().stream().map(RegiaoDTO::new).collect(Collectors.toList());
	}

	public RegiaoDTO findById(Long id) {
		Regiao regiao = repository.findById(id).orElseThrow(() -> new RuntimeException("Região não encontrada"));
		return new RegiaoDTO(regiao);
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("Região não encontrada");
		}
		repository.deleteById(id);
	}
}