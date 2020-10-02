package br.erick.unidep.apiseguranca.controller;

import br.erick.unidep.apiseguranca.data.UsuarioData;
import br.erick.unidep.apiseguranca.entities.Usuario;
import br.erick.unidep.apiseguranca.services.UsuarioSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioData usuarioData;
    @Autowired
    private UsuarioSerivce usuarioService;

    @GetMapping
    private List<Usuario> findAll() {
        return usuarioData.findAll();
    }

    @GetMapping("{id}")
    private Usuario findById(@PathVariable("id") Long id) {
        return usuarioData.findById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Usuario save(@RequestBody Usuario usuario) {
        return usuarioData.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalva = usuarioService.update(id, usuario);
        return ResponseEntity.ok(usuarioSalva);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@RequestParam("id") Long id) {
        usuarioData.deleteById(id);
    }
}
