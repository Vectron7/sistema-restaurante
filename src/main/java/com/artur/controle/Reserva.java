package com.artur.controle;

import com.artur.gerenciamento.GerenciarPessoa;
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
    private final GerenciarPessoa pessoa;


    public Reserva(String dataReserva, String horaReserva, String nomeCliente, String telefoneCliente, int numMesa, GerenciarPessoa pessoa) {
        this.dataReserva = dataReserva;
        this.horaReserva = horaReserva;
        this.telefoneCliente = telefoneCliente;
        this.nomeCliente = nomeCliente;
        this.numMesa = numMesa;
        this.pessoa = pessoa;

        Garcom g = escolherGarcom();
        if (g != null) {
            this.idGarcom = g.getId();
            this.nomeGarcom = g.getNome();
        } else {
            System.out.println("Nao foi possivel reservar um garcom.");
        }
    }

    private Garcom escolherGarcom() {

        if (pessoa.getListaGarcom() == null || pessoa.getListaGarcom().isEmpty()) {
            System.out.println("A lista de garcons está vazia.");
            return null;
        }

        System.out.println("Total garcons: " + pessoa.getListaGarcom().size());
        for (Garcom g : pessoa.getListaGarcom()) {
            System.out.println("Garcom ID: " + g.getId() + ", Ocupado: " + g.isOcupado());
            if (!g.isOcupado()) {
                g.setOcupado(true);
                System.out.println("Garcom escolhido: ID " + g.getId());
                return g;
            }
        }

        System.out.println("Nao existe garcom disponivel");
        return null;

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