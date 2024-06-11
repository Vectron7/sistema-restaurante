package com.artur.gerenciamento;

import com.artur.controle.ItemPedido;
import com.artur.interfaces.Listagem;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedidos implements Listagem {

    private int contadorPedidos = 1;
    private final List<ItemPedido> listaPedidos;

    public GerenciadorPedidos() {
        listaPedidos = new ArrayList<>();
        GerenciadorCardapio gerenciarCardapio = new GerenciadorCardapio();
        gerenciarCardapio.gerarItems();
    }

    public void adicionarItem(ItemPedido item) {
        boolean itemExistente = false;


        for (ItemPedido i : listaPedidos) {
            // Verifica se o item já existe na lista e pertence ao mesmo cliente
            if (item.getIdItemCardapio() == i.getIdItemCardapio() && item.getIdCliente() == i.getIdCliente()) {
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                itemExistente = true;
                break;
            }
        }


        if (itemExistente) {
            return;
        }

        // Se o item não existir na lista para o mesmo cliente, adiciona um novo item
        item.setIdPedido(contadorPedidos++);
        listaPedidos.add(item);
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

    public List<ItemPedido> getListaPedidos() {
        return listaPedidos;
    }
}
