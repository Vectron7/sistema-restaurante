package com.artur.gerenciamento;

import com.artur.controle.ItemPedido;
import com.artur.interfaces.Listagem;

import java.util.*;

public class GerenciadorPedidos implements Listagem {

    private static int contadorPedidos = 0;
    private final Set<ItemPedido> listaPedidos;

    public GerenciadorPedidos() {
        Comparator<ItemPedido> comparator = Comparator
                .comparing(ItemPedido::getNomePedido)
                .thenComparing(ItemPedido::getIdCliente);

        listaPedidos = new TreeSet<>(comparator);
        GerenciadorCardapio gerenciarCardapio = new GerenciadorCardapio();
        gerenciarCardapio.gerarItems();
    }

    public void adicionarItem(ItemPedido item) {
        boolean itemExistente = false;
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
            return;
        }

        // Se o item não existir na lista para o mesmo cliente, adiciona um novo item
        contadorPedidos++;
        item.setIdPedido(contadorPedidos);
        listaPedidos.add(item);
        System.out.println(item.getId() + " - 4");
    }

    public void removerItem(int idItem) {
        ItemPedido itemRemovido = null;
        for (ItemPedido item : listaPedidos) {
            if (item.getId() == idItem) {
                itemRemovido = item;
                break;
            }
        }

        if (itemRemovido != null) {
            listaPedidos.remove(itemRemovido);
            contadorPedidos--;
            System.out.println("Item removido com sucesso.");
        }

        int novoId = 1;
        for (ItemPedido p : listaPedidos) {
            p.setIdPedido(novoId++);
        }
    }

    @Override
    public void listar() {
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

    public Set<ItemPedido> getListaPedidos() {
        return listaPedidos;
    }
}
