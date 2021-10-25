package com.aula_algaworks.algalog.api.controller;

import com.aula_algaworks.algalog.domain.model.Cliente;
import com.aula_algaworks.algalog.domain.repository.ClienteRepository;
import com.aula_algaworks.algalog.domain.service.CatalogoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class Cliente_Controller {

//    @PersistenceContext
//    private EntityManager manager;

//    Vamos injetar uma instancia..
        //@Autowired
        ClienteRepository clienteRepository;
        CatalogoClienteService catalogoClienteService;

//    Outra forma de injetar dependencias é através de constructor, pois permite realizar testes:
        public Cliente_Controller(ClienteRepository clienteRepository) {
        super();
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listar() {
        // Aqui está herdando as funcionalidades do JpaRepository como findAll, getById.. etc
        // Podemos também criar nosso proprios métodos lá no Repository

        return clienteRepository.findAll();
//      return manager.createNamedQuery("from cliente", Cliente.class).getResultList();
    }

    @GetMapping("/{clienteId}") // clienteId é path variable, precisamos fazer um binding abaixo:
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
           Optional<Cliente> cliente = clienteRepository.findById(clienteId);
            if (cliente.isPresent()) {
                return ResponseEntity.ok(cliente.get());
            }
                return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente){

//    return clienteRepository.save(cliente);
      return catalogoClienteService.salvar(cliente);
    }

    // Obs: O método POST precisa pegar o cliente, e depois passar as novas infos;
    // Por isso o retorno é uma ResponseEntity!
    @PutMapping("/{clienteId}")
    public ResponseEntity <Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente){
            if (!clienteRepository.existsById(clienteId)){
                return ResponseEntity.notFound().build();
            }
              cliente.setId(clienteId);
//            cliente = clienteRepository.save(cliente);
              cliente = catalogoClienteService.salvar(cliente);
              return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deletar(@PathVariable Long clienteId){
            if (!clienteRepository.existsById(clienteId)){
                return ResponseEntity.notFound().build();
            }
            //clienteRepository.deleteById(clienteId);
              catalogoClienteService.excluir(clienteId);
            return ResponseEntity.noContent().build();
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
