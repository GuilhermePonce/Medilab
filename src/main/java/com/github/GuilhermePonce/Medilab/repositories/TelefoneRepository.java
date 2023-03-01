package com.github.GuilhermePonce.Medilab.repositories;

import com.github.GuilhermePonce.Medilab.model.Cliente;
import com.github.GuilhermePonce.Medilab.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    List<Telefone> findAllByActiveOrderByCodigoDesc(boolean active);
    Optional<Telefone> findByCodigoAndActive(Integer codigo, boolean active);

}
