package br.com.rm551941.joaopedro.repository;

import br.com.rm551941.joaopedro.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
