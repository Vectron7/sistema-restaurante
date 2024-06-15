package com.artur.controle;

import com.artur.interfaces.Identificacao; // Importação da interface Identificacao
import com.artur.pessoas.Garcom; // Importação da classe Garcom

// Declaração da classe Reserva que implementa a interface Identificacao
public class Reserva implements Identificacao {

     // Declaração dos atributos da classe
    private int idReserva;// Identificador único da reserva
    private int numMesa; // Número da mesa reservada
    private final int idGarcom; // Identificador do garçom associado à reserva
    private final int idCliente; // Identificador do cliente que fez a reserva
    private final String nomeGarcom; // Nome do garçom associado à reserva
    private String telefoneCliente; // Telefone do cliente
    private String nomeCliente; // Nome do cliente
    private String dataReserva; // Data da reserva
    private String horaReserva; // Hora da reserva



    // Construtor da classe
    public Reserva(String dataReserva, String horaReserva, String nomeCliente, String telefoneCliente, int numMesa, Garcom g, int idCliente) {
        this.dataReserva = dataReserva; // Define a data da reserva
        this.horaReserva = horaReserva; // Define a hora da reserva
        this.telefoneCliente = telefoneCliente; // Define o telefone do cliente
        this.nomeCliente = nomeCliente; // Define o nome do cliente
        this.numMesa = numMesa; // Define o número da mesa 
        this.idGarcom = g.getId(); // Obtém o ID do garçom 
        this.nomeGarcom = g.getNome(); // Obtém o nome do garçom
        this.idCliente = idCliente; // Define o ID do cliente
    }



    // Implementação do método da interface Identificacao para obter o ID da reserva
    @Override
    public int getId() {
        return idReserva;
    }

    // Métodos getters para obter os atributos da classe
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

    public int getIdGarcom() {
        return idGarcom;
    }

    public String getNomeGarcom() {
        return nomeGarcom;
    }

    public int getIdCliente() {
        return idCliente;
    }

    
    // Métodos setters para modificar os atributos da classe
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
