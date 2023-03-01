package com.github.GuilhermePonce.Medilab.repositories;

import com.github.GuilhermePonce.Medilab.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByActiveOrderByCodigo(boolean active);
    Optional<Cliente> findByCodigoAndActive(Integer codigo, boolean active);
}
