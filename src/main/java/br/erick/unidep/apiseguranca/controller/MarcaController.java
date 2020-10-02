package br.erick.unidep.apiseguranca.controller;

import br.erick.unidep.apiseguranca.data.MarcaData;
import br.erick.unidep.apiseguranca.entities.Marca;
import br.erick.unidep.apiseguranca.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/marca")
public class MarcaController {

    @Autowired
    private MarcaData marcaData;
    @Autowired
    private MarcaService marcaService;

    @GetMapping("{id}")
    private Marca findById(@PathVariable("id") Long id) { return marcaData.findById(id).orElse(null); }

    @GetMapping
    private List<Marca> findAll() {
        return marcaData.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Marca save(@Valid @RequestBody Marca marca) {
        return marcaData.save(marca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@PathVariable("id") Long id, @Valid @RequestBody Marca marca) {
        Marca marcaSalva = marcaService.update(id, marca);
        return ResponseEntity.ok(marcaSalva);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@RequestParam("id") Long id) {
        marcaData.deleteById(id);
    }
}
