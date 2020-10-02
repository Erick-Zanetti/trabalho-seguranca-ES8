package br.erick.unidep.apiseguranca.services;

import br.erick.unidep.apiseguranca.data.EmpresaData;
import br.erick.unidep.apiseguranca.entities.Empresa;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaSerivce {

    @Autowired
    private EmpresaData empresaData;

    public Empresa update(Long codigo, Empresa empresa) {
        Optional<Empresa> empresaSalva = empresaData.findById(codigo);
        if (empresaSalva == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(empresa, empresaSalva.get(), "codigo");
        return empresaData.save(empresaSalva.get());
    }

}
