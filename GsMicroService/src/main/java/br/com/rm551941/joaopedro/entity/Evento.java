package br.com.rm551941.joaopedro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
	private String nome;

	@NotBlank(message = "Descrição é obrigatória")
	@Size(min = 2, max = 255, message = "Descrição deve ter entre 2 e 255 caracteres")
	private String descricao;

	@PastOrPresent(message = "A data não pode ser futura")
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "regiao_id", nullable = false)
	@NotNull(message = "Região é obrigatória")
	private Regiao regiao;

	public Evento(Long id, String nome, String descricao, LocalDate data, Regiao regiao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.regiao = regiao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	// Construtor default sem argumentos (necessário para JPA)
	public Evento() {
	}
}
