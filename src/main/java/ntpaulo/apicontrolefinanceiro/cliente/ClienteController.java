package ntpaulo.apicontrolefinanceiro.cliente;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public void salvarCliente(@RequestBody ClienteCreateDTO data){
        Cliente clienteSalvo = new Cliente(data);
        clienteRepository.save(clienteSalvo);
    }

    @GetMapping
    public List<ClienteResponseDTO> listarClientes(){
        List<ClienteResponseDTO> clientes = clienteRepository.findAll().stream().map(ClienteResponseDTO::new).collect(Collectors.toList());
        return clientes;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> BuscarClienteById(@PathVariable(value = "id") String id){
        Cliente clienteAtualizado = clienteRepository.findById(id).orElseThrow();
        return ResponseEntity.ok().body(clienteAtualizado);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizarCliente(@PathVariable String id, @RequestBody ClienteUpdateDTO data){

        Optional<Cliente> optionalDoador = clienteRepository.findById(id);

        Cliente clienteAtualizado = optionalDoador.orElseThrow(() -> new EntityNotFoundException("Cliente não existe"));

        if(data.nome() != null){
            clienteAtualizado.setNome(data.nome());
        }
        if (data.contato() != null){
            clienteAtualizado.setContato(data.contato());
        }

        clienteRepository.save(clienteAtualizado);
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO(clienteAtualizado);
        return clienteResponseDTO;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerCliente(@PathVariable String id){
        try {
            Optional<Cliente> optionalCliente = clienteRepository.findById(id);
            Cliente cliente = optionalCliente.orElseThrow(() -> new EntityNotFoundException("Cliente não existe"));
            clienteRepository.delete(cliente);
            return ResponseEntity.ok("Cliente removido com sucesso");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

}
