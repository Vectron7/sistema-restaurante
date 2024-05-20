package com.artur.Main;

import java.util.ArrayList;

public class Reservas{
    
    private int idReserva;
    private int numMesa;
    private String telefoneCliente;
    private String nomeCliente;
    private String dataReserva;
    private String horaReserva;
    

    public Reservas(String dataReserva, String horaReserva, String nomeCliente, String telefoneCliente, int numMesa) {
        this.dataReserva = dataReserva;
        this.horaReserva = horaReserva;
        this.telefoneCliente = telefoneCliente;
        this.nomeCliente = nomeCliente;
        this.numMesa = numMesa;

    }
    
    public void listarReservas(ArrayList<Reservas> listaReservas){
        
        for (Reservas reserva : listaReservas) {
            System.out.println("ID: " + reserva.getIdReserva() + " | Num. Mesa: "+numMesa+" | Nome: " + reserva.getNomeCliente() + " | Telefone: " + reserva.getTelefoneCliente() + " | Data e Hora: " + reserva.getDataReserva() + " " + reserva.getHoraReserva());

        }
        
    }

    public int getIdReserva() {
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

    


}