package com.artur.Estabelecimento;

public class Mesa{

    private int numero;
    private int capacidade;
    private boolean statusMesa;
    

    public Mesa(int capacidade, int numero) {
        this.capacidade = capacidade;
        this.numero = numero;
        this.statusMesa = false;
    }

    public boolean isStatusMesa() {
        return statusMesa;
    }

    public void reservar(){
        statusMesa = true;
    }
    
    public void liberar(){
        statusMesa = false;        
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setStatusMesa(boolean statusMesa) {
        this.statusMesa = statusMesa;
    }
    
    
    


}