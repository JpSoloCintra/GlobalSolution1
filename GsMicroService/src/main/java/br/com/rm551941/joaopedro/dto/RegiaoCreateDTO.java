package br.com.rm551941.joaopedro.dto;

import jakarta.validation.constraints.NotBlank;

public class RegiaoCreateDTO {

	@NotBlank(message = "O nome da região é obrigatório")
	private String nome;

	public RegiaoCreateDTO() {
	}

	public RegiaoCreateDTO(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}