package org.serratec.backend.exercicio03.repository;

import org.serratec.backend.exercicio03.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Long>{
}
