package com.aula_algaworks.algalog.api.controller;

import com.aula_algaworks.algalog.domain.model.Cliente;
import com.aula_algaworks.algalog.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@RestController
public class Cliente_Controller {

//    @PersistenceContext
//    private EntityManager manager;

//    Vamos injetar uma instancia..
        //@Autowired
        ClienteRepository clienteRepository;

//    Outra forma de injetar dependencias é através de constructor, pois permite realizar testes:
        public Cliente_Controller(ClienteRepository clienteRepository) {
        super();
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        // Aqui está herdando as funcionalidades do JpaRepository como findAll, getById.. etc
        // Podemos também criar nosso proprios métodos la no Repository

        return clienteRepository.findAll();

//      return manager.createNamedQuery("from cliente", Cliente.class).getResultList();
    }
}
//        Cliente cliente1 = new Cliente();
//        cliente1.setId(1L);
//        cliente1.setNome("Joao");
//        cliente1.setEmail("joaodacoves@hotmail");
//        cliente1.setTelefone("5565511545");
//
//        Cliente cliente2 = new Cliente();
//        cliente2.setId(1L);
//        cliente2.setNome("Joao");
//        cliente2.setEmail("joaodacoves@hotmail");
//        cliente2.setTelefone("5565511545");
//
//        // Agora que instaciamos, retornamos a lista de 2 clientes, retornada pelo método Listar:
//        return Arrays.asList(cliente1, cliente2);
