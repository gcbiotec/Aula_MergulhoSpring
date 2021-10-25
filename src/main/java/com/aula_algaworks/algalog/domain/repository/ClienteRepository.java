package com.aula_algaworks.algalog.domain.repository;

import com.aula_algaworks.algalog.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Aqui vamos criar nosso proprio método de busca no banco, passando o nome:
        List<Cliente> findByNome(String nome);

    // Aqui vamos criar um método para buscar por letra, uma função do tipo 'LIKE':
        List<Cliente> findByNomeContaining(String nome);

        Optional<Cliente> findByEmail(String email);
}
