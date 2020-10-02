package br.erick.unidep.apiseguranca.services;

import br.erick.unidep.apiseguranca.data.ProdutoData;
import br.erick.unidep.apiseguranca.entities.Produto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoData produtoData;

    public Produto update(Long codigo, Produto produto) {
        Optional<Produto> produtoSalva = produtoData.findById(codigo);
        if (produtoSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(produto, produtoSalva.get(), "codigo");
        return produtoData.save(produtoSalva.get());
    }

}
