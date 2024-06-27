package ntpaulo.apicontrolefinanceiro.cliente;



public record ClienteResponseDTO(String id_cliente, String nome, Long contato) {

    public ClienteResponseDTO(Cliente cliente){
        this(cliente.getId_cliente(), cliente.getNome(), cliente.getContato());
    }
}
