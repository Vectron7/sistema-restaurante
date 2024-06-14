package com.artur.gerenciamento;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.artur.controle.ItemPedido;

public class GerenciadorCozinha {

    private final Set<ItemPedido> pedidosPendentes;
    private final Set<ItemPedido> pedidosEmPreparacao;
    private final Set<ItemPedido> pedidosProntos;

    public GerenciadorCozinha() {
        Comparator<ItemPedido> comparator = Comparator
                .comparing(ItemPedido::getNomePedido)
                .thenComparing(ItemPedido::getIdCliente);

        this.pedidosPendentes = new TreeSet<>(comparator);
        this.pedidosEmPreparacao = new TreeSet<>(comparator);
        this.pedidosProntos = new TreeSet<>(comparator);
    }

    public static void loadingAnimation(long durationInMillis) {
        try {
            long startTime = System.currentTimeMillis();

            while (System.currentTimeMillis() - startTime < durationInMillis) {
                System.out.print("\rPreparando.  ");
                Thread.sleep(500);
                System.out.print("\rPreparando.. ");
                Thread.sleep(500);
                System.out.print("\rPreparando...");
                Thread.sleep(500);
            }
            System.out.print("\r                "); // Limpa a linha após a animação
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void preparar(ItemPedido novoPedido) {
        System.out.println("Pedido adicionado com sucesso!");

        loadingAnimation(2000);
        marcarPedidoEmPendente(novoPedido);
        loadingAnimation(2000);
        marcarPedidoComoPreparando(novoPedido);
        loadingAnimation(2000);
        marcarPedidoComoPronto(novoPedido);
        loadingAnimation(2000);
        System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " entregue.");
    }

    public void marcarPedidoEmPendente(ItemPedido novoPedido) {
        if (!atualizarQuantidadeSeExistente(novoPedido, pedidosPendentes)) {
            pedidosPendentes.add(novoPedido);
            System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " foi adicionado a pendentes.");
        } else {
            System.out.println("Pedido ID: " + novoPedido.getId() + " atualizado na lista de pendentes.");
        }
    }

    public void marcarPedidoComoPreparando(ItemPedido novoPedido) {
        if (!atualizarQuantidadeSeExistente(novoPedido, pedidosEmPreparacao)) {
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
        if (!atualizarQuantidadeSeExistente(novoPedido, pedidosProntos)) {
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

    private boolean atualizarQuantidadeSeExistente(ItemPedido novoPedido, Set<ItemPedido> pedidos) {
        for (ItemPedido pedido : pedidos) {
            if (pedido.getNomePedido().equals(novoPedido.getNomePedido()) && pedido.getIdCliente() == novoPedido.getIdCliente()) {
                pedido.setQuantidade(pedido.getQuantidade() + novoPedido.getQuantidade());
                return true;
            }
        }
        return false;
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

    public Set<ItemPedido> getPedidosPendentes() {
        return pedidosPendentes;
    }

    public Set<ItemPedido> getPedidosEmPreparacao() {
        return pedidosEmPreparacao;
    }

    public Set<ItemPedido> getPedidosProntos() {
        return pedidosProntos;
    }
}
