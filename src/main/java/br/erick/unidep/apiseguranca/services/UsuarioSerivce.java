package br.erick.unidep.apiseguranca.services;

import br.erick.unidep.apiseguranca.data.UsuarioData;
import br.erick.unidep.apiseguranca.entities.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioSerivce {

    @Autowired
    private UsuarioData usuarioData;

    public Usuario update(Long codigo, Usuario usuario) {
        Optional<Usuario> usuarioSalva = usuarioData.findById(codigo);
        if (usuarioSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(usuario, usuarioSalva.get(), "codigo");
        return usuarioData.save(usuarioSalva.get());
    }

}
