package com.artur.pessoas;

import com.artur.interfaces.Identificacao;

public class Cliente extends Pessoa implements Identificacao {

    private String dataNasc;
    private int idCliente;

    public Cliente(String nome, String endereco, String telefone, String dataNasc) {
        super(nome, endereco, telefone);
        this.dataNasc = dataNasc;
    }

    @Override
    public int getId() {
        return idCliente;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }





}