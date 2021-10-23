package com.aula_algaworks.algalog.api.controller;

import com.aula_algaworks.algalog.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class Cliente_Controller {

    @GetMapping("/clientes")
    public List<Cliente> listar(){



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
//    }
}
