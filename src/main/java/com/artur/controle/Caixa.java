//aqui está definindo o pacote ao qual a classe 'caixa' pertence. 
package com.artur.controle;

// Importa a classe GerenciadorCozinha do pacote com.artur.gerenciamento
import com.artur.gerenciamento.GerenciadorCozinha;
// Importa a classe GerenciadorDePessoas do pacote com.artur.gerenciamento
import com.artur.gerenciamento.GerenciadorDePessoas;
// Importa a interface Listagem do pacote com.artur.interfaces
import com.artur.interfaces.Listagem;
// Importa a interface MetodosPagamento do pacote com.artur.interfaces
import com.artur.interfaces.MetodosPagamento;
// Importa a classe Cliente do pacote com.artur.pessoas
import com.artur.pessoas.Cliente;

// Importa a classe ArrayList do pacote java.util
import java.util.ArrayList;
// Importa a classe List do pacote java.util
import java.util.List;
// Importa a classe Scanner do pacote java.util
import java.util.Scanner;

public abstract class Caixa implements MetodosPagamento, Listagem {
    
   // Esta é a lista para armazenar os pedidos pagos
    private final List<ItemPedido> pedidosPagos;
    
   // Construtor da classe Caixa
    public Caixa(){
        this.pedidosPagos = new ArrayList<>();
    }
    
   // Método para listar os pedidos de um cliente para pagar
    public void listarPedidosParaPagar(GerenciadorDePessoas pessoa, GerenciadorCozinha cozinha, int idCliente){
        boolean checar = false;
        pessoa.listarCliente(); // Método para listar os clientes
        
      // Aqui vamos verificar se o ID do cliente fornecido é válido
        for (Cliente id : pessoa.getListaClientes()) {
            if (id.getId() == idCliente) {
                checar = true;
                break;
            }
        }

        if (!checar) {
            System.out.println("ID DE CLIENTE INVALIDO.");
            return;
        }
        
       // Lista temporária para armazenar os pedidos do cliente
        List<ItemPedido> listaTemp = new ArrayList<>();

        // Este Filtra os pedidos prontos da cozinha para enviar ao cliente
        for(ItemPedido p : cozinha.getPedidosProntos()){
            if(p.getIdCliente() == idCliente){
                listaTemp.add(p);
            }
        }

        double total = 0;
        System.out.println("========== SEU PEDIDO ==========");
        // Exibe os detalhes dos pedidos do cliente
        for (ItemPedido pedido : listaTemp) {
            System.out.println("ID: " + pedido.getId() + " | Nome: " + pedido.getNomePedido() + " | Quantidade: " + pedido.getQuantidade() + " | Preço: R$ " + pedido.getPrecoPedido() + " | Cliente ID e Nome: " + pedido.getIdCliente() + " - " + pedido.getNomeCliente());
            total += pedido.getPrecoPedido() * pedido.getQuantidade();
        }
        System.out.println("Total: R$ " + total);
        System.out.println("==========================");

    }

    // Método para listar os pedidos pagos
    public void listar(){
        for(ItemPedido p : pedidosPagos){
            System.out.println("ID: " + p.getId() + " | Nome: " + p.getNomePedido() + " | Quantidade: " + p.getQuantidade() + " | Preço: R$ " + p.getPrecoPedido() + " | Cliente ID e Nome: " + p.getIdCliente() + " - " + p.getNomeCliente());

        }
    }

    public List<ItemPedido> getPedidosPagos() {
        return pedidosPagos;
    }

    public abstract void fazerPagamento(Scanner sc);
}
