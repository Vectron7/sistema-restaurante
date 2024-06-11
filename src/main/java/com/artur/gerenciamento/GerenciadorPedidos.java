package com.artur.gerenciamento;

import com.artur.controle.ItemPedido;
import com.artur.interfaces.Listagem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        if (listaPedidos != null) {
            for (ItemPedido i : listaPedidos) {
                // Verifica se o item já existe na lista e pertence ao mesmo cliente
                if (item.getIdItemCardapio() == i.getIdItemCardapio() && item.getIdCliente() == i.getIdCliente()) {
                    i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                    itemExistente = true;
                    break;
                }
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

    public double precoTotal() {
        double total = 0;
        for (ItemPedido item : listaPedidos) {
            total += item.getQuantidade() * item.getPrecoPedido();
        }
        return total;
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

    public void cancelarPedido(Scanner sc) {
        GerenciadorCozinha cozinha = new GerenciadorCozinha();
        GerenciadorMenu menu = new GerenciadorMenu();
        boolean pedidoEncontrado = false;

        System.out.println("Digite o ID do pedido a ser cancelado:");
        int idPedido = menu.inserirInt(sc);

        for (ItemPedido p : listaPedidos) {
            if (p.getId() == idPedido) {
                listaPedidos.remove(p);
                pedidoEncontrado = true;
                break;
            }
        }

        if (pedidoEncontrado) {
            System.out.println("Pedidos: Pedido cancelado com sucesso.");
            pedidoEncontrado = false;
        } else {
            System.out.println("Pedidos: Pedido não encontrado.");
        }

        for (ItemPedido p : cozinha.getPedidosPendentes()) {
            if (p.getId() == idPedido) {
                cozinha.getPedidosPendentes().remove(p);
                pedidoEncontrado = true;
                break;
            }
        }

        if (pedidoEncontrado) {
            System.out.println("Pedido Pendente: Pedido cancelado com sucesso.");
            pedidoEncontrado = false;
        } else {
            System.out.println("Pedido Pendente: Pedido não encontrado.");
        }

        for (ItemPedido p : cozinha.getPedidosEmPreparacao()) {
            if (p.getId() == idPedido) {
                cozinha.getPedidosEmPreparacao().remove(p);
                pedidoEncontrado = true;
                break;
            }
        }

        if (pedidoEncontrado) {
            System.out.println("Pedido em Preparação: Pedido cancelado com sucesso.");
            pedidoEncontrado = false;
        } else {
            System.out.println("Pedido em Preparação: Pedido não encontrado.");
        }

        for (ItemPedido p : cozinha.getPedidosProntos()) {
            if (p.getId() == idPedido) {
                cozinha.getPedidosProntos().remove(p);
                pedidoEncontrado = true;
                break;
            }
        }

        if (pedidoEncontrado) {
            System.out.println("Pedido Pronto: Pedido cancelado com sucesso.");
        } else {
            System.out.println("Pedido Pronto: Pedido não encontrado.");
        }
    }

    public List<ItemPedido> getListaPedidos() {
        return listaPedidos;
    }
}
