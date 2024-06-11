package com.artur.controle;

import com.artur.interfaces.Identificacao;

public class Mesa implements Identificacao {

    private int idMesa;
    private int capacidade;
    private boolean statusMesa;

    public Mesa(int capacidade) {
        this.capacidade = capacidade;
        this.statusMesa = false;
    }

    public boolean isStatusMesa() {
        return statusMesa;
    }

    public void reservar() {
        statusMesa = true;
    }

    public void liberar() {
        statusMesa = false;
    }

    @Override
    public int getId() {
        return idMesa;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setStatusMesa(boolean statusMesa) {
        this.statusMesa = statusMesa;
    }

}