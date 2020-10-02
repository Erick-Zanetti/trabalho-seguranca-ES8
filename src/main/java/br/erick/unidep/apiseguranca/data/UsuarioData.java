package br.erick.unidep.apiseguranca.data;

import br.erick.unidep.apiseguranca.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioData extends JpaRepository<Usuario, Long> {
}
