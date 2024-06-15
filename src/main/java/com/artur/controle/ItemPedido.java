// Importação das classes necessárias do pacote com.artur
// Este pacote contém as implementações de controle, interfaces e definições de pessoas do sistema
package com.artur.controle;


// Importação da interface Identificacao do pacote com.artur.interfaces
// Esta interface é implementada pela classe ItemPedido para fornecer um método getId()
import com.artur.interfaces.Identificacao;
// Importação da classe Cliente do pacote com.artur.pessoas
// Esta classe é utilizada no construtor de ItemPedido para associar um cliente ao pedido
import com.artur.pessoas.Cliente;

// Declaração da classe ItemPedido que implementa a interface Identificacao
public class ItemPedido implements Identificacao {

    // Declaração dos atributos da classe
    private final String nomePedido;// Nome do pedido
    private final float precoPedido;// Preço do pedido 
    private int idPedido;// Identificador único do pedido
    private final int idItemCardapio;// Identificador do item do cardápio associado ao pedido
    private int quantidade;// Quantidade do pedido
    private final int idCliente;// Identificador do cliente associado ao pedido
    private final String nomeCliente;// Nome do cliente associado ao pedido

    
    // Construtor da classe
    public ItemPedido(int idPedido, String nomePedido, int quantidade, float precoPedido, Cliente cliente) {
        this.nomePedido = nomePedido;
        this.precoPedido = precoPedido;
        this.quantidade = quantidade;
        this.idItemCardapio = idPedido;
        this.idCliente = cliente.getId(); // Obtém o ID do cliente
        this.nomeCliente = cliente.getNome();// Obtém o nome do cliente
    }

     // Método getter para obter o nome do pedido
    public String getNomePedido() {
        return nomePedido;
    }

     // Implementação do método da interface Identificacao para obter o ID do item
    @Override
    public int getId() {
        return this.idPedido;
    }

    // Método setter para definir o ID do pedido
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    // Métodos getters e setters para obter e definir a quantidade do pedido
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

     // Métodos getters para obter o preço do pedido e o identificador do item do cardápio associado ao pedido
    public float getPrecoPedido() {
        return precoPedido;
    }

    public int getIdItemCardapio() {
        return idItemCardapio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
}
