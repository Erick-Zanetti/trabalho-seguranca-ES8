package br.erick.unidep.apiseguranca.services;

import br.erick.unidep.apiseguranca.data.ClienteData;
import br.erick.unidep.apiseguranca.entities.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteSerivce {

    @Autowired
    private ClienteData clienteData;

    public Cliente update(Long codigo, Cliente cliente) {
        Optional<Cliente> clienteSalva = clienteData.findById(codigo);
        if (clienteSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(cliente, clienteSalva.get(), "codigo");
        return clienteData.save(clienteSalva.get());
    }

}
