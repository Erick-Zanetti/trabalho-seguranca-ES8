package br.erick.unidep.apiseguranca.controller;

import br.erick.unidep.apiseguranca.data.ClienteData;
import br.erick.unidep.apiseguranca.entities.Cliente;
import br.erick.unidep.apiseguranca.services.ClienteSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteData clienteData;
    @Autowired
    private ClienteSerivce clienteService;

    @GetMapping
    private List<Cliente> findAll() {
        return clienteData.findAll();
    }

    @GetMapping("{id}")
    private Cliente findById(@PathVariable("id") Long id) {
        return clienteData.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Cliente save(@Valid @RequestBody Cliente cliente) {
        return clienteData.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente) {
        Cliente clienteSalva = clienteService.update(id, cliente);
        return ResponseEntity.ok(clienteSalva);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@RequestParam("id") Long id) {
        clienteData.deleteById(id);
    }
}
