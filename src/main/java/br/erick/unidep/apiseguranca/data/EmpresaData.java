package br.erick.unidep.apiseguranca.data;

import br.erick.unidep.apiseguranca.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaData extends JpaRepository<Empresa, Long> {
}
