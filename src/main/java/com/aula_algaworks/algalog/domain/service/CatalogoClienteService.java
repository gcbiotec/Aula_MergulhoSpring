package com.aula_algaworks.algalog.domain.service;

import com.aula_algaworks.algalog.domain.model.Cliente;
import com.aula_algaworks.algalog.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogoClienteService {
        @Autowired
        ClienteRepository clienteRepository;

        @Transactional
        public Cliente salvar(Cliente cliente) {
            return clienteRepository.save(cliente);
    }
        @Transactional
        public void excluir(Long clienteId) {
            clienteRepository.deleteById(clienteId);
        }
}
