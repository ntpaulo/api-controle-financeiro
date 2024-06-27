package ntpaulo.apicontrolefinanceiro.cliente;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")  // Define o nome da tabela no banco de dados
@Entity(name = "Cliente")  // Define o nome da entidade
@EqualsAndHashCode(of = "id_cliente")  // Gera os métodos equals() e hashCode() baseados no campo id_cliente

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)  // Gera o valor do campo automaticamente com UUID
    private String id_cliente;  // Chave primária da entidade

    private String nome;  // Atributo para armazenar o nome do cliente

    private Long contato;  // Atributo para armazenar informações de contato do cliente

    public Cliente(ClienteCreateDTO data) {
        this.nome = data.nome();
        this.contato = data.contato();
    }

    // Getters e Setters são omitidos aqui por causa do Lombok

}

