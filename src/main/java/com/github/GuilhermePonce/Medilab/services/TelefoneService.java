package com.github.GuilhermePonce.Medilab.services;


import com.github.GuilhermePonce.Medilab.model.Cliente;
import com.github.GuilhermePonce.Medilab.model.Telefone;
import com.github.GuilhermePonce.Medilab.repositories.TelefoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TelefoneService {
    private final TelefoneRepository telefoneRepository;

    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }
    public Telefone getTelefone(Integer codigo) {

        return telefoneRepository.findByCodigoAndActive(codigo,true).orElseThrow(RuntimeException::new);
    }
    public Telefone createTelefone(Telefone telefone) {
        return telefoneRepository.save(telefone);

    }
    public Telefone updatete(Integer codigo, Telefone request) {
        Telefone fromDb = getTelefone(codigo);
        fromDb.setCodigo(request.getCodigo());
        fromDb.setCliente(request.getCliente());
        fromDb.setTelefone(fromDb.getTelefone());
        fromDb.setTipoTelefone(fromDb.getTipoTelefone());
        return telefoneRepository.save(fromDb);
    }


}