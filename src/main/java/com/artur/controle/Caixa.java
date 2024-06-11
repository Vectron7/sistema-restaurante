package com.artur.controle;

import com.artur.gerenciamento.GerenciadorCozinha;
import com.artur.gerenciamento.GerenciadorDePessoas;
import com.artur.gerenciamento.GerenciadorMenu;
import com.artur.interfaces.Listagem;
import com.artur.interfaces.MetodosPagamento;
import com.artur.pessoas.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Caixa implements MetodosPagamento, Listagem {

    private final List<ItemPedido> pedidosPagos;

    public Caixa(){
        this.pedidosPagos = new ArrayList<>();
    }

    public void listarPedidosParaPagar(Scanner sc, GerenciadorDePessoas pessoa, GerenciadorCozinha cozinha, int idCliente){
        GerenciadorMenu menu = new GerenciadorMenu();
        boolean checar = false;
        pessoa.listarCliente();

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

        List<ItemPedido> listaTemp = new ArrayList<>();

        for(ItemPedido p : cozinha.getPedidosProntos()){
            if(p.getIdCliente() == idCliente){
                listaTemp.add(p);
            }
        }

        double total = 0;
        System.out.println("========== SEU PEDIDO ==========");
        for (ItemPedido pedido : listaTemp) {
            System.out.println("ID: " + pedido.getId() + " | Nome: " + pedido.getNomePedido() + " | Quantidade: " + pedido.getQuantidade() + " | Preço: R$ " + pedido.getPrecoPedido() + " | Cliente ID e Nome: " + pedido.getIdCliente() + " - " + pedido.getNomeCliente());
            total += pedido.getPrecoPedido() * pedido.getQuantidade();
        }
        System.out.println("Total: R$ " + total);
        System.out.println("==========================");

    }

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