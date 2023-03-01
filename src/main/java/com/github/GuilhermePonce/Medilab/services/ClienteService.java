package com.github.GuilhermePonce.Medilab.services;

import com.github.GuilhermePonce.Medilab.model.Cliente;
import com.github.GuilhermePonce.Medilab.repositories.ClienteRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }

    public Cliente getCliente(Integer codigo) {
        return clienteRepository.findByCodigoAndActive(codigo,true).orElseThrow(RuntimeException::new);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updatete(Integer codigo, Cliente request) {
        Cliente fromDb = getCliente(codigo);
        fromDb.setNome(request.getNome());
        fromDb.setCep(request.getCep());
        fromDb.setCidade(fromDb.getCidade());
        fromDb.setTelefones(fromDb.getTelefones());
        fromDb.setBairro(fromDb.getBairro());
        fromDb.setPossuiFilhos(fromDb.isPossuiFilhos());
        fromDb.setTipoDocumento(fromDb.getTipoDocumento());

        return clienteRepository.save(fromDb);
    }

}
