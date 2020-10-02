package br.erick.unidep.apiseguranca.controller;

import br.erick.unidep.apiseguranca.data.ProdutoData;
import br.erick.unidep.apiseguranca.entities.Produto;
import br.erick.unidep.apiseguranca.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoData produtoData;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    private List<Produto> findAll() {
        return produtoData.findAll();
    }

    @GetMapping("{id}")
    private Produto findById(@PathVariable("id") Long id) {
        return produtoData.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Produto save(@Valid @RequestBody Produto produto) {
        return produtoData.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @Valid @RequestBody Produto produto) {
        Produto produtoSalva = produtoService.update(id, produto);
        return ResponseEntity.ok(produtoSalva);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@RequestParam("id") Long id) {
        produtoData.deleteById(id);
    }
}
