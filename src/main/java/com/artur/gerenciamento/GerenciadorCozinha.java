package com.artur.gerenciamento;

import java.util.ArrayList;
import java.util.List;

import com.artur.controle.ItemPedido;

public class GerenciadorCozinha {

    private final List<ItemPedido> pedidosPendentes;
    private final List<ItemPedido> pedidosEmPreparacao;
    private final List<ItemPedido> pedidosProntos;

    public GerenciadorCozinha() {
        this.pedidosPendentes = new ArrayList<>();
        this.pedidosEmPreparacao = new ArrayList<>();
        this.pedidosProntos = new ArrayList<>();
    }

    public void preparar(ItemPedido novoPedido) {
        System.out.println("Pedido adicionado com sucesso!");
        marcarPedidoEmPendente(novoPedido);
        marcarPedidoComoPreparando(novoPedido);
        marcarPedidoComoPronto(novoPedido);
        System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " entregue.");
    }

    public void marcarPedidoEmPendente(ItemPedido novoPedido) {
        boolean pedidoExistente = false;

        for (ItemPedido i : pedidosPendentes) {
            // Verifica se o item já existe na lista e pertence ao mesmo cliente
            if (novoPedido.getIdItemCardapio() == i.getIdItemCardapio() && novoPedido.getIdCliente() == i.getIdCliente()) {
                i.setQuantidade(i.getQuantidade() + novoPedido.getQuantidade());
                pedidoExistente = true;
                break;
            }
        }

        if (!pedidoExistente) {
            pedidosPendentes.add(novoPedido);
            System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " foi adicionado a pendentes.");
        } else {
            System.out.println("Pedido ID: " + novoPedido.getId() + " atualizado na lista de pendentes.");
        }
    }

    public void marcarPedidoComoPreparando(ItemPedido novoPedido) {
        boolean pedidoExistente = false;

        for (ItemPedido pedido : pedidosEmPreparacao) {
            if (pedido.getIdItemCardapio() == novoPedido.getIdItemCardapio() && pedido.getIdCliente() == novoPedido.getIdCliente()) {
                pedido.setQuantidade(pedido.getQuantidade() + novoPedido.getQuantidade());
                pedidoExistente = true;
                break;
            }
        }

        if (!pedidoExistente) {
            ItemPedido pedidoPendente = null;
            for (ItemPedido pedido : pedidosPendentes) {
                if (pedido.getIdItemCardapio() == novoPedido.getIdItemCardapio() && pedido.getIdCliente() == novoPedido.getIdCliente()) {
                    pedidoPendente = pedido;
                    break;
                }
            }

            if (pedidoPendente != null) {
                pedidosPendentes.remove(pedidoPendente);
                pedidosEmPreparacao.add(novoPedido);
                System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " está em preparação.");
            } else {
                pedidosEmPreparacao.add(novoPedido);
                System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " adicionado diretamente a em preparação.");
            }
        } else {
            System.out.println("Pedido ID: " + novoPedido.getId() + " atualizado na lista de em preparação.");
        }
    }

    public void marcarPedidoComoPronto(ItemPedido novoPedido) {
        boolean pedidoExistente = false;

        for (ItemPedido pedido : pedidosProntos) {
            if (pedido.getIdItemCardapio() == novoPedido.getIdItemCardapio() && pedido.getIdCliente() == novoPedido.getIdCliente()) {
                pedido.setQuantidade(pedido.getQuantidade() + novoPedido.getQuantidade());
                pedidoExistente = true;
                break;
            }
        }

        if (!pedidoExistente) {
            ItemPedido pedidoEmPreparacao = null;
            for (ItemPedido pedido : pedidosEmPreparacao) {
                if (pedido.getIdItemCardapio() == novoPedido.getIdItemCardapio() && pedido.getIdCliente() == novoPedido.getIdCliente()) {
                    pedidoEmPreparacao = pedido;
                    break;
                }
            }

            if (pedidoEmPreparacao != null) {
                pedidosEmPreparacao.remove(pedidoEmPreparacao);
                pedidosProntos.add(novoPedido);
                System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " está pronto.");
            } else {
                pedidosProntos.add(novoPedido);
                System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " adicionado diretamente a prontos.");
            }
        } else {
            System.out.println("Pedido ID: " + novoPedido.getId() + " atualizado na lista de prontos.");
        }
    }

    public void mostrarPedidosPendentes() {
        System.out.println("Pedidos pendentes:");
        for (ItemPedido pedido : pedidosPendentes) {
            System.out.println("ID: " + pedido.getId() + " | Nome do pedido: " + pedido.getNomePedido() + " | Quantidade: " + pedido.getQuantidade() + " | Preco: " + pedido.getPrecoPedido() + " | ID e Cliente: " + pedido.getIdCliente() + " - " + pedido.getNomeCliente());
        }
    }

    public void mostrarPedidosEmPreparacao() {
        System.out.println("Pedidos em Preparação:");
        for (ItemPedido pedido : pedidosEmPreparacao) {
            System.out.println("ID: " + pedido.getId() + " | Nome do pedido: " + pedido.getNomePedido() + " | Quantidade: " + pedido.getQuantidade() + " | Preco: " + pedido.getPrecoPedido() + " | ID e Cliente: " + pedido.getIdCliente() + " - " + pedido.getNomeCliente());
        }
    }

    public void mostrarPedidosProntos() {
        System.out.println("Pedidos Prontos:");
        for (ItemPedido pedido : pedidosProntos) {
            System.out.println("ID: " + pedido.getId() + " | Nome do pedido: " + pedido.getNomePedido() + " | Quantidade: " + pedido.getQuantidade() + " | Preco: " + pedido.getPrecoPedido() + " | ID e Cliente: " + pedido.getIdCliente() + " - " + pedido.getNomeCliente());
        }
    }

    public List<ItemPedido> getPedidosPendentes() {
        return pedidosPendentes;
    }

    public List<ItemPedido> getPedidosEmPreparacao() {
        return pedidosEmPreparacao;
    }

    public List<ItemPedido> getPedidosProntos() {
        return pedidosProntos;
    }
}