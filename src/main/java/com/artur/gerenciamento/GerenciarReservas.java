package com.artur.gerenciamento;

import java.util.ArrayList;

import com.artur.controle.Reserva;
import com.artur.interfaces.Listagem;
import com.artur.estabelecimento.Mesa;
import com.artur.pessoas.Garcom;


public class GerenciarReservas implements Listagem {

    private final ArrayList<Reserva> listaReservas;
    private int ultimoIdReserva = 1;

    public GerenciarReservas() {

        this.listaReservas = new ArrayList<>();
    }

    protected void adicionarReserva(Reserva reserva) {

        reserva.setIdReserva(this.ultimoIdReserva++);
        listaReservas.add(reserva);
    }

    protected void cancelarReserva(int canIdReserva, ArrayList<Mesa> listaMesas, ArrayList<Garcom> listaGarcom) {

        // Procurar pela reserva com o ID especificado
        Reserva reservaRemover = null;
        for (Reserva r : listaReservas) {
            if (r.getId() == canIdReserva) {
                reservaRemover = r;
                break;
            }
        }

        if (reservaRemover != null) {
            // Atualizar o status do garcom correspondente
            for (Garcom g : listaGarcom) {
                if (g.getId() == reservaRemover.getIdGarcom()) {
                    g.setOcupado(false);
                    break;
                }
            }
        }

        if (reservaRemover != null) {
            // Atualizar o status da mesa correspondente
            for (Mesa m : listaMesas) {
                if (m.getId() == reservaRemover.getNumMesa()) {
                    m.setStatusMesa(false);
                    break;
                }
            }

            // Remover a reserva da lista de reservas
            listaReservas.remove(reservaRemover);
            System.out.println("Reserva removida com sucesso.");

            // Atualizar os IDs das reservas restantes
            for (int j = 0; j < listaReservas.size(); j++) {
                listaReservas.get(j).setIdReserva(j + 1);
            }

            this.ultimoIdReserva = listaReservas.size() + 1;
        } else {
            System.out.println("Reserva não encontrada.");
        }
    }

    @Override
    public void listar() {

        for (Reserva reserva : listaReservas) {
            System.out.println("ID: " + reserva.getId() + " | Num. Mesa: " + reserva.getNumMesa() + " | Nome e ID do Gargom: "
                    + reserva.getIdGarcom() + " - " + reserva.getNomeGarcom() + " | Nome do Cliente: "
                    + reserva.getNomeCliente() + " | Telefone: " + reserva.getTelefoneCliente() + " | Data e Hora: "
                    + reserva.getDataReserva() + " - " + reserva.getHoraReserva());

        }

    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

}