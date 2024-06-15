package com.artur.gerenciamento; 
// Declaração do pacote

import com.artur.controle.ItemPedido; // Importação da classe ItemPedido
import com.artur.interfaces.Listagem; // Importação da interface Listagem


import java.util.*; // Importação das classes da biblioteca java.util

// Classe que gerencia os pedidos e implementa a interface Listagem
public class GerenciadorPedidos implements Listagem {

    private static int contadorPedidos = 0; // Variável estática para contar o número de pedidos
    private final Set<ItemPedido> listaPedidos; // Conjunto de pedidos (TreeSet para manter a ordem)


    // Construtor da classe
    public GerenciadorPedidos() {
 // Comparator para ordenar os pedidos primeiro pelo nome do pedido e depois pelo ID do cliente
        Comparator<ItemPedido> comparator = Comparator
                .comparing(ItemPedido::getNomePedido)
                .thenComparing(ItemPedido::getIdCliente);

        listaPedidos = new TreeSet<>(comparator); // Inicializa o conjunto de pedidos com o comparator
        GerenciadorCardapio gerenciarCardapio = new GerenciadorCardapio(); // Cria uma instância de GerenciadorCardapio
        gerenciarCardapio.gerarItems(); // Gera itens do cardápio 
    }

    // Método para adicionar um item ao pedido
    public void adicionarItem(ItemPedido item) {
        boolean itemExistente = false; // Flag para verificar se o item já existe na lista
        System.out.println(item.getId() + " - 1");

        for (ItemPedido i : listaPedidos) {
            // Verifica se o item já existe na lista e pertence ao mesmo cliente
            if (item.getIdItemCardapio() == i.getIdItemCardapio() && item.getIdCliente() == i.getIdCliente()) {
                System.out.println(item.getId() + " - 000");
                System.out.println(i.getId() + " - 2");
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                System.out.println(i.getId() + " - 3");
                itemExistente = true;
                break;
            }
        }


        if (itemExistente) {
            return; // Se o item já existe, sai do método
        }

        // Se o item não existir na lista para o mesmo cliente, adiciona um novo item
        contadorPedidos++;
        item.setIdPedido(contadorPedidos); // Define o ID do pedido
        listaPedidos.add(item); // Adiciona o item à lista
        System.out.println(item.getId() + " - 4");
    }

    // Método para remover um item do pedido
    public void removerItem(int idItem) {
        ItemPedido itemRemovido = null; // Variável para armazenar o item a ser removido
        for (ItemPedido item : listaPedidos) {
            if (item.getId() == idItem) {
                itemRemovido = item; // Encontra o item a ser removido
                break;
            }
        }

        if (itemRemovido != null) {
            listaPedidos.remove(itemRemovido); // Remove o item da lista
            contadorPedidos--;  // Decrementa o contador de pedidos
            System.out.println("Item removido com sucesso.");
        }

         // Atualiza os IDs dos pedidos restantes
        int novoId = 1;
        for (ItemPedido p : listaPedidos) {
            p.setIdPedido(novoId++);
        }
    }

    @Override
   
    public void listar() {
         // Lista todos os pedidos
        if (listaPedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado.");
        } else {
            for (ItemPedido pedido : listaPedidos) {
                System.out.println("ID: " + pedido.getId() + " | Nome do pedido: " + pedido.getNomePedido() +
                        " | Quantidade: " + pedido.getQuantidade() + " | Preco: " + pedido.getPrecoPedido() +
                        " | ID e Cliente: " + pedido.getIdCliente() + " - " + pedido.getNomeCliente());
            }
        }
    }
    
    // Método para obter a lista de pedidos
    public Set<ItemPedido> getListaPedidos() {
        return listaPedidos;
    }
}
