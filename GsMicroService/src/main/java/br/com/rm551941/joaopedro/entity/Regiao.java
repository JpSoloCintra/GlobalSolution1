package br.com.rm551941.joaopedro.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Regiao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome da região é obrigatório")
	@Size(min = 2, max = 50, message = "Nome da região deve ter entre 2 e 50 caracteres")
	private String nome;

	@OneToMany(mappedBy = "regiao")
	private List<Evento> eventos;

	public Regiao(Long id,
			@NotBlank(message = "Nome da região é obrigatório") @Size(min = 2, max = 50, message = "Nome da região deve ter entre 2 e 50 caracteres") String nome,
			List<Evento> eventos) {
		super();
		this.id = id;
		this.nome = nome;
		this.eventos = eventos;
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

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

}
