package ntpaulo.apicontrolefinanceiro.produto;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name = "prudutos")
@Entity(name = "Produto")
@EqualsAndHashCode(of = "id_produto")

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id_produto;

    private String nome;

    private String categoria;
}
