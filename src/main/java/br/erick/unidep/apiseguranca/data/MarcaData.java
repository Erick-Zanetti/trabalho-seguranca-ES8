package br.erick.unidep.apiseguranca.data;

import br.erick.unidep.apiseguranca.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaData extends JpaRepository<Marca, Long> {
}
