package br.erick.unidep.apiseguranca.services;

import br.erick.unidep.apiseguranca.data.MarcaData;
import br.erick.unidep.apiseguranca.entities.Marca;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaData marcaData;

    public Marca update(Long codigo, Marca marca) {
        Optional<Marca> marcaSalva = marcaData.findById(codigo);
        if (marcaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(marca, marcaSalva.get(), "codigo");
        return marcaData.save(marcaSalva.get());
    }

}
