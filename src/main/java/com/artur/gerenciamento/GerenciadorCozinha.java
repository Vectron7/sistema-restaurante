package com.artur.gerenciamento;
import java.util.ArrayList;
import java.util.List;

import com.artur.controle.Caixa;
import com.artur.controle.ItemPedido;
import com.artur.controle.Pagamento;

public class GerenciadorCozinha {

    private GerenciadorPedidos gerenciarPedidos;
    private final List<ItemPedido> pedidosPendentes;
    private final List<ItemPedido> pedidosEmPreparacao;
    private final List<ItemPedido> pedidosProntos;

    public GerenciadorCozinha() {
        this.gerenciarPedidos = new GerenciadorPedidos();
        this.pedidosPendentes = new ArrayList<>();
        this.pedidosEmPreparacao = new ArrayList<>();
        this.pedidosProntos = new ArrayList<>();
    }

    public void preparar(ItemPedido novoPedido){

        System.out.println("Pedido adicionado com sucesso!");
        adicionarPedidoEmPendente(novoPedido);
        marcarPedidoComoPreparando(novoPedido);
        marcarPedidoComoPronto(novoPedido);

        System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " entregue.");
    }

    public void adicionarPedidoEmPendente(ItemPedido novoPedido) {
        pedidosPendentes.add(novoPedido);
        System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " foi adicionado a pendentes.");
    }

    public void marcarPedidoComoPreparando(ItemPedido novoPedido) {
        if (pedidosPendentes.remove(novoPedido)) {
            pedidosEmPreparacao.add(novoPedido);
            System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " está em preparação.");
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void marcarPedidoComoPronto(ItemPedido novoPedido) {
        if (pedidosEmPreparacao.remove(novoPedido)) {
            pedidosProntos.add(novoPedido);
            System.out.println("Pedido ID: " + novoPedido.getId() + " - " + novoPedido.getNomePedido() + " está pronto.");
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void mostrarPedidosPendentes(){
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
