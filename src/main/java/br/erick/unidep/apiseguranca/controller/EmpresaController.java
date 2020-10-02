package br.erick.unidep.apiseguranca.controller;

import br.erick.unidep.apiseguranca.data.EmpresaData;
import br.erick.unidep.apiseguranca.entities.Empresa;
import br.erick.unidep.apiseguranca.services.EmpresaSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaData empresaData;
    @Autowired
    private EmpresaSerivce empresaService;

    @GetMapping
    private List<Empresa> findAll() {
        return empresaData.findAll();
    }

    @GetMapping("{id}")
    private Empresa findById(@PathVariable("id") Long id) {
        return empresaData.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Empresa save(@Valid @RequestBody Empresa empresa) {
        return empresaData.save(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable("id") Long id, @Valid @RequestBody Empresa empresa) {
        Empresa empresaSalva = empresaService.update(id, empresa);
        return ResponseEntity.ok(empresaSalva);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@RequestParam("id") Long id) {
        empresaData.deleteById(id);
    }
}
