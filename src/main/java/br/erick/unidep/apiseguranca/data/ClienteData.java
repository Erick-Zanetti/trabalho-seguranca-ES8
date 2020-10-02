package br.erick.unidep.apiseguranca.data;

import br.erick.unidep.apiseguranca.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteData extends JpaRepository<Cliente, Long> {
}
