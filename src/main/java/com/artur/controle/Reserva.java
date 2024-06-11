package com.artur.controle;

import com.artur.interfaces.Identificacao;
import com.artur.pessoas.Garcom;

public class Reserva implements Identificacao {

    private int idReserva;
    private int numMesa;
    private int idGarcom;
    private String nomeGarcom;
    private String telefoneCliente;
    private String nomeCliente;
    private String dataReserva;
    private String horaReserva;



    public Reserva(String dataReserva, String horaReserva, String nomeCliente, String telefoneCliente, int numMesa, Garcom g) {
        this.dataReserva = dataReserva;
        this.horaReserva = horaReserva;
        this.telefoneCliente = telefoneCliente;
        this.nomeCliente = nomeCliente;
        this.numMesa = numMesa;
        this.idGarcom = g.getId();
        this.nomeGarcom = g.getNome();

    }



    @Override
    public int getId() {
        return idReserva;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdGarcom() {
        return idGarcom;
    }

    public String getNomeGarcom() {
        return nomeGarcom;
    }

}