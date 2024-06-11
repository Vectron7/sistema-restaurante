package com.artur.controle;

import com.artur.interfaces.Identificacao;
import com.artur.pessoas.Cliente;

public class ItemPedido implements Identificacao {

    private final String nomePedido;
    private final float precoPedido;
    private int idPedido;
    private final int idItemCardapio;
    private int quantidade;
    private final int idCliente;
    private final String nomeCliente;

    public ItemPedido(int idPedido, String nomePedido, int quantidade, float precoPedido, Cliente cliente) {
        this.nomePedido = nomePedido;
        this.precoPedido = precoPedido;
        this.quantidade = quantidade;
        this.idItemCardapio = idPedido;
        this.idCliente = cliente.getId();
        this.nomeCliente = cliente.getNome();
    }

    public String getNomePedido() {
        return nomePedido;
    }

    @Override
    public int getId() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

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
