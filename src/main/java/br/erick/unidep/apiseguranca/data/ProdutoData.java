package br.erick.unidep.apiseguranca.data;

import br.erick.unidep.apiseguranca.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoData extends JpaRepository<Produto, Long> {
}
