package ntpaulo.apicontrolefinanceiro.fornecedor;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name = "fornecedores")
@Entity(name = "Fornecedor")
@EqualsAndHashCode(of = "id_fornecedor")

public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_fornecedor;

    private String nome;

    private String contato;
}
