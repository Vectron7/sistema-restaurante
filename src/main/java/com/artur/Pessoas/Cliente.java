package com.artur.Pessoas;

import java.util.ArrayList;

public class Cliente extends Pessoas {

    private String dataNasc;
    private int idCliente;
    private String telefone;
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    public Cliente(String nome, String endereco, String telefone, String dataNasc) {
        super(nome, endereco);
        this.dataNasc = dataNasc;
        this.telefone = telefone;
    }

    public void cadastrarCliente(Cliente cliente) {

        listaClientes.add(cliente);

    }

    public void listarClientes() {

        for (Cliente cliente : listaClientes) {
            System.out.println("ID: "+cliente.getIdCliente()+" | Nome: "+cliente.getNome()+" | Endereco: "+cliente.getEndereco()+" | Telefone: "+cliente.getTelefone()+" | Data de Nascimento: "+cliente.getDataNasc());
        }

    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    

}
